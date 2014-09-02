/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.OperationsDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class OperationsDAOImpl extends MyHibernateSessionFactory implements
		OperationsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Operations> search() {
		return getSession().createQuery("from Operations").list();
	}

	@Override
	public void save(Operations operations) {
		getSession().saveOrUpdate(operations);
	}

	@Override
	public Operations fetchById(Long id) {
		return (Operations) getSession().createQuery("from Operations where id=?")
				.setParameter(0, id).list().get(0);
	}

	@Override
	public void remove(String id) {
		getSession()
		.createQuery("delete from Operations where id in (:ids)")
		.setParameterList("ids",
				AppUtils.convertToLongArray(id.split(",")))
		.executeUpdate();
	}

}
