/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.AoAccess;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;


/**
 * @author j.saini
 *
 */
public interface AODAO {

	List<Operations> fetchAllOperations();

	List<AoAccess> search(String projectid);

	void save(AoAccess ao);

	AoAccess fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
