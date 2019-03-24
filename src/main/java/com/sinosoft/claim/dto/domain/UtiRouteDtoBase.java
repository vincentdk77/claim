package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是UtiRoute路由配置表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:40<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiRouteDtoBase implements Serializable{
    /** 属性机构代码 */
    private String comCode = "";
    /** 属性机构名称 */
    private String comName = "";
    /** 属性主机名称 */
    private String hostName = "";
    /** 属性IP地址 */
    private String iPaddress = "";
    /** 属性服务器名称 */
    private String serverName = "";
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiRouteDtoBase对象
     */
    public UtiRouteDtoBase(){
    }

    /**
     * 设置属性机构代码
     * @param comCode 待设置的属性机构代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性机构代码
     * @return 属性机构代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性机构名称
     * @param comName 待设置的属性机构名称的值
     */
    public void setComName(String comName){
        this.comName = StringUtils.rightTrim(comName);
    }

    /**
     * 获取属性机构名称
     * @return 属性机构名称的值
     */
    public String getComName(){
        return comName;
    }

    /**
     * 设置属性主机名称
     * @param hostName 待设置的属性主机名称的值
     */
    public void setHostName(String hostName){
        this.hostName = StringUtils.rightTrim(hostName);
    }

    /**
     * 获取属性主机名称
     * @return 属性主机名称的值
     */
    public String getHostName(){
        return hostName;
    }

    /**
     * 设置属性IP地址
     * @param iPaddress 待设置的属性IP地址的值
     */
    public void setIPaddress(String iPaddress){
        this.iPaddress = StringUtils.rightTrim(iPaddress);
    }

    /**
     * 获取属性IP地址
     * @return 属性IP地址的值
     */
    public String getIPaddress(){
        return iPaddress;
    }

    /**
     * 设置属性服务器名称
     * @param serverName 待设置的属性服务器名称的值
     */
    public void setServerName(String serverName){
        this.serverName = StringUtils.rightTrim(serverName);
    }

    /**
     * 获取属性服务器名称
     * @return 属性服务器名称的值
     */
    public String getServerName(){
        return serverName;
    }

    /**
     * 设置属性效力状态
     * @param validStatus 待设置的属性效力状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态
     * @return 属性效力状态的值
     */
    public String getValidStatus(){
        return validStatus;
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
