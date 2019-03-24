package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class GisRegistDetailInfo implements Serializable {
	/** ���Ա����� */
	private String policyNo = "";
	/** ����������� */
	private String riskCode = "";
	/** ���Թ�������ʡ������ */
	private String businessProvince = "";
	/** ���Թ���������д��� */
	private String businessTown = "";
	/** ���Թ����������ش��� */
	private String businessCountry = "";
	/** ���Թ��������������� */
	private String businessAreaName = "";
	/** ���������� */
	private Date startDate = new Date();
	/** ���Ա����������� */
	// private String insuredName = "";\
	/** ������������ */
	private String lFlag = "";
	/** �������� */
	private String language = "";
	/** ���Ա������˴��� */
	private String insuredCode = "";
	/** ���Ա����������� */
	private String insuredName = "";
	/** ���Ա������� */
	private Date reportDate = new Date();
	/** ���Ա���Сʱ */
	private String reportHour = "";
	/** ���Ա����� */
	private String reportorName = "";
	/** ���Ա�����ʽ */
	private String reportType = "";
	/** ���Ա�������ϵ�绰 */
	private String phoneNumber = "";
	/** ������ϵ�� */
	private String linkerName = "";
	/** ���Ա����� */
	private String registNo = "";

	/** ���Գ��տ�ʼ���� */
	private Date damageStartDate = new Date();
	/** ���Գ��տ�ʼСʱ */
	private String damageStartHour = "";
	/** ���Գ�����ֹ���� */
	private Date damageEndDate = new Date();
	/** ���Գ�����ֹСʱ */
	private String damageEndHour = "";
	/** ���Գ���ԭ����� */
	private String damageCode = "";
	/** ���Գ���ԭ��˵�� */
	private String damageName = "";
	/** ���Գ��յش��� */
	private String addressCode = "";
	/** ���Գ��յص� */
	private String damageAddress = "";

	/** ���������� */
	private String lossName = "";
	/** �������������� */
	private String lossQuantity = "";
	/** ���Թ���ұ� */
	private String estiCurrency = "";
	/** ���Թ����� */
	private String estimateLoss = "";

	/** ���ԽӰ�Ա���� */
	private String receiverName = "";
	/** ���Թ���ҵ��Ա���� */
	private String handler1Code = "";
	/** ���Թ���ҵ��Ա���� */
	private String comCode = "";
	/** ���Լ�����䵥���� */
	private Date inputDate = new Date();
	/** ���������־ */
	private String acceptFlag = "";
	/** �����Ƿ����ı��չ�˾Ͷ�� */
	private String repeatInsureFlag = "";
	/** ����ע���������� */
	private Date cancelDate = new Date();
	/** ����ע�������˴��� */
	private String dealerCode = "";
	/** ���Բ���Ա���� */
	private String operatorCode = "";
	/** ��������Ǽǻ��� */
	private String makeCom = "";
	/** �����⸶���� */
	private String lossesNumber = "";
	/** �����⸶����������λ */
	private String lossesUnitCode = "";
	/** ����ũҵ��ũ��ũ */
	private String businessType = "";
	/** ��������ط���ҵ�� */
	private String businessType1 = "";
	/** ����ҵ���־ */
	private String businessFlag = "";
	/** ����������־ */
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
