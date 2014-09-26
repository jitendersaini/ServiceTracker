/**
 * 
 */
package com.accenture.tracker.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.SqlDao;
import com.accenture.tracker.hibernate.domains.SqlObject;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class SqlDAOImpl extends MyHibernateSessionFactory implements SqlDao {

	@SuppressWarnings("unchecked")
	@Override
	public SqlObject fetchAll() {
		SqlObject sqlObject = new SqlObject();
		sqlObject.setListAccess(getSession().createQuery("from AoAccess").list());
		sqlObject.setListCodeFreeze(getSession().createQuery("from CodeFreeze").list());
		sqlObject.setListKT(getSession().createQuery("from KT").list());
		sqlObject.setListPGLS(getSession().createQuery("from PGLS").list());
		sqlObject.setListPT(getSession().createQuery("from ProcessAndTools").list());
		sqlObject.setListRehearsal(getSession().createQuery("from Rehearsal").list());
		sqlObject.setListRelease(getSession().createQuery("from Release").list());
		sqlObject.setListSupportScope(getSession().createQuery("from SupportScope").list());
		sqlObject.setListTesting(getSession().createQuery("from Testing").list());
		sqlObject.setListThirdParty(getSession().createQuery("from ThirdParty").list());
		sqlObject.setListWalk(getSession().createQuery("from Walkthrough").list());
		sqlObject.setListWorkEnv(getSession().createQuery("from WorkEnvironment").list());
		return sqlObject;
	}

	

}
