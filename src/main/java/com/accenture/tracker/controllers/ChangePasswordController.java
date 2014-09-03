/**
 * 
 */
package com.accenture.tracker.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.tracker.model.ChangePassword;
import com.accenture.tracker.service.PasswordService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/settings")
public class ChangePasswordController {

	@Autowired
	private PasswordService passwordService;

	@RequestMapping(value = "/password/action", params = { "change" })
	public String createForm(Model model) {
		model.addAttribute("title", "Change Password");
		model.addAttribute("attr", "password");
		model.addAttribute("password", new ChangePassword());
		return AppConstants.PASSWORD_CHANGE;
	}

	@RequestMapping(value = "/password/action", params = { "save" })
	public @ResponseBody String saveForm(ChangePassword password, HttpServletRequest request) {
		return passwordService.save(
				password,
				Long.valueOf(request.getSession().getAttribute("login_id")
						.toString()));		
	}
}
