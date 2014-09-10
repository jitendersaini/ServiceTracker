/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.RehearsalDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Rehearsal;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.RehearsalService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class RehearsalServiceImpl implements RehearsalService {

	@Autowired
	RehearsalDAO rehearsalDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return rehearsalDAO.fetchAllOperations();
	}

	@Override
	public List<Rehearsal> search(String projectid) {
		return rehearsalDAO.search(projectid);
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

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<Rehearsal> listRehearsal =  rehearsalDAO.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (Rehearsal object : listRehearsal) {
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
