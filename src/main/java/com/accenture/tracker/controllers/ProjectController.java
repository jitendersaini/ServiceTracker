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

import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/admin")
public class ProjectController {

	@Autowired
	private ProjectsService projectsService;

	@RequestMapping(value = "/projects/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.PROJECTS_LIST;
	}

	@RequestMapping(value = "/projects/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model) {
		model.addAttribute("title", "Create New Project");
		model.addAttribute("attr", "project");
		model.addAttribute("project", new Projects());
		return AppConstants.PROJECTS_CREATE;
	}

	@RequestMapping(value = "/projects/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		projectsService.remove(id);
		return "";
	}

	@RequestMapping(value = "/projects/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(Model model, Projects projects,
			HttpServletRequest request) {

		projects = projectsService.fetchById(projects.getId());

		model.addAttribute("title", "Edit Projects");
		model.addAttribute("attr", "projects");
		model.addAttribute("projects", projects);
		return AppConstants.PROJECTS_EDIT;
	}

	@RequestMapping(value = "/projects/action", params = { "save" }, method = RequestMethod.POST)
	public String saveForm(Projects projects, HttpServletRequest request) {
		projectsService.save(
				projects,
				Long.valueOf(request.getSession().getAttribute("login_id")
						.toString()));
		return AppConstants.PROJECTS_DATA;
	}

	@RequestMapping(value = "/projects/action", params = { "search" }, method = RequestMethod.POST)
	public String search(Model model) {
		model.addAttribute("listData", projectsService.search());
		return AppConstants.PROJECTS_DATA;
	}
}
