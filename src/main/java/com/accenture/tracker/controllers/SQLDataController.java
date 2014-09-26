/**
 * 
 */
package com.accenture.tracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.tracker.service.SqlService;

/**
 * @author j.saini
 *
 */
@Controller
public class SQLDataController {
	
	@Autowired
	private SqlService sqlService;
	
	
	
	@RequestMapping("/sql")
	public String sqlPage(HttpServletRequest request, Model model) {
		List<String> list = sqlService.fetchAll();
		return "admin-page/sql";
	}
}
