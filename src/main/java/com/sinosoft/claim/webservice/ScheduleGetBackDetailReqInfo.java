package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * ����ϵͳ������ϸ��ʷ��Ϣ:�������
 * @author Administrator
 *
 */
public class ScheduleGetBackDetailReqInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**�����ǼǺ�*/
	private String registNo;
	/**����ʱ��*/
	private String flowInTime;
	/**���Ȳ���Ա����*/
	private String handlerCode;
	/**���Ȳ���Ա����*/
	private String handlerName;
	/**�鿱/������Ա����*/
	private String beforeHandlerCode;
	/**�鿱/������Ա����*/
	private String beforeHandlerName;
	/**���ȶ������*/
	private String lossItemCode;
	/**���ȶ�������*/
	private String lossItemName;
	/**�ڵ�ID*/
	private String flowId;
	/**�ڵ����*/
	private String logNo;
	private String userCode;
	private String comCode;

	public ScheduleGetBackDetailReqInfo() {
		super();
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getFlowInTime() {
		return flowInTime;
	}
	public void setFlowInTime(String flowInTime) {
		this.flowInTime = flowInTime;
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
	public String getBeforeHandlerCode() {
		return beforeHandlerCode;
	}
	public void setBeforeHandlerCode(String beforeHandlerCode) {
		this.beforeHandlerCode = beforeHandlerCode;
	}
	public String getBeforeHandlerName() {
		return beforeHandlerName;
	}
	public void setBeforeHandlerName(String beforeHandlerName) {
		this.beforeHandlerName = beforeHandlerName;
	}
	public String getLossItemCode() {
		return lossItemCode;
	}
	public void setLossItemCode(String lossItemCode) {
		this.lossItemCode = lossItemCode;
	}
	public String getLossItemName() {
		return lossItemName;
	}
	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
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
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	

}
