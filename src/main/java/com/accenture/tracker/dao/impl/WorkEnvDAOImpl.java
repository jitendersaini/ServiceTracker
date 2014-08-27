/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.WorkEnvDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.WorkEnvironment;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class WorkEnvDAOImpl extends MyHibernateSessionFactory implements
		WorkEnvDAO {

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
	public List<WorkEnvironment> search() {
		return getSession().createQuery("from WorkEnvironment").list();
	}

	@Override
	public void save(WorkEnvironment workEnvironment) {
		getSession().save(workEnvironment);
	}

}
