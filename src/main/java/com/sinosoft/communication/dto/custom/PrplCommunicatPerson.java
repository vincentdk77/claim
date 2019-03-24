package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;
/**
 * ��ͨ��Ա���ӱ�
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatPerson implements Serializable {
	
	/** ��ͨ���� ��ͨ��������Id  */
	private String communicationNo;
	/** ��ͨ��Ա��� */
	private String personNo;
	/** ��ͨ��Ա�������� */
	private String comCode;
	/** ��ͨ��Ա�˴��� */
	private String userCode;
	/** ��ͨ��Ա���� */
	private String userName;
	/** ������� */
	private Date createTime;
	/** ��Ч��־ */
	private String validata;
	
	public PrplCommunicatPerson(){}
	
	/** ��ͨ����  */
	public String getCommunicationNo() {
		return communicationNo;
	}
	/** ��ͨ����   */
	public void setCommunicationNo(String communicationNo) {
		this.communicationNo = communicationNo;
	}
	
	/** ��ͨ��Ա���  */
	public String getPersonNo() {
		return personNo;
	}
	
	/** ��ͨ��Ա���  */
	public void setPersonNo(String personNo) {
		this.personNo = personNo;
	}

	/** ��ͨ��Ա�������� */
	public String getComCode() {
		return comCode;
	}
	/** ��ͨ��Ա�������� */
	public void setComCode(String comCode) {
		this.comCode = comCode;
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
	
	/** ������� */
	public Date getCreateTime() {
		return createTime;
	}
	/** ������� */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/** ��Ч��־ */
	public String getValidata() {
		return validata;
	}
	/** ��Ч��־ */
	public void setValidata(String validata) {
		this.validata = validata;
	}
}
