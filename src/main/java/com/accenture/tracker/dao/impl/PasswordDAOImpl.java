/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.PasswordDAO;
import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class PasswordDAOImpl extends MyHibernateSessionFactory implements
		PasswordDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Users findByIdAndPasword(Long userid, String password) {
		List<Users> list = getSession().createQuery("from Users where id = ? and password = ?")
				.setParameter(0, userid).setParameter(1, password).list();
		if(!list.isEmpty()) {
			return (Users)list.get(0);	
		} else {
			return null;
		}
	}

	@Override
	public void saveOrUpdate(Users usr) {
		getSession().saveOrUpdate(usr);
	}

}
