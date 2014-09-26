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
	public String fetchAll() {
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
		StringBuilder stb = new StringBuilder();
		for (AoAccess object : listAO) {
			stb.append("INSERT INTO ");
			stb.append("ao_access ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (CodeFreeze object : listCodeFreeze) {
			stb.append("INSERT INTO ");
			stb.append("code_freeze ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (KT object : listKT) {
			stb.append("INSERT INTO ");
			stb.append("knowledge_transition ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id,kt_status) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(","+object.getKtStatus());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (PGLS object : listPGLS) {
			stb.append("INSERT INTO ");
			stb.append("pgls ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (ProcessAndTools object : listPT) {
			stb.append("INSERT INTO ");
			stb.append("process_tools ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (Rehearsal object : listRehearsal) {
			stb.append("INSERT INTO ");
			stb.append("rehearsal ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (Release object : listRelease) {
			stb.append("INSERT INTO ");
			stb.append("releases ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (SupportScope object : listSC) {
			stb.append("INSERT INTO ");
			stb.append("support_scope ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (Testing object : listTesting) {
			stb.append("INSERT INTO ");
			stb.append("testing ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (ThirdParty object : listTP) {
			stb.append("INSERT INTO ");
			stb.append("third_party ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (Walkthrough object : listWalk) {
			stb.append("INSERT INTO ");
			stb.append("walkthrough ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}
		stb.append("<br><br>");
		for (WorkEnvironment object : listWorkEnv) {
			stb.append("INSERT INTO ");
			stb.append("work_environment ");
			stb.append("(completion,created_date,documents,end_date,lead_time,modified_date,progress,requirements,start_date,operation_id,priorities_id,project_id,status_id) VALUES (");
			stb.append(object.getCompletion());
			stb.append(",'"+object.getCreatedDate()+"'");
			stb.append(",'"+object.getDocs()+"'");
			stb.append(",'"+object.getEndDate()+"'");
			stb.append(",'"+object.getLeadTime()+"'");
			stb.append(",'"+object.getModifiedDate()+"'");
			stb.append(",'"+object.getProgress()+"'");
			stb.append(",'"+object.getRequirements()+"'");
			stb.append(",'"+object.getStartDate()+"'");
			stb.append(","+object.getOperations().getId());
			stb.append(","+object.getPriorities().getId());
			stb.append(","+object.getProjects().getId());
			stb.append(","+object.getStatus().getId());
			stb.append(")<br>");
		}		
		//System.out.println("stb----------> "+stb.toString());
		return stb.toString();
	}
}
