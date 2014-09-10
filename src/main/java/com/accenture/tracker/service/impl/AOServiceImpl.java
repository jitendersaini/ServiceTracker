/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.AODAO;
import com.accenture.tracker.hibernate.domains.AoAccess;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.AOService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class AOServiceImpl implements AOService {

	@Autowired
	AODAO aODAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return aODAO.fetchAllOperations();
	}

	@Override
	public List<AoAccess> search(String projectid) {
		return aODAO.search(projectid);
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

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<AoAccess> listAoAccess =  aODAO.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (AoAccess object : listAoAccess) {
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
