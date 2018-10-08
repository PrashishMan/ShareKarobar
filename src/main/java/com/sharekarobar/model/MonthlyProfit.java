package com.sharekarobar.model;

public class MonthlyProfit {
	
	private int year;
	private int month;
	private int debitTotal;
	private int creditTotal;
	private int profit;
	
	public MonthlyProfit() {
	}
	
	public MonthlyProfit(int year, int month, int debitTotal, int creditTotal, int profit) {
		super();
		this.year = year;
		this.month = month;
		this.profit = profit;
		this.debitTotal = debitTotal;
		this.creditTotal = creditTotal; 
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDebitTotal() {
		return debitTotal;
	}

	public void setDebitTotal(int debitTotal) {
		this.debitTotal = debitTotal;
	}

	public int getCreditTotal() {
		return creditTotal;
	}

	public void setCreditTotal(int creditTotal) {
		this.creditTotal = creditTotal;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}
	
	
	
}
