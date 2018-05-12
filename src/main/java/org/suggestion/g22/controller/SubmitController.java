package org.suggestion.g22.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

import org.apache.commons.io.FilenameUtils;
import org.locationanalyzer.calc.StayPointCalc;
import org.locationanalyzer.clustering.ClusterPoint;
import org.locationanalyzer.clustering.StayPointCluster;
import org.locationanalyzer.clustering.StayPointClustering;
import org.locationanalyzer.entities.json.out.StayPoint;
import org.locationanalyzer.file.ClusterPointsJSON;
import org.locationanalyzer.file.StayPointJSON;
import org.locationanalyzer.file.StayPointKML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SubmitController
{
	@Autowired
	ReceivedFileController fileFetcher;
	
	@RequestMapping("/submit")
	public String submit(Model model) throws IOException
	{
		String inputDirectory="/home/nirmal/Documents/Final-Year-Project/Input/";
		
		MultipartFile[] files = fileFetcher.getFiles();
		ArrayList<File> receivedFiles=new ArrayList<File>();

		for (MultipartFile multipartFile : files)
		{
			receivedFiles.add(convertFile(multipartFile,inputDirectory));
		}
		model.addAttribute("files", files);
		
		String jsonDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"JSON"+File.separator;
		String clJsonDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"CLJSON"+File.separator;
		String spKmlDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"SPKML"+File.separator;
		String clKmlDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"CLKML"+File.separator;
		
		StayPointCalc stayPointDetection=new StayPointCalc();
		StayPointClustering stayPointClustering=new StayPointClustering();
		ClusterPoint clusterPoint=new ClusterPoint();
		
		File jsonFolder=new File(jsonDestPath);
		File spKmlFolder=new File(spKmlDestPath);
		File clKmlFolder=new File(clKmlDestPath);
		File clJsonFolder=new File(clJsonDestPath);
		
		if(!jsonFolder.exists())
		{
			jsonFolder.mkdirs();
		}
		if(!spKmlFolder.exists())
		{
			spKmlFolder.mkdirs();
		}
		if(!clKmlFolder.exists())
		{
			clKmlFolder.mkdirs();
		}
		if(!clJsonFolder.exists())
		{
			clJsonFolder.mkdirs();
		}
		
		for (File file : receivedFiles)
		{
			String sorceJsonPath=file.getAbsolutePath();
			TreeSet<StayPoint> stayPoints = stayPointDetection.detectStayPoint(sorceJsonPath);
			ArrayList<StayPoint> apparentStayPoint=stayPointClustering.clustering(stayPoints);
			ArrayList<StayPointCluster> clusters = clusterPoint.addToClusters(apparentStayPoint,stayPoints); /*Returns Aggregated Points with Duration and all the stay points lies inside specified cluster*/
			
			
			StayPointJSON jsonGenerator=new StayPointJSON();
			StayPointKML kmlGenerator = new StayPointKML();
			ClusterPointsJSON clJsonGenerator = new ClusterPointsJSON();
			
			String jsonDestFile=jsonDestPath+FilenameUtils.getBaseName(file.toString())+"-sp.json";
			String spKmlDestFile=spKmlDestPath+FilenameUtils.getBaseName(file.toString())+"-sp.kml";
			String clKmlDestFile=clKmlDestPath+FilenameUtils.getBaseName(file.toString())+"-cl.kml";
			String clJsonFile=clJsonDestPath+FilenameUtils.getBaseName(file.toString())+"-cl.json";
			
			jsonGenerator.generateJsonFile(stayPoints,jsonDestFile);
			kmlGenerator.generateKmlFile(stayPoints,spKmlDestFile);
			kmlGenerator.generateKmlFile(apparentStayPoint, clKmlDestFile);
			clJsonGenerator.generateJsonFile(clusters, clJsonFile);
		}
		
		System.out.println("JSON Files at : "+jsonFolder.getAbsolutePath());
		System.out.println("StayPoint-KML Files at : "+spKmlFolder.getAbsolutePath());
		System.out.println("Clustered StayPoint-KML Files at : "+clKmlFolder.getAbsolutePath());
		System.out.println("Clustered StayPoint-JSON Files at : "+clJsonFolder.getAbsolutePath());
		
		return "submit";
	}
	
	private static File convertFile(MultipartFile file ,String inputDirectory) throws IOException
	{
	    File convFile = new File(inputDirectory+file.getOriginalFilename());
	    convFile.createNewFile();
	    FileOutputStream fos = new FileOutputStream(convFile);
	    fos.write(file.getBytes());
	    fos.close();
	    return convFile;
	}
}