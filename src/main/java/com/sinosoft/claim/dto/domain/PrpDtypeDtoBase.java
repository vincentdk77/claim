package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdtype通用代码类表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDtypeDtoBase implements Serializable{
    /** 属性代码类型 */
    private String codeType = "";
    /** 属性代码类型描述 */
    private String codeTypeDesc = "";
    /** 属性新的代码类型 */
    private String newCodeType = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDtypeDtoBase对象
     */
    public PrpDtypeDtoBase(){
    }

    /**
     * 设置属性代码类型
     * @param codeType 待设置的属性代码类型的值
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * 获取属性代码类型
     * @return 属性代码类型的值
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * 设置属性代码类型描述
     * @param codeTypeDesc 待设置的属性代码类型描述的值
     */
    public void setCodeTypeDesc(String codeTypeDesc){
        this.codeTypeDesc = StringUtils.rightTrim(codeTypeDesc);
    }

    /**
     * 获取属性代码类型描述
     * @return 属性代码类型描述的值
     */
    public String getCodeTypeDesc(){
        return codeTypeDesc;
    }

    /**
     * 设置属性新的代码类型
     * @param newCodeType 待设置的属性新的代码类型的值
     */
    public void setNewCodeType(String newCodeType){
        this.newCodeType = StringUtils.rightTrim(newCodeType);
    }

    /**
     * 获取属性新的代码类型
     * @return 属性新的代码类型的值
     */
    public String getNewCodeType(){
        return newCodeType;
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
