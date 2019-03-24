package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLcheckExt-�鿱/���鿱��չ��(�޸�)�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.281<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckExtDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** �����ⰸ���� */
    private String claimNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���Բ鿱��Ŀ���� */
    private String columnName = "";
    /** ���Բ鿱��Ŀ���� */
    private String displayName = "";
    /** ���������ֶ����� */
    private String columnValue = "";
    /** ���Ա�־ */
    private String flag = "";
    /** ���Թ������⳵����� */
    private int referSerialNo = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcheckExtDtoBase����
     */
    public PrpLcheckExtDtoBase(){
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �����������ִ���
     * @param riskCode �����õ��������ִ����ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ�������ִ���
     * @return �������ִ����ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Բ鿱��Ŀ����
     * @param columnName �����õ����Բ鿱��Ŀ�����ֵ
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * ��ȡ���Բ鿱��Ŀ����
     * @return ���Բ鿱��Ŀ�����ֵ
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * �������Բ鿱��Ŀ����
     * @param displayName �����õ����Բ鿱��Ŀ���Ƶ�ֵ
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * ��ȡ���Բ鿱��Ŀ����
     * @return ���Բ鿱��Ŀ���Ƶ�ֵ
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * �������������ֶ�����
     * @param columnValue �����õ����������ֶ����ݵ�ֵ
     */
    public void setColumnValue(String columnValue){
        this.columnValue = StringUtils.rightTrim(columnValue);
    }

    /**
     * ��ȡ���������ֶ�����
     * @return ���������ֶ����ݵ�ֵ
     */
    public String getColumnValue(){
        return columnValue;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * �������Թ������⳵�����
     * @param referSerialNo �����õ����Թ������⳵����ŵ�ֵ
     */
    public void setReferSerialNo(int referSerialNo){
        this.referSerialNo = referSerialNo;
    }

    /**
     * ��ȡ���Թ������⳵�����
     * @return ���Թ������⳵����ŵ�ֵ
     */
    public int getReferSerialNo(){
        return referSerialNo;
    }
}
