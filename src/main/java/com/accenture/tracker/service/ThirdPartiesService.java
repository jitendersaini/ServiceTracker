/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.ThirdParty;
import com.accenture.tracker.json.DataObject;



/**
 * @author j.saini
 *
 */
public interface ThirdPartiesService {

	List<Operations> fetchAllOperations();

	List<ThirdParty> search(String projectid);

	void save(ThirdParty thirdParty);

	ThirdParty fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

	List<DataObject> searchForJson(String projectid);

}
