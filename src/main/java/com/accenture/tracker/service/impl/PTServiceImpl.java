/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.PTDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.ProcessAndTools;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.PTService;

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
}
