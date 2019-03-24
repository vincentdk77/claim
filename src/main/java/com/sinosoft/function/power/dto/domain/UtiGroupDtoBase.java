package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是UtiGroup  权限组号表的数据传输对象基类<br>
 * 创建于 2004-11-09 10:40:47.658<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiGroupDtoBase implements Serializable{
    /** 属性权限组号代码 */
    private String groupCode = "";
    /** 属性权限组号名称 */
    private String groupName = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiGroupDtoBase对象
     */
    public UtiGroupDtoBase(){
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
     * 设置属性权限组号名称
     * @param groupName 待设置的属性权限组号名称的值
     */
    public void setGroupName(String groupName){
        this.groupName = StringUtils.rightTrim(groupName);
    }

    /**
     * 获取属性权限组号名称
     * @return 属性权限组号名称的值
     */
    public String getGroupName(){
        return groupName;
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
