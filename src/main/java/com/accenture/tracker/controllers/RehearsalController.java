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

import com.accenture.tracker.hibernate.domains.Rehearsal;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.RehearsalService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class RehearsalController {

	@Autowired
	private RehearsalService rehearsalService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/rehearsal/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.REHEARSAL_LIST;
	}

	@RequestMapping(value = "/rehearsal/action", params = { "create" })
	public String createForm(Model model,HttpServletRequest request) {
		model.addAttribute("title", "Create New Rehearsal Entry");
		model.addAttribute("attr", "rh");
		model.addAttribute("rh", new Rehearsal());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				rehearsalService.fetchAllOperations());
		model.addAttribute("listPriorities",
				rehearsalService.fetchAllPriorites());

		model.addAttribute("listStatus", rehearsalService.fetchAllStatus());

		return AppConstants.REHEARSAL_CREATE;
	}

	@RequestMapping(value = "/rehearsal/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		rehearsalService.remove(id);
		return "";
	}

	@RequestMapping(value = "/rehearsal/action", params = { "edit" })
	public String editForm(ModelMap model, Rehearsal rh,
			HttpServletRequest request) {

		rh = rehearsalService.fetchById(rh.getId());

		model.addAttribute("title", "Edit Rehearsal Entry");
		model.addAttribute("attr", "rh");
		model.addAttribute("rh", rh);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				rehearsalService.fetchAllOperations());

		model.addAttribute("listPriorities",
				rehearsalService.fetchAllPriorites());

		model.addAttribute("listStatus", rehearsalService.fetchAllStatus());

		return AppConstants.REHEARSAL_EDIT;
	}

	@RequestMapping(value = "/rehearsal/action", params = { "save" })
	public String saveForm(Rehearsal rh) {
		rehearsalService.save(rh);
		return AppConstants.REHEARSAL_DATA;
	}

	@RequestMapping(value = "/rehearsal/action", params = { "search" })
	public String search(Model model,HttpServletRequest request) {
		model.addAttribute("listData", rehearsalService.search(request.getSession()
				.getAttribute("project").toString()));
		return AppConstants.REHEARSAL_DATA;
	}
}
