package com.sharekarobar.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharekarobar.dao.ShareDao;
import com.sharekarobar.model.ShareModel;
import com.sharekarobar.services.ShareService;

@Service("shareService")
@Transactional(propagation=Propagation.SUPPORTS)
public class ShareServiceImpl implements ShareService{

	@Autowired
	private ShareDao shareDao;
	
	@Override
	public void addShare(ShareModel share) {
		shareDao.addShare(share);
	}

	@Override
	public ShareModel getShare(int issueId) {
		return shareDao.getShare(issueId);
	}

	@Override
	public List<ShareModel> getShare() {
		return shareDao.getShare();
	}

	@Override
	public int getTotalShare() {
		return shareDao.getTotalShare();
	}

	@Override
	public int getLatestIssueId() {
		return shareDao.getLatestIssueId();
	}
	
	
}
