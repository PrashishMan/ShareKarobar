package com.sharekarobar.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transactions")
public class TransactionModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TransactionId")
	public int transactionId;
	
	@Column(name = "Date")
	public Date date;
	
	@Column(name = "billNo")
	public int billNo;
	
	@Column(name = "PartyName")
	public String partyName;
	
	@Column(name = "transactionPurpose")
	public String transactionPurpose;
	
	@Column(name = "TransactionType")
	public String transactionType;
	
	@Column(name = "BillAmount")
	public int amount;
	
	@Column(name = "PaymentType")
	public String paymentType;
	
	

	public TransactionModel(int transactionId, Date date, int billNo, String partyName, String transactionPurpose,
			String transactionType, int amount, String paymentType) {
		super();
		this.transactionId = transactionId;
		this.date = new Date();
		this.billNo = billNo;
		this.partyName = partyName;
		this.transactionPurpose = transactionPurpose;
		this.transactionType = transactionType;
		this.amount = amount;
		this.paymentType = paymentType;
	}

	public TransactionModel() {
		this.date = new Date();
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public String getTransactionPurpose() {
		return transactionPurpose;
	}

	public void setTransactionPurpose(String transactionPurpose) {
		this.transactionPurpose = transactionPurpose;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
