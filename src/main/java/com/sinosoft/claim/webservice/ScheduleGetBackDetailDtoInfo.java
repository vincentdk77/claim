package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * 理赔系统改派详细历史信息:改派详细历史信息
 * @author Administrator
 *
 */
public class ScheduleGetBackDetailDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**报案号*/
	private String registNo;
	/**保单号*/
	private String policyNo;
	/**联系人姓名*/
	private String linkerName;
	/**联系电话*/
	private String phoneNumber;
	/**代理人代码*/
	private String agentCode;
	/**代理人名称*/
	private String agentName;
	/**理赔处理机构*/
	private String comCode;
	/**理赔处理机构名称*/
	private String comName;
	/**调度员*/
	private String operatorCode;
	/**调度员名称*/
	private String operatorName;
	/**报损金额CNY*/
	private String estimateLoss = "0";
	/**调度日期(yyyy-mm-dd)*/
	private String inputDate;
	/**调度时间(hh24:mi)*/
	private String inputHour;
	/**调度次数*/
	private String surveyNo ="0";
	/**出险情况*/
	private String registText;
	/**查勘处理单位代码*/
	private String scheduleObjectID;
	/**查勘处理单位名称*/
	private String ScheduleObjectName;
	/**查勘地址*/
	private String checkSite;
	/**查勘要点提示*/
	private String checkInfo;
	/**查勘人员代码*/
	private String nextHandlerCode;
	/**查勘人员名称*/
	private String nextHandlerName;
	/**是否调公估行(1：是/0：否)*/
	private String flag;
	/**标的（可改派）(1：是/0：否)*/
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
