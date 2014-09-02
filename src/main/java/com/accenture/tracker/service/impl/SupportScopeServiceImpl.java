/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.SupportScopeDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.SupportScope;
import com.accenture.tracker.service.SupportScopeService;

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
}
