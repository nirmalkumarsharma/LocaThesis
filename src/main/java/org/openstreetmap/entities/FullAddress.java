package org.openstreetmap.entities;

public class FullAddress
{
	private String name;
	private double latitude;
	private double longitude;
	private String address;
	
	public FullAddress() {
		// TODO Auto-generated constructor stub
	}

	public FullAddress(String name, double latitude, double longitude, String address) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
