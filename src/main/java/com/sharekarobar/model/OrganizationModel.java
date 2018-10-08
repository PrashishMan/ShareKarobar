package com.sharekarobar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Organization")
public class OrganizationModel {

	
	@Column(name = "OrganizationName", length = 100)
	public String organizationName;
	
	@Column(name = "AdminFName", length = 100)
	public String adminFname;
	
	@Column(name = "AdminLName", length = 100)
	public String adminLname;
	
	@Id
	@Column(name = "adminUserName", length = 25)
	public String adminUsername;
	
	@Column(name = "adminPassword", length = 25)
	public String adminPassword;
	
	@Column(name = "OrganizationMargin", length = 11)
	public int organizationMargin;
	
	public OrganizationModel() {}

	public OrganizationModel(String adminUsername, String adminPassword) {
		this.adminUsername = adminUsername;
		this.adminPassword = adminPassword;
	}
	
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getAdminFame() {
		return adminFname;
	}

	public void setAdminFame(String adminFame) {
		this.adminFname = adminFame;
	}

	public String getAdminLame() {
		return adminLname;
	}

	public void setAdminLame(String adminLame) {
		this.adminLname = adminLame;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getOrganizationMargin() {
		return organizationMargin;
	}

	public void setOrganizationMargin(int organizationMargin) {
		this.organizationMargin = organizationMargin;
	}
	
	
}
