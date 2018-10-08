package com.sharekarobar.services;

import java.util.List;

import com.sharekarobar.model.ShareHolderModel;

public interface ShareHolderService {
	public void addShareHolder(ShareHolderModel shareholder);
	public List<ShareHolderModel> getShareHolder();
	public ShareHolderModel getShareHolder(String username);
}
