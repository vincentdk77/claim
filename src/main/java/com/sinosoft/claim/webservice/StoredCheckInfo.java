package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;


/**
 * 暂存数据传输对象Bean
 * 保单号、报案号、出险日期、出险时间、出险地点、查勘日期、查勘时间、查勘地点、是否第一现场、查勘类型、查勘人1、查勘人2、出险原因号、事故原因号、事故责任(buqueding )、
 * 出险区域、赔案类别、备注等
 * 
 * @author fei
 * 
 */
public class StoredCheckInfo implements Serializable {

	/**
	 * 数据来源于查勘表中
	 * 查勘时间(表中无此字段)
	 */
	private static final long serialVersionUID = 1L;
	/** 属性保单号码 */
    private String policyNo = "";
	/** 属性报案号码 */
    private String registNo = "";
    /** 属性出险日期 */
    private String damageStartDate = "";
    /** 属性出险时间*/
    private String damageStartHour = "";
	/** 属性出险地点 */
    private String damageAddress = "";
    /** 查勘日期 */
    private String checkDate = "";
    /** 查勘时间 */
    private String checkStartHour = "";
    /** 属性查勘/代查勘地点 */
    private String checkSite = "";
    /** 属性是否第一现场 */
    private String firstSiteFlag = "";
    /** 属性查勘类型 */
    private String checkType = "";
    /** 属性查勘/代查勘人1 */
    private String checker1 = "";
    /** 属性查勘/代查勘人2 */
    private String checker2 = "";
    /** 属性出险原因代码 */
    private String damageCode = "";
    /** 属性事故类型代码 */
    private String damageTypeCode = "";
    /** 属性赔偿责任代码 */
    private String indemnityDuty = "";
    /** 属性出险区域代码 */
    private String damageAreaCode = "";
    /** 属性案件类型 */
    private String claimType = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 联系人姓名 */
    private String linkerName = "";
    /** 联系人电话 */
    private String linkerPhone = "";
    /** 联系人地址 */
    private String linkerAddress = "";
    /** 联系人邮编 */
    private String linkerPostCode = "";
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

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getLinkerName() {
		return linkerName;
	}

	public void setLinkerName(String linkerName) {
		this.linkerName = linkerName;
	}

	public String getLinkerPhone() {
		return linkerPhone;
	}

	public void setLinkerPhone(String linkerPhone) {
		this.linkerPhone = linkerPhone;
	}

	public String getLinkerAddress() {
		return linkerAddress;
	}

	public void setLinkerAddress(String linkerAddress) {
		this.linkerAddress = linkerAddress;
	}

	public String getLinkerPostCode() {
		return linkerPostCode;
	}

	public void setLinkerPostCode(String linkerPostCode) {
		this.linkerPostCode = linkerPostCode;
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
     * 设置属性出险日期
     * @param damageStartDate 待设置的属性出险日期的值
     */
    public void setDamageStartDate(String damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * 获取属性出险日期
     * @return 属性出险日期的值
     */
    public String getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * 设置属性出险时间
     * @param damageStartHour 待设置的属性出险时间的值
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * 获取属性出险时间
     * @return 属性出险时间的值
     */
    public String getDamageStartHour(){
        return damageStartHour;
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
     * 设置属性查勘/代查勘日期
     * @param checkDate 待设置的属性查勘/代查勘日期的值
     */
    public void setCheckDate(String checkDate){
        this.checkDate = checkDate;
    }

    /**
     * 获取属性查勘/代查勘日期
     * @return 属性查勘/代查勘日期的值
     */
    public String getCheckDate(){
        return checkDate;
        
    }
    
    
    /**
     * 获取属性查勘/代查勘时间
     * @return 属性查勘/代查勘时间的值
     */
    public String getCheckStartHour() {
		return checkStartHour;
	}

    /**
     * 设置属性查勘/代查勘时间
     * @param checkDate 待设置的属性查勘/代查勘时间的值
     */
	public void setCheckStartHour(String checkStartHour) {
		this.checkStartHour = checkStartHour;
	}

	/**
     * 设置属性查勘/代查勘地点
     * @param checkSite 待设置的属性查勘/代查勘地点的值
     */
    public void setCheckSite(String checkSite){
        this.checkSite = StringUtils.rightTrim(checkSite);
    }

    /**
     * 获取属性查勘/代查勘地点
     * @return 属性查勘/代查勘地点的值
     */
    public String getCheckSite(){
        return checkSite;
    }
    
    /**
     * 设置属性是否第一现场
     * @param firstSiteFlag 待设置的属性是否第一现场的值
     */
    public void setFirstSiteFlag(String firstSiteFlag){
        this.firstSiteFlag = StringUtils.rightTrim(firstSiteFlag);
    }

    /**
     * 获取属性是否第一现场
     * @return 属性是否第一现场的值
     */
    public String getFirstSiteFlag(){
        return firstSiteFlag;
    }
    
    /**
     * 设置属性查勘类型
     * @param checkType 待设置的属性查勘类型的值
     */
    public void setCheckType(String checkType){
        this.checkType = StringUtils.rightTrim(checkType);
    }

    /**
     * 获取属性查勘类型
     * @return 属性查勘类型的值
     */
    public String getCheckType(){
        return checkType;
    }
    
    /**
     * 设置属性查勘/代查勘人1
     * @param checker1 待设置的属性查勘/代查勘人1的值
     */
    public void setChecker1(String checker1){
        this.checker1 = StringUtils.rightTrim(checker1);
    }

    /**
     * 获取属性查勘/代查勘人1
     * @return 属性查勘/代查勘人1的值
     */
    public String getChecker1(){
        return checker1;
    }

    /**
     * 设置属性查勘/代查勘人2
     * @param checker2 待设置的属性查勘/代查勘人2的值
     */
    public void setChecker2(String checker2){
        this.checker2 = StringUtils.rightTrim(checker2);
    }

    /**
     * 获取属性查勘/代查勘人2
     * @return 属性查勘/代查勘人2的值
     */
    public String getChecker2(){
        return checker2;
    }
    
    /**
     * 设置属性案件类型
     * @param claimType 待设置的属性案件类型的值
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
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
     * 获取属性案件类型
     * @return 属性案件类型的值
     */
    public String getClaimType(){
        return claimType;
    }

    /**
     * 设置属性出险原因代码
     * @param damageCode 待设置的属性出险原因代码的值
     */
    public void setDamageCode(String damageCode){
        this.damageCode = StringUtils.rightTrim(damageCode);
    }

    /**
     * 获取属性出险原因代码
     * @return 属性出险原因代码的值
     */
    public String getDamageCode(){
        return damageCode;
    }

    
    /**
     * 设置属性事故类型代码
     * @param damageTypeCode 待设置的属性事故类型代码的值
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * 获取属性事故类型代码
     * @return 属性事故类型代码的值
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * 设置属性出险区域代码
     * @param damageAreaCode 待设置的属性出险区域代码的值
     */
    public void setDamageAreaCode(String damageAreaCode){
        this.damageAreaCode = StringUtils.rightTrim(damageAreaCode);
    }

    /**
     * 获取属性出险区域代码
     * @return 属性出险区域代码的值
     */
    public String getDamageAreaCode(){
        return damageAreaCode;
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
    
    
}
