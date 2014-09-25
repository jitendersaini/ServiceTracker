/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.KTDAO;
import com.accenture.tracker.hibernate.domains.KT;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.json.DataObject;
import com.accenture.tracker.service.KTService;
import com.accenture.tracker.util.AppConstants;

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

	@Override
	public List<DataObject> searchForJson(String projectid) {
		List<KT> listKT =  ktDAO.search(projectid);
		
		List<DataObject> list = new ArrayList<DataObject>();
		
		DataObject doj = null;
		
		for (KT kt : listKT) {
			doj = new DataObject();			
			doj.setId(kt.getId().toString());
			doj.setDocs(kt.getDocs());
			doj.setEndDate(AppConstants.convertDate(kt.getEndDate()));
			doj.setLeadTime(kt.getLeadTime());
			doj.setPercentage(kt.getCompletion().toString());
			doj.setPriority(kt.getPriorities().getPriority());
			doj.setProgress(kt.getProgress());
			doj.setProjects(kt.getProjects().getProjectName());
			doj.setRequirements(kt.getRequirements());
			doj.setResponseOperation(kt.getOperations().getName());
			doj.setStartDate(AppConstants.convertDate(kt.getStartDate()));
			doj.setStatus(kt.getStatus().getStatus());
			if(kt.getKtStatus() == 0) {
				doj.setKtStatus(AppConstants.FLAG_GREEN);
			} else if(kt.getKtStatus() == 1) {
				doj.setKtStatus(AppConstants.FLAG_AMBER);
			} else if(kt.getKtStatus() == 2) {
				doj.setKtStatus(AppConstants.FLAG_RED);
			}
			list.add(doj);
		}		
		return list;
	}

	@Override
	public Map<Short, String> fetchAllKtStatus() {
		Map<Short,String> map = new HashMap<Short, String>();
		map.put((short)0, "Green");		
		map.put((short)1, "Amber");
		map.put((short)2, "Red");
		return map;
	}
}
