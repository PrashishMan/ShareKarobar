package com.sharekarobar.daoimplementation;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharekarobar.dao.LocationDao;
import com.sharekarobar.model.Location;


@Repository("LocationDao")
public class LocationDAOImpl implements LocationDao {

	@Autowired
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addLocation(Location location) {
		getSession().saveOrUpdate(location);	
	}

	@Override
	public Location getLocation(int locationID) {
		return  (Location)getSession().get(Location.class, locationID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getLocation() {
		return (List<Location>)getSession().createCriteria(Location.class).list();
	}
	
}
