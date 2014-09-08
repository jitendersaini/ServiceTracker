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

import com.accenture.tracker.hibernate.domains.ThirdParty;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.ThirdPartiesService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class ThirdPartiesController {

	@Autowired
	private ThirdPartiesService thirdPartiesService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/thirdparties/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.THIRD_PARTIES_LIST;
	}

	@RequestMapping(value = "/thirdparties/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model,HttpServletRequest request) {
		model.addAttribute("title", "Create New Third Party Entry");
		model.addAttribute("attr", "tp");
		model.addAttribute("tp", new ThirdParty());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				thirdPartiesService.fetchAllOperations());
		model.addAttribute("listPriorities", thirdPartiesService.fetchAllPriorites());

		model.addAttribute("listStatus", thirdPartiesService.fetchAllStatus());

		return AppConstants.THIRD_PARTIES_CREATE;
	}

	@RequestMapping(value = "/thirdparties/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		thirdPartiesService.remove(id);
		return "";
	}

	@RequestMapping(value = "/thirdparties/action", params = { "edit" })
	public String editForm(ModelMap model, ThirdParty tp,
			HttpServletRequest request) {

		tp = thirdPartiesService.fetchById(tp.getId());

		model.addAttribute("title", "Edit Third Party Entry");
		model.addAttribute("attr", "tp");
		model.addAttribute("tp", tp);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				thirdPartiesService.fetchAllOperations());

		model.addAttribute("listPriorities", thirdPartiesService.fetchAllPriorites());

		model.addAttribute("listStatus", thirdPartiesService.fetchAllStatus());

		return AppConstants.THIRD_PARTIES_EDIT;
	}

	@RequestMapping(value = "/thirdparties/action", params = { "save" }, method = RequestMethod.POST)
	public String saveForm(ThirdParty tp) {
		thirdPartiesService.save(tp);
		return AppConstants.THIRD_PARTIES_DATA;
	}

	@RequestMapping(value = "/thirdparties/action", params = { "search" }, method = RequestMethod.POST)
	public String search(Model model,HttpServletRequest request) {
		model.addAttribute("listData", thirdPartiesService.search(request.getSession()
				.getAttribute("project").toString()));
		return AppConstants.THIRD_PARTIES_DATA;
	}
}
