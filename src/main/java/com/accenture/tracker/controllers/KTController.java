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

import com.accenture.tracker.hibernate.domains.KT;
import com.accenture.tracker.service.KTService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/kt")
public class KTController {

	@Autowired
	private KTService kTService;

	@RequestMapping(value = "/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.KT_LIST;
	}

	@RequestMapping(value = "/action", params = { "create" })
	public String createForm(Model model) {
		model.addAttribute("title", "Create New Knowledge Transfer Entry");
		model.addAttribute("attr", "kt");
		model.addAttribute("kt", new KT());
		model.addAttribute("listProjects", kTService.fetchAllProjects());
		model.addAttribute("listOperations",
				kTService.fetchAllOperations());
		model.addAttribute("listPriorities", kTService.fetchAllPriorites());

		model.addAttribute("listStatus", kTService.fetchAllStatus());

		return AppConstants.KT_CREATE;
	}

	@RequestMapping(value = "/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		kTService.remove(id);
		return "";
	}

	@RequestMapping(value = "/action", params = { "edit" })
	public String editForm(ModelMap model, KT kt,
			HttpServletRequest request) {

		kt = kTService.fetchById(kt.getId());

		model.addAttribute("title", "Edit Knowledge Transition Entry");
		model.addAttribute("attr", "kt");
		model.addAttribute("kt", kt);
		model.addAttribute("listProjects", kTService.fetchAllProjects());
		model.addAttribute("listOperations",
				kTService.fetchAllOperations());

		model.addAttribute("listPriorities", kTService.fetchAllPriorites());

		model.addAttribute("listStatus", kTService.fetchAllStatus());

		return AppConstants.KT_EDIT;
	}

	@RequestMapping(value = "/action", params = { "save" })
	public String saveForm(KT kt) {
		kTService.save(kt);
		return AppConstants.KT_DATA;
	}

	@RequestMapping(value = "/action", params = { "search" })
	public String search(Model model) {
		model.addAttribute("listData", kTService.search());
		return AppConstants.KT_DATA;
	}
}
