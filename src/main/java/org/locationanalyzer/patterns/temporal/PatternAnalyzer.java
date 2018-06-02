package org.locationanalyzer.patterns.temporal;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.locationanalyzer.clustering.StayDuration;
import org.locationanalyzer.clustering.StayPointCluster;
import org.locationanalyzer.patterns.entities.StayLocation;

public class PatternAnalyzer
{
	@SuppressWarnings("deprecation")
	public ArrayList<StayLocation> dayTimePattern(ArrayList<StayPointCluster> stayPointClusters)
	{
		ArrayList<StayLocation> stayLocations=new ArrayList<StayLocation>();
		
		for (StayPointCluster stayPointCluster : stayPointClusters)
		{
			ArrayList<StayDuration> durations=stayPointCluster.getDurations();
			
			long morningMillisecond=0;
			long eveningMillisecond=0;
			long nightMillisecond=0;
			long totalMillisecond=0;
			long weekends=0;
			long weekdays=0;
			
			int lastDay=0;
			
			for (StayDuration duration : durations)
			{
				Timestamp startTime=duration.getArrivalTime();
				Timestamp endTime=duration.getDepartureTime();
				
				GregorianCalendar calendar=new GregorianCalendar();
				calendar.setTime(startTime);

				if(startTime.getDay()!=lastDay)
				{
					if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY||calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
					{
						weekends+=compareTwoTimeStamps(startTime, endTime);
					}
					else
					{
						weekdays+=compareTwoTimeStamps(startTime, endTime);
					}
					lastDay=startTime.getDay();
				}
				
				totalMillisecond+=compareTwoTimeStamps(startTime, endTime);
				
				Timestamp itrStartTime=new Timestamp(startTime.getTime());
				Timestamp itrEndTime=new Timestamp(startTime.getTime());
				
				String startTimeRange=getTimeRange(itrStartTime);
				String endTimeRange=getTimeRange(itrEndTime);
				
				if(!startTimeRange.equals("transition"))
				{
					if(startTimeRange.equals("morning"))
					{
						itrStartTime.setHours(16);
						itrStartTime.setMinutes(0);
						itrStartTime.setSeconds(0);
					}
					if(startTimeRange.equals("evening"))
					{
						itrStartTime.setHours(0);
						itrStartTime.setMinutes(0);
						itrStartTime.setSeconds(0);
					}
					if(startTimeRange.equals("night"))
					{
						itrStartTime.setHours(8);
						itrStartTime.setMinutes(0);
						itrStartTime.setSeconds(0);
					}
				}
				
				if(!endTimeRange.equals("transition"))
				{
					if(endTimeRange.equals("morning"))
					{
						itrEndTime.setHours(8);
						itrEndTime.setMinutes(0);
						itrEndTime.setSeconds(0);
					}
					if(endTimeRange.equals("evening"))
					{
						itrEndTime.setHours(16);
						itrEndTime.setMinutes(0);
						itrEndTime.setSeconds(0);
					}
					if(endTimeRange.equals("night"))
					{
						itrEndTime.setHours(0);
						itrEndTime.setMinutes(0);
						itrEndTime.setSeconds(0);
					}
				}
				
				if(itrEndTime.before(itrStartTime)||(itrEndTime.equals(itrStartTime)))
				{
					long durInMillisecond=compareTwoTimeStamps(endTime, startTime);
					if(startTimeRange.equals("morning"))
					{
						morningMillisecond+=durInMillisecond;
					}
					if(startTimeRange.equals("evening"))
					{
						eveningMillisecond+=durInMillisecond;
					}
					if(startTimeRange.equals("night"))
					{
						nightMillisecond+=durInMillisecond;
					}
				}
				if(itrEndTime.after(itrStartTime))
				{
					long durInMillisecond1=compareTwoTimeStamps(itrStartTime, startTime);
					long durInMillisecond2=compareTwoTimeStamps(itrEndTime, endTime);
					
					if(startTimeRange.equals("morning"))
					{
						morningMillisecond+=durInMillisecond1;
					}
					if(startTimeRange.equals("evening"))
					{
						eveningMillisecond+=durInMillisecond1;
					}
					if(startTimeRange.equals("night"))
					{
						nightMillisecond+=durInMillisecond1;
					}
					
					if(endTimeRange.equals("morning"))
					{
						morningMillisecond+=durInMillisecond2;
					}
					if(endTimeRange.equals("evening"))
					{
						eveningMillisecond+=durInMillisecond2;
					}
					if(endTimeRange.equals("night"))
					{
						nightMillisecond+=durInMillisecond2;
					}
					long daySpanMillisecond=28800000;
					long itrTimeDuration=compareTwoTimeStamps(itrStartTime, itrEndTime);
					long noOfDaySpan=itrTimeDuration/daySpanMillisecond;
					long incrVal=daySpanMillisecond*(noOfDaySpan/3);
					
					morningMillisecond+=incrVal;
					eveningMillisecond+=incrVal;
					nightMillisecond+=incrVal;
					
					long forFac=noOfDaySpan%3;
					
					if(startTimeRange.equals("morning"))
					{
						if(forFac==1)
						{
							morningMillisecond+=daySpanMillisecond;
						}
						if(forFac==2)
						{
							morningMillisecond+=daySpanMillisecond;
							eveningMillisecond+=daySpanMillisecond;
						}
					}
					
					if(startTimeRange.equals("evening"))
					{
						if(forFac==1)
						{
							eveningMillisecond+=daySpanMillisecond;
						}
						if(forFac==2)
						{
							eveningMillisecond+=daySpanMillisecond;
							nightMillisecond+=daySpanMillisecond;
						}
					}
					
					if(startTimeRange.equals("night"))
					{
						if(forFac==1)
						{
							nightMillisecond+=daySpanMillisecond;
						}
						if(forFac==2)
						{
							nightMillisecond+=daySpanMillisecond;
							morningMillisecond+=daySpanMillisecond;
						}
					}
				}
			}
			int count=0;
			if(morningMillisecond==0)
			{
				morningMillisecond+=totalMillisecond/4;
				count++;
			}
			if(eveningMillisecond==0)
			{
				eveningMillisecond+=totalMillisecond/4;
				count++;
			}
			if(nightMillisecond==0)
			{
				nightMillisecond+=totalMillisecond/4;
				count++;
			}
			totalMillisecond=count*totalMillisecond/4;
			
			long totalmillisecondG = nightMillisecond+morningMillisecond+eveningMillisecond;
			
			if(totalMillisecond<totalmillisecondG)
			{
				totalMillisecond=totalmillisecondG;
			}
			StayLocation stayLocation=new StayLocation(stayPointCluster.getId(),stayPointCluster.getClusterCentre(),morningMillisecond,eveningMillisecond,nightMillisecond,totalMillisecond,weekends,weekdays);
			stayLocations.add(stayLocation);
		}
		return stayLocations;
	}

	@SuppressWarnings("deprecation")
	private String getTimeRange(Timestamp time)
	{
		Timestamp morningStartTime=new Timestamp(time.getTime());
		Timestamp morningEndTime=new Timestamp(time.getTime());
		
		Timestamp eveningStartTime=new Timestamp(time.getTime());
		Timestamp eveningEndTime=new Timestamp(time.getTime());
		
		Timestamp nightStartTime=new Timestamp(time.getTime());
		Timestamp nightEndTime=new Timestamp(time.getTime());
		
		morningStartTime.setHours(8);
		morningStartTime.setMinutes(0);
		morningStartTime.setSeconds(0);
		
		morningEndTime.setHours(16);
		morningEndTime.setMinutes(0);
		morningEndTime.setSeconds(0);
		
		
		eveningStartTime.setHours(16);
		eveningStartTime.setMinutes(0);
		eveningStartTime.setSeconds(0);
		
		eveningEndTime.setHours(0);
		eveningEndTime.setMinutes(0);
		eveningEndTime.setSeconds(0);
		
		
		nightStartTime.setHours(0);
		nightStartTime.setMinutes(0);
		nightStartTime.setSeconds(0);
		
		nightEndTime.setHours(8);
		nightEndTime.setMinutes(0);
		nightEndTime.setSeconds(0);
		
		if((time.after(morningStartTime)||time.equals(morningStartTime))&&(time.before(morningEndTime)||time.equals(morningEndTime)))
		{
			return "morning";
		}
		if((time.after(eveningStartTime)||time.equals(eveningStartTime))&&(time.before(eveningEndTime)||time.equals(eveningEndTime)))
		{
			return "evening";
		}
		if((time.after(nightStartTime)||time.equals(nightStartTime))&&(time.before(nightEndTime)||time.equals(nightEndTime)))
		{
			return "night";
		}
		return "transition";
	}
	
	private static long compareTwoTimeStamps(Timestamp timestamp1, Timestamp timestamp2)
	{
	    long milliseconds1 = timestamp1.getTime();
	    long milliseconds2 = timestamp2.getTime();

	    long diff = milliseconds2 - milliseconds1;
	    diff=Math.abs(diff);
	    return diff;
	}
}
