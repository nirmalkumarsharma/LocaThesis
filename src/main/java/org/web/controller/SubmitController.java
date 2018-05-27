package org.web.controller;

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
import org.locationanalyzer.file.StayLocationJSON;
import org.locationanalyzer.file.StayPointJSON;
import org.locationanalyzer.file.StayPointKML;
import org.locationanalyzer.patterns.entities.StayLocation;
import org.locationanalyzer.patterns.temporal.PatternAnalyzer;
import org.locationanalyzer.user.User;
import org.locationanalyzer.user.UserService;
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
	
	ArrayList<User> users;
	
	@RequestMapping("/submit")
	public String submit(Model model) throws IOException
	{
		String inputDirectory=System.getProperty("user.home")+File.separator+"Applications"+File.separator+"LocaThesis"+File.separator+"Input"+File.separator;
		
		File inputDirectoryFolder=new File(inputDirectory);
		if(!inputDirectoryFolder.exists())
		{
			inputDirectoryFolder.mkdirs();
		}
		
		MultipartFile[] files = fileFetcher.getFiles();
		ArrayList<File> receivedFiles=new ArrayList<File>();
		ArrayList<String> receivedFilesName=new ArrayList<String>();

		for (MultipartFile multipartFile : files)
		{
			File jsonFile=convertFile(multipartFile,inputDirectory);
			receivedFiles.add(jsonFile);
			receivedFilesName.add(FilenameUtils.getBaseName(jsonFile.toString()));
		}
		model.addAttribute("files", receivedFilesName);
		
		users=new ArrayList<User>();
		
		String jsonDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"JSON"+File.separator;
		String clJsonDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"CLJSON"+File.separator;
		String spKmlDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"SPKML"+File.separator;
		String clKmlDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"CLKML"+File.separator;
		String patternJsonDestPath=inputDirectory+File.separator+".."+File.separator+"Output"+File.separator+"PJSON"+File.separator;
		
		StayPointCalc stayPointDetection=new StayPointCalc();
		StayPointClustering stayPointClustering=new StayPointClustering();
		ClusterPoint clusterPoint=new ClusterPoint();
		PatternAnalyzer patternAnalyzer=new PatternAnalyzer();
		UserService userService=new UserService();
		
		File jsonFolder=new File(jsonDestPath);
		File spKmlFolder=new File(spKmlDestPath);
		File clKmlFolder=new File(clKmlDestPath);
		File clJsonFolder=new File(clJsonDestPath);
		File ptJsonFolder=new File(patternJsonDestPath);
		
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
		if(!ptJsonFolder.exists())
		{
			ptJsonFolder.mkdirs();
		}
		
		for (File file : receivedFiles)
		{
			String sorceJsonPath=file.getAbsolutePath();
			TreeSet<StayPoint> stayPoints = stayPointDetection.detectStayPoint(sorceJsonPath);
			ArrayList<StayPoint> apparentStayPoint=stayPointClustering.clustering(stayPoints);
			ArrayList<StayPointCluster> stayPointClusters = clusterPoint.addToClusters(apparentStayPoint,stayPoints); /*Returns Aggregated Points with Duration and all the stay points lies inside specified cluster*/
			ArrayList<StayLocation> dayTimePattern = patternAnalyzer.dayTimePattern(stayPointClusters);
			
			StayPointJSON jsonGenerator=new StayPointJSON();
			StayPointKML kmlGenerator = new StayPointKML();
			ClusterPointsJSON clJsonGenerator = new ClusterPointsJSON();
			StayLocationJSON slJsonGenerator=new StayLocationJSON();
			
			String jsonDestFile=jsonDestPath+FilenameUtils.getBaseName(file.toString())+"-sp.json";
			String spKmlDestFile=spKmlDestPath+FilenameUtils.getBaseName(file.toString())+"-sp.kml";
			String clKmlDestFile=clKmlDestPath+FilenameUtils.getBaseName(file.toString())+"-cl.kml";
			String clJsonFile=clJsonDestPath+FilenameUtils.getBaseName(file.toString())+"-cl.json";
			String plJsonFile=patternJsonDestPath+FilenameUtils.getBaseName(file.toString())+"-sl.json";
			
			jsonGenerator.generateJsonFile(stayPoints,jsonDestFile);
			kmlGenerator.generateKmlFile(stayPoints,spKmlDestFile);
			kmlGenerator.generateKmlFile(apparentStayPoint, clKmlDestFile);
			clJsonGenerator.generateJsonFile(stayPointClusters, clJsonFile);
			slJsonGenerator.generateJsonFile(dayTimePattern, plJsonFile);

			User user=new User();
			user.setUsername(FilenameUtils.getBaseName(file.toString()));
			user.setTotal(userService.sortByTotal(dayTimePattern));
			user.setMorning(userService.sortByMorning(dayTimePattern));
			user.setEvening(userService.sortByEvening(dayTimePattern));
			user.setNight(userService.sortByNight(dayTimePattern));
			user.setWeekdays(userService.sortByWeekday(dayTimePattern));
			user.setWeekend(userService.sortByWeekend(dayTimePattern));
			users.add(user);
		}
		
		System.out.println("JSON Files at : "+jsonFolder.getAbsolutePath());
		System.out.println("StayPoint-KML Files at : "+spKmlFolder.getAbsolutePath());
		System.out.println("Clustered StayPoint-KML Files at : "+clKmlFolder.getAbsolutePath());
		System.out.println("Clustered StayPoint-JSON Files at : "+clJsonFolder.getAbsolutePath());
		System.out.println("Pattern-JSON Files at : "+ptJsonFolder.getAbsolutePath());
		
		return "submit";
	}
	
	public ArrayList<User> getUsersData()
	{
		return users;
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
