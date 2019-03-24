package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * ��ͨ���� ���ݿ�ײ�ӳ����
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicationDtoBase implements Serializable {
	/** ��ͨ���� ����Id�����ձ������룩  */
	private String communicationNo;
	/** ��ͨ���� */
	private String communicationTopic;
	/** �������� */
	private String registNo;
	/** ������������ */
	private String comCode;
	/** ������������ */
	private String comName;
	/** �����˴��� */
	private String userCode;
	/** ���������� */
	private String userName;
	/** �ڵ���� */
	private String nodeCode;
	/** �ڵ����� */
	private String nodeName;
	/** �������� */
	private String taskType;
	/** �������� */
	private String taskName;
	/** ����ʱ�� */
	private DateTime createTime = new DateTime();
	/** �ر����� */
	private DateTime closeTime  = new DateTime();
	/** �رշ�ʽ (1:�ֶ��ر�,0:�᰸�Զ��ر�) */
	private String closeMode;
	/** ��Ч��־ (1:δ�ر�,0:�ѹر�)*/
	private String validata;
	
	public PrplCommunicationDtoBase(){}
	
	/** ��ͨ���� ����Id�����ձ������룩  */
	public String getCommunicationNo() {
		return communicationNo;
	}
	/** ��ͨ���� ����Id�����ձ������룩  */
	public void setCommunicationNo(String communicationNo) {
		this.communicationNo = communicationNo;
	}
	/** ��ͨ���� */
	public String getCommunicationTopic() {
		return communicationTopic;
	}
	/** ��ͨ���� */
	public void setCommunicationTopic(String communicationTopic) {
		this.communicationTopic = communicationTopic;
	}
	/** �������� */
	public String getRegistNo() {
		return registNo;
	}
	/** �������� */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	/** ������������ */
	public String getComCode() {
		return comCode;
	}
	/** ������������ */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/** �����˴��� */
	public String getUserCode() {
		return userCode;
	}
	/** �����˴��� */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/** ���������� */
	public String getUserName() {
		return userName;
	}
	/** ���������� */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** �ڵ���� */
	public String getNodeCode() {
		return nodeCode;
	}
	/** �ڵ���� */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}
	/** �ڵ����� */
	public String getNodeName() {
		return nodeName;
	}
	/** �ڵ����� */
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}
	/** ����ʱ�� */
	public DateTime getCreateTime() {
		return createTime;
	}
	/** ����ʱ�� */
	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}
	/** �ر����� */
	public DateTime getCloseTime() {
		return closeTime;
	}
	/** �ر����� */
	public void setCloseTime(DateTime closeTime) {
		this.closeTime = closeTime;
	}
	/** �رշ�ʽ (1:�ֶ��ر�,0:�᰸�Զ��ر�) */
	public String getCloseMode() {
		return closeMode;
	}
	/** �رշ�ʽ (1:�ֶ��ر�,0:�᰸�Զ��ر�) */
	public void setCloseMode(String closeMode) {
		this.closeMode = closeMode;
	}
	/** ��Ч��־ */
	public String getValidata() {
		return validata;
	}
	/** ��Ч��־ */
	public void setValidata(String validata) {
		this.validata = validata;
	}
	/** ������������ */
	public String getComName() {
		return comName;
	}
	/** ������������ */
	public void setComName(String comName) {
		this.comName = comName;
	}
	/** �������� */
	public String getTaskType() {
		return taskType;
	}
	/** �������� */
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	/** �������� */
	public String getTaskName() {
		return taskName;
	}
	/** �������� */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
