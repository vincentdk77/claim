package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpddbs的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDdbsDtoBase implements Serializable{
    /** 属性comcode */
    private String comCode = "";
    /** 属性comname */
    private String comName = "";
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性hostname */
    private String hostName = "";
    /** 属性svrname */
    private String svrName = "";
    /** 属性dbsname */
    private String dbsName = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDdbsDtoBase对象
     */
    public PrpDdbsDtoBase(){
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
     * 设置属性riskcode
     * @param riskCode 待设置的属性riskcode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskcode
     * @return 属性riskcode的值
     */
    public String getRiskCode(){
        return riskCode;
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
     * 设置属性svrname
     * @param svrName 待设置的属性svrname的值
     */
    public void setSvrName(String svrName){
        this.svrName = StringUtils.rightTrim(svrName);
    }

    /**
     * 获取属性svrname
     * @return 属性svrname的值
     */
    public String getSvrName(){
        return svrName;
    }

    /**
     * 设置属性dbsname
     * @param dbsName 待设置的属性dbsname的值
     */
    public void setDbsName(String dbsName){
        this.dbsName = StringUtils.rightTrim(dbsName);
    }

    /**
     * 获取属性dbsname
     * @return 属性dbsname的值
     */
    public String getDbsName(){
        return dbsName;
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
