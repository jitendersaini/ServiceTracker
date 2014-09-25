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
import org.springframework.web.servlet.ModelAndView;

import com.accenture.tracker.hibernate.domains.KT;
import com.accenture.tracker.json.DataList;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.KTService;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class KTController {

	@Autowired
	private KTService kTService;

	@Autowired
	private ProjectsService projectService;

	@RequestMapping(value = "/kt/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.KT_LIST;
	}

	@RequestMapping(value = "/kt/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model, HttpServletRequest request) {
		model.addAttribute("title", "Create New Knowledge Transfer Entry");
		model.addAttribute("attr", "kt");
		model.addAttribute("kt", new KT());		
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations", kTService.fetchAllOperations());
		model.addAttribute("ktStatus", kTService.fetchAllKtStatus());
		model.addAttribute("listPriorities", kTService.fetchAllPriorites());

		model.addAttribute("listStatus", kTService.fetchAllStatus());

		return AppConstants.KT_CREATE;
	}

	@RequestMapping(value = "/kt/action", params = { "remove" }, method = RequestMethod.POST)
	public @ResponseBody String removeData(ModelMap model, String id) {
		kTService.remove(id);
		return "";
	}

	@RequestMapping(value = "/kt/action", params = { "edit" }, method = RequestMethod.POST)
	public String editForm(ModelMap model, KT kt, HttpServletRequest request) {

		kt = kTService.fetchById(kt.getId());

		model.addAttribute("title", "Edit Knowledge Transition Entry");
		model.addAttribute("attr", "kt");
		model.addAttribute("kt", kt);
		model.addAttribute("ktStatus", kTService.fetchAllKtStatus());
		model.addAttribute(
				"listProjects",
				projectService.fetchAllProjects(request.getSession()
						.getAttribute("project").toString()));
		model.addAttribute("listOperations", kTService.fetchAllOperations());

		model.addAttribute("listPriorities", kTService.fetchAllPriorites());

		model.addAttribute("listStatus", kTService.fetchAllStatus());

		return AppConstants.KT_EDIT;
	}

	@RequestMapping(value = "/kt/action", params = { "save" }, method = RequestMethod.POST)
	public @ResponseBody String saveForm(KT kt) {
		kTService.save(kt);
		return AppConstants.RETURN_BLANK;
	}

	@RequestMapping(value = "/kt/action", params = { "search" }, method = RequestMethod.POST, headers = "Accept= application/json", produces = "application/json")
	public @ResponseBody DataList search(Model model, HttpServletRequest request) {		
		// Call service here
		DataList result = new DataList();
		List<DataObject> list = kTService.searchForJson(request.getSession()
				.getAttribute("project").toString());		
		result.setData(list);

		return result;

	}
	
	@RequestMapping(value = "/kt/action", params={"export"},  method = RequestMethod.GET)
	public ModelAndView getExcel(HttpServletRequest request) {
		List<DataObject> list = kTService.searchForJson(request.getSession()
				.getAttribute("project").toString());
		return new ModelAndView("ListExcel", "dataList", list);
	}
}
