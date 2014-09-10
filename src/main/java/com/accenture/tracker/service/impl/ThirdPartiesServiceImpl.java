/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.ThirdPartyDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.ThirdParty;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.ThirdPartiesService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class ThirdPartiesServiceImpl implements ThirdPartiesService {

	@Autowired
	ThirdPartyDAO thirdPartyDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return thirdPartyDAO.fetchAllOperations();
	}

	@Override
	public List<ThirdParty> search(String projectid) {
		return thirdPartyDAO.search(projectid);
	}

	@Override
	public void save(ThirdParty thirdParty) {
		if (thirdParty.getId() == null) {
			thirdParty.setCreatedDate(new Date());
		}
		thirdParty.setModifiedDate(new Date());

		thirdPartyDAO.save(thirdParty);
	}

	@Override
	public ThirdParty fetchById(Long id) {
		return thirdPartyDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		thirdPartyDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return thirdPartyDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return thirdPartyDAO.fetchAllStatus();
	}

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<ThirdParty> listTP =  thirdPartyDAO.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (ThirdParty object : listTP) {
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
