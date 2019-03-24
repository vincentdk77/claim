package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utittyrecord登录记录表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyRecordDtoBase implements Serializable{
    /** 属性系统设备号 */
    private String sysTty = "";
    /** 属性操作员 */
    private String userName = "";
    /** 属性网点 */
    private String comCode = "";
    /** 属性年号 */
    private String year = "";
    /** 属性险种 */
    private String riskCode = "";
    /** 属性设备编号 */
    private String ttyCode = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiTtyRecordDtoBase对象
     */
    public UtiTtyRecordDtoBase(){
    }

    /**
     * 设置属性系统设备号
     * @param sysTty 待设置的属性系统设备号的值
     */
    public void setSysTty(String sysTty){
        this.sysTty = StringUtils.rightTrim(sysTty);
    }

    /**
     * 获取属性系统设备号
     * @return 属性系统设备号的值
     */
    public String getSysTty(){
        return sysTty;
    }

    /**
     * 设置属性操作员
     * @param userName 待设置的属性操作员的值
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * 获取属性操作员
     * @return 属性操作员的值
     */
    public String getUserName(){
        return userName;
    }

    /**
     * 设置属性网点
     * @param comCode 待设置的属性网点的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性网点
     * @return 属性网点的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性年号
     * @param year 待设置的属性年号的值
     */
    public void setYear(String year){
        this.year = StringUtils.rightTrim(year);
    }

    /**
     * 获取属性年号
     * @return 属性年号的值
     */
    public String getYear(){
        return year;
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
     * 设置属性设备编号
     * @param ttyCode 待设置的属性设备编号的值
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * 获取属性设备编号
     * @return 属性设备编号的值
     */
    public String getTtyCode(){
        return ttyCode;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
