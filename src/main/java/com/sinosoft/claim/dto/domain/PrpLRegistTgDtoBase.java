package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLregist－报案信息表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLRegistTgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /**报案提交的日期*/
    private DateTime submitDate = new DateTime();
    /**报案提交的时分秒*/
    private String SubmitHour="";
	/**报案受理的时分秒*/
	private String inputHour="";
	/**是否派现场*/
	private String siteFlag="";
	/**出现经过*/
	private String damageDescribe="";
	/**伤情描述*/
	private String woundDescribe="";
	/**损失类型*/
	private String lossType="";
	/**损失程度*/
	private String lossLevel="";
	/**被保险人手机号*/
	private String InsuredMobilePhone="";
	/**被保险人固定电话*/
	private String insuredPhone="";
	/**驾驶员联系电话*/
	private String driverPhone="";
	/**报案人是否被保险人*/
	private String isinsureFlag="";
	/**驾驶员姓名*/
	private String driverName="";
	/**报案人是否驾驶员*/
	private String driverFlag="";
    
    
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性理赔类型 */
    private String lFlag = "";
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性语种 */
    private String language = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性被保险人通讯地址 */
    private String insuredAddress = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车辆种类代码 */
    private String carKindCode = "";
    /** 属性车型代码(车系+车型) */
    private String modelCode = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性车辆已行驶公里数 */
    private double runDistance = 0D;
    /** 属性车辆实际使用年限 */
    private int useYears = 0;
    /** 属性报案日期 */
    private DateTime reportDate = new DateTime();
    /** 属性报案小时 */
    private String reportHour = "";
    /** 属性报案地点 */
    private String reportAddress = "";
    /** 属性报案人 */
    private String reportorName = "";
    /** 属性报案形式 */
    private String reportType = "";
    /** 属性报案人联系电话 */
    private String phoneNumber = "";
    /** 属性联系人 */
    private String linkerName = "";
    /** 属性出险日期起 */
    private DateTime damageStartDate = new DateTime();
    /** 属性出险开始小时 */
    private String damageStartHour = "";
    /** 属性出险日期止 */
    private DateTime damageEndDate = new DateTime();
    /** 属性出险终止小时 */
    private String damageEndHour = "";
    /** 属性出险原因代码 */
    private String damageCode = "";
    /** 属性出险原因说明 */
    private String damageName = "";
    /** 属性事故类型代码(车险) */
    private String damageTypeCode = "";
    /** 属性事故类型说明 */
    private String damageTypeName = "";
    /** 属性是否第一现场 */
    private String firstSiteFlag = "";
    /** 属性出险区域代码 */
    private String damageAreaCode = "";
    /** 属性出险区域名称 */
    private String damageAreaName = "";
    /** 属性出险地点分类 */
    private String damageAddressType = "";
    /** 属性出险地代码 */
    private String addressCode = "";
    /** 属性出险地点 */
    private String damageAddress = "";
    /** 属性出险地点邮政编码 */
    private String damageAreaPostCode = "";
    /** 属性事故处理部门 */
    private String handleUnit = "";
    /** 属性受损标的 */
    private String lossName = "";
    /** 属性受损标的数量 */
    private double lossQuantity = 0D;
    /** 属性数量单位 */
    private String unit = "";
    /** 属性估损币别 */
    private String estiCurrency = "";
    /** 属性估损金额 */
    private double estimateLoss = 0D;
    /** 属性接案员姓名 */
    private String receiverName = "";
    /** 属性经办人代码 */
    private String handlerCode = "";
    /** 属性归属业务员代码 */
    private String handler1Code = "";
    /** 属性业务归属机构代码 */
    private String comCode = "";
    /** 属性计算机输单日期 */
    private DateTime inputDate = new DateTime();
    /** 属性受理标志(Y/N) */
    private String acceptFlag = "";
    /** 属性是否向别的保险公司投保(Y/N) */
    private String repeatInsureFlag = "";
    /** 属性赔案类别 */
    private String claimType = "";
    /** 属性注销/拒赔日期 */
    private DateTime cancelDate = new DateTime();
    /** 属性注销/拒赔人代码 */
    private String dealerCode = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性理赔登记机构 */
    private String makeCom = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性报案人电话 */
    private String reportorPhoneNumber = "";
    /** 属性联系人邮编 */
    private String linkerPostCode = "";
    /** 属性联系人通讯地址 */
    private String linkerAddress = "";
    /** 属性未决赔款准备金 */
    private double estimateFee = 0D;
    /** 属性巨灾一级代码 */
    private String catastropheCode1 = "";
    /** 属性巨灾一级名称 */
    private String catastropheName1 = "";
    /** 属性巨灾二级代码 */
    private String catastropheCode2 = "";
    /** 属性巨灾二级名称 */
    private String catastropheName2 = "";
    /** 属性报案标志 */
    private String reportFlag = "";
    /** 属性事故责任类型 */
    private String indemnityDuty = "";
    private String damageArea = "";
    /** 属性迟报案标志 */
    private String lateRegistFlag = "";
    /** 属性迟报案原因 */
    private String lateRegistReason = "";

	/**
     *  默认构造方法,构造一个默认的PrpLregistDtoBase对象
     */
    public PrpLRegistTgDtoBase(){
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
     * 设置属性理赔类型
     * @param lFlag 待设置的属性理赔类型的值
     */
    public void setLFlag(String lFlag){
        this.lFlag = StringUtils.rightTrim(lFlag);
    }

    /**
     * 获取属性理赔类型
     * @return 属性理赔类型的值
     */
    public String getLFlag(){
        return lFlag;
    }

    /**
     * 设置属性险类代码
     * @param classCode 待设置的属性险类代码的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性险类代码
     * @return 属性险类代码的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }
    
    public String getDriverFlag() {
		return driverFlag;
	}

	public void setDriverFlag(String driverFlag) {
		this.driverFlag = driverFlag;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getIsinsureFlag() {
		return isinsureFlag;
	}

	public void setIsinsureFlag(String isinsureFlag) {
		this.isinsureFlag = isinsureFlag;
	}

	public String getDriverPhone() {
		return driverPhone;
	}

	public void setDriverPhone(String driverPhone) {
		this.driverPhone = driverPhone;
	}

	public String getInsuredPhone() {
		return insuredPhone;
	}

	public void setInsuredPhone(String insuredPhone) {
		this.insuredPhone = insuredPhone;
	}

	public String getInsuredMobilePhone() {
		return InsuredMobilePhone;
	}

	public void setInsuredMobilePhone(String insuredMobilePhone) {
		this.InsuredMobilePhone = insuredMobilePhone;
	}

	public String getLossLevel() {
		return lossLevel;
	}

	public void setLossLevel(String lossLevel) {
		this.lossLevel = lossLevel;
	}

	public String getLossType() {
		return lossType;
	}

	public void setLossType(String lossType) {
		this.lossType = lossType;
	}

	public String getWoundDescribe() {
		return woundDescribe;
	}

	public void setWoundDescribe(String woundDescribe) {
		this.woundDescribe = woundDescribe;
	}

	public String getDamageDescribe() {
		return damageDescribe;
	}

	public void setDamageDescribe(String damageDescribe) {
		this.damageDescribe = damageDescribe;
	}

	public String getSiteFlag() {
		return siteFlag;
	}

	public void setSiteFlag(String siteFlag) {
		this.siteFlag = siteFlag;
	}

	public String getInputHour() {
		return inputHour;
	}

	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
	}

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性语种
     * @param language 待设置的属性语种的值
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * 获取属性语种
     * @return 属性语种的值
     */
    public String getLanguage(){
        return language;
    }

    /**
     * 设置属性被保险人代码
     * @param insuredCode 待设置的属性被保险人代码的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性被保险人代码
     * @return 属性被保险人代码的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性被保险人名称
     * @param insuredName 待设置的属性被保险人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性被保险人名称
     * @return 属性被保险人名称的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性被保险人通讯地址
     * @param insuredAddress 待设置的属性被保险人通讯地址的值
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * 获取属性被保险人通讯地址
     * @return 属性被保险人通讯地址的值
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * 设置属性条款类别
     * @param clauseType 待设置的属性条款类别的值
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * 获取属性条款类别
     * @return 属性条款类别的值
     */
    public String getClauseType(){
        return clauseType;
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
     * 设置属性车辆种类代码
     * @param carKindCode 待设置的属性车辆种类代码的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类代码
     * @return 属性车辆种类代码的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }

    /**
     * 设置属性车型代码(车系+车型)
     * @param modelCode 待设置的属性车型代码(车系+车型)的值
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * 获取属性车型代码(车系+车型)
     * @return 属性车型代码(车系+车型)的值
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * 设置属性厂牌型号
     * @param brandName 待设置的属性厂牌型号的值
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * 获取属性厂牌型号
     * @return 属性厂牌型号的值
     */
    public String getBrandName(){
        return brandName;
    }

    /**
     * 设置属性发动机号
     * @param engineNo 待设置的属性发动机号的值
     */
    public void setEngineNo(String engineNo){
        this.engineNo = StringUtils.rightTrim(engineNo);
    }

    /**
     * 获取属性发动机号
     * @return 属性发动机号的值
     */
    public String getEngineNo(){
        return engineNo;
    }

    /**
     * 设置属性车架号
     * @param frameNo 待设置的属性车架号的值
     */
    public void setFrameNo(String frameNo){
        this.frameNo = StringUtils.rightTrim(frameNo);
    }

    /**
     * 获取属性车架号
     * @return 属性车架号的值
     */
    public String getFrameNo(){
        return frameNo;
    }

    /**
     * 设置属性车辆已行驶公里数
     * @param runDistance 待设置的属性车辆已行驶公里数的值
     */
    public void setRunDistance(double runDistance){
        this.runDistance = runDistance;
    }

    /**
     * 获取属性车辆已行驶公里数
     * @return 属性车辆已行驶公里数的值
     */
    public double getRunDistance(){
        return runDistance;
    }

    /**
     * 设置属性车辆实际使用年限
     * @param useYears 待设置的属性车辆实际使用年限的值
     */
    public void setUseYears(int useYears){
        this.useYears = useYears;
    }

    /**
     * 获取属性车辆实际使用年限
     * @return 属性车辆实际使用年限的值
     */
    public int getUseYears(){
        return useYears;
    }

    /**
     * 设置属性报案日期
     * @param reportDate 待设置的属性报案日期的值
     */
    public void setReportDate(DateTime reportDate){
        this.reportDate = reportDate;
    }

    /**
     * 获取属性报案日期
     * @return 属性报案日期的值
     */
    public DateTime getReportDate(){
        return reportDate;
    }

    /**
     * 设置属性报案小时
     * @param reportHour 待设置的属性报案小时的值
     */
    public void setReportHour(String reportHour){
        this.reportHour = StringUtils.rightTrim(reportHour);
    }

    /**
     * 获取属性报案小时
     * @return 属性报案小时的值
     */
    public String getReportHour(){
        return reportHour;
    }

    /**
     * 设置属性报案地点
     * @param reportAddress 待设置的属性报案地点的值
     */
    public void setReportAddress(String reportAddress){
        this.reportAddress = StringUtils.rightTrim(reportAddress);
    }

    /**
     * 获取属性报案地点
     * @return 属性报案地点的值
     */
    public String getReportAddress(){
        return reportAddress;
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
     * 设置属性报案形式
     * @param reportType 待设置的属性报案形式的值
     */
    public void setReportType(String reportType){
        this.reportType = StringUtils.rightTrim(reportType);
    }

    /**
     * 获取属性报案形式
     * @return 属性报案形式的值
     */
    public String getReportType(){
        return reportType;
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
     * 设置属性出险日期起
     * @param damageStartDate 待设置的属性出险日期起的值
     */
    public void setDamageStartDate(DateTime damageStartDate){
        this.damageStartDate = damageStartDate;
    }

    /**
     * 获取属性出险日期起
     * @return 属性出险日期起的值
     */
    public DateTime getDamageStartDate(){
        return damageStartDate;
    }

    /**
     * 设置属性出险开始小时
     * @param damageStartHour 待设置的属性出险开始小时的值
     */
    public void setDamageStartHour(String damageStartHour){
        this.damageStartHour = StringUtils.rightTrim(damageStartHour);
    }

    /**
     * 获取属性出险开始小时
     * @return 属性出险开始小时的值
     */
    public String getDamageStartHour(){
        return damageStartHour;
    }

    /**
     * 设置属性出险日期止
     * @param damageEndDate 待设置的属性出险日期止的值
     */
    public void setDamageEndDate(DateTime damageEndDate){
        this.damageEndDate = damageEndDate;
    }

    /**
     * 获取属性出险日期止
     * @return 属性出险日期止的值
     */
    public DateTime getDamageEndDate(){
        return damageEndDate;
    }

    /**
     * 设置属性出险终止小时
     * @param damageEndHour 待设置的属性出险终止小时的值
     */
    public void setDamageEndHour(String damageEndHour){
        this.damageEndHour = StringUtils.rightTrim(damageEndHour);
    }

    /**
     * 获取属性出险终止小时
     * @return 属性出险终止小时的值
     */
    public String getDamageEndHour(){
        return damageEndHour;
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
     * 设置属性出险地点分类
     * @param damageAddressType 待设置的属性出险地点分类的值
     */
    public void setDamageAddressType(String damageAddressType){
        this.damageAddressType = StringUtils.rightTrim(damageAddressType);
    }

    /**
     * 获取属性出险地点分类
     * @return 属性出险地点分类的值
     */
    public String getDamageAddressType(){
        return damageAddressType;
    }

    /**
     * 设置属性出险地代码
     * @param addressCode 待设置的属性出险地代码的值
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * 获取属性出险地代码
     * @return 属性出险地代码的值
     */
    public String getAddressCode(){
        return addressCode;
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
     * 设置属性出险地点邮政编码
     * @param damageAreaPostCode 待设置的属性出险地点邮政编码的值
     */
    public void setDamageAreaPostCode(String damageAreaPostCode){
        this.damageAreaPostCode = StringUtils.rightTrim(damageAreaPostCode);
    }

    /**
     * 获取属性出险地点邮政编码
     * @return 属性出险地点邮政编码的值
     */
    public String getDamageAreaPostCode(){
        return damageAreaPostCode;
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
     * 设置属性受损标的
     * @param lossName 待设置的属性受损标的的值
     */
    public void setLossName(String lossName){
        this.lossName = StringUtils.rightTrim(lossName);
    }

    /**
     * 获取属性受损标的
     * @return 属性受损标的的值
     */
    public String getLossName(){
        return lossName;
    }

    /**
     * 设置属性受损标的数量
     * @param lossQuantity 待设置的属性受损标的数量的值
     */
    public void setLossQuantity(double lossQuantity){
        this.lossQuantity = lossQuantity;
    }

    /**
     * 获取属性受损标的数量
     * @return 属性受损标的数量的值
     */
    public double getLossQuantity(){
        return lossQuantity;
    }

    /**
     * 设置属性数量单位
     * @param unit 待设置的属性数量单位的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性数量单位
     * @return 属性数量单位的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性估损币别
     * @param estiCurrency 待设置的属性估损币别的值
     */
    public void setEstiCurrency(String estiCurrency){
        this.estiCurrency = StringUtils.rightTrim(estiCurrency);
    }

    /**
     * 获取属性估损币别
     * @return 属性估损币别的值
     */
    public String getEstiCurrency(){
        return estiCurrency;
    }

    /**
     * 设置属性估损金额
     * @param estimateLoss 待设置的属性估损金额的值
     */
    public void setEstimateLoss(double estimateLoss){
        this.estimateLoss = estimateLoss;
    }

    /**
     * 获取属性估损金额
     * @return 属性估损金额的值
     */
    public double getEstimateLoss(){
        return estimateLoss;
    }

    /**
     * 设置属性接案员姓名
     * @param receiverName 待设置的属性接案员姓名的值
     */
    public void setReceiverName(String receiverName){
        this.receiverName = StringUtils.rightTrim(receiverName);
    }

    /**
     * 获取属性接案员姓名
     * @return 属性接案员姓名的值
     */
    public String getReceiverName(){
        return receiverName;
    }

    /**
     * 设置属性经办人代码
     * @param handlerCode 待设置的属性经办人代码的值
     */
    public void setHandlerCode(String handlerCode){
        this.handlerCode = StringUtils.rightTrim(handlerCode);
    }

    /**
     * 获取属性经办人代码
     * @return 属性经办人代码的值
     */
    public String getHandlerCode(){
        return handlerCode;
    }

    /**
     * 设置属性归属业务员代码
     * @param handler1Code 待设置的属性归属业务员代码的值
     */
    public void setHandler1Code(String handler1Code){
        this.handler1Code = StringUtils.rightTrim(handler1Code);
    }

    /**
     * 获取属性归属业务员代码
     * @return 属性归属业务员代码的值
     */
    public String getHandler1Code(){
        return handler1Code;
    }

    /**
     * 设置属性业务归属机构代码
     * @param comCode 待设置的属性业务归属机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性业务归属机构代码
     * @return 属性业务归属机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性计算机输单日期
     * @param inputDate 待设置的属性计算机输单日期的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性计算机输单日期
     * @return 属性计算机输单日期的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性受理标志(Y/N)
     * @param acceptFlag 待设置的属性受理标志(Y/N)的值
     */
    public void setAcceptFlag(String acceptFlag){
        this.acceptFlag = StringUtils.rightTrim(acceptFlag);
    }

    /**
     * 获取属性受理标志(Y/N)
     * @return 属性受理标志(Y/N)的值
     */
    public String getAcceptFlag(){
        return acceptFlag;
    }

    /**
     * 设置属性是否向别的保险公司投保(Y/N)
     * @param repeatInsureFlag 待设置的属性是否向别的保险公司投保(Y/N)的值
     */
    public void setRepeatInsureFlag(String repeatInsureFlag){
        this.repeatInsureFlag = StringUtils.rightTrim(repeatInsureFlag);
    }

    /**
     * 获取属性是否向别的保险公司投保(Y/N)
     * @return 属性是否向别的保险公司投保(Y/N)的值
     */
    public String getRepeatInsureFlag(){
        return repeatInsureFlag;
    }

    /**
     * 设置属性赔案类别
     * @param claimType 待设置的属性赔案类别的值
     */
    public void setClaimType(String claimType){
        this.claimType = StringUtils.rightTrim(claimType);
    }

    /**
     * 获取属性赔案类别
     * @return 属性赔案类别的值
     */
    public String getClaimType(){
        return claimType;
    }

    /**
     * 设置属性注销/拒赔日期
     * @param cancelDate 待设置的属性注销/拒赔日期的值
     */
    public void setCancelDate(DateTime cancelDate){
        this.cancelDate = cancelDate;
    }

    /**
     * 获取属性注销/拒赔日期
     * @return 属性注销/拒赔日期的值
     */
    public DateTime getCancelDate(){
        return cancelDate;
    }

    /**
     * 设置属性注销/拒赔人代码
     * @param dealerCode 待设置的属性注销/拒赔人代码的值
     */
    public void setDealerCode(String dealerCode){
        this.dealerCode = StringUtils.rightTrim(dealerCode);
    }

    /**
     * 获取属性注销/拒赔人代码
     * @return 属性注销/拒赔人代码的值
     */
    public String getDealerCode(){
        return dealerCode;
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
     * 设置属性理赔登记机构
     * @param makeCom 待设置的属性理赔登记机构的值
     */
    public void setMakeCom(String makeCom){
        this.makeCom = StringUtils.rightTrim(makeCom);
    }

    /**
     * 获取属性理赔登记机构
     * @return 属性理赔登记机构的值
     */
    public String getMakeCom(){
        return makeCom;
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
     * 设置属性报案人电话
     * @param reportorPhoneNumber 待设置的属性报案人电话的值
     */
    public void setReportorPhoneNumber(String reportorPhoneNumber){
        this.reportorPhoneNumber = StringUtils.rightTrim(reportorPhoneNumber);
    }

    /**
     * 获取属性报案人电话
     * @return 属性报案人电话的值
     */
    public String getReportorPhoneNumber(){
        return reportorPhoneNumber;
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
     * 设置属性未决赔款准备金
     * @param estimateFee 待设置的属性未决赔款准备金的值
     */
    public void setEstimateFee(double estimateFee){
        this.estimateFee = estimateFee;
    }

    /**
     * 获取属性未决赔款准备金
     * @return 属性未决赔款准备金的值
     */
    public double getEstimateFee(){
        return estimateFee;
    }

    /**
     * 设置属性巨灾一级代码
     * @param catastropheCode1 待设置的属性巨灾一级代码的值
     */
    public void setCatastropheCode1(String catastropheCode1){
        this.catastropheCode1 = StringUtils.rightTrim(catastropheCode1);
    }

    /**
     * 获取属性巨灾一级代码
     * @return 属性巨灾一级代码的值
     */
    public String getCatastropheCode1(){
        return catastropheCode1;
    }

    /**
     * 设置属性巨灾一级名称
     * @param catastropheName1 待设置的属性巨灾一级名称的值
     */
    public void setCatastropheName1(String catastropheName1){
        this.catastropheName1 = StringUtils.rightTrim(catastropheName1);
    }

    /**
     * 获取属性巨灾一级名称
     * @return 属性巨灾一级名称的值
     */
    public String getCatastropheName1(){
        return catastropheName1;
    }

    /**
     * 设置属性巨灾二级代码
     * @param catastropheCode2 待设置的属性巨灾二级代码的值
     */
    public void setCatastropheCode2(String catastropheCode2){
        this.catastropheCode2 = StringUtils.rightTrim(catastropheCode2);
    }

    /**
     * 获取属性巨灾二级代码
     * @return 属性巨灾二级代码的值
     */
    public String getCatastropheCode2(){
        return catastropheCode2;
    }

    /**
     * 设置属性巨灾二级名称
     * @param catastropheName2 待设置的属性巨灾二级名称的值
     */
    public void setCatastropheName2(String catastropheName2){
        this.catastropheName2 = StringUtils.rightTrim(catastropheName2);
    }

    /**
     * 获取属性巨灾二级名称
     * @return 属性巨灾二级名称的值
     */
    public String getCatastropheName2(){
        return catastropheName2;
    }

    /**
     * 设置属性报案标志
     * @param reportFlag 待设置的属性报案标志的值
     */
    public void setReportFlag(String reportFlag){
        this.reportFlag = StringUtils.rightTrim(reportFlag);
    }

    /**
     * 获取属性报案标志
     * @return 属性报案标志的值
     */
    public String getReportFlag(){
        return reportFlag;
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

	public DateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(DateTime submitDate) {
		this.submitDate = submitDate;
	}

	public String getSubmitHour() {
		return SubmitHour;
	}

	public void setSubmitHour(String submitHour) {
		this.SubmitHour = submitHour;
	}

	public String getDamageArea() {
		return damageArea;
	}

	public void setDamageArea(String damageArea) {
		this.damageArea = damageArea;
	}

	public String getLateRegistFlag() {
		return lateRegistFlag;
	}

	public void setLateRegistFlag(String lateRegistFlag) {
		this.lateRegistFlag = lateRegistFlag;
	}

	public String getLateRegistReason() {
		return lateRegistReason;
	}

	public void setLateRegistReason(String lateRegistReason) {
		this.lateRegistReason = lateRegistReason;
	}
	
}
