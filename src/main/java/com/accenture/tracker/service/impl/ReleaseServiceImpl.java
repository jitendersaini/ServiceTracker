/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.ReleaseDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Release;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.ReleaseService;

/**
 * @author j.saini
 * 
 */
@Service
public class ReleaseServiceImpl implements ReleaseService {

	@Autowired
	ReleaseDAO releaseDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return releaseDAO.fetchAllOperations();
	}

	@Override
	public List<Release> search(String projectid) {
		return releaseDAO.search(projectid);
	}

	@Override
	public void save(Release release) {
		if (release.getId() == null) {
			release.setCreatedDate(new Date());
		}
		release.setModifiedDate(new Date());
		
		releaseDAO.save(release);
	}

	@Override
	public Release fetchById(Long id) {
		return releaseDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		releaseDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return releaseDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return releaseDAO.fetchAllStatus();
	}
}
