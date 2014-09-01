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

import com.accenture.tracker.hibernate.domains.SupportScope;
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

	@RequestMapping(value = "/supportscope/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.SUPPORT_SCOPE_LIST;
	}

	@RequestMapping(value = "/supportscope/action", params = { "create" })
	public String createForm(Model model) {
		model.addAttribute("title", "Create New Support Scope Entry");
		model.addAttribute("attr", "support");
		model.addAttribute("support", new SupportScope());
		model.addAttribute("listProjects",
				supportScopeService.fetchAllProjects());
		model.addAttribute("listOperations",
				supportScopeService.fetchAllOperations());
		model.addAttribute("listPriorities",
				supportScopeService.fetchAllPriorites());

		model.addAttribute("listStatus", supportScopeService.fetchAllStatus());

		return AppConstants.SUPPORT_SCOPE_CREATE;
	}

	@RequestMapping(value = "/supportscope/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		supportScopeService.remove(id);
		return "";
	}

	@RequestMapping(value = "/supportscope/action", params = { "edit" })
	public String editForm(ModelMap model, SupportScope supportScope, HttpServletRequest request) {

		supportScope = supportScopeService.fetchById(supportScope.getId());

		model.addAttribute("title", "Edit Support Scope Entry");
		model.addAttribute("attr", "support");
		model.addAttribute("support", supportScope);
		model.addAttribute("listProjects",
				supportScopeService.fetchAllProjects());
		model.addAttribute("listOperations",
				supportScopeService.fetchAllOperations());

		model.addAttribute("listPriorities",
				supportScopeService.fetchAllPriorites());

		model.addAttribute("listStatus", supportScopeService.fetchAllStatus());

		return AppConstants.SUPPORT_SCOPE_EDIT;
	}

	@RequestMapping(value = "/supportscope/action", params = { "save" })
	public String saveForm(SupportScope supportScope) {
		supportScopeService.save(supportScope);
		return AppConstants.SUPPORT_SCOPE_DATA;
	}

	@RequestMapping(value = "/supportscope/action", params = { "search" })
	public String search(Model model) {
		model.addAttribute("listData", supportScopeService.search());
		return AppConstants.SUPPORT_SCOPE_DATA;
	}
}
