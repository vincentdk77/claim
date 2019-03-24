package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLCItemCar-代赔保单车辆附表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.640<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLCItemCarDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性报案号 */
    private String registNo = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性被保险人与车辆关系 */
    private String carInsuredRelation = "";
    /** 属性车主 */
    private String carOwner = "";
    /** 属性条款类别 */
    private String clauseType = "";
    /** 属性是否约定驾驶员标志1是/0否 */
    private String agreeDriverFlag = "";
    /** 属性是否投保新增设备标志1是/0否 */
    private String newDeviceFlag = "";
    /** 属性车牌号码 */
    private String licenseNo = "";
    /** 属性车牌底色代码 */
    private String licenseColorCode = "";
    /** 属性车辆种类代码 ▲
--** 客车/货车/客货两用/
--** 摩托车/拖拉机/特种车/… */
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
    private double runMiles = 0d;
    /** 属性初登日期 */
    private DateTime enrollDate = new DateTime();
    /** 属性使用年限 */
    private int useYears = 0;
    /** 属性厂牌型号 */
    private String brandName = "";
    /** 属性使用性质代码--** 公务企业用/家庭自用/… */
    private String useNatureCode = "";
    /** 属性座位数 */
    private int seatCount = 0;
    /** 属性吨位数 */
    private double tonCount = 0d;
    /** 属性排量 */
    private double exhaustScale = 0d;
    /** 属性车身颜色代码 */
    private String colorCode = "";
    /** 属性安全配置--** 可以选择多个代码，用逗号分隔；
--** 安全气囊/ABS/… */
    private String safeDevice = "";
    /** 属性其他性质 [1]：是否有上两年度完整维护保养 记录，1/0：有/无；
--** [2]：上年是否在本公司投保，1/0： 有/无；
--** [3]：投保人是否提供了真实详尽的保单信息, 1/0： 有/无；
--** [4]：优惠给付方式1：单车 2：车队 */
    private String otherNature = "";
    /** 属性费率号次 */
    private String rateCode = "";
    /** 属性固定停放地点 */
    private String parkSite = "";
    /** 属性新车购置价 */
    private double purchasePrice = 0d;
    /** 属性是否在我公司投保信用或保证保险
--** 1是/0否 */
    private String carLoanFlag = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLCItemCarDtoBase对象
     */
    public PrpLCItemCarDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性报案号
     * @param registNo 待设置的属性报案号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号
     * @return 属性报案号的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性是否约定驾驶员标志1是/0否
     * @param agreeDriverFlag 待设置的属性是否约定驾驶员标志1是/0否的值
     */
    public void setAgreeDriverFlag(String agreeDriverFlag){
        this.agreeDriverFlag = StringUtils.rightTrim(agreeDriverFlag);
    }

    /**
     * 获取属性是否约定驾驶员标志1是/0否
     * @return 属性是否约定驾驶员标志1是/0否的值
     */
    public String getAgreeDriverFlag(){
        return agreeDriverFlag;
    }

    /**
     * 设置属性是否投保新增设备标志1是/0否
     * @param newDeviceFlag 待设置的属性是否投保新增设备标志1是/0否的值
     */
    public void setNewDeviceFlag(String newDeviceFlag){
        this.newDeviceFlag = StringUtils.rightTrim(newDeviceFlag);
    }

    /**
     * 获取属性是否投保新增设备标志1是/0否
     * @return 属性是否投保新增设备标志1是/0否的值
     */
    public String getNewDeviceFlag(){
        return newDeviceFlag;
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
     * 设置属性车辆种类代码 ▲
--** 客车/货车/客货两用/
--** 摩托车/拖拉机/特种车/…
     * @param carKindCode 待设置的属性车辆种类代码 ▲
--** 客车/货车/客货两用/
--** 摩托车/拖拉机/特种车/…的值
     */
    public void setCarKindCode(String carKindCode){
        this.carKindCode = StringUtils.rightTrim(carKindCode);
    }

    /**
     * 获取属性车辆种类代码 ▲
--** 客车/货车/客货两用/
--** 摩托车/拖拉机/特种车/…
     * @return 属性车辆种类代码 ▲
--** 客车/货车/客货两用/
--** 摩托车/拖拉机/特种车/…的值
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
     * 设置属性使用性质代码--** 公务企业用/家庭自用/…
     * @param useNatureCode 待设置的属性使用性质代码--** 公务企业用/家庭自用/…的值
     */
    public void setUseNatureCode(String useNatureCode){
        this.useNatureCode = StringUtils.rightTrim(useNatureCode);
    }

    /**
     * 获取属性使用性质代码--** 公务企业用/家庭自用/…
     * @return 属性使用性质代码--** 公务企业用/家庭自用/…的值
     */
    public String getUseNatureCode(){
        return useNatureCode;
    }

    /**
     * 设置属性座位数
     * @param seatCount 待设置的属性座位数的值
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * 获取属性座位数
     * @return 属性座位数的值
     */
    public int getSeatCount(){
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
     * 设置属性安全配置--** 可以选择多个代码，用逗号分隔；
--** 安全气囊/ABS/…
     * @param safeDevice 待设置的属性安全配置--** 可以选择多个代码，用逗号分隔；
--** 安全气囊/ABS/…的值
     */
    public void setSafeDevice(String safeDevice){
        this.safeDevice = StringUtils.rightTrim(safeDevice);
    }

    /**
     * 获取属性安全配置--** 可以选择多个代码，用逗号分隔；
--** 安全气囊/ABS/…
     * @return 属性安全配置--** 可以选择多个代码，用逗号分隔；
--** 安全气囊/ABS/…的值
     */
    public String getSafeDevice(){
        return safeDevice;
    }

    /**
     * 设置属性其他性质 [1]：是否有上两年度完整维护保养 记录，1/0：有/无；
--** [2]：上年是否在本公司投保，1/0： 有/无；
--** [3]：投保人是否提供了真实详尽的保单信息, 1/0： 有/无；
--** [4]：优惠给付方式1：单车 2：车队
     * @param otherNature 待设置的属性其他性质 [1]：是否有上两年度完整维护保养 记录，1/0：有/无；
--** [2]：上年是否在本公司投保，1/0： 有/无；
--** [3]：投保人是否提供了真实详尽的保单信息, 1/0： 有/无；
--** [4]：优惠给付方式1：单车 2：车队的值
     */
    public void setOtherNature(String otherNature){
        this.otherNature = StringUtils.rightTrim(otherNature);
    }

    /**
     * 获取属性其他性质 [1]：是否有上两年度完整维护保养 记录，1/0：有/无；
--** [2]：上年是否在本公司投保，1/0： 有/无；
--** [3]：投保人是否提供了真实详尽的保单信息, 1/0： 有/无；
--** [4]：优惠给付方式1：单车 2：车队
     * @return 属性其他性质 [1]：是否有上两年度完整维护保养 记录，1/0：有/无；
--** [2]：上年是否在本公司投保，1/0： 有/无；
--** [3]：投保人是否提供了真实详尽的保单信息, 1/0： 有/无；
--** [4]：优惠给付方式1：单车 2：车队的值
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
     * 设置属性新车购置价
     * @param purchasePrice 待设置的属性新车购置价的值
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取属性新车购置价
     * @return 属性新车购置价的值
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * 设置属性是否在我公司投保信用或保证保险
--** 1是/0否
     * @param carLoanFlag 待设置的属性是否在我公司投保信用或保证保险
--** 1是/0否的值
     */
    public void setCarLoanFlag(String carLoanFlag){
        this.carLoanFlag = StringUtils.rightTrim(carLoanFlag);
    }

    /**
     * 获取属性是否在我公司投保信用或保证保险
--** 1是/0否
     * @return 属性是否在我公司投保信用或保证保险
--** 1是/0否的值
     */
    public String getCarLoanFlag(){
        return carLoanFlag;
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
}
