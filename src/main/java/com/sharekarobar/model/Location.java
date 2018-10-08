package com.sharekarobar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Locations")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LocationID")
	public int locationID;
	
	@Column(name = "State")
	public String state;
	
	@Column(name = "Zone")
	public String zone;
	
	@Column(name = "City")
	public String city;
	
	@Column(name = "street")
	public String Street;

	
	
	public Location(int locationID, String state, String zone, String city, String street) {
		this.locationID = locationID;
		this.state = state;
		this.zone = zone;
		this.city = city;
		Street = street;
	}
	
	public Location() {}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}
	
	
}
