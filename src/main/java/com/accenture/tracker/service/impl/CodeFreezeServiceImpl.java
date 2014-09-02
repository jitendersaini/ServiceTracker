/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.CodeFreezeDAO;
import com.accenture.tracker.hibernate.domains.CodeFreeze;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.hibernate.domains.Priorities;
import com.accenture.tracker.hibernate.domains.Status;
import com.accenture.tracker.service.CodeFreezeService;

/**
 * @author j.saini
 * 
 */
@Service
public class CodeFreezeServiceImpl implements CodeFreezeService {

	@Autowired
	CodeFreezeDAO codeFreezeDAO;

	@Override
	public List<Operations> fetchAllOperations() {
		return codeFreezeDAO.fetchAllOperations();
	}

	@Override
	public List<CodeFreeze> search(String projectid) {
		return codeFreezeDAO.search(projectid);
	}

	@Override
	public void save(CodeFreeze codeFreeze) {
		if (codeFreeze.getId() == null) {
			codeFreeze.setCreatedDate(new Date());
		}
		codeFreeze.setModifiedDate(new Date());
		
		codeFreezeDAO.save(codeFreeze);
	}

	@Override
	public CodeFreeze fetchById(Long id) {
		return codeFreezeDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		codeFreezeDAO.remove(id);
	}

	@Override
	public List<Priorities> fetchAllPriorites() {
		return codeFreezeDAO.fetchAllPriorites();
	}

	@Override
	public List<Status> fetchAllStatus() {
		return codeFreezeDAO.fetchAllStatus();
	}
}
