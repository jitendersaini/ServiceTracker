/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.WalkthroughDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.Walkthrough;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class WalkthroughDAOImpl extends MyHibernateSessionFactory implements WalkthroughDAO {


	@SuppressWarnings("unchecked")
	@Override
	public List<Operations> fetchAllOperations() {
		return getSession().createQuery("from Operations").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Walkthrough> search(String projectid) {
		return getSession().createQuery("from Walkthrough where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list();
	}

	@Override
	public void save(Walkthrough walkthrough) {
		getSession().saveOrUpdate(walkthrough);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Walkthrough fetchById(Long id) {
		List<Walkthrough> list = getSession().createQuery("from Walkthrough where id = ?")
				.setParameter(0, id).list();
		return list.get(0);
	}

	@Override
	public void remove(String id) {
		getSession()
				.createQuery("delete from Walkthrough where id in (:ids)")
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
