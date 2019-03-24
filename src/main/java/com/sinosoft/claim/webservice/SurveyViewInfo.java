package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 任务相关信息 字段：保单号、报案号、已出险次数、出险时间、出险地点、车牌号码、联系人、联系人地址、联系电话、联系人邮编等
 * 查勘界面带出的信息的数据来源
 * @author fei
 * 
 */
public class SurveyViewInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 属性保单号码 */
    private String policyNo = "";
	/** 属性报案号码 */
    private String registNo = "";
    /** 属性出险次数 */
    private int perilCount = 0;
    /** 属性出险时间 */
    private String damageTime = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性联系人 */
    private String linkerName = "";
    /** 属性联系人电话 */
    private String linkerPhone = "";//无此字段。
    /** 属性联系人邮编 */
    private String linkerPostCode = "";
    /** 属性联系人通讯地址 */
    private String linkerAddress = "";
    /** 属性是否第一现场 */
    private String firstSiteFlag = "";
    /** 属性出险原因 */
    private String damageCode = "";
    /** 属性事故责任 */
    private String indemnityDuty = "";
    /** 属性出险区域 */
    private String damageAreaCode = "";
    /** 属性赔案类别 */
    private String claimType = "";
    /** 属性查勘人名称 */
    private String checkUserName = "";
    /** 属性驾驶员姓名 */
    private String driverName = "";
    /** 属性驾驶员电话 */
    private String driverPhone = "";
    /** 属性驾驶员证件类型 */
    private String certTypeCode = "";
    /** 属性驾驶员证件号码 */
    private String certNo = "";
    /** 属性查勘报告 */
    private String surveyReport = "";
    
    
    public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getCertTypeCode() {
		return certTypeCode;
	}

	public void setCertTypeCode(String certTypeCode) {
		this.certTypeCode = certTypeCode;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getSurveyReport() {
		return surveyReport;
	}

	public void setSurveyReport(String surveyReport) {
		this.surveyReport = surveyReport;
	}

	public String getFirstSiteFlag() {
		return firstSiteFlag;
	}

	public void setFirstSiteFlag(String firstSiteFlag) {
		this.firstSiteFlag = firstSiteFlag;
	}

	public String getDamageCode() {
		return damageCode;
	}

	public void setDamageCode(String damageCode) {
		this.damageCode = damageCode;
	}

	public String getIndemnityDuty() {
		return indemnityDuty;
	}

	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}

	public String getDamageAreaCode() {
		return damageAreaCode;
	}

	public void setDamageAreaCode(String damageAreaCode) {
		this.damageAreaCode = damageAreaCode;
	}

	public String getClaimType() {
		return claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	/**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }
    
    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
    }
    
    /**
     * 获取属性出险次数 
     * @return 属性出险次数 的值
     */
	public int getPerilCount() {
		return perilCount;
	}

	/**
     * 设置属性出险次数 
     * @param perilCount 待设置的属性出险次数 的值
     */
	public void setPerilCount(int perilCount) {
		this.perilCount = perilCount;
	}
	
	/**
     * 获取属性出险时间
     * @return 属性出险时间的值
     */
    public String getDamageTime() {
		return damageTime;
	}

    /**
     * 设置属性出险时间
     * @param damageTime 待设置的属性出险时间的值
     */
	public void setDamageTime(String damageTime) {
		this.damageTime = damageTime;
	}
	
	/**
     * 设置属性出险地点
     * @param damageAddress 待设置的属性出险地点的值
     */
    public void setDamageAddress(String damageAddress){
        this.damageAddress = StringUtils.rightTrim(damageAddress);
    }

    /**
     * 获取属性出险地点
     * @return 属性出险地点的值
     */
    public String getDamageAddress(){
        return damageAddress;
    }	
    
    /**
     * 设置属性车牌号码
     * @param licenseNo 待设置的属性车牌号码的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号码
     * @return 属性车牌号码的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }
    
    /**
     * 设置属性联系人
     * @param linkerName 待设置的属性联系人的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性联系人
     * @return 属性联系人的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性联系人邮编
     * @param linkerPostCode 待设置的属性联系人邮编的值
     */
    public void setLinkerPostCode(String linkerPostCode){
        this.linkerPostCode = StringUtils.rightTrim(linkerPostCode);
    }

    /**
     * 获取属性联系人邮编
     * @return 属性联系人邮编的值
     */
    public String getLinkerPostCode(){
        return linkerPostCode;
    }

    /**
     * 设置属性联系人通讯地址
     * @param linkerAddress 待设置的属性联系人通讯地址的值
     */
    public void setLinkerAddress(String linkerAddress){
        this.linkerAddress = StringUtils.rightTrim(linkerAddress);
    }

    /**
     * 获取属性联系人通讯地址
     * @return 属性联系人通讯地址的值
     */
    public String getLinkerAddress(){
        return linkerAddress;
    }

    /**
     * 获取属性联系人电话
     * @return 属性联系人电话的值
     */
	public String getLinkerPhone() {
		return linkerPhone;
	}

	/**
     * 设置属性联系人电话
     * @param linkerPhone 待设置的属性联系人电话的值
     */
	public void setLinkerPhone(String linkerPhone) {
		this.linkerPhone = linkerPhone;
	}

	public String getCheckUserName() {
		return checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}
    
    
}
