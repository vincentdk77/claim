package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpCmainLoan的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCmainLoanDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性PolicyNo */
    private String policyNo = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性RiskKind */
    private String riskKind = "";
    /** 属性GuaranteeType */
    private String guaranteeType = "";
    /** 属性GuaranteeName */
    private String guaranteeName = "";
    /** 属性MortgageNo */
    private String mortgageNo = "";
    /** 属性WarrantorCode */
    private String warrantorCode = "";
    /** 属性WarrantorName */
    private String warrantorName = "";
    /** 属性LoanNo1 */
    private String loanNo1 = "";
    /** 属性LoanNo2 */
    private String loanNo2 = "";
    /** 属性InstallmentFlag */
    private String installmentFlag = "";
    /** 属性DeliverDate */
    private DateTime deliverDate = new DateTime();
    /** 属性LoanContractNo */
    private String loanContractNo = "";
    /** 属性LoanWay */
    private String loanWay = "";
    /** 属性LoanNature */
    private String loanNature = "";
    /** 属性LoanBankCode */
    private String loanBankCode = "";
    /** 属性LoanBankName */
    private String loanBankName = "";
    /** 属性LoanUsage */
    private String loanUsage = "";
    /** 属性LoanStartDate */
    private DateTime loanStartDate = new DateTime();
    /** 属性LoanEndDate */
    private DateTime loanEndDate = new DateTime();
    /** 属性LoanYear */
    private int loanYear = 0;
    /** 属性PlanAmount */
    private double planAmount = 0D;
    /** 属性FirstRate */
    private double firstRate = 0D;
    /** 属性FirstPaid */
    private double firstPaid = 0D;
    /** 属性Currency */
    private String currency = "";
    /** 属性LoanAmount */
    private double loanAmount = 0D;
    /** 属性LoanRate */
    private double loanRate = 0D;
    /** 属性RepaidType */
    private String repaidType = "";
    /** 属性PaidTimes */
    private long paidTimes = 0L;
    /** 属性PerRepaidAmount */
    private double perRepaidAmount = 0D;
    /** 属性Remark */
    private String remark = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCmainLoanDtoBase对象
     */
    public PrpCmainLoanDtoBase(){
    }

    /**
     * 设置属性PolicyNo
     * @param policyNo 待设置的属性PolicyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性PolicyNo
     * @return 属性PolicyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性RiskKind
     * @param riskKind 待设置的属性RiskKind的值
     */
    public void setRiskKind(String riskKind){
        this.riskKind = StringUtils.rightTrim(riskKind);
    }

    /**
     * 获取属性RiskKind
     * @return 属性RiskKind的值
     */
    public String getRiskKind(){
        return riskKind;
    }

    /**
     * 设置属性GuaranteeType
     * @param guaranteeType 待设置的属性GuaranteeType的值
     */
    public void setGuaranteeType(String guaranteeType){
        this.guaranteeType = StringUtils.rightTrim(guaranteeType);
    }

    /**
     * 获取属性GuaranteeType
     * @return 属性GuaranteeType的值
     */
    public String getGuaranteeType(){
        return guaranteeType;
    }

    /**
     * 设置属性GuaranteeName
     * @param guaranteeName 待设置的属性GuaranteeName的值
     */
    public void setGuaranteeName(String guaranteeName){
        this.guaranteeName = StringUtils.rightTrim(guaranteeName);
    }

    /**
     * 获取属性GuaranteeName
     * @return 属性GuaranteeName的值
     */
    public String getGuaranteeName(){
        return guaranteeName;
    }

    /**
     * 设置属性MortgageNo
     * @param mortgageNo 待设置的属性MortgageNo的值
     */
    public void setMortgageNo(String mortgageNo){
        this.mortgageNo = StringUtils.rightTrim(mortgageNo);
    }

    /**
     * 获取属性MortgageNo
     * @return 属性MortgageNo的值
     */
    public String getMortgageNo(){
        return mortgageNo;
    }

    /**
     * 设置属性WarrantorCode
     * @param warrantorCode 待设置的属性WarrantorCode的值
     */
    public void setWarrantorCode(String warrantorCode){
        this.warrantorCode = StringUtils.rightTrim(warrantorCode);
    }

    /**
     * 获取属性WarrantorCode
     * @return 属性WarrantorCode的值
     */
    public String getWarrantorCode(){
        return warrantorCode;
    }

    /**
     * 设置属性WarrantorName
     * @param warrantorName 待设置的属性WarrantorName的值
     */
    public void setWarrantorName(String warrantorName){
        this.warrantorName = StringUtils.rightTrim(warrantorName);
    }

    /**
     * 获取属性WarrantorName
     * @return 属性WarrantorName的值
     */
    public String getWarrantorName(){
        return warrantorName;
    }

    /**
     * 设置属性LoanNo1
     * @param loanNo1 待设置的属性LoanNo1的值
     */
    public void setLoanNo1(String loanNo1){
        this.loanNo1 = StringUtils.rightTrim(loanNo1);
    }

    /**
     * 获取属性LoanNo1
     * @return 属性LoanNo1的值
     */
    public String getLoanNo1(){
        return loanNo1;
    }

    /**
     * 设置属性LoanNo2
     * @param loanNo2 待设置的属性LoanNo2的值
     */
    public void setLoanNo2(String loanNo2){
        this.loanNo2 = StringUtils.rightTrim(loanNo2);
    }

    /**
     * 获取属性LoanNo2
     * @return 属性LoanNo2的值
     */
    public String getLoanNo2(){
        return loanNo2;
    }

    /**
     * 设置属性InstallmentFlag
     * @param installmentFlag 待设置的属性InstallmentFlag的值
     */
    public void setInstallmentFlag(String installmentFlag){
        this.installmentFlag = StringUtils.rightTrim(installmentFlag);
    }

    /**
     * 获取属性InstallmentFlag
     * @return 属性InstallmentFlag的值
     */
    public String getInstallmentFlag(){
        return installmentFlag;
    }

    /**
     * 设置属性DeliverDate
     * @param deliverDate 待设置的属性DeliverDate的值
     */
    public void setDeliverDate(DateTime deliverDate){
        this.deliverDate = deliverDate;
    }

    /**
     * 获取属性DeliverDate
     * @return 属性DeliverDate的值
     */
    public DateTime getDeliverDate(){
        return deliverDate;
    }

    /**
     * 设置属性LoanContractNo
     * @param loanContractNo 待设置的属性LoanContractNo的值
     */
    public void setLoanContractNo(String loanContractNo){
        this.loanContractNo = StringUtils.rightTrim(loanContractNo);
    }

    /**
     * 获取属性LoanContractNo
     * @return 属性LoanContractNo的值
     */
    public String getLoanContractNo(){
        return loanContractNo;
    }

    /**
     * 设置属性LoanWay
     * @param loanWay 待设置的属性LoanWay的值
     */
    public void setLoanWay(String loanWay){
        this.loanWay = StringUtils.rightTrim(loanWay);
    }

    /**
     * 获取属性LoanWay
     * @return 属性LoanWay的值
     */
    public String getLoanWay(){
        return loanWay;
    }

    /**
     * 设置属性LoanNature
     * @param loanNature 待设置的属性LoanNature的值
     */
    public void setLoanNature(String loanNature){
        this.loanNature = StringUtils.rightTrim(loanNature);
    }

    /**
     * 获取属性LoanNature
     * @return 属性LoanNature的值
     */
    public String getLoanNature(){
        return loanNature;
    }

    /**
     * 设置属性LoanBankCode
     * @param loanBankCode 待设置的属性LoanBankCode的值
     */
    public void setLoanBankCode(String loanBankCode){
        this.loanBankCode = StringUtils.rightTrim(loanBankCode);
    }

    /**
     * 获取属性LoanBankCode
     * @return 属性LoanBankCode的值
     */
    public String getLoanBankCode(){
        return loanBankCode;
    }

    /**
     * 设置属性LoanBankName
     * @param loanBankName 待设置的属性LoanBankName的值
     */
    public void setLoanBankName(String loanBankName){
        this.loanBankName = StringUtils.rightTrim(loanBankName);
    }

    /**
     * 获取属性LoanBankName
     * @return 属性LoanBankName的值
     */
    public String getLoanBankName(){
        return loanBankName;
    }

    /**
     * 设置属性LoanUsage
     * @param loanUsage 待设置的属性LoanUsage的值
     */
    public void setLoanUsage(String loanUsage){
        this.loanUsage = StringUtils.rightTrim(loanUsage);
    }

    /**
     * 获取属性LoanUsage
     * @return 属性LoanUsage的值
     */
    public String getLoanUsage(){
        return loanUsage;
    }

    /**
     * 设置属性LoanStartDate
     * @param loanStartDate 待设置的属性LoanStartDate的值
     */
    public void setLoanStartDate(DateTime loanStartDate){
        this.loanStartDate = loanStartDate;
    }

    /**
     * 获取属性LoanStartDate
     * @return 属性LoanStartDate的值
     */
    public DateTime getLoanStartDate(){
        return loanStartDate;
    }

    /**
     * 设置属性LoanEndDate
     * @param loanEndDate 待设置的属性LoanEndDate的值
     */
    public void setLoanEndDate(DateTime loanEndDate){
        this.loanEndDate = loanEndDate;
    }

    /**
     * 获取属性LoanEndDate
     * @return 属性LoanEndDate的值
     */
    public DateTime getLoanEndDate(){
        return loanEndDate;
    }

    /**
     * 设置属性LoanYear
     * @param loanYear 待设置的属性LoanYear的值
     */
    public void setLoanYear(int loanYear){
        this.loanYear = loanYear;
    }

    /**
     * 获取属性LoanYear
     * @return 属性LoanYear的值
     */
    public int getLoanYear(){
        return loanYear;
    }

    /**
     * 设置属性PlanAmount
     * @param planAmount 待设置的属性PlanAmount的值
     */
    public void setPlanAmount(double planAmount){
        this.planAmount = planAmount;
    }

    /**
     * 获取属性PlanAmount
     * @return 属性PlanAmount的值
     */
    public double getPlanAmount(){
        return planAmount;
    }

    /**
     * 设置属性FirstRate
     * @param firstRate 待设置的属性FirstRate的值
     */
    public void setFirstRate(double firstRate){
        this.firstRate = firstRate;
    }

    /**
     * 获取属性FirstRate
     * @return 属性FirstRate的值
     */
    public double getFirstRate(){
        return firstRate;
    }

    /**
     * 设置属性FirstPaid
     * @param firstPaid 待设置的属性FirstPaid的值
     */
    public void setFirstPaid(double firstPaid){
        this.firstPaid = firstPaid;
    }

    /**
     * 获取属性FirstPaid
     * @return 属性FirstPaid的值
     */
    public double getFirstPaid(){
        return firstPaid;
    }

    /**
     * 设置属性Currency
     * @param currency 待设置的属性Currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性Currency
     * @return 属性Currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性LoanAmount
     * @param loanAmount 待设置的属性LoanAmount的值
     */
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    /**
     * 获取属性LoanAmount
     * @return 属性LoanAmount的值
     */
    public double getLoanAmount(){
        return loanAmount;
    }

    /**
     * 设置属性LoanRate
     * @param loanRate 待设置的属性LoanRate的值
     */
    public void setLoanRate(double loanRate){
        this.loanRate = loanRate;
    }

    /**
     * 获取属性LoanRate
     * @return 属性LoanRate的值
     */
    public double getLoanRate(){
        return loanRate;
    }

    /**
     * 设置属性RepaidType
     * @param repaidType 待设置的属性RepaidType的值
     */
    public void setRepaidType(String repaidType){
        this.repaidType = StringUtils.rightTrim(repaidType);
    }

    /**
     * 获取属性RepaidType
     * @return 属性RepaidType的值
     */
    public String getRepaidType(){
        return repaidType;
    }

    /**
     * 设置属性PaidTimes
     * @param paidTimes 待设置的属性PaidTimes的值
     */
    public void setPaidTimes(long paidTimes){
        this.paidTimes = paidTimes;
    }

    /**
     * 获取属性PaidTimes
     * @return 属性PaidTimes的值
     */
    public long getPaidTimes(){
        return paidTimes;
    }

    /**
     * 设置属性PerRepaidAmount
     * @param perRepaidAmount 待设置的属性PerRepaidAmount的值
     */
    public void setPerRepaidAmount(double perRepaidAmount){
        this.perRepaidAmount = perRepaidAmount;
    }

    /**
     * 获取属性PerRepaidAmount
     * @return 属性PerRepaidAmount的值
     */
    public double getPerRepaidAmount(){
        return perRepaidAmount;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
