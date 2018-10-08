package com.sharekarobar.dao;

import java.util.List;

import com.sharekarobar.model.PurchaseModel;
import com.sharekarobar.model.TotalShareHoldersPurchase;

public interface ShareHoldersPurchaseDao {
	public void addPurchase(PurchaseModel purchase);
	public PurchaseModel getPurchase(int issueID, String username);
	public List<PurchaseModel> getPurchase();
	public List<TotalShareHoldersPurchase> getShareholdersTotalPurchase();
	public int getTotalAmount();
	public int getShareholdersPurchase(String username);
}
