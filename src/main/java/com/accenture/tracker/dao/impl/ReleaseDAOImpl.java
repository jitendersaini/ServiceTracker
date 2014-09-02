/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.ReleaseDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Release;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class ReleaseDAOImpl extends MyHibernateSessionFactory implements ReleaseDAO {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Operations> fetchAllOperations() {
		return getSession().createQuery("from Operations").list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Release> search(String projectid) {
		return getSession().createQuery("from Release where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list();
	}

	@Override
	public void save(Release release) {
		getSession().saveOrUpdate(release);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Release fetchById(Long id) {
		List<Release> list = getSession().createQuery("from Release where id = ?")
				.setParameter(0, id).list();
		return list.get(0);
	}

	@Override
	public void remove(String id) {
		getSession()
				.createQuery("delete from Release where id in (:ids)")
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
