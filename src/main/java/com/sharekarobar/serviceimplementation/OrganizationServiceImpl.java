package com.sharekarobar.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharekarobar.dao.OrganizationDao;
import com.sharekarobar.model.OrganizationModel;
import com.sharekarobar.services.OrganizationService;

@Service("organizationService")


@Transactional(propagation=Propagation.SUPPORTS)
public class OrganizationServiceImpl implements OrganizationService {
	
	@Autowired
	OrganizationDao organizationDao;
	
	public OrganizationModel getOrganizationInfo(String userName) {
			return organizationDao.getOrganizationInfo(userName);
		
	};
	
	@Override
	public void updateOrganization(OrganizationModel organizationModel) {
		organizationDao.updateOrganization(organizationModel);
	}

}
