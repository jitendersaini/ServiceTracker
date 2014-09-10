/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.WorkEnvDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.WorkEnvironment;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.WorkEnvService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class WorkEnvServiceImpl implements WorkEnvService {

	@Autowired
	WorkEnvDAO workEnvDao;

	@Override
	public List<Operations> fetchAllOperations() {
		return workEnvDao.fetchAllOperations();
	}
	
	@Override
	public List<WorkEnvironment> search(String projectid) {
		return workEnvDao.search(projectid);
	}

	@Override
	public void save(WorkEnvironment workEnvironment) {
		if (workEnvironment.getId() == null) {
			workEnvironment.setCreatedDate(new Date());
		}
		workEnvironment.setModifiedDate(new Date());
		
		workEnvDao.save(workEnvironment);
	}

	@Override
	public WorkEnvironment fetchById(Long id) {
		return workEnvDao.fetchById(id);
	}

	@Override
	public void remove(String id) {
		workEnvDao.remove(id);
	}

	@Override	
	public List<Priorities> fetchAllPriorites() {
		return workEnvDao.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return workEnvDao.fetchAllStatus();
	}

	@Override
	public List<DataObject> searchForJson(String projectid) {
		
		List<WorkEnvironment> listWork =  workEnvDao.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (WorkEnvironment workEnvironment : listWork) {
			doj = new DataObject();			
			doj.setId(workEnvironment.getId().toString());
			doj.setDocs(workEnvironment.getDocs());
			doj.setEndDate(AppConstants.convertDate(workEnvironment.getEndDate()));
			doj.setLeadTime(workEnvironment.getLeadTime());
			doj.setPercentage(workEnvironment.getCompletion().toString());
			doj.setPriority(workEnvironment.getPriorities().getPriority());
			doj.setProgress(workEnvironment.getProgress());
			doj.setProjects(workEnvironment.getProjects().getProjectName());
			doj.setRequirements(workEnvironment.getRequirements());
			doj.setResponseOperation(workEnvironment.getOperations().getName());
			doj.setStartDate(AppConstants.convertDate(workEnvironment.getStartDate()));
			doj.setStatus(workEnvironment.getStatus().getStatus());
			list.add(doj);
		}		
		return list;
	}
}
