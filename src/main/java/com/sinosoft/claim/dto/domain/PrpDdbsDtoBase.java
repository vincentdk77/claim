package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpddbs数据库维护表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdbsDtoBase implements Serializable{
    /** 属性机构代码 */
    private String comCode = "";
    /** 属性机构名称 */
    private String comName = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性主机名称 */
    private String hostName = "";
    /** 属性服务器名称 */
    private String svrName = "";
    /** 属性数据库名 */
    private String dbsName = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDdbsDtoBase对象
     */
    public PrpDdbsDtoBase(){
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
     * 设置属性险种
     * @param riskCode 待设置的属性险种的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种
     * @return 属性险种的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性服务器名称
     * @param svrName 待设置的属性服务器名称的值
     */
    public void setSvrName(String svrName){
        this.svrName = StringUtils.rightTrim(svrName);
    }

    /**
     * 获取属性服务器名称
     * @return 属性服务器名称的值
     */
    public String getSvrName(){
        return svrName;
    }

    /**
     * 设置属性数据库名
     * @param dbsName 待设置的属性数据库名的值
     */
    public void setDbsName(String dbsName){
        this.dbsName = StringUtils.rightTrim(dbsName);
    }

    /**
     * 获取属性数据库名
     * @return 属性数据库名的值
     */
    public String getDbsName(){
        return dbsName;
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
