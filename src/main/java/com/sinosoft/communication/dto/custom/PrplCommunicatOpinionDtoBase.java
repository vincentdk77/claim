package com.sinosoft.communication.dto.custom;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
/**
 * ��ͨ������ӱ�
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatOpinionDtoBase implements Serializable {
	/** ��ͨ����  */
	private String communicationNo;
	/** ��ͨ������ */
	private String opinionNo;
	/** ��ͨ��Ա��� */
	private String personNo;
	/** ����������� */
	private String comCode;
	/** ����������� */
	private String comCName;
	/** ��ͨ��Ա�˴��� */
	private String userCode;
	/** ��ͨ��Ա���� */
	private String userName;
	/** �����ɫ */
	private String handleRole;
	/** ����ʱ�� */
	private DateTime handleTime = new DateTime();
	/** ��ͨ��� */
	private String direction;
	/** ռ��ʱ�� */
	private String aboveTime;
	/** ������� */
	private String handleOpinion;
	
	
	public PrplCommunicatOpinionDtoBase(){}
	
	/** ��ͨ����  */
	public String getCommunicationNo() {
		return communicationNo;
	}
	/** ��ͨ����   */
	public void setCommunicationNo(String communicationNo) {
		this.communicationNo = communicationNo;
	}
	
	/** ��ͨ������  */
	public String getOpinionNo() {
		return opinionNo;
	}
	
	/** ��ͨ������  */
	public void setOpinionNo(String opinionNo) {
		this.opinionNo = opinionNo;
	}

	/** ��ͨ��Ա���  */
	public String getPersonNo() {
		return personNo;
	}
	
	/** ��ͨ��Ա���  */
	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	}
	/** ����������� */
	public String getComCode() {
		return comCode;
	}
	/** ����������� */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	/** ����������� */
	public String getComCName() {
		return comCName;
	}
	/** ����������� */
	public void setComCName(String comCName) {
		this.comCName = comCName;
	}

	/** ��ͨ��Ա���� */
	public String getUserCode() {
		return userCode;
	}
	/** ��ͨ��Ա���� */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/** ��ͨ��Ա���� */
	public String getUserName() {
		return userName;
	}
	/** ��ͨ��Ա���� */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/** �����ɫ */
	public String getHandleRole() {
		return handleRole;
	}
	/** �����ɫ */
	public void setHandleRole(String handleRole) {
		this.handleRole = handleRole;
	}
	/** ����ʱ�� */
	public DateTime getHandleTime() {
		return handleTime;
	}

	/** ����ʱ�� */
	public void setHandleTime(DateTime handleTime) {
		this.handleTime = handleTime;
	}
	/** ��ͨ˵�� */
	public String getDirection() {
		return direction;
	}
	/** ��ͨ˵�� */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/** ռ��ʱ�� */
	public String getAboveTime() {
		return aboveTime;
	}
	/** ռ��ʱ�� */
	public void setAboveTime(String aboveTime) {
		this.aboveTime = aboveTime;
	}
	/** ������� */
	public String getHandleOpinion() {
		return handleOpinion;
	}
	/** ������� */
	public void setHandleOpinion(String handleOpinion) {
		this.handleOpinion = handleOpinion;
	}
}
