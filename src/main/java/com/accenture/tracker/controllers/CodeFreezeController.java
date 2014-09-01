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

import com.accenture.tracker.hibernate.domains.CodeFreeze;
import com.accenture.tracker.service.CodeFreezeService;
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

	@RequestMapping(value = "/codefreeze/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.CODE_FREEZE_LIST;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "create" })
	public String createForm(Model model) {
		model.addAttribute("title", "Create New Code Freeze Entry");
		model.addAttribute("attr", "codefreeze");
		model.addAttribute("codefreeze", new CodeFreeze());
		model.addAttribute("listProjects", codeFreezeService.fetchAllProjects());
		model.addAttribute("listOperations",
				codeFreezeService.fetchAllOperations());
		model.addAttribute("listPriorities",
				codeFreezeService.fetchAllPriorites());

		model.addAttribute("listStatus", codeFreezeService.fetchAllStatus());

		return AppConstants.CODE_FREEZE_CREATE;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		codeFreezeService.remove(id);
		return "";
	}

	@RequestMapping(value = "/codefreeze/action", params = { "edit" })
	public String editForm(ModelMap model, CodeFreeze codeFreeze, HttpServletRequest request) {

		codeFreeze = codeFreezeService.fetchById(codeFreeze.getId());

		model.addAttribute("title", "Edit Code Freeze Entry");
		model.addAttribute("attr", "codefreeze");
		model.addAttribute("codefreeze", codeFreeze);
		model.addAttribute("listProjects", codeFreezeService.fetchAllProjects());
		model.addAttribute("listOperations",
				codeFreezeService.fetchAllOperations());

		model.addAttribute("listPriorities",
				codeFreezeService.fetchAllPriorites());

		model.addAttribute("listStatus", codeFreezeService.fetchAllStatus());

		return AppConstants.CODE_FREEZE_EDIT;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "save" })
	public String saveForm(CodeFreeze codeFreeze) {
		codeFreezeService.save(codeFreeze);
		return AppConstants.CODE_FREEZE_DATA;
	}

	@RequestMapping(value = "/codefreeze/action", params = { "search" })
	public String search(Model model) {
		model.addAttribute("listData", codeFreezeService.search());
		return AppConstants.CODE_FREEZE_DATA;
	}
}
