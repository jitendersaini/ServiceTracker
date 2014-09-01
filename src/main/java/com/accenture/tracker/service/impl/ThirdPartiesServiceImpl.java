/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.ThirdPartyDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Projects;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.hibernate.domains.ThirdParty;
import com.accenture.tracker.service.ThirdPartiesService;

/**
 * @author j.saini
 * 
 */
@Service
public class ThirdPartiesServiceImpl implements ThirdPartiesService {

	@Autowired
	ThirdPartyDAO thirdPartyDAO;

	@Override
	public List<Projects> fetchAllProjects() {
		return thirdPartyDAO.fetchAllProjects();
	}

	@Override
	public List<Operations> fetchAllOperations() {
		return thirdPartyDAO.fetchAllOperations();
	}

	@Override
	public List<ThirdParty> search() {
		return thirdPartyDAO.search();
	}

	@Override
	public void save(ThirdParty thirdParty) {
		if (thirdParty.getId() == null) {
			thirdParty.setCreatedDate(new Date());
		}
		thirdParty.setModifiedDate(new Date());

		thirdPartyDAO.save(thirdParty);
	}

	@Override
	public ThirdParty fetchById(Long id) {
		return thirdPartyDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		thirdPartyDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return thirdPartyDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return thirdPartyDAO.fetchAllStatus();
	}
}
