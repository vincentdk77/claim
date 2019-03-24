package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcarmodel车型代码的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcarModelDtoBase implements Serializable{
    /** 属性车型代码 */
    private String modelCode = "";
    /** 属性速查索引码 */
    private String shortHandCode = "";
    /** 属性车型名称 */
    private String modelName = "";
    /** 属性车系名称 */
    private String carSeriesName = "";
    /** 属性座位数 */
    private int seatCount = 0;
    /** 属性吨位数 */
    private double tonCount = 0d;
    /** 属性生产厂家 */
    private String factory = "";
    /** 属性生产国家代码 */
    private String countryCode = "";
    /** 属性新车购置价格 */
    private double purchasePrice = 0d;
    /** 属性使用险种范围 */
    private String riskScope = "";
    /** 属性启用日期 */
    private DateTime validDate = new DateTime();
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性状态位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcarModelDtoBase对象
     */
    public PrpDcarModelDtoBase(){
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
     * 设置属性速查索引码
     * @param shortHandCode 待设置的属性速查索引码的值
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * 获取属性速查索引码
     * @return 属性速查索引码的值
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * 设置属性车型名称
     * @param modelName 待设置的属性车型名称的值
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * 获取属性车型名称
     * @return 属性车型名称的值
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * 设置属性车系名称
     * @param carSeriesName 待设置的属性车系名称的值
     */
    public void setCarSeriesName(String carSeriesName){
        this.carSeriesName = StringUtils.rightTrim(carSeriesName);
    }

    /**
     * 获取属性车系名称
     * @return 属性车系名称的值
     */
    public String getCarSeriesName(){
        return carSeriesName;
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
     * 设置属性生产厂家
     * @param factory 待设置的属性生产厂家的值
     */
    public void setFactory(String factory){
        this.factory = StringUtils.rightTrim(factory);
    }

    /**
     * 获取属性生产厂家
     * @return 属性生产厂家的值
     */
    public String getFactory(){
        return factory;
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
     * 设置属性新车购置价格
     * @param purchasePrice 待设置的属性新车购置价格的值
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取属性新车购置价格
     * @return 属性新车购置价格的值
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * 设置属性使用险种范围
     * @param riskScope 待设置的属性使用险种范围的值
     */
    public void setRiskScope(String riskScope){
        this.riskScope = StringUtils.rightTrim(riskScope);
    }

    /**
     * 获取属性使用险种范围
     * @return 属性使用险种范围的值
     */
    public String getRiskScope(){
        return riskScope;
    }

    /**
     * 设置属性启用日期
     * @param validDate 待设置的属性启用日期的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性启用日期
     * @return 属性启用日期的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性效力状态
     * @param validStatus 待设置的属性效力状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态
     * @return 属性效力状态的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性状态位
     * @param flag 待设置的属性状态位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性状态位
     * @return 属性状态位的值
     */
    public String getFlag(){
        return flag;
    }
}
