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

import com.accenture.tracker.hibernate.domains.ProcessAndTools;
import com.accenture.tracker.json.DataList;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.PTService;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class PTController {

	@Autowired
	private PTService pTService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/processtools/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.PROCESS_TOOLS_LIST;
	}

	@RequestMapping(value = "/processtools/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model,HttpServletRequest request) {
		model.addAttribute("title", "Create New Process And Tools Entry");
		model.addAttribute("attr", "pt");
		model.addAttribute("pt", new ProcessAndTools());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations", pTService.fetchAllOperations());
		model.addAttribute("listPriorities", pTService.fetchAllPriorites());

		model.addAttribute("listStatus", pTService.fetchAllStatus());

		return AppConstants.PROCESS_TOOLS_CREATE;
	}

	@RequestMapping(value = "/processtools/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		pTService.remove(id);
		return "";
	}

	@RequestMapping(value = "/processtools/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(ModelMap model, ProcessAndTools pt,
			HttpServletRequest request) {

		pt = pTService.fetchById(pt.getId());

		model.addAttribute("title", "Edit Process And Tools Entry");
		model.addAttribute("attr", "pt");
		model.addAttribute("pt", pt);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations", pTService.fetchAllOperations());

		model.addAttribute("listPriorities", pTService.fetchAllPriorites());

		model.addAttribute("listStatus", pTService.fetchAllStatus());

		return AppConstants.PROCESS_TOOLS_EDIT;
	}

	@RequestMapping(value = "/processtools/action", params = { "save" }, method = RequestMethod.POST)
	public @ResponseBody String saveForm(ProcessAndTools pt) {
		pTService.save(pt);
		return AppConstants.RETURN_BLANK;
	}
	
	@RequestMapping(value = "/processtools/action", params = { "search" }, method = RequestMethod.POST, headers = "Accept= application/json", produces = "application/json")
	public @ResponseBody DataList search(Model model, HttpServletRequest request) {		
		// Call service here
		DataList result = new DataList();
		List<DataObject> list = pTService.searchForJson(request.getSession()
				.getAttribute("project").toString());		
		result.setData(list);

		return result;

	}
}
