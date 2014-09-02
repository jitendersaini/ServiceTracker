/**
 * 
 */
package com.accenture.tracker.dao;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;


/**
 * @author j.saini
 *
 */
public interface OperationsDAO {

	List<Operations> search();

	void save(Operations operations);

	Operations fetchById(Long id);

	void remove(String id);
}
