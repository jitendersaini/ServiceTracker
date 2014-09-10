/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.json.DataObjectAdmin;


/**
 * @author j.saini
 *
 */
public interface OperationsService {

	List<Operations> search();
	List<Operations> searchForUsersReg();

	void save(Operations operations, Long loginId);

	Operations fetchById(Long id);

	void remove(String id);
	
	List<DataObjectAdmin> searchForJson();

}
