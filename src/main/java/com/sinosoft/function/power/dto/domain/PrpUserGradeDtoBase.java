package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpUserGrade 员工权限表的数据传输对象基类<br>
 * 创建于 2004-11-09 10:40:47.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeDtoBase implements Serializable{
    /** 属性员工代码 */
    private String userCode = "";
    /** 属性权限组号代码 */
    private String groupCode = "";
    /** 属性任务代码 */
    private String taskCode = "";
    /** 属性权限检验代码 */
    private String checkCode = "";
    /** 属性具体取值 */
    private String value = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpUserGradeDtoBase对象
     */
    public PrpUserGradeDtoBase(){
    }

    /**
     * 设置属性员工代码
     * @param userCode 待设置的属性员工代码的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性员工代码
     * @return 属性员工代码的值
     */
    public String getUserCode(){
        return userCode;
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
     * 设置属性具体取值
     * @param value 待设置的属性具体取值的值
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * 获取属性具体取值
     * @return 属性具体取值的值
     */
    public String getValue(){
        return value;
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
