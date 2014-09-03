/**
 * 
 */
package com.accenture.tracker.dao;

import com.accenture.tracker.hibernate.domains.Users;



/**
 * @author j.saini
 *
 */
public interface PasswordDAO {	

	Users findByIdAndPasword(Long userid, String password);

	void saveOrUpdate(Users usr);
}
