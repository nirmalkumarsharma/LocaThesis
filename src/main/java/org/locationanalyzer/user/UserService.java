package org.locationanalyzer.user;

import java.util.ArrayList;

import org.locationanalyzer.patterns.entities.StayLocation;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	public ArrayList<StayLocation> sortByTotal(ArrayList<StayLocation> stayLocations)
	{
		ArrayList<StayLocation> sortedByTotal=new ArrayList<StayLocation>();
		if(stayLocations!=null)
		{
			sortedByTotal.addAll(stayLocations);
			for(int i=0;i<sortedByTotal.size();i++)
			{
				for(int j=0;j<sortedByTotal.size()-i-1;j++)
				{
					if(sortedByTotal.get(j).getTotalMillisecond()<sortedByTotal.get(j+1).getTotalMillisecond())
					{
						StayLocation stayLocation=sortedByTotal.get(j);
						sortedByTotal.set(j, sortedByTotal.get(j+1));
						sortedByTotal.set(j+1, stayLocation);
					}
				}
			}
			return sortedByTotal;
		}
		return null;
	}
	public ArrayList<StayLocation> sortByMorning(ArrayList<StayLocation> stayLocations)
	{
		ArrayList<StayLocation> sortedByMorning=new ArrayList<StayLocation>();
		if(stayLocations!=null)
		{
			sortedByMorning.addAll(stayLocations);
			for(int i=0;i<sortedByMorning.size();i++)
			{
				for(int j=0;j<sortedByMorning.size()-i-1;j++)
				{
					if(sortedByMorning.get(j).getMorningMillisecond()<sortedByMorning.get(j+1).getMorningMillisecond())
					{
						StayLocation stayLocation=sortedByMorning.get(j);
						sortedByMorning.set(j, sortedByMorning.get(j+1));
						sortedByMorning.set(j+1, stayLocation);
					}
				}
			}
			return sortedByMorning;
		}
		return null;
	}
	public ArrayList<StayLocation> sortByEvening(ArrayList<StayLocation> stayLocations)
	{
		ArrayList<StayLocation> sortedByEvening=new ArrayList<StayLocation>();
		if(stayLocations!=null)
		{
			sortedByEvening.addAll(stayLocations);
			for(int i=0;i<sortedByEvening.size();i++)
			{
				for(int j=0;j<sortedByEvening.size()-i-1;j++)
				{
					if(sortedByEvening.get(j).getEveningMillisecond()<sortedByEvening.get(j+1).getEveningMillisecond())
					{
						StayLocation stayLocation=sortedByEvening.get(j);
						sortedByEvening.set(j, sortedByEvening.get(j+1));
						sortedByEvening.set(j+1, stayLocation);
					}
				}
			}
			return sortedByEvening;
		}
		return null;
	}
	public ArrayList<StayLocation> sortByNight(ArrayList<StayLocation> stayLocations)
	{
		ArrayList<StayLocation> sortedByNight=new ArrayList<StayLocation>();
		if(stayLocations!=null)
		{
			sortedByNight.addAll(stayLocations);
			for(int i=0;i<sortedByNight.size();i++)
			{
				for(int j=0;j<sortedByNight.size()-i-1;j++)
				{
					if(sortedByNight.get(j).getNightMillisecond()<sortedByNight.get(j+1).getNightMillisecond())
					{
						StayLocation stayLocation=sortedByNight.get(j);
						sortedByNight.set(j, sortedByNight.get(j+1));
						sortedByNight.set(j+1, stayLocation);
					}
				}
			}
			return sortedByNight;
		}
		return null;
	}
	public ArrayList<StayLocation> sortByWeekday(ArrayList<StayLocation> stayLocations)
	{
		ArrayList<StayLocation> sortedByWeekday=new ArrayList<StayLocation>();
		if(stayLocations!=null)
		{
			sortedByWeekday.addAll(stayLocations);
			for(int i=0;i<sortedByWeekday.size();i++)
			{
				for(int j=0;j<sortedByWeekday.size()-i-1;j++)
				{
					if(sortedByWeekday.get(j).getWeekday()<sortedByWeekday.get(j+1).getWeekday())
					{
						StayLocation stayLocation=sortedByWeekday.get(j);
						sortedByWeekday.set(j, sortedByWeekday.get(j+1));
						sortedByWeekday.set(j+1, stayLocation);
					}
				}
			}
			return sortedByWeekday;
		}
		return null;
	}
	public ArrayList<StayLocation> sortByWeekend(ArrayList<StayLocation> stayLocations)
	{
		ArrayList<StayLocation> sortedByWeekend=new ArrayList<StayLocation>();
		if(stayLocations!=null)
		{
			sortedByWeekend.addAll(stayLocations);
			for(int i=0;i<sortedByWeekend.size();i++)
			{
				for(int j=0;j<sortedByWeekend.size()-i-1;j++)
				{
					if(sortedByWeekend.get(j).getWeekend()<sortedByWeekend.get(j+1).getWeekend())
					{
						StayLocation stayLocation=sortedByWeekend.get(j);
						sortedByWeekend.set(j, sortedByWeekend.get(j+1));
						sortedByWeekend.set(j+1, stayLocation);
					}
				}
			}
			return sortedByWeekend;
		}
		return null;
	}
	
}