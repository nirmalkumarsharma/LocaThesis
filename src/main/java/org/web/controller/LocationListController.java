package org.web.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.location.entities.FullAddress;
import org.locationanalyzer.entities.json.in.LocationAddress;
import org.locationanalyzer.patterns.entities.StayLocation;
import org.locationanalyzer.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class LocationListController
{
	@Autowired
	private SubmitController submitController;
	
	@RequestMapping("/user/locations/{username}")
	public String userLocationList(@PathVariable String username, Model model) throws JsonParseException, JsonMappingException, MalformedURLException, IOException
	{
		ArrayList<User> users = submitController.getUsersData();
		int i=0;
		for (User user : users)
		{
			if(user.getUsername().equals(username))
			{
				break;
			}
			i++;
		}
		ArrayList<StayLocation> LocList = users.get(i).getTotal();
		int j=0;
		ArrayList<FullAddress> locationAddress=new ArrayList<FullAddress>();
		ObjectMapper mapper=new ObjectMapper();
		for (StayLocation stayLocation : LocList)
		{
			double lati=stayLocation.getClusterCentre().getLatitudeE7()/Math.pow(10, 7);
			double longi=stayLocation.getClusterCentre().getLongitudeE7()/Math.pow(10, 7);
			String url="https://eu1.locationiq.org/v1/reverse.php?key=91b61f3ada4329&lat="+lati+"&lon="+longi+"&format=json&addressdetails=0";
			LocationAddress addr=mapper.readValue(new URL(url), LocationAddress.class);
			FullAddress fullAddress=new FullAddress("Location-"+j,lati,longi,addr.getDisplay_name());
			locationAddress.add(fullAddress);
			j++;
		}
		model.addAttribute("locationAddress", locationAddress);
		model.addAttribute("username",username);
		return "locdet";
	}
}
