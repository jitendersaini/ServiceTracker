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

import com.accenture.tracker.hibernate.domains.AoAccess;
import com.accenture.tracker.service.AOService;
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

	@RequestMapping(value = "/accessao/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.ACCESS_AO_LIST;
	}

	@RequestMapping(value = "/accessao/action", params = { "create" })
	public String createForm(Model model) {
		model.addAttribute("title", "Create New ACCESS AO Entry");
		model.addAttribute("attr", "ao");
		model.addAttribute("ao", new AoAccess());
		model.addAttribute("listProjects", aOService.fetchAllProjects());
		model.addAttribute("listOperations", aOService.fetchAllOperations());
		model.addAttribute("listPriorities", aOService.fetchAllPriorites());

		model.addAttribute("listStatus", aOService.fetchAllStatus());

		return AppConstants.ACCESS_AO_CREATE;
	}

	@RequestMapping(value = "/accessao/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		aOService.remove(id);
		return "";
	}

	@RequestMapping(value = "/accessao/action", params = { "edit" })
	public String editForm(ModelMap model, AoAccess ao,
			HttpServletRequest request) {

		ao = aOService.fetchById(ao.getId());

		model.addAttribute("title", "Edit Access AO Entry");
		model.addAttribute("attr", "ao");
		model.addAttribute("ao", ao);
		model.addAttribute("listProjects", aOService.fetchAllProjects());
		model.addAttribute("listOperations", aOService.fetchAllOperations());

		model.addAttribute("listPriorities", aOService.fetchAllPriorites());

		model.addAttribute("listStatus", aOService.fetchAllStatus());

		return AppConstants.ACCESS_AO_EDIT;
	}

	@RequestMapping(value = "/accessao/action", params = { "save" })
	public String saveForm(AoAccess aoAccess) {
		aOService.save(aoAccess);
		return AppConstants.ACCESS_AO_DATA;
	}

	@RequestMapping(value = "/accessao/action", params = { "search" })
	public String search(Model model) {
		model.addAttribute("listData", aOService.search());
		return AppConstants.ACCESS_AO_DATA;
	}
}
