package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utittyrecord��¼��¼������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiTtyRecordDtoBase implements Serializable{
    /** ����ϵͳ�豸�� */
    private String sysTty = "";
    /** ���Բ���Ա */
    private String userName = "";
    /** �������� */
    private String comCode = "";
    /** ������� */
    private String year = "";
    /** �������� */
    private String riskCode = "";
    /** �����豸��� */
    private String ttyCode = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiTtyRecordDtoBase����
     */
    public UtiTtyRecordDtoBase(){
    }

    /**
     * ��������ϵͳ�豸��
     * @param sysTty �����õ�����ϵͳ�豸�ŵ�ֵ
     */
    public void setSysTty(String sysTty){
        this.sysTty = StringUtils.rightTrim(sysTty);
    }

    /**
     * ��ȡ����ϵͳ�豸��
     * @return ����ϵͳ�豸�ŵ�ֵ
     */
    public String getSysTty(){
        return sysTty;
    }

    /**
     * �������Բ���Ա
     * @param userName �����õ����Բ���Ա��ֵ
     */
    public void setUserName(String userName){
        this.userName = StringUtils.rightTrim(userName);
    }

    /**
     * ��ȡ���Բ���Ա
     * @return ���Բ���Ա��ֵ
     */
    public String getUserName(){
        return userName;
    }

    /**
     * ������������
     * @param comCode �����õ����������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ��������
     * @return ���������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �����������
     * @param year �����õ�������ŵ�ֵ
     */
    public void setYear(String year){
        this.year = StringUtils.rightTrim(year);
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public String getYear(){
        return year;
    }

    /**
     * ������������
     * @param riskCode �����õ��������ֵ�ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ��������
     * @return �������ֵ�ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ���������豸���
     * @param ttyCode �����õ������豸��ŵ�ֵ
     */
    public void setTtyCode(String ttyCode){
        this.ttyCode = StringUtils.rightTrim(ttyCode);
    }

    /**
     * ��ȡ�����豸���
     * @return �����豸��ŵ�ֵ
     */
    public String getTtyCode(){
        return ttyCode;
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
}
