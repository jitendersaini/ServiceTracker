/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.TestingDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.Testing;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class TestingDAOImpl extends MyHibernateSessionFactory implements TestingDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Projects> fetchAllProjects() {
		return getSession().createQuery("from Projects").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Operations> fetchAllOperations() {
		return getSession().createQuery("from Operations").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Testing> search() {
		return getSession().createQuery("from Testing").list();
	}

	@Override
	public void save(Testing testing) {
		getSession().saveOrUpdate(testing);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Testing fetchById(Long id) {
		List<Testing> list = getSession().createQuery("from Testing where id = ?")
				.setParameter(0, id).list();
		return list.get(0);
	}

	@Override
	public void remove(String id) {
		getSession()
				.createQuery("delete from Testing where id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(id.split(",")))
				.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Priorities> fetchAllPriorites() {
		return getSession().createQuery("from Priorities").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Status> fetchAllStatus() {
		return getSession().createQuery("from Status").list();
	}

}
