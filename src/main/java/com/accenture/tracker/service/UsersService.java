/**
 * 
 */
package com.accenture.tracker.service;

import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.model.ChangePassword;


/**
 * @author j.saini
 *
 */
public interface UsersService {

	String save(Users users);

	Users findByUsername(String username);

	Users findByemail(String username);

	Users findById(Long joinedId);

	Integer savePasswordChanged(ChangePassword cp, String email);

	int resetAndSavePassword(String email);

}
