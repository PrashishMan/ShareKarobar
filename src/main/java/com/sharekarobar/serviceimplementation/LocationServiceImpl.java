package com.sharekarobar.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharekarobar.dao.LocationDao;
import com.sharekarobar.model.Location;
import com.sharekarobar.services.LocationService;

@Service("locationService")
@Transactional(propagation =  Propagation.SUPPORTS, readOnly = true)
public class LocationServiceImpl implements LocationService{

	@Autowired
	LocationDao locationDao;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = false)
	public void addLocation(Location location) {
		locationDao.addLocation(location);
	}

	@Override
	public Location getLocation(int locationID) {
		return locationDao.getLocation(locationID);
	}

	@Override
	public List<Location> getLocation() {
		return locationDao.getLocation();
	}
	

}
