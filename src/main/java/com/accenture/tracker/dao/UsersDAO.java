/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Tabs;
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

	List<Tabs> fetchAllUsersTabs(Integer access);

	List<Users> search();

	String saveEdited(Users users);

	String disableUser(List<Users> list, Integer status);

	List<Users> fetchAllUsersByIds(String id);

}
