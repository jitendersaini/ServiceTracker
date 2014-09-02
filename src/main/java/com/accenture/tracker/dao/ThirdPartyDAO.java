/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.ThirdParty;


/**
 * @author j.saini
 *
 */
public interface ThirdPartyDAO {

	List<Operations> fetchAllOperations();

	List<ThirdParty> search(String projectid);

	void save(ThirdParty thirdParty);

	ThirdParty fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
