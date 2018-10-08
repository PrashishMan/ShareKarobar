package com.sharekarobar.daoimplementation;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharekarobar.dao.TransactionDao;
import com.sharekarobar.model.MonthlyProfit;
import com.sharekarobar.model.TransactionModel;

@Repository("transactionDao")
public class TransactionDAOImpl implements TransactionDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addTransaction(TransactionModel transactionModel) {
		getSession().saveOrUpdate(transactionModel);

	}

	@Override
	public TransactionModel getTransaction(int transactionId) {
		return (TransactionModel) getSession().get(TransactionModel.class, transactionId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionModel> getTransaction() {
		return (List<TransactionModel>) getSession().createCriteria(TransactionModel.class).list();
	}

	@Override
	public MonthlyProfit getMonthlyProfit(int month) {
		Query debitQuery = getSession().createQuery(
				"SELECT SUM(amount) FROM TransactionModel WHERE month(date) = ? AND year(date) = ? AND transactionType = 'Debit'");
		debitQuery.setParameter(0, month);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		debitQuery.setParameter(1, year);
		Query creditQuery = getSession().createQuery(
				"SELECT SUM(amount) FROM TransactionModel WHERE month(date) = ? AND year(date) = ? AND transactionType = 'Credit'");
		creditQuery.setParameter(0, month);
		creditQuery.setParameter(1, year);
		
		int profit = 0;
		int debitSum = 0;
		int creditSum = 0;
		
		if (debitQuery.uniqueResult() != null && creditQuery.uniqueResult() != null) {
			debitSum = ((Long) debitQuery.uniqueResult()).intValue();
			creditSum = ((Long) creditQuery.uniqueResult()).intValue();
		}
		

		profit = debitSum - creditSum;

		MonthlyProfit monthlyProfit = new MonthlyProfit(year, month, debitSum, creditSum, profit);

		return monthlyProfit;
	}
	
//	@Override
	public List<TransactionModel> getMonthlyTransaction(int month) {
		Query query = getSession().createQuery(
				"FROM TransactionModel WHERE month(date) = ? AND year(date) = ?");
		query.setParameter(0, month);
		int year = Calendar.getInstance().get(Calendar.YEAR);
		query.setParameter(1, year);
		
		@SuppressWarnings("unchecked")
		List<TransactionModel> transactionList = (List<TransactionModel>) query.list();
		return transactionList;
	}

}
