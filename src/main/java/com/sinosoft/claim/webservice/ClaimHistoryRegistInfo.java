package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimHistoryRegistInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** �������� */
	private String registNo = "";
	/** ����ʱ�� */
	private String damageStartDate = "";
	/** ���յص� */
	private String damageAddress = "";
	/** �⸶��� */
	private String sumPaid = "";
	/** �Ƿ�ע�� */
	private String isCancel = "";//1,��;0,��
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getDamageStartDate() {
		return damageStartDate;
	}
	public void setDamageStartDate(String damageStartDate) {
		this.damageStartDate = damageStartDate;
	}
	public String getDamageAddress() {
		return damageAddress;
	}
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = damageAddress;
	}

	public String getSumPaid() {
		return sumPaid;
	}

	public void setSumPaid(String sumPaid) {
		this.sumPaid = sumPaid;
	}
	public String getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}
	
	
}
