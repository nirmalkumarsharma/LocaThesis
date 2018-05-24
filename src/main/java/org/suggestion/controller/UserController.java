package org.suggestion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.locationanalyzer.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.statistical.chart.CanvasjsChartService;

@Controller
public class UserController
{
	@Autowired
	private SubmitController submitController;
	
	@Autowired
	private CanvasjsChartService canvasjsChartService;

	@RequestMapping("/user/{username}")
	public String userPage(@PathVariable String username, Model model)
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
		model.addAttribute("user", users.get(i));
		
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData();
		model.addAttribute("dataPointsList", canvasjsDataList);
		
		
		return "user";
	}
}
