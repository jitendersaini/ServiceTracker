/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.ProjectsDAO;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class ProjectsDAOImpl extends MyHibernateSessionFactory implements
		ProjectsDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Projects> search() {
		return getSession().createQuery("from Projects").list();
	}

	@Override
	public void save(Projects projects) {
		getSession().saveOrUpdate(projects);
	}

	@Override
	public Projects fetchById(Long id) {
		return (Projects) getSession().createQuery("from Projects where id=?")
				.setParameter(0, id).list().get(0);
	}

	@Override
	public void remove(String id) {
		getSession()
		.createQuery("delete from Projects where id in (:ids)")
		.setParameterList("ids",
				AppUtils.convertToLongArray(id.split(",")))
		.executeUpdate();
	}

}
