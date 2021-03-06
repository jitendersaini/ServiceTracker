/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.WorkEnvironment;


/**
 * @author j.saini
 *
 */
public interface WorkEnvDAO {

	List<WorkEnvironment> search(String projectid);

	void save(WorkEnvironment workEnvironment);

	WorkEnvironment fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

	List<Operations> fetchAllOperations();

}
