/**
 * 
 */
package com.accenture.tracker.json;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author j.saini
 *
 */
@XmlRootElement(name = "data")
public class DataObject implements Serializable {

	private static final long serialVersionUID = 5619388866353307340L;

	private String id;
	private String leadTime;
	private String requirements;
	private String responseOperation;
	private String projects;
	private String startDate;
	private String endDate;
	private String progress;
	private String status;
	private String priority;
	private String docs;
	private String percentage;
	private String ktStatus;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the leadTime
	 */
	public String getLeadTime() {
		return leadTime;
	}

	/**
	 * @param leadTime
	 *            the leadTime to set
	 */
	public void setLeadTime(String leadTime) {
		this.leadTime = leadTime;
	}

	/**
	 * @return the requirements
	 */
	public String getRequirements() {
		return requirements;
	}

	/**
	 * @param requirements
	 *            the requirements to set
	 */
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	/**
	 * @return the responseOperation
	 */
	public String getResponseOperation() {
		return responseOperation;
	}

	/**
	 * @param responseOperation
	 *            the responseOperation to set
	 */
	public void setResponseOperation(String responseOperation) {
		this.responseOperation = responseOperation;
	}

	/**
	 * @return the projects
	 */
	public String getProjects() {
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(String projects) {
		this.projects = projects;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}

	/**
	 * @param progress
	 *            the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the docs
	 */
	public String getDocs() {
		return docs;
	}

	/**
	 * @param docs
	 *            the docs to set
	 */
	public void setDocs(String docs) {
		this.docs = docs;
	}

	/**
	 * @return the percentage
	 */
	public String getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage
	 *            the percentage to set
	 */
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	/**
	 * @return the ktStatus
	 */
	public String getKtStatus() {
		return ktStatus;
	}

	/**
	 * @param ktStatus
	 *            the ktStatus to set
	 */
	public void setKtStatus(String ktStatus) {
		this.ktStatus = ktStatus;
	}

}
