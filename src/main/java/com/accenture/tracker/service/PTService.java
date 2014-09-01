/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.ProcessAndTools;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;



/**
 * @author j.saini
 *
 */
public interface PTService {

	List<Projects> fetchAllProjects();

	List<Operations> fetchAllOperations();

	List<ProcessAndTools> search();

	void save(ProcessAndTools pt);

	ProcessAndTools fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
