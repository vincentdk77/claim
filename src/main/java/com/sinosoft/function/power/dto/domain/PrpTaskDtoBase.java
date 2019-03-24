package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpTask工作任务表的数据传输对象基类<br>
 * 创建于 2004-11-09 10:40:47.668<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpTaskDtoBase implements Serializable{
    /** 属性任务代码 */
    private String taskCode = "";
    /** 属性任务名称 */
    private String taskName = "";
    /** 属性权限检验代码 */
    private String checkCode = "";
    /** 属性权限检验名称 */
    private String checkName = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpTaskDtoBase对象
     */
    public PrpTaskDtoBase(){
    }

    /**
     * 设置属性任务代码
     * @param taskCode 待设置的属性任务代码的值
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * 获取属性任务代码
     * @return 属性任务代码的值
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * 设置属性任务名称
     * @param taskName 待设置的属性任务名称的值
     */
    public void setTaskName(String taskName){
        this.taskName = StringUtils.rightTrim(taskName);
    }

    /**
     * 获取属性任务名称
     * @return 属性任务名称的值
     */
    public String getTaskName(){
        return taskName;
    }

    /**
     * 设置属性权限检验代码
     * @param checkCode 待设置的属性权限检验代码的值
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * 获取属性权限检验代码
     * @return 属性权限检验代码的值
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * 设置属性权限检验名称
     * @param checkName 待设置的属性权限检验名称的值
     */
    public void setCheckName(String checkName){
        this.checkName = StringUtils.rightTrim(checkName);
    }

    /**
     * 获取属性权限检验名称
     * @return 属性权限检验名称的值
     */
    public String getCheckName(){
        return checkName;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
