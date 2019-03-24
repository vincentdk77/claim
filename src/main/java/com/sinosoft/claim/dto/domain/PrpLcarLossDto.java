package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcarLoss定损车辆表的数据传输对象类<br>
 * 创建于 2004-07-19 14:23:54.158<br>
 * JToolpad(1.2.12-RC8) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLcarLossDto extends PrpLcarLossDtoBase implements Serializable{
    /**
     *  默认构造方法,构造一个默认的PrpLcarLossDto对象
     */
    public PrpLcarLossDto(){
    }
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性号牌种类代码 */
    private String carKindCode = "";
    /** 属性号牌种类名称 */
    private String carKindName = ""; 
    /** 车型代码 */
    private String modelCode = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性是否为本保单车辆 */
    private String insureCarFlag = "";
    /** 属性是否为本保单车辆 */
    private String insureCarFlagName = "";
    /** 属性承保公司代码 */
    private String insureComCode = "";
    /** 属性承保公司名称 */
    private String insureComName = "";
    /** 属性VIN号 */
    private String vINNo = "";
    /**修理厂类型 **/
    private String repairFactoryCode = "";
    /**修理厂名称 **/
    private String repairFactoryName = "";
    /**
     * 设置属性VIN号
     * @param vINNo 待设置的属性VIN号的值
     */
    public void setVINNo(String vINNo){
        this.vINNo = StringUtils.rightTrim(vINNo);
    }

    /**
     * 获取属性VIN号
     * @return 属性VIN号的值
     */
    public String getVINNo(){
        return vINNo;
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
     * 设置属性是否为本保单车辆
     * @param insureCarFlag 待设置的属性是否为本保单车辆的值
     */
    public void setInsureCarFlag(String insureCarFlag){
        this.insureCarFlag = StringUtils.rightTrim(insureCarFlag);
    }

    /**
     * 获取属性是否为本保单车辆
     * @return 属性是否为本保单车辆的值
     */
    public String getInsureCarFlag(){
        return insureCarFlag;
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
     * 设置属性车型代码
     * @param modelCode 待设置的属性车型代码的值
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * 获取属性车型代码
     * @return 属性车型代码的值
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
     * 设置属性号牌种类代码
     * @param carKindCode 待设置的属性号牌种类代码的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性号牌种类代码
     * @return 属性号牌种类代码的值
     */
    public String getCarKindCode(){
        return carKindCode;
    }
    
    /**
     * 设置属性车牌底色代码
     * @param licenseColorCode 待设置的属性车牌底色代码的值
     */
    public void setLicenseColorCode(String licenseColorCode){
        this.licenseColorCode = StringUtils.rightTrim(licenseColorCode);
    }
    
    /**
     * 设置属性是否为本保单车辆
     * @param insureCarFlagName 属性是否为本保单车辆
     */
    public void setInsureCarFlagName(String insureCarFlagName) {
      this.insureCarFlagName = insureCarFlagName;
    }

    /**
     * 设置属性号牌种类名称
     * @param carKindName 属性号牌种类名称
     */  
    public void setCarKindName(String carKindName) {
      this.carKindName = carKindName;
    }

   /**
     * 获取属性车牌底色代码
     * @return 属性车牌底色代码的值
     */
    public String getLicenseColorCode(){
        return licenseColorCode;
    }
  
   /**
     * 获取属性是否为本保单车辆
     * @return 属性是否为本保单车辆
     */
    public String getInsureCarFlagName() {
      return insureCarFlagName;
    }
  
   /**
     * 获取属性号牌种类名称
     * @return 属性号牌种类名称
     */
    public String getCarKindName() {
      return carKindName;
    }

/**
 * 获取属性 repairFactoryCode
 * @return the repairFactoryCode
 */
public String getRepairFactoryCode() {
	return repairFactoryCode;
}

/**
 * 设置属性 repairFactoryCode
 * @param repairFactoryCode the repairFactoryCode to set
 */
public void setRepairFactoryCode(String repairFactoryCode) {
	this.repairFactoryCode = repairFactoryCode;
}

/**
 * 获取属性 repairFactoryName
 * @return the repairFactoryName
 */
public String getRepairFactoryName() {
	return repairFactoryName;
}

/**
 * 设置属性 repairFactoryName
 * @param repairFactoryName the repairFactoryName to set
 */
public void setRepairFactoryName(String repairFactoryName) {
	this.repairFactoryName = repairFactoryName;
}

    
}
