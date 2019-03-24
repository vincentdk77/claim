package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class GisRegistInfo implements Serializable {
	/** ���Ա����� */
	private String registNo = "";
	/** ���Ա����� */
	private String policyNo = "";
	/** �������� */
	private String riskCode = "";
	/** ������������ */
	private String riskName = "";
	/** ���Դ���������� */
	private String comCode = "";
	/** �����ֺ����ʹ��� */
	private String damageCode = "";
	/** �����ֺ��������� */
	private String damageName = "";
	/** ���Գ������� */
	private Date damageStartDate = new Date();
	/** ���Է������� */
	private Date reportDate = new Date();
	
	public GisRegistInfo(){
		
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		if (null != registNo) {
			this.registNo = registNo;
		}
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		if (null != policyNo) {
			this.policyNo = policyNo;
		}
	}

	public String getRiskCode() {
		return riskCode;
	}

	public void setRiskCode(String riskCode) {
		if (null != riskCode) {
			this.riskCode = riskCode;
		}
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		if (null != riskName) {
			this.riskName = riskName;
		}
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		if (null != comCode) {
			this.comCode = comCode;
		}
	}

	public String getDamageCode() {
		return damageCode;
	}

	public void setDamageCode(String damageCode) {
		if (null != damageCode) {
			this.damageCode = damageCode;
		}
	}

	public String getDamageName() {
		return damageName;
	}

	public void setDamageName(String damageName) {
		if (null != damageName) {
			this.damageName = damageName;
		}
	}

	public Date getDamageStartDate() {
		return damageStartDate;
	}

	public void setDamageStartDate(Date damageStartDate) {
		if (null != damageStartDate) {
			this.damageStartDate = damageStartDate;
		}
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		if (null != reportDate) {
			this.reportDate = reportDate;
		}
	}

}
