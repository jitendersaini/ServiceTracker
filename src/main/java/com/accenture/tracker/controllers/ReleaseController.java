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

import com.accenture.tracker.hibernate.domains.Release;
import com.accenture.tracker.json.DataList;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.ReleaseService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class ReleaseController {

	@Autowired
	private ReleaseService releaseService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/release/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.RELEASE_LIST;
	}

	@RequestMapping(value = "/release/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model,HttpServletRequest request) {
		model.addAttribute("title", "Create New Release Entry");
		model.addAttribute("attr", "release");
		model.addAttribute("release", new Release());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				releaseService.fetchAllOperations());
		model.addAttribute("listPriorities", releaseService.fetchAllPriorites());

		model.addAttribute("listStatus", releaseService.fetchAllStatus());

		return AppConstants.RELEASE_CREATE;
	}

	@RequestMapping(value = "/release/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		releaseService.remove(id);
		return "";
	}

	@RequestMapping(value = "/release/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(ModelMap model, Release release,
			HttpServletRequest request) {

		release = releaseService.fetchById(release.getId());

		model.addAttribute("title", "Edit Release Entry");
		model.addAttribute("attr", "release");
		model.addAttribute("release", release);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				releaseService.fetchAllOperations());

		model.addAttribute("listPriorities", releaseService.fetchAllPriorites());

		model.addAttribute("listStatus", releaseService.fetchAllStatus());

		return AppConstants.RELEASE_EDIT;
	}

	@RequestMapping(value = "/release/action", params = { "save" }, method = RequestMethod.POST)
	public String saveForm(Release relase) {
		releaseService.save(relase);
		return AppConstants.RELEASE_DATA;
	}

	/*@RequestMapping(value = "/release/action", params = { "search" }, method = RequestMethod.POST)
	public String search(Model model,HttpServletRequest request) {
		model.addAttribute("listData", releaseService.search(request.getSession()
				.getAttribute("project").toString()));
		return AppConstants.RELEASE_DATA;
	}*/
	
	@RequestMapping(value = "/release/action", params = { "search" }, method = RequestMethod.GET, headers = "Accept= application/json", produces = "application/json")
	public @ResponseBody DataList search(Model model, HttpServletRequest request) {		
		// Call service here
		DataList result = new DataList();
		List<DataObject> list = releaseService.searchForJson(request.getSession()
				.getAttribute("project").toString());		
		result.setData(list);

		return result;

	}
}
