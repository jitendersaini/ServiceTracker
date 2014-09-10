/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.PGLSDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.PGLS;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.PGLSService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class PGLSServiceImpl implements PGLSService {

	@Autowired
	PGLSDAO pGLSDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return pGLSDAO.fetchAllOperations();
	}

	@Override
	public List<PGLS> search(String projectid) {
		return pGLSDAO.search(projectid);
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

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<PGLS> listPgls = pGLSDAO.search(projectid);

		List<DataObject> list = new ArrayList<DataObject>();

		DataObject doj = null;

		for (PGLS object : listPgls) {
			doj = new DataObject();
			doj.setId(object.getId().toString());
			doj.setDocs(object.getDocs());
			doj.setEndDate(AppConstants.convertDate(object.getEndDate()));
			doj.setLeadTime(object.getLeadTime());
			doj.setPercentage(object.getCompletion().toString());
			doj.setPriority(object.getPriorities().getPriority());
			doj.setProgress(object.getProgress());
			doj.setProjects(object.getProjects().getProjectName());
			doj.setRequirements(object.getRequirements());
			doj.setResponseOperation(object.getOperations().getName());
			doj.setStartDate(AppConstants.convertDate(object.getStartDate()));
			doj.setStatus(object.getStatus().getStatus());
			list.add(doj);
		}
		return list;
	}
}
