package com.sharekarobar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shares")
public class ShareModel  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issueID")
	public int issueID;
	
	@Column(name = "IssueDate")
	public Date issueDate;
		
	@Column(name = "IssuedAmount")
	public int issuedAmount;

	public int getIssueID() {
		return issueID;
	}

	public void setIssueID(int issueID) {
		this.issueID = issueID;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public int getIssuedAmount() {
		return issuedAmount;
	}

	public void setIssuedAmount(int issuedAmount) {
		this.issuedAmount = issuedAmount;
	}
	
	
}
