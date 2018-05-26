package org.statistical.chart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.locationanalyzer.patterns.entities.StayLocation;
import org.locationanalyzer.user.User;
import org.springframework.stereotype.Component;

@Component
public class CanvasjsChartData
{
	int elements=5;
	
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
		ArrayList<StayLocation> total = user.getMorning();
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
		ArrayList<StayLocation> total = user.getEvening();
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
		ArrayList<StayLocation> total = user.getNight();
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs(millisecondToHours(stayLocation.getNightMillisecond())));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public List<List<Map<Object, Object>>> getCanvasjsDataListWeekDay(User user) {
		ArrayList<StayLocation> total = user.getWeekdays();
		Random random=new Random();
		Map<Object,Object> map = null;
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs((7*random.nextFloat()+16.8)*stayLocation.getWeekday()));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public List<List<Map<Object, Object>>> getCanvasjsDataListWeekend(User user)
	{
		ArrayList<StayLocation> total = user.getWeekend();
		Map<Object,Object> map = null;
		Random random=new Random();
		List<List<Map<Object,Object>>> list = new ArrayList<List<Map<Object,Object>>>();
		List<Map<Object,Object>> dataPoints = new ArrayList<Map<Object,Object>>();
		
		for(int i=0;i<total.size()&&i<elements;i++)
		{
			String location="Location";
			StayLocation stayLocation=total.get(i);
			
			map = new HashMap<Object,Object>();
			map.put("label", location+"-"+stayLocation.getId());
			map.put("y", Math.abs((7*random.nextFloat()+16.8)*stayLocation.getWeekend()));
			dataPoints.add(map);
		}
		list.add(dataPoints);
		return list;
	}
	public double millisecondToHours(long millisecond)
	{
		return millisecond/(3600000);
	}
}