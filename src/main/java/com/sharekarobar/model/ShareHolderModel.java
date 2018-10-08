package com.sharekarobar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ShareHolders")
public class ShareHolderModel {
	@Id
	@Column(name = "username")
	public String username;
	
	@Column(name = "password")
	public String password;
	
	@Column(name = "ShareholderName")
	public String shareholderName;
		
	@ManyToOne
	@JoinColumn(name = "LocationId")
	public Location locationId;
	
	@Column(name = "Status")
	public int status;

	@Transient
	public int totalShare;
	
	@Transient
	public int purchaseAmount;
	
	
	public ShareHolderModel(){}
	
	public ShareHolderModel(String username, String password, String shareholderName, Location locationId) {
		this.username = username;
		this.password = password;
		this.shareholderName = shareholderName;
		this.locationId = locationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShareholderName() {
		return shareholderName;
	}

	public void setShareholderName(String shareholderName) {
		this.shareholderName = shareholderName;
	}

	public Location getLocationId() {
		return locationId;
	}

	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getTotalShare() {
		return totalShare;
	}

	public void setTotalShare(int totalShare) {
		this.totalShare = totalShare;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	
}
