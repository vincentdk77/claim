package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * 理赔系统改派:入参对象
 * @author Administrator
 *
 */
public class ScheduleGetBackReqInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**报案号*/
	private String registNo;
	/**险种代码*/
	private String riskCode;
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
	/**节点ID*/
	private String flowId;
	/**节点序号*/
	private String logNo;
	/**操作人员代码*/
	private String operatorCode;
	/**操作日期*/
	private String inputDate;
	/**操作时间(hh24:mi:ss)*/
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
