package com.sinosoft.communication.dto.custom;

import java.io.Serializable;
import java.sql.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * ��ͨ��Ա���ӱ�
 * @author chubin 2013-02-18
 *
 */
public class PrplCommunicatPersonDtoBase implements Serializable {
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
	private DateTime createTime = new DateTime();
	/** ��ͨ�˱�־��1:��ͨ�ظ��ˣ�2:��ͨ�����ˣ� */
	private String validata;
	/** ��ͨ״̬ (0:������,1:�Ѵ���,2:�����) */
	private String communicationFlag;
	
	public PrplCommunicatPersonDtoBase(){}
	
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
	public DateTime getCreateTime() {
		return createTime;
	}
	/** ������� */
	public void setCreateTime(DateTime createTime) {
		this.createTime = createTime;
	}
	
	/** ��ͨ�˱�־��1:��ͨ�ظ��ˣ�2:��ͨ�����ˣ� */
	public String getValidata() {
		return validata;
	}
	/** ��ͨ�˱�־��1:��ͨ�ظ��ˣ�2:��ͨ�����ˣ� */
	public void setValidata(String validata) {
		this.validata = validata;
	}
	/**��ͨ״̬ (0:������,1:�Ѵ���,2:�����)*/
	public String getCommunicationFlag() {
		return communicationFlag;
	}
	/**��ͨ״̬ (0:������,1:�Ѵ���,2:�����)*/
	public void setCommunicationFlag(String communicationFlag) {
		this.communicationFlag = communicationFlag;
	}
	
}
