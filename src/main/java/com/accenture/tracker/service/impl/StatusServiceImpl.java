/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.StatusDAO;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.StatusService;

/**
 * @author j.saini
 * 
 */
@Service
public class StatusServiceImpl implements StatusService {

	@Autowired
	StatusDAO statusDAO;

	@Override
	public List<Status> search() {
		return statusDAO.search();
	}

	@Override
	public void save(Status status, Long loginId) {
		if(status.getId() == null) {
			status.setCreatedDate(new Date());			
		}
		status.setModifiedDate(new Date());		
		statusDAO.save(status);
	}

	@Override
	public Status fetchById(Long id) {
		return statusDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		statusDAO.remove(id);
	}
}
