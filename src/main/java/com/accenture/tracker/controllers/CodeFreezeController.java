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

import com.accenture.tracker.hibernate.domains.CodeFreeze;
import com.accenture.tracker.json.DataList;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.CodeFreezeService;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class CodeFreezeController {

	@Autowired
	private CodeFreezeService codeFreezeService;
	
	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/codefreeze/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.CODE_FREEZE_LIST;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model,HttpServletRequest request) {
		model.addAttribute("title", "Create New Code Freeze Entry");
		model.addAttribute("attr", "codefreeze");
		model.addAttribute("codefreeze", new CodeFreeze());
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				codeFreezeService.fetchAllOperations());
		model.addAttribute("listPriorities",
				codeFreezeService.fetchAllPriorites());

		model.addAttribute("listStatus", codeFreezeService.fetchAllStatus());

		return AppConstants.CODE_FREEZE_CREATE;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		codeFreezeService.remove(id);
		return "";
	}

	@RequestMapping(value = "/codefreeze/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(ModelMap model, CodeFreeze codeFreeze, HttpServletRequest request) {

		codeFreeze = codeFreezeService.fetchById(codeFreeze.getId());

		model.addAttribute("title", "Edit Code Freeze Entry");
		model.addAttribute("attr", "codefreeze");
		model.addAttribute("codefreeze", codeFreeze);
		model.addAttribute("listProjects", projectService.fetchAllProjects(request.getSession()
				.getAttribute("project").toString()));
		model.addAttribute("listOperations",
				codeFreezeService.fetchAllOperations());

		model.addAttribute("listPriorities",
				codeFreezeService.fetchAllPriorites());

		model.addAttribute("listStatus", codeFreezeService.fetchAllStatus());

		return AppConstants.CODE_FREEZE_EDIT;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "save" }, method = RequestMethod.POST)
	public @ResponseBody String saveForm(CodeFreeze codeFreeze) {
		codeFreezeService.save(codeFreeze);
		return AppConstants.RETURN_BLANK;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "search" }, method = RequestMethod.POST, headers = "Accept= application/json", produces = "application/json")
	public @ResponseBody DataList search(Model model, HttpServletRequest request) {		
		// Call service here
		DataList result = new DataList();
		List<DataObject> list = codeFreezeService.searchForJson(request.getSession()
				.getAttribute("project").toString());		
		result.setData(list);

		return result;

	}
}
