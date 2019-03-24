package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLpeds_Person人员伤亡明细信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpeds_PersonDtoBase implements Serializable{
    /** 属性报案号 */
    private String registNo = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性保单标的子险序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性所在地区代码 */
    private String areaCode = "";
    /** 属性固定收入标志 */
    private String fixedIncomeFlag = "";
    /** 属性行业代码 */
    private String jobCode = "";
    /** 属性行业名称 */
    private String jobName = "";
    /** 属性赔付人员类型 */
    private String payPersonType = "";
    /** 属性各种费用代码 */
    private String feeTypeCode = "";
    /** 属性费用名称 */
    private String feeTypeName = "";
    /** 属性人员序号 */
    private int personNo = 0;
    /** 属性人员姓名 */
    private String personName = "";
    /** 属性性别 */
    private String personSex = "";
    /** 属性年龄 */
    private int personAge = 0;
    /** 属性币别 */
    private String currency = "";
    /** 属性受损金额 */
    private double sumLoss = 0d;
    /** 属性剔除金额 */
    private double sumReject = 0d;
    /** 属性剔除原因 */
    private String rejectReason = "";
    /** 属性赔偿比例 */
    private double lossRate = 0d;
    /** 属性核定损金额 */
    private double sumDefLoss = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpeds_PersonDtoBase对象
     */
    public PrpLpeds_PersonDtoBase(){
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
     * 设置属性保单标的子险序号
     * @param itemKindNo 待设置的属性保单标的子险序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性保单标的子险序号
     * @return 属性保单标的子险序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性所在地区代码
     * @param areaCode 待设置的属性所在地区代码的值
     */
    public void setAreaCode(String areaCode){
        this.areaCode = StringUtils.rightTrim(areaCode);
    }

    /**
     * 获取属性所在地区代码
     * @return 属性所在地区代码的值
     */
    public String getAreaCode(){
        return areaCode;
    }

    /**
     * 设置属性固定收入标志
     * @param fixedIncomeFlag 待设置的属性固定收入标志的值
     */
    public void setFixedIncomeFlag(String fixedIncomeFlag){
        this.fixedIncomeFlag = StringUtils.rightTrim(fixedIncomeFlag);
    }

    /**
     * 获取属性固定收入标志
     * @return 属性固定收入标志的值
     */
    public String getFixedIncomeFlag(){
        return fixedIncomeFlag;
    }

    /**
     * 设置属性行业代码
     * @param jobCode 待设置的属性行业代码的值
     */
    public void setJobCode(String jobCode){
        this.jobCode = StringUtils.rightTrim(jobCode);
    }

    /**
     * 获取属性行业代码
     * @return 属性行业代码的值
     */
    public String getJobCode(){
        return jobCode;
    }

    /**
     * 设置属性行业名称
     * @param jobName 待设置的属性行业名称的值
     */
    public void setJobName(String jobName){
        this.jobName = StringUtils.rightTrim(jobName);
    }

    /**
     * 获取属性行业名称
     * @return 属性行业名称的值
     */
    public String getJobName(){
        return jobName;
    }

    /**
     * 设置属性赔付人员类型
     * @param payPersonType 待设置的属性赔付人员类型的值
     */
    public void setPayPersonType(String payPersonType){
        this.payPersonType = StringUtils.rightTrim(payPersonType);
    }

    /**
     * 获取属性赔付人员类型
     * @return 属性赔付人员类型的值
     */
    public String getPayPersonType(){
        return payPersonType;
    }

    /**
     * 设置属性各种费用代码
     * @param feeTypeCode 待设置的属性各种费用代码的值
     */
    public void setFeeTypeCode(String feeTypeCode){
        this.feeTypeCode = StringUtils.rightTrim(feeTypeCode);
    }

    /**
     * 获取属性各种费用代码
     * @return 属性各种费用代码的值
     */
    public String getFeeTypeCode(){
        return feeTypeCode;
    }

    /**
     * 设置属性费用名称
     * @param feeTypeName 待设置的属性费用名称的值
     */
    public void setFeeTypeName(String feeTypeName){
        this.feeTypeName = StringUtils.rightTrim(feeTypeName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getFeeTypeName(){
        return feeTypeName;
    }

    /**
     * 设置属性人员序号
     * @param personNo 待设置的属性人员序号的值
     */
    public void setPersonNo(int personNo){
        this.personNo = personNo;
    }

    /**
     * 获取属性人员序号
     * @return 属性人员序号的值
     */
    public int getPersonNo(){
        return personNo;
    }

    /**
     * 设置属性人员姓名
     * @param personName 待设置的属性人员姓名的值
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * 获取属性人员姓名
     * @return 属性人员姓名的值
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * 设置属性性别
     * @param personSex 待设置的属性性别的值
     */
    public void setPersonSex(String personSex){
        this.personSex = StringUtils.rightTrim(personSex);
    }

    /**
     * 获取属性性别
     * @return 属性性别的值
     */
    public String getPersonSex(){
        return personSex;
    }

    /**
     * 设置属性年龄
     * @param personAge 待设置的属性年龄的值
     */
    public void setPersonAge(int personAge){
        this.personAge = personAge;
    }

    /**
     * 获取属性年龄
     * @return 属性年龄的值
     */
    public int getPersonAge(){
        return personAge;
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
     * 设置属性受损金额
     * @param sumLoss 待设置的属性受损金额的值
     */
    public void setSumLoss(double sumLoss){
        this.sumLoss = sumLoss;
    }

    /**
     * 获取属性受损金额
     * @return 属性受损金额的值
     */
    public double getSumLoss(){
        return sumLoss;
    }

    /**
     * 设置属性剔除金额
     * @param sumReject 待设置的属性剔除金额的值
     */
    public void setSumReject(double sumReject){
        this.sumReject = sumReject;
    }

    /**
     * 获取属性剔除金额
     * @return 属性剔除金额的值
     */
    public double getSumReject(){
        return sumReject;
    }

    /**
     * 设置属性剔除原因
     * @param rejectReason 待设置的属性剔除原因的值
     */
    public void setRejectReason(String rejectReason){
        this.rejectReason = StringUtils.rightTrim(rejectReason);
    }

    /**
     * 获取属性剔除原因
     * @return 属性剔除原因的值
     */
    public String getRejectReason(){
        return rejectReason;
    }

    /**
     * 设置属性赔偿比例
     * @param lossRate 待设置的属性赔偿比例的值
     */
    public void setLossRate(double lossRate){
        this.lossRate = lossRate;
    }

    /**
     * 获取属性赔偿比例
     * @return 属性赔偿比例的值
     */
    public double getLossRate(){
        return lossRate;
    }

    /**
     * 设置属性核定损金额
     * @param sumDefLoss 待设置的属性核定损金额的值
     */
    public void setSumDefLoss(double sumDefLoss){
        this.sumDefLoss = sumDefLoss;
    }

    /**
     * 获取属性核定损金额
     * @return 属性核定损金额的值
     */
    public double getSumDefLoss(){
        return sumDefLoss;
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
}
