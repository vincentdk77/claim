package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLpayObject-支付对象管理表的数据传输对象基类<br>
 * 创建于 2006-08-03 14:43:23.159<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpayObjectDtoBase implements Serializable{
    /** 属性支付对象类型 */
    private String payObjectType = "";
    /** 属性支付对象代码 */
    private String payObjectCode = "";
    /** 属性支付对象名称 */
    private String payObjectName = "";
    /** 属性机构代码 */
    private String comCode = "";
    /** 属性操作员代码 */
    private String operatorCode = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpayObjectDtoBase对象
     */
    public PrpLpayObjectDtoBase(){
    }

    /**
     * 设置属性支付对象类型
     * @param payObjectType 待设置的属性支付对象类型的值
     */
    public void setPayObjectType(String payObjectType){
        this.payObjectType = StringUtils.rightTrim(payObjectType);
    }

    /**
     * 获取属性支付对象类型
     * @return 属性支付对象类型的值
     */
    public String getPayObjectType(){
        return payObjectType;
    }

    /**
     * 设置属性支付对象代码
     * @param payObjectCode 待设置的属性支付对象代码的值
     */
    public void setPayObjectCode(String payObjectCode){
        this.payObjectCode = StringUtils.rightTrim(payObjectCode);
    }

    /**
     * 获取属性支付对象代码
     * @return 属性支付对象代码的值
     */
    public String getPayObjectCode(){
        return payObjectCode;
    }

    /**
     * 设置属性支付对象名称
     * @param payObjectName 待设置的属性支付对象名称的值
     */
    public void setPayObjectName(String payObjectName){
        this.payObjectName = StringUtils.rightTrim(payObjectName);
    }

    /**
     * 获取属性支付对象名称
     * @return 属性支付对象名称的值
     */
    public String getPayObjectName(){
        return payObjectName;
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
     * 设置属性操作员代码
     * @param operatorCode 待设置的属性操作员代码的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性操作员代码
     * @return 属性操作员代码的值
     */
    public String getOperatorCode(){
        return operatorCode;
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
}
