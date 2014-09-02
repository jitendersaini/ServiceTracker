/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.WorkEnvDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.WorkEnvironment;
import com.accenture.tracker.service.WorkEnvService;

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
}
