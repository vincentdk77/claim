package com.sinosoft.NXCaseUp.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是CASEFARMER的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class CasefarmerDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性FARMERNAME */
    private String farmername = "";
    /** 属性FARMERIDNUMBER */
    private String farmeridnumber = "";
    /** 属性FARMERPHONE */
    private String farmerphone = "";
    /** 属性INSUREOBIECTNUMBER */
    private double insureobiectnumber = 0D;
    /** 属性LOSSDEGREE */
    private double lossdegree = 0D;
    /** 属性SETTLEAMOUNT */
    private double settleamount = 0D;
    /** 属性SETTLESUMAMOUNT */
    private double settlesumamount = 0D;
    /** 属性SERINO */
    private long serino = 0L;
    /** 属性AFFECTEDAREA */
    private double affectedarea = 0D;
    /** 属性DAMAGEDAREA */
    private double damagedarea = 0D;
    /** 属性LOSSAREA */
    private double lossarea = 0D;
    /** 属性MEASUREMANTUNIT */
    private String measuremantunit = "";
    /** 属性CASENO */
    private String caseno = "";
    /** 属性FARMERIDTYPE */
    private String farmeridtype = "";
    /** 属性SETTLEOBJECTNUMBER */
    private double settleobjectnumber = 0D;
    /** 属性PREPAIDAMOUNT */
    private double prepaidamount = 0D;

    /**
     *  默认构造方法,构造一个默认的CasefarmerDtoBase对象
     */
    public CasefarmerDtoBase(){
    }

    /**
     * 设置属性FARMERNAME
     * @param farmername 待设置的属性FARMERNAME的值
     */
    public void setFarmername(String farmername){
        this.farmername = StringUtils.rightTrim(farmername);
    }

    /**
     * 获取属性FARMERNAME
     * @return 属性FARMERNAME的值
     */
    public String getFarmername(){
        return farmername;
    }

    /**
     * 设置属性FARMERIDNUMBER
     * @param farmeridnumber 待设置的属性FARMERIDNUMBER的值
     */
    public void setFarmeridnumber(String farmeridnumber){
        this.farmeridnumber = StringUtils.rightTrim(farmeridnumber);
    }

    /**
     * 获取属性FARMERIDNUMBER
     * @return 属性FARMERIDNUMBER的值
     */
    public String getFarmeridnumber(){
        return farmeridnumber;
    }

    /**
     * 设置属性FARMERPHONE
     * @param farmerphone 待设置的属性FARMERPHONE的值
     */
    public void setFarmerphone(String farmerphone){
        this.farmerphone = StringUtils.rightTrim(farmerphone);
    }

    /**
     * 获取属性FARMERPHONE
     * @return 属性FARMERPHONE的值
     */
    public String getFarmerphone(){
        return farmerphone;
    }

    /**
     * 设置属性INSUREOBIECTNUMBER
     * @param insureobiectnumber 待设置的属性INSUREOBIECTNUMBER的值
     */
    public void setInsureobiectnumber(double insureobiectnumber){
        this.insureobiectnumber = insureobiectnumber;
    }

    /**
     * 获取属性INSUREOBIECTNUMBER
     * @return 属性INSUREOBIECTNUMBER的值
     */
    public double getInsureobiectnumber(){
        return insureobiectnumber;
    }

    /**
     * 设置属性LOSSDEGREE
     * @param lossdegree 待设置的属性LOSSDEGREE的值
     */
    public void setLossdegree(double lossdegree){
        this.lossdegree = lossdegree;
    }

    /**
     * 获取属性LOSSDEGREE
     * @return 属性LOSSDEGREE的值
     */
    public double getLossdegree(){
        return lossdegree;
    }

    /**
     * 设置属性SETTLEAMOUNT
     * @param settleamount 待设置的属性SETTLEAMOUNT的值
     */
    public void setSettleamount(double settleamount){
        this.settleamount = settleamount;
    }

    /**
     * 获取属性SETTLEAMOUNT
     * @return 属性SETTLEAMOUNT的值
     */
    public double getSettleamount(){
        return settleamount;
    }

    /**
     * 设置属性SETTLESUMAMOUNT
     * @param settlesumamount 待设置的属性SETTLESUMAMOUNT的值
     */
    public void setSettlesumamount(double settlesumamount){
        this.settlesumamount = settlesumamount;
    }

    /**
     * 获取属性SETTLESUMAMOUNT
     * @return 属性SETTLESUMAMOUNT的值
     */
    public double getSettlesumamount(){
        return settlesumamount;
    }

    /**
     * 设置属性SERINO
     * @param serino 待设置的属性SERINO的值
     */
    public void setSerino(long serino){
        this.serino = serino;
    }

    /**
     * 获取属性SERINO
     * @return 属性SERINO的值
     */
    public long getSerino(){
        return serino;
    }

    /**
     * 设置属性AFFECTEDAREA
     * @param affectedarea 待设置的属性AFFECTEDAREA的值
     */
    public void setAffectedarea(double affectedarea){
        this.affectedarea = affectedarea;
    }

    /**
     * 获取属性AFFECTEDAREA
     * @return 属性AFFECTEDAREA的值
     */
    public double getAffectedarea(){
        return affectedarea;
    }

    /**
     * 设置属性DAMAGEDAREA
     * @param damagedarea 待设置的属性DAMAGEDAREA的值
     */
    public void setDamagedarea(double damagedarea){
        this.damagedarea = damagedarea;
    }

    /**
     * 获取属性DAMAGEDAREA
     * @return 属性DAMAGEDAREA的值
     */
    public double getDamagedarea(){
        return damagedarea;
    }

    /**
     * 设置属性LOSSAREA
     * @param lossarea 待设置的属性LOSSAREA的值
     */
    public void setLossarea(double lossarea){
        this.lossarea = lossarea;
    }

    /**
     * 获取属性LOSSAREA
     * @return 属性LOSSAREA的值
     */
    public double getLossarea(){
        return lossarea;
    }

    /**
     * 设置属性MEASUREMANTUNIT
     * @param measuremantunit 待设置的属性MEASUREMANTUNIT的值
     */
    public void setMeasuremantunit(String measuremantunit){
        this.measuremantunit = StringUtils.rightTrim(measuremantunit);
    }

    /**
     * 获取属性MEASUREMANTUNIT
     * @return 属性MEASUREMANTUNIT的值
     */
    public String getMeasuremantunit(){
        return measuremantunit;
    }

    /**
     * 设置属性CASENO
     * @param caseno 待设置的属性CASENO的值
     */
    public void setCaseno(String caseno){
        this.caseno = StringUtils.rightTrim(caseno);
    }

    /**
     * 获取属性CASENO
     * @return 属性CASENO的值
     */
    public String getCaseno(){
        return caseno;
    }

    /**
     * 设置属性FARMERIDTYPE
     * @param farmeridtype 待设置的属性FARMERIDTYPE的值
     */
    public void setFarmeridtype(String farmeridtype){
        this.farmeridtype = StringUtils.rightTrim(farmeridtype);
    }

    /**
     * 获取属性FARMERIDTYPE
     * @return 属性FARMERIDTYPE的值
     */
    public String getFarmeridtype(){
        return farmeridtype;
    }

    /**
     * 设置属性SETTLEOBJECTNUMBER
     * @param settleobjectnumber 待设置的属性SETTLEOBJECTNUMBER的值
     */
    public void setSettleobjectnumber(double settleobjectnumber){
        this.settleobjectnumber = settleobjectnumber;
    }

    /**
     * 获取属性SETTLEOBJECTNUMBER
     * @return 属性SETTLEOBJECTNUMBER的值
     */
    public double getSettleobjectnumber(){
        return settleobjectnumber;
    }

    /**
     * 设置属性PREPAIDAMOUNT
     * @param prepaidamount 待设置的属性PREPAIDAMOUNT的值
     */
    public void setPrepaidamount(double prepaidamount){
        this.prepaidamount = prepaidamount;
    }

    /**
     * 获取属性PREPAIDAMOUNT
     * @return 属性PREPAIDAMOUNT的值
     */
    public double getPrepaidamount(){
        return prepaidamount;
    }
}
