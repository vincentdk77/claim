package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是utittycode终端属性记录表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyCodeDtoBase implements Serializable{
    /** 属性终端序号 */
    private String ttyCode = "";
    /** 属性系统分配的终端号 */
    private String sysTty = "";
    /** 属性终端类型 */
    private String ttyType = "";
    /** 属性终端名称 */
    private String ttyName = "";
    /** 属性打印机类型 */
    private String prtType = "";
    /** 属性打印机名称 */
    private String prtName = "";
    /** 属性打印模式（A/T/L） */
    private String prtMode = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的UtiTtyCodeDtoBase对象
     */
    public UtiTtyCodeDtoBase(){
    }

    /**
     * 设置属性终端序号
     * @param ttyCode 待设置的属性终端序号的值
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * 获取属性终端序号
     * @return 属性终端序号的值
     */
    public String getTtyCode(){
        return ttyCode;
    }

    /**
     * 设置属性系统分配的终端号
     * @param sysTty 待设置的属性系统分配的终端号的值
     */
    public void setSysTty(String sysTty){
        this.sysTty = StringUtils.rightTrim(sysTty);
    }

    /**
     * 获取属性系统分配的终端号
     * @return 属性系统分配的终端号的值
     */
    public String getSysTty(){
        return sysTty;
    }

    /**
     * 设置属性终端类型
     * @param ttyType 待设置的属性终端类型的值
     */
    public void setTtyType(String ttyType){
        this.ttyType = StringUtils.rightTrim(ttyType);
    }

    /**
     * 获取属性终端类型
     * @return 属性终端类型的值
     */
    public String getTtyType(){
        return ttyType;
    }

    /**
     * 设置属性终端名称
     * @param ttyName 待设置的属性终端名称的值
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * 获取属性终端名称
     * @return 属性终端名称的值
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * 设置属性打印机类型
     * @param prtType 待设置的属性打印机类型的值
     */
    public void setPrtType(String prtType){
        this.prtType = StringUtils.rightTrim(prtType);
    }

    /**
     * 获取属性打印机类型
     * @return 属性打印机类型的值
     */
    public String getPrtType(){
        return prtType;
    }

    /**
     * 设置属性打印机名称
     * @param prtName 待设置的属性打印机名称的值
     */
    public void setPrtName(String prtName){
        this.prtName = StringUtils.rightTrim(prtName);
    }

    /**
     * 获取属性打印机名称
     * @return 属性打印机名称的值
     */
    public String getPrtName(){
        return prtName;
    }

    /**
     * 设置属性打印模式（A/T/L）
     * @param prtMode 待设置的属性打印模式（A/T/L）的值
     */
    public void setPrtMode(String prtMode){
        this.prtMode = StringUtils.rightTrim(prtMode);
    }

    /**
     * 获取属性打印模式（A/T/L）
     * @return 属性打印模式（A/T/L）的值
     */
    public String getPrtMode(){
        return prtMode;
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
