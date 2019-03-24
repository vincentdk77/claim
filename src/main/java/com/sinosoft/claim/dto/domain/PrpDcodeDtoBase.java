package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcode通用代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeDtoBase implements Serializable{
    /** 属性代码类型 */
    private String codeType = "";
    /** 属性业务代码 */
    private String codeCode = "";
    /** 属性业务代码中文含义 */
    private String codeCName = "";
    /** 属性业务代码英文含义 */
    private String codeEName = "";
    /** 属性新的业务代码 */
    private String newCodeCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcodeDtoBase对象
     */
    public PrpDcodeDtoBase(){
    }
    public PrpDcodeDtoBase(String codeCode,String codeCName){
    	this.codeCode = codeCode;
    	this.codeCName = codeCName;
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
     * 设置属性业务代码
     * @param codeCode 待设置的属性业务代码的值
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * 获取属性业务代码
     * @return 属性业务代码的值
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * 设置属性业务代码中文含义
     * @param codeCName 待设置的属性业务代码中文含义的值
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * 获取属性业务代码中文含义
     * @return 属性业务代码中文含义的值
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * 设置属性业务代码英文含义
     * @param codeEName 待设置的属性业务代码英文含义的值
     */
    public void setCodeEName(String codeEName){
        this.codeEName = StringUtils.rightTrim(codeEName);
    }

    /**
     * 获取属性业务代码英文含义
     * @return 属性业务代码英文含义的值
     */
    public String getCodeEName(){
        return codeEName;
    }

    /**
     * 设置属性新的业务代码
     * @param newCodeCode 待设置的属性新的业务代码的值
     */
    public void setNewCodeCode(String newCodeCode){
        this.newCodeCode = StringUtils.rightTrim(newCodeCode);
    }

    /**
     * 获取属性新的业务代码
     * @return 属性新的业务代码的值
     */
    public String getNewCodeCode(){
        return newCodeCode;
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
