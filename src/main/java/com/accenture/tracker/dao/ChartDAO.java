/**
 * 
 */
package com.accenture.tracker.dao;


/**
 * @author j.saini
 *
 */
public interface ChartDAO {

	Double fetchWorkEnvDetails(String projectid);

	Double fetchAODetails(String projectid);

	Double fetchCodeFreezeDetails(String projectid);

	Double fetchKTDetails(String projectid);

	Double fetchPGLSDetails(String projectid);

	Double fetchProcessToolsDetails(String projectid);

	Double fetchRhearSalDetails(String projectid);

	Double fetchReleaseDetails(String projectid);

	Double fetchSupportDetails(String projectid);

	Double fetchTestingDetails(String projectid);

	Double fetchThirdPartyDetails(String projectid);

	Double fetchWalkThroughDetails(String projectid);

}
