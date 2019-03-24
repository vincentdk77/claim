package com.sinosoft.claim.webservice;

import java.io.Serializable;
import com.sinosoft.sysframework.common.util.StringUtils;
/**
 * 保单信息表对应javaBean
 * 承保机构、保单号码、被保险人、
 * 行驶证车主、车牌号码、厂型号码、
 * 车架号码、发动机号码、投保日期、投保期限、
 * 使用性质、行驶区域、新车购置价、约定驾驶员
 * 、绝对免赔额、投保险别
 *日期格式均为yyyy-MM-dd
 * 
 */

public class PolicyInfo implements Serializable{
	/** 属性保单号码 */
    private String policyNo = "";
    /** 属性承保代码*/
    private String comCode = "";
    /** 属性承保机构*/
    private String comName = "";
    /** 属性被保险人代码 */
    private String insuredCode = "";
    /** 属性被保险人名称 */
    private String insuredName = "";
    /** 属性车主 */
    private String carOwner = "";
    /** 属性签单日期/投保日期 */
    private String operateDate = "";
    /** 属性终保日期 */
    private String endDate = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性行驶区域代码 */
    private String runAreaCode = "";
    /** 属性行驶区域名称 */
    private String runAreaName = "";
    /** 属性使用性质代码 */
    private String useNatureCode = "";
    /** 属性使用性质名称 */
    private String useNatureName = "";
    /** 属性新车重置价格 */
    private double purchasePrice = 0D;
    /** 属性约定驾驶员、多个以逗号隔开*/
    private String driverName = "";
    /** 属性险别代码、多个以逗号隔开 */
    private String kindCode = "";
    /** 属性险别名称、多个以逗号隔开 */
    private String kindName = "";
    /** 属性免赔额、多个以逗号隔开 */
    private double deductible = 0d;
    /** 属性车牌底色代码 */                        
    private String licenseColorCode = "";      
    /** 属性车辆种类代码 */                    
    private String carKindCode = "";           


    
	/**
     *  默认构造方法,构造一个默认的PolicyInfo对象
     */
    public PolicyInfo(){
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = policyNo;
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性签单日期/投保日期
     * @param operateDate 待设置的属性签单日期/投保日期的值
     */
    public void setOperateDate(String operateDate){
        this.operateDate = operateDate;
    }

    /**
     * 获取属性签单日期/投保日期
     * @return 属性签单日期/投保日期的值
     */
    public String getOperateDate(){
        return operateDate;
    }
    
    /**
     * 设置属性终保日期
     * @param endDate 待设置的属性终保日期的值
     */
    public void setEndDate(String endDate){
        this.endDate = endDate;
    }

    /**
     * 获取属性终保日期
     * @return 属性终保日期的值
     */
    public String getEndDate(){
        return endDate;
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
     * 设置属性承保机构
     * @param comName 待设置的属性承保机构的值
     */
	public void setComName(String comName) {
		this.comName = comName;
	}

	/**
     * 获取属性承保机构名称
     * @return  承保机构名称
     */
	public String getComName() {
		return comName;
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
     * 设置属性车主
     * @param carOwner 待设置的属性车主的值
     */
    public void setCarOwner(String carOwner){
        this.carOwner = StringUtils.rightTrim(carOwner);
    }

    /**
     * 获取属性车主
     * @return 属性车主的值
     */
    public String getCarOwner(){
        return carOwner;
    }

	
	/**
     * 获取属性被保险人名称
     * @return 属性被保险人名称的值
     */
	public String getInsuredName() {
		return insuredName;
	}

	/**
     * 设置属性被保险人名称
     * @param policyNo 待设置的属性被保险人名称的值
     */
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	
	/**
     * 获取属性车牌号码
     * @return 属性车牌号码值
     */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
     * 设置属性车牌号码
     * @param policyNo 待设置的属性车牌号码的值
     */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	/**
     * 设置属性厂牌型号名称
     * @param brandName 待设置的属性厂牌型号名称的值
     */
    public void setBrandName(String brandName){
        this.brandName = StringUtils.rightTrim(brandName);
    }

    /**
     * 获取属性厂牌型号名称
     * @return 属性厂牌型号名称的值
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
     * 设置属性行驶区域代码
     * @param runAreaCode 待设置的属性行驶区域代码的值
     */
    public void setRunAreaCode(String runAreaCode){
        this.runAreaCode = StringUtils.rightTrim(runAreaCode);
    }

    /**
     * 获取属性行驶区域代码
     * @return 属性行驶区域代码的值
     */
    public String getRunAreaCode(){
        return runAreaCode;
    }
    
    /**
     * 设置属性行驶区域名称
     * @param runAreaName 待设置的属性行驶区域名称的值
     */
    public void setRunAreaName(String runAreaName){
        this.runAreaName = StringUtils.rightTrim(runAreaName);
    }

    /**
     * 获取属性行驶区域名称
     * @return 属性行驶区域名称的值
     */
    public String getRunAreaName(){
        return runAreaName;
    }
    
    /**
     * 设置属性使用性质代码
     * @param useNatureCode 待设置的属性使用性质代码的值
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * 获取属性使用性质代码
     * @return 属性使用性质代码的值
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }
    
    /**
     * 设置属性使用性质名称
     * @param useNatureName 待设置的属性使用性质名称的值
     */
    public void setUseNatureName(String useNatureName){
        this.useNatureName = StringUtils.rightTrim(useNatureName);
    }

    /**
     * 获取属性使用性质名称
     * @return 属性使用性质名称的值
     */
    public String getUseNatureName(){
        return useNatureName;
    }
    
    /**
     * 设置属性新车重置价格
     * @param purchasePrice 待设置的属性新车重置价格的值
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取属性新车重置价格
     * @return 属性新车重置价格的值
     */
    public double getPurchasePrice(){
        return purchasePrice;
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
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
    }
    
    /**
     * 设置属性免赔额
     * @param deductible 待设置的属性免赔额的值
     */
    public void setDeductible(double deductible){
        this.deductible = deductible;
    }

    /**
     * 获取属性免赔额
     * @return 属性免赔额的值
     */
    public double getDeductible(){
        return deductible;
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
}
