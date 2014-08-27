package com.accenture.tracker.hibernate.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author j.saini
 *
 */
@Entity
@Table(name = "work_environment")
public class WorkEnvironment implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 91967812462673062L;

	private Long id;
	private String priority;
	
	private String requirements;

	private Projects projects;

	private Operations operations;

	private Date startDate;
	private Date endDate;
	private String leadTime;

	private String docs;
	private Integer completion;
	private String status;
	private String progress;

	private Date createdDate;
	private Date modifiedDate;

	public WorkEnvironment() {
	}

	public WorkEnvironment(Long id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param priority
	 * @param requirements
	 * @param projects
	 * @param operations
	 * @param startDate
	 * @param endDate
	 * @param leadTime
	 * @param docs
	 * @param completion
	 * @param status
	 * @param progress
	 * @param createdDate
	 * @param modifiedDate
	 */
	public WorkEnvironment(Long id, String priority, String requirements,
			Projects projects, Operations operations, Date startDate,
			Date endDate, String leadTime, String docs, Integer completion,
			String status, String progress, Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.priority = priority;
		this.requirements = requirements;
		this.projects = projects;
		this.operations = operations;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leadTime = leadTime;
		this.docs = docs;
		this.completion = completion;
		this.status = status;
		this.progress = progress;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	

	/**
	 * @return the requirements
	 */
	@Column(name = "requirements", length=400)
	public String getRequirements() {
		return requirements;
	}

	/**
	 * @param requirements the requirements to set
	 */
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	/**
	 * @return the priority
	 */
	@Column(name = "priority", length = 3)
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
	 * @return the projects
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	public Projects getProjects() {
		return projects;
	}

	/**
	 * @param projects
	 *            the projects to set
	 */
	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	/**
	 * @return the operations
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "operation_id")
	public Operations getOperations() {
		return operations;
	}

	/**
	 * @param operations
	 *            the operations to set
	 */
	public void setOperations(Operations operations) {
		this.operations = operations;
	}

	/**
	 * @return the startDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_date", length = 19)
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_date", length = 19)
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the leadTime
	 */
	@Column(name = "lead_time", length = 200)
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
	 * @return the docs
	 */
	@Column(name = "documents", length = 200)
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
	 * @return the completion
	 */
	@Column(name = "completion")
	public Integer getCompletion() {
		return completion;
	}

	/**
	 * @param completion
	 *            the completion to set
	 */
	public void setCompletion(Integer completion) {
		this.completion = completion;
	}

	/**
	 * @return the status
	 */
	@Column(name = "status", length = 200)
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
	 * @return the progress
	 */
	@Column(name = "progress", length = 400)
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
	 * @return the createdDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", length = 19)
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedDate
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date", length = 19)
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}