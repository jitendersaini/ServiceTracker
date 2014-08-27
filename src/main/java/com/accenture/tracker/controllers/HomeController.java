/**
 * 
 */
package com.accenture.tracker.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.service.UsersService;

/**
 * @author j.saini
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping("/_dashboard")
	public String homePage(HttpServletRequest request) {
		if (request.getSession(false) == null
				|| SecurityContextHolder.getContext().getAuthentication() == null) {
			return "redirect:/login";
		}
		if (request.getSession().getAttribute("userid") == null) {
			Users usr = usersService.findByUsername(SecurityContextHolder
					.getContext().getAuthentication().getName());
						
			request.getSession().setAttribute("email", usr.getEmail());
			request.getSession().setAttribute("firstName", usr.getFirstName());
			request.getSession().setAttribute("lastName", usr.getLastName());			
			request.getSession().setAttribute("login_id", usr.getId());
			
		}
		return "dashboard-page/dashboard";
		// return model;

	}
}
