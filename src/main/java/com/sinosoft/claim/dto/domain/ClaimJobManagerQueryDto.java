package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerQueryDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ���������� */
	private String deptCode = "";
	/** ���������� */
	private String deptName = "";
	/** ������Ա���� */
	private String handlerCode = "";
	/** ������Ա���� */
	private String handlerName = "";
	/** ����·� */
	private String month = "";
	/** ���� */
	private String classcode = "";
	/** ά����Ա */
	private String operator = "";
	/** ά��ʱ�� */
	private String modifytime = "";

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

}
