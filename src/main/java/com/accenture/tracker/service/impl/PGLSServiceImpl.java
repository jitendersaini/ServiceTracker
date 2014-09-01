/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.PGLSDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.PGLS;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.PGLSService;

/**
 * @author j.saini
 * 
 */
@Service
public class PGLSServiceImpl implements PGLSService {

	@Autowired
	PGLSDAO pGLSDAO;

	@Override
	public List<Projects> fetchAllProjects() {		
		return pGLSDAO.fetchAllProjects();
	}

	@Override
	public List<Operations> fetchAllOperations() {
		return pGLSDAO.fetchAllOperations();
	}

	@Override
	public List<PGLS> search() {
		return pGLSDAO.search();
	}

	@Override
	public void save(PGLS pgls) {
		if (pgls.getId() == null) {
			pgls.setCreatedDate(new Date());
		}
		pgls.setModifiedDate(new Date());
		
		pGLSDAO.save(pgls);
	}

	@Override
	public PGLS fetchById(Long id) {
		return pGLSDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		pGLSDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return pGLSDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return pGLSDAO.fetchAllStatus();
	}
}
