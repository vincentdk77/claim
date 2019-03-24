package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是EdaUser-座席员信息表的数据传输对象基类<br>
 * 创建于 2005-06-22 14:56:36.573<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdaUserDtoBase implements Serializable{
    /** 属性座席员工号 */
    private String edaUserCode = "";
    /** 属性座席员名称 */
    private String edaUserName = "";
    /** 属性业务系统员工代码 */
    private String userCode = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的EdaUserDtoBase对象
     */
    public EdaUserDtoBase(){
    }

    /**
     * 设置属性座席员工号
     * @param edaUserCode 待设置的属性座席员工号的值
     */
    public void setEdaUserCode(String edaUserCode){
        this.edaUserCode = StringUtils.rightTrim(edaUserCode);
    }

    /**
     * 获取属性座席员工号
     * @return 属性座席员工号的值
     */
    public String getEdaUserCode(){
        return edaUserCode;
    }

    /**
     * 设置属性座席员名称
     * @param edaUserName 待设置的属性座席员名称的值
     */
    public void setEdaUserName(String edaUserName){
        this.edaUserName = StringUtils.rightTrim(edaUserName);
    }

    /**
     * 获取属性座席员名称
     * @return 属性座席员名称的值
     */
    public String getEdaUserName(){
        return edaUserName;
    }

    /**
     * 设置属性业务系统员工代码
     * @param userCode 待设置的属性业务系统员工代码的值
     */
    public void setUserCode(String userCode){
        this.userCode = StringUtils.rightTrim(userCode);
    }

    /**
     * 获取属性业务系统员工代码
     * @return 属性业务系统员工代码的值
     */
    public String getUserCode(){
        return userCode;
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
