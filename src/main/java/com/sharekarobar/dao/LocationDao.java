package com.sharekarobar.dao;

import java.util.List;

import com.sharekarobar.model.Location;

public interface LocationDao {
	public void addLocation(Location location);
	public Location getLocation(int locationID);
	public List<Location> getLocation();
}
