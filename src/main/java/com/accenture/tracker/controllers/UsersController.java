/**
 * 
 */
package com.accenture.tracker.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.UsersService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/admin")
public class UsersController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private ProjectsService projectsService;

	@RequestMapping(value = "/usrs/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.USERS_LIST;
	}

	@RequestMapping(value = "/usrs/action", params = { "create" })
	public String createForm(Model model) {
		model.addAttribute("title", "Create New User / Viewer");
		model.addAttribute("attr", "users");
		Map<Integer, String> mapGender = new HashMap<Integer, String>();
		mapGender.put(0, "Male");
		mapGender.put(1, "Female");

		Map<Integer, String> mapAccess = new HashMap<Integer, String>();
		mapAccess.put(0, "User");
		mapAccess.put(2, "Viewer");
		mapAccess.put(1, "Super Admin");

		model.addAttribute("mapAccess", mapAccess);
		model.addAttribute("rdoValues", mapGender);
		model.addAttribute("users", new Users());
		model.addAttribute("projectsList", projectsService.searchForUsersReg());
		return AppConstants.USERS_CREATE;
	}

	
	@RequestMapping(value = "/usrs/action", params = { "disable" })
	public @ResponseBody String disableUser(Model model, String id) {
		return  usersService.disableEnableUser(id,0);	
	}
	
	@RequestMapping(value = "/usrs/action", params = { "enable" })
	public @ResponseBody String enableUser(Model model, String id) {
		return  usersService.disableEnableUser(id,1);	
	}
	  
	@RequestMapping(value = "/usrs/action", params = { "edit" })
	public String editForm(Model model, Users users,
			HttpServletRequest request) {

		users = usersService.findById(users.getId());

		model.addAttribute("title", "Edit User");
		model.addAttribute("attr", "users");
		Map<Integer, String> mapGender = new HashMap<Integer, String>();
		mapGender.put(0, "Male");
		mapGender.put(1, "Female");

		Map<Integer, String> mapAccess = new HashMap<Integer, String>();
		mapAccess.put(0, "User");
		mapAccess.put(2, "Viewer");
		mapAccess.put(1, "Super Admin");

		model.addAttribute("mapAccess", mapAccess);
		model.addAttribute("rdoValues", mapGender);
		model.addAttribute("users", users);
		model.addAttribute("projectsList", projectsService.searchForUsersReg());
		
		return AppConstants.USERS_EDIT;
	}
	 
	@RequestMapping(value = "/usrs/action", params = { "save" })
	public @ResponseBody String saveForm(Users users, HttpServletRequest request) {
		return usersService.save(users);		
	}

	@RequestMapping(value = "/usrs/action", params = { "search" })
	public String search(Model model) {
		model.addAttribute("listData", usersService.search());
		return AppConstants.USERS_DATA;
	}
}
