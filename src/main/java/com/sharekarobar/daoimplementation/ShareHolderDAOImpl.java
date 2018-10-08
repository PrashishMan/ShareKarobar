package com.sharekarobar.daoimplementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sharekarobar.dao.ShareHolderDao;
import com.sharekarobar.model.ShareHolderModel;

@Repository("shareHolderDao")
public class ShareHolderDAOImpl implements ShareHolderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
			return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public void addShareHolder(ShareHolderModel shareholder) {
		getSession().saveOrUpdate(shareholder);
	}

	@Override
	public ShareHolderModel getShareHolder(String username) {
		return (ShareHolderModel)getSession().get(ShareHolderModel.class, username);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShareHolderModel> getShareHolder() {
		return 	(List<ShareHolderModel>)getSession().createCriteria(ShareHolderModel.class).list();
				//(List<ShareHolderModel>)getSession().createQuery("FROM ShareHolders").list();
	}
	
}
