package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * ����ϵͳ������ϸ��ʷ��Ϣ:������ϸ��ʷ��Ϣ
 * @author Administrator
 *
 */
public class ScheduleGetBackDetailDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**������*/
	private String registNo;
	/**������*/
	private String policyNo;
	/**��ϵ������*/
	private String linkerName;
	/**��ϵ�绰*/
	private String phoneNumber;
	/**�����˴���*/
	private String agentCode;
	/**����������*/
	private String agentName;
	/**���⴦�����*/
	private String comCode;
	/**���⴦���������*/
	private String comName;
	/**����Ա*/
	private String operatorCode;
	/**����Ա����*/
	private String operatorName;
	/**������CNY*/
	private String estimateLoss = "0";
	/**��������(yyyy-mm-dd)*/
	private String inputDate;
	/**����ʱ��(hh24:mi)*/
	private String inputHour;
	/**���ȴ���*/
	private String surveyNo ="0";
	/**�������*/
	private String registText;
	/**�鿱����λ����*/
	private String scheduleObjectID;
	/**�鿱����λ����*/
	private String ScheduleObjectName;
	/**�鿱��ַ*/
	private String checkSite;
	/**�鿱Ҫ����ʾ*/
	private String checkInfo;
	/**�鿱��Ա����*/
	private String nextHandlerCode;
	/**�鿱��Ա����*/
	private String nextHandlerName;
	/**�Ƿ��������(1����/0����)*/
	private String flag;
	/**��ģ��ɸ��ɣ�(1����/0����)*/
	private String checkYesNo;
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getLinkerName() {
		return linkerName;
	}
	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	
	public String getInputDate() {
		return inputDate;
	}
	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	public String getInputHour() {
		return inputHour;
	}
	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
	}
	
	public String getRegistText() {
		return registText;
	}
	public void setRegistText(String registText) {
		this.registText = registText;
	}
	public String getScheduleObjectID() {
		return scheduleObjectID;
	}
	public void setScheduleObjectID(String scheduleObjectID) {
		this.scheduleObjectID = scheduleObjectID;
	}
	public String getScheduleObjectName() {
		return ScheduleObjectName;
	}
	public void setScheduleObjectName(String scheduleObjectName) {
		ScheduleObjectName = scheduleObjectName;
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
	public String getNextHandlerCode() {
		return nextHandlerCode;
	}
	public void setNextHandlerCode(String nextHandlerCode) {
		this.nextHandlerCode = nextHandlerCode;
	}
	public String getNextHandlerName() {
		return nextHandlerName;
	}
	public void setNextHandlerName(String nextHandlerName) {
		this.nextHandlerName = nextHandlerName;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getCheckYesNo() {
		return checkYesNo;
	}
	public void setCheckYesNo(String checkYesNo) {
		this.checkYesNo = checkYesNo;
	}
	
	
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public ScheduleGetBackDetailDtoInfo() {
		super();
	}
	public String getEstimateLoss() {
		return estimateLoss;
	}
	public void setEstimateLoss(String estimateLoss) {
		this.estimateLoss = estimateLoss;
	}
	public String getSurveyNo() {
		return surveyNo;
	}
	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}
	
	

}
