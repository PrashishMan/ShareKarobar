package com.sharekarobar.daoimplementation;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharekarobar.dao.ShareHoldersPurchaseDao;
import com.sharekarobar.model.PurchaseModel;
import com.sharekarobar.model.PurchaseModel.PurchaseJoinKey;
import com.sharekarobar.model.ShareHolderModel;
import com.sharekarobar.model.TotalShareHoldersPurchase;

@Repository("shareHoldersPurchaseDao")
public class ShareholdersPurchaseDAOImpl implements ShareHoldersPurchaseDao {

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addPurchase(PurchaseModel purchase) {
		getSession().saveOrUpdate(purchase);
	}

	@Override
	public PurchaseModel getPurchase(int issueID, String username) {
		PurchaseJoinKey key = new PurchaseJoinKey(issueID, username);
		return getSession().get(PurchaseModel.class, key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PurchaseModel> getPurchase() {
		return (List<PurchaseModel>) getSession().createCriteria(PurchaseModel.class).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TotalShareHoldersPurchase> getShareholdersTotalPurchase() {

		List<TotalShareHoldersPurchase> purchaseList = new ArrayList<>();
		Query query = getSession().createQuery(
				"SELECT pm.purchaseKey.username, sum(pm.purchaseAmount) from PurchaseModel as pm GROUP BY pm.purchaseKey.username");
		List <Object> list = query.list();
		for (Object obj : list) {
			Object[] field = (Object[]) obj;
			ShareHolderModel shareholder = (ShareHolderModel) field[0];
			TotalShareHoldersPurchase purchase = new TotalShareHoldersPurchase(shareholder.getUsername(),
					Integer.parseInt(field[1].toString()));
			purchaseList.add(purchase);
		}
		return purchaseList;
	}
	
	@Override
	public int getShareholdersPurchase(String username) {
		Query query = getSession().createQuery("SELECT sum(pm.purchaseAmount) from PurchaseModel as pm WHERE pm.purchaseKey.username.username = ?");
		query.setParameter(0, username);
		int purchaseAmount = 0;
		purchaseAmount = ((Long)query.uniqueResult()).intValue();
		return purchaseAmount;
	}

	@Override
	public int getTotalAmount() {
		int total = 0;

		Query query = getSession().createQuery("SELECT sum(purchaseAmount) FROM PurchaseModel");
		if (query.uniqueResult() != null) {
			total = ((Long) query.uniqueResult()).intValue();
		}
		return total;
	}

}
