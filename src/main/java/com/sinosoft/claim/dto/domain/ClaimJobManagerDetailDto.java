package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerDetailDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** �鿱���� */
	private String handlerCode = "";
	/** �鿱��Ա */
	private String handlerName = "";
	/** ������ɫ 1����鿱 2���� 12�������� 3�ǳ��鿱*/
	private String jobRole = "";
	/** ���ڻ������� */
	private String comCode = "";
	/** ���ڻ������� */
	private String comName = "";
	/** �װ๤������ */
	private String[] workTimeAm;
	/** ��๤������ */
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
