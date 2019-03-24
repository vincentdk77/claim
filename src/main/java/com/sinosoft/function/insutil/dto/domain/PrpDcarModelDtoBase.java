package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcarmodel的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcarModelDtoBase implements Serializable{
    /** 属性modelcode */
    private String modelCode = "";
    /** 属性shorthandcode */
    private String shortHandCode = "";
    /** 属性modelname */
    private String modelName = "";
    /** 属性carseriesname */
    private String carSeriesName = "";
    /** 属性seatcount */
    private int seatCount = 0;
    /** 属性toncount */
    private double tonCount = 0d;
    /** 属性factory */
    private String factory = "";
    /** 属性countrycode */
    private String countryCode = "";
    /** 属性purchaseprice */
    private double purchasePrice = 0d;
    /** 属性riskscope */
    private String riskScope = "";
    /** 属性validdate */
    private DateTime validDate = new DateTime();
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcarModelDtoBase对象
     */
    public PrpDcarModelDtoBase(){
    }

    /**
     * 设置属性modelcode
     * @param modelCode 待设置的属性modelcode的值
     */
    public void setModelCode(String modelCode){
        this.modelCode = StringUtils.rightTrim(modelCode);
    }

    /**
     * 获取属性modelcode
     * @return 属性modelcode的值
     */
    public String getModelCode(){
        return modelCode;
    }

    /**
     * 设置属性shorthandcode
     * @param shortHandCode 待设置的属性shorthandcode的值
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * 获取属性shorthandcode
     * @return 属性shorthandcode的值
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * 设置属性modelname
     * @param modelName 待设置的属性modelname的值
     */
    public void setModelName(String modelName){
        this.modelName = StringUtils.rightTrim(modelName);
    }

    /**
     * 获取属性modelname
     * @return 属性modelname的值
     */
    public String getModelName(){
        return modelName;
    }

    /**
     * 设置属性carseriesname
     * @param carSeriesName 待设置的属性carseriesname的值
     */
    public void setCarSeriesName(String carSeriesName){
        this.carSeriesName = StringUtils.rightTrim(carSeriesName);
    }

    /**
     * 获取属性carseriesname
     * @return 属性carseriesname的值
     */
    public String getCarSeriesName(){
        return carSeriesName;
    }

    /**
     * 设置属性seatcount
     * @param seatCount 待设置的属性seatcount的值
     */
    public void setSeatCount(int seatCount){
        this.seatCount = seatCount;
    }

    /**
     * 获取属性seatcount
     * @return 属性seatcount的值
     */
    public int getSeatCount(){
        return seatCount;
    }

    /**
     * 设置属性toncount
     * @param tonCount 待设置的属性toncount的值
     */
    public void setTonCount(double tonCount){
        this.tonCount = tonCount;
    }

    /**
     * 获取属性toncount
     * @return 属性toncount的值
     */
    public double getTonCount(){
        return tonCount;
    }

    /**
     * 设置属性factory
     * @param factory 待设置的属性factory的值
     */
    public void setFactory(String factory){
        this.factory = StringUtils.rightTrim(factory);
    }

    /**
     * 获取属性factory
     * @return 属性factory的值
     */
    public String getFactory(){
        return factory;
    }

    /**
     * 设置属性countrycode
     * @param countryCode 待设置的属性countrycode的值
     */
    public void setCountryCode(String countryCode){
        this.countryCode = StringUtils.rightTrim(countryCode);
    }

    /**
     * 获取属性countrycode
     * @return 属性countrycode的值
     */
    public String getCountryCode(){
        return countryCode;
    }

    /**
     * 设置属性purchaseprice
     * @param purchasePrice 待设置的属性purchaseprice的值
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取属性purchaseprice
     * @return 属性purchaseprice的值
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * 设置属性riskscope
     * @param riskScope 待设置的属性riskscope的值
     */
    public void setRiskScope(String riskScope){
        this.riskScope = StringUtils.rightTrim(riskScope);
    }

    /**
     * 获取属性riskscope
     * @return 属性riskscope的值
     */
    public String getRiskScope(){
        return riskScope;
    }

    /**
     * 设置属性validdate
     * @param validDate 待设置的属性validdate的值
     */
    public void setValidDate(DateTime validDate){
        this.validDate = validDate;
    }

    /**
     * 获取属性validdate
     * @return 属性validdate的值
     */
    public DateTime getValidDate(){
        return validDate;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
