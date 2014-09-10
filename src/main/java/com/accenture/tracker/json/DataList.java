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
public class DataList {

	private List<DataObject> data;

	public List<DataObject> getData() {
		return data;
	}

	public void setData(List<DataObject> data) {
		this.data = data;
	}
}
