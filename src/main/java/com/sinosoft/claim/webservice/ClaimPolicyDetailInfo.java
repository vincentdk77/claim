package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** Ͷ�������� */
	private String proposalNo;
	/** �������� */
	private String riskName;
	/** �������� */
	private String policyNo;
	/** Э��� */
	private String groupNo;
	/** ���� */
	private String language;
	/** �������� */
	private String policySort;
	/** ҵ������ */
	private String businessType;
	/** ����/��ҵ��־ */
	private String businessType1;
	/** ������ʶ��0 ������ 1 ���� */
	private String renewalFlag;
	/** ���������� */
	private String oldPolicyNoRenewal;
	/** �������� */
	private String comCode;
	/** ������������ */
	private String comName;
	/** ����ҵ��Ա���� */
	private String handler1Code;
	/** ����ҵ��Ա�������� */
	private String handler1Name;
	/** ҵ����Դ */
	private String businessNature;
	/** ������/������ */
	private String agentCode;
	/** ������/���������� */
	private String agentName;
	/** ����Э��� */
	private String agreementNo;
	/** Ͷ������/�ֿ�������/�ܱ��������� */
	private String sumQuantity;
	/** �������˻�����Ϣ */
	private String ZHSumDoor;
	/** ZH03�ܱ��������� */
	private String ZH03SumQuantity;
	/** �Ż�ϵ�� */
	private String discount;
	/** �嵥�� */
	private String insuranceCode;
	/** ʵ��ҵ��Ա */
	private String handlerCode;
	/** ʵ��ҵ��Ա���� */
	private String handlerName;
	/** ҵ����� */
	private String[] groupFlag;
	/** �������� */
	private String startDate;
	/** ����ֹ�� */
	private String endDate;
	/** Ͷ������ */
	private String operateDate;
	/** �Ƶ����� */
	private String signDate;
	/** ��ҵ��� */
	private String businessSource;
	/** ��ҵ������� */
	private String businessSourceName;
	/** Ӫҵ���� */
	private String businessDetail;
	/** 01Ӫҵ���� /����������ҵ���� */
	private String businessSort;
	/** 01Ӫҵ���� /����������ҵ���� */
	private String businessSortName;
	/** �Ʋ�ռ������ */
	private String possessNature;
	/** �Ʋ�ռ������ */
	private String possessNatureName;
	/** ���ܱұ� */
	private String sumCurrency;
	/** ���ܱұ����� */
	private String sumCurrencyName;
	/** ֧���ұ� */
	private String payCurrency;
	/** ֧���ұ����� */
	private String payCurrencyName;
	/** ����/���ͷѱ���% */
	private String disRate;
	/** ����/���ͷѽ�� */
	private String disRateFee;
	/** ������Ч����% */
	private String basePerformanceRate;
	/** ������Ч��� */
	private String basePerformanceRateFee;
	/** ˾����Ͻ */
	private String judicalScopeName;
	/** ��ͬ��������ʽ */
	private String argueSolution;
	/** ����Ա���� */
	private String operatorCode;
	/** ����Ա���� */
	private String operatorName;
	/** ¼������ */
	private String inputDate;
	/** ����޸��˴��� */
	private String updaterCode;
	/** ����޸������� */
	private String updaterName;
	/** ����޸�ʱ�� */
	private String updateDate;
	/** �˱��˴��� */
	private String underWriteCode;
	/** �˱������� */
	private String underWriteName;
	/** �˱�ͨ������ */
	private String underWriteEndDate;
	/** ����Ա��� */
	private String remark;
	/** ��������־ */
	private String coinsFlagName;
	/** ÿ���¹������޶� */
	private String limitAmount;
	/** �ۼ��⳥�޶�,�ܱ��ս�� */
	private String sumAmount;
	/** �ܱ��շ� */
	private String sumPremium;
	/** ��ʱ���������/���淽ʽ 2���������� 4��������������������� */
	private String allinsFlag;
	/** �Ƿ�ͨ��������ʶ�� 0��ѡ��1�ǣ�2�� */
	private String thirdKnow;
	/** ��λ������ */
	private String UnitCount;
	/** ���շ�ʽ */
	private String policyType;
	/** ���ʽ */
	private String autoTransRenewFlag;
	/** �����˵�� */
	private String textDeductibleText;
	/** �����ʾ��־ */
	private String agriInsuranceFlag;
	/** Ͷ������Ϣ */
	private ClaimPolicyAppliInsuredInfo claimPolicyAppliInsuredInfo;
	/** ����������Ϣ */
	private ClaimPolicyInsuredInfo claimPolicyInsuredInfo;
	/** �����ղƲ������ַ */
	private ClaimPolicyInsuredAddressInfo[] claimPolicyInsuredAddressInfoList;
	/** ���ձ����Ϣ 1526���乤����Ϣ */
	private ClaimPolicyItemDeviceInfo[] claimPolicyItemDeviceInfoList;
	/** ������Ϣ */
	private ClaimPolicyItemKindMainInfo[] claimPolicyItemKindMainInfoList;
	/** ��������Ϣ */
	private ClaimPolicyItemKindSubInfo[] claimPolicyItemKindSubInfoList;
	/** �ұ���Ϣ */
	private ClaimPolicyDcurrencyInfo[] claimPolicyDcurrencyInfoList;
	/** �ɷѼƻ� */
	private ClaimPolicyPlanFeeInfo[] claimPolicyPlanFeeInfoList;
	/** ��Լ��������Ϣ */
	private ClaimPolicyEngageInfo[] claimPolicyEngageInfoList;
	/** ר��-���θ�������Ϣ */
	private ClaimPolicyMainLiabInfo claimPolicyMainLiabInfo;
	/** ר��-�����������Ϣ */
	private ClaimPolicyItemKindZHMainInfo[] claimPolicyItemKindZHMainInfoList;
	/** ר��-����ո�������Ϣ */
	private ClaimPolicyItemKindZHSubInfo[] claimPolicyItemKindZHSubInfoList;
	/** 0908��Ϣ */
	private ClaimPolicyMainCargoInfo claimPolicyMainCargoInfo;

	public String getProposalNo() {
		return proposalNo;
	}

	public void setProposalNo(String proposalNo) {
		this.proposalNo = proposalNo;
	}

	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getPolicySort() {
		return policySort;
	}

	public void setPolicySort(String policySort) {
		this.policySort = policySort;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType1() {
		return businessType1;
	}

	public void setBusinessType1(String businessType1) {
		this.businessType1 = businessType1;
	}

	public String getRenewalFlag() {
		return renewalFlag;
	}

	public void setRenewalFlag(String renewalFlag) {
		this.renewalFlag = renewalFlag;
	}

	public String getOldPolicyNoRenewal() {
		return oldPolicyNoRenewal;
	}

	public void setOldPolicyNoRenewal(String oldPolicyNoRenewal) {
		this.oldPolicyNoRenewal = oldPolicyNoRenewal;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getHandler1Code() {
		return handler1Code;
	}

	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}

	public String getHandler1Name() {
		return handler1Name;
	}

	public void setHandler1Name(String handler1Name) {
		this.handler1Name = handler1Name;
	}

	public String getBusinessNature() {
		return businessNature;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}

	public String getSumQuantity() {
		return sumQuantity;
	}

	public void setSumQuantity(String sumQuantity) {
		this.sumQuantity = sumQuantity;
	}

	public String getZHSumDoor() {
		return ZHSumDoor;
	}

	public void setZHSumDoor(String sumDoor) {
		ZHSumDoor = sumDoor;
	}

	public String getZH03SumQuantity() {
		return ZH03SumQuantity;
	}

	public void setZH03SumQuantity(String sumQuantity) {
		ZH03SumQuantity = sumQuantity;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getInsuranceCode() {
		return insuranceCode;
	}

	public void setInsuranceCode(String insuranceCode) {
		this.insuranceCode = insuranceCode;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public String[] getGroupFlag() {
		return groupFlag;
	}

	public void setGroupFlag(String[] groupFlag) {
		this.groupFlag = groupFlag;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getSignDate() {
		return signDate;
	}

	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}

	public String getBusinessSource() {
		return businessSource;
	}

	public void setBusinessSource(String businessSource) {
		this.businessSource = businessSource;
	}

	public String getBusinessSourceName() {
		return businessSourceName;
	}

	public void setBusinessSourceName(String businessSourceName) {
		this.businessSourceName = businessSourceName;
	}

	public String getBusinessDetail() {
		return businessDetail;
	}

	public void setBusinessDetail(String businessDetail) {
		this.businessDetail = businessDetail;
	}

	public String getBusinessSort() {
		return businessSort;
	}

	public void setBusinessSort(String businessSort) {
		this.businessSort = businessSort;
	}

	public String getBusinessSortName() {
		return businessSortName;
	}

	public void setBusinessSortName(String businessSortName) {
		this.businessSortName = businessSortName;
	}

	public String getPossessNature() {
		return possessNature;
	}

	public void setPossessNature(String possessNature) {
		this.possessNature = possessNature;
	}

	public String getPossessNatureName() {
		return possessNatureName;
	}

	public void setPossessNatureName(String possessNatureName) {
		this.possessNatureName = possessNatureName;
	}

	public String getSumCurrency() {
		return sumCurrency;
	}

	public void setSumCurrency(String sumCurrency) {
		this.sumCurrency = sumCurrency;
	}

	public String getSumCurrencyName() {
		return sumCurrencyName;
	}

	public void setSumCurrencyName(String sumCurrencyName) {
		this.sumCurrencyName = sumCurrencyName;
	}

	public String getPayCurrency() {
		return payCurrency;
	}

	public void setPayCurrency(String payCurrency) {
		this.payCurrency = payCurrency;
	}

	public String getPayCurrencyName() {
		return payCurrencyName;
	}

	public void setPayCurrencyName(String payCurrencyName) {
		this.payCurrencyName = payCurrencyName;
	}

	public String getDisRate() {
		return disRate;
	}

	public void setDisRate(String disRate) {
		this.disRate = disRate;
	}

	public String getDisRateFee() {
		return disRateFee;
	}

	public void setDisRateFee(String disRateFee) {
		this.disRateFee = disRateFee;
	}

	public String getBasePerformanceRate() {
		return basePerformanceRate;
	}

	public void setBasePerformanceRate(String basePerformanceRate) {
		this.basePerformanceRate = basePerformanceRate;
	}

	public String getBasePerformanceRateFee() {
		return basePerformanceRateFee;
	}

	public void setBasePerformanceRateFee(String basePerformanceRateFee) {
		this.basePerformanceRateFee = basePerformanceRateFee;
	}

	public String getJudicalScopeName() {
		return judicalScopeName;
	}

	public void setJudicalScopeName(String judicalScopeName) {
		this.judicalScopeName = judicalScopeName;
	}

	public String getArgueSolution() {
		return argueSolution;
	}

	public void setArgueSolution(String argueSolution) {
		this.argueSolution = argueSolution;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getUpdaterCode() {
		return updaterCode;
	}

	public void setUpdaterCode(String updaterCode) {
		this.updaterCode = updaterCode;
	}

	public String getUpdaterName() {
		return updaterName;
	}

	public void setUpdaterName(String updaterName) {
		this.updaterName = updaterName;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUnderWriteCode() {
		return underWriteCode;
	}

	public void setUnderWriteCode(String underWriteCode) {
		this.underWriteCode = underWriteCode;
	}

	public String getUnderWriteName() {
		return underWriteName;
	}

	public void setUnderWriteName(String underWriteName) {
		this.underWriteName = underWriteName;
	}

	public String getUnderWriteEndDate() {
		return underWriteEndDate;
	}

	public void setUnderWriteEndDate(String underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCoinsFlagName() {
		return coinsFlagName;
	}

	public void setCoinsFlagName(String coinsFlagName) {
		this.coinsFlagName = coinsFlagName;
	}

	public String getAgriInsuranceFlag() {
		return agriInsuranceFlag;
	}

	public void setAgriInsuranceFlag(String agriInsuranceFlag) {
		this.agriInsuranceFlag = agriInsuranceFlag;
	}

	public String getLimitAmount() {
		return limitAmount;
	}

	public void setLimitAmount(String limitAmount) {
		this.limitAmount = limitAmount;
	}

	public String getSumAmount() {
		return sumAmount;
	}

	public void setSumAmount(String sumAmount) {
		this.sumAmount = sumAmount;
	}

	public String getSumPremium() {
		return sumPremium;
	}

	public void setSumPremium(String sumPremium) {
		this.sumPremium = sumPremium;
	}

	public String getAllinsFlag() {
		return allinsFlag;
	}

	public void setAllinsFlag(String allinsFlag) {
		this.allinsFlag = allinsFlag;
	}

	public String getThirdKnow() {
		return thirdKnow;
	}

	public void setThirdKnow(String thirdKnow) {
		this.thirdKnow = thirdKnow;
	}

	public String getUnitCount() {
		return UnitCount;
	}

	public void setUnitCount(String unitCount) {
		UnitCount = unitCount;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getAutoTransRenewFlag() {
		return autoTransRenewFlag;
	}

	public void setAutoTransRenewFlag(String autoTransRenewFlag) {
		this.autoTransRenewFlag = autoTransRenewFlag;
	}

	public ClaimPolicyAppliInsuredInfo getClaimPolicyAppliInsuredInfo() {
		return claimPolicyAppliInsuredInfo;
	}

	public void setClaimPolicyAppliInsuredInfo(
			ClaimPolicyAppliInsuredInfo claimPolicyAppliInsuredInfo) {
		this.claimPolicyAppliInsuredInfo = claimPolicyAppliInsuredInfo;
	}

	public ClaimPolicyInsuredInfo getClaimPolicyInsuredInfo() {
		return claimPolicyInsuredInfo;
	}

	public void setClaimPolicyInsuredInfo(
			ClaimPolicyInsuredInfo claimPolicyInsuredInfo) {
		this.claimPolicyInsuredInfo = claimPolicyInsuredInfo;
	}

	public ClaimPolicyInsuredAddressInfo[] getClaimPolicyInsuredAddressInfoList() {
		return claimPolicyInsuredAddressInfoList;
	}

	public void setClaimPolicyInsuredAddressInfoList(
			ClaimPolicyInsuredAddressInfo[] claimPolicyInsuredAddressInfoList) {
		this.claimPolicyInsuredAddressInfoList = claimPolicyInsuredAddressInfoList;
	}

	public ClaimPolicyItemDeviceInfo[] getClaimPolicyItemDeviceInfoList() {
		return claimPolicyItemDeviceInfoList;
	}

	public void setClaimPolicyItemDeviceInfoList(
			ClaimPolicyItemDeviceInfo[] claimPolicyItemDeviceInfoList) {
		this.claimPolicyItemDeviceInfoList = claimPolicyItemDeviceInfoList;
	}

	public ClaimPolicyItemKindMainInfo[] getClaimPolicyItemKindMainInfoList() {
		return claimPolicyItemKindMainInfoList;
	}

	public void setClaimPolicyItemKindMainInfoList(
			ClaimPolicyItemKindMainInfo[] claimPolicyItemKindMainInfoList) {
		this.claimPolicyItemKindMainInfoList = claimPolicyItemKindMainInfoList;
	}

	public ClaimPolicyItemKindSubInfo[] getClaimPolicyItemKindSubInfoList() {
		return claimPolicyItemKindSubInfoList;
	}

	public void setClaimPolicyItemKindSubInfoList(
			ClaimPolicyItemKindSubInfo[] claimPolicyItemKindSubInfoList) {
		this.claimPolicyItemKindSubInfoList = claimPolicyItemKindSubInfoList;
	}

	public ClaimPolicyDcurrencyInfo[] getClaimPolicyDcurrencyInfoList() {
		return claimPolicyDcurrencyInfoList;
	}

	public void setClaimPolicyDcurrencyInfoList(
			ClaimPolicyDcurrencyInfo[] claimPolicyDcurrencyInfoList) {
		this.claimPolicyDcurrencyInfoList = claimPolicyDcurrencyInfoList;
	}

	public ClaimPolicyPlanFeeInfo[] getClaimPolicyPlanFeeInfoList() {
		return claimPolicyPlanFeeInfoList;
	}

	public void setClaimPolicyPlanFeeInfoList(
			ClaimPolicyPlanFeeInfo[] claimPolicyPlanFeeInfoList) {
		this.claimPolicyPlanFeeInfoList = claimPolicyPlanFeeInfoList;
	}

	public ClaimPolicyEngageInfo[] getClaimPolicyEngageInfoList() {
		return claimPolicyEngageInfoList;
	}

	public void setClaimPolicyEngageInfoList(
			ClaimPolicyEngageInfo[] claimPolicyEngageInfoList) {
		this.claimPolicyEngageInfoList = claimPolicyEngageInfoList;
	}

	public String getTextDeductibleText() {
		return textDeductibleText;
	}

	public void setTextDeductibleText(String textDeductibleText) {
		this.textDeductibleText = textDeductibleText;
	}

	public ClaimPolicyMainLiabInfo getClaimPolicyMainLiabInfo() {
		return claimPolicyMainLiabInfo;
	}

	public void setClaimPolicyMainLiabInfo(
			ClaimPolicyMainLiabInfo claimPolicyMainLiabInfo) {
		this.claimPolicyMainLiabInfo = claimPolicyMainLiabInfo;
	}

	public ClaimPolicyItemKindZHMainInfo[] getClaimPolicyItemKindZHMainInfoList() {
		return claimPolicyItemKindZHMainInfoList;
	}

	public void setClaimPolicyItemKindZHMainInfoList(
			ClaimPolicyItemKindZHMainInfo[] claimPolicyItemKindZHMainInfoList) {
		this.claimPolicyItemKindZHMainInfoList = claimPolicyItemKindZHMainInfoList;
	}

	public ClaimPolicyItemKindZHSubInfo[] getClaimPolicyItemKindZHSubInfoList() {
		return claimPolicyItemKindZHSubInfoList;
	}

	public void setClaimPolicyItemKindZHSubInfoList(
			ClaimPolicyItemKindZHSubInfo[] claimPolicyItemKindZHSubInfoList) {
		this.claimPolicyItemKindZHSubInfoList = claimPolicyItemKindZHSubInfoList;
	}

	public ClaimPolicyMainCargoInfo getClaimPolicyMainCargoInfo() {
		return claimPolicyMainCargoInfo;
	}

	public void setClaimPolicyMainCargoInfo(
			ClaimPolicyMainCargoInfo claimPolicyMainCargoInfo) {
		this.claimPolicyMainCargoInfo = claimPolicyMainCargoInfo;
	}

}
