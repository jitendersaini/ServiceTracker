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
@Table(name = "tabs")
public class Tabs implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 91967812462673062L;

	private Long id;
	private String tabTitle;
	private String tabURL;
	private Integer access;
	private Date createdDate;
	private Date modifiedDate;

	public Tabs() {
	}

	public Tabs(Long id) {
		this.id = id;
	}

	/**
	 * @param id
	 * @param tabTitle
	 * @param tabURL
	 * @param access
	 * @param createdDate
	 * @param modifiedDate
	 */
	public Tabs(Long id, String tabTitle, String tabURL, Integer access,
			Date createdDate, Date modifiedDate) {
		super();
		this.id = id;
		this.tabTitle = tabTitle;
		this.tabURL = tabURL;
		this.access = access;
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
	 * @return the tabTitle
	 */
	@Column(name = "tab_title", length = 100)
	public String getTabTitle() {
		return tabTitle;
	}

	/**
	 * @param tabTitle
	 *            the tabTitle to set
	 */
	public void setTabTitle(String tabTitle) {
		this.tabTitle = tabTitle;
	}

	/**
	 * @return the tabURL
	 */
	@Column(name = "tab_url", length = 200)
	public String getTabURL() {
		return tabURL;
	}

	/**
	 * @param tabURL
	 *            the tabURL to set
	 */
	public void setTabURL(String tabURL) {
		this.tabURL = tabURL;
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
	 * @return the access
	 */
	@Column(name = "users_access")
	public Integer getAccess() {
		return access;
	}

	/**
	 * @param access
	 *            the access to set
	 */
	public void setAccess(Integer access) {
		this.access = access;
	}

}