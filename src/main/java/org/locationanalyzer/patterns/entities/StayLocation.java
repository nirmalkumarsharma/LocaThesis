package org.locationanalyzer.patterns.entities;

import org.locationanalyzer.entities.json.out.StayPoint;

public class StayLocation
{
	private int id;
	private StayPoint clusterCentre;
	
	long morningMillisecond;
	long eveningMillisecond;
	long nightMillisecond;
	long totalMillisecond;
	long weekend;
	long weekday;
	
	public StayLocation() {	}
	
	public StayLocation(int id, StayPoint clusterCentre, long morningMillisecond, long eveningMillisecond, long nightMillisecond,long totalMillisecond, long weekend, long weekday)
	{
		super();
		this.id = id;
		this.clusterCentre = clusterCentre;
		this.morningMillisecond = morningMillisecond;
		this.eveningMillisecond = eveningMillisecond;
		this.nightMillisecond = nightMillisecond;
		this.totalMillisecond = totalMillisecond;
		this.weekend=weekend;
		this.weekday=weekday;
	}
	public long getWeekend() {
		return weekend;
	}
	public void setWeekend(long weekend) {
		this.weekend = weekend;
	}
	public long getWeekday() {
		return weekday;
	}
	public void setWeekday(long weekday) {
		this.weekday = weekday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StayPoint getClusterCentre() {
		return clusterCentre;
	}
	public void setClusterCentre(StayPoint clusterCentre) {
		this.clusterCentre = clusterCentre;
	}
	public long getMorningMillisecond() {
		return morningMillisecond;
	}
	public void setMorningMillisecond(long morningMillisecond) {
		this.morningMillisecond = morningMillisecond;
	}
	public long getEveningMillisecond() {
		return eveningMillisecond;
	}
	public void setEveningMillisecond(long eveningMillisecond) {
		this.eveningMillisecond = eveningMillisecond;
	}
	public long getNightMillisecond() {
		return nightMillisecond;
	}
	public void setNightMillisecond(long nightMillisecond) {
		this.nightMillisecond = nightMillisecond;
	}
	public long getTotalMillisecond() {
		return totalMillisecond;
	}
	public void setTotalMillisecond(long totalMillisecond) {
		this.totalMillisecond = totalMillisecond;
	}
}
