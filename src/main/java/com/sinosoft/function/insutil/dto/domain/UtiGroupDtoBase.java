package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utigroup的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiGroupDtoBase implements Serializable{
    /** 属性groupcode */
    private String groupCode = "";
    /** 属性groupname */
    private String groupName = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiGroupDtoBase对象
     */
    public UtiGroupDtoBase(){
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
     * 设置属性groupname
     * @param groupName 待设置的属性groupname的值
     */
    public void setGroupName(String groupName){
        this.groupName = StringUtils.rightTrim(groupName);
    }

    /**
     * 获取属性groupname
     * @return 属性groupname的值
     */
    public String getGroupName(){
        return groupName;
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
