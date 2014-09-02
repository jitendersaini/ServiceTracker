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

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.service.OperationsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 *
 */

@Controller
@RequestMapping("/admin")
public class OperationController {

	@Autowired
	private OperationsService operationsService;

	@RequestMapping(value = "/operations/action")
	public String loadForm(HttpServletRequest request) {
		return AppConstants.OPERATIONS_LIST;
	}

	@RequestMapping(value = "/operations/action", params = { "create" })
	public String createForm(Model model) {
		model.addAttribute("title", "Create New Operation");
		model.addAttribute("attr", "op");
		model.addAttribute("op", new Operations());
		return AppConstants.OPERATIONS_CREATE;
	}

	@RequestMapping(value = "/operations/action", params = { "remove" })
	public @ResponseBody String removeData(ModelMap model, String id) {
		operationsService.remove(id);
		return "";
	}

	@RequestMapping(value = "/operations/action", params = { "edit" })
	public String editForm(Model model, Operations op,
			HttpServletRequest request) {

		op = operationsService.fetchById(op.getId());

		model.addAttribute("title", "Edit Operations");
		model.addAttribute("attr", "op");
		model.addAttribute("op", op);
		return AppConstants.OPERATIONS_EDIT;
	}

	@RequestMapping(value = "/operations/action", params = { "save" })
	public String saveForm(Operations op, HttpServletRequest request) {
		operationsService.save(
				op,
				Long.valueOf(request.getSession().getAttribute("login_id")
						.toString()));
		return AppConstants.OPERATIONS_DATA;
	}

	@RequestMapping(value = "/operations/action", params = { "search" })
	public String search(Model model) {
		model.addAttribute("listData", operationsService.search());
		return AppConstants.OPERATIONS_DATA;
	}
}
