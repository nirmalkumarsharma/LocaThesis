package org.statistical.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.locationanalyzer.patterns.entities.StayLocation;
import org.locationanalyzer.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.suggestion.controller.SubmitController;

@Component
public class CanvasjsChartData
{
	int elements=5;
	
	/*
	static
	{
		map = new HashMap<Object,Object>(); map.put("label", "Other"); map.put("y", 3.2);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Paramount"); map.put("y", 2.9);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Sony"); map.put("y", 5.2);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Fox"); map.put("y", 7.9);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Warner Bros."); map.put("y", 8.6);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Universal"); map.put("y", 11.6);dataPoints1.add(map);
		map = new HashMap<Object,Object>(); map.put("label", "Disney"); map.put("y", 17.1);dataPoints1.add(map);

		list.add(dataPoints1);
	}
*/
	public List<List<Map<Object, Object>>> getCanvasjsDataList(User user)
	{
		ArrayList<StayLocation> total = user.getTotal();
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs(millisecondToHours(stayLocation.getTotalMillisecond())));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public List<List<Map<Object, Object>>> getCanvasjsDataListMorning(User user)
	{
		ArrayList<StayLocation> total = user.getTotal();
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs(millisecondToHours(stayLocation.getMorningMillisecond())));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public List<List<Map<Object, Object>>> getCanvasjsDataListEvening(User user)
	{
		ArrayList<StayLocation> total = user.getTotal();
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs(millisecondToHours(stayLocation.getEveningMillisecond())));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public List<List<Map<Object, Object>>> getCanvasjsDataListNight(User user)
	{
		ArrayList<StayLocation> total = user.getTotal();
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs(millisecondToHours(stayLocation.getEveningMillisecond())));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public List<List<Map<Object, Object>>> getCanvasjsDataListWeekDay(User user) {
		ArrayList<StayLocation> total = user.getTotal();
		
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs(16.8*stayLocation.getWeekday()));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public List<List<Map<Object, Object>>> getCanvasjsDataListWeekend(User user)
	{
		ArrayList<StayLocation> total = user.getTotal();
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs(16.8*stayLocation.getWeekend()));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public float millisecondToHours(long millisecond)
	{
		return (int) millisecond/(3600000);
	}
}