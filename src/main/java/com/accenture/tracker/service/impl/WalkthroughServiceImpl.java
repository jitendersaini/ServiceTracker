/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.WalkthroughDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.Walkthrough;
import com.accenture.tracker.service.WalkthroughService;

/**
 * @author j.saini
 * 
 */
@Service
public class WalkthroughServiceImpl implements WalkthroughService {

	@Autowired
	WalkthroughDAO walkthroughDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return walkthroughDAO.fetchAllOperations();
	}

	@Override
	public List<Walkthrough> search(String projectid) {
		return walkthroughDAO.search(projectid);
	}

	@Override
	public void save(Walkthrough walkthrough) {
		if (walkthrough.getId() == null) {
			walkthrough.setCreatedDate(new Date());
		}
		walkthrough.setModifiedDate(new Date());
		
		walkthroughDAO.save(walkthrough);
	}

	@Override
	public Walkthrough fetchById(Long id) {
		return walkthroughDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		walkthroughDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return walkthroughDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return walkthroughDAO.fetchAllStatus();
	}
}
