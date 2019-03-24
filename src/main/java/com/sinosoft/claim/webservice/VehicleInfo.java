package com.sinosoft.claim.webservice;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 存储车辆信息
 * @author Administrator
 *
 */
public class VehicleInfo implements Serializable {

	/**
	 * 
	 ,损失金额
	 */
	private static final long serialVersionUID = -3292919583910696944L;

    /** 属性报案号码 */
    private String registNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性车牌号 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车辆种类代码 */
    private String carKindCode = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性车型代码(车系+车型) */
    private String modelCode = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性车辆已行驶公里数 */
    private double runDistance = 0d;
    /** 属性车辆实际使用年限 */
    private int useYears = 0;
    /** 属性本车责任比例 */
    private double dutyPercent = 0d;
    /** 属性承保公司代码 */
    private String insureComCode = "";
    /** 属性承保公司名称 */
    private String insureComName = "";
    /** 属性VIN号码 */
    private String vINNo = "";
    /** 属性损失金额 */
    private double lossFee = 0d;
    /** 属性受损标志 */
    private String lossFlag = "";
    /** 属性是三者车驾驶员姓名 */
    private String prpLthirdPartyDriveName = "";
    /** 属性是三者车驾驶员身份征*/
    private String prpLthirdPartyDriveLicensNo = "";
    /** 属性车辆保单号码 */
    private String carPolicyNo = "";
    /**
     *  默认构造方法,构造一个默认的VehicleInfo对象
     */
    public VehicleInfo(){
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
     * 设置属性本车责任比例
     * @param dutyPercent 待设置的属性本车责任比例的值
     */
    public void setDutyPercent(double dutyPercent){
        this.dutyPercent = dutyPercent;
    }

    /**
     * 获取属性本车责任比例
     * @return 属性本车责任比例的值
     */
    public double getDutyPercent(){
        return dutyPercent;
    }

    /**
     * 设置属性承保公司代码
     * @param insureComCode 待设置的属性承保公司代码的值
     */
    public void setInsureComCode(String insureComCode){
        this.insureComCode = StringUtils.rightTrim(insureComCode);
    }

    /**
     * 获取属性承保公司代码
     * @return 属性承保公司代码的值
     */
    public String getInsureComCode(){
        return insureComCode;
    }

    /**
     * 设置属性承保公司名称
     * @param insureComName 待设置的属性承保公司名称的值
     */
    public void setInsureComName(String insureComName){
        this.insureComName = StringUtils.rightTrim(insureComName);
    }

    /**
     * 获取属性承保公司名称
     * @return 属性承保公司名称的值
     */
    public String getInsureComName(){
        return insureComName;
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
     * 设置属性损失金额
     * @param lossFee 待设置的属性损失金额的值
     */
    public void setLossFee(double lossFee){
        this.lossFee = lossFee;
    }

    /**
     * 获取属性损失金额
     * @return 属性损失金额的值
     */
    public double getLossFee(){
        return lossFee;
    }
    
    /**
     * 设置属性LossFlag受损标志
     * @param lossFlag 待设置的属性受损标志的值
     */
    public void setLossFlag(String lossFlag){
        this.lossFlag = StringUtils.rightTrim(lossFlag);
    }

    /**
     * 获取属性LossFlag受损标志
     * @return 属性lossFlag受损标志的值
     */
    public String getLossFlag(){
        return lossFlag;
    }

    /**
     * 获取属性prpLthirdPartyDriveName三者车驾驶员姓名
     * @return 属性prpLthirdPartyDriveName三者车驾驶员姓名的值
     */
    public String getPrpLthirdPartyDriveName() {
		return prpLthirdPartyDriveName;
	}

    /**
     * 设置属性prpLthirdPartyDriveName三者车驾驶员姓名
     * @param prpLthirdPartyDriveName 待设置的属性三者车驾驶员姓名的值
     */
	public void setPrpLthirdPartyDriveName(String prpLthirdPartyDriveName) {
		this.prpLthirdPartyDriveName = prpLthirdPartyDriveName;
	}

    /**
     * 获取属性prpLthirdPartyDriveLicensNo三者车驾驶员身份征
     * @return 属性prpLthirdPartyDriveLicensNo三者车驾驶员身份征的值
     */
	public String getPrpLthirdPartyDriveLicensNo() {
		return prpLthirdPartyDriveLicensNo;
	}

	/**
     * 设置属性prpLthirdPartyDriveLicensNo三者车驾驶员身份征
     * @param prpLthirdPartyDriveLicensNo 待设置的属性三者车驾驶员身份征的值
     */
      
	public void setPrpLthirdPartyDriveLicensNo(
			String prpLthirdPartyDriveLicensNo) {
		this.prpLthirdPartyDriveLicensNo = prpLthirdPartyDriveLicensNo;
	}
    
	/**
	 * 获取属性 carPolicyNo
	 * @return the carPolicyNo
	 */
	public String getCarPolicyNo() {
		return carPolicyNo;
	}

	/**
	 * 设置属性 carPolicyNo
	 * @param carPolicyNo the carPolicyNo to set
	 */
	public void setCarPolicyNo(String carPolicyNo) {
		this.carPolicyNo = carPolicyNo;
	}
    


}
