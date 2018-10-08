package com.sharekarobar.daoimplementation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharekarobar.dao.OrganizationDao;
import com.sharekarobar.model.OrganizationModel;

@Repository("organizationDao")
public class OrganizationDAOImpl implements OrganizationDao{
	
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession() {
		return (Session)sessionFactory.getCurrentSession();
		
	}
	@Override
	public OrganizationModel getOrganizationInfo(String userName) {
		return (OrganizationModel)getSession().get(OrganizationModel.class, userName);
	}
	
	@Override
	public void updateOrganization(OrganizationModel organizationModel) {
		getSession().update(organizationModel);
	}
	
}
