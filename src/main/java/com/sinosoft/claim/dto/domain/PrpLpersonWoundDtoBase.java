package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLpersonWound-������Ϣ��(����)�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.765<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLpersonWoundDtoBase implements Serializable{
    /** ���Ա����� */
    private String registNo = "";
    /** �����ⰸ�� */
    private String claimNo = "";
    /** ���Ա����� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ������Ա��� */
    private int personNo = 0;
    /** ������Ա���� */
    private String personName = "";
    /** ����������� */
    private String woundCode = "";
    /** ������������ */
    private String woundDesc = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpersonWoundDtoBase����
     */
    public PrpLpersonWoundDtoBase(){
    }

    /**
     * �������Ա�����
     * @param registNo �����õ����Ա����ŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ���������ⰸ��
     * @param claimNo �����õ������ⰸ�ŵ�ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ��
     * @return �����ⰸ�ŵ�ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * �������Ա�����
     * @param policyNo �����õ����Ա����ŵ�ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
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
     * ����������Ա���
     * @param personNo �����õ�������Ա��ŵ�ֵ
     */
    public void setPersonNo(int personNo){
        this.personNo = personNo;
    }

    /**
     * ��ȡ������Ա���
     * @return ������Ա��ŵ�ֵ
     */
    public int getPersonNo(){
        return personNo;
    }

    /**
     * ����������Ա����
     * @param personName �����õ�������Ա������ֵ
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա������ֵ
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * ���������������
     * @param woundCode �����õ�������������ֵ
     */
    public void setWoundCode(String woundCode){
        this.woundCode = StringUtils.rightTrim(woundCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getWoundCode(){
        return woundCode;
    }

    /**
     * ����������������
     * @param woundDesc �����õ���������������ֵ
     */
    public void setWoundDesc(String woundDesc){
        this.woundDesc = StringUtils.rightTrim(woundDesc);
    }

    /**
     * ��ȡ������������
     * @return ��������������ֵ
     */
    public String getWoundDesc(){
        return woundDesc;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
