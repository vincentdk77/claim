package com.sinosoft.servlet.accisd.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCICLAIMINFOSD�����ݴ���������<br>
 */
public class PrpLAcciClaimInfoSDDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����NAME */
    private String name = "";
    /** ����CREDENTIALTYPE */
    private String credentialType = "";
    /** ����CREDENTIALNO */
    private String credentialNo = "";
    /** ����CLAIMNO */
    private String claimNo = "";
    /** ����COMPANYCODE */
    private String companyCode = "";
    /** ����CLAIMDATE */
    private String claimDate = "";
    /** ����LOSSDATE */
    private String lossDate = "";
    /** ����LOSSRESULT */
    private String lossResult = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplacciclaiminfosdDtoBase����
     */
    public PrpLAcciClaimInfoSDDtoBase(){
    }

    /**
     * ��������NAME
     * @param name �����õ�����NAME��ֵ
     */
    public void setName(String name){
        this.name = StringUtils.rightTrim(name);
    }

    /**
     * ��ȡ����NAME
     * @return ����NAME��ֵ
     */
    public String getName(){
        return name;
    }

    /**
     * ��������CREDENTIALTYPE
     * @param credentialtype �����õ�����CREDENTIALTYPE��ֵ
     */
    public void setCredentialType(String credentialtype){
        this.credentialType = StringUtils.rightTrim(credentialtype);
    }

    /**
     * ��ȡ����CREDENTIALTYPE
     * @return ����CREDENTIALTYPE��ֵ
     */
    public String getCredentialType(){
        return credentialType;
    }

    /**
     * ��������CREDENTIALNO
     * @param credentialno �����õ�����CREDENTIALNO��ֵ
     */
    public void setCredentialNo(String credentialno){
        this.credentialNo = StringUtils.rightTrim(credentialno);
    }

    /**
     * ��ȡ����CREDENTIALNO
     * @return ����CREDENTIALNO��ֵ
     */
    public String getCredentialNo(){
        return credentialNo;
    }

    /**
     * ��������CLAIMNO
     * @param claimno �����õ�����CLAIMNO��ֵ
     */
    public void setClaimNo(String claimno){
        this.claimNo = StringUtils.rightTrim(claimno);
    }

    /**
     * ��ȡ����CLAIMNO
     * @return ����CLAIMNO��ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ��������COMPANYCODE
     * @param companycode �����õ�����COMPANYCODE��ֵ
     */
    public void setCompanyCode(String companycode){
        this.companyCode = StringUtils.rightTrim(companycode);
    }

    /**
     * ��ȡ����COMPANYCODE
     * @return ����COMPANYCODE��ֵ
     */
    public String getCompanyCode(){
        return companyCode;
    }

    /**
     * ��������CLAIMDATE
     * @param claimdate �����õ�����CLAIMDATE��ֵ
     */
    public void setClaimDate(String claimdate){
        this.claimDate = StringUtils.rightTrim(claimdate);
    }

    /**
     * ��ȡ����CLAIMDATE
     * @return ����CLAIMDATE��ֵ
     */
    public String getClaimDate(){
        return claimDate;
    }

    /**
     * ��������LOSSDATE
     * @param lossdate �����õ�����LOSSDATE��ֵ
     */
    public void setLossDate(String lossdate){
        this.lossDate = StringUtils.rightTrim(lossdate);
    }

    /**
     * ��ȡ����LOSSDATE
     * @return ����LOSSDATE��ֵ
     */
    public String getLossDate(){
        return lossDate;
    }

    /**
     * ��������LOSSRESULT
     * @param lossresult �����õ�����LOSSRESULT��ֵ
     */
    public void setLossResult(String lossresult){
        this.lossResult = StringUtils.rightTrim(lossresult);
    }

    /**
     * ��ȡ����LOSSRESULT
     * @return ����LOSSRESULT��ֵ
     */
    public String getLossResult(){
        return lossResult;
    }
}
