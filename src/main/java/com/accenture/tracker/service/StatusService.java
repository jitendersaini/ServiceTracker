/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.json.DataObjectAdmin;


/**
 * @author j.saini
 *
 */
public interface StatusService {

	List<Status> search();

	void save(Status status, Long loginId);

	Status fetchById(Long id);

	void remove(String id);

	List<DataObjectAdmin> searchForJson();

}
