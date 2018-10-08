package com.sharekarobar.dao;

import java.util.List;

import com.sharekarobar.model.ShareModel;

public interface ShareDao {
	public void addShare(ShareModel shares);
	public ShareModel getShare(int issueId);
	public List<ShareModel> getShare();
	public int getTotalShare();
	public int getLatestIssueId();
}
