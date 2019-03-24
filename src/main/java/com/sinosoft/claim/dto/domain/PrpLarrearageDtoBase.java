package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLarrearage-逾款欠款清单表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.671<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLarrearageDtoBase implements Serializable{
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性汽车经销商 */
    private String automobileDealer = "";
    /** 属性贷款金额 */
    private double sumLoan = 0d;
    /** 属性借款时间 */
    private DateTime loanStartDate = new DateTime();
    /** 属性借款期限 */
    private String loanTerm = "";
    /** 属性已还款期数 */
    private int sumRepaidTimes = 0;
    /** 属性已还款金额 */
    private double sumRePaid = 0d;
    /** 属性贷款余额 */
    private double sumNoRePaid = 0d;
    /** 属性欠款本金 */
    private double arrearageCorpus = 0d;
    /** 属性逾期时间 */
    private DateTime arrearageDate = new DateTime();
    /** 属性最近一次还款日期 */
    private DateTime lastRepaidDate = new DateTime();
    /** 属性本期应还款截止日期 */
    private DateTime arrearageEndDate = new DateTime();
    /** 属性逾期欠款期数 */
    private int arrearageTimes = 0;
    /** 属性逾期欠款金额 */
    private double sumArrearage = 0d;
    /** 属性逾期欠款原因 */
    private String arrearageReason = "";
    /** 属性抵押物/质押物 */
    private String guaranteeName = "";
    /** 属性保证人 */
    private String cautioner = "";
    /** 属性保证金 */
    private double cautionMoney = 0d;
    /** 属性催收措施 */
    private String dunStep = "";
    /** 属性报告单位意见 */
    private String reportUnitProposal = "";
    /** 属性经办人 */
    private String handlerCode = "";
    /** 属性经理 */
    private String manager = "";
    /** 属性登录时间 */
    private DateTime inputDate = new DateTime();
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLarrearageDtoBase对象
     */
    public PrpLarrearageDtoBase(){
    }

    /**
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性汽车经销商
     * @param automobileDealer 待设置的属性汽车经销商的值
     */
    public void setAutomobileDealer(String automobileDealer){
        this.automobileDealer = StringUtils.rightTrim(automobileDealer);
    }

    /**
     * 获取属性汽车经销商
     * @return 属性汽车经销商的值
     */
    public String getAutomobileDealer(){
        return automobileDealer;
    }

    /**
     * 设置属性贷款金额
     * @param sumLoan 待设置的属性贷款金额的值
     */
    public void setSumLoan(double sumLoan){
        this.sumLoan = sumLoan;
    }

    /**
     * 获取属性贷款金额
     * @return 属性贷款金额的值
     */
    public double getSumLoan(){
        return sumLoan;
    }

    /**
     * 设置属性借款时间
     * @param loanStartDate 待设置的属性借款时间的值
     */
    public void setLoanStartDate(DateTime loanStartDate){
        this.loanStartDate = loanStartDate;
    }

    /**
     * 获取属性借款时间
     * @return 属性借款时间的值
     */
    public DateTime getLoanStartDate(){
        return loanStartDate;
    }

    /**
     * 设置属性借款期限
     * @param loanTerm 待设置的属性借款期限的值
     */
    public void setLoanTerm(String loanTerm){
        this.loanTerm = StringUtils.rightTrim(loanTerm);
    }

    /**
     * 获取属性借款期限
     * @return 属性借款期限的值
     */
    public String getLoanTerm(){
        return loanTerm;
    }

    /**
     * 设置属性已还款期数
     * @param sumRepaidTimes 待设置的属性已还款期数的值
     */
    public void setSumRepaidTimes(int sumRepaidTimes){
        this.sumRepaidTimes = sumRepaidTimes;
    }

    /**
     * 获取属性已还款期数
     * @return 属性已还款期数的值
     */
    public int getSumRepaidTimes(){
        return sumRepaidTimes;
    }

    /**
     * 设置属性已还款金额
     * @param sumRePaid 待设置的属性已还款金额的值
     */
    public void setSumRePaid(double sumRePaid){
        this.sumRePaid = sumRePaid;
    }

    /**
     * 获取属性已还款金额
     * @return 属性已还款金额的值
     */
    public double getSumRePaid(){
        return sumRePaid;
    }

    /**
     * 设置属性贷款余额
     * @param sumNoRePaid 待设置的属性贷款余额的值
     */
    public void setSumNoRePaid(double sumNoRePaid){
        this.sumNoRePaid = sumNoRePaid;
    }

    /**
     * 获取属性贷款余额
     * @return 属性贷款余额的值
     */
    public double getSumNoRePaid(){
        return sumNoRePaid;
    }

    /**
     * 设置属性欠款本金
     * @param arrearageCorpus 待设置的属性欠款本金的值
     */
    public void setArrearageCorpus(double arrearageCorpus){
        this.arrearageCorpus = arrearageCorpus;
    }

    /**
     * 获取属性欠款本金
     * @return 属性欠款本金的值
     */
    public double getArrearageCorpus(){
        return arrearageCorpus;
    }

    /**
     * 设置属性逾期时间
     * @param arrearageDate 待设置的属性逾期时间的值
     */
    public void setArrearageDate(DateTime arrearageDate){
        this.arrearageDate = arrearageDate;
    }

    /**
     * 获取属性逾期时间
     * @return 属性逾期时间的值
     */
    public DateTime getArrearageDate(){
        return arrearageDate;
    }

    /**
     * 设置属性最近一次还款日期
     * @param lastRepaidDate 待设置的属性最近一次还款日期的值
     */
    public void setLastRepaidDate(DateTime lastRepaidDate){
        this.lastRepaidDate = lastRepaidDate;
    }

    /**
     * 获取属性最近一次还款日期
     * @return 属性最近一次还款日期的值
     */
    public DateTime getLastRepaidDate(){
        return lastRepaidDate;
    }

    /**
     * 设置属性本期应还款截止日期
     * @param arrearageEndDate 待设置的属性本期应还款截止日期的值
     */
    public void setArrearageEndDate(DateTime arrearageEndDate){
        this.arrearageEndDate = arrearageEndDate;
    }

    /**
     * 获取属性本期应还款截止日期
     * @return 属性本期应还款截止日期的值
     */
    public DateTime getArrearageEndDate(){
        return arrearageEndDate;
    }

    /**
     * 设置属性逾期欠款期数
     * @param arrearageTimes 待设置的属性逾期欠款期数的值
     */
    public void setArrearageTimes(int arrearageTimes){
        this.arrearageTimes = arrearageTimes;
    }

    /**
     * 获取属性逾期欠款期数
     * @return 属性逾期欠款期数的值
     */
    public int getArrearageTimes(){
        return arrearageTimes;
    }

    /**
     * 设置属性逾期欠款金额
     * @param sumArrearage 待设置的属性逾期欠款金额的值
     */
    public void setSumArrearage(double sumArrearage){
        this.sumArrearage = sumArrearage;
    }

    /**
     * 获取属性逾期欠款金额
     * @return 属性逾期欠款金额的值
     */
    public double getSumArrearage(){
        return sumArrearage;
    }

    /**
     * 设置属性逾期欠款原因
     * @param arrearageReason 待设置的属性逾期欠款原因的值
     */
    public void setArrearageReason(String arrearageReason){
        this.arrearageReason = StringUtils.rightTrim(arrearageReason);
    }

    /**
     * 获取属性逾期欠款原因
     * @return 属性逾期欠款原因的值
     */
    public String getArrearageReason(){
        return arrearageReason;
    }

    /**
     * 设置属性抵押物/质押物
     * @param guaranteeName 待设置的属性抵押物/质押物的值
     */
    public void setGuaranteeName(String guaranteeName){
        this.guaranteeName = StringUtils.rightTrim(guaranteeName);
    }

    /**
     * 获取属性抵押物/质押物
     * @return 属性抵押物/质押物的值
     */
    public String getGuaranteeName(){
        return guaranteeName;
    }

    /**
     * 设置属性保证人
     * @param cautioner 待设置的属性保证人的值
     */
    public void setCautioner(String cautioner){
        this.cautioner = StringUtils.rightTrim(cautioner);
    }

    /**
     * 获取属性保证人
     * @return 属性保证人的值
     */
    public String getCautioner(){
        return cautioner;
    }

    /**
     * 设置属性保证金
     * @param cautionMoney 待设置的属性保证金的值
     */
    public void setCautionMoney(double cautionMoney){
        this.cautionMoney = cautionMoney;
    }

    /**
     * 获取属性保证金
     * @return 属性保证金的值
     */
    public double getCautionMoney(){
        return cautionMoney;
    }

    /**
     * 设置属性催收措施
     * @param dunStep 待设置的属性催收措施的值
     */
    public void setDunStep(String dunStep){
        this.dunStep = StringUtils.rightTrim(dunStep);
    }

    /**
     * 获取属性催收措施
     * @return 属性催收措施的值
     */
    public String getDunStep(){
        return dunStep;
    }

    /**
     * 设置属性报告单位意见
     * @param reportUnitProposal 待设置的属性报告单位意见的值
     */
    public void setReportUnitProposal(String reportUnitProposal){
        this.reportUnitProposal = StringUtils.rightTrim(reportUnitProposal);
    }

    /**
     * 获取属性报告单位意见
     * @return 属性报告单位意见的值
     */
    public String getReportUnitProposal(){
        return reportUnitProposal;
    }

    /**
     * 设置属性经办人
     * @param handlerCode 待设置的属性经办人的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人
     * @return 属性经办人的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性经理
     * @param manager 待设置的属性经理的值
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * 获取属性经理
     * @return 属性经理的值
     */
    public String getManager(){
        return manager;
    }

    /**
     * 设置属性登录时间
     * @param inputDate 待设置的属性登录时间的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性登录时间
     * @return 属性登录时间的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
