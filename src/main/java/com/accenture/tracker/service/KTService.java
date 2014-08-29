/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.KT;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;



/**
 * @author j.saini
 *
 */
public interface KTService {

	List<Projects> fetchAllProjects();

	List<Operations> fetchAllOperations();

	List<KT> search();

	void save(KT kt);

	KT fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
