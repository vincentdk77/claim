package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerLinkDto implements Serializable{

	private static final long serialVersionUID = 1L;
	/** 日期 */
	private String jobDate = "";
	/** 班次名称  AM 白班 PM夜班*/
	private String dateType = "";
	/** 查勘人员 */
	private String handlerCode = "";
	/** 查勘人员 */
	private String handlerName = "";
	/** 作业区域 */
	private String areaName = "";
	/** 联系电话 */
	private String phone = "";
	/** 工作角色 1 车物查勘 2 人伤查勘 12车物人伤查勘 3非车*/
	private String jobrole = "";
	/** 已派工数量 */
	private String checkCount;

	public String getJobDate() {
		return jobDate;
	}

	public void setJobDate(String jobDate) {
		this.jobDate = jobDate;
	}

	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getJobrole() {
		return jobrole;
	}

	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}

	public String getCheckCount() {
		return checkCount;
	}

	public void setCheckCount(String checkCount) {
		this.checkCount = checkCount;
	}
}
