package com.accenture.tracker.hibernate.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author j.saini
 *
 */
@Entity
@Table(name = "projects")
public class Projects implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 91967812462673062L;

	private Long id;
	private String projectName;

	private Date createdDate;
	private Date modifiedDate;

	public Projects() {
	}

	public Projects(Long id) {
		this.id = id;
	}
	
	public Projects(Long id, String projectName) {
		this.id = id;
		this.projectName = projectName;
	}

	/**
	 * @param id
	 * @param projectName
	 * @param createdDate
	 * @param modifiedDate
	 */
	public Projects(Long id, String projectName, Date createdDate,
			Date modifiedDate) {
		super();
		this.id = id;
		this.projectName = projectName;
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
	 * @return the projectName
	 */
	@Column(name = "project_name", length = 145)
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName
	 *            the projectName to set
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
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