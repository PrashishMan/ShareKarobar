package com.sharekarobar.dao;

import java.util.List;

import com.sharekarobar.model.ShareHolderModel;

public interface ShareHolderDao {
	public void addShareHolder(ShareHolderModel shareholder);
	public ShareHolderModel getShareHolder(String username);
	public List<ShareHolderModel> getShareHolder();
}
