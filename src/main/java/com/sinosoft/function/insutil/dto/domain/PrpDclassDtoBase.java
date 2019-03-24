package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdclass的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclassDtoBase implements Serializable{
    /** 属性classcode */
    private String classCode = "";
    /** 属性classname */
    private String className = "";
    /** 属性classename */
    private String classEName = "";
    /** 属性accCode */
    private String accCode = "";
    /** 属性newclasscode */
    private String newClassCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDclassDtoBase对象
     */
    public PrpDclassDtoBase(){
    }

    /**
     * 设置属性classcode
     * @param classCode 待设置的属性classcode的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性classcode
     * @return 属性classcode的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性classname
     * @param className 待设置的属性classname的值
     */
    public void setClassName(String className){
        this.className = StringUtils.rightTrim(className);
    }

    /**
     * 获取属性classname
     * @return 属性classname的值
     */
    public String getClassName(){
        return className;
    }

    /**
     * 设置属性classename
     * @param classEName 待设置的属性classename的值
     */
    public void setClassEName(String classEName){
        this.classEName = StringUtils.rightTrim(classEName);
    }

    /**
     * 获取属性classename
     * @return 属性classename的值
     */
    public String getClassEName(){
        return classEName;
    }

    /**
     * 设置属性accCode
     * @param accCode 待设置的属性accCode的值
     */
    public void setAccCode(String accCode){
        this.accCode = StringUtils.rightTrim(accCode);
    }

    /**
     * 获取属性accCode
     * @return 属性accCode的值
     */
    public String getAccCode(){
        return accCode;
    }

    /**
     * 设置属性newclasscode
     * @param newClassCode 待设置的属性newclasscode的值
     */
    public void setNewClassCode(String newClassCode){
        this.newClassCode = StringUtils.rightTrim(newClassCode);
    }

    /**
     * 获取属性newclasscode
     * @return 属性newclasscode的值
     */
    public String getNewClassCode(){
        return newClassCode;
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
