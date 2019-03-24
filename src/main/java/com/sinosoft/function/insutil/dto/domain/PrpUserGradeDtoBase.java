package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpusergrade的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUserGradeDtoBase implements Serializable{
    /** 属性usercode */
    private String userCode = "";
    /** 属性groupcode */
    private String groupCode = "";
    /** 属性taskcode */
    private String taskCode = "";
    /** 属性checkcode */
    private String checkCode = "";
    /** 属性value */
    private String value = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpUserGradeDtoBase对象
     */
    public PrpUserGradeDtoBase(){
    }

    /**
     * 设置属性usercode
     * @param userCode 待设置的属性usercode的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性usercode
     * @return 属性usercode的值
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * 设置属性groupcode
     * @param groupCode 待设置的属性groupcode的值
     */
    public void setGroupCode(String groupCode){
        this.groupCode = StringUtils.rightTrim(groupCode);
    }

    /**
     * 获取属性groupcode
     * @return 属性groupcode的值
     */
    public String getGroupCode(){
        return groupCode;
    }

    /**
     * 设置属性taskcode
     * @param taskCode 待设置的属性taskcode的值
     */
    public void setTaskCode(String taskCode){
        this.taskCode = StringUtils.rightTrim(taskCode);
    }

    /**
     * 获取属性taskcode
     * @return 属性taskcode的值
     */
    public String getTaskCode(){
        return taskCode;
    }

    /**
     * 设置属性checkcode
     * @param checkCode 待设置的属性checkcode的值
     */
    public void setCheckCode(String checkCode){
        this.checkCode = StringUtils.rightTrim(checkCode);
    }

    /**
     * 获取属性checkcode
     * @return 属性checkcode的值
     */
    public String getCheckCode(){
        return checkCode;
    }

    /**
     * 设置属性value
     * @param value 待设置的属性value的值
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * 获取属性value
     * @return 属性value的值
     */
    public String getValue(){
        return value;
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
