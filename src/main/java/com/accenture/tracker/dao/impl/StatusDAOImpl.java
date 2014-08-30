/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.StatusDAO;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class StatusDAOImpl extends MyHibernateSessionFactory implements
		StatusDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Status> search() {
		return getSession().createQuery("from Status").list();
	}

	@Override
	public void save(Status status) {
		getSession().saveOrUpdate(status);
	}

	@Override
	public Status fetchById(Long id) {
		return (Status) getSession().createQuery("from Status where id=?")
				.setParameter(0, id).list().get(0);
	}

	@Override
	public void remove(String id) {
		getSession()
				.createQuery("delete from Status where id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(id.split(",")))
				.executeUpdate();
	}

}
