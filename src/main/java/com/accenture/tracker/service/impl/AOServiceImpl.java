/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.AODAO;
import com.accenture.tracker.hibernate.domains.AoAccess;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.AOService;

/**
 * @author j.saini
 * 
 */
@Service
public class AOServiceImpl implements AOService {

	@Autowired
	AODAO aODAO;

	@Override
	public List<Projects> fetchAllProjects() {		
		return aODAO.fetchAllProjects();
	}

	@Override
	public List<Operations> fetchAllOperations() {
		return aODAO.fetchAllOperations();
	}

	@Override
	public List<AoAccess> search() {
		return aODAO.search();
	}

	@Override
	public void save(AoAccess ao) {
		if (ao.getId() == null) {
			ao.setCreatedDate(new Date());
		}
		ao.setModifiedDate(new Date());
		
		aODAO.save(ao);
	}

	@Override
	public AoAccess fetchById(Long id) {
		return aODAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		aODAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return aODAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return aODAO.fetchAllStatus();
	}
}
