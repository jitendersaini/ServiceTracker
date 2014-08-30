/**
 * 
 */
package com.accenture.tracker.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.StatusService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/admin")
public class StatusController {

	@Autowired
	private StatusService statusService;

	@RequestMapping(value = "/status/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.STATUS_LIST;
	}

	@RequestMapping(value = "/status/action", params = { "create" })
	public String createForm(Model model) {
		model.addAttribute("title", "Create New Status");
		model.addAttribute("attr", "status");
		model.addAttribute("status", new Status());
		return AppConstants.STATUS_CREATE;
	}

	@RequestMapping(value = "/status/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		statusService.remove(id);
		return "";
	}

	@RequestMapping(value = "/status/action", params = { "edit" })
	public String editForm(Model model, Status status,
			HttpServletRequest request) {

		status = statusService.fetchById(status.getId());

		model.addAttribute("title", "Edit Status");
		model.addAttribute("attr", "status");
		model.addAttribute("status", status);
		return AppConstants.STATUS_EDIT;
	}

	@RequestMapping(value = "/status/action", params = { "save" })
	public String saveForm(Status status, HttpServletRequest request) {
		statusService.save(
				status,
				Long.valueOf(request.getSession().getAttribute("login_id")
						.toString()));
		return AppConstants.STATUS_DATA;
	}

	@RequestMapping(value = "/status/action", params = { "search" })
	public String search(Model model) {
		model.addAttribute("listData", statusService.search());
		return AppConstants.STATUS_DATA;
	}
}
