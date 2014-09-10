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

import com.accenture.tracker.hibernate.domains.PGLS;
import com.accenture.tracker.json.DataList;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.PGLSService;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class PGLSController {

	@Autowired
	private PGLSService pGLSService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/pgls/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.PGLS_LIST;
	}

	@RequestMapping(value = "/pgls/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model,HttpServletRequest request) {
		model.addAttribute("title", "Create New PGLS Entry");
		model.addAttribute("attr", "pgls");
		model.addAttribute("pgls", new PGLS());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				pGLSService.fetchAllOperations());
		model.addAttribute("listPriorities", pGLSService.fetchAllPriorites());

		model.addAttribute("listStatus", pGLSService.fetchAllStatus());

		return AppConstants.PGLS_CREATE;
	}

	@RequestMapping(value = "/pgls/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		pGLSService.remove(id);
		return "";
	}

	@RequestMapping(value = "/pgls/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(ModelMap model, PGLS pgls,
			HttpServletRequest request) {

		pgls = pGLSService.fetchById(pgls.getId());

		model.addAttribute("title", "Edit PGLS Entry");
		model.addAttribute("attr", "pgls");
		model.addAttribute("pgls", pgls);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				pGLSService.fetchAllOperations());

		model.addAttribute("listPriorities", pGLSService.fetchAllPriorites());

		model.addAttribute("listStatus", pGLSService.fetchAllStatus());

		return AppConstants.PGLS_EDIT;
	}

	@RequestMapping(value = "/pgls/action", params = { "save" }, method = RequestMethod.POST)
	public String saveForm(PGLS pgls) {
		pGLSService.save(pgls);
		return AppConstants.PGLS_DATA;
	}

	/*@RequestMapping(value = "/pgls/action", params = { "search" })
	public String search(Model model,HttpServletRequest request) {
		model.addAttribute("listData", pGLSService.search(request.getSession()
				.getAttribute("project").toString()));
		return AppConstants.PGLS_DATA;
	}*/
	
	@RequestMapping(value = "/pgls/action", params = { "search" }, method = RequestMethod.GET, headers = "Accept= application/json", produces = "application/json")
	public @ResponseBody DataList search(Model model, HttpServletRequest request) {		
		// Call service here
		DataList result = new DataList();
		List<DataObject> list = pGLSService.searchForJson(request.getSession()
				.getAttribute("project").toString());		
		result.setData(list);

		return result;

	}
}
