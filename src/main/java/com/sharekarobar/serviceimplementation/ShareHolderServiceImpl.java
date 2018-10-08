package com.sharekarobar.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sharekarobar.dao.ShareHolderDao;
import com.sharekarobar.model.ShareHolderModel;
import com.sharekarobar.services.ShareHolderService;

@Service("shareHolderService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly = true)
public class ShareHolderServiceImpl implements ShareHolderService{
	@Autowired
	ShareHolderDao shareholderDao;
	
	@Override
	@Transactional(propagation=Propagation.SUPPORTS, readOnly = false)
	public void addShareHolder(ShareHolderModel shareholder) {
		shareholderDao.addShareHolder(shareholder);
	}

	@Override
	public List<ShareHolderModel> getShareHolder() {
		return shareholderDao.getShareHolder();
	}

	@Override
	public ShareHolderModel getShareHolder(String username) {
		return shareholderDao.getShareHolder(username);
	}
	
}
