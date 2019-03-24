package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLACCIDANGERCLAIMSD�����ݴ���������<br>
 */
public class PrplaccidangerclaimsdDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Գ��������� */
    private String insuredName = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Գ��չ�˾���� */
    private String companyCode = "";
    /** ����LOSSDATE */
    private String lossDate = "";
    /** ����LOSSRESULT */
    private String lossResult = "";
    /** ����CLAIMAMOUNT */
    private Double claimAmount = 0.00;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplaccidangerclaimsdDtoBase����
     */
    public PrplaccidangerclaimsdDtoBase(){
    }

    /**
     * ��������INSUREDNAME
     * @param insuredname �����õ�����INSUREDNAME��ֵ
     */
    public void setInsuredname(String insuredname){
        this.insuredName = StringUtils.rightTrim(insuredname);
    }

    /**
     * ��ȡ����INSUREDNAME
     * @return ����INSUREDNAME��ֵ
     */
    public String getInsuredname(){
        return insuredName;
    }

    /**
     * ��������SERIALNO
     * @param serialno �����õ�����SERIALNO��ֵ
     */
    public void setSerialno(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����SERIALNO
     * @return ����SERIALNO��ֵ
     */
    public int getSerialno(){
        return serialNo;
    }

    /**
     * ��������COMPANYCODE
     * @param companycode �����õ�����COMPANYCODE��ֵ
     */
    public void setCompanycode(String companycode){
        this.companyCode = StringUtils.rightTrim(companycode);
    }

    /**
     * ��ȡ����COMPANYCODE
     * @return ����COMPANYCODE��ֵ
     */
    public String getCompanycode(){
        return companyCode;
    }

    /**
     * ��������LOSSDATE
     * @param lossdate �����õ�����LOSSDATE��ֵ
     */
    public void setLossdate(String lossdate){
        this.lossDate = StringUtils.rightTrim(lossdate);
    }

    /**
     * ��ȡ����LOSSDATE
     * @return ����LOSSDATE��ֵ
     */
    public String getLossdate(){
        return lossDate;
    }

    /**
     * ��������LOSSRESULT
     * @param lossresult �����õ�����LOSSRESULT��ֵ
     */
    public void setLossresult(String lossresult){
        this.lossResult = StringUtils.rightTrim(lossresult);
    }

    /**
     * ��ȡ����LOSSRESULT
     * @return ����LOSSRESULT��ֵ
     */
    public String getLossresult(){
        return lossResult;
    }

    /**
     * ��������CLAIMAMOUNT
     * @param claimamount �����õ�����CLAIMAMOUNT��ֵ
     */
    public void setClaimamount(Double claimamount){
        this.claimAmount = claimamount;
    }

    /**
     * ��ȡ����CLAIMAMOUNT
     * @return ����CLAIMAMOUNT��ֵ
     */
    public Double getClaimamount(){
        return claimAmount;
    }
}
