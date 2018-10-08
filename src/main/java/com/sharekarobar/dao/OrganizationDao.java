package com.sharekarobar.dao;

import com.sharekarobar.model.OrganizationModel;

public interface OrganizationDao {
	public OrganizationModel getOrganizationInfo(String userName);
	public void updateOrganization(OrganizationModel organizationModel);
}
