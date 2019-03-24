package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcarLoss-车辆定损表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.734<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcarLossDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性标的序号 */
    private String lossItemCode = "";
    /** 属性车牌号码 */
    private String lossItemName = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性剔除金额/残值/损余 */
    private double sumRest = 0d;
    /** 属性管理费 */
    private double sumManager = 0d;
    /** 属性总定损金额 */
    private double sumCertainLoss = 0d;
    /** 属性剔除金额/残值/损余（核损） */
    private double sumVeriRest = 0d;
    /** 属性管理费（核损） */
    private double sumVeriManager = 0d;
    /** 属性总核损金额 */
    private double sumVerifyLoss = 0d;
    /** 属性损失部位及程度概述 */
    private String lossDesc = "";
    /** 属性赔偿责任代码 */
    private String indemnityDuty = "";
    /** 属性责任比例 */
    private double indemnityDutyRate = 0d;
    /** 属性责任比例(核损) */
    private double veriIndeDutyRate = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性复核人代码 */
    private String approverCode = "";
    /** 属性事故类型 */
    private String caseFlag = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性VIN号码 */
    private String vINNo = "";
    /** 属性管理费率 */
    private double sumManageFeeRate = 0d;
    /** 属性回勘意见 */
    private String backCheckRemark = "";
    /** 属性是否需要回勘 */
    private String backCheckFlag = "";
    
    /** 属性可操作/处理的级别 */
    private String handlerRange = "";
    
    /** 属性SumTransFee */
    private double sumTransFee = 0D;
    /** 属性SumTax */
    private double sumTax = 0D;
    
    /**
     *  默认构造方法,构造一个默认的PrpLcarLossDtoBase对象
     */
    public PrpLcarLossDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
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
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性标的序号
     * @param lossItemCode 待设置的属性标的序号的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性车牌号码
     * @param lossItemName 待设置的属性车牌号码的值
     */
    public void setLossItemName(String lossItemName){
        this.lossItemName = StringUtils.rightTrim(lossItemName);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLossItemName(){
        return lossItemName;
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
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性剔除金额/残值/损余
     * @param sumRest 待设置的属性剔除金额/残值/损余的值
     */
    public void setSumRest(double sumRest){
        this.sumRest = sumRest;
    }

    /**
     * 获取属性剔除金额/残值/损余
     * @return 属性剔除金额/残值/损余的值
     */
    public double getSumRest(){
        return sumRest;
    }

    /**
     * 设置属性管理费
     * @param sumManager 待设置的属性管理费的值
     */
    public void setSumManager(double sumManager){
        this.sumManager = sumManager;
    }

    /**
     * 获取属性管理费
     * @return 属性管理费的值
     */
    public double getSumManager(){
        return sumManager;
    }

    /**
     * 设置属性总定损金额
     * @param sumCertainLoss 待设置的属性总定损金额的值
     */
    public void setSumCertainLoss(double sumCertainLoss){
        this.sumCertainLoss = sumCertainLoss;
    }

    /**
     * 获取属性总定损金额
     * @return 属性总定损金额的值
     */
    public double getSumCertainLoss(){
        return sumCertainLoss;
    }

    /**
     * 设置属性剔除金额/残值/损余（核损）
     * @param sumVeriRest 待设置的属性剔除金额/残值/损余（核损）的值
     */
    public void setSumVeriRest(double sumVeriRest){
        this.sumVeriRest = sumVeriRest;
    }

    /**
     * 获取属性剔除金额/残值/损余（核损）
     * @return 属性剔除金额/残值/损余（核损）的值
     */
    public double getSumVeriRest(){
        return sumVeriRest;
    }

    /**
     * 设置属性管理费（核损）
     * @param sumVeriManager 待设置的属性管理费（核损）的值
     */
    public void setSumVeriManager(double sumVeriManager){
        this.sumVeriManager = sumVeriManager;
    }

    /**
     * 获取属性管理费（核损）
     * @return 属性管理费（核损）的值
     */
    public double getSumVeriManager(){
        return sumVeriManager;
    }

    /**
     * 设置属性总核损金额
     * @param sumVerifyLoss 待设置的属性总核损金额的值
     */
    public void setSumVerifyLoss(double sumVerifyLoss){
        this.sumVerifyLoss = sumVerifyLoss;
    }

    /**
     * 获取属性总核损金额
     * @return 属性总核损金额的值
     */
    public double getSumVerifyLoss(){
        return sumVerifyLoss;
    }

    /**
     * 设置属性损失部位及程度概述
     * @param lossDesc 待设置的属性损失部位及程度概述的值
     */
    public void setLossDesc(String lossDesc){
        this.lossDesc = StringUtils.rightTrim(lossDesc);
    }

    /**
     * 获取属性损失部位及程度概述
     * @return 属性损失部位及程度概述的值
     */
    public String getLossDesc(){
        return lossDesc;
    }

    /**
     * 设置属性赔偿责任代码
     * @param indemnityDuty 待设置的属性赔偿责任代码的值
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * 获取属性赔偿责任代码
     * @return 属性赔偿责任代码的值
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

    /**
     * 设置属性责任比例
     * @param indemnityDutyRate 待设置的属性责任比例的值
     */
    public void setIndemnityDutyRate(double indemnityDutyRate){
        this.indemnityDutyRate = indemnityDutyRate;
    }

    /**
     * 获取属性责任比例
     * @return 属性责任比例的值
     */
    public double getIndemnityDutyRate(){
        return indemnityDutyRate;
    }

    /**
     * 设置属性责任比例(核损)
     * @param veriIndeDutyRate 待设置的属性责任比例(核损)的值
     */
    public void setVeriIndeDutyRate(double veriIndeDutyRate){
        this.veriIndeDutyRate = veriIndeDutyRate;
    }

    /**
     * 获取属性责任比例(核损)
     * @return 属性责任比例(核损)的值
     */
    public double getVeriIndeDutyRate(){
        return veriIndeDutyRate;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性复核人代码
     * @param approverCode 待设置的属性复核人代码的值
     */
    public void setApproverCode(String approverCode){
        this.approverCode = StringUtils.rightTrim(approverCode);
    }

    /**
     * 获取属性复核人代码
     * @return 属性复核人代码的值
     */
    public String getApproverCode(){
        return approverCode;
    }

    /**
     * 设置属性事故类型
     * @param caseFlag 待设置的属性事故类型的值
     */
    public void setCaseFlag(String caseFlag){
        this.caseFlag = StringUtils.rightTrim(caseFlag);
    }

    /**
     * 获取属性事故类型
     * @return 属性事故类型的值
     */
    public String getCaseFlag(){
        return caseFlag;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性VIN号码
     * @param vINNo 待设置的属性VIN号码的值
     */
    public void setVINNo(String vINNo){
        this.vINNo = StringUtils.rightTrim(vINNo);
    }

    /**
     * 获取属性VIN号码
     * @return 属性VIN号码的值
     */
    public String getVINNo(){
        return vINNo;
    }

    /**
     * 设置属性管理费率
     * @param sumManageFeeRate 待设置的属性管理费率的值
     */
    public void setSumManageFeeRate(double sumManageFeeRate){
        this.sumManageFeeRate = sumManageFeeRate;
    }

    /**
     * 获取属性管理费率
     * @return 属性管理费率的值
     */
    public double getSumManageFeeRate(){
        return sumManageFeeRate;
    }

    /**
     * 设置属性回勘意见
     * @param backCheckRemark 待设置的属性回勘意见的值
     */
    public void setBackCheckRemark(String backCheckRemark){
        this.backCheckRemark = StringUtils.rightTrim(backCheckRemark);
    }

    /**
     * 获取属性回勘意见
     * @return 属性回勘意见的值
     */
    public String getBackCheckRemark(){
        return backCheckRemark;
    }

    /**
     * 设置属性是否需要回勘
     * @param backCheckFlag 待设置的属性是否需要回勘的值
     */
    public void setBackCheckFlag(String backCheckFlag){
        this.backCheckFlag = StringUtils.rightTrim(backCheckFlag);
    }

    /**
     * 获取属性是否需要回勘
     * @return 属性是否需要回勘的值
     */
    public String getBackCheckFlag(){
        return backCheckFlag;
    }
    
    /**
     * 设置属性可操作/处理的级别
     * @param handlerRange 待设置的属性可操作/处理的级别的值
     */
    public void setHandlerRange(String handlerRange){
        this.handlerRange = StringUtils.rightTrim(handlerRange);
    }

    /**
     * 获取属性可操作/处理的级别
     * @return 属性可操作/处理的级别的值
     */
    public String getHandlerRange(){
        return handlerRange;
    }

    /**
     * 设置属性SumTransFee
     * @param sumTransFee 待设置的属性SumTransFee的值
     */
    public void setSumTransFee(double sumTransFee){
        this.sumTransFee = sumTransFee;
    }

    /**
     * 获取属性SumTransFee
     * @return 属性SumTransFee的值
     */
    public double getSumTransFee(){
        return sumTransFee;
    }

    /**
     * 设置属性SumTax
     * @param sumTax 待设置的属性SumTax的值
     */
    public void setSumTax(double sumTax){
        this.sumTax = sumTax;
    }

    /**
     * 获取属性SumTax
     * @return 属性SumTax的值
     */
    public double getSumTax(){
        return sumTax;
    }

}
