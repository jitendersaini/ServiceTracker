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

import com.accenture.tracker.hibernate.domains.AoAccess;
import com.accenture.tracker.service.AOService;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class AOController {

	@Autowired
	private AOService aOService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/accessao/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.ACCESS_AO_LIST;
	}

	@RequestMapping(value = "/accessao/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Create New ACCESS AO Entry");
		model.addAttribute("attr", "ao");
		model.addAttribute("ao", new AoAccess());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations", aOService.fetchAllOperations());
		model.addAttribute("listPriorities", aOService.fetchAllPriorites());

		model.addAttribute("listStatus", aOService.fetchAllStatus());

		return AppConstants.ACCESS_AO_CREATE;
	}

	@RequestMapping(value = "/accessao/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		aOService.remove(id);
		return "";
	}

	@RequestMapping(value = "/accessao/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(ModelMap model, AoAccess ao,
			HttpServletRequest request) {

		ao = aOService.fetchById(ao.getId());

		model.addAttribute("title", "Edit Access AO Entry");
		model.addAttribute("attr", "ao");
		model.addAttribute("ao", ao);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations", aOService.fetchAllOperations());

		model.addAttribute("listPriorities", aOService.fetchAllPriorites());

		model.addAttribute("listStatus", aOService.fetchAllStatus());

		return AppConstants.ACCESS_AO_EDIT;
	}

	@RequestMapping(value = "/accessao/action", params = { "save" }, method = RequestMethod.POST)
	public String saveForm(AoAccess aoAccess) {
		aOService.save(aoAccess);
		return AppConstants.ACCESS_AO_DATA;
	}

	@RequestMapping(value = "/accessao/action", params = { "search" }, method = RequestMethod.POST)
	public String search(Model model, HttpServletRequest request) {
		model.addAttribute("listData", aOService.search(request.getSession()
				.getAttribute("project").toString()));
		return AppConstants.ACCESS_AO_DATA;
	}
}
