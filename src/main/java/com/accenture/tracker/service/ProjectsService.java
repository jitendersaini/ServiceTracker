/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.json.DataObjectAdmin;


/**
 * @author j.saini
 *
 */
public interface ProjectsService {

	List<Projects> search();
	List<Projects> searchForUsersReg();

	void save(Projects projects, Long loginId);

	Projects fetchById(Long id);

	void remove(String id);
	List<Projects> fetchAllProjects(String projectid);
	
	List<DataObjectAdmin> searchForJson();

}
