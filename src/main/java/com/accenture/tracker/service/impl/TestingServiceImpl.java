/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.TestingDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.Testing;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.TestingService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class TestingServiceImpl implements TestingService {

	@Autowired
	TestingDAO testingDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return testingDAO.fetchAllOperations();
	}

	@Override
	public List<Testing> search(String projectid) {
		return testingDAO.search(projectid);
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

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<Testing> listTesting =  testingDAO.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (Testing object : listTesting) {
			doj = new DataObject();			
			doj.setId(object.getId().toString());
			doj.setDocs(object.getDocs());
			doj.setEndDate(AppConstants.convertDate(object.getEndDate()));
			doj.setLeadTime(object.getLeadTime());
			doj.setPercentage(object.getCompletion().toString());
			doj.setPriority(object.getPriorities().getPriority());
			doj.setProgress(object.getProgress());
			doj.setProjects(object.getProjects().getProjectName());
			doj.setRequirements(object.getRequirements());
			doj.setResponseOperation(object.getOperations().getName());
			doj.setStartDate(AppConstants.convertDate(object.getStartDate()));
			doj.setStatus(object.getStatus().getStatus());
			list.add(doj);
		}		
		return list;
	}
}
