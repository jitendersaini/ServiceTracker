/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.SupportScope;


/**
 * @author j.saini
 *
 */
public interface SupportScopeDAO {

	List<Operations> fetchAllOperations();

	List<SupportScope> search(String projectid);

	void save(SupportScope supportScope);

	SupportScope fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
