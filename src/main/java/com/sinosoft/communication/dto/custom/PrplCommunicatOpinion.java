package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;
/**
 * ��ͨ������ӱ�
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatOpinion implements Serializable {
	
	/** ��ͨ����  */
	private String communicationNo;
	/** ��ͨ������ */
	private String opinionNo;
	/** ��ͨ��Ա��� */
	private String personNo;
	/** ��ͨ��Ա�˴��� */
	private String userCode;
	/** ��ͨ��Ա���� */
	private String userName;
	/** �����ɫ */
	private String handleRole;
	/** ����ʱ�� */
	private String handleTime;
	/** ��ͨ��� */
	private String communicatOpinion;
	
	
	public PrplCommunicatOpinion(){}
	
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
	public String getHandleTime() {
		return handleTime;
	}

	/** ����ʱ�� */
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	/** ��ͨ��� */
	public String getCommunicatOpinion() {
		return communicatOpinion;
	}
	/** ��ͨ��� */
	public void setCommunicatOpinion(String communicatOpinion) {
		this.communicatOpinion = communicatOpinion;
	}
	
}
