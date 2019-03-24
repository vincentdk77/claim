package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ������ϵ�˱�PrpLrelatePerson�����ݴ���������<br>
 * ������ 2005-05-31 19:50:52.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLrelatePersonDtoBase implements Serializable{
    /** ���Գ��յǼǺ� */
    private String registNo = "";
    /** ������Ա���� */
    private String personType = "";
    /** ������� */
    private int serialNo = 0;
    /** ������Ա���� */
    private String personCode = "";
    /** ������Ա���� */
    private String personName = "";
    /** ������ϵ�绰 */
    private String phoneNumber = "";
    /** �����ƶ��绰 */
    private String mobile = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLrelatePersonDtoBase����
     */
    public PrpLrelatePersonDtoBase(){
    }

    /**
     * �������Գ��յǼǺ�
     * @param registNo �����õ����Գ��յǼǺŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Գ��յǼǺ�
     * @return ���Գ��յǼǺŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ����������Ա����
     * @param personType �����õ�������Ա���͵�ֵ
     */
    public void setPersonType(String personType){
        this.personType = StringUtils.rightTrim(personType);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա���͵�ֵ
     */
    public String getPersonType(){
        return personType;
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
     * ����������Ա����
     * @param personCode �����õ�������Ա�����ֵ
     */
    public void setPersonCode(String personCode){
        this.personCode = StringUtils.rightTrim(personCode);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա�����ֵ
     */
    public String getPersonCode(){
        return personCode;
    }

    /**
     * ����������Ա����
     * @param personName �����õ�������Ա���Ƶ�ֵ
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * ��ȡ������Ա����
     * @return ������Ա���Ƶ�ֵ
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * ����������ϵ�绰
     * @param phoneNumber �����õ�������ϵ�绰��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ������ϵ�绰
     * @return ������ϵ�绰��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ���������ƶ��绰
     * @param mobile �����õ������ƶ��绰��ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ�����ƶ��绰
     * @return �����ƶ��绰��ֵ
     */
    public String getMobile(){
        return mobile;
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
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
