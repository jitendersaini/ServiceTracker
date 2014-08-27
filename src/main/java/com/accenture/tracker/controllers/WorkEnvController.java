/**
 * 
 */
package com.accenture.tracker.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accenture.tracker.hibernate.domains.WorkEnvironment;
import com.accenture.tracker.service.WorkEnvService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */
@RequestMapping("/workenv")
@Controller
public class WorkEnvController {

	@Autowired
	private WorkEnvService workEnvService;

	@RequestMapping(value = "/action", params = { "create" }, method = RequestMethod.POST)
	public String createForm(Model model) {
		model.addAttribute("title", "Create New Work Env. Entry");
		model.addAttribute("attr","work");
		model.addAttribute("work", new WorkEnvironment());
		model.addAttribute("listProjects", workEnvService.fetchAllProjects());
		model.addAttribute("listOperations",
				workEnvService.fetchAllOperations());
		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "P1");
		map.put(2, "P2");
		map.put(3, "P3");
		map.put(4, "P4");

		model.addAttribute("listPriorities", map);

		Map<Integer, String> mapStatus = new HashMap<Integer, String>();

		mapStatus.put(1, "Signed Off");
		mapStatus.put(2, "Started");
		mapStatus.put(3, "Not Started");
		
		model.addAttribute("listStatus", mapStatus);
		
		return AppConstants.WORKENV_PAGE;
	}
	@RequestMapping(value = "/action", params = { "saveWork" })	
	public String saveForm(WorkEnvironment workEnvironment) {
		System.out.println("Saveddddddddddddddddddddd");
		workEnvService.save(workEnvironment);
		return AppConstants.WORKENV_DATA;
	}
	
	@RequestMapping(value = "/action", params = { "search" })
	public String search(Model model) {
		System.out.println("Searchchhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
		model.addAttribute("listData",workEnvService.search());
		return AppConstants.WORKENV_DATA;
	}
}
