package org.locationanalyzer.user;

import java.util.ArrayList;

import org.locationanalyzer.patterns.entities.StayLocation;

public class User
{
	private String username;
	private ArrayList<StayLocation> morning;
	private ArrayList<StayLocation> evening;
	private ArrayList<StayLocation> night;
	private ArrayList<StayLocation> weekdays;
	private ArrayList<StayLocation> weekend;
	private ArrayList<StayLocation> total;
	
	public User()
	{
		super();
	}
	public User(String username, ArrayList<StayLocation> morning, ArrayList<StayLocation> evening, ArrayList<StayLocation> night, ArrayList<StayLocation> weekdays, ArrayList<StayLocation> weekend, ArrayList<StayLocation> total)
	{
		super();
		this.username = username;
		this.morning = morning;
		this.evening = evening;
		this.night = night;
		this.weekdays = weekdays;
		this.weekend = weekend;
		this.total=total;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ArrayList<StayLocation> getMorning() {
		return morning;
	}
	public void setMorning(ArrayList<StayLocation> morning) {
		this.morning = morning;
	}
	public ArrayList<StayLocation> getEvening() {
		return evening;
	}
	public void setEvening(ArrayList<StayLocation> evening) {
		this.evening = evening;
	}
	public ArrayList<StayLocation> getNight() {
		return night;
	}
	public void setNight(ArrayList<StayLocation> night) {
		this.night = night;
	}
	public ArrayList<StayLocation> getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(ArrayList<StayLocation> weekdays) {
		this.weekdays = weekdays;
	}
	public ArrayList<StayLocation> getWeekend() {
		return weekend;
	}
	public void setWeekend(ArrayList<StayLocation> weekend) {
		this.weekend = weekend;
	}
	public ArrayList<StayLocation> getTotal() {
		return total;
	}
	public void setTotal(ArrayList<StayLocation> total) {
		this.total = total;
	}
}
