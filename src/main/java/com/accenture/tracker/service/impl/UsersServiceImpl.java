/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.UsersDAO;
import com.accenture.tracker.hibernate.domains.Tabs;
import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.json.DataObjectUser;
import com.accenture.tracker.model.ChangePassword;
import com.accenture.tracker.service.UsersService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
@Configurable
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDAO usersDao;

	@Override
	public String save(Users users) {
		if(users != null && users.getId() == null) {
			return usersDao.save(users);
		} else {
			Users usrs = usersDao.findById(users.getId());			
			users.setCreatedDate(usrs.getCreatedDate());
			users.setModifiedDate(new Date());
			users.setDeleted(usrs.getDeleted());
			users.setPassword(usrs.getPassword());
			users.setEnabled(usrs.getEnabled());
			return usersDao.saveEdited(users);
		}
	}

	@Override
	public Users findByUsername(String username) {
		return usersDao.findByUsername(username);
	}

	@Override
	public Users findByemail(String username) {

		return usersDao.findByemail(username);
	}

	@Override
	public Users findById(Long joinedId) {
		return usersDao.findById(joinedId);
	}

	@Override
	public Integer savePasswordChanged(ChangePassword cp, String email) {
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		cp.setPassword(passwordEncoder.encodePassword(cp.getPassword(), null));
		cp.setNewpassword(passwordEncoder.encodePassword(cp.getNewpassword(),
				null));
		Users usr = usersDao.findByemailAndPasword(email, cp.getPassword());
		if (null != usr) {
			usr.setPassword(cp.getNewpassword());
			usr.setModifiedDate(new Date());
			usersDao.saveOrUpdate(usr);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int resetAndSavePassword(String email) {
		Users user = usersDao.findByemail(email);
		if (null == user) {
			return 0;
		} else {

			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(100000);

			Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
			user.setPassword(passwordEncoder.encodePassword(randomInt + "",
					null));

			usersDao.saveOrUpdate(user);
			return randomInt;
		}
	}

	@Override
	public List<Tabs> fetchAllUsersTabs(Integer access) {		
		return usersDao.fetchAllUsersTabs(access);
	}

	@Override
	public List<Users> search() {
		return usersDao.search();
	}

	@Override
	public String disableEnableUser(String id, Integer status) {
		List<Users> list = usersDao.fetchAllUsersByIds(id);
		return usersDao.disableUser(list,status);		
	}

	@Override
	public List<DataObjectUser> searchForJson() {
		List<Users> listUsers = usersDao.search();

		List<DataObjectUser> list = new ArrayList<DataObjectUser>();

		DataObjectUser doj = null;

		for (Users object : listUsers) {
			doj = new DataObjectUser();
			doj.setId(object.getId().toString());
			doj.setUsername(object.getUsername());
			doj.setCreatedDate(AppConstants.convertDateWithTime(object.getCreatedDate()));
			doj.setModifiedDate(AppConstants.convertDateWithTime(object.getModifiedDate()));
			doj.setEmail(object.getEmail());
			doj.setProject(object.getProjects().getProjectName());
			if(object.getEnabled() == 1) {
				doj.setStatus("ENABLED");	
			}
			else if(object.getEnabled() == 0) {
				doj.setStatus("DISABLED");	
			} else {
				doj.setStatus("N/A");
			}
			list.add(doj);
		}
		return list;
	}
}
