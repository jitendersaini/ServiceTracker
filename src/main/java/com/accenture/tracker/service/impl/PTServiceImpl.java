/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.PTDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.ProcessAndTools;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.PTService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class PTServiceImpl implements PTService {

	@Autowired
	PTDAO ptDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return ptDAO.fetchAllOperations();
	}

	@Override
	public List<ProcessAndTools> search(String projectid) {
		return ptDAO.search(projectid);
	}

	@Override
	public void save(ProcessAndTools pt) {
		if (pt.getId() == null) {
			pt.setCreatedDate(new Date());
		}
		pt.setModifiedDate(new Date());
		
		ptDAO.save(pt);
	}

	@Override
	public ProcessAndTools fetchById(Long id) {
		return ptDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		ptDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return ptDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return ptDAO.fetchAllStatus();
	}

	@Override
	public List<DataObject> searchForJson(String projectId) {
		List<ProcessAndTools> listPT =  ptDAO.search(projectId);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (ProcessAndTools object : listPT) {
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
