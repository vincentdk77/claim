package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpCitemCar-机动车险标的信息的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpCitemCarDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性标的序号 */
    private long itemNo = 0L;
    /** 属性保户类别代码 */
    private String insuredTypeCode = "";
    /** 属性被保险人与车辆关系 */
    private String carInsuredRelation = "";
    /** 属性车主 */
    private String carOwner = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性是否约定驾驶员标志 */
    private String agreeDriverFlag = "";
    /** 属性是否投保新增设备标志 */
    private String newDeviceFlag = "";
    /** 属性车险保单号 */
    private String carPolicyno = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车辆种类代码 */
    private String carKindCode = "";
    /** 属性是否港澳车标志 */
    private String hKFlag = "";
    /** 属性港澳车牌号码 */
    private String hKLicenseNo = "";
    /** 属性发动机号 */
    private String engineNo = "";
    /** 属性VIN号 */
    private String vINNo = "";
    /** 属性车架号 */
    private String frameNo = "";
    /** 属性行驶区域代码 */
    private String runAreaCode = "";
    /** 属性行驶区域名称 */
    private String runAreaName = "";
    /** 属性行驶里程(公里) */
    private double runMiles = 0D;
    /** 属性初登日期 */
    private DateTime enrollDate = new DateTime();
    /** 属性使用年限 */
    private int useYears = 0;
    /** 属性车型代码 */
    private String modelCode = "";
    /** 属性厂牌型号名称 */
    private String brandName = "";
    /** 属性国别性质 */
    private String countryNature = "";
    /** 属性生产国家代码 */
    private String countryCode = "";
    /** 属性使用性质代码 */
    private String useNatureCode = "";
    /** 属性营业性质分类代码 */
    private String businessClassCode = "";
    /** 属性座位数 */
    private long seatCount = 0L;
    /** 属性吨位数 */
    private double tonCount = 0D;
    /** 属性排量 */
    private double exhaustScale = 0D;
    /** 属性车身颜色代码 */
    private String colorCode = "";
    /** 属性安全配置 */
    private String safeDevice = "";
    /** 属性固定停放地点 */
    private String parkSite = "";
    /** 属性购车人地址 */
    private String ownerAddress = "";
    /** 属性其他性质 */
    private String otherNature = "";
    /** 属性费率号次 */
    private String rateCode = "";
    /** 属性生产日期 */
    private DateTime makeDate = new DateTime();
    /** 属性购车用途 */
    private String carUsage = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性新车重置价格 */
    private double purchasePrice = 0D;
    /** 属性实际价值 */
    private double actualValue = 0D;
    /** 属性购车发票号 */
    private String invoiceNo = "";
    /** 属性是否在我公司投保信用或保证保险 */
    private String carLoanFlag = "";
    /** 属性承保公司代码 */
    private String insurerCode = "";
    /** 属性上期承保公司 */
    private String lastInsurer = "";
    /** 属性验车情况 */
    private String carCheckStatus = "";
    /** 属性验车人 */
    private String carChecker = "";
    /** 属性验车时间 */
    private String carCheckTime = "";
    /** 属性无赔款优待 */
    private double specialTreat = 0D;
    /** 属性救助区域 */
    private String relievingAreaCode = "";
    /** 属性附加险数量 */
    private long addonCount = 0L;
    /** 属性经销商代码 */
    private String carDealerCode = "";
    /** 属性经销商名称 */
    private String carDealerName = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";
    /** 属性CarCheckReason */
    private String carCheckReason = "";
    /** 属性SvioLatedTimes */
    private long svioLatedTimes = 0L;
    /** 属性LvioLatedTimes */
    private long lvioLatedTimes = 0L;
    /** 属性LicenseKindCode */
    private String licenseKindCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpCitemCarDtoBase对象
     */
    public PrpCitemCarDtoBase(){
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
     * 设置属性标的序号
     * @param itemNo 待设置的属性标的序号的值
     */
    public void setItemNo(long itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public long getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性保户类别代码
     * @param insuredTypeCode 待设置的属性保户类别代码的值
     */
    public void setInsuredTypeCode(String insuredTypeCode){
        this.insuredTypeCode = StringUtils.rightTrim(insuredTypeCode);
    }

    /**
     * 获取属性保户类别代码
     * @return 属性保户类别代码的值
     */
    public String getInsuredTypeCode(){
        return insuredTypeCode;
    }

    /**
     * 设置属性被保险人与车辆关系
     * @param carInsuredRelation 待设置的属性被保险人与车辆关系的值
     */
    public void setCarInsuredRelation(String carInsuredRelation){
        this.carInsuredRelation = StringUtils.rightTrim(carInsuredRelation);
    }

    /**
     * 获取属性被保险人与车辆关系
     * @return 属性被保险人与车辆关系的值
     */
    public String getCarInsuredRelation(){
        return carInsuredRelation;
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
     * 设置属性是否约定驾驶员标志
     * @param agreeDriverFlag 待设置的属性是否约定驾驶员标志的值
     */
    public void setAgreeDriverFlag(String agreeDriverFlag){
        this.agreeDriverFlag = StringUtils.rightTrim(agreeDriverFlag);
    }

    /**
     * 获取属性是否约定驾驶员标志
     * @return 属性是否约定驾驶员标志的值
     */
    public String getAgreeDriverFlag(){
        return agreeDriverFlag;
    }

    /**
     * 设置属性是否投保新增设备标志
     * @param newDeviceFlag 待设置的属性是否投保新增设备标志的值
     */
    public void setNewDeviceFlag(String newDeviceFlag){
        this.newDeviceFlag = StringUtils.rightTrim(newDeviceFlag);
    }

    /**
     * 获取属性是否投保新增设备标志
     * @return 属性是否投保新增设备标志的值
     */
    public String getNewDeviceFlag(){
        return newDeviceFlag;
    }

    /**
     * 设置属性车险保单号
     * @param carPolicyno 待设置的属性车险保单号的值
     */
    public void setCarPolicyno(String carPolicyno){
        this.carPolicyno = StringUtils.rightTrim(carPolicyno);
    }

    /**
     * 获取属性车险保单号
     * @return 属性车险保单号的值
     */
    public String getCarPolicyno(){
        return carPolicyno;
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
     * 设置属性是否港澳车标志
     * @param hKFlag 待设置的属性是否港澳车标志的值
     */
    public void setHKFlag(String hKFlag){
        this.hKFlag = StringUtils.rightTrim(hKFlag);
    }

    /**
     * 获取属性是否港澳车标志
     * @return 属性是否港澳车标志的值
     */
    public String getHKFlag(){
        return hKFlag;
    }

    /**
     * 设置属性港澳车牌号码
     * @param hKLicenseNo 待设置的属性港澳车牌号码的值
     */
    public void setHKLicenseNo(String hKLicenseNo){
        this.hKLicenseNo = StringUtils.rightTrim(hKLicenseNo);
    }

    /**
     * 获取属性港澳车牌号码
     * @return 属性港澳车牌号码的值
     */
    public String getHKLicenseNo(){
        return hKLicenseNo;
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
     * 设置属性行驶里程(公里)
     * @param runMiles 待设置的属性行驶里程(公里)的值
     */
    public void setRunMiles(double runMiles){
        this.runMiles = runMiles;
    }

    /**
     * 获取属性行驶里程(公里)
     * @return 属性行驶里程(公里)的值
     */
    public double getRunMiles(){
        return runMiles;
    }

    /**
     * 设置属性初登日期
     * @param enrollDate 待设置的属性初登日期的值
     */
    public void setEnrollDate(DateTime enrollDate){
        this.enrollDate = enrollDate;
    }

    /**
     * 获取属性初登日期
     * @return 属性初登日期的值
     */
    public DateTime getEnrollDate(){
        return enrollDate;
    }

    /**
     * 设置属性使用年限
     * @param useYears 待设置的属性使用年限的值
     */
    public void setUseYears(int useYears){
        this.useYears = useYears;
    }

    /**
     * 获取属性使用年限
     * @return 属性使用年限的值
     */
    public int getUseYears(){
        return useYears;
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
     * 设置属性国别性质
     * @param countryNature 待设置的属性国别性质的值
     */
    public void setCountryNature(String countryNature){
        this.countryNature = StringUtils.rightTrim(countryNature);
    }

    /**
     * 获取属性国别性质
     * @return 属性国别性质的值
     */
    public String getCountryNature(){
        return countryNature;
    }

    /**
     * 设置属性生产国家代码
     * @param countryCode 待设置的属性生产国家代码的值
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * 获取属性生产国家代码
     * @return 属性生产国家代码的值
     */
    public String getCountryCode(){
        return countryCode;
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
     * 设置属性营业性质分类代码
     * @param businessClassCode 待设置的属性营业性质分类代码的值
     */
    public void setBusinessClassCode(String businessClassCode){
        this.businessClassCode = StringUtils.rightTrim(businessClassCode);
    }

    /**
     * 获取属性营业性质分类代码
     * @return 属性营业性质分类代码的值
     */
    public String getBusinessClassCode(){
        return businessClassCode;
    }

    /**
     * 设置属性座位数
     * @param seatCount 待设置的属性座位数的值
     */
    public void setSeatCount(long seatCount){
        this.seatCount = seatCount;
    }

    /**
     * 获取属性座位数
     * @return 属性座位数的值
     */
    public long getSeatCount(){
        return seatCount;
    }

    /**
     * 设置属性吨位数
     * @param tonCount 待设置的属性吨位数的值
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * 获取属性吨位数
     * @return 属性吨位数的值
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * 设置属性排量
     * @param exhaustScale 待设置的属性排量的值
     */
    public void setExhaustScale(double exhaustScale){
        this.exhaustScale = exhaustScale;
    }

    /**
     * 获取属性排量
     * @return 属性排量的值
     */
    public double getExhaustScale(){
        return exhaustScale;
    }

    /**
     * 设置属性车身颜色代码
     * @param colorCode 待设置的属性车身颜色代码的值
     */
    public void setColorCode(String colorCode){
        this.colorCode = StringUtils.rightTrim(colorCode);
    }

    /**
     * 获取属性车身颜色代码
     * @return 属性车身颜色代码的值
     */
    public String getColorCode(){
        return colorCode;
    }

    /**
     * 设置属性安全配置
     * @param safeDevice 待设置的属性安全配置的值
     */
    public void setSafeDevice(String safeDevice){
        this.safeDevice = StringUtils.rightTrim(safeDevice);
    }

    /**
     * 获取属性安全配置
     * @return 属性安全配置的值
     */
    public String getSafeDevice(){
        return safeDevice;
    }

    /**
     * 设置属性固定停放地点
     * @param parkSite 待设置的属性固定停放地点的值
     */
    public void setParkSite(String parkSite){
        this.parkSite = StringUtils.rightTrim(parkSite);
    }

    /**
     * 获取属性固定停放地点
     * @return 属性固定停放地点的值
     */
    public String getParkSite(){
        return parkSite;
    }

    /**
     * 设置属性购车人地址
     * @param ownerAddress 待设置的属性购车人地址的值
     */
    public void setOwnerAddress(String ownerAddress){
        this.ownerAddress = StringUtils.rightTrim(ownerAddress);
    }

    /**
     * 获取属性购车人地址
     * @return 属性购车人地址的值
     */
    public String getOwnerAddress(){
        return ownerAddress;
    }

    /**
     * 设置属性其他性质
     * @param otherNature 待设置的属性其他性质的值
     */
    public void setOtherNature(String otherNature){
        this.otherNature = StringUtils.rightTrim(otherNature);
    }

    /**
     * 获取属性其他性质
     * @return 属性其他性质的值
     */
    public String getOtherNature(){
        return otherNature;
    }

    /**
     * 设置属性费率号次
     * @param rateCode 待设置的属性费率号次的值
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * 获取属性费率号次
     * @return 属性费率号次的值
     */
    public String getRateCode(){
        return rateCode;
    }

    /**
     * 设置属性生产日期
     * @param makeDate 待设置的属性生产日期的值
     */
    public void setMakeDate(DateTime makeDate){
        this.makeDate = makeDate;
    }

    /**
     * 获取属性生产日期
     * @return 属性生产日期的值
     */
    public DateTime getMakeDate(){
        return makeDate;
    }

    /**
     * 设置属性购车用途
     * @param carUsage 待设置的属性购车用途的值
     */
    public void setCarUsage(String carUsage){
        this.carUsage = StringUtils.rightTrim(carUsage);
    }

    /**
     * 获取属性购车用途
     * @return 属性购车用途的值
     */
    public String getCarUsage(){
        return carUsage;
    }

    /**
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
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
     * 设置属性实际价值
     * @param actualValue 待设置的属性实际价值的值
     */
    public void setActualValue(double actualValue){
        this.actualValue = actualValue;
    }

    /**
     * 获取属性实际价值
     * @return 属性实际价值的值
     */
    public double getActualValue(){
        return actualValue;
    }

    /**
     * 设置属性购车发票号
     * @param invoiceNo 待设置的属性购车发票号的值
     */
    public void setInvoiceNo(String invoiceNo){
        this.invoiceNo = StringUtils.rightTrim(invoiceNo);
    }

    /**
     * 获取属性购车发票号
     * @return 属性购车发票号的值
     */
    public String getInvoiceNo(){
        return invoiceNo;
    }

    /**
     * 设置属性是否在我公司投保信用或保证保险
     * @param carLoanFlag 待设置的属性是否在我公司投保信用或保证保险的值
     */
    public void setCarLoanFlag(String carLoanFlag){
        this.carLoanFlag = StringUtils.rightTrim(carLoanFlag);
    }

    /**
     * 获取属性是否在我公司投保信用或保证保险
     * @return 属性是否在我公司投保信用或保证保险的值
     */
    public String getCarLoanFlag(){
        return carLoanFlag;
    }

    /**
     * 设置属性承保公司代码
     * @param insurerCode 待设置的属性承保公司代码的值
     */
    public void setInsurerCode(String insurerCode){
        this.insurerCode = StringUtils.rightTrim(insurerCode);
    }

    /**
     * 获取属性承保公司代码
     * @return 属性承保公司代码的值
     */
    public String getInsurerCode(){
        return insurerCode;
    }

    /**
     * 设置属性上期承保公司
     * @param lastInsurer 待设置的属性上期承保公司的值
     */
    public void setLastInsurer(String lastInsurer){
        this.lastInsurer = StringUtils.rightTrim(lastInsurer);
    }

    /**
     * 获取属性上期承保公司
     * @return 属性上期承保公司的值
     */
    public String getLastInsurer(){
        return lastInsurer;
    }

    /**
     * 设置属性验车情况
     * @param carCheckStatus 待设置的属性验车情况的值
     */
    public void setCarCheckStatus(String carCheckStatus){
        this.carCheckStatus = StringUtils.rightTrim(carCheckStatus);
    }

    /**
     * 获取属性验车情况
     * @return 属性验车情况的值
     */
    public String getCarCheckStatus(){
        return carCheckStatus;
    }

    /**
     * 设置属性验车人
     * @param carChecker 待设置的属性验车人的值
     */
    public void setCarChecker(String carChecker){
        this.carChecker = StringUtils.rightTrim(carChecker);
    }

    /**
     * 获取属性验车人
     * @return 属性验车人的值
     */
    public String getCarChecker(){
        return carChecker;
    }

    /**
     * 设置属性验车时间
     * @param carCheckTime 待设置的属性验车时间的值
     */
    public void setCarCheckTime(String carCheckTime){
        this.carCheckTime = StringUtils.rightTrim(carCheckTime);
    }

    /**
     * 获取属性验车时间
     * @return 属性验车时间的值
     */
    public String getCarCheckTime(){
        return carCheckTime;
    }

    /**
     * 设置属性无赔款优待
     * @param specialTreat 待设置的属性无赔款优待的值
     */
    public void setSpecialTreat(double specialTreat){
        this.specialTreat = specialTreat;
    }

    /**
     * 获取属性无赔款优待
     * @return 属性无赔款优待的值
     */
    public double getSpecialTreat(){
        return specialTreat;
    }

    /**
     * 设置属性救助区域
     * @param relievingAreaCode 待设置的属性救助区域的值
     */
    public void setRelievingAreaCode(String relievingAreaCode){
        this.relievingAreaCode = StringUtils.rightTrim(relievingAreaCode);
    }

    /**
     * 获取属性救助区域
     * @return 属性救助区域的值
     */
    public String getRelievingAreaCode(){
        return relievingAreaCode;
    }

    /**
     * 设置属性附加险数量
     * @param addonCount 待设置的属性附加险数量的值
     */
    public void setAddonCount(long addonCount){
        this.addonCount = addonCount;
    }

    /**
     * 获取属性附加险数量
     * @return 属性附加险数量的值
     */
    public long getAddonCount(){
        return addonCount;
    }

    /**
     * 设置属性经销商代码
     * @param carDealerCode 待设置的属性经销商代码的值
     */
    public void setCarDealerCode(String carDealerCode){
        this.carDealerCode = StringUtils.rightTrim(carDealerCode);
    }

    /**
     * 获取属性经销商代码
     * @return 属性经销商代码的值
     */
    public String getCarDealerCode(){
        return carDealerCode;
    }

    /**
     * 设置属性经销商名称
     * @param carDealerName 待设置的属性经销商名称的值
     */
    public void setCarDealerName(String carDealerName){
        this.carDealerName = StringUtils.rightTrim(carDealerName);
    }

    /**
     * 获取属性经销商名称
     * @return 属性经销商名称的值
     */
    public String getCarDealerName(){
        return carDealerName;
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

    /**
     * 设置属性CarCheckReason
     * @param carCheckReason 待设置的属性CarCheckReason的值
     */
    public void setCarCheckReason(String carCheckReason){
        this.carCheckReason = StringUtils.rightTrim(carCheckReason);
    }

    /**
     * 获取属性CarCheckReason
     * @return 属性CarCheckReason的值
     */
    public String getCarCheckReason(){
        return carCheckReason;
    }

    /**
     * 设置属性SvioLatedTimes
     * @param svioLatedTimes 待设置的属性SvioLatedTimes的值
     */
    public void setSvioLatedTimes(long svioLatedTimes){
        this.svioLatedTimes = svioLatedTimes;
    }

    /**
     * 获取属性SvioLatedTimes
     * @return 属性SvioLatedTimes的值
     */
    public long getSvioLatedTimes(){
        return svioLatedTimes;
    }

    /**
     * 设置属性LvioLatedTimes
     * @param lvioLatedTimes 待设置的属性LvioLatedTimes的值
     */
    public void setLvioLatedTimes(long lvioLatedTimes){
        this.lvioLatedTimes = lvioLatedTimes;
    }

    /**
     * 获取属性LvioLatedTimes
     * @return 属性LvioLatedTimes的值
     */
    public long getLvioLatedTimes(){
        return lvioLatedTimes;
    }

    /**
     * 设置属性LicenseKindCode
     * @param licenseKindCode 待设置的属性LicenseKindCode的值
     */
    public void setLicenseKindCode(String licenseKindCode){
        this.licenseKindCode = StringUtils.rightTrim(licenseKindCode);
    }

    /**
     * 获取属性LicenseKindCode
     * @return 属性LicenseKindCode的值
     */
    public String getLicenseKindCode(){
        return licenseKindCode;
    }
}
