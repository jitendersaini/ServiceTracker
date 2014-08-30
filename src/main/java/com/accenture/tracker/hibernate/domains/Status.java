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
@Table(name = "status")
public class Status implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 91967812462673062L;

	private Long id;
	private String status;

	private Date createdDate;
	private Date modifiedDate;

	private Users createdBy;
	private Users modifiedBy;

	public Status() {
	}

	public Status(Long id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param status
	 * @param createdDate
	 * @param modifiedDate
	 * @param createdBy
	 * @param modifiedBy
	 */
	public Status(Long id, String status, Date createdDate, Date modifiedDate,
			Users createdBy, Users modifiedBy) {
		super();
		this.id = id;
		this.status = status;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
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
	 * @return the status
	 */
	@Column(name = "status", length = 100)
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

	/**
	 * @return the createdBy
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by")
	public Users getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the modifiedBy
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "modified_by")
	public Users getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(Users modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

}