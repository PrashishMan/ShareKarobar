package com.sharekarobar.dao;

import java.util.List;

import com.sharekarobar.model.MonthlyProfit;
import com.sharekarobar.model.TransactionModel;

public interface TransactionDao {
	public void addTransaction(TransactionModel transaction);
	public TransactionModel getTransaction(int transactionId);
	public List<TransactionModel> getTransaction();
	public MonthlyProfit getMonthlyProfit(int month);
	public List<TransactionModel> getMonthlyTransaction(int month);
}
