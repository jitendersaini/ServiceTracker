/**
 * 
 */
package com.accenture.tracker.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.UsersDAO;
import com.accenture.tracker.hibernate.domains.Tabs;
import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.util.AppUtils;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
@Configurable
public class UsersDAOImpl extends MyHibernateSessionFactory implements UsersDAO {

	@Override
	public String save(Users users) {
		if (null != users.getId()) {
			Users userstmp = getUserForEdit(users.getId());
			userstmp.setFirstName(users.getFirstName());
			userstmp.setLastName(users.getLastName());
			// userstmp.setEmail(users.getEmail());
			userstmp.setModifiedDate(new Date());
			users = userstmp;
		} else {
			if (findByUserName(users.getUsername())) {
				return "username";
			} else if (findByEmail(users.getEmail())) {
				return "email";
			}
			Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
			users.setPassword(passwordEncoder.encodePassword(
					users.getPassword(), null));
			users.setCreatedDate(new Date());
			users.setModifiedDate(new Date());
		}
		// users.setAccess(1);
		users.setDeleted(1);
		users.setEnabled(1);
		getSession().saveOrUpdate(users);
		return "save";
	}

	@SuppressWarnings("unchecked")
	private boolean findByUserName(String username) {
		List<Users> list = getSession()
				.createQuery("from Users where username = ?")
				.setParameter(0, username).list();
		return (list != null && list.size() == 0) ? false : true;
	}

	@SuppressWarnings("unchecked")
	private boolean findByEmail(String email) {
		List<Users> list = getSession()
				.createQuery("from Users where email = ?")
				.setParameter(0, email).list();
		return (list != null && list.size() == 0) ? false : true;
	}

	@SuppressWarnings("unchecked")
	public Users findByemail(String email) {
		List<Users> list = getSession()
				.createQuery("from Users where email = ?")
				.setParameter(0, email).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	public Users getUserForEdit(Long id) {
		List<Users> list = getSession().createQuery("from Users where id = ?")
				.setParameter(0, id).list();
		return list == null ? null : list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Users findByUsername(String username) {// System.out.println("username--> "+username);
		List<Users> list = getSession()
				.createQuery("from Users where username = ?")
				.setParameter(0, username).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Users findById(Long joinedId) {
		List<Users> list = getSession().createQuery("from Users where id = ?")
				.setParameter(0, joinedId).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@Override
	public void saveOrUpdate(Users usr) {
		getSession().saveOrUpdate(usr);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Users findByemailAndPasword(String email, String pwd) {
		List<Users> list = getSession()
				.createQuery("from Users where email = ? and password = ?")
				.setParameter(0, email).setParameter(1, pwd).list();
		return (list != null && list.size() == 0) ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tabs> fetchAllUsersTabs(Integer access) {
		if (access == 2) {
			access = 0;
		}
		return getSession().createQuery("from Tabs where access =?")
				.setParameter(0, access).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> search() {
		return getSession().createQuery("from Users where access in (:access)")
				.setParameterList("access", new Integer[] { 0, 2 }).list();
	}

	@Override
	public String saveEdited(Users users) {
		getSession().saveOrUpdate(users);
		return "saved_edited";
	}

	@Override
	public String disableUser(List<Users> list, Integer status) {
		for (Users user : list) {
			user.setEnabled(status);
			user.setModifiedDate(new Date());
			getSession().saveOrUpdate(user);
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> fetchAllUsersByIds(String id) {
		return getSession()
				.createQuery("from Users where id in (:ids)")
				.setParameterList("ids",
						AppUtils.convertToLongArray(id.split(","))).list();		
	}
}
