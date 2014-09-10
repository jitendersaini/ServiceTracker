/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.ReleaseDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Release;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.ReleaseService;
import com.accenture.tracker.util.AppConstants;

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

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<Release> listRelease =  releaseDAO.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (Release object : listRelease) {
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
