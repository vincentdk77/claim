package com.sinosoft.servlet.accisd.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLACCICLAIMINFOSD的数据传输对象基类<br>
 */
public class PrpLAcciClaimInfoSDDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性NAME */
    private String name = "";
    /** 属性CREDENTIALTYPE */
    private String credentialType = "";
    /** 属性CREDENTIALNO */
    private String credentialNo = "";
    /** 属性CLAIMNO */
    private String claimNo = "";
    /** 属性COMPANYCODE */
    private String companyCode = "";
    /** 属性CLAIMDATE */
    private String claimDate = "";
    /** 属性LOSSDATE */
    private String lossDate = "";
    /** 属性LOSSRESULT */
    private String lossResult = "";

    /**
     *  默认构造方法,构造一个默认的PrplacciclaiminfosdDtoBase对象
     */
    public PrpLAcciClaimInfoSDDtoBase(){
    }

    /**
     * 设置属性NAME
     * @param name 待设置的属性NAME的值
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * 获取属性NAME
     * @return 属性NAME的值
     */
    public String getName(){
        return name;
    }

    /**
     * 设置属性CREDENTIALTYPE
     * @param credentialtype 待设置的属性CREDENTIALTYPE的值
     */
    public void setCredentialType(String credentialtype){
        this.credentialType = StringUtils.rightTrim(credentialtype);
    }

    /**
     * 获取属性CREDENTIALTYPE
     * @return 属性CREDENTIALTYPE的值
     */
    public String getCredentialType(){
        return credentialType;
    }

    /**
     * 设置属性CREDENTIALNO
     * @param credentialno 待设置的属性CREDENTIALNO的值
     */
    public void setCredentialNo(String credentialno){
        this.credentialNo = StringUtils.rightTrim(credentialno);
    }

    /**
     * 获取属性CREDENTIALNO
     * @return 属性CREDENTIALNO的值
     */
    public String getCredentialNo(){
        return credentialNo;
    }

    /**
     * 设置属性CLAIMNO
     * @param claimno 待设置的属性CLAIMNO的值
     */
    public void setClaimNo(String claimno){
        this.claimNo = StringUtils.rightTrim(claimno);
    }

    /**
     * 获取属性CLAIMNO
     * @return 属性CLAIMNO的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性COMPANYCODE
     * @param companycode 待设置的属性COMPANYCODE的值
     */
    public void setCompanyCode(String companycode){
        this.companyCode = StringUtils.rightTrim(companycode);
    }

    /**
     * 获取属性COMPANYCODE
     * @return 属性COMPANYCODE的值
     */
    public String getCompanyCode(){
        return companyCode;
    }

    /**
     * 设置属性CLAIMDATE
     * @param claimdate 待设置的属性CLAIMDATE的值
     */
    public void setClaimDate(String claimdate){
        this.claimDate = StringUtils.rightTrim(claimdate);
    }

    /**
     * 获取属性CLAIMDATE
     * @return 属性CLAIMDATE的值
     */
    public String getClaimDate(){
        return claimDate;
    }

    /**
     * 设置属性LOSSDATE
     * @param lossdate 待设置的属性LOSSDATE的值
     */
    public void setLossDate(String lossdate){
        this.lossDate = StringUtils.rightTrim(lossdate);
    }

    /**
     * 获取属性LOSSDATE
     * @return 属性LOSSDATE的值
     */
    public String getLossDate(){
        return lossDate;
    }

    /**
     * 设置属性LOSSRESULT
     * @param lossresult 待设置的属性LOSSRESULT的值
     */
    public void setLossResult(String lossresult){
        this.lossResult = StringUtils.rightTrim(lossresult);
    }

    /**
     * 获取属性LOSSRESULT
     * @return 属性LOSSRESULT的值
     */
    public String getLossResult(){
        return lossResult;
    }
}
