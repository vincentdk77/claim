package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLnodutyLoss的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLnodutyLossDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性compensateNo */
    private String compensateNo = "";
    /** 属性riskCode */
    private String riskCode = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性serialNo */
    private int serialNo = 0;
    /** 属性kindCode */
    private String kindCode = "";
    /** 属性licenseNo */
    private String licenseNo = "";
    /** 属性insuredName */
    private String insuredName = "";
    /** 属性driverLicenseNo */
    private String driverLicenseNo = "";
    /** 属性insuredCompanyCode */
    private String insuredCompanyCode = "";
    /** 属性insuredCompanyName */
    private String insuredCompanyName = "";
    /** 属性dutyPercent */
    private double dutyPercent = 0D;
    /** 属性paidType */
    private String paidType = "";
    /** 属性paidName */
    private String paidName = "";
    /** 属性currency */
    private String currency = "";
    /** 属性verifyPaid */
    private double verifyPaid = 0D;
    /** 属性limitPaid */
    private double limitPaid = 0D;
    /** 属性realPaid */
    private double realPaid = 0D;
    /** 属性dutyType */
    private String dutyType = "";
    /** 属性replaceFlag */
    private String replaceFlag = "";
    /** 属性remark */
    private String remark = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLnodutyLossDtoBase对象
     */
    public PrpLnodutyLossDtoBase(){
    }

    /**
     * 设置属性compensateNo
     * @param compensateNo 待设置的属性compensateNo的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性compensateNo
     * @return 属性compensateNo的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性riskCode
     * @param riskCode 待设置的属性riskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskCode
     * @return 属性riskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性kindCode
     * @param kindCode 待设置的属性kindCode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性kindCode
     * @return 属性kindCode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性licenseNo
     * @param licenseNo 待设置的属性licenseNo的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性licenseNo
     * @return 属性licenseNo的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性insuredName
     * @param insuredName 待设置的属性insuredName的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性insuredName
     * @return 属性insuredName的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性driverLicenseNo
     * @param driverLicenseNo 待设置的属性driverLicenseNo的值
     */
    public void setDriverLicenseNo(String driverLicenseNo){
        this.driverLicenseNo = StringUtils.rightTrim(driverLicenseNo);
    }

    /**
     * 获取属性driverLicenseNo
     * @return 属性driverLicenseNo的值
     */
    public String getDriverLicenseNo(){
        return driverLicenseNo;
    }

    /**
     * 设置属性insuredCompanyCode
     * @param insuredCompanyCode 待设置的属性insuredCompanyCode的值
     */
    public void setInsuredCompanyCode(String insuredCompanyCode){
        this.insuredCompanyCode = StringUtils.rightTrim(insuredCompanyCode);
    }

    /**
     * 获取属性insuredCompanyCode
     * @return 属性insuredCompanyCode的值
     */
    public String getInsuredCompanyCode(){
        return insuredCompanyCode;
    }

    /**
     * 设置属性insuredCompanyName
     * @param insuredCompanyName 待设置的属性insuredCompanyName的值
     */
    public void setInsuredCompanyName(String insuredCompanyName){
        this.insuredCompanyName = StringUtils.rightTrim(insuredCompanyName);
    }

    /**
     * 获取属性insuredCompanyName
     * @return 属性insuredCompanyName的值
     */
    public String getInsuredCompanyName(){
        return insuredCompanyName;
    }

    /**
     * 设置属性dutyPercent
     * @param dutyPercent 待设置的属性dutyPercent的值
     */
    public void setDutyPercent(double dutyPercent){
        this.dutyPercent = dutyPercent;
    }

    /**
     * 获取属性dutyPercent
     * @return 属性dutyPercent的值
     */
    public double getDutyPercent(){
        return dutyPercent;
    }

    /**
     * 设置属性paidType
     * @param paidType 待设置的属性paidType的值
     */
    public void setPaidType(String paidType){
        this.paidType = StringUtils.rightTrim(paidType);
    }

    /**
     * 获取属性paidType
     * @return 属性paidType的值
     */
    public String getPaidType(){
        return paidType;
    }

    /**
     * 设置属性paidName
     * @param paidName 待设置的属性paidName的值
     */
    public void setPaidName(String paidName){
        this.paidName = StringUtils.rightTrim(paidName);
    }

    /**
     * 获取属性paidName
     * @return 属性paidName的值
     */
    public String getPaidName(){
        return paidName;
    }

    /**
     * 设置属性currency
     * @param currency 待设置的属性currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性currency
     * @return 属性currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性verifyPaid
     * @param verifyPaid 待设置的属性verifyPaid的值
     */
    public void setVerifyPaid(double verifyPaid){
        this.verifyPaid = verifyPaid;
    }

    /**
     * 获取属性verifyPaid
     * @return 属性verifyPaid的值
     */
    public double getVerifyPaid(){
        return verifyPaid;
    }

    /**
     * 设置属性limitPaid
     * @param limitPaid 待设置的属性limitPaid的值
     */
    public void setLimitPaid(double limitPaid){
        this.limitPaid = limitPaid;
    }

    /**
     * 获取属性limitPaid
     * @return 属性limitPaid的值
     */
    public double getLimitPaid(){
        return limitPaid;
    }

    /**
     * 设置属性realPaid
     * @param realPaid 待设置的属性realPaid的值
     */
    public void setRealPaid(double realPaid){
        this.realPaid = realPaid;
    }

    /**
     * 获取属性realPaid
     * @return 属性realPaid的值
     */
    public double getRealPaid(){
        return realPaid;
    }

    /**
     * 设置属性dutyType
     * @param dutyType 待设置的属性dutyType的值
     */
    public void setDutyType(String dutyType){
        this.dutyType = StringUtils.rightTrim(dutyType);
    }

    /**
     * 获取属性dutyType
     * @return 属性dutyType的值
     */
    public String getDutyType(){
        return dutyType;
    }

    /**
     * 设置属性replaceFlag
     * @param replaceFlag 待设置的属性replaceFlag的值
     */
    public void setReplaceFlag(String replaceFlag){
        this.replaceFlag = StringUtils.rightTrim(replaceFlag);
    }

    /**
     * 获取属性replaceFlag
     * @return 属性replaceFlag的值
     */
    public String getReplaceFlag(){
        return replaceFlag;
    }

    /**
     * 设置属性remark
     * @param remark 待设置的属性remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性remark
     * @return 属性remark的值
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
