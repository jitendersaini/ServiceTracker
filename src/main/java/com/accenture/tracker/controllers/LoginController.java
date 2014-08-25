/**
 * 
 */
package com.accenture.tracker.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.tracker.hibernate.domains.Users;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */
@Controller
public class LoginController {
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");;
		model.setViewName(AppConstants.LOGIN_PAGE);
		return model;

	}
	
	@RequestMapping(value = { "/signup"}, method = RequestMethod.GET)
	public String signUp(Model model) {
		
		//ModelAndView model = new ModelAndView();
		model.addAttribute("title", "Sign UP");
		model.addAttribute("user", new Users());
		List<String> list = new ArrayList<String>();
		list.add("Male");
		list.add("Female");
		model.addAttribute("rdoValues", list);
		//model.addObject("message", "This is welcome page!");		
		return "signup-page/signup";

	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been loggeddddd out successfully.");
		}		
		model.setViewName(AppConstants.LOGIN_PAGE);

		return model;

	}
}
