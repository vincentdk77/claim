package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdclass险类代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclassDtoBase implements Serializable{
    /** 属性险类代码 */
    private String classCode = "";
    /** 属性险类名称 */
    private String className = "";
    /** 属性新的险类代码 */
    private String newClassCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDclassDtoBase对象
     */
    public PrpDclassDtoBase(){
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
     * 设置属性险类名称
     * @param className 待设置的属性险类名称的值
     */
    public void setClassName(String className){
        this.className = StringUtils.rightTrim(className);
    }

    /**
     * 获取属性险类名称
     * @return 属性险类名称的值
     */
    public String getClassName(){
        return className;
    }

    /**
     * 设置属性新的险类代码
     * @param newClassCode 待设置的属性新的险类代码的值
     */
    public void setNewClassCode(String newClassCode){
        this.newClassCode = StringUtils.rightTrim(newClassCode);
    }

    /**
     * 获取属性新的险类代码
     * @return 属性新的险类代码的值
     */
    public String getNewClassCode(){
        return newClassCode;
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
