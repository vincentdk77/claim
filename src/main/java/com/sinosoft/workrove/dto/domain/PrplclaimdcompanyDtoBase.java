package com.sinosoft.workrove.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLCLAIMDCOMPANY的数据传输对象基类<br>
 */
public class PrplclaimdcompanyDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性NODETYPE */
    private String nodetype = "";
    /** 属性COMCODE */
    private String comcode = "";
    /** 属性COMNAME */
    private String comname = "";
    /** 属性UPPERCOMCODE */
    private String uppercomcode = "";
    /** 属性LIMITFLAG */
    private String limitflag = "";
    /** 属性SCHEDULECOMFLAG */
    private String schedulecomflag = "";
    /** 属性MONEYLIMIT */
    private double moneylimit = 0D;
    /** 属性ISCOMMIT */
    private String iscommit = "";

    /**
     *  默认构造方法,构造一个默认的PrplclaimdcompanyDtoBase对象
     */
    public PrplclaimdcompanyDtoBase(){
    }

    /**
     * 设置属性NODETYPE
     * @param nodetype 待设置的属性NODETYPE的值
     */
    public void setNodetype(String nodetype){
        this.nodetype = StringUtils.rightTrim(nodetype);
    }

    /**
     * 获取属性NODETYPE
     * @return 属性NODETYPE的值
     */
    public String getNodetype(){
        return nodetype;
    }

    /**
     * 设置属性COMCODE
     * @param comcode 待设置的属性COMCODE的值
     */
    public void setComcode(String comcode){
        this.comcode = StringUtils.rightTrim(comcode);
    }

    /**
     * 获取属性COMCODE
     * @return 属性COMCODE的值
     */
    public String getComcode(){
        return comcode;
    }

    /**
     * 设置属性COMNAME
     * @param comname 待设置的属性COMNAME的值
     */
    public void setComname(String comname){
        this.comname = StringUtils.rightTrim(comname);
    }

    /**
     * 获取属性COMNAME
     * @return 属性COMNAME的值
     */
    public String getComname(){
        return comname;
    }

    /**
     * 设置属性UPPERCOMCODE
     * @param uppercomcode 待设置的属性UPPERCOMCODE的值
     */
    public void setUppercomcode(String uppercomcode){
        this.uppercomcode = StringUtils.rightTrim(uppercomcode);
    }

    /**
     * 获取属性UPPERCOMCODE
     * @return 属性UPPERCOMCODE的值
     */
    public String getUppercomcode(){
        return uppercomcode;
    }

    /**
     * 设置属性LIMITFLAG
     * @param limitflag 待设置的属性LIMITFLAG的值
     */
    public void setLimitflag(String limitflag){
        this.limitflag = StringUtils.rightTrim(limitflag);
    }

    /**
     * 获取属性LIMITFLAG
     * @return 属性LIMITFLAG的值
     */
    public String getLimitflag(){
        return limitflag;
    }

    /**
     * 设置属性SCHEDULECOMFLAG
     * @param schedulecomflag 待设置的属性SCHEDULECOMFLAG的值
     */
    public void setSchedulecomflag(String schedulecomflag){
        this.schedulecomflag = StringUtils.rightTrim(schedulecomflag);
    }

    /**
     * 获取属性SCHEDULECOMFLAG
     * @return 属性SCHEDULECOMFLAG的值
     */
    public String getSchedulecomflag(){
        return schedulecomflag;
    }

    /**
     * 设置属性MONEYLIMIT
     * @param moneylimit 待设置的属性MONEYLIMIT的值
     */
    public void setMoneylimit(double moneylimit){
        this.moneylimit = moneylimit;
    }

    /**
     * 获取属性MONEYLIMIT
     * @return 属性MONEYLIMIT的值
     */
    public double getMoneylimit(){
        return moneylimit;
    }

    /**
     * 设置属性ISCOMMIT
     * @param iscommit 待设置的属性ISCOMMIT的值
     */
    public void setIscommit(String iscommit){
        this.iscommit = StringUtils.rightTrim(iscommit);
    }

    /**
     * 获取属性ISCOMMIT
     * @return 属性ISCOMMIT的值
     */
    public String getIscommit(){
        return iscommit;
    }
}
