/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Release;
import com.accenture.tracker.hibernate.domains.Status;


/**
 * @author j.saini
 *
 */
public interface ReleaseDAO {

	List<Operations> fetchAllOperations();

	List<Release> search(String projectid);

	void save(Release release);

	Release fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
