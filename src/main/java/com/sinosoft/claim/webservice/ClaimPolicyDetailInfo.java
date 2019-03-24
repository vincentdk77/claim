package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyDetailInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 投保单号码 */
	private String proposalNo;
	/** 险种名称 */
	private String riskName;
	/** 保单号码 */
	private String policyNo;
	/** 协议号 */
	private String groupNo;
	/** 语种 */
	private String language;
	/** 保单种类 */
	private String policySort;
	/** 业务类型 */
	private String businessType;
	/** 政策/商业标志 */
	private String businessType1;
	/** 续保标识：0 非续保 1 续保 */
	private String renewalFlag;
	/** 续保保单号 */
	private String oldPolicyNoRenewal;
	/** 归属机构 */
	private String comCode;
	/** 归属机构名称 */
	private String comName;
	/** 归属业务员代码 */
	private String handler1Code;
	/** 归属业务员代码名称 */
	private String handler1Name;
	/** 业务来源 */
	private String businessNature;
	/** 代理人/经纪人 */
	private String agentCode;
	/** 代理人/经纪人名称 */
	private String agentName;
	/** 代理协议号 */
	private String agreementNo;
	/** 投保份数/持卡人人数/总被保险人数 */
	private String sumQuantity;
	/** 被保险人户数信息 */
	private String ZHSumDoor;
	/** ZH03总被保险人数 */
	private String ZH03SumQuantity;
	/** 优惠系数 */
	private String discount;
	/** 清单号 */
	private String insuranceCode;
	/** 实际业务员 */
	private String handlerCode;
	/** 实际业务员名称 */
	private String handlerName;
	/** 业务大类 */
	private String[] groupFlag;
	/** 保险起期 */
	private String startDate;
	/** 保险止期 */
	private String endDate;
	/** 投保日期 */
	private String operateDate;
	/** 制单日期 */
	private String signDate;
	/** 企业类别 */
	private String businessSource;
	/** 企业类别名称 */
	private String businessSourceName;
	/** 营业性质 */
	private String businessDetail;
	/** 01营业性质 /被保险人企业性质 */
	private String businessSort;
	/** 01营业性质 /被保险人企业性质 */
	private String businessSortName;
	/** 财产占用性质 */
	private String possessNature;
	/** 财产占用性质 */
	private String possessNatureName;
	/** 汇总币别 */
	private String sumCurrency;
	/** 汇总币别名称 */
	private String sumCurrencyName;
	/** 支付币别 */
	private String payCurrency;
	/** 支付币别名称 */
	private String payCurrencyName;
	/** 手续/经纪费比例% */
	private String disRate;
	/** 手续/经纪费金额 */
	private String disRateFee;
	/** 基础绩效比例% */
	private String basePerformanceRate;
	/** 基础绩效金额 */
	private String basePerformanceRateFee;
	/** 司法管辖 */
	private String judicalScopeName;
	/** 合同争议解决方式 */
	private String argueSolution;
	/** 操作员代码 */
	private String operatorCode;
	/** 操作员名称 */
	private String operatorName;
	/** 录单日期 */
	private String inputDate;
	/** 最近修改人代码 */
	private String updaterCode;
	/** 最近修改人名称 */
	private String updaterName;
	/** 最近修改时间 */
	private String updateDate;
	/** 核保人代码 */
	private String underWriteCode;
	/** 核保人名称 */
	private String underWriteName;
	/** 核保通过日期 */
	private String underWriteEndDate;
	/** 出单员意见 */
	private String remark;
	/** 联共保标志 */
	private String coinsFlagName;
	/** 每次事故责任限额 */
	private String limitAmount;
	/** 累计赔偿限额,总保险金额 */
	private String sumAmount;
	/** 总保险费 */
	private String sumPremium;
	/** 身故保险受益人/受益方式 2法定受益人 4受益人详见被保险人名册 */
	private String allinsFlag;
	/** 是否通过第三方识别 0请选择，1是，2否 */
	private String thirdKnow;
	/** 单位总人数 */
	private String UnitCount;
	/** 保险方式 */
	private String policyType;
	/** 付款方式 */
	private String autoTransRenewFlag;
	/** 免赔额说明 */
	private String textDeductibleText;
	/** 调查问卷标志 */
	private String agriInsuranceFlag;
	/** 投保人信息 */
	private ClaimPolicyAppliInsuredInfo claimPolicyAppliInsuredInfo;
	/** 被保险人信息 */
	private ClaimPolicyInsuredInfo claimPolicyInsuredInfo;
	/** 被保险财产坐落地址 */
	private ClaimPolicyInsuredAddressInfo[] claimPolicyInsuredAddressInfoList;
	/** 保险标的信息 1526运输工具信息 */
	private ClaimPolicyItemDeviceInfo[] claimPolicyItemDeviceInfoList;
	/** 主险信息 */
	private ClaimPolicyItemKindMainInfo[] claimPolicyItemKindMainInfoList;
	/** 附加险信息 */
	private ClaimPolicyItemKindSubInfo[] claimPolicyItemKindSubInfoList;
	/** 币别信息 */
	private ClaimPolicyDcurrencyInfo[] claimPolicyDcurrencyInfoList;
	/** 缴费计划 */
	private ClaimPolicyPlanFeeInfo[] claimPolicyPlanFeeInfoList;
	/** 特约及附加信息 */
	private ClaimPolicyEngageInfo[] claimPolicyEngageInfoList;
	/** 专用-责任附加险信息 */
	private ClaimPolicyMainLiabInfo claimPolicyMainLiabInfo;
	/** 专用-组合险主险信息 */
	private ClaimPolicyItemKindZHMainInfo[] claimPolicyItemKindZHMainInfoList;
	/** 专用-组合险附加险信息 */
	private ClaimPolicyItemKindZHSubInfo[] claimPolicyItemKindZHSubInfoList;
	/** 0908信息 */
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
