/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.RehearsalDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Rehearsal;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class RehearsalDAOImpl extends MyHibernateSessionFactory implements RehearsalDAO {

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
	public List<Rehearsal> search() {
		return getSession().createQuery("from Rehearsal").list();
	}

	@Override
	public void save(Rehearsal rh) {
		getSession().saveOrUpdate(rh);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Rehearsal fetchById(Long id) {
		List<Rehearsal> list = getSession().createQuery("from Rehearsal where id = ?")
				.setParameter(0, id).list();
		return list.get(0);
	}

	@Override
	public void remove(String id) {
		getSession()
				.createQuery("delete from Rehearsal where id in (:ids)")
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
