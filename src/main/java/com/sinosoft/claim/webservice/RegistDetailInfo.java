package com.sinosoft.claim.webservice;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 包括报案代码、出险时间、报案人、报案人电话、驾驶员、驾驶员电话、车牌号码、事故类型、出险原因、出险区域、出险地点、处理部门、事故责任、损失类型（空）、伤情描述、出险经过（PrpLregistText）、出险次数等信息。
 * @author fei
 *
 */
public class RegistDetailInfo implements Serializable {

	/**事故责任中0-全责，1-主责2-同责，3-次责，4-无责，9-其他
	 * 损失类型：1-车损      、2-物损     3-盗抢  、 4-本车伤    5-三者伤 
	 */
	private static final long serialVersionUID = 1L;
	/** 属性报案号码 */
    private String registNo = "";
    /** 属性出险时间 */
    private String damageTime = "";
    /** 属性驾驶员姓名 */
    private String driverName = "";//prpLdriver表中
    /** 属性驾驶员联系电话 */
    private String driverPhone = "";
	/** 属性报案人 */
    private String reportorName = "";
    /** 属性报案人联系电话 */
    private String phoneNumber = "";
    /** 属性事故类型代码(车险) */
    private String damageTypeCode = "";
    /** 属性事故类型说明 */
    private String damageTypeName = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性出险原因代码 */
    private String damageCode = "";
    /** 属性出险原因说明 */
    private String damageName = "";
    /** 属性出险区域代码 */
    private String damageAreaCode = "";
    /** 属性出险区域名称 */
    private String damageAreaName = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性事故处理部门 */
    private String handleUnit = "";
    /** 属性事故责任类型 */
    private String indemnityDuty = "";
    /** 属性伤情描述 */
    private String woundRemark = "";//PrpLpersonTrace表
    /** 属性损失类型 */
    private String lossType = "";
    /** 属性出现经过*/
    private String damageAbstract = "";//出险经过（PrpLregistText）
    /** 属性出险次数 */
    private int perilCount = 0;

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
     * 设置属性驾驶员姓名
     * @param driverName 待设置的属性驾驶员姓名的值
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * 获取属性驾驶员姓名
     * @return 属性驾驶员姓名的值
     */
    public String getDriverName(){
        return driverName;
    }
    
    
    /**
     * 获取属性驾驶员联系电话
     * @return 属性驾驶员联系电话的值
     */
    public String getDriverPhone() {
		return driverPhone;
	}
    
    /**
     * 设置属性驾驶员联系电话
     * @param driverPhone 待设置的属性驾驶员联系电话的值
     */
	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}
    
    /**
     * 设置属性报案人
     * @param reportorName 待设置的属性报案人的值
     */
    public void setReportorName(String reportorName){
        this.reportorName = StringUtils.rightTrim(reportorName);
    }

    /**
     * 获取属性报案人
     * @return 属性报案人的值
     */
    public String getReportorName(){
        return reportorName;
    }
    
    /**
     * 设置属性报案人联系电话
     * @param phoneNumber 待设置的属性报案人联系电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性报案人联系电话
     * @return 属性报案人联系电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    /**
     * 设置属性事故类型代码(车险)
     * @param damageTypeCode 待设置的属性事故类型代码(车险)的值
     */
    public void setDamageTypeCode(String damageTypeCode){
        this.damageTypeCode = StringUtils.rightTrim(damageTypeCode);
    }

    /**
     * 获取属性事故类型代码(车险)
     * @return 属性事故类型代码(车险)的值
     */
    public String getDamageTypeCode(){
        return damageTypeCode;
    }

    /**
     * 设置属性事故类型说明
     * @param damageTypeName 待设置的属性事故类型说明的值
     */
    public void setDamageTypeName(String damageTypeName){
        this.damageTypeName = StringUtils.rightTrim(damageTypeName);
    }

    /**
     * 获取属性事故类型说明
     * @return 属性事故类型说明的值
     */
    public String getDamageTypeName(){
        return damageTypeName;
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
     * 设置属性出险原因说明
     * @param damageName 待设置的属性出险原因说明的值
     */
    public void setDamageName(String damageName){
        this.damageName = StringUtils.rightTrim(damageName);
    }

    /**
     * 获取属性出险原因说明
     * @return 属性出险原因说明的值
     */
    public String getDamageName(){
        return damageName;
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
     * 设置属性出险区域名称
     * @param damageAreaName 待设置的属性出险区域名称的值
     */
    public void setDamageAreaName(String damageAreaName){
        this.damageAreaName = StringUtils.rightTrim(damageAreaName);
    }

    /**
     * 获取属性出险区域名称
     * @return 属性出险区域名称的值
     */
    public String getDamageAreaName(){
        return damageAreaName;
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
     * 设置属性事故处理部门
     * @param handleUnit 待设置的属性事故处理部门的值
     */
    public void setHandleUnit(String handleUnit){
        this.handleUnit = StringUtils.rightTrim(handleUnit);
    }

    /**
     * 获取属性事故处理部门
     * @return 属性事故处理部门的值
     */
    public String getHandleUnit(){
        return handleUnit;
    }
    
   
    /**
     * 设置属性事故责任类型
     * @param indemnityDuty 待设置的属性事故责任类型的值
     */
    public void setIndemnityDuty(String indemnityDuty){
        this.indemnityDuty = StringUtils.rightTrim(indemnityDuty);
    }

    /**
     * 获取属性事故责任类型
     * @return 属性事故责任类型的值
     */
    public String getIndemnityDuty(){
        return indemnityDuty;
    }

	/**
     * 设置属性伤情描述
     * @param woundRemark 待设置的属性伤情描述的值
     */
    public void setWoundRemark(String woundRemark){
        this.woundRemark = StringUtils.rightTrim(woundRemark);
    }

    /**
     * 获取属性伤情描述
     * @return 属性伤情描述的值
     */
    public String getWoundRemark(){
        return woundRemark;
    }

    /**
     * 获取属性损失类型 
     * @return 属性损失类型 的值
     */
	public String getLossType() {
		return lossType;
	}

	/**
     * 设置属性损失类型 
     * @param lossType 待设置的属性损失类型 的值
     */
	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	/**
     * 获取属性出现经过 
     * @return 属性出现经过 的值
     */
	public String getDamageAbstract() {
		return damageAbstract;
	}
	
	/**
     * 设置属性出现经过 
     * @param damageAbstract 待设置的属性出现经过 的值
     */
	public void setDamageAbstract(String damageAbstract) {
		this.damageAbstract = damageAbstract;
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
    
    

}
