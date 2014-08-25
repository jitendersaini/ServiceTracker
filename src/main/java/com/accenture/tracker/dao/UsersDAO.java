/**
 * 
 */
package com.accenture.tracker.dao;

import com.accenture.tracker.hibernate.domains.Users;

/**
 * @author j.saini
 *
 */
public interface UsersDAO {

	String save(Users users);

	Users findByUsername(String username);

	Users findByemail(String username);

	Users findById(Long joinedId);

	void saveOrUpdate(Users usr);

	Users findByemailAndPasword(String email, String pwd);
}
