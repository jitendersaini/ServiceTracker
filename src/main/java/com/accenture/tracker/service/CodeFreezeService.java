/**
 * 
 */
package com.accenture.tracker.service;

import java.util.List;

import com.accenture.tracker.hibernate.domains.CodeFreeze;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;



/**
 * @author j.saini
 *
 */
public interface CodeFreezeService {

	List<Projects> fetchAllProjects();

	List<Operations> fetchAllOperations();

	List<CodeFreeze> search();

	void save(CodeFreeze codeFreeze);

	CodeFreeze fetchById(Long id);

	void remove(String id);

	List<Priorities> fetchAllPriorites();

	List<Status> fetchAllStatus();

}
