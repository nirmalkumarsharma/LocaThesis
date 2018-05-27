package org.web.controller;

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
		
		List<List<Map<Object, Object>>> canvasjsDataList = canvasjsChartService.getCanvasjsChartData(users.get(i));
		List<List<Map<Object, Object>>> canvasjsDataListMorning = canvasjsChartService.getCanvasjsChartDataMorning(users.get(i));
		List<List<Map<Object, Object>>> canvasjsDataListEvening = canvasjsChartService.getCanvasjsChartDataEvening(users.get(i));
		List<List<Map<Object, Object>>> canvasjsDataListNight = canvasjsChartService.getCanvasjsChartDataNight(users.get(i));
		List<List<Map<Object, Object>>> canvasjsDataListWeekDay = canvasjsChartService.getCanvasjsChartDataWeekDay(users.get(i));
		List<List<Map<Object, Object>>> canvasjsDataListWeekend = canvasjsChartService.getCanvasjsChartDataWeekend(users.get(i));
		
		
		model.addAttribute("dataPointsList", canvasjsDataList);
		model.addAttribute("dataPointsListMorning", canvasjsDataListMorning);
		model.addAttribute("dataPointsListEvening", canvasjsDataListEvening);
		model.addAttribute("dataPointsListNight", canvasjsDataListNight);
		model.addAttribute("dataPointsListWeekDay", canvasjsDataListWeekDay);
		model.addAttribute("dataPointsListWeekend", canvasjsDataListWeekend);
		
		
		return "user";
	}
}
