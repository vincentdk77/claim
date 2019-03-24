package com.sinosoft.workrove.util;

import java.io.Serializable;

public class DTreeDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id = "";
	public String parentId = "";
	public String name = "";
	public String url  ="";
	public String title = "";
	public String target = "";
	public String openFlag = "false";
	public String checkBox = "false";
	public String checkStatus = "false";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getOpenFlag() {
		return openFlag;
	}
	public void setOpenFlag(String openFlag) {
		this.openFlag = openFlag;
	}
	public String getCheckBox() {
		return checkBox;
	}
	public void setCheckBox(String checkBox) {
		this.checkBox = checkBox;
	}
	public String getCheckStatus() {
		return checkStatus;
	}
	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
