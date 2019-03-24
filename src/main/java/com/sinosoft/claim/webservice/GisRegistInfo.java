package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class GisRegistInfo implements Serializable {
	/** 属性报案号 */
	private String registNo = "";
	/** 属性保单号 */
	private String policyNo = "";
	/** 属性险种 */
	private String riskCode = "";
	/** 属性险种名称 */
	private String riskName = "";
	/** 属性处理机构名称 */
	private String comCode = "";
	/** 属性灾害类型代码 */
	private String damageCode = "";
	/** 属性灾害类型名称 */
	private String damageName = "";
	/** 属性出险日期 */
	private Date damageStartDate = new Date();
	/** 属性发布日期 */
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
