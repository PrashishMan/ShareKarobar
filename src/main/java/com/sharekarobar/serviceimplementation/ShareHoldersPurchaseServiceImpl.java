package com.sharekarobar.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharekarobar.dao.ShareHoldersPurchaseDao;
import com.sharekarobar.model.PurchaseModel;
import com.sharekarobar.model.TotalShareHoldersPurchase;
import com.sharekarobar.services.ShareHoldersPurchaseService;

@Service("shareHolderPurchaseService")

@Transactional(propagation = Propagation.SUPPORTS)
public class ShareHoldersPurchaseServiceImpl implements ShareHoldersPurchaseService{
	
	@Autowired
	ShareHoldersPurchaseDao shareHoldersPurchaseDao;
	
	@Override
	public void addPurchase(PurchaseModel purchase) {
		shareHoldersPurchaseDao.addPurchase(purchase);
	}
	
	@Override
	public PurchaseModel getPurchase (int issueID, String username) {
		return shareHoldersPurchaseDao.getPurchase(issueID, username);
	}
	
	@Override
	public List<PurchaseModel> getPurchase() {
		return shareHoldersPurchaseDao.getPurchase();
	}

	@Override
	public List<TotalShareHoldersPurchase> getShareholdersTotalPurchase() {
		return shareHoldersPurchaseDao.getShareholdersTotalPurchase();
	}
	
	@Override
	public int getTotalAmount() {
		return shareHoldersPurchaseDao.getTotalAmount();		
	}

	@Override
	public int getShareholdersPurchase(String username) {
		return shareHoldersPurchaseDao.getShareholdersPurchase(username);
	}
	
}
