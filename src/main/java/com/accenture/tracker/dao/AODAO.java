/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.AoAccess;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;


/**
 * @author j.saini
 *
 */
public interface AODAO {

	List<Projects> fetchAllProjects();

	List<Operations> fetchAllOperations();

	List<AoAccess> search();

	void save(AoAccess ao);

	AoAccess fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
