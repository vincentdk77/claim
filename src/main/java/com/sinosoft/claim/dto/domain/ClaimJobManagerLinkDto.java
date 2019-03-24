package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerLinkDto implements Serializable{

	private static final long serialVersionUID = 1L;
	/** ���� */
	private String jobDate = "";
	/** �������  AM �װ� PMҹ��*/
	private String dateType = "";
	/** �鿱��Ա */
	private String handlerCode = "";
	/** �鿱��Ա */
	private String handlerName = "";
	/** ��ҵ���� */
	private String areaName = "";
	/** ��ϵ�绰 */
	private String phone = "";
	/** ������ɫ 1 ����鿱 2 ���˲鿱 12�������˲鿱 3�ǳ�*/
	private String jobrole = "";
	/** ���ɹ����� */
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
