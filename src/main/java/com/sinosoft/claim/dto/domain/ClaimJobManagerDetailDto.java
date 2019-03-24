package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerDetailDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** 查勘代码 */
	private String handlerCode = "";
	/** 查勘人员 */
	private String handlerName = "";
	/** 工作角色 1车物查勘 2人伤 12车物人伤 3非车查勘*/
	private String jobRole = "";
	/** 所在机构代码 */
	private String comCode = "";
	/** 所在机构名称 */
	private String comName = "";
	/** 白班工作日期 */
	private String[] workTimeAm;
	/** 晚班工作日期 */
	private String[] workTimePm;

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

	public String getJobRole() {
		return jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String[] getWorkTimeAm() {
		return workTimeAm;
	}

	public void setWorkTimeAm(String[] workTimeAm) {
		this.workTimeAm = workTimeAm;
	}

	public String[] getWorkTimePm() {
		return workTimePm;
	}

	public void setWorkTimePm(String[] workTimePm) {
		this.workTimePm = workTimePm;
	}
}
