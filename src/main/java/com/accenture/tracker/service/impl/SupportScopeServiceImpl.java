/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.SupportScopeDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.SupportScope;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.SupportScopeService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class SupportScopeServiceImpl implements SupportScopeService {

	@Autowired
	SupportScopeDAO supportScopeDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return supportScopeDAO.fetchAllOperations();
	}

	@Override
	public List<SupportScope> search(String projectid) {
		return supportScopeDAO.search(projectid);
	}

	@Override
	public void save(SupportScope supportScope) {
		if (supportScope.getId() == null) {
			supportScope.setCreatedDate(new Date());
		}
		supportScope.setModifiedDate(new Date());
		
		supportScopeDAO.save(supportScope);
	}

	@Override
	public SupportScope fetchById(Long id) {
		return supportScopeDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		supportScopeDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return supportScopeDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return supportScopeDAO.fetchAllStatus();
	}

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<SupportScope> listSupport =  supportScopeDAO.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (SupportScope object : listSupport) {
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
