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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.tracker.hibernate.domains.WorkEnvironment;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.WorkEnvService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class WorkEnvController {

	@Autowired
	private WorkEnvService workEnvService;

	@Autowired
	private ProjectsService projectService;
	
	@RequestMapping(value = "/workenv/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.WORKENV_LIST;
	}

	@RequestMapping(value = "/workenv/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Create New Work Env. Entry");
		model.addAttribute("attr", "work");
		model.addAttribute("work", new WorkEnvironment());
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				workEnvService.fetchAllOperations());
		model.addAttribute("listPriorities", workEnvService.fetchAllPriorites());

		model.addAttribute("listStatus", workEnvService.fetchAllStatus());

		return AppConstants.WORKENV_CREATE;
	}

	@RequestMapping(value = "/workenv/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		workEnvService.remove(id);
		return "";
	}

	@RequestMapping(value = "/workenv/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(ModelMap model, WorkEnvironment workEnvironment,
			HttpServletRequest request) {

		workEnvironment = workEnvService.fetchById(workEnvironment.getId());

		model.addAttribute("title", "Edit Work Env. Entry");
		model.addAttribute("attr", "work");
		model.addAttribute("work", workEnvironment);
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				workEnvService.fetchAllOperations());

		model.addAttribute("listPriorities", workEnvService.fetchAllPriorites());

		model.addAttribute("listStatus", workEnvService.fetchAllStatus());

		return AppConstants.WORKENV_EDIT;
	}

	@RequestMapping(value = "/workenv/action", params = { "save" }, method = RequestMethod.POST)
	public String saveForm(WorkEnvironment workEnvironment) {
		workEnvService.save(workEnvironment);
		return AppConstants.WORKENV_DATA;
	}

	@RequestMapping(value = "/workenv/action", params = { "search" }, method = RequestMethod.POST)
	public String search(Model model, HttpServletRequest request) {
		model.addAttribute(
				"listData",
				workEnvService.search(request.getSession()
						.getAttribute("project").toString()));
		return AppConstants.WORKENV_DATA;
	}
}
