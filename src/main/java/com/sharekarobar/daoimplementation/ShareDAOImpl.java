package com.sharekarobar.daoimplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sharekarobar.dao.ShareDao;
import com.sharekarobar.model.ShareModel;

@Repository("shareDao")
public class ShareDAOImpl implements ShareDao{

	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addShare(ShareModel shares) {
		getSession().saveOrUpdate(shares);

	}

	@Override
	public ShareModel getShare(int issueId) {
		return (ShareModel) getSession().get(ShareModel.class, issueId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShareModel> getShare() {
		return (List<ShareModel>) getSession().createCriteria(ShareModel.class).list();
		//(List<ShareModel>)getSession().createQuery("FROM ShareModel").list();
	}

	@Override
	public int getTotalShare() {
		int totalShare = 0;

		Long query = ((Long)getSession().createQuery("SELECT sum(issuedAmount) FROM ShareModel").uniqueResult());
		if (query != null) {
			totalShare = (Integer)query.intValue();
		}

		return totalShare;
	}
	
	@Override
	public int getLatestIssueId() {
		int latestIssueId = -1;
		Integer query = ((Integer)getSession().createQuery("SELECT max(issueID) FROM ShareModel").uniqueResult());
		if(query != null) {
			latestIssueId = (Integer)query.intValue();
		}
		return latestIssueId;
	}

}
