package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * ����ϵͳ����:��ζ���
 * @author Administrator
 *
 */
public class ScheduleGetBackReqInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**������*/
	private String registNo;
	/**���ִ���*/
	private String riskCode;
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
	/**�ڵ�ID*/
	private String flowId;
	/**�ڵ����*/
	private String logNo;
	/**������Ա����*/
	private String operatorCode;
	/**��������*/
	private String inputDate;
	/**����ʱ��(hh24:mi:ss)*/
	private String inputHour;
	public ScheduleGetBackReqInfo() {
		super();
	}
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
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getLogNo() {
		return logNo;
	}
	public void setLogNo(String logNo) {
		this.logNo = logNo;
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
	


}
