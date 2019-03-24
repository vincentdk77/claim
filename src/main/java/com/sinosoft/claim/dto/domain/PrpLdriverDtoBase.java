package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLdriver-车险驾驶员信息表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.328<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLdriverDtoBase implements Serializable{
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保险单号次 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性车牌号 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性(当班) 驾驶员驾驶证号码 */
    private String drivingLicenseNo = "";
    /** 属性(当班)驾驶员姓名 */
    private String driverName = "";
    /** 属性(当班)驾驶员性别 */
    private String driverSex = "";
    /** 属性(当班)驾驶员年龄 */
    private int driverAge = 0;
    /** 属性(当班) 驾驶员职业 */
    private String driverOccupation = "";
    /** 属性文化程度 */
    private String education = "";
    /** 属性单位地址 */
    private String unitAddress = "";
    /** 属性身份证号码 */
    private String identifyNumber = "";
    /** 属性(当班) 驾驶员等级 */
    private int driverGrade = 0;
    /** 属性(当班) 驾驶员航线 */
    private String driverSeaRoute = "";
    /** 属性(当班) 驾驶员领证时间 */
    private DateTime receiveLicenseDate = new DateTime();
    /** 属性准驾车型 */
    private String drivingCarType = "";
    /** 属性(当班) 驾驶员驾驶年限 */
    private int drivingYear = 0;
    /** 属性颁证机关 */
    private String awardLicenseOrgan = "";
    /** 属性有无高速船舶驾驶培训合格证书(0/1) */
    private String specialCertificate = "";
    /** 属性标志字段 */
    private String flag = "";
    
    private String identifyType="";

    /**
     *  默认构造方法,构造一个默认的PrpLdriverDtoBase对象
     */
    public PrpLdriverDtoBase(){
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
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性保险单号次
     * @param policyNo 待设置的属性保险单号次的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保险单号次
     * @return 属性保险单号次的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * 设置属性车牌号
     * @param licenseNo 待设置的属性车牌号的值
     */
    public void setLicenseNo(String licenseNo){
        this.licenseNo = StringUtils.rightTrim(licenseNo);
    }

    /**
     * 获取属性车牌号
     * @return 属性车牌号的值
     */
    public String getLicenseNo(){
        return licenseNo;
    }

    /**
     * 设置属性车牌底色代码
     * @param licenseColorCode 待设置的属性车牌底色代码的值
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }

    /**
     * 获取属性车牌底色代码
     * @return 属性车牌底色代码的值
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }

    /**
     * 设置属性(当班) 驾驶员驾驶证号码
     * @param drivingLicenseNo 待设置的属性(当班) 驾驶员驾驶证号码的值
     */
    public void setDrivingLicenseNo(String drivingLicenseNo){
        this.drivingLicenseNo = StringUtils.rightTrim(drivingLicenseNo);
    }

    /**
     * 获取属性(当班) 驾驶员驾驶证号码
     * @return 属性(当班) 驾驶员驾驶证号码的值
     */
    public String getDrivingLicenseNo(){
        return drivingLicenseNo;
    }

    /**
     * 设置属性(当班)驾驶员姓名
     * @param driverName 待设置的属性(当班)驾驶员姓名的值
     */
    public void setDriverName(String driverName){
        this.driverName = StringUtils.rightTrim(driverName);
    }

    /**
     * 获取属性(当班)驾驶员姓名
     * @return 属性(当班)驾驶员姓名的值
     */
    public String getDriverName(){
        return driverName;
    }

    /**
     * 设置属性(当班)驾驶员性别
     * @param driverSex 待设置的属性(当班)驾驶员性别的值
     */
    public void setDriverSex(String driverSex){
        this.driverSex = StringUtils.rightTrim(driverSex);
    }

    /**
     * 获取属性(当班)驾驶员性别
     * @return 属性(当班)驾驶员性别的值
     */
    public String getDriverSex(){
        return driverSex;
    }

    /**
     * 设置属性(当班)驾驶员年龄
     * @param driverAge 待设置的属性(当班)驾驶员年龄的值
     */
    public void setDriverAge(int driverAge){
        this.driverAge = driverAge;
    }

    /**
     * 获取属性(当班)驾驶员年龄
     * @return 属性(当班)驾驶员年龄的值
     */
    public int getDriverAge(){
        return driverAge;
    }

    /**
     * 设置属性(当班) 驾驶员职业
     * @param driverOccupation 待设置的属性(当班) 驾驶员职业的值
     */
    public void setDriverOccupation(String driverOccupation){
        this.driverOccupation = StringUtils.rightTrim(driverOccupation);
    }

    /**
     * 获取属性(当班) 驾驶员职业
     * @return 属性(当班) 驾驶员职业的值
     */
    public String getDriverOccupation(){
        return driverOccupation;
    }

    /**
     * 设置属性文化程度
     * @param education 待设置的属性文化程度的值
     */
    public void setEducation(String education){
        this.education = StringUtils.rightTrim(education);
    }

    /**
     * 获取属性文化程度
     * @return 属性文化程度的值
     */
    public String getEducation(){
        return education;
    }

    /**
     * 设置属性单位地址
     * @param unitAddress 待设置的属性单位地址的值
     */
    public void setUnitAddress(String unitAddress){
        this.unitAddress = StringUtils.rightTrim(unitAddress);
    }

    /**
     * 获取属性单位地址
     * @return 属性单位地址的值
     */
    public String getUnitAddress(){
        return unitAddress;
    }

    /**
     * 设置属性身份证号码
     * @param identifyNumber 待设置的属性身份证号码的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性身份证号码
     * @return 属性身份证号码的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性(当班) 驾驶员等级
     * @param driverGrade 待设置的属性(当班) 驾驶员等级的值
     */
    public void setDriverGrade(int driverGrade){
        this.driverGrade = driverGrade;
    }

    /**
     * 获取属性(当班) 驾驶员等级
     * @return 属性(当班) 驾驶员等级的值
     */
    public int getDriverGrade(){
        return driverGrade;
    }

    /**
     * 设置属性(当班) 驾驶员航线
     * @param driverSeaRoute 待设置的属性(当班) 驾驶员航线的值
     */
    public void setDriverSeaRoute(String driverSeaRoute){
        this.driverSeaRoute = StringUtils.rightTrim(driverSeaRoute);
    }

    /**
     * 获取属性(当班) 驾驶员航线
     * @return 属性(当班) 驾驶员航线的值
     */
    public String getDriverSeaRoute(){
        return driverSeaRoute;
    }

    /**
     * 设置属性(当班) 驾驶员领证时间
     * @param receiveLicenseDate 待设置的属性(当班) 驾驶员领证时间的值
     */
    public void setReceiveLicenseDate(DateTime receiveLicenseDate){
        this.receiveLicenseDate = receiveLicenseDate;
    }

    /**
     * 获取属性(当班) 驾驶员领证时间
     * @return 属性(当班) 驾驶员领证时间的值
     */
    public DateTime getReceiveLicenseDate(){
        return receiveLicenseDate;
    }

    /**
     * 设置属性准驾车型
     * @param drivingCarType 待设置的属性准驾车型的值
     */
    public void setDrivingCarType(String drivingCarType){
        this.drivingCarType = StringUtils.rightTrim(drivingCarType);
    }

    /**
     * 获取属性准驾车型
     * @return 属性准驾车型的值
     */
    public String getDrivingCarType(){
        return drivingCarType;
    }

    /**
     * 设置属性(当班) 驾驶员驾驶年限
     * @param drivingYear 待设置的属性(当班) 驾驶员驾驶年限的值
     */
    public void setDrivingYear(int drivingYear){
        this.drivingYear = drivingYear;
    }

    /**
     * 获取属性(当班) 驾驶员驾驶年限
     * @return 属性(当班) 驾驶员驾驶年限的值
     */
    public int getDrivingYear(){
        return drivingYear;
    }

    /**
     * 设置属性颁证机关
     * @param awardLicenseOrgan 待设置的属性颁证机关的值
     */
    public void setAwardLicenseOrgan(String awardLicenseOrgan){
        this.awardLicenseOrgan = StringUtils.rightTrim(awardLicenseOrgan);
    }

    /**
     * 获取属性颁证机关
     * @return 属性颁证机关的值
     */
    public String getAwardLicenseOrgan(){
        return awardLicenseOrgan;
    }

    /**
     * 设置属性有无高速船舶驾驶培训合格证书(0/1)
     * @param specialCertificate 待设置的属性有无高速船舶驾驶培训合格证书(0/1)的值
     */
    public void setSpecialCertificate(String specialCertificate){
        this.specialCertificate = StringUtils.rightTrim(specialCertificate);
    }

    /**
     * 获取属性有无高速船舶驾驶培训合格证书(0/1)
     * @return 属性有无高速船舶驾驶培训合格证书(0/1)的值
     */
    public String getSpecialCertificate(){
        return specialCertificate;
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

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}
}
