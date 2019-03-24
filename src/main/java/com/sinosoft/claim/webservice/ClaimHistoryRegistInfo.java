package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimHistoryRegistInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/** 报案号码 */
	private String registNo = "";
	/** 出险时间 */
	private String damageStartDate = "";
	/** 出险地点 */
	private String damageAddress = "";
	/** 赔付金额 */
	private String sumPaid = "";
	/** 是否注销 */
	private String isCancel = "";//1,是;0,否
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
