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
public class DataListAdmin {

	private List<DataObjectAdmin> data;

	public List<DataObjectAdmin> getData() {
		return data;
	}

	public void setData(List<DataObjectAdmin> data) {
		this.data = data;
	}
}
