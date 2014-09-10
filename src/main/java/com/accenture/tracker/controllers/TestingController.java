/**
 * 
 */
package com.accenture.tracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.tracker.hibernate.domains.Testing;
import com.accenture.tracker.json.DataList;
import com.accenture.tracker.json.DataObject;
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

	@RequestMapping(value = "/testing/action", params = { "create" }, method = RequestMethod.POST)
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

	@RequestMapping(value = "/testing/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		testingService.remove(id);
		return "";
	}

	@RequestMapping(value = "/testing/action", params = { "edit" }, method = RequestMethod.POST)
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

	@RequestMapping(value = "/testing/action", params = { "save" }, method = RequestMethod.POST)
	public String saveForm(Testing testing) {
		testingService.save(testing);
		return AppConstants.TESTING_DATA;
	}

	/*@RequestMapping(value = "/testing/action", params = { "search" }, method = RequestMethod.POST)
	public String search(Model model, HttpServletRequest request) {
		model.addAttribute(
				"listData",
				testingService.search(request.getSession()
						.getAttribute("project").toString()));
		return AppConstants.TESTING_DATA;
	}*/
	
	@RequestMapping(value = "/testing/action", params = { "search" }, method = RequestMethod.GET, headers = "Accept= application/json", produces = "application/json")
	public @ResponseBody DataList search(Model model, HttpServletRequest request) {		
		// Call service here
		DataList result = new DataList();
		List<DataObject> list = testingService.searchForJson(request.getSession()
				.getAttribute("project").toString());		
		result.setData(list);

		return result;

	}
}
