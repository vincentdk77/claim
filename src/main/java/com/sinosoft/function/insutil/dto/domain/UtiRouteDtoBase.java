package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utiroute的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiRouteDtoBase implements Serializable{
    /** 属性comcode */
    private String comCode = "";
    /** 属性comname */
    private String comName = "";
    /** 属性hostname */
    private String hostName = "";
    /** 属性ipaddress */
    private String iPAddress = "";
    /** 属性servername */
    private String serverName = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiRouteDtoBase对象
     */
    public UtiRouteDtoBase(){
    }

    /**
     * 设置属性comcode
     * @param comCode 待设置的属性comcode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comcode
     * @return 属性comcode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性comname
     * @param comName 待设置的属性comname的值
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * 获取属性comname
     * @return 属性comname的值
     */
    public String getComName(){
        return comName;
    }

    /**
     * 设置属性hostname
     * @param hostName 待设置的属性hostname的值
     */
    public void setHostName(String hostName){
        this.hostName = StringUtils.rightTrim(hostName);
    }

    /**
     * 获取属性hostname
     * @return 属性hostname的值
     */
    public String getHostName(){
        return hostName;
    }

    /**
     * 设置属性ipaddress
     * @param iPAddress 待设置的属性ipaddress的值
     */
    public void setIPAddress(String iPAddress){
        this.iPAddress = StringUtils.rightTrim(iPAddress);
    }

    /**
     * 获取属性ipaddress
     * @return 属性ipaddress的值
     */
    public String getIPAddress(){
        return iPAddress;
    }

    /**
     * 设置属性servername
     * @param serverName 待设置的属性servername的值
     */
    public void setServerName(String serverName){
        this.serverName = StringUtils.rightTrim(serverName);
    }

    /**
     * 获取属性servername
     * @return 属性servername的值
     */
    public String getServerName(){
        return serverName;
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
