/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.ProjectsDAO;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.json.DataObjectAdmin;
import com.accenture.tracker.service.ProjectsService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	ProjectsDAO projectsDAO;

	@Override
	public List<Projects> search() {		
		return projectsDAO.search();
	}
	
	
	@Override
	public List<Projects> searchForUsersReg() {
		List<Projects> list = projectsDAO.search();
		list.add(0, new Projects(null,"----Select Project---"));
		return list;
	}

	@Override
	public void save(Projects projects, Long loginId) {
		if (projects.getId() == null) {
			projects.setCreatedDate(new Date());
		}
		projects.setModifiedDate(new Date());
		projectsDAO.save(projects);
	}

	@Override
	public Projects fetchById(Long id) {
		return projectsDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		projectsDAO.remove(id);
	}


	@Override
	public List<Projects> fetchAllProjects(String projectid) {
		return projectsDAO.fetchAllProjects(projectid);
	}


	@Override
	public List<DataObjectAdmin> searchForJson() {
		List<Projects> listProjects = projectsDAO.search();

		List<DataObjectAdmin> list = new ArrayList<DataObjectAdmin>();

		DataObjectAdmin doj = null;

		for (Projects object : listProjects) {
			doj = new DataObjectAdmin();
			doj.setId(object.getId().toString());
			doj.setTitle(object.getProjectName());
			doj.setCreatedDate(AppConstants.convertDateWithTime(object.getCreatedDate()));
			doj.setModifiedDate(AppConstants.convertDateWithTime(object.getModifiedDate()));			
			list.add(doj);
		}
		return list;
	}
}
