/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.UsersDAO;
import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.model.ChangePassword;
import com.accenture.tracker.service.UsersService;

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

		return usersDao.save(users);
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

}
