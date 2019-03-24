package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class ClaimRequestInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 属性客户端报案流水号 */
	private String outRigstNo = "";
	/** 属性输入时间 */
	private Date inputDate = new Date();
	/** 属性保单号码 */
	private String policyno = "";
	/** 属性报案号码 */
	private String registno = "";
	/** 属性立案号码 */
	private String claimno = "";
	/** 属性事故日期(yyyy-MM-dd) */
	private Date damageStartDate = new Date();
	/** 属性事故时分(00:00) */
	private String damageStartHour = "";
	/** 属性事故原因 */
	private String damageCode = "";
	/** 属性报案人 */
	private String reportName = "";
	/** 属性报案时间(yyyy-MM-dd) */
	private Date reportDate = new Date();
	/** 属性报案时分(00:00) */
	private String reportHour = "";
	/** 属性报案方式 */
	private String reportType = "";
	/** 属性联系人 */
	private String linkerName = "";
	/** 属性联系电话 */
	private String phoneNumber = "";
	/** 属性联系地址 */
	private String linkerAddress = "";
	/** 属性与事故者关系 */
	private String clauseType = "";
	/** 属性事故地点 */
	private String damageAddress = "";
	/** 属性事故类型 */
	private String damageTypeCode = "";
	/** 属性赔付人次，默认为0 */
	private double lossesNumber = 0D;
	/** 属性操作人代码 */
	private String operatorCode = "";
	/** 属性操作人名称 */
	private String operatorName = "";
	/** 属性理赔处理机构 */
	private String makeCom = "";
	/** 属性处理机构名称 */
	private String makeComName = "";
	/** 属性报案备忘录 */
	private String remark = "";
	/** 属性事故经过及事故现状 */
	private String context = "";
	/** 属性报损金额CNY */
	private double estimateLoss = 0D;
	/** 属性调度查勘处理单位 */
	private String scheduleObjectId = "";
	/** 属性查勘地址 */
	private String checkSite = "";
	/** 属性查勘要点 */
	private String checkInfo = "";
	/** 属性查勘人代码 */
	private String nextHandlerCode = "";
	/** 属性查勘人名称 */
	private String nextHandlerName = "";
	/** 属性查勘人2 */
	private String checker2 = "";
	/** 属性查勘类型(查勘L代查D) */
	private String checkType = "";
	/** 属性查勘日期(yyyy-MM-dd) */
	private Date checkDate = new Date();
	/** 属性查勘性质(现场1其他9) */
	private String checkNature = "";
	/** 属性查勘预估金额CNY */
	private double checkEstimateLoss = 0D;
	/** 属性预估费用 */
	private double estimateFee = 0D;
	/** 属性查勘处理单位(内1，外0) */
	private String unitType = "";
	/** 属性查勘备注 */
	private String checkRemark = "";
	/** 属性查勘报告 */
	private String checkContext = "";
	/** 属性币别（默认CNY */
	private String currency = "";
	/** 属性事故类型名称 */
	private String damageTypeName = "";
	/** 属性是否可能追偿(是1，否0) */
	private String replevyFlag = "";
	/** 属性是否其他理赔中介:是1否0 */
	private String thirdComFlag = "";
	/** 属性立案估损金额 */
	private double sumClaim = 0D;
	/** 属性案件类型代码 */
	private String claimType = "";
	/** 属性申请预赔赔案类型选择 */
	private String caseType = "";
	/** 属性预赔申请原因 */
	private String payAppContext = "";
	/** 属性预赔金额，默认0.00 */
	private double sumPrePaid = 0D;
	/** 属性预赔报告 */
	private String prepayReport = "";
	/** 属性单证案件处理意见 */
	private String certifyContext = "";
	/** 属性被保险人开户银行 */
	private String bank = "";
	/** 属性收款人全称 */
	private String receiverName = "";
	/** 属性开户账号 */
	private String account = "";
	/** 属性确认开户账号 */
	private String accountOK = "";
	/** 属性零赔付原因 */
	private String zeroLossType = "";
	/** 属性费用合计，默认0.00 */
	private double sumNoDutyFee = 0D;
	/** 属性赔款合计，默认0.00 */
	private double prplCompensateSumPaid = 0D;
	/** 属性已预付赔款，默认0.00 */
	private double prplCompensateSumPrePaid = 0D;
	/** 属性已预付费用，默认0.00 */
	private double sumChargePaid = 0D;
	/** 属性本次给付金额，默认0.00 */
	private double sumThisPaid = 0D;
	/** 属性赔款计算过程 */
	private String compeContext = "";
	/** 属性审批片语 */
	private String notion = "";
	/** 属性核赔签署意见 */
	private String handleText = "";
	/** 属性客户端数据主键 */
    private String outId = "";
    /** 属性报案时间 */
    private Date registTime = new Date();
    /** 属性立案时间 */
    private Date compeTime = new Date();
    /** 属性核赔时间 */
    private Date vericTime = new Date();
    /** 属性报案操作人代码 */
    private String registUser = "";
    /** 属性立案操作人代码 */
    private String compeUser = "";
    /** 属性核赔操作人代码 */
    private String vericUser = "";
	/** 属性事故者信息 */
	private AccidentPersonInfoDto[] accidentPersonInfoDto;
	/** 属性调度补充说明信息 */
	private SchedExtInfoDto[] schedExtInfoDto;
	/** 属性立案索赔申请人信息 */
	private ClaimAppDto[] claimAppDto;
	/** 属性立案险别估损金额信息 */
	private ClaimKindDto[] claimKindDto;
	/** 属性费用信息 */
	private PrepayFeeInfoDto[] prepayFeeInfoDto;
	/** 属性单证信息 */
	private CertifyInfoDto[] certifyInfoDto;
	/** 属性计算书费用信息 */
	private CompeFeeInfoDto[] compeFeeInfoDto;
	/** 属性计算书赔款费用信息 */
	private CompePayFeeInfoDto[] compePayFeeInfoDto;
	/** 属性计算书理算清单信息 */
	private CompeInvMainInfo[] compeInvMainInfo;
	/** 属性具体出险人信息 */
	private InjuryPersonInfoDto injuryPersonInfoDto;
	/**具体出险人信息*/
	private InjuryPersonInfoDto[] injuryPersonInfoArrayDto;
	
	
	/**
	 * 默认构造方法,构造一个默认的PrpLinterRequestDtoBase对象
	 */
	public ClaimRequestInfo() {
	}

	/**
	 * 设置属性输入时间
	 * 
	 * @param inputDate
	 *            待设置的属性输入时间的值
	 */
	public void setInputDate(Date inputDate) {
		if (null != inputDate) {
			this.inputDate = inputDate;
		}
	}

	/**
	 * 获取属性输入时间
	 * 
	 * @return 属性输入时间的值
	 */
	public Date getInputDate() {
		return inputDate;
	}

	/**
	 * 设置属性保单号码
	 * 
	 * @param policyno
	 *            待设置的属性保单号码的值
	 */
	public void setPolicyno(String policyno) {
		this.policyno = StringUtils.rightTrim(policyno);
	}

	/**
	 * 获取属性保单号码
	 * 
	 * @return 属性保单号码的值
	 */
	public String getPolicyno() {
		return policyno;
	}

	/**
	 * 设置属性报案号码
	 * 
	 * @param registno
	 *            待设置的属性报案号码的值
	 */
	public void setRegistno(String registno) {
		this.registno = StringUtils.rightTrim(registno);
	}

	/**
	 * 获取属性报案号码
	 * 
	 * @return 属性报案号码的值
	 */
	public String getRegistno() {
		return registno;
	}

	/**
	 * 设置属性立案号码
	 * 
	 * @param claimno
	 *            待设置的属性立案号码的值
	 */
	public void setClaimno(String claimno) {
		this.claimno = StringUtils.rightTrim(claimno);
	}

	/**
	 * 获取属性立案号码
	 * 
	 * @return 属性立案号码的值
	 */
	public String getClaimno() {
		return claimno;
	}

	/**
	 * 设置属性事故日期(yyyy-MM-dd)
	 * 
	 * @param damageStartDate
	 *            待设置的属性事故日期(yyyy-MM-dd)的值
	 */
	public void setDamageStartDate(Date damageStartDate) {
		if (null != damageStartDate) {
			this.damageStartDate = damageStartDate;
		}
	}

	/**
	 * 获取属性事故日期(yyyy-MM-dd)
	 * 
	 * @return 属性事故日期(yyyy-MM-dd)的值
	 */
	public Date getDamageStartDate() {
		return damageStartDate;
	}

	/**
	 * 设置属性事故时分(00:00)
	 * 
	 * @param damageStartHour
	 *            待设置的属性事故时分(00:00)的值
	 */
	public void setDamageStartHour(String damageStartHour) {
		this.damageStartHour = StringUtils.rightTrim(damageStartHour);
	}

	/**
	 * 获取属性事故时分(00:00)
	 * 
	 * @return 属性事故时分(00:00)的值
	 */
	public String getDamageStartHour() {
		return damageStartHour;
	}

	/**
	 * 设置属性事故原因
	 * 
	 * @param damageCode
	 *            待设置的属性事故原因的值
	 */
	public void setDamageCode(String damageCode) {
		this.damageCode = StringUtils.rightTrim(damageCode);
	}

	/**
	 * 获取属性事故原因
	 * 
	 * @return 属性事故原因的值
	 */
	public String getDamageCode() {
		return damageCode;
	}

	/**
	 * 设置属性报案人
	 * 
	 * @param reportName
	 *            待设置的属性报案人的值
	 */
	public void setReportName(String reportName) {
		this.reportName = StringUtils.rightTrim(reportName);
	}

	/**
	 * 获取属性报案人
	 * 
	 * @return 属性报案人的值
	 */
	public String getReportName() {
		return reportName;
	}

	/**
	 * 设置属性报案时间(yyyy-MM-dd)
	 * 
	 * @param reportDate
	 *            待设置的属性报案时间(yyyy-MM-dd)的值
	 */
	public void setReportDate(Date reportDate) {
		if (null != reportDate) {
			this.reportDate = reportDate;
		}
	}

	/**
	 * 获取属性报案时间(yyyy-MM-dd)
	 * 
	 * @return 属性报案时间(yyyy-MM-dd)的值
	 */
	public Date getReportDate() {
		return reportDate;
	}

	/**
	 * 设置属性报案时分(00:00)
	 * 
	 * @param reportHour
	 *            待设置的属性报案时分(00:00)的值
	 */
	public void setReportHour(String reportHour) {
		this.reportHour = StringUtils.rightTrim(reportHour);
	}

	/**
	 * 获取属性报案时分(00:00)
	 * 
	 * @return 属性报案时分(00:00)的值
	 */
	public String getReportHour() {
		return reportHour;
	}

	/**
	 * 设置属性报案方式
	 * 
	 * @param reportType
	 *            待设置的属性报案方式的值
	 */
	public void setReportType(String reportType) {
		this.reportType = StringUtils.rightTrim(reportType);
	}

	/**
	 * 获取属性报案方式
	 * 
	 * @return 属性报案方式的值
	 */
	public String getReportType() {
		return reportType;
	}

	/**
	 * 设置属性联系人
	 * 
	 * @param linkerName
	 *            待设置的属性联系人的值
	 */
	public void setLinkerName(String linkerName) {
		this.linkerName = StringUtils.rightTrim(linkerName);
	}

	/**
	 * 获取属性联系人
	 * 
	 * @return 属性联系人的值
	 */
	public String getLinkerName() {
		return linkerName;
	}

	/**
	 * 设置属性联系电话
	 * 
	 * @param phoneNumber
	 *            待设置的属性联系电话的值
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = StringUtils.rightTrim(phoneNumber);
	}

	/**
	 * 获取属性联系电话
	 * 
	 * @return 属性联系电话的值
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 设置属性联系地址
	 * 
	 * @param linkerAddress
	 *            待设置的属性联系地址的值
	 */
	public void setLinkerAddress(String linkerAddress) {
		this.linkerAddress = StringUtils.rightTrim(linkerAddress);
	}

	/**
	 * 获取属性联系地址
	 * 
	 * @return 属性联系地址的值
	 */
	public String getLinkerAddress() {
		return linkerAddress;
	}

	/**
	 * 设置属性与事故者关系
	 * 
	 * @param clauseType
	 *            待设置的属性与事故者关系的值
	 */
	public void setClauseType(String clauseType) {
		this.clauseType = StringUtils.rightTrim(clauseType);
	}

	/**
	 * 获取属性与事故者关系
	 * 
	 * @return 属性与事故者关系的值
	 */
	public String getClauseType() {
		return clauseType;
	}

	/**
	 * 设置属性事故地点
	 * 
	 * @param damageAddress
	 *            待设置的属性事故地点的值
	 */
	public void setDamageAddress(String damageAddress) {
		this.damageAddress = StringUtils.rightTrim(damageAddress);
	}

	/**
	 * 获取属性事故地点
	 * 
	 * @return 属性事故地点的值
	 */
	public String getDamageAddress() {
		return damageAddress;
	}

	/**
	 * 设置属性事故类型
	 * 
	 * @param damageTypeCode
	 *            待设置的属性事故类型的值
	 */
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
	}

	/**
	 * 获取属性事故类型
	 * 
	 * @return 属性事故类型的值
	 */
	public String getDamageTypeCode() {
		return damageTypeCode;
	}

	/**
	 * 设置属性赔付人次，默认为0
	 * 
	 * @param lossesNumber
	 *            待设置的属性赔付人次，默认为0的值
	 */
	public void setLossesNumber(double lossesNumber) {
		this.lossesNumber = lossesNumber;
	}

	/**
	 * 获取属性赔付人次，默认为0
	 * 
	 * @return 属性赔付人次，默认为0的值
	 */
	public double getLossesNumber() {
		return lossesNumber;
	}

	/**
	 * 设置属性操作人代码
	 * 
	 * @param operatorCode
	 *            待设置的属性操作人代码的值
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = StringUtils.rightTrim(operatorCode);
	}

	/**
	 * 获取属性操作人代码
	 * 
	 * @return 属性操作人代码的值
	 */
	public String getOperatorCode() {
		return operatorCode;
	}

	/**
	 * 设置属性操作人名称
	 * 
	 * @param operatorName
	 *            待设置的属性操作人名称的值
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = StringUtils.rightTrim(operatorName);
	}

	/**
	 * 获取属性操作人名称
	 * 
	 * @return 属性操作人名称的值
	 */
	public String getOperatorName() {
		return operatorName;
	}

	/**
	 * 设置属性理赔处理机构
	 * 
	 * @param makeCom
	 *            待设置的属性理赔处理机构的值
	 */
	public void setMakeCom(String makeCom) {
		this.makeCom = StringUtils.rightTrim(makeCom);
	}

	/**
	 * 获取属性理赔处理机构
	 * 
	 * @return 属性理赔处理机构的值
	 */
	public String getMakeCom() {
		return makeCom;
	}

	/**
	 * 设置属性处理机构名称
	 * 
	 * @param makeComName
	 *            待设置的属性处理机构名称的值
	 */
	public void setMakeComName(String makeComName) {
		this.makeComName = StringUtils.rightTrim(makeComName);
	}

	/**
	 * 获取属性处理机构名称
	 * 
	 * @return 属性处理机构名称的值
	 */
	public String getMakeComName() {
		return makeComName;
	}

	/**
	 * 设置属性报案备忘录
	 * 
	 * @param remark
	 *            待设置的属性报案备忘录的值
	 */
	public void setRemark(String remark) {
		this.remark = StringUtils.rightTrim(remark);
	}

	/**
	 * 获取属性报案备忘录
	 * 
	 * @return 属性报案备忘录的值
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置属性事故经过及事故现状
	 * 
	 * @param context
	 *            待设置的属性事故经过及事故现状的值
	 */
	public void setContext(String context) {
		this.context = StringUtils.rightTrim(context);
	}

	/**
	 * 获取属性事故经过及事故现状
	 * 
	 * @return 属性事故经过及事故现状的值
	 */
	public String getContext() {
		return context;
	}

	/**
	 * 设置属性报损金额CNY
	 * 
	 * @param estimateLoss
	 *            待设置的属性报损金额CNY的值
	 */
	public void setEstimateLoss(double estimateLoss) {
		this.estimateLoss = estimateLoss;
	}

	/**
	 * 获取属性报损金额CNY
	 * 
	 * @return 属性报损金额CNY的值
	 */
	public double getEstimateLoss() {
		return estimateLoss;
	}

	/**
	 * 设置属性调度查勘处理单位
	 * 
	 * @param scheduleObjectId
	 *            待设置的属性调度查勘处理单位的值
	 */
	public void setScheduleObjectId(String scheduleObjectId) {
		this.scheduleObjectId = StringUtils.rightTrim(scheduleObjectId);
	}

	/**
	 * 获取属性调度查勘处理单位
	 * 
	 * @return 属性调度查勘处理单位的值
	 */
	public String getScheduleObjectId() {
		return scheduleObjectId;
	}

	/**
	 * 设置属性查勘地址
	 * 
	 * @param checkSite
	 *            待设置的属性查勘地址的值
	 */
	public void setCheckSite(String checkSite) {
		this.checkSite = StringUtils.rightTrim(checkSite);
	}

	/**
	 * 获取属性查勘地址
	 * 
	 * @return 属性查勘地址的值
	 */
	public String getCheckSite() {
		return checkSite;
	}

	/**
	 * 设置属性查勘要点
	 * 
	 * @param checkInfo
	 *            待设置的属性查勘要点的值
	 */
	public void setCheckInfo(String checkInfo) {
		this.checkInfo = StringUtils.rightTrim(checkInfo);
	}

	/**
	 * 获取属性查勘要点
	 * 
	 * @return 属性查勘要点的值
	 */
	public String getCheckInfo() {
		return checkInfo;
	}

	/**
	 * 设置属性查勘人代码
	 * 
	 * @param nextHandlerCode
	 *            待设置的属性查勘人代码的值
	 */
	public void setNextHandlerCode(String nextHandlerCode) {
		this.nextHandlerCode = StringUtils.rightTrim(nextHandlerCode);
	}

	/**
	 * 获取属性查勘人代码
	 * 
	 * @return 属性查勘人代码的值
	 */
	public String getNextHandlerCode() {
		return nextHandlerCode;
	}

	/**
	 * 设置属性查勘人名称
	 * 
	 * @param nextHandlerName
	 *            待设置的属性查勘人名称的值
	 */
	public void setNextHandlerName(String nextHandlerName) {
		this.nextHandlerName = StringUtils.rightTrim(nextHandlerName);
	}

	/**
	 * 获取属性查勘人名称
	 * 
	 * @return 属性查勘人名称的值
	 */
	public String getNextHandlerName() {
		return nextHandlerName;
	}

	/**
	 * 设置属性查勘人2
	 * 
	 * @param checker2
	 *            待设置的属性查勘人2的值
	 */
	public void setChecker2(String checker2) {
		this.checker2 = StringUtils.rightTrim(checker2);
	}

	/**
	 * 获取属性查勘人2
	 * 
	 * @return 属性查勘人2的值
	 */
	public String getChecker2() {
		return checker2;
	}

	/**
	 * 设置属性查勘类型(查勘L代查D)
	 * 
	 * @param checkType
	 *            待设置的属性查勘类型(查勘L代查D)的值
	 */
	public void setCheckType(String checkType) {
		this.checkType = StringUtils.rightTrim(checkType);
	}

	/**
	 * 获取属性查勘类型(查勘L代查D)
	 * 
	 * @return 属性查勘类型(查勘L代查D)的值
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * 设置属性查勘日期(yyyy-MM-dd)
	 * 
	 * @param checkDate
	 *            待设置的属性查勘日期(yyyy-MM-dd)的值
	 */
	public void setCheckDate(Date checkDate) {
		if (null != checkDate) {
			this.checkDate = checkDate;
		}
	}

	/**
	 * 获取属性查勘日期(yyyy-MM-dd)
	 * 
	 * @return 属性查勘日期(yyyy-MM-dd)的值
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * 设置属性查勘性质(现场1其他9)
	 * 
	 * @param checkNature
	 *            待设置的属性查勘性质(现场1其他9)的值
	 */
	public void setCheckNature(String checkNature) {
		this.checkNature = StringUtils.rightTrim(checkNature);
	}

	/**
	 * 获取属性查勘性质(现场1其他9)
	 * 
	 * @return 属性查勘性质(现场1其他9)的值
	 */
	public String getCheckNature() {
		return checkNature;
	}

	/**
	 * 设置属性查勘预估金额CNY
	 * 
	 * @param checkEstimateLoss
	 *            待设置的属性查勘预估金额CNY的值
	 */
	public void setCheckEstimateLoss(double checkEstimateLoss) {
		this.checkEstimateLoss = checkEstimateLoss;
	}

	/**
	 * 获取属性查勘预估金额CNY
	 * 
	 * @return 属性查勘预估金额CNY的值
	 */
	public double getCheckEstimateLoss() {
		return checkEstimateLoss;
	}

	/**
	 * 设置属性预估费用
	 * 
	 * @param estimateFee
	 *            待设置的属性预估费用的值
	 */
	public void setEstimateFee(double estimateFee) {
		this.estimateFee = estimateFee;
	}

	/**
	 * 获取属性预估费用
	 * 
	 * @return 属性预估费用的值
	 */
	public double getEstimateFee() {
		return estimateFee;
	}

	/**
	 * 设置属性查勘处理单位(内1，外0)
	 * 
	 * @param unitType
	 *            待设置的属性查勘处理单位(内1，外0)的值
	 */
	public void setUnitType(String unitType) {
		this.unitType = StringUtils.rightTrim(unitType);
	}

	/**
	 * 获取属性查勘处理单位(内1，外0)
	 * 
	 * @return 属性查勘处理单位(内1，外0)的值
	 */
	public String getUnitType() {
		return unitType;
	}

	/**
	 * 设置属性查勘备注
	 * 
	 * @param checkRemark
	 *            待设置的属性查勘备注的值
	 */
	public void setCheckRemark(String checkRemark) {
		this.checkRemark = StringUtils.rightTrim(checkRemark);
	}

	/**
	 * 获取属性查勘备注
	 * 
	 * @return 属性查勘备注的值
	 */
	public String getCheckRemark() {
		return checkRemark;
	}

	/**
	 * 设置属性查勘报告
	 * 
	 * @param checkContext
	 *            待设置的属性查勘报告的值
	 */
	public void setCheckContext(String checkContext) {
		this.checkContext = StringUtils.rightTrim(checkContext);
	}

	/**
	 * 获取属性查勘报告
	 * 
	 * @return 属性查勘报告的值
	 */
	public String getCheckContext() {
		return checkContext;
	}

	/**
	 * 设置属性币别（默认CNY
	 * 
	 * @param currency
	 *            待设置的属性币别（默认CNY的值
	 */
	public void setCurrency(String currency) {
		this.currency = StringUtils.rightTrim(currency);
	}

	/**
	 * 获取属性币别（默认CNY
	 * 
	 * @return 属性币别（默认CNY的值
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * 设置属性事故类型名称
	 * 
	 * @param damageTypeName
	 *            待设置的属性事故类型名称的值
	 */
	public void setDamageTypeName(String damageTypeName) {
		this.damageTypeName = StringUtils.rightTrim(damageTypeName);
	}

	/**
	 * 获取属性事故类型名称
	 * 
	 * @return 属性事故类型名称的值
	 */
	public String getDamageTypeName() {
		return damageTypeName;
	}

	/**
	 * 设置属性是否可能追偿(是1，否0)
	 * 
	 * @param replevyFlag
	 *            待设置的属性是否可能追偿(是1，否0)的值
	 */
	public void setReplevyFlag(String replevyFlag) {
		this.replevyFlag = StringUtils.rightTrim(replevyFlag);
	}

	/**
	 * 获取属性是否可能追偿(是1，否0)
	 * 
	 * @return 属性是否可能追偿(是1，否0)的值
	 */
	public String getReplevyFlag() {
		return replevyFlag;
	}

	/**
	 * 设置属性是否其他理赔中介:是1否0
	 * 
	 * @param thirdComFlag
	 *            待设置的属性是否其他理赔中介:是1否0的值
	 */
	public void setThirdComFlag(String thirdComFlag) {
		this.thirdComFlag = StringUtils.rightTrim(thirdComFlag);
	}

	/**
	 * 获取属性是否其他理赔中介:是1否0
	 * 
	 * @return 属性是否其他理赔中介:是1否0的值
	 */
	public String getThirdComFlag() {
		return thirdComFlag;
	}

	/**
	 * 设置属性立案估损金额
	 * 
	 * @param sumClaim
	 *            待设置的属性立案估损金额的值
	 */
	public void setSumClaim(double sumClaim) {
		this.sumClaim = sumClaim;
	}

	/**
	 * 获取属性立案估损金额
	 * 
	 * @return 属性立案估损金额的值
	 */
	public double getSumClaim() {
		return sumClaim;
	}

	/**
	 * 设置属性案件类型代码
	 * 
	 * @param claimType
	 *            待设置的属性案件类型代码的值
	 */
	public void setClaimType(String claimType) {
		this.claimType = StringUtils.rightTrim(claimType);
	}

	/**
	 * 获取属性案件类型代码
	 * 
	 * @return 属性案件类型代码的值
	 */
	public String getClaimType() {
		return claimType;
	}

	/**
	 * 设置属性申请预赔赔案类型选择
	 * 
	 * @param caseType
	 *            待设置的属性申请预赔赔案类型选择的值
	 */
	public void setCaseType(String caseType) {
		this.caseType = StringUtils.rightTrim(caseType);
	}

	/**
	 * 获取属性申请预赔赔案类型选择
	 * 
	 * @return 属性申请预赔赔案类型选择的值
	 */
	public String getCaseType() {
		return caseType;
	}

	/**
	 * 设置属性预赔申请原因
	 * 
	 * @param payAppContext
	 *            待设置的属性预赔申请原因的值
	 */
	public void setPayAppContext(String payAppContext) {
		this.payAppContext = StringUtils.rightTrim(payAppContext);
	}

	/**
	 * 获取属性预赔申请原因
	 * 
	 * @return 属性预赔申请原因的值
	 */
	public String getPayAppContext() {
		return payAppContext;
	}

	/**
	 * 设置属性预赔金额，默认0.00
	 * 
	 * @param sumPrePaid
	 *            待设置的属性预赔金额，默认0.00的值
	 */
	public void setSumPrePaid(double sumPrePaid) {
		this.sumPrePaid = sumPrePaid;
	}

	/**
	 * 获取属性预赔金额，默认0.00
	 * 
	 * @return 属性预赔金额，默认0.00的值
	 */
	public double getSumPrePaid() {
		return sumPrePaid;
	}

	/**
	 * 设置属性预赔报告
	 * 
	 * @param prepayReport
	 *            待设置的属性预赔报告的值
	 */
	public void setPrepayReport(String prepayReport) {
		this.prepayReport = StringUtils.rightTrim(prepayReport);
	}

	/**
	 * 获取属性预赔报告
	 * 
	 * @return 属性预赔报告的值
	 */
	public String getPrepayReport() {
		return prepayReport;
	}

	/**
	 * 设置属性单证案件处理意见
	 * 
	 * @param certifyContext
	 *            待设置的属性单证案件处理意见的值
	 */
	public void setCertifyContext(String certifyContext) {
		this.certifyContext = StringUtils.rightTrim(certifyContext);
	}

	/**
	 * 获取属性单证案件处理意见
	 * 
	 * @return 属性单证案件处理意见的值
	 */
	public String getCertifyContext() {
		return certifyContext;
	}

	/**
	 * 设置属性被保险人开户银行
	 * 
	 * @param bank
	 *            待设置的属性被保险人开户银行的值
	 */
	public void setBank(String bank) {
		this.bank = StringUtils.rightTrim(bank);
	}

	/**
	 * 获取属性被保险人开户银行
	 * 
	 * @return 属性被保险人开户银行的值
	 */
	public String getBank() {
		return bank;
	}

	/**
	 * 设置属性收款人全称
	 * 
	 * @param receiverName
	 *            待设置的属性收款人全称的值
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = StringUtils.rightTrim(receiverName);
	}

	/**
	 * 获取属性收款人全称
	 * 
	 * @return 属性收款人全称的值
	 */
	public String getReceiverName() {
		return receiverName;
	}

	/**
	 * 设置属性开户账号
	 * 
	 * @param account
	 *            待设置的属性开户账号的值
	 */
	public void setAccount(String account) {
		this.account = StringUtils.rightTrim(account);
	}

	/**
	 * 获取属性开户账号
	 * 
	 * @return 属性开户账号的值
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置属性确认开户账号
	 * 
	 * @param accountOK
	 *            待设置的属性确认开户账号的值
	 */
	public void setAccountOK(String accountOK) {
		this.accountOK = StringUtils.rightTrim(accountOK);
	}

	/**
	 * 获取属性确认开户账号
	 * 
	 * @return 属性确认开户账号的值
	 */
	public String getAccountOK() {
		return accountOK;
	}

	/**
	 * 设置属性零赔付原因
	 * 
	 * @param zeroLossType
	 *            待设置的属性零赔付原因的值
	 */
	public void setZeroLossType(String zeroLossType) {
		this.zeroLossType = StringUtils.rightTrim(zeroLossType);
	}

	/**
	 * 获取属性零赔付原因
	 * 
	 * @return 属性零赔付原因的值
	 */
	public String getZeroLossType() {
		return zeroLossType;
	}

	/**
	 * 设置属性费用合计，默认0.00
	 * 
	 * @param sumNoDutyFee
	 *            待设置的属性费用合计，默认0.00的值
	 */
	public void setSumNoDutyFee(double sumNoDutyFee) {
		this.sumNoDutyFee = sumNoDutyFee;
	}

	/**
	 * 获取属性费用合计，默认0.00
	 * 
	 * @return 属性费用合计，默认0.00的值
	 */
	public double getSumNoDutyFee() {
		return sumNoDutyFee;
	}

	/**
	 * 设置属性赔款合计，默认0.00
	 * 
	 * @param prplCompensateSumPaid
	 *            待设置的属性赔款合计，默认0.00的值
	 */
	public void setPrplCompensateSumPaid(double prplCompensateSumPaid) {
		this.prplCompensateSumPaid = prplCompensateSumPaid;
	}

	/**
	 * 获取属性赔款合计，默认0.00
	 * 
	 * @return 属性赔款合计，默认0.00的值
	 */
	public double getPrplCompensateSumPaid() {
		return prplCompensateSumPaid;
	}

	/**
	 * 设置属性已预付赔款，默认0.00
	 * 
	 * @param prplCompensateSumPrePaid
	 *            待设置的属性已预付赔款，默认0.00的值
	 */
	public void setPrplCompensateSumPrePaid(double prplCompensateSumPrePaid) {
		this.prplCompensateSumPrePaid = prplCompensateSumPrePaid;
	}

	/**
	 * 获取属性已预付赔款，默认0.00
	 * 
	 * @return 属性已预付赔款，默认0.00的值
	 */
	public double getPrplCompensateSumPrePaid() {
		return prplCompensateSumPrePaid;
	}

	/**
	 * 设置属性已预付费用，默认0.00
	 * 
	 * @param sumChargePaid
	 *            待设置的属性已预付费用，默认0.00的值
	 */
	public void setSumChargePaid(double sumChargePaid) {
		this.sumChargePaid = sumChargePaid;
	}

	/**
	 * 获取属性已预付费用，默认0.00
	 * 
	 * @return 属性已预付费用，默认0.00的值
	 */
	public double getSumChargePaid() {
		return sumChargePaid;
	}

	/**
	 * 设置属性本次给付金额，默认0.00
	 * 
	 * @param sumThisPaid
	 *            待设置的属性本次给付金额，默认0.00的值
	 */
	public void setSumThisPaid(double sumThisPaid) {
		this.sumThisPaid = sumThisPaid;
	}

	/**
	 * 获取属性本次给付金额，默认0.00
	 * 
	 * @return 属性本次给付金额，默认0.00的值
	 */
	public double getSumThisPaid() {
		return sumThisPaid;
	}

	/**
	 * 设置属性赔款计算过程
	 * 
	 * @param compeContext
	 *            待设置的属性赔款计算过程的值
	 */
	public void setCompeContext(String compeContext) {
		this.compeContext = StringUtils.rightTrim(compeContext);
	}

	/**
	 * 获取属性赔款计算过程
	 * 
	 * @return 属性赔款计算过程的值
	 */
	public String getCompeContext() {
		return compeContext;
	}

	/**
	 * 设置属性审批片语
	 * 
	 * @param notion
	 *            待设置的属性审批片语的值
	 */
	public void setNotion(String notion) {
		this.notion = StringUtils.rightTrim(notion);
	}

	/**
	 * 获取属性审批片语
	 * 
	 * @return 属性审批片语的值
	 */
	public String getNotion() {
		return notion;
	}

	/**
	 * 设置属性核赔签署意见
	 * 
	 * @param handleText
	 *            待设置的属性核赔签署意见的值
	 */
	public void setHandleText(String handleText) {
		this.handleText = StringUtils.rightTrim(handleText);
	}

	/**
	 * 获取属性核赔签署意见
	 * 
	 * @return 属性核赔签署意见的值
	 */
	public String getHandleText() {
		return handleText;
	}
	
	/**
     * 设置属性客户端数据主键
     * @param outId 待设置的属性客户端数据主键的值
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * 获取属性客户端数据主键
     * @return 属性客户端数据主键的值
     */
    public String getOutId(){
        return outId;
    }
	
	/**
	 * 设置属性事故者信息
	 * 
	 * @param accidentPersonInfoDto
	 *            待设置的属性事故者信息的值
	 */
	public void setAccidentPersonInfoDto(AccidentPersonInfoDto[] accidentPersonInfoDto) {
		this.accidentPersonInfoDto = accidentPersonInfoDto;
	}

	/**
	 * 获取属性事故者信息
	 * 
	 * @return 属性事故者信息的值
	 */
	public AccidentPersonInfoDto[] getAccidentPersonInfoDto() {
		return accidentPersonInfoDto;
	}

	/**
	 * 设置属性调度补充说明信息
	 * 
	 * @param schedExtInfoDto
	 *            待设置的属性调度补充说明信息的值
	 */
	public void setSchedExtInfoDto(SchedExtInfoDto[] schedExtInfoDto) {
		this.schedExtInfoDto = schedExtInfoDto;
	}

	/**
	 * 获取属性调度补充说明信息
	 * 
	 * @return 属性调度补充说明信息的值
	 */
	public SchedExtInfoDto[] getSchedExtInfoDto() {
		return schedExtInfoDto;
	}

	/**
	 * 设置属性立案索赔申请人信息
	 * 
	 * @param claimAppDto
	 *            待设置的属性立案索赔申请人信息的值
	 */
	public void setClaimAppDto(ClaimAppDto[] claimAppDto) {
		this.claimAppDto = claimAppDto;
	}

	/**
	 * 获取属性立案索赔申请人信息
	 * 
	 * @return 属性立案索赔申请人信息的值
	 */
	public ClaimAppDto[] getClaimAppDto() {
		return claimAppDto;
	}

	/**
	 * 设置属性立案险别估损金额信
	 * 
	 * @param claimKindDto
	 *            待设置的属性立案险别估损金额信的值
	 */
	public void setClaimKindDto(ClaimKindDto[] claimKindDto) {
		this.claimKindDto = claimKindDto;
	}

	/**
	 * 获取属性立案险别估损金额信
	 * 
	 * @return 属性立案险别估损金额信的值
	 */
	public ClaimKindDto[] getClaimKindDto() {
		return claimKindDto;
	}

	/**
	 * 设置属性费用信息
	 * 
	 * @param prepayFeeInfoDto
	 *            待设置的属性费用信息的值
	 */
	public void setPrepayFeeInfoDto(PrepayFeeInfoDto[] prepayFeeInfoDto) {
		this.prepayFeeInfoDto = prepayFeeInfoDto;
	}

	/**
	 * 获取属性费用信息
	 * 
	 * @return 属性费用信息的值
	 */
	public PrepayFeeInfoDto[] getPrepayFeeInfoDto() {
		return prepayFeeInfoDto;
	}

	/**
	 * 设置属性单证信息
	 * 
	 * @param certifyInfoDto
	 *            待设置的属性单证信息的值
	 */
	public void setCertifyInfoDto(CertifyInfoDto[] certifyInfoDto) {
		this.certifyInfoDto = certifyInfoDto;
	}

	/**
	 * 获取属性单证信息
	 * 
	 * @return 属性单证信息的值
	 */
	public CertifyInfoDto[] getCertifyInfoDto() {
		return certifyInfoDto;
	}

	/**
	 * 设置属性计算书费用信息
	 * 
	 * @param compeFeeInfoDto
	 *            待设置的属性计算书费用信息的值
	 */
	public void setCompeFeeInfoDto(CompeFeeInfoDto[] compeFeeInfoDto) {
		this.compeFeeInfoDto = compeFeeInfoDto;
	}

	/**
	 * 获取属性计算书费用信息
	 * 
	 * @return 属性计算书费用信息的值
	 */
	public CompeFeeInfoDto[] getCompeFeeInfoDto() {
		return compeFeeInfoDto;
	}

	/**
	 * 设置属性计算书赔款费用信息
	 * 
	 * @param compePayFeeInfoDto
	 *            待设置的属性计算书赔款费用信息的值
	 */
	public void setCompePayFeeInfoDto(CompePayFeeInfoDto[] compePayFeeInfoDto) {
		this.compePayFeeInfoDto = compePayFeeInfoDto;
	}

	/**
	 * 获取属性计算书赔款费用信息
	 * 
	 * @return 属性计算书赔款费用信息的值
	 */
	public CompePayFeeInfoDto[] getCompePayFeeInfoDto() {
		return compePayFeeInfoDto;
	}

	/**
	 * 设置属性计算书赔款费用信息
	 * 
	 * @param compePayFeeInfoDto
	 *            待设置的属性计算书赔款费用信息的值
	 */
	public void setCompeInvMainInfo(CompeInvMainInfo[] compeInvMainInfo) {
		this.compeInvMainInfo = compeInvMainInfo;
	}

	/**
	 * 获取属性计算书赔款费用信息
	 * 
	 * @return 属性计算书赔款费用信息的值
	 */
	public CompeInvMainInfo[] getCompeInvMainInfo() {
		return compeInvMainInfo;
	}

	public String getOutRigstNo() {
		return outRigstNo;
	}

	public void setOutRigstNo(String outRigstNo) {
		this.outRigstNo = outRigstNo;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

	public Date getCompeTime() {
		return compeTime;
	}

	public void setCompeTime(Date compeTime) {
		this.compeTime = compeTime;
	}

	public Date getVericTime() {
		return vericTime;
	}

	public void setVericTime(Date vericTime) {
		this.vericTime = vericTime;
	}

	public String getRegistUser() {
		return registUser;
	}

	public void setRegistUser(String registUser) {
		this.registUser = registUser;
	}

	public String getCompeUser() {
		return compeUser;
	}

	public void setCompeUser(String compeUser) {
		this.compeUser = compeUser;
	}

	public String getVericUser() {
		return vericUser;
	}

	public void setVericUser(String vericUser) {
		this.vericUser = vericUser;
	}

	public InjuryPersonInfoDto getInjuryPersonInfoDto() {
		return injuryPersonInfoDto;
	}

	public void setInjuryPersonInfoDto(InjuryPersonInfoDto injuryPersonInfoDto) {
		this.injuryPersonInfoDto = injuryPersonInfoDto;
	}

	public InjuryPersonInfoDto[] getInjuryPersonInfoArrayDto() {
		return injuryPersonInfoArrayDto;
	}

	public void setInjuryPersonInfoArrayDto(
			InjuryPersonInfoDto[] injuryPersonInfoArrayDto) {
		this.injuryPersonInfoArrayDto = injuryPersonInfoArrayDto;
	}

	

}
