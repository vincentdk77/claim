package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class GisRegistDetailInfo implements Serializable {
	/** 属性保单号 */
	private String policyNo = "";
	/** 属性险类代码 */
	private String riskCode = "";
	/** 属性归属区域省级代码 */
	private String businessProvince = "";
	/** 属性归属区域地市代码 */
	private String businessTown = "";
	/** 属性归属区域区县代码 */
	private String businessCountry = "";
	/** 属性归属区域乡镇名称 */
	private String businessAreaName = "";
	/** 属性起保日期 */
	private Date startDate = new Date();
	/** 属性被保险人名称 */
	// private String insuredName = "";\
	/** 属性理赔类型 */
	private String lFlag = "";
	/** 属性语种 */
	private String language = "";
	/** 属性被保险人代码 */
	private String insuredCode = "";
	/** 属性被保险人名称 */
	private String insuredName = "";
	/** 属性报案日期 */
	private Date reportDate = new Date();
	/** 属性报案小时 */
	private String reportHour = "";
	/** 属性报案人 */
	private String reportorName = "";
	/** 属性报案形式 */
	private String reportType = "";
	/** 属性报案人联系电话 */
	private String phoneNumber = "";
	/** 属性联系人 */
	private String linkerName = "";
	/** 属性报案号 */
	private String registNo = "";

	/** 属性出险开始日期 */
	private Date damageStartDate = new Date();
	/** 属性出险开始小时 */
	private String damageStartHour = "";
	/** 属性出险终止日期 */
	private Date damageEndDate = new Date();
	/** 属性出险终止小时 */
	private String damageEndHour = "";
	/** 属性出险原因代码 */
	private String damageCode = "";
	/** 属性出险原因说明 */
	private String damageName = "";
	/** 属性出险地代码 */
	private String addressCode = "";
	/** 属性出险地点 */
	private String damageAddress = "";

	/** 属性受损标的 */
	private String lossName = "";
	/** 属性受损标的数量 */
	private String lossQuantity = "";
	/** 属性估损币别 */
	private String estiCurrency = "";
	/** 属性估损金额 */
	private String estimateLoss = "";

	/** 属性接案员姓名 */
	private String receiverName = "";
	/** 属性归属业务员代码 */
	private String handler1Code = "";
	/** 属性归属业务员代码 */
	private String comCode = "";
	/** 属性计算机输单日期 */
	private Date inputDate = new Date();
	/** 属性受理标志 */
	private String acceptFlag = "";
	/** 属性是否向别的保险公司投保 */
	private String repeatInsureFlag = "";
	/** 属性注销拒赔日期 */
	private Date cancelDate = new Date();
	/** 属性注销拒赔人代码 */
	private String dealerCode = "";
	/** 属性操作员代码 */
	private String operatorCode = "";
	/** 属性理赔登记机构 */
	private String makeCom = "";
	/** 属性赔付数量 */
	private String lossesNumber = "";
	/** 属性赔付数量计量单位 */
	private String lossesUnitCode = "";
	/** 属性农业涉农非农 */
	private String businessType = "";
	/** 属性中央地方商业性 */
	private String businessType1 = "";
	/** 属性业务标志 */
	private String businessFlag = "";
	/** 属性其他标志 */
	private String otherFlag = "";

	public GisRegistDetailInfo() {

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

	public String getBusinessProvince() {
		return businessProvince;
	}

	public void setBusinessProvince(String businessProvince) {
		if (null != businessProvince) {
			this.businessProvince = businessProvince;
		}
	}

	public String getBusinessTown() {
		return businessTown;
	}

	public void setBusinessTown(String businessTown) {
		if (null != businessTown) {
			this.businessTown = businessTown;
		}
	}

	public String getBusinessCountry() {
		return businessCountry;
	}

	public void setBusinessCountry(String businessCountry) {
		if (null != businessCountry) {
			this.businessCountry = businessCountry;
		}
	}

	public String getBusinessAreaName() {
		return businessAreaName;
	}

	public void setBusinessAreaName(String businessAreaName) {
		if (null != businessAreaName) {
			this.businessAreaName = businessAreaName;
		}
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		if (null != startDate) {
			this.startDate = startDate;
		}
	}

	public String getLFlag() {
		return lFlag;
	}

	public void setLFlag(String flag) {
		if (null != flag) {
			lFlag = flag;
		}
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		if (null != language) {
			this.language = language;
		}
	}

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		if (null != insuredCode) {
			this.insuredCode = insuredCode;
		}
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		if (null != insuredName) {
			this.insuredName = insuredName;
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

	public String getReportHour() {
		return reportHour;
	}

	public void setReportHour(String reportHour) {
		if (null != reportHour) {
			this.reportHour = reportHour;
		}
	}

	public String getReportorName() {
		return reportorName;
	}

	public void setReportorName(String reportorName) {
		if (null != reportorName) {
			this.reportorName = reportorName;
		}
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		if (null != reportType) {
			this.reportType = reportType;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (null != phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	}

	public String getLinkerName() {
		return linkerName;
	}

	public void setLinkerName(String linkerName) {
		if (null != linkerName) {
			this.linkerName = linkerName;
		}
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		if (null != registNo) {
			this.registNo = registNo;
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

	public String getDamageStartHour() {
		return damageStartHour;
	}

	public void setDamageStartHour(String damageStartHour) {
		if (null != damageStartHour) {
			this.damageStartHour = damageStartHour;
		}
	}

	public Date getDamageEndDate() {
		return damageEndDate;
	}

	public void setDamageEndDate(Date damageEndDate) {
		if (null != damageEndDate) {
			this.damageEndDate = damageEndDate;
		}
	}

	public String getDamageEndHour() {
		return damageEndHour;
	}

	public void setDamageEndHour(String damageEndHour) {
		if (null != damageEndHour) {
			this.damageEndHour = damageEndHour;
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

	public String getAddressCode() {
		return addressCode;
	}

	public void setAddressCode(String addressCode) {
		if (null != addressCode) {
			this.addressCode = addressCode;
		}
	}

	public String getDamageAddress() {
		return damageAddress;
	}

	public void setDamageAddress(String damageAddress) {
		if (null != damageAddress) {
			this.damageAddress = damageAddress;
		}
	}

	public String getLossName() {
		return lossName;
	}

	public void setLossName(String lossName) {
		if (null != lossName) {
			this.lossName = lossName;
		}
	}

	public String getLossQuantity() {
		return lossQuantity;
	}

	public void setLossQuantity(String lossQuantity) {
		if (null != lossQuantity) {
			this.lossQuantity = lossQuantity;
		}
	}

	public String getEstiCurrency() {
		return estiCurrency;
	}

	public void setEstiCurrency(String estiCurrency) {
		if (null != estiCurrency) {
			this.estiCurrency = estiCurrency;
		}
	}

	public String getEstimateLoss() {
		return estimateLoss;
	}

	public void setEstimateLoss(String estimateLoss) {
		if (null != estimateLoss) {
			this.estimateLoss = estimateLoss;
		}
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		if (null != receiverName) {
			this.receiverName = receiverName;
		}
	}

	public String getHandler1Code() {
		return handler1Code;
	}

	public void setHandler1Code(String handler1Code) {
		if (null != handler1Code) {
			this.handler1Code = handler1Code;
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

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		if (null != inputDate) {
			this.inputDate = inputDate;
		}
	}

	public String getAcceptFlag() {
		return acceptFlag;
	}

	public void setAcceptFlag(String acceptFlag) {
		if (null != acceptFlag) {
			this.acceptFlag = acceptFlag;
		}
	}

	public String getRepeatInsureFlag() {
		return repeatInsureFlag;
	}

	public void setRepeatInsureFlag(String repeatInsureFlag) {
		if (null != repeatInsureFlag) {
			this.repeatInsureFlag = repeatInsureFlag;
		}
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		if (null != cancelDate) {
			this.cancelDate = cancelDate;
		}
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		if (null != dealerCode) {
			this.dealerCode = dealerCode;
		}
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		if (null != operatorCode) {
			this.operatorCode = operatorCode;
		}
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		if (null != makeCom) {
			this.makeCom = makeCom;
		}
	}

	public String getLossesNumber() {
		return lossesNumber;
	}

	public void setLossesNumber(String lossesNumber) {
		if (null != lossesNumber) {
			this.lossesNumber = lossesNumber;
		}
	}

	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		if (null != lossesUnitCode) {
			this.lossesUnitCode = lossesUnitCode;
		}
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		if (null != businessType) {
			this.businessType = businessType;
		}
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		if (null != businessType1) {
			this.businessType1 = businessType1;
		}
	}

	public String getBusinessFlag() {
		return businessFlag;
	}

	public void setBusinessFlag(String businessFlag) {
		if (null != businessFlag) {
			this.businessFlag = businessFlag;
		}
	}

	public String getOtherFlag() {
		return otherFlag;
	}

	public void setOtherFlag(String otherFlag) {
		if (null != otherFlag) {
			this.otherFlag = otherFlag;
		}
	}

}
