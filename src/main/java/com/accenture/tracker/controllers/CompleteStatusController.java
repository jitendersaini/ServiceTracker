/**
 * 
 */
package com.accenture.tracker.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.tracker.service.AOService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class CompleteStatusController {

	@Autowired
	private AOService aOService;

	@RequestMapping(value = "/completestatus/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.COMPLETE_STATUS_LIST;
	}
}
