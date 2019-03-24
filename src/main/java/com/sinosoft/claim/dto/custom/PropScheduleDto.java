package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class PropScheduleDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������ */
	private String registNo;
	/** ���� */
	private String riskCode;
	/** �鿱����λ���� */
	private String scheduleObjectID;
	/** �鿱����λ */
	private String scheduleObjectName;
	/** �鿱��ַ */
	private String checkSite;
	/** �鿱Ҫ����ʾ */
	private String checkInfo;
	/** �鿱��Ա���� */
	private String nextHandlerCode1;
	/** �鿱��Ա */
	private String nextHandlerName1;
	/** ������Ա���� */
	private String operatorCode;
	/** ������Ա */
	private String operatorName;
	/** ������������ */
	private String makeComCode;
	/** �������� */
	private String makeComName;

	private RegistExtDto[] registExtDto;

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}

	public String getScheduleObjectID() {
		return scheduleObjectID;
	}

	public void setScheduleObjectID(String scheduleObjectID) {
		this.scheduleObjectID = scheduleObjectID;
	}

	public String getScheduleObjectName() {
		return scheduleObjectName;
	}

	public void setScheduleObjectName(String scheduleObjectName) {
		this.scheduleObjectName = scheduleObjectName;
	}

	public String getCheckSite() {
		return checkSite;
	}

	public void setCheckSite(String checkSite) {
		this.checkSite = checkSite;
	}

	public String getCheckInfo() {
		return checkInfo;
	}

	public void setCheckInfo(String checkInfo) {
		this.checkInfo = checkInfo;
	}

	public String getNextHandlerCode1() {
		return nextHandlerCode1;
	}

	public void setNextHandlerCode1(String nextHandlerCode1) {
		this.nextHandlerCode1 = nextHandlerCode1;
	}

	public String getNextHandlerName1() {
		return nextHandlerName1;
	}

	public void setNextHandlerName1(String nextHandlerName1) {
		this.nextHandlerName1 = nextHandlerName1;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getMakeComCode() {
		return makeComCode;
	}

	public void setMakeComCode(String makeComCode) {
		this.makeComCode = makeComCode;
	}

	public String getMakeComName() {
		return makeComName;
	}

	public void setMakeComName(String makeComName) {
		this.makeComName = makeComName;
	}

	public RegistExtDto[] getRegistExtDto() {
		return registExtDto;
	}

	public void setRegistExtDto(RegistExtDto[] registExtDto) {
		this.registExtDto = registExtDto;
	}

}
