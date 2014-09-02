/**
 * 
 */
package com.accenture.tracker.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.tracker.dao.ChartDAO;
import com.accenture.tracker.util.MyHibernateSessionFactory;

/**
 * @author j.saini
 * 
 */
@Repository
@Transactional
public class ChartDAOImpl extends MyHibernateSessionFactory implements ChartDAO {

	@Override
	public Double fetchWorkEnvDetails(String projectid) {

		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM WorkEnvironment alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchAODetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM AoAccess alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchCodeFreezeDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM CodeFreeze alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchKTDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM KT alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchPGLSDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM PGLS alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchProcessToolsDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM ProcessAndTools alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchRhearSalDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM Rehearsal alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchReleaseDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM Release alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchSupportDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM SupportScope alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchTestingDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM Testing alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchThirdPartyDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM ThirdParty alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}

	@Override
	public Double fetchWalkThroughDetails(String projectid) {
		return (Double) getSession()
				.createQuery(
						"Select avg(alias.completion) FROM Walkthrough alias where projects.id = ?")
				.setParameter(0, Long.valueOf(projectid)).list().get(0);
	}
}
