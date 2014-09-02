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

import com.accenture.tracker.hibernate.domains.Testing;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.TestingService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class TestingController {

	@Autowired
	private TestingService testingService;

	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/testing/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.TESTING_LIST;
	}

	@RequestMapping(value = "/testing/action", params = { "create" })
	public String createForm(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Create New Testing Entry");
		model.addAttribute("attr", "testing");
		model.addAttribute("testing", new Testing());
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				testingService.fetchAllOperations());
		model.addAttribute("listPriorities", testingService.fetchAllPriorites());

		model.addAttribute("listStatus", testingService.fetchAllStatus());

		return AppConstants.TESTING_CREATE;
	}

	@RequestMapping(value = "/testing/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		testingService.remove(id);
		return "";
	}

	@RequestMapping(value = "/testing/action", params = { "edit" })
	public String editForm(ModelMap model, Testing testing,
			HttpServletRequest request) {

		testing = testingService.fetchById(testing.getId());

		model.addAttribute("title", "Edit Testing Entry");
		model.addAttribute("attr", "testing");
		model.addAttribute("testing", testing);
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				testingService.fetchAllOperations());

		model.addAttribute("listPriorities", testingService.fetchAllPriorites());

		model.addAttribute("listStatus", testingService.fetchAllStatus());

		return AppConstants.TESTING_EDIT;
	}

	@RequestMapping(value = "/testing/action", params = { "save" })
	public String saveForm(Testing testing) {
		testingService.save(testing);
		return AppConstants.TESTING_DATA;
	}

	@RequestMapping(value = "/testing/action", params = { "search" })
	public String search(Model model, HttpServletRequest request) {
		model.addAttribute(
				"listData",
				testingService.search(request.getSession()
						.getAttribute("project").toString()));
		return AppConstants.TESTING_DATA;
	}
}
