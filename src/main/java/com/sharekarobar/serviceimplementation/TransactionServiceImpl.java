package com.sharekarobar.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharekarobar.dao.TransactionDao;
import com.sharekarobar.model.MonthlyProfit;
import com.sharekarobar.model.TransactionModel;
import com.sharekarobar.services.TransactionService;

@Service("transactionService")
@Transactional(propagation = Propagation.SUPPORTS)
public class TransactionServiceImpl implements TransactionService{

	@Autowired
	TransactionDao transactionDao;
	
	@Override
	public void addTransaction(TransactionModel transaction) {
		transactionDao.addTransaction(transaction);
		
	}

	@Override
	public TransactionModel getTransaction(int transactionId) {
		return transactionDao.getTransaction(transactionId);
	}

	@Override
	public List<TransactionModel> getTransaction() {
		return transactionDao.getTransaction();
	}

	@Override
	public MonthlyProfit getMonthlyProfit(int month) {
		return transactionDao.getMonthlyProfit(month);
	}
	
	public List<TransactionModel> getMonthlyTransaction(int month){
		return transactionDao.getMonthlyTransaction(month);
	}

}
