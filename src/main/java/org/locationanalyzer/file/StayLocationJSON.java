package org.locationanalyzer.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.locationanalyzer.patterns.entities.StayLocation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class StayLocationJSON {

	public void generateJsonFile(ArrayList<StayLocation> stayLocations, String jsonDestFile) throws JsonProcessingException, FileNotFoundException
	{
		ObjectMapper mapper=new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String stayPointFile = ow.writeValueAsString(stayLocations);
		PrintWriter out = new PrintWriter(jsonDestFile);
		out.print(stayPointFile);
		out.close();
	}

}
