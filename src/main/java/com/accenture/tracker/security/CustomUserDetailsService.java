package com.accenture.tracker.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.service.UsersService;

@Transactional(readOnly = true)
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	protected static Logger logger = Logger.getLogger("service");

	@Autowired
	UsersService userService;

	/**
	 * Retrieves a user record containing the user's credentials and access.
	 */
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// Declare a null Spring User
		UserDetails user = null;
		try {
			Users dbUser = userService.findByUsername(username);

			if (null == dbUser) {
				dbUser = userService.findByemail(username);
			}

			if (null != dbUser) {
				boolean enabled = false;
				if (dbUser.getEnabled() != null && dbUser.getEnabled() == 1) {
					enabled = true;
				}
				user = new User(dbUser.getUsername(), dbUser.getPassword()
						.toLowerCase(), enabled, true, true, true,
						getAuthorities(dbUser.getAccess()));
			} else {
				throw new UsernameNotFoundException("Error in retrieving user");
			}

		} catch (Exception e) {
			logger.error("Error in retrieving user");
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return user;
	}

	/**
	 * Retrieves the correct ROLE type depending on the access level, where
	 * access level is an Integer. Basically, this interprets the access value
	 * whether it's for a regular user or admin.
	 * 
	 * @param access
	 *            an integer value representing the access of the user
	 * @return collection of granted authorities
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer access) {
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// Check if this user has admin access
		// We interpret Integer(1) as an admin user
		if (access.compareTo(1) == 0) {
			// User has admin access
			logger.debug("Grant ADMIN ACCESS to this user");
			authList.add(new SimpleGrantedAuthority("ADMIN"));
		} else if (access.compareTo(0) == 0) {
			// All users are granted with ROLE_USER access
			// Therefore this user gets a ROLE_USER by default
			logger.debug("Grant USER ACCESS to this user");
			authList.add(new SimpleGrantedAuthority("USER"));
		} else if (access.compareTo(2) == 0) {
			// All users are granted with ROLE_USER access
			// Therefore this user gets a ROLE_USER by default
			logger.debug("Grant VIEWER ACCESS to this user");
			authList.add(new SimpleGrantedAuthority("VIEWER"));
		}

		// Return list of granted authorities
		return authList;
	}
}