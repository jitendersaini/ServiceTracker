/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Rehearsal;
import com.accenture.tracker.hibernate.domains.Status;



/**
 * @author j.saini
 *
 */
public interface RehearsalService {

	List<Projects> fetchAllProjects();

	List<Operations> fetchAllOperations();

	List<Rehearsal> search();

	void save(Rehearsal rehearsal);

	Rehearsal fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
