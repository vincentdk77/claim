package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdlimit限额免赔代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDlimitDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性限额/免赔类别代码 */
    private String limitCode = "";
    /** 属性限额/免赔中文名称 */
    private String limitCName = "";
    /** 属性限额/免赔英文名称 */
    private String limitEName = "";
    /** 属性限额/免赔优先级别[0,9] */
    private String limitPriority = "";
    /** 属性标的代码 */
    private String itemCode = "";
    /** 属性投保方式/责任分类 */
    private String modeCode = "";
    /** 属性赔偿限额 */
    private double limitFee = 0d;
    /** 属性险别 */
    private String kindCode = "";
    /** 属性限额之间关系 */
    private String limitRelation = "";
    /** 属性限额之间关系说明 */
    private String limitRelationDesc = "";
    /** 属性新的限额类别代码 */
    private String newLimitCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性限额类别 */
    private String limitFlag = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDlimitDtoBase对象
     */
    public PrpDlimitDtoBase(){
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
     * 设置属性限额/免赔类别代码
     * @param limitCode 待设置的属性限额/免赔类别代码的值
     */
    public void setLimitCode(String limitCode){
        this.limitCode = StringUtils.rightTrim(limitCode);
    }

    /**
     * 获取属性限额/免赔类别代码
     * @return 属性限额/免赔类别代码的值
     */
    public String getLimitCode(){
        return limitCode;
    }

    /**
     * 设置属性限额/免赔中文名称
     * @param limitCName 待设置的属性限额/免赔中文名称的值
     */
    public void setLimitCName(String limitCName){
        this.limitCName = StringUtils.rightTrim(limitCName);
    }

    /**
     * 获取属性限额/免赔中文名称
     * @return 属性限额/免赔中文名称的值
     */
    public String getLimitCName(){
        return limitCName;
    }

    /**
     * 设置属性限额/免赔英文名称
     * @param limitEName 待设置的属性限额/免赔英文名称的值
     */
    public void setLimitEName(String limitEName){
        this.limitEName = StringUtils.rightTrim(limitEName);
    }

    /**
     * 获取属性限额/免赔英文名称
     * @return 属性限额/免赔英文名称的值
     */
    public String getLimitEName(){
        return limitEName;
    }

    /**
     * 设置属性限额/免赔优先级别[0,9]
     * @param limitPriority 待设置的属性限额/免赔优先级别[0,9]的值
     */
    public void setLimitPriority(String limitPriority){
        this.limitPriority = StringUtils.rightTrim(limitPriority);
    }

    /**
     * 获取属性限额/免赔优先级别[0,9]
     * @return 属性限额/免赔优先级别[0,9]的值
     */
    public String getLimitPriority(){
        return limitPriority;
    }

    /**
     * 设置属性标的代码
     * @param itemCode 待设置的属性标的代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的代码
     * @return 属性标的代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性投保方式/责任分类
     * @param modeCode 待设置的属性投保方式/责任分类的值
     */
    public void setModeCode(String modeCode){
        this.modeCode = StringUtils.rightTrim(modeCode);
    }

    /**
     * 获取属性投保方式/责任分类
     * @return 属性投保方式/责任分类的值
     */
    public String getModeCode(){
        return modeCode;
    }

    /**
     * 设置属性赔偿限额
     * @param limitFee 待设置的属性赔偿限额的值
     */
    public void setLimitFee(double limitFee){
        this.limitFee = limitFee;
    }

    /**
     * 获取属性赔偿限额
     * @return 属性赔偿限额的值
     */
    public double getLimitFee(){
        return limitFee;
    }

    /**
     * 设置属性险别
     * @param kindCode 待设置的属性险别的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别
     * @return 属性险别的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性限额之间关系
     * @param limitRelation 待设置的属性限额之间关系的值
     */
    public void setLimitRelation(String limitRelation){
        this.limitRelation = StringUtils.rightTrim(limitRelation);
    }

    /**
     * 获取属性限额之间关系
     * @return 属性限额之间关系的值
     */
    public String getLimitRelation(){
        return limitRelation;
    }

    /**
     * 设置属性限额之间关系说明
     * @param limitRelationDesc 待设置的属性限额之间关系说明的值
     */
    public void setLimitRelationDesc(String limitRelationDesc){
        this.limitRelationDesc = StringUtils.rightTrim(limitRelationDesc);
    }

    /**
     * 获取属性限额之间关系说明
     * @return 属性限额之间关系说明的值
     */
    public String getLimitRelationDesc(){
        return limitRelationDesc;
    }

    /**
     * 设置属性新的限额类别代码
     * @param newLimitCode 待设置的属性新的限额类别代码的值
     */
    public void setNewLimitCode(String newLimitCode){
        this.newLimitCode = StringUtils.rightTrim(newLimitCode);
    }

    /**
     * 获取属性新的限额类别代码
     * @return 属性新的限额类别代码的值
     */
    public String getNewLimitCode(){
        return newLimitCode;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性限额类别
     * @param limitFlag 待设置的属性限额类别的值
     */
    public void setLimitFlag(String limitFlag){
        this.limitFlag = StringUtils.rightTrim(limitFlag);
    }

    /**
     * 获取属性限额类别
     * @return 属性限额类别的值
     */
    public String getLimitFlag(){
        return limitFlag;
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
