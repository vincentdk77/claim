package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpDrisk险种代码表的数据传输对象基类<br>
 * 创建于 2004-11-09 10:40:47.678<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDriskDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性险种中文名称 */
    private String riskCName = "";
    /** 属性险种英文名称 */
    private String riskEName = "";
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性权限组号代码 */
    private String groupCode = "";
    /** 属性计算保费方式 */
    private double calculator = 0d;
    /** 属性结束日期标志 */
    private String endDateFlag = "";
    /** 属性险种标志 */
    private String riskFlag = "";
    /** 属性起保小时 */
    private double startHour = 0d;
    /** 属性新的险种代码 */
    private String newRiskCode = "";
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性专项代码 */
    private String articleCode = "";
    /** 属性收付费处理标志 */
    private String manageFlag = "";
    /** 属性设置类型 */
    private String settleType = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDriskDtoBase对象
     */
    public PrpDriskDtoBase(){
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
     * 设置属性险种中文名称
     * @param riskCName 待设置的属性险种中文名称的值
     */
    public void setRiskCName(String riskCName){
        this.riskCName = StringUtils.rightTrim(riskCName);
    }

    /**
     * 获取属性险种中文名称
     * @return 属性险种中文名称的值
     */
    public String getRiskCName(){
        return riskCName;
    }

    /**
     * 设置属性险种英文名称
     * @param riskEName 待设置的属性险种英文名称的值
     */
    public void setRiskEName(String riskEName){
        this.riskEName = StringUtils.rightTrim(riskEName);
    }

    /**
     * 获取属性险种英文名称
     * @return 属性险种英文名称的值
     */
    public String getRiskEName(){
        return riskEName;
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
     * 设置属性权限组号代码
     * @param groupCode 待设置的属性权限组号代码的值
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * 获取属性权限组号代码
     * @return 属性权限组号代码的值
     */
    public String getGroupCode(){
        return groupCode;
    }

    /**
     * 设置属性计算保费方式
     * @param calculator 待设置的属性计算保费方式的值
     */
    public void setCalculator(double calculator){
        this.calculator = calculator;
    }

    /**
     * 获取属性计算保费方式
     * @return 属性计算保费方式的值
     */
    public double getCalculator(){
        return calculator;
    }

    /**
     * 设置属性结束日期标志
     * @param endDateFlag 待设置的属性结束日期标志的值
     */
    public void setEndDateFlag(String endDateFlag){
        this.endDateFlag = StringUtils.rightTrim(endDateFlag);
    }

    /**
     * 获取属性结束日期标志
     * @return 属性结束日期标志的值
     */
    public String getEndDateFlag(){
        return endDateFlag;
    }

    /**
     * 设置属性险种标志
     * @param riskFlag 待设置的属性险种标志的值
     */
    public void setRiskFlag(String riskFlag){
        this.riskFlag = StringUtils.rightTrim(riskFlag);
    }

    /**
     * 获取属性险种标志
     * @return 属性险种标志的值
     */
    public String getRiskFlag(){
        return riskFlag;
    }

    /**
     * 设置属性起保小时
     * @param startHour 待设置的属性起保小时的值
     */
    public void setStartHour(double startHour){
        this.startHour = startHour;
    }

    /**
     * 获取属性起保小时
     * @return 属性起保小时的值
     */
    public double getStartHour(){
        return startHour;
    }

    /**
     * 设置属性新的险种代码
     * @param newRiskCode 待设置的属性新的险种代码的值
     */
    public void setNewRiskCode(String newRiskCode){
        this.newRiskCode = StringUtils.rightTrim(newRiskCode);
    }

    /**
     * 获取属性新的险种代码
     * @return 属性新的险种代码的值
     */
    public String getNewRiskCode(){
        return newRiskCode;
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
     * 设置属性专项代码
     * @param articleCode 待设置的属性专项代码的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性专项代码
     * @return 属性专项代码的值
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * 设置属性收付费处理标志
     * @param manageFlag 待设置的属性收付费处理标志的值
     */
    public void setManageFlag(String manageFlag){
        this.manageFlag = StringUtils.rightTrim(manageFlag);
    }

    /**
     * 获取属性收付费处理标志
     * @return 属性收付费处理标志的值
     */
    public String getManageFlag(){
        return manageFlag;
    }

    /**
     * 设置属性设置类型
     * @param settleType 待设置的属性设置类型的值
     */
    public void setSettleType(String settleType){
        this.settleType = StringUtils.rightTrim(settleType);
    }

    /**
     * 获取属性设置类型
     * @return 属性设置类型的值
     */
    public String getSettleType(){
        return settleType;
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
