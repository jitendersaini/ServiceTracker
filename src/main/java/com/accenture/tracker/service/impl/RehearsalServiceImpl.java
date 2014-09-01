/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.RehearsalDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Rehearsal;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.RehearsalService;

/**
 * @author j.saini
 * 
 */
@Service
public class RehearsalServiceImpl implements RehearsalService {

	@Autowired
	RehearsalDAO rehearsalDAO;

	@Override
	public List<Projects> fetchAllProjects() {		
		return rehearsalDAO.fetchAllProjects();
	}

	@Override
	public List<Operations> fetchAllOperations() {
		return rehearsalDAO.fetchAllOperations();
	}

	@Override
	public List<Rehearsal> search() {
		return rehearsalDAO.search();
	}

	@Override
	public void save(Rehearsal rehearsal) {
		if (rehearsal.getId() == null) {
			rehearsal.setCreatedDate(new Date());
		}
		rehearsal.setModifiedDate(new Date());
		
		rehearsalDAO.save(rehearsal);
	}

	@Override
	public Rehearsal fetchById(Long id) {
		return rehearsalDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		rehearsalDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return rehearsalDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return rehearsalDAO.fetchAllStatus();
	}
}
