/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.SqlDao;
import com.accenture.tracker.hibernate.domains.AoAccess;
import com.accenture.tracker.hibernate.domains.CodeFreeze;
import com.accenture.tracker.hibernate.domains.KT;
import com.accenture.tracker.hibernate.domains.PGLS;
import com.accenture.tracker.hibernate.domains.ProcessAndTools;
import com.accenture.tracker.hibernate.domains.Rehearsal;
import com.accenture.tracker.hibernate.domains.Release;
import com.accenture.tracker.hibernate.domains.SqlObject;
import com.accenture.tracker.hibernate.domains.SupportScope;
import com.accenture.tracker.hibernate.domains.Testing;
import com.accenture.tracker.hibernate.domains.ThirdParty;
import com.accenture.tracker.hibernate.domains.Walkthrough;
import com.accenture.tracker.hibernate.domains.WorkEnvironment;
import com.accenture.tracker.service.SqlService;

/**
 * @author j.saini
 * 
 */
@Service
public class SqlServiceImpl implements SqlService {

	@Autowired
	SqlDao sqlDao;

	
	@Override
	public List<String> fetchAll() {
		// TODO Auto-generated method stub
		SqlObject sqlObject = sqlDao.fetchAll();
		
		List<AoAccess> listAO =  sqlObject.getListAccess();
		List<CodeFreeze> listCodeFreeze =  sqlObject.getListCodeFreeze();
		List<KT> listKT =  sqlObject.getListKT();
		List<PGLS> listPGLS =  sqlObject.getListPGLS();
		List<ProcessAndTools> listPT =  sqlObject.getListPT();		
		List<Rehearsal> listRehearsal =  sqlObject.getListRehearsal();
		List<Release> listRelease =  sqlObject.getListRelease();
		List<SupportScope> listSC =  sqlObject.getListSupportScope();
		List<Testing> listTesting =  sqlObject.getListTesting();
		List<ThirdParty> listTP =  sqlObject.getListThirdParty();
		List<Walkthrough> listWalk =  sqlObject.getListWalk();
		List<WorkEnvironment> listWorkEnv =  sqlObject.getListWorkEnv();
		StringBuilder stb = new StringBuilder("INSERT INTO ");
		for (AoAccess ao : listAO) {
			stb.append("ao_access ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(ao.getCompletion());
			stb.append(",'"+ao.getCreatedDate()+"'");
			stb.append(",'"+ao.getDocs()+"'");
			//INSERT INTO ao_access(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (1,NOW(),'documents','2014-02-11 11:07:32.0','12 days',NOW(),'Progress','Requirements','2014-02-11 11:07:32.0',1,1,1,1);
		}
		return null;
	}
}
