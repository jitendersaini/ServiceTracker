/**
 * 
 */
package com.accenture.tracker.json;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author j.saini
 *
 */
@XmlRootElement(name = "data")
public class DataListUser {

	private List<DataObjectUser> data;

	public List<DataObjectUser> getData() {
		return data;
	}

	public void setData(List<DataObjectUser> data) {
		this.data = data;
	}
}
