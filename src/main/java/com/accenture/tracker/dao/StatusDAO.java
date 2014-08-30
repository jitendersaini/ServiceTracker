/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Status;

/**
 * @author j.saini
 *
 */
public interface StatusDAO {

	List<Status> search();

	void save(Status status);

	Status fetchById(Long id);

	void remove(String id);
}
