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

import com.accenture.tracker.hibernate.domains.SupportScope;
import com.accenture.tracker.json.DataList;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.service.SupportScopeService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class SupportScopeController {

	@Autowired
	private SupportScopeService supportScopeService;

	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/supportscope/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.SUPPORT_SCOPE_LIST;
	}

	@RequestMapping(value = "/supportscope/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Create New Support Scope Entry");
		model.addAttribute("attr", "support");
		model.addAttribute("support", new SupportScope());
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				supportScopeService.fetchAllOperations());
		model.addAttribute("listPriorities",
				supportScopeService.fetchAllPriorites());

		model.addAttribute("listStatus", supportScopeService.fetchAllStatus());

		return AppConstants.SUPPORT_SCOPE_CREATE;
	}

	@RequestMapping(value = "/supportscope/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		supportScopeService.remove(id);
		return "";
	}

	@RequestMapping(value = "/supportscope/action", params = { "edit" })
	public String editForm(ModelMap model, SupportScope supportScope,
			HttpServletRequest request) {

		supportScope = supportScopeService.fetchById(supportScope.getId());

		model.addAttribute("title", "Edit Support Scope Entry");
		model.addAttribute("attr", "support");
		model.addAttribute("support", supportScope);
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				supportScopeService.fetchAllOperations());

		model.addAttribute("listPriorities",
				supportScopeService.fetchAllPriorites());

		model.addAttribute("listStatus", supportScopeService.fetchAllStatus());

		return AppConstants.SUPPORT_SCOPE_EDIT;
	}

	@RequestMapping(value = "/supportscope/action", params = { "save" }, method = RequestMethod.POST)
	public @ResponseBody String saveForm(SupportScope supportScope) {
		supportScopeService.save(supportScope);
		return AppConstants.RETURN_BLANK;
	}
	
	@RequestMapping(value = "/supportscope/action", params = { "search" }, method = RequestMethod.POST, headers = "Accept= application/json", produces = "application/json")
	public @ResponseBody DataList search(Model model, HttpServletRequest request) {		
		// Call service here
		DataList result = new DataList();
		List<DataObject> list = supportScopeService.searchForJson(request.getSession()
				.getAttribute("project").toString());		
		result.setData(list);

		return result;

	}
}
