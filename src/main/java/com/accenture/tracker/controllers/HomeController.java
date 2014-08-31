/**
 * 
 */
package com.accenture.tracker.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.service.UsersService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */
@Controller
public class HomeController {
	
	@Autowired
	private UsersService usersService;

	@RequestMapping("/_dashboard")
	public String homePage(HttpServletRequest request, Model model) {
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
			request.getSession().setAttribute("access", usr.getAccess());
			model.addAttribute("tabs", usersService.fetchAllUsersTabs(usr.getAccess()));
		}
		return AppConstants.USERS_VIEWERS;
		// return model;

	}
	
	@RequestMapping("/_admin")
	public String adminPage(HttpServletRequest request, Model model) {
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
			model.addAttribute("tabs", usersService.fetchAllUsersTabs(usr.getAccess()));
			
		}
		return AppConstants.ADMIN;
	}
	
	@RequestMapping("/403")
	public String noAccessPage(HttpServletRequest request) {
		return AppConstants.NO_ACCESS;
	}
	
		
}
