/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.TestingDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.Testing;
import com.accenture.tracker.service.TestingService;

/**
 * @author j.saini
 * 
 */
@Service
public class TestingServiceImpl implements TestingService {

	@Autowired
	TestingDAO testingDAO;

	@Override
	public List<Projects> fetchAllProjects() {
		return testingDAO.fetchAllProjects();
	}

	@Override
	public List<Operations> fetchAllOperations() {
		return testingDAO.fetchAllOperations();
	}

	@Override
	public List<Testing> search() {
		return testingDAO.search();
	}

	@Override
	public void save(Testing testing) {
		if (testing.getId() == null) {
			testing.setCreatedDate(new Date());
		}
		testing.setModifiedDate(new Date());

		testingDAO.save(testing);
	}

	@Override
	public Testing fetchById(Long id) {
		return testingDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		testingDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return testingDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return testingDAO.fetchAllStatus();
	}
}
