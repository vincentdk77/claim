package com.sinosoft.claim.webservice;

public class RegistEditPostInfo {
	private String registNo;

	private String UserComCode;
	private String UserComName;
	private String UserCode;
	private String UserName;
	private String damageMessageFlag;// 详细出险原因
	private String[] damageMessage;// 出险原因
	private String prpLregistLinkerAddress;
	private String prpLregistDamageTypeCode;
	private String prpLregistDamageTypeName;
	private String prpLregistLossesNumber;
	private String qsFlag;
	private String prpLregistLFlag;
	private String prpLregistRiskCode;
	private String prpLregistClassCode;
	private String prpLregistLanguage;
	private String prpLregistTypeForDriver;
	private String prpLregistPolicyNo;
	private String prpLregistInsuredCode;
	private String prpLregistInsuredName;

	private String prpLregistDamageStartDate;
	private String prpLregistDamageStartHour;
	private String prpLregistDamageStartMinute;
	private String prpLregistDamageCode;
	private String prpLregistDamageName;
	private String prpLregistReportorName;
	private String prpLregistReportDate;
	private String prpLregistReportHour;
	private String prpLregistReportMinute;

	private String reportType;
	private String prpLregistInputDate;
	private String prpLregistLinkerName;
	private String prpLregistPhoneNumber;
	// 添加联系人
	private String[] prpLrelatePersonSeriaNo;
	private String[] prpLrelatePersonPersonName;
	private String[] prpLrelatePersonPhoneNumber;
	private String[] prpLrelatePersonMobile;
	private String[] prpLrelatePersonRemark;

	private String prpLregistAddressCode;
	private String prpLregistDamageAddress;
	private String prpLregistEstiCurrency;
	private String prpLregistEstimateFee;
	private String prpLregistRemark;
	private String prpLregistTextContextInnerHTML;
	private String prpCatastropheCode1;
	private String prpCatastropheName1;
	private String prpCatastropheCode2;
	private String prpCatastropheName2;
	// 保单自动带出
	private String prpLregistLossName;
	private String prpLregistReceiverCode;
	private String prpLregistReceiverName;
	private String prpLregistLossQuantity;
	private String prpLregistEstimateLoss;
	private String prpLregistHandler1Code;
	private String prpLregistHandler1Name;
	private String prpLregistComCode;
	private String prpLregistComName;
	private String prpLregistOperatorCode;
	private String prpLregistOperatorName;
	private String prpLregistMakeCom;
	private String prpLregistMakeComName;
	private String acceptFlag;
	private String repeatInsureFlag;
	private String prplregistReportFlag;
	private String lossesUnitCode;
	// 事故者信息模块
	private String[] prpLacciPersonAcciCode;
	private String[] prpLacciBenPersonSerialNo;
	private String[] prpLacciPersonAcciName;
	private String[] prpLacciPersonFamilyNo;
	private String[] prpLacciPersonAge;
	private String[] prpLacciPersonSex;
	private String[] prpLacciPersonIdentifyNumber;
	private String[] prpLacciPersonAddress;
	// 耳标号信息表
	private String[] prplCompensateEarAccount;
	private String[] prplCompensateEarBank;
	private String[] prplCompensateEarBreedingAreaCode;
	private String[] prplCompensateEarBreedingAreaName;
	private String[] prplCompensateEarCaseNo;
	private String[] prplCompensateEarClaimNo;
	private String[] prplCompensateEarClaimRate;
	private String[] prplCompensateEarCombineNo;
	private String[] prplCompensateEarCompensateNo;
	private String[] prplCompensateEarCullNumber;
	private String[] prplCompensateEarDamageCode;
	private String[] prplCompensateEarDamageEndDate;
	private String[] prplCompensateEarDamageName;
	private String[] prplCompensateEarDamageStartDate;
	private String[] prplCompensateEarDamageStartHour;
	private String[] prplCompensateEarDeadNumber;
	private String[] prplCompensateEarDeadReason;
	private String[] prplCompensateEarDeductible;
	private String[] prplCompensateEarDeductibleRate;
	private String[] prplCompensateEarEarNo;
	private String[] prplCompensateEarEstimateLoss;
	private String[] prplCompensateEarFCode;
	private String[] prplCompensateEarId_Card;
	private String[] prplCompensateEarInusreListCode;
	private String[] prplCompensateEarKindCode;
	private String[] prplCompensateEarName;
	private String[] prplCompensateEarNodeNo;
	private String[] prplCompensateEarNodeType;
	private String[] prplCompensateEarPolicyNo;
	private String[] prplCompensateEarRegistNo;
	private String[] prplCompensateEarReportTime;
	private String[] prplCompensateEarRestFee;
	private String[] prplCompensateEarSumRealpay;
	private String[] prplCompensateEarUnitAmount;
	private String buttonSaveType;
	private String scheduleRef;
	
	private String scheduleType;
	
	private String prpLregistTextContextInnerHTML2;
	private String prpLregistInsuredAddress;
	private String prpLregistClauseType;
	private String prpLregistLicenseNo;
	private String prpLregistLicenseColorCode;
	private String prpLregistCarKindCode;
	private String prpLregistModelCode;
	private String prpLregistBrandName;
	private String prpLregistEngineNo;
	private String prpLregistFrameNo;
	private String prpLregistRunDistance;
	private String prpLregistUseYears;
	private String prpLregistReportorPhoneNumber;
	private String prpLregistLinkerPostCode;
	private String prpLregistReportAddress;
	private String firstSiteFlag;
	private String prpLregistDamageAreaCode;
	private String prpLregistDamageAreaName;
	private String damageAddressType;
	private String prpLregistDamageAreaPostCode;
	private String prpLregistHandleUnit;
	private String prpLregistUnit;
	private String prpLregistHandlerCode;
	private String claimType;
	private String prpLregistCancelDate;
	private String prpLregistDealerCode;
	private String prpLregistFlag;
	private String indemnityDuty;

