package com.sharekarobar.services;

import java.util.List;

import com.sharekarobar.model.Location;

public interface LocationService {
	public void addLocation(Location location);
	public Location getLocation(int locationID);
	public List<Location> getLocation();
}
