/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.OperationsDAO;
import com.accenture.tracker.hibernate.domains.Operations;
import com.accenture.tracker.service.OperationsService;

/**
 * @author j.saini
 * 
 */
@Service
public class OperationsServiceImpl implements OperationsService {

	@Autowired
	OperationsDAO operationsDAO;

	@Override
	public List<Operations> search() {		
		return operationsDAO.search();
	}
	
	
	@Override
	public List<Operations> searchForUsersReg() {
		List<Operations> list = operationsDAO.search();
		list.add(0, new Operations(null,"----Select Operations---"));
		return list;
	}

	@Override
	public void save(Operations operations, Long loginId) {
		if (operations.getId() == null) {
			operations.setCreatedDate(new Date());
		}
		operations.setModifiedDate(new Date());
		operationsDAO.save(operations);
	}

	@Override
	public Operations fetchById(Long id) {
		return operationsDAO.fetchById(id);
	}

	@Override
	public void remove(String id) {
		operationsDAO.remove(id);
	}
}
