/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Tabs;
import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.json.DataObjectUser;
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

	List<Tabs> fetchAllUsersTabs(Integer access);

	List<Users> search();

	String disableEnableUser(String id, Integer status);

	List<DataObjectUser> searchForJson();
}
