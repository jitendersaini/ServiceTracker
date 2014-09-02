/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.KTDAO;
import com.accenture.tracker.hibernate.domains.KT;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.KTService;

/**
 * @author j.saini
 * 
 */
@Service
public class KTServiceImpl implements KTService {

	@Autowired
	KTDAO ktDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return ktDAO.fetchAllOperations();
	}

	@Override
	public List<KT> search(String projectid) {
		return ktDAO.search(projectid);
	}

	@Override
	public void save(KT kt) {
		if (kt.getId() == null) {
			kt.setCreatedDate(new Date());
		}
		kt.setModifiedDate(new Date());
		
		ktDAO.save(kt);
	}

	@Override
	public KT fetchById(Long id) {
		return ktDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		ktDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return ktDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return ktDAO.fetchAllStatus();
	}
}
