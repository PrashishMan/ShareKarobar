package com.sharekarobar.services;

import java.util.List;

import com.sharekarobar.model.ShareModel;

public interface ShareService {
	public void addShare(ShareModel share);
	public ShareModel getShare(int issueId);
	public List<ShareModel> getShare();
	public int getTotalShare();
	public int getLatestIssueId();
}
