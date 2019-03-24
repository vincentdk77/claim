package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpCmainLoan�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCmainLoanDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����PolicyNo */
    private String policyNo = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����RiskKind */
    private String riskKind = "";
    /** ����GuaranteeType */
    private String guaranteeType = "";
    /** ����GuaranteeName */
    private String guaranteeName = "";
    /** ����MortgageNo */
    private String mortgageNo = "";
    /** ����WarrantorCode */
    private String warrantorCode = "";
    /** ����WarrantorName */
    private String warrantorName = "";
    /** ����LoanNo1 */
    private String loanNo1 = "";
    /** ����LoanNo2 */
    private String loanNo2 = "";
    /** ����InstallmentFlag */
    private String installmentFlag = "";
    /** ����DeliverDate */
    private DateTime deliverDate = new DateTime();
    /** ����LoanContractNo */
    private String loanContractNo = "";
    /** ����LoanWay */
    private String loanWay = "";
    /** ����LoanNature */
    private String loanNature = "";
    /** ����LoanBankCode */
    private String loanBankCode = "";
    /** ����LoanBankName */
    private String loanBankName = "";
    /** ����LoanUsage */
    private String loanUsage = "";
    /** ����LoanStartDate */
    private DateTime loanStartDate = new DateTime();
    /** ����LoanEndDate */
    private DateTime loanEndDate = new DateTime();
    /** ����LoanYear */
    private int loanYear = 0;
    /** ����PlanAmount */
    private double planAmount = 0D;
    /** ����FirstRate */
    private double firstRate = 0D;
    /** ����FirstPaid */
    private double firstPaid = 0D;
    /** ����Currency */
    private String currency = "";
    /** ����LoanAmount */
    private double loanAmount = 0D;
    /** ����LoanRate */
    private double loanRate = 0D;
    /** ����RepaidType */
    private String repaidType = "";
    /** ����PaidTimes */
    private long paidTimes = 0L;
    /** ����PerRepaidAmount */
    private double perRepaidAmount = 0D;
    /** ����Remark */
    private String remark = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCmainLoanDtoBase����
     */
    public PrpCmainLoanDtoBase(){
    }

    /**
     * ��������PolicyNo
     * @param policyNo �����õ�����PolicyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����PolicyNo
     * @return ����PolicyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������RiskKind
     * @param riskKind �����õ�����RiskKind��ֵ
     */
    public void setRiskKind(String riskKind){
        this.riskKind = StringUtils.rightTrim(riskKind);
    }

    /**
     * ��ȡ����RiskKind
     * @return ����RiskKind��ֵ
     */
    public String getRiskKind(){
        return riskKind;
    }

    /**
     * ��������GuaranteeType
     * @param guaranteeType �����õ�����GuaranteeType��ֵ
     */
    public void setGuaranteeType(String guaranteeType){
        this.guaranteeType = StringUtils.rightTrim(guaranteeType);
    }

    /**
     * ��ȡ����GuaranteeType
     * @return ����GuaranteeType��ֵ
     */
    public String getGuaranteeType(){
        return guaranteeType;
    }

    /**
     * ��������GuaranteeName
     * @param guaranteeName �����õ�����GuaranteeName��ֵ
     */
    public void setGuaranteeName(String guaranteeName){
        this.guaranteeName = StringUtils.rightTrim(guaranteeName);
    }

    /**
     * ��ȡ����GuaranteeName
     * @return ����GuaranteeName��ֵ
     */
    public String getGuaranteeName(){
        return guaranteeName;
    }

    /**
     * ��������MortgageNo
     * @param mortgageNo �����õ�����MortgageNo��ֵ
     */
    public void setMortgageNo(String mortgageNo){
        this.mortgageNo = StringUtils.rightTrim(mortgageNo);
    }

    /**
     * ��ȡ����MortgageNo
     * @return ����MortgageNo��ֵ
     */
    public String getMortgageNo(){
        return mortgageNo;
    }

    /**
     * ��������WarrantorCode
     * @param warrantorCode �����õ�����WarrantorCode��ֵ
     */
    public void setWarrantorCode(String warrantorCode){
        this.warrantorCode = StringUtils.rightTrim(warrantorCode);
    }

    /**
     * ��ȡ����WarrantorCode
     * @return ����WarrantorCode��ֵ
     */
    public String getWarrantorCode(){
        return warrantorCode;
    }

    /**
     * ��������WarrantorName
     * @param warrantorName �����õ�����WarrantorName��ֵ
     */
    public void setWarrantorName(String warrantorName){
        this.warrantorName = StringUtils.rightTrim(warrantorName);
    }

    /**
     * ��ȡ����WarrantorName
     * @return ����WarrantorName��ֵ
     */
    public String getWarrantorName(){
        return warrantorName;
    }

    /**
     * ��������LoanNo1
     * @param loanNo1 �����õ�����LoanNo1��ֵ
     */
    public void setLoanNo1(String loanNo1){
        this.loanNo1 = StringUtils.rightTrim(loanNo1);
    }

    /**
     * ��ȡ����LoanNo1
     * @return ����LoanNo1��ֵ
     */
    public String getLoanNo1(){
        return loanNo1;
    }

    /**
     * ��������LoanNo2
     * @param loanNo2 �����õ�����LoanNo2��ֵ
     */
    public void setLoanNo2(String loanNo2){
        this.loanNo2 = StringUtils.rightTrim(loanNo2);
    }

    /**
     * ��ȡ����LoanNo2
     * @return ����LoanNo2��ֵ
     */
    public String getLoanNo2(){
        return loanNo2;
    }

    /**
     * ��������InstallmentFlag
     * @param installmentFlag �����õ�����InstallmentFlag��ֵ
     */
    public void setInstallmentFlag(String installmentFlag){
        this.installmentFlag = StringUtils.rightTrim(installmentFlag);
    }

    /**
     * ��ȡ����InstallmentFlag
     * @return ����InstallmentFlag��ֵ
     */
    public String getInstallmentFlag(){
        return installmentFlag;
    }

    /**
     * ��������DeliverDate
     * @param deliverDate �����õ�����DeliverDate��ֵ
     */
    public void setDeliverDate(DateTime deliverDate){
        this.deliverDate = deliverDate;
    }

    /**
     * ��ȡ����DeliverDate
     * @return ����DeliverDate��ֵ
     */
    public DateTime getDeliverDate(){
        return deliverDate;
    }

    /**
     * ��������LoanContractNo
     * @param loanContractNo �����õ�����LoanContractNo��ֵ
     */
    public void setLoanContractNo(String loanContractNo){
        this.loanContractNo = StringUtils.rightTrim(loanContractNo);
    }

    /**
     * ��ȡ����LoanContractNo
     * @return ����LoanContractNo��ֵ
     */
    public String getLoanContractNo(){
        return loanContractNo;
    }

    /**
     * ��������LoanWay
     * @param loanWay �����õ�����LoanWay��ֵ
     */
    public void setLoanWay(String loanWay){
        this.loanWay = StringUtils.rightTrim(loanWay);
    }

    /**
     * ��ȡ����LoanWay
     * @return ����LoanWay��ֵ
     */
    public String getLoanWay(){
        return loanWay;
    }

    /**
     * ��������LoanNature
     * @param loanNature �����õ�����LoanNature��ֵ
     */
    public void setLoanNature(String loanNature){
        this.loanNature = StringUtils.rightTrim(loanNature);
    }

    /**
     * ��ȡ����LoanNature
     * @return ����LoanNature��ֵ
     */
    public String getLoanNature(){
        return loanNature;
    }

    /**
     * ��������LoanBankCode
     * @param loanBankCode �����õ�����LoanBankCode��ֵ
     */
    public void setLoanBankCode(String loanBankCode){
        this.loanBankCode = StringUtils.rightTrim(loanBankCode);
    }

    /**
     * ��ȡ����LoanBankCode
     * @return ����LoanBankCode��ֵ
     */
    public String getLoanBankCode(){
        return loanBankCode;
    }

    /**
     * ��������LoanBankName
     * @param loanBankName �����õ�����LoanBankName��ֵ
     */
    public void setLoanBankName(String loanBankName){
        this.loanBankName = StringUtils.rightTrim(loanBankName);
    }

    /**
     * ��ȡ����LoanBankName
     * @return ����LoanBankName��ֵ
     */
    public String getLoanBankName(){
        return loanBankName;
    }

    /**
     * ��������LoanUsage
     * @param loanUsage �����õ�����LoanUsage��ֵ
     */
    public void setLoanUsage(String loanUsage){
        this.loanUsage = StringUtils.rightTrim(loanUsage);
    }

    /**
     * ��ȡ����LoanUsage
     * @return ����LoanUsage��ֵ
     */
    public String getLoanUsage(){
        return loanUsage;
    }

    /**
     * ��������LoanStartDate
     * @param loanStartDate �����õ�����LoanStartDate��ֵ
     */
    public void setLoanStartDate(DateTime loanStartDate){
        this.loanStartDate = loanStartDate;
    }

    /**
     * ��ȡ����LoanStartDate
     * @return ����LoanStartDate��ֵ
     */
    public DateTime getLoanStartDate(){
        return loanStartDate;
    }

    /**
     * ��������LoanEndDate
     * @param loanEndDate �����õ�����LoanEndDate��ֵ
     */
    public void setLoanEndDate(DateTime loanEndDate){
        this.loanEndDate = loanEndDate;
    }

    /**
     * ��ȡ����LoanEndDate
     * @return ����LoanEndDate��ֵ
     */
    public DateTime getLoanEndDate(){
        return loanEndDate;
    }

    /**
     * ��������LoanYear
     * @param loanYear �����õ�����LoanYear��ֵ
     */
    public void setLoanYear(int loanYear){
        this.loanYear = loanYear;
    }

    /**
     * ��ȡ����LoanYear
     * @return ����LoanYear��ֵ
     */
    public int getLoanYear(){
        return loanYear;
    }

    /**
     * ��������PlanAmount
     * @param planAmount �����õ�����PlanAmount��ֵ
     */
    public void setPlanAmount(double planAmount){
        this.planAmount = planAmount;
    }

    /**
     * ��ȡ����PlanAmount
     * @return ����PlanAmount��ֵ
     */
    public double getPlanAmount(){
        return planAmount;
    }

    /**
     * ��������FirstRate
     * @param firstRate �����õ�����FirstRate��ֵ
     */
    public void setFirstRate(double firstRate){
        this.firstRate = firstRate;
    }

    /**
     * ��ȡ����FirstRate
     * @return ����FirstRate��ֵ
     */
    public double getFirstRate(){
        return firstRate;
    }

    /**
     * ��������FirstPaid
     * @param firstPaid �����õ�����FirstPaid��ֵ
     */
    public void setFirstPaid(double firstPaid){
        this.firstPaid = firstPaid;
    }

    /**
     * ��ȡ����FirstPaid
     * @return ����FirstPaid��ֵ
     */
    public double getFirstPaid(){
        return firstPaid;
    }

    /**
     * ��������Currency
     * @param currency �����õ�����Currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����Currency
     * @return ����Currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������LoanAmount
     * @param loanAmount �����õ�����LoanAmount��ֵ
     */
    public void setLoanAmount(double loanAmount){
        this.loanAmount = loanAmount;
    }

    /**
     * ��ȡ����LoanAmount
     * @return ����LoanAmount��ֵ
     */
    public double getLoanAmount(){
        return loanAmount;
    }

    /**
     * ��������LoanRate
     * @param loanRate �����õ�����LoanRate��ֵ
     */
    public void setLoanRate(double loanRate){
        this.loanRate = loanRate;
    }

    /**
     * ��ȡ����LoanRate
     * @return ����LoanRate��ֵ
     */
    public double getLoanRate(){
        return loanRate;
    }

    /**
     * ��������RepaidType
     * @param repaidType �����õ�����RepaidType��ֵ
     */
    public void setRepaidType(String repaidType){
        this.repaidType = StringUtils.rightTrim(repaidType);
    }

    /**
     * ��ȡ����RepaidType
     * @return ����RepaidType��ֵ
     */
    public String getRepaidType(){
        return repaidType;
    }

    /**
     * ��������PaidTimes
     * @param paidTimes �����õ�����PaidTimes��ֵ
     */
    public void setPaidTimes(long paidTimes){
        this.paidTimes = paidTimes;
    }

    /**
     * ��ȡ����PaidTimes
     * @return ����PaidTimes��ֵ
     */
    public long getPaidTimes(){
        return paidTimes;
    }

    /**
     * ��������PerRepaidAmount
     * @param perRepaidAmount �����õ�����PerRepaidAmount��ֵ
     */
    public void setPerRepaidAmount(double perRepaidAmount){
        this.perRepaidAmount = perRepaidAmount;
    }

    /**
     * ��ȡ����PerRepaidAmount
     * @return ����PerRepaidAmount��ֵ
     */
    public double getPerRepaidAmount(){
        return perRepaidAmount;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
