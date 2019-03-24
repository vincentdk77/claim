package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdrate标准费率表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDrateDtoBase implements Serializable{
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性机构代码 */
    private String comCode = "";
    /** 属性占用性质 */
    private String possessNature = "";
    /** 属性行业代码 */
    private String businessSource = "";
    /** 属性营业性质代码 */
    private String businessDetail = "";
    /** 属性标的项目代码 */
    private String itemCode = "";
    /** 属性标的项目名称 */
    private String itemName = "";
    /** 属性承保年限 */
    private int years = 0;
    /** 属性上年度营业额 */
    private double preturnOver = 0d;
    /** 属性限额类型 */
    private String limitType = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性赔偿限额下限 */
    private double limitFeeLower = 0d;
    /** 属性赔偿限额上限 */
    private double limitFeeUpper = 0d;
    /** 属性基础费率下限 */
    private double baseRateLower = 0d;
    /** 属性基础费率上限 */
    private double baseRateUpper = 0d;
    /** 属性费率比率 */
    private double rateRatio = 0d;
    /** 属性保费 */
    private double premium = 0d;
    /** 属性费率代码 */
    private String rateCode = "";
    /** 属性启用日期 */
    private DateTime validDate = new DateTime();
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性状态位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDrateDtoBase对象
     */
    public PrpDrateDtoBase(){
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

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性机构代码
     * @param comCode 待设置的属性机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性机构代码
     * @return 属性机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性占用性质
     * @param possessNature 待设置的属性占用性质的值
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * 获取属性占用性质
     * @return 属性占用性质的值
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * 设置属性行业代码
     * @param businessSource 待设置的属性行业代码的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性行业代码
     * @return 属性行业代码的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性营业性质代码
     * @param businessDetail 待设置的属性营业性质代码的值
     */
    public void setBusinessDetail(String businessDetail){
        this.businessDetail = StringUtils.rightTrim(businessDetail);
    }

    /**
     * 获取属性营业性质代码
     * @return 属性营业性质代码的值
     */
    public String getBusinessDetail(){
        return businessDetail;
    }

    /**
     * 设置属性标的项目代码
     * @param itemCode 待设置的属性标的项目代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的项目代码
     * @return 属性标的项目代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性标的项目名称
     * @param itemName 待设置的属性标的项目名称的值
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * 获取属性标的项目名称
     * @return 属性标的项目名称的值
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * 设置属性承保年限
     * @param years 待设置的属性承保年限的值
     */
    public void setYears(int years){
        this.years = years;
    }

    /**
     * 获取属性承保年限
     * @return 属性承保年限的值
     */
    public int getYears(){
        return years;
    }

    /**
     * 设置属性上年度营业额
     * @param preturnOver 待设置的属性上年度营业额的值
     */
    public void setPreturnOver(double preturnOver){
        this.preturnOver = preturnOver;
    }

    /**
     * 获取属性上年度营业额
     * @return 属性上年度营业额的值
     */
    public double getPreturnOver(){
        return preturnOver;
    }

    /**
     * 设置属性限额类型
     * @param limitType 待设置的属性限额类型的值
     */
    public void setLimitType(String limitType){
        this.limitType = StringUtils.rightTrim(limitType);
    }

    /**
     * 获取属性限额类型
     * @return 属性限额类型的值
     */
    public String getLimitType(){
        return limitType;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性赔偿限额下限
     * @param limitFeeLower 待设置的属性赔偿限额下限的值
     */
    public void setLimitFeeLower(double limitFeeLower){
        this.limitFeeLower = limitFeeLower;
    }

    /**
     * 获取属性赔偿限额下限
     * @return 属性赔偿限额下限的值
     */
    public double getLimitFeeLower(){
        return limitFeeLower;
    }

    /**
     * 设置属性赔偿限额上限
     * @param limitFeeUpper 待设置的属性赔偿限额上限的值
     */
    public void setLimitFeeUpper(double limitFeeUpper){
        this.limitFeeUpper = limitFeeUpper;
    }

    /**
     * 获取属性赔偿限额上限
     * @return 属性赔偿限额上限的值
     */
    public double getLimitFeeUpper(){
        return limitFeeUpper;
    }

    /**
     * 设置属性基础费率下限
     * @param baseRateLower 待设置的属性基础费率下限的值
     */
    public void setBaseRateLower(double baseRateLower){
        this.baseRateLower = baseRateLower;
    }

    /**
     * 获取属性基础费率下限
     * @return 属性基础费率下限的值
     */
    public double getBaseRateLower(){
        return baseRateLower;
    }

    /**
     * 设置属性基础费率上限
     * @param baseRateUpper 待设置的属性基础费率上限的值
     */
    public void setBaseRateUpper(double baseRateUpper){
        this.baseRateUpper = baseRateUpper;
    }

    /**
     * 获取属性基础费率上限
     * @return 属性基础费率上限的值
     */
    public double getBaseRateUpper(){
        return baseRateUpper;
    }

    /**
     * 设置属性费率比率
     * @param rateRatio 待设置的属性费率比率的值
     */
    public void setRateRatio(double rateRatio){
        this.rateRatio = rateRatio;
    }

    /**
     * 获取属性费率比率
     * @return 属性费率比率的值
     */
    public double getRateRatio(){
        return rateRatio;
    }

    /**
     * 设置属性保费
     * @param premium 待设置的属性保费的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性保费
     * @return 属性保费的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性费率代码
     * @param rateCode 待设置的属性费率代码的值
     */
    public void setRateCode(String rateCode){
        this.rateCode = StringUtils.rightTrim(rateCode);
    }

    /**
     * 获取属性费率代码
     * @return 属性费率代码的值
     */
    public String getRateCode(){
        return rateCode;
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
