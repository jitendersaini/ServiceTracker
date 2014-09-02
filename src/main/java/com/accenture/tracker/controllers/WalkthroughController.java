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

import com.accenture.tracker.hibernate.domains.Walkthrough;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.WalkthroughService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class WalkthroughController {

	@Autowired
	private WalkthroughService walkthroughService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/walkthrough/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.WALKTHROUGH_LIST;
	}

	@RequestMapping(value = "/walkthrough/action", params = { "create" })
	public String createForm(Model model,HttpServletRequest request) {
		model.addAttribute("title", "Create New Walkthrough Entry");
		model.addAttribute("attr", "walkthrough");
		model.addAttribute("walkthrough", new Walkthrough());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				walkthroughService.fetchAllOperations());
		model.addAttribute("listPriorities", walkthroughService.fetchAllPriorites());

		model.addAttribute("listStatus", walkthroughService.fetchAllStatus());

		return AppConstants.WALKTHROUGH_CREATE;
	}

	@RequestMapping(value = "/walkthrough/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		walkthroughService.remove(id);
		return "";
	}

	@RequestMapping(value = "/walkthrough/action", params = { "edit" })
	public String editForm(ModelMap model, Walkthrough walkthrough,
			HttpServletRequest request) {

		walkthrough = walkthroughService.fetchById(walkthrough.getId());

		model.addAttribute("title", "Edit Walkthrough Entry");
		model.addAttribute("attr", "walkthrough");
		model.addAttribute("walkthrough", walkthrough);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				walkthroughService.fetchAllOperations());

		model.addAttribute("listPriorities", walkthroughService.fetchAllPriorites());

		model.addAttribute("listStatus", walkthroughService.fetchAllStatus());

		return AppConstants.WALKTHROUGH_EDIT;
	}

	@RequestMapping(value = "/walkthrough/action", params = { "save" })
	public String saveForm(Walkthrough walkthrough) {
		walkthroughService.save(walkthrough);
		return AppConstants.WALKTHROUGH_DATA;
	}

	@RequestMapping(value = "/walkthrough/action", params = { "search" })
	public String search(Model model,HttpServletRequest request) {
		model.addAttribute("listData", walkthroughService.search(request.getSession()
				.getAttribute("project").toString()));
		return AppConstants.WALKTHROUGH_DATA;
	}
}
