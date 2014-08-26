/**
 * 
 */
package com.accenture.tracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */
@RequestMapping("/workenv")
@Controller
public class WorkEnvController {
	@RequestMapping(value = "/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model) {
		// model.addAttribute("", arg1)
		return AppConstants.WORKENV_PAGE;
	}
}