	//农村住房信息
	private String prplCompensateHouseAddress; 
	private String prplCompensateHouseRemark;  
	private String prplCompensateHouseEstimateloss;    
	private String prplCompensateHouseHukoubu; 
	private String prplCompensateHouseIdcard;  
	private String prplCompensateHouseName;  
	private String prplCompensateHousePhone; 
	private String prplCompensateHouseFloor;  
	private String prplCompensateHouseBuildingnumber;  
	private String prplCompensateHouseZhuannumber; 
	private String prplCompensateHouseWanumber;   
	private String prplCompensateHouseKitchennumber;  
	private String prplCompensateHouseOthernumber;
	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getUserComCode() {
		return UserComCode;
	}

	public void setUserComCode(String userComCode) {
		UserComCode = userComCode;
	}

	public String getUserComName() {
		return UserComName;
	}

	public void setUserComName(String userComName) {
		UserComName = userComName;
	}

	public String getUserCode() {
		return UserCode;
	}

	public void setUserCode(String userCode) {
		UserCode = userCode;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getDamageMessageFlag() {
		return damageMessageFlag;
	}

	public void setDamageMessageFlag(String damageMessageFlag) {
		this.damageMessageFlag = damageMessageFlag;
	}

	public String[] getDamageMessage() {
		return damageMessage;
	}

	public void setDamageMessage(String[] damageMessage) {
		this.damageMessage = damageMessage;
	}

	public String getPrpLregistLinkerAddress() {
		return prpLregistLinkerAddress;
	}

	public void setPrpLregistLinkerAddress(String prpLregistLinkerAddress) {
		this.prpLregistLinkerAddress = prpLregistLinkerAddress;
	}

	public String getPrpLregistDamageTypeCode() {
		return prpLregistDamageTypeCode;
	}

	public void setPrpLregistDamageTypeCode(String prpLregistDamageTypeCode) {
		this.prpLregistDamageTypeCode = prpLregistDamageTypeCode;
	}

	public String getPrpLregistDamageTypeName() {
		return prpLregistDamageTypeName;
	}

	public void setPrpLregistDamageTypeName(String prpLregistDamageTypeName) {
		this.prpLregistDamageTypeName = prpLregistDamageTypeName;
	}

	public String getPrpLregistLossesNumber() {
		return prpLregistLossesNumber;
	}

	public void setPrpLregistLossesNumber(String prpLregistLossesNumber) {
		this.prpLregistLossesNumber = prpLregistLossesNumber;
	}

	public String getQsFlag() {
		return qsFlag;
	}

	public void setQsFlag(String qsFlag) {
		this.qsFlag = qsFlag;
	}

	public String getPrpLregistLFlag() {
		return prpLregistLFlag;
	}

	public void setPrpLregistLFlag(String prpLregistLFlag) {
		this.prpLregistLFlag = prpLregistLFlag;
	}

	public String getPrpLregistRiskCode() {
		return prpLregistRiskCode;
	}

	public void setPrpLregistRiskCode(String prpLregistRiskCode) {
		this.prpLregistRiskCode = prpLregistRiskCode;
	}

	public String getPrpLregistClassCode() {
		return prpLregistClassCode;
	}

	public void setPrpLregistClassCode(String prpLregistClassCode) {
		this.prpLregistClassCode = prpLregistClassCode;
	}

	public String getPrpLregistLanguage() {
		return prpLregistLanguage;
	}

	public void setPrpLregistLanguage(String prpLregistLanguage) {
		this.prpLregistLanguage = prpLregistLanguage;
	}

	public String getPrpLregistTypeForDriver() {
		return prpLregistTypeForDriver;
	}

	public void setPrpLregistTypeForDriver(String prpLregistTypeForDriver) {
		this.prpLregistTypeForDriver = prpLregistTypeForDriver;
	}

	public String getPrpLregistPolicyNo() {
		return prpLregistPolicyNo;
	}

	public void setPrpLregistPolicyNo(String prpLregistPolicyNo) {
		this.prpLregistPolicyNo = prpLregistPolicyNo;
	}

	public String getPrpLregistInsuredCode() {
		return prpLregistInsuredCode;
	}

	public void setPrpLregistInsuredCode(String prpLregistInsuredCode) {
		this.prpLregistInsuredCode = prpLregistInsuredCode;
	}

	public String getPrpLregistInsuredName() {
		return prpLregistInsuredName;
	}

	public void setPrpLregistInsuredName(String prpLregistInsuredName) {
		this.prpLregistInsuredName = prpLregistInsuredName;
	}

	public String getPrpLregistDamageStartDate() {
		return prpLregistDamageStartDate;
	}

	public void setPrpLregistDamageStartDate(String prpLregistDamageStartDate) {
		this.prpLregistDamageStartDate = prpLregistDamageStartDate;
	}

	public String getPrpLregistDamageStartHour() {
		return prpLregistDamageStartHour;
	}

	public void setPrpLregistDamageStartHour(String prpLregistDamageStartHour) {
		this.prpLregistDamageStartHour = prpLregistDamageStartHour;
	}

	public String getPrpLregistDamageStartMinute() {
		return prpLregistDamageStartMinute;
	}

	public void setPrpLregistDamageStartMinute(
			String prpLregistDamageStartMinute) {
		this.prpLregistDamageStartMinute = prpLregistDamageStartMinute;
	}

	public String getPrpLregistDamageCode() {
		return prpLregistDamageCode;
	}

	public void setPrpLregistDamageCode(String prpLregistDamageCode) {
		this.prpLregistDamageCode = prpLregistDamageCode;
	}

	public String getPrpLregistDamageName() {
		return prpLregistDamageName;
	}

	public void setPrpLregistDamageName(String prpLregistDamageName) {
		this.prpLregistDamageName = prpLregistDamageName;
	}

	public String getPrpLregistReportorName() {
		return prpLregistReportorName;
	}

	public void setPrpLregistReportorName(String prpLregistReportorName) {
		this.prpLregistReportorName = prpLregistReportorName;
	}

	public String getPrpLregistReportDate() {
		return prpLregistReportDate;
	}

	public void setPrpLregistReportDate(String prpLregistReportDate) {
		this.prpLregistReportDate = prpLregistReportDate;
	}

	public String getPrpLregistReportHour() {
		return prpLregistReportHour;
	}

	public void setPrpLregistReportHour(String prpLregistReportHour) {
		this.prpLregistReportHour = prpLregistReportHour;
	}

	public String getPrpLregistReportMinute() {
		return prpLregistReportMinute;
	}

	public void setPrpLregistReportMinute(String prpLregistReportMinute) {
		this.prpLregistReportMinute = prpLregistReportMinute;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getPrpLregistInputDate() {
		return prpLregistInputDate;
	}

	public void setPrpLregistInputDate(String prpLregistInputDate) {
		this.prpLregistInputDate = prpLregistInputDate;
	}

	public String getPrpLregistLinkerName() {
		return prpLregistLinkerName;
	}

	public void setPrpLregistLinkerName(String prpLregistLinkerName) {
		this.prpLregistLinkerName = prpLregistLinkerName;
	}

	public String getPrpLregistPhoneNumber() {
		return prpLregistPhoneNumber;
	}

	public void setPrpLregistPhoneNumber(String prpLregistPhoneNumber) {
		this.prpLregistPhoneNumber = prpLregistPhoneNumber;
	}

	public String[] getPrpLrelatePersonSeriaNo() {
		return prpLrelatePersonSeriaNo;
	}

	public void setPrpLrelatePersonSeriaNo(String[] prpLrelatePersonSeriaNo) {
		this.prpLrelatePersonSeriaNo = prpLrelatePersonSeriaNo;
	}

	public String[] getPrpLrelatePersonPersonName() {
		return prpLrelatePersonPersonName;
	}

	public void setPrpLrelatePersonPersonName(
			String[] prpLrelatePersonPersonName) {
		this.prpLrelatePersonPersonName = prpLrelatePersonPersonName;
	}

	public String[] getPrpLrelatePersonPhoneNumber() {
		return prpLrelatePersonPhoneNumber;
	}

	public void setPrpLrelatePersonPhoneNumber(
			String[] prpLrelatePersonPhoneNumber) {
		this.prpLrelatePersonPhoneNumber = prpLrelatePersonPhoneNumber;
	}

	public String[] getPrpLrelatePersonMobile() {
		return prpLrelatePersonMobile;
	}

	public void setPrpLrelatePersonMobile(String[] prpLrelatePersonMobile) {
		this.prpLrelatePersonMobile = prpLrelatePersonMobile;
	}

	public String[] getPrpLrelatePersonRemark() {
		return prpLrelatePersonRemark;
	}

	public void setPrpLrelatePersonRemark(String[] prpLrelatePersonRemark) {
		this.prpLrelatePersonRemark = prpLrelatePersonRemark;
	}

	public String getPrpLregistAddressCode() {
		return prpLregistAddressCode;
	}

	public void setPrpLregistAddressCode(String prpLregistAddressCode) {
		this.prpLregistAddressCode = prpLregistAddressCode;
	}

	public String getPrpLregistDamageAddress() {
		return prpLregistDamageAddress;
	}

	public void setPrpLregistDamageAddress(String prpLregistDamageAddress) {
		this.prpLregistDamageAddress = prpLregistDamageAddress;
	}

	public String getPrpLregistEstiCurrency() {
		return prpLregistEstiCurrency;
	}

	public void setPrpLregistEstiCurrency(String prpLregistEstiCurrency) {
		this.prpLregistEstiCurrency = prpLregistEstiCurrency;
	}

	public String getPrpLregistEstimateFee() {
		return prpLregistEstimateFee;
	}

	public void setPrpLregistEstimateFee(String prpLregistEstimateFee) {
		this.prpLregistEstimateFee = prpLregistEstimateFee;
	}

	public String getPrpLregistRemark() {
		return prpLregistRemark;
	}

	public void setPrpLregistRemark(String prpLregistRemark) {
		this.prpLregistRemark = prpLregistRemark;
	}

	public String getPrpLregistTextContextInnerHTML() {
		return prpLregistTextContextInnerHTML;
	}

	public void setPrpLregistTextContextInnerHTML(
			String prpLregistTextContextInnerHTML) {
		this.prpLregistTextContextInnerHTML = prpLregistTextContextInnerHTML;
	}

	public String getPrpCatastropheCode1() {
		return prpCatastropheCode1;
	}

	public void setPrpCatastropheCode1(String prpCatastropheCode1) {
		this.prpCatastropheCode1 = prpCatastropheCode1;
	}

	public String getPrpCatastropheName1() {
		return prpCatastropheName1;
	}

	public void setPrpCatastropheName1(String prpCatastropheName1) {
		this.prpCatastropheName1 = prpCatastropheName1;
	}

	public String getPrpCatastropheCode2() {
		return prpCatastropheCode2;
	}

	public void setPrpCatastropheCode2(String prpCatastropheCode2) {
		this.prpCatastropheCode2 = prpCatastropheCode2;
	}

	public String getPrpCatastropheName2() {
		return prpCatastropheName2;
	}

	public void setPrpCatastropheName2(String prpCatastropheName2) {
		this.prpCatastropheName2 = prpCatastropheName2;
	}

	public String getPrpLregistLossName() {
		return prpLregistLossName;
	}

	public void setPrpLregistLossName(String prpLregistLossName) {
		this.prpLregistLossName = prpLregistLossName;
	}

	public String getPrpLregistReceiverCode() {
		return prpLregistReceiverCode;
	}

	public void setPrpLregistReceiverCode(String prpLregistReceiverCode) {
		this.prpLregistReceiverCode = prpLregistReceiverCode;
	}

	public String getPrpLregistReceiverName() {
		return prpLregistReceiverName;
	}

	public void setPrpLregistReceiverName(String prpLregistReceiverName) {
		this.prpLregistReceiverName = prpLregistReceiverName;
	}

	public String getPrpLregistLossQuantity() {
		return prpLregistLossQuantity;
	}

	public void setPrpLregistLossQuantity(String prpLregistLossQuantity) {
		this.prpLregistLossQuantity = prpLregistLossQuantity;
	}

	public String getPrpLregistEstimateLoss() {
		return prpLregistEstimateLoss;
	}

	public void setPrpLregistEstimateLoss(String prpLregistEstimateLoss) {
		this.prpLregistEstimateLoss = prpLregistEstimateLoss;
	}

	public String getPrpLregistHandler1Code() {
		return prpLregistHandler1Code;
	}

	public void setPrpLregistHandler1Code(String prpLregistHandler1Code) {
		this.prpLregistHandler1Code = prpLregistHandler1Code;
	}

	public String getPrpLregistHandler1Name() {
		return prpLregistHandler1Name;
	}

	public void setPrpLregistHandler1Name(String prpLregistHandler1Name) {
		this.prpLregistHandler1Name = prpLregistHandler1Name;
	}

	public String getPrpLregistComCode() {
		return prpLregistComCode;
	}

	public void setPrpLregistComCode(String prpLregistComCode) {
		this.prpLregistComCode = prpLregistComCode;
	}

	public String getPrpLregistComName() {
		return prpLregistComName;
	}

	public void setPrpLregistComName(String prpLregistComName) {
		this.prpLregistComName = prpLregistComName;
	}

	public String getPrpLregistOperatorCode() {
		return prpLregistOperatorCode;
	}

	public void setPrpLregistOperatorCode(String prpLregistOperatorCode) {
		this.prpLregistOperatorCode = prpLregistOperatorCode;
	}

	public String getPrpLregistOperatorName() {
		return prpLregistOperatorName;
	}

	public void setPrpLregistOperatorName(String prpLregistOperatorName) {
		this.prpLregistOperatorName = prpLregistOperatorName;
	}

	public String getPrpLregistMakeCom() {
		return prpLregistMakeCom;
	}

	public void setPrpLregistMakeCom(String prpLregistMakeCom) {
		this.prpLregistMakeCom = prpLregistMakeCom;
	}

	public String getPrpLregistMakeComName() {
		return prpLregistMakeComName;
	}

	public void setPrpLregistMakeComName(String prpLregistMakeComName) {
		this.prpLregistMakeComName = prpLregistMakeComName;
	}

	public String getAcceptFlag() {
		return acceptFlag;
	}

	public void setAcceptFlag(String acceptFlag) {
		this.acceptFlag = acceptFlag;
	}

	public String getRepeatInsureFlag() {
		return repeatInsureFlag;
	}

	public void setRepeatInsureFlag(String repeatInsureFlag) {
		this.repeatInsureFlag = repeatInsureFlag;
	}

	public String getPrplregistReportFlag() {
		return prplregistReportFlag;
	}

	public void setPrplregistReportFlag(String prplregistReportFlag) {
		this.prplregistReportFlag = prplregistReportFlag;
	}

	public String getLossesUnitCode() {
		return lossesUnitCode;
	}

	public void setLossesUnitCode(String lossesUnitCode) {
		this.lossesUnitCode = lossesUnitCode;
	}

	public String[] getPrpLacciPersonAcciCode() {
		return prpLacciPersonAcciCode;
	}

	public void setPrpLacciPersonAcciCode(String[] prpLacciPersonAcciCode) {
		this.prpLacciPersonAcciCode = prpLacciPersonAcciCode;
	}

	public String[] getPrpLacciBenPersonSerialNo() {
		return prpLacciBenPersonSerialNo;
	}

	public void setPrpLacciBenPersonSerialNo(String[] prpLacciBenPersonSerialNo) {
		this.prpLacciBenPersonSerialNo = prpLacciBenPersonSerialNo;
	}

	public String[] getPrpLacciPersonAcciName() {
		return prpLacciPersonAcciName;
	}

	public void setPrpLacciPersonAcciName(String[] prpLacciPersonAcciName) {
		this.prpLacciPersonAcciName = prpLacciPersonAcciName;
	}

	public String[] getPrpLacciPersonFamilyNo() {
		return prpLacciPersonFamilyNo;
	}

	public void setPrpLacciPersonFamilyNo(String[] prpLacciPersonFamilyNo) {
		this.prpLacciPersonFamilyNo = prpLacciPersonFamilyNo;
	}

	public String[] getPrpLacciPersonAge() {
		return prpLacciPersonAge;
	}

	public void setPrpLacciPersonAge(String[] prpLacciPersonAge) {
		this.prpLacciPersonAge = prpLacciPersonAge;
	}

	public String[] getPrpLacciPersonSex() {
		return prpLacciPersonSex;
	}

	public void setPrpLacciPersonSex(String[] prpLacciPersonSex) {
		this.prpLacciPersonSex = prpLacciPersonSex;
	}

	public String[] getPrpLacciPersonIdentifyNumber() {
		return prpLacciPersonIdentifyNumber;
	}

	public void setPrpLacciPersonIdentifyNumber(
			String[] prpLacciPersonIdentifyNumber) {
		this.prpLacciPersonIdentifyNumber = prpLacciPersonIdentifyNumber;
	}

	public String[] getPrpLacciPersonAddress() {
		return prpLacciPersonAddress;
	}

	public void setPrpLacciPersonAddress(String[] prpLacciPersonAddress) {
		this.prpLacciPersonAddress = prpLacciPersonAddress;
	}

	public String[] getPrplCompensateEarAccount() {
		return prplCompensateEarAccount;
	}

	public void setPrplCompensateEarAccount(String[] prplCompensateEarAccount) {
		this.prplCompensateEarAccount = prplCompensateEarAccount;
	}

	public String[] getPrplCompensateEarBank() {
		return prplCompensateEarBank;
	}

	public void setPrplCompensateEarBank(String[] prplCompensateEarBank) {
		this.prplCompensateEarBank = prplCompensateEarBank;
	}

	public String[] getPrplCompensateEarBreedingAreaCode() {
		return prplCompensateEarBreedingAreaCode;
	}

	public void setPrplCompensateEarBreedingAreaCode(
			String[] prplCompensateEarBreedingAreaCode) {
		this.prplCompensateEarBreedingAreaCode = prplCompensateEarBreedingAreaCode;
	}

	public String[] getPrplCompensateEarBreedingAreaName() {
		return prplCompensateEarBreedingAreaName;
	}

	public void setPrplCompensateEarBreedingAreaName(
			String[] prplCompensateEarBreedingAreaName) {
		this.prplCompensateEarBreedingAreaName = prplCompensateEarBreedingAreaName;
	}

	public String[] getPrplCompensateEarCaseNo() {
		return prplCompensateEarCaseNo;
	}

	public void setPrplCompensateEarCaseNo(String[] prplCompensateEarCaseNo) {
		this.prplCompensateEarCaseNo = prplCompensateEarCaseNo;
	}

	public String[] getPrplCompensateEarClaimNo() {
		return prplCompensateEarClaimNo;
	}

	public void setPrplCompensateEarClaimNo(String[] prplCompensateEarClaimNo) {
		this.prplCompensateEarClaimNo = prplCompensateEarClaimNo;
	}

	public String[] getPrplCompensateEarClaimRate() {
		return prplCompensateEarClaimRate;
	}

	public void setPrplCompensateEarClaimRate(
			String[] prplCompensateEarClaimRate) {
		this.prplCompensateEarClaimRate = prplCompensateEarClaimRate;
	}

	public String[] getPrplCompensateEarCombineNo() {
		return prplCompensateEarCombineNo;
	}

	public void setPrplCompensateEarCombineNo(
			String[] prplCompensateEarCombineNo) {
		this.prplCompensateEarCombineNo = prplCompensateEarCombineNo;
	}

	public String[] getPrplCompensateEarCompensateNo() {
		return prplCompensateEarCompensateNo;
	}

	public void setPrplCompensateEarCompensateNo(
			String[] prplCompensateEarCompensateNo) {
		this.prplCompensateEarCompensateNo = prplCompensateEarCompensateNo;
	}

	public String[] getPrplCompensateEarCullNumber() {
		return prplCompensateEarCullNumber;
	}

	public void setPrplCompensateEarCullNumber(
			String[] prplCompensateEarCullNumber) {
		this.prplCompensateEarCullNumber = prplCompensateEarCullNumber;
	}

	public String[] getPrplCompensateEarDamageCode() {
		return prplCompensateEarDamageCode;
	}

	public void setPrplCompensateEarDamageCode(
			String[] prplCompensateEarDamageCode) {
		this.prplCompensateEarDamageCode = prplCompensateEarDamageCode;
	}

	public String[] getPrplCompensateEarDamageEndDate() {
		return prplCompensateEarDamageEndDate;
	}

	public void setPrplCompensateEarDamageEndDate(
			String[] prplCompensateEarDamageEndDate) {
		this.prplCompensateEarDamageEndDate = prplCompensateEarDamageEndDate;
	}

	public String[] getPrplCompensateEarDamageName() {
		return prplCompensateEarDamageName;
	}

	public void setPrplCompensateEarDamageName(
			String[] prplCompensateEarDamageName) {
		this.prplCompensateEarDamageName = prplCompensateEarDamageName;
	}

	public String[] getPrplCompensateEarDamageStartDate() {
		return prplCompensateEarDamageStartDate;
	}

	public void setPrplCompensateEarDamageStartDate(
			String[] prplCompensateEarDamageStartDate) {
		this.prplCompensateEarDamageStartDate = prplCompensateEarDamageStartDate;
	}

	public String[] getPrplCompensateEarDamageStartHour() {
		return prplCompensateEarDamageStartHour;
	}

	public void setPrplCompensateEarDamageStartHour(
			String[] prplCompensateEarDamageStartHour) {
		this.prplCompensateEarDamageStartHour = prplCompensateEarDamageStartHour;
	}

	public String[] getPrplCompensateEarDeadNumber() {
		return prplCompensateEarDeadNumber;
	}

	public void setPrplCompensateEarDeadNumber(
			String[] prplCompensateEarDeadNumber) {
		this.prplCompensateEarDeadNumber = prplCompensateEarDeadNumber;
	}

	public String[] getPrplCompensateEarDeadReason() {
		return prplCompensateEarDeadReason;
	}

	public void setPrplCompensateEarDeadReason(
			String[] prplCompensateEarDeadReason) {
		this.prplCompensateEarDeadReason = prplCompensateEarDeadReason;
	}

	public String[] getPrplCompensateEarDeductible() {
		return prplCompensateEarDeductible;
	}

	public void setPrplCompensateEarDeductible(
			String[] prplCompensateEarDeductible) {
		this.prplCompensateEarDeductible = prplCompensateEarDeductible;
	}

	public String[] getPrplCompensateEarDeductibleRate() {
		return prplCompensateEarDeductibleRate;
	}

	public void setPrplCompensateEarDeductibleRate(
			String[] prplCompensateEarDeductibleRate) {
		this.prplCompensateEarDeductibleRate = prplCompensateEarDeductibleRate;
	}

	public String[] getPrplCompensateEarEarNo() {
		return prplCompensateEarEarNo;
	}

	public void setPrplCompensateEarEarNo(String[] prplCompensateEarEarNo) {
		this.prplCompensateEarEarNo = prplCompensateEarEarNo;
	}

	public String[] getPrplCompensateEarEstimateLoss() {
		return prplCompensateEarEstimateLoss;
	}

	public void setPrplCompensateEarEstimateLoss(
			String[] prplCompensateEarEstimateLoss) {
		this.prplCompensateEarEstimateLoss = prplCompensateEarEstimateLoss;
	}

	public String[] getPrplCompensateEarFCode() {
		return prplCompensateEarFCode;
	}

	public void setPrplCompensateEarFCode(String[] prplCompensateEarFCode) {
		this.prplCompensateEarFCode = prplCompensateEarFCode;
	}

	public String[] getPrplCompensateEarId_Card() {
		return prplCompensateEarId_Card;
	}

	public void setPrplCompensateEarId_Card(String[] prplCompensateEarId_Card) {
		this.prplCompensateEarId_Card = prplCompensateEarId_Card;
	}

	public String[] getPrplCompensateEarInusreListCode() {
		return prplCompensateEarInusreListCode;
	}

	public void setPrplCompensateEarInusreListCode(
			String[] prplCompensateEarInusreListCode) {
		this.prplCompensateEarInusreListCode = prplCompensateEarInusreListCode;
	}

	public String[] getPrplCompensateEarKindCode() {
		return prplCompensateEarKindCode;
	}

	public void setPrplCompensateEarKindCode(String[] prplCompensateEarKindCode) {
		this.prplCompensateEarKindCode = prplCompensateEarKindCode;
	}

	public String[] getPrplCompensateEarName() {
		return prplCompensateEarName;
	}

	public void setPrplCompensateEarName(String[] prplCompensateEarName) {
		this.prplCompensateEarName = prplCompensateEarName;
	}

	public String[] getPrplCompensateEarNodeNo() {
		return prplCompensateEarNodeNo;
	}

	public void setPrplCompensateEarNodeNo(String[] prplCompensateEarNodeNo) {
		this.prplCompensateEarNodeNo = prplCompensateEarNodeNo;
	}

	public String[] getPrplCompensateEarNodeType() {
		return prplCompensateEarNodeType;
	}

	public void setPrplCompensateEarNodeType(String[] prplCompensateEarNodeType) {
		this.prplCompensateEarNodeType = prplCompensateEarNodeType;
	}

	public String[] getPrplCompensateEarPolicyNo() {
		return prplCompensateEarPolicyNo;
	}

	public void setPrplCompensateEarPolicyNo(String[] prplCompensateEarPolicyNo) {
		this.prplCompensateEarPolicyNo = prplCompensateEarPolicyNo;
	}

	public String[] getPrplCompensateEarRegistNo() {
		return prplCompensateEarRegistNo;
	}

	public void setPrplCompensateEarRegistNo(String[] prplCompensateEarRegistNo) {
		this.prplCompensateEarRegistNo = prplCompensateEarRegistNo;
	}

	public String[] getPrplCompensateEarReportTime() {
		return prplCompensateEarReportTime;
	}

	public void setPrplCompensateEarReportTime(
			String[] prplCompensateEarReportTime) {
		this.prplCompensateEarReportTime = prplCompensateEarReportTime;
	}

	public String[] getPrplCompensateEarRestFee() {
		return prplCompensateEarRestFee;
	}

	public void setPrplCompensateEarRestFee(String[] prplCompensateEarRestFee) {
		this.prplCompensateEarRestFee = prplCompensateEarRestFee;
	}

	public String[] getPrplCompensateEarSumRealpay() {
		return prplCompensateEarSumRealpay;
	}

	public void setPrplCompensateEarSumRealpay(
			String[] prplCompensateEarSumRealpay) {
		this.prplCompensateEarSumRealpay = prplCompensateEarSumRealpay;
	}

	public String[] getPrplCompensateEarUnitAmount() {
		return prplCompensateEarUnitAmount;
	}

	public void setPrplCompensateEarUnitAmount(
			String[] prplCompensateEarUnitAmount) {
		this.prplCompensateEarUnitAmount = prplCompensateEarUnitAmount;
	}

	public String getButtonSaveType() {
		return buttonSaveType;
	}

	public void setButtonSaveType(String buttonSaveType) {
		this.buttonSaveType = buttonSaveType;
	}

	public String getScheduleRef() {
		return scheduleRef;
	}

	public void setScheduleRef(String scheduleRef) {
		this.scheduleRef = scheduleRef;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

	public String getPrpLregistTextContextInnerHTML2() {
		return prpLregistTextContextInnerHTML2;
	}

	public void setPrpLregistTextContextInnerHTML2(
			String prpLregistTextContextInnerHTML2) {
		this.prpLregistTextContextInnerHTML2 = prpLregistTextContextInnerHTML2;
	}

	public String getPrpLregistInsuredAddress() {
		return prpLregistInsuredAddress;
	}

	public void setPrpLregistInsuredAddress(String prpLregistInsuredAddress) {
		this.prpLregistInsuredAddress = prpLregistInsuredAddress;
	}

	public String getPrpLregistClauseType() {
		return prpLregistClauseType;
	}

	public void setPrpLregistClauseType(String prpLregistClauseType) {
		this.prpLregistClauseType = prpLregistClauseType;
	}

	public String getPrpLregistLicenseNo() {
		return prpLregistLicenseNo;
	}

	public void setPrpLregistLicenseNo(String prpLregistLicenseNo) {
		this.prpLregistLicenseNo = prpLregistLicenseNo;
	}

	public String getPrpLregistLicenseColorCode() {
		return prpLregistLicenseColorCode;
	}

	public void setPrpLregistLicenseColorCode(String prpLregistLicenseColorCode) {
		this.prpLregistLicenseColorCode = prpLregistLicenseColorCode;
	}

	public String getPrpLregistCarKindCode() {
		return prpLregistCarKindCode;
	}

	public void setPrpLregistCarKindCode(String prpLregistCarKindCode) {
		this.prpLregistCarKindCode = prpLregistCarKindCode;
	}

	public String getPrpLregistModelCode() {
		return prpLregistModelCode;
	}

	public void setPrpLregistModelCode(String prpLregistModelCode) {
		this.prpLregistModelCode = prpLregistModelCode;
	}

	public String getPrpLregistBrandName() {
		return prpLregistBrandName;
	}

	public void setPrpLregistBrandName(String prpLregistBrandName) {
		this.prpLregistBrandName = prpLregistBrandName;
	}

	public String getPrpLregistEngineNo() {
		return prpLregistEngineNo;
	}

	public void setPrpLregistEngineNo(String prpLregistEngineNo) {
		this.prpLregistEngineNo = prpLregistEngineNo;
	}

	public String getPrpLregistFrameNo() {
		return prpLregistFrameNo;
	}

	public void setPrpLregistFrameNo(String prpLregistFrameNo) {
		this.prpLregistFrameNo = prpLregistFrameNo;
	}

	public String getPrpLregistRunDistance() {
		return prpLregistRunDistance;
	}

	public void setPrpLregistRunDistance(String prpLregistRunDistance) {
		this.prpLregistRunDistance = prpLregistRunDistance;
	}

	public String getPrpLregistUseYears() {
		return prpLregistUseYears;
	}

	public void setPrpLregistUseYears(String prpLregistUseYears) {
		this.prpLregistUseYears = prpLregistUseYears;
	}

	public String getPrpLregistReportorPhoneNumber() {
		return prpLregistReportorPhoneNumber;
	}

	public void setPrpLregistReportorPhoneNumber(
			String prpLregistReportorPhoneNumber) {
		this.prpLregistReportorPhoneNumber = prpLregistReportorPhoneNumber;
	}

	public String getPrpLregistLinkerPostCode() {
		return prpLregistLinkerPostCode;
	}

	public void setPrpLregistLinkerPostCode(String prpLregistLinkerPostCode) {
		this.prpLregistLinkerPostCode = prpLregistLinkerPostCode;
	}

	public String getPrpLregistReportAddress() {
		return prpLregistReportAddress;
	}

	public void setPrpLregistReportAddress(String prpLregistReportAddress) {
		this.prpLregistReportAddress = prpLregistReportAddress;
	}

	public String getFirstSiteFlag() {
		return firstSiteFlag;
	}

	public void setFirstSiteFlag(String firstSiteFlag) {
		this.firstSiteFlag = firstSiteFlag;
	}

	public String getPrpLregistDamageAreaCode() {
		return prpLregistDamageAreaCode;
	}

	public void setPrpLregistDamageAreaCode(String prpLregistDamageAreaCode) {
		this.prpLregistDamageAreaCode = prpLregistDamageAreaCode;
	}

	public String getPrpLregistDamageAreaName() {
		return prpLregistDamageAreaName;
	}

	public void setPrpLregistDamageAreaName(String prpLregistDamageAreaName) {
		this.prpLregistDamageAreaName = prpLregistDamageAreaName;
	}

	public String getDamageAddressType() {
		return damageAddressType;
	}

	public void setDamageAddressType(String damageAddressType) {
		this.damageAddressType = damageAddressType;
	}

	public String getPrpLregistDamageAreaPostCode() {
		return prpLregistDamageAreaPostCode;
	}

	public void setPrpLregistDamageAreaPostCode(String prpLregistDamageAreaPostCode) {
		this.prpLregistDamageAreaPostCode = prpLregistDamageAreaPostCode;
	}

	public String getPrpLregistHandleUnit() {
		return prpLregistHandleUnit;
	}

	public void setPrpLregistHandleUnit(String prpLregistHandleUnit) {
		this.prpLregistHandleUnit = prpLregistHandleUnit;
	}

	public String getPrpLregistUnit() {
		return prpLregistUnit;
	}

	public void setPrpLregistUnit(String prpLregistUnit) {
		this.prpLregistUnit = prpLregistUnit;
	}

	public String getPrpLregistHandlerCode() {
		return prpLregistHandlerCode;
	}

	public void setPrpLregistHandlerCode(String prpLregistHandlerCode) {
		this.prpLregistHandlerCode = prpLregistHandlerCode;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	public String getPrpLregistCancelDate() {
		return prpLregistCancelDate;
	}

	public void setPrpLregistCancelDate(String prpLregistCancelDate) {
		this.prpLregistCancelDate = prpLregistCancelDate;
	}

	public String getPrpLregistDealerCode() {
		return prpLregistDealerCode;
	}

	public void setPrpLregistDealerCode(String prpLregistDealerCode) {
		this.prpLregistDealerCode = prpLregistDealerCode;
	}

	public String getPrpLregistFlag() {
		return prpLregistFlag;
	}

	public void setPrpLregistFlag(String prpLregistFlag) {
		this.prpLregistFlag = prpLregistFlag;
	}

	public String getIndemnityDuty() {
		return indemnityDuty;
	}

	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}

	public String getPrplCompensateHouseAddress() {
		return prplCompensateHouseAddress;
	}

	public void setPrplCompensateHouseAddress(String prplCompensateHouseAddress) {
		this.prplCompensateHouseAddress = prplCompensateHouseAddress;
	}

	public String getPrplCompensateHouseRemark() {
		return prplCompensateHouseRemark;
	}

	public void setPrplCompensateHouseRemark(String prplCompensateHouseRemark) {
		this.prplCompensateHouseRemark = prplCompensateHouseRemark;
	}

	public String getPrplCompensateHouseEstimateloss() {
		return prplCompensateHouseEstimateloss;
	}

	public void setPrplCompensateHouseEstimateloss(
			String prplCompensateHouseEstimateloss) {
		this.prplCompensateHouseEstimateloss = prplCompensateHouseEstimateloss;
	}

	public String getPrplCompensateHouseHukoubu() {
		return prplCompensateHouseHukoubu;
	}

	public void setPrplCompensateHouseHukoubu(String prplCompensateHouseHukoubu) {
		this.prplCompensateHouseHukoubu = prplCompensateHouseHukoubu;
	}

	public String getPrplCompensateHouseIdcard() {
		return prplCompensateHouseIdcard;
	}

	public void setPrplCompensateHouseIdcard(String prplCompensateHouseIdcard) {
		this.prplCompensateHouseIdcard = prplCompensateHouseIdcard;
	}

	public String getPrplCompensateHouseName() {
		return prplCompensateHouseName;
	}

	public void setPrplCompensateHouseName(String prplCompensateHouseName) {
		this.prplCompensateHouseName = prplCompensateHouseName;
	}

	public String getPrplCompensateHousePhone() {
		return prplCompensateHousePhone;
	}

	public void setPrplCompensateHousePhone(String prplCompensateHousePhone) {
		this.prplCompensateHousePhone = prplCompensateHousePhone;
	}

	public String getPrplCompensateHouseFloor() {
		return prplCompensateHouseFloor;
	}

	public void setPrplCompensateHouseFloor(String prplCompensateHouseFloor) {
		this.prplCompensateHouseFloor = prplCompensateHouseFloor;
	}

	public String getPrplCompensateHouseBuildingnumber() {
		return prplCompensateHouseBuildingnumber;
	}

	public void setPrplCompensateHouseBuildingnumber(
			String prplCompensateHouseBuildingnumber) {
		this.prplCompensateHouseBuildingnumber = prplCompensateHouseBuildingnumber;
	}

	public String getPrplCompensateHouseZhuannumber() {
		return prplCompensateHouseZhuannumber;
	}

	public void setPrplCompensateHouseZhuannumber(
			String prplCompensateHouseZhuannumber) {
		this.prplCompensateHouseZhuannumber = prplCompensateHouseZhuannumber;
	}

	public String getPrplCompensateHouseWanumber() {
		return prplCompensateHouseWanumber;
	}

	public void setPrplCompensateHouseWanumber(String prplCompensateHouseWanumber) {
		this.prplCompensateHouseWanumber = prplCompensateHouseWanumber;
	}

	public String getPrplCompensateHouseKitchennumber() {
		return prplCompensateHouseKitchennumber;
	}

	public void setPrplCompensateHouseKitchennumber(
			String prplCompensateHouseKitchennumber) {
		this.prplCompensateHouseKitchennumber = prplCompensateHouseKitchennumber;
	}

	public String getPrplCompensateHouseOthernumber() {
		return prplCompensateHouseOthernumber;
	}

	public void setPrplCompensateHouseOthernumber(
			String prplCompensateHouseOthernumber) {
		this.prplCompensateHouseOthernumber = prplCompensateHouseOthernumber;
	}
	
}
