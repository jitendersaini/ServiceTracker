/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.WorkEnvironment;



/**
 * @author j.saini
 *
 */
public interface WorkEnvService {

	List<Projects> fetchAllProjects();

	List<Operations> fetchAllOperations();

	List<WorkEnvironment> search();

	void save(WorkEnvironment workEnvironment);

}
