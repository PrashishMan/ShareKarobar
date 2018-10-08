package com.sharekarobar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.sharekarobar.services.ShareHolderService;
import com.sharekarobar.services.ShareService;

@Entity
@Table(name = "ShareholdersPurchases")
public class PurchaseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	public PurchaseJoinKey purchaseKey;
	
	@Column(name = "Date")
	public Date purchaseDate;

	@Column(name = "PurchaseAmount")
	public int purchaseAmount;

	public PurchaseModel(PurchaseJoinKey purchaseKey, Date purchaseDate, int purchaseAmount) {
		this.purchaseKey = purchaseKey;
		this.purchaseDate = new Date();
		this.purchaseAmount = purchaseAmount;
	}
	
	public PurchaseModel() {
		this.purchaseDate = new Date();
	}
	
	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public PurchaseJoinKey getPurchaseKey() {
		return purchaseKey;
	}

	public void setPurchaseKey(PurchaseJoinKey purchaseKey) {
		this.purchaseKey = purchaseKey;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Embeddable
	public static class PurchaseJoinKey implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Autowired
		@Transient
		private ShareService shareService;		
		
		@Autowired
		@Transient
		private ShareHolderService shareHolderService;
		
		@ManyToOne
		@JoinColumn(name = "username")
		public ShareHolderModel username;
		
		@ManyToOne
		@JoinColumn(name = "issueID")
		public ShareModel issueID;

		public PurchaseJoinKey(int issueID, String username) {
			this.issueID = shareService.getShare(issueID);
			this.username = shareHolderService.getShareHolder(username);
		}
		public PurchaseJoinKey() {
		}

		public ShareHolderModel getUsername() {
			return username;
		}

		public void setUsername(ShareHolderModel username) {
			this.username = username;
		}

		public ShareModel getIssueID() {
			return issueID;
		}

		public void setIssueID(ShareModel issueID) {
			this.issueID = issueID;
		}

	}

}
