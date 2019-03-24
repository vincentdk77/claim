package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class PrpJpayRefRecDtoBase implements Serializable{
	//TODO  属性不全
    private static final long serialVersionUID = 1L;
    /** 属性业务类型 */
    private String certiType = "";
    /** 属性保单号码/批单号码 */
    private String certiNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性交费计划序号 */
    private int serialNo = 0;
    /** 属性收付原因 */
    private String payRefReason = "";
    /** 属性收付次数 */
    private int payRefTimes = 0;
    /** 属性立案号 */
    private String claimNo = "";
    /** 属性险类 */
    private String classCode = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性合同号 */
    private String contractNo = "";
    /** 属性投保人 */
    private String appliCode = "";
    /** 属性投保人名称 */
    private String appliName = "";
    /** 属性被保险人 */
    private String insuredCode = "";
    /** 属性被保人名称 */
    private String insuredName = "";
    /** 属性起保日期 */
    private DateTime startDate = new DateTime();
    /** 属性终保日期 */
    private DateTime endDate = new DateTime();
    /** 属性批单生效日期 */
    private DateTime validDate = new DateTime();
    /** 属性缴费期数 */
    private int payNo = 0;
    /** 属性应收币种 */
    private String currency1 = "";
    /** 属性应收应付金额 */
    private double planFee = 0D;
    /** 属性分期缴费日期 */
    private DateTime planDate = new DateTime();
    /** 属性归属机构 */
    private String comCode = "";
    /** 属性出单机构 */
    private String makeCom = "";
    /** 属性代理人代码 */
    private String agentCode = "";
    /** 属性业务归属人员 */
    private String handler1Code = "";
    /** 属性经办人 */
    private String handlerCode = "";
    /** 属性核保/赔日期 */
    private DateTime underWriteDate = new DateTime();
    /** 属性联共保标志 */
    private String coinsFlag = "";
    /** 属性联共保人代码 */
    private String coinsCode = "";
    /** 属性联共保人名称 */
    private String coinsName = "";
    /** 属性联共保类型 */
    private String coinsType = "";
    /** 属性实际操作日期 */
    private DateTime operateDate = new DateTime();
    /** 属性签发人 */
    private String operatorCode = "";
    /** 属性签发部门 */
    private String operateUnit = "";
    /** 属性收付币种 */
    private String currency2 = "";
    /** 属性收付汇率 */
    private double exchangeRate = 0D;
    /** 属性收付金额 */
    private double payRefFee = 0D;
    /** 属性单证类型 */
    private String visaCode = "";
    /** 属性单证名称 */
    private String visaName = "";
    /** 属性发票号 */
    private String visaSerialNo = "";
    /** 属性发票打印日期 */
    private DateTime printDate = new DateTime();
    /** 属性发票打印人 */
    private String printerCode = "";
    /** 属性发票经手人 */
    private String visaHandler = "";
    /** 属性交/领款人 */
    private String payRefName = "";
    /** 属性交/领款人证件类型 */
    private String identifyType = "";
    /** 属性交/领款人证件号码 */
    private String identifyNumber = "";
    /** 属性发票/支付单备注 */
    private String remark = "";
    /** 属性打包号/支付单号 */
    private String payRefNo = "";
    /** 属性收付日期 */
    private DateTime payRefDate = new DateTime();
    /** 属性预留标志 */
    private String flag = "";
    /** 属性业务渠道 */
    private String businessNature = "";
    /** 属性业务标志 */
    private String othFlag = "";
    /** 属性个人代理手续费代扣税金 */
    private double taxFee = 0D;
    /** 属性交强险车辆九大类类 */
    private String carNatureCode = "";
    /** 属性交强险九大类使用性质 */
    private String useNatureCode = "";
    /** 属性交强险九大类车的属性 */
    private double carProperty = 0D;
    /** 属性营业及附加税金 */
    private double businessFee = 0D;
    /** 属性个人所得税金 */
    private double personalFee = 0D;
    /**
     *  默认构造方法,构造一个默认的PrpJpayRefRecDtoBase对象
     */
    public PrpJpayRefRecDtoBase(){
    }
	public String getCertiType() {
		return certiType;
	}
	public void setCertiType(String certiType) {
		this.certiType = certiType;
	}
	public String getCertiNo() {
		return certiNo;
	}
	public void setCertiNo(String certiNo) {
		this.certiNo = certiNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getPayRefReason() {
		return payRefReason;
	}
	public void setPayRefReason(String payRefReason) {
		this.payRefReason = payRefReason;
	}
	public int getPayRefTimes() {
		return payRefTimes;
	}
	public void setPayRefTimes(int payRefTimes) {
		this.payRefTimes = payRefTimes;
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getRiskCode() {
		return riskCode;
	}
	public void setRiskCode(String riskCode) {
		this.riskCode = riskCode;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getAppliCode() {
		return appliCode;
	}
	public void setAppliCode(String appliCode) {
		this.appliCode = appliCode;
	}
	public String getAppliName() {
		return appliName;
	}
	public void setAppliName(String appliName) {
		this.appliName = appliName;
	}
	public String getInsuredCode() {
		return insuredCode;
	}
	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public DateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	public DateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}
	public DateTime getValidDate() {
		return validDate;
	}
	public void setValidDate(DateTime validDate) {
		this.validDate = validDate;
	}
	public int getPayNo() {
		return payNo;
	}
	public void setPayNo(int payNo) {
		this.payNo = payNo;
	}
	public String getCurrency1() {
		return currency1;
	}
	public void setCurrency1(String currency1) {
		this.currency1 = currency1;
	}
	public double getPlanFee() {
		return planFee;
	}
	public void setPlanFee(double planFee) {
		this.planFee = planFee;
	}
	public DateTime getPlanDate() {
		return planDate;
	}
	public void setPlanDate(DateTime planDate) {
		this.planDate = planDate;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getMakeCom() {
		return makeCom;
	}
	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getHandler1Code() {
		return handler1Code;
	}
	public void setHandler1Code(String handler1Code) {
		this.handler1Code = handler1Code;
	}
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	public DateTime getUnderWriteDate() {
		return underWriteDate;
	}
	public void setUnderWriteDate(DateTime underWriteDate) {
		this.underWriteDate = underWriteDate;
	}
	public String getCoinsFlag() {
		return coinsFlag;
	}
	public void setCoinsFlag(String coinsFlag) {
		this.coinsFlag = coinsFlag;
	}
	public String getCoinsCode() {
		return coinsCode;
	}
	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}
	public String getCoinsName() {
		return coinsName;
	}
	public void setCoinsName(String coinsName) {
		this.coinsName = coinsName;
	}
	public String getCoinsType() {
		return coinsType;
	}
	public void setCoinsType(String coinsType) {
		this.coinsType = coinsType;
	}
	public DateTime getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(DateTime operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperatorCode() {
		return operatorCode;
	}
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperateUnit() {
		return operateUnit;
	}
	public void setOperateUnit(String operateUnit) {
		this.operateUnit = operateUnit;
	}
	public String getCurrency2() {
		return currency2;
	}
	public void setCurrency2(String currency2) {
		this.currency2 = currency2;
	}
	public double getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public double getPayRefFee() {
		return payRefFee;
	}
	public void setPayRefFee(double payRefFee) {
		this.payRefFee = payRefFee;
	}
	public String getVisaCode() {
		return visaCode;
	}
	public void setVisaCode(String visaCode) {
		this.visaCode = visaCode;
	}
	public String getVisaName() {
		return visaName;
	}
	public void setVisaName(String visaName) {
		this.visaName = visaName;
	}
	public String getVisaSerialNo() {
		return visaSerialNo;
	}
	public void setVisaSerialNo(String visaSerialNo) {
		this.visaSerialNo = visaSerialNo;
	}
	public DateTime getPrintDate() {
		return printDate;
	}
	public void setPrintDate(DateTime printDate) {
		this.printDate = printDate;
	}
	public String getPrinterCode() {
		return printerCode;
	}
	public void setPrinterCode(String printerCode) {
		this.printerCode = printerCode;
	}
	public String getVisaHandler() {
		return visaHandler;
	}
	public void setVisaHandler(String visaHandler) {
		this.visaHandler = visaHandler;
	}
	public String getPayRefName() {
		return payRefName;
	}
	public void setPayRefName(String payRefName) {
		this.payRefName = payRefName;
	}
	public String getIdentifyType() {
		return identifyType;
	}
	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPayRefNo() {
		return payRefNo;
	}
	public void setPayRefNo(String payRefNo) {
		this.payRefNo = payRefNo;
	}
	public DateTime getPayRefDate() {
		return payRefDate;
	}
	public void setPayRefDate(DateTime payRefDate) {
		this.payRefDate = payRefDate;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getBusinessNature() {
		return businessNature;
	}
	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}
	public String getOthFlag() {
		return othFlag;
	}
	public void setOthFlag(String othFlag) {
		this.othFlag = othFlag;
	}
	public double getTaxFee() {
		return taxFee;
	}
	public void setTaxFee(double taxFee) {
		this.taxFee = taxFee;
	}
	public String getCarNatureCode() {
		return carNatureCode;
	}
	public void setCarNatureCode(String carNatureCode) {
		this.carNatureCode = carNatureCode;
	}
	public String getUseNatureCode() {
		return useNatureCode;
	}
	public void setUseNatureCode(String useNatureCode) {
		this.useNatureCode = useNatureCode;
	}
	public double getCarProperty() {
		return carProperty;
	}
	public void setCarProperty(double carProperty) {
		this.carProperty = carProperty;
	}
	public double getBusinessFee() {
		return businessFee;
	}
	public void setBusinessFee(double businessFee) {
		this.businessFee = businessFee;
	}
	public double getPersonalFee() {
		return personalFee;
	}
	public void setPersonalFee(double personalFee) {
		this.personalFee = personalFee;
	}
    
}