package com.sharekarobar.services;

import com.sharekarobar.model.OrganizationModel;

public interface OrganizationService {

	public OrganizationModel getOrganizationInfo(String userName);
	public void updateOrganization(OrganizationModel organizationModel);
}
