/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.WorkEnvDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Projects;
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
	public List<Projects> fetchAllProjects() {		
		return workEnvDao.fetchAllProjects();
	}

	@Override
	public List<Operations> fetchAllOperations() {
		return workEnvDao.fetchAllOperations();
	}

	@Override
	public List<WorkEnvironment> search() {
		return workEnvDao.search();
	}
}
