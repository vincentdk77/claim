package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCIDANGERCLAIMSD的数据传输对象基类<br>
 */
public class PrplaccidangerclaimsdDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性出险人姓名 */
    private String insuredName = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性出险公司代码 */
    private String companyCode = "";
    /** 属性LOSSDATE */
    private String lossDate = "";
    /** 属性LOSSRESULT */
    private String lossResult = "";
    /** 属性CLAIMAMOUNT */
    private Double claimAmount = 0.00;

    /**
     *  默认构造方法,构造一个默认的PrplaccidangerclaimsdDtoBase对象
     */
    public PrplaccidangerclaimsdDtoBase(){
    }

    /**
     * 设置属性INSUREDNAME
     * @param insuredname 待设置的属性INSUREDNAME的值
     */
    public void setInsuredname(String insuredname){
        this.insuredName = StringUtils.rightTrim(insuredname);
    }

    /**
     * 获取属性INSUREDNAME
     * @return 属性INSUREDNAME的值
     */
    public String getInsuredname(){
        return insuredName;
    }

    /**
     * 设置属性SERIALNO
     * @param serialno 待设置的属性SERIALNO的值
     */
    public void setSerialno(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性SERIALNO
     * @return 属性SERIALNO的值
     */
    public int getSerialno(){
        return serialNo;
    }

    /**
     * 设置属性COMPANYCODE
     * @param companycode 待设置的属性COMPANYCODE的值
     */
    public void setCompanycode(String companycode){
        this.companyCode = StringUtils.rightTrim(companycode);
    }

    /**
     * 获取属性COMPANYCODE
     * @return 属性COMPANYCODE的值
     */
    public String getCompanycode(){
        return companyCode;
    }

    /**
     * 设置属性LOSSDATE
     * @param lossdate 待设置的属性LOSSDATE的值
     */
    public void setLossdate(String lossdate){
        this.lossDate = StringUtils.rightTrim(lossdate);
    }

    /**
     * 获取属性LOSSDATE
     * @return 属性LOSSDATE的值
     */
    public String getLossdate(){
        return lossDate;
    }

    /**
     * 设置属性LOSSRESULT
     * @param lossresult 待设置的属性LOSSRESULT的值
     */
    public void setLossresult(String lossresult){
        this.lossResult = StringUtils.rightTrim(lossresult);
    }

    /**
     * 获取属性LOSSRESULT
     * @return 属性LOSSRESULT的值
     */
    public String getLossresult(){
        return lossResult;
    }

    /**
     * 设置属性CLAIMAMOUNT
     * @param claimamount 待设置的属性CLAIMAMOUNT的值
     */
    public void setClaimamount(Double claimamount){
        this.claimAmount = claimamount;
    }

    /**
     * 获取属性CLAIMAMOUNT
     * @return 属性CLAIMAMOUNT的值
     */
    public Double getClaimamount(){
        return claimAmount;
    }
}
