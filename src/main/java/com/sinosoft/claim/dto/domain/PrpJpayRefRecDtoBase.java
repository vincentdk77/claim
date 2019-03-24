package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class PrpJpayRefRecDtoBase implements Serializable{
	//TODO  ���Բ�ȫ
    private static final long serialVersionUID = 1L;
    /** ����ҵ������ */
    private String certiType = "";
    /** ���Ա�������/�������� */
    private String certiNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Խ��Ѽƻ���� */
    private int serialNo = 0;
    /** �����ո�ԭ�� */
    private String payRefReason = "";
    /** �����ո����� */
    private int payRefTimes = 0;
    /** ���������� */
    private String claimNo = "";
    /** �������� */
    private String classCode = "";
    /** �������� */
    private String riskCode = "";
    /** ���Ժ�ͬ�� */
    private String contractNo = "";
    /** ����Ͷ���� */
    private String appliCode = "";
    /** ����Ͷ�������� */
    private String appliName = "";
    /** ���Ա������� */
    private String insuredCode = "";
    /** ���Ա��������� */
    private String insuredName = "";
    /** ���������� */
    private DateTime startDate = new DateTime();
    /** �����ձ����� */
    private DateTime endDate = new DateTime();
    /** ����������Ч���� */
    private DateTime validDate = new DateTime();
    /** ���Խɷ����� */
    private int payNo = 0;
    /** ����Ӧ�ձ��� */
    private String currency1 = "";
    /** ����Ӧ��Ӧ����� */
    private double planFee = 0D;
    /** ���Է��ڽɷ����� */
    private DateTime planDate = new DateTime();
    /** ���Թ������� */
    private String comCode = "";
    /** ���Գ������� */
    private String makeCom = "";
    /** ���Դ����˴��� */
    private String agentCode = "";
    /** ����ҵ�������Ա */
    private String handler1Code = "";
    /** ���Ծ����� */
    private String handlerCode = "";
    /** ���Ժ˱�/������ */
    private DateTime underWriteDate = new DateTime();
    /** ������������־ */
    private String coinsFlag = "";
    /** �����������˴��� */
    private String coinsCode = "";
    /** ���������������� */
    private String coinsName = "";
    /** �������������� */
    private String coinsType = "";
    /** ����ʵ�ʲ������� */
    private DateTime operateDate = new DateTime();
    /** ����ǩ���� */
    private String operatorCode = "";
    /** ����ǩ������ */
    private String operateUnit = "";
    /** �����ո����� */
    private String currency2 = "";
    /** �����ո����� */
    private double exchangeRate = 0D;
    /** �����ո���� */
    private double payRefFee = 0D;
    /** ���Ե�֤���� */
    private String visaCode = "";
    /** ���Ե�֤���� */
    private String visaName = "";
    /** ���Է�Ʊ�� */
    private String visaSerialNo = "";
    /** ���Է�Ʊ��ӡ���� */
    private DateTime printDate = new DateTime();
    /** ���Է�Ʊ��ӡ�� */
    private String printerCode = "";
    /** ���Է�Ʊ������ */
    private String visaHandler = "";
    /** ���Խ�/����� */
    private String payRefName = "";
    /** ���Խ�/�����֤������ */
    private String identifyType = "";
    /** ���Խ�/�����֤������ */
    private String identifyNumber = "";
    /** ���Է�Ʊ/֧������ע */
    private String remark = "";
    /** ���Դ����/֧������ */
    private String payRefNo = "";
    /** �����ո����� */
    private DateTime payRefDate = new DateTime();
    /** ����Ԥ����־ */
    private String flag = "";
    /** ����ҵ������ */
    private String businessNature = "";
    /** ����ҵ���־ */
    private String othFlag = "";
    /** ���Ը��˴��������Ѵ���˰�� */
    private double taxFee = 0D;
    /** ���Խ�ǿ�ճ����Ŵ����� */
    private String carNatureCode = "";
    /** ���Խ�ǿ�վŴ���ʹ������ */
    private String useNatureCode = "";
    /** ���Խ�ǿ�վŴ��೵������ */
    private double carProperty = 0D;
    /** ����Ӫҵ������˰�� */
    private double businessFee = 0D;
    /** ���Ը�������˰�� */
    private double personalFee = 0D;
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpJpayRefRecDtoBase����
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