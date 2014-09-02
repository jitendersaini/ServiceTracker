/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.ProjectsDAO;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.service.ProjectsService;

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
}
