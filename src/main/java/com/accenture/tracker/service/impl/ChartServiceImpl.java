/**
 * 
 */
package com.accenture.tracker.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.tracker.dao.ChartDAO;
import com.accenture.tracker.service.ChartService;
import com.accenture.tracker.util.AppConstants;

/**
 * @author j.saini
 * 
 */
@Service
public class ChartServiceImpl implements ChartService {

	@Autowired
	ChartDAO chartDAO;
	
	@Override
	public Map<String, Double> retrieveMap4Chart(String projectid) {
		
		Double sumWork =  chartDAO.fetchWorkEnvDetails(projectid);
		Double sumAO =  chartDAO.fetchAODetails(projectid);
		Double sumCodeFreeze =  chartDAO.fetchCodeFreezeDetails(projectid);
		Double sumKT =  chartDAO.fetchKTDetails(projectid);
		Double sumPGLS =  chartDAO.fetchPGLSDetails(projectid);
		Double sumTools =  chartDAO.fetchProcessToolsDetails(projectid);
		Double sumRehearsal =  chartDAO.fetchRhearSalDetails(projectid);
		Double sumRelease =  chartDAO.fetchReleaseDetails(projectid);
		Double sumSupport =  chartDAO.fetchSupportDetails(projectid);
		Double sumTesting =  chartDAO.fetchTestingDetails(projectid);
		Double sumTP =  chartDAO.fetchThirdPartyDetails(projectid);
		Double sumWalkthrough =  chartDAO.fetchWalkThroughDetails(projectid);
		
		Map<String, Double> mapChart = new HashMap<String, Double>();
		
		mapChart.put("Work Env", AppConstants.formatNumber(sumWork));
		mapChart.put("Access for AO", AppConstants.formatNumber(sumAO));
		mapChart.put("Knowledge Transition", AppConstants.formatNumber(sumKT));
		mapChart.put("Code Freeze", AppConstants.formatNumber(sumCodeFreeze));
		mapChart.put("PGLS", AppConstants.formatNumber(sumPGLS));
		mapChart.put("Process & Tools", AppConstants.formatNumber(sumTools));
		mapChart.put("Rehearsal", AppConstants.formatNumber(sumRehearsal));
		mapChart.put("Release", AppConstants.formatNumber(sumRelease));
		mapChart.put("Testing", AppConstants.formatNumber(sumTesting));
		mapChart.put("Support Scope", AppConstants.formatNumber(sumSupport));
		mapChart.put("Third Parties", AppConstants.formatNumber(sumTP));
		mapChart.put("Walkthrough", AppConstants.formatNumber(sumWalkthrough));		
		
		return mapChart;
	}

}
