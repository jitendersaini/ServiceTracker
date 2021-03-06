/**
 * 
 */
package com.accenture.tracker.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.tracker.service.ChartService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/users")
public class CompleteStatusController {

	@Autowired
	private ChartService chartService;

	@RequestMapping(value = "/completestatus/action")
	public String loadForm(Model model, HttpServletRequest request) {
		Map<String, Double> mapChart = chartService.retrieveMap4Chart(request.getSession()
				.getAttribute("project").toString());
		/*Map<String, Double> map = new HashMap<String, Double>();
		map.put("Firefox", 45.0);
		map.put("IE", 26.8);
		map.put("Chrome", 12.8);
		map.put("Safari", 8.5);
		map.put("Opera", 6.2);
		map.put("Others", 0.7);*/
		model.addAttribute("map", mapChart);
		return AppConstants.COMPLETE_STATUS_LIST;
	}
}
