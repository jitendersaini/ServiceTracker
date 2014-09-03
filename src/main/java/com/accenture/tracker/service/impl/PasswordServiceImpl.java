/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.PasswordDAO;
import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.model.ChangePassword;
import com.accenture.tracker.service.PasswordService;

/**
 * @author j.saini
 * 
 */
@Service
public class PasswordServiceImpl implements PasswordService {

	@Autowired
	PasswordDAO passwordDAO;

	@Override
	public String save(ChangePassword cp, Long userid) {
		System.out.println("cp.getPassword(): "+cp.getPassword());
		Md5PasswordEncoder passwordEncoder = new Md5PasswordEncoder();
		cp.setPassword(passwordEncoder.encodePassword(cp.getPassword(), null));
		cp.setNewpassword(passwordEncoder.encodePassword(cp.getNewpassword(),
				null));
		Users usr = passwordDAO.findByIdAndPasword(userid, cp.getPassword());
		if (null != usr) {
			usr.setPassword(cp.getNewpassword());
			usr.setModifiedDate(new Date());
			passwordDAO.saveOrUpdate(usr);
			return "1";
		} else {
			return "0";
		}
	}

}
