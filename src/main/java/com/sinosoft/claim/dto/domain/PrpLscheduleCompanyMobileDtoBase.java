package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLscheduleCompanyMobile--�������ĵ绰������ݴ���������<br>
 * ������ 2005-09-22 17:24:48.058<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLscheduleCompanyMobileDtoBase implements Serializable{
    /** ���Ե������Ļ������� */
    private String comCode = "";
    /** �������к��� */
    private int serialNo = 0;
    /** �����ֻ����� */
    private String mobileNo = "";
    /** ���Ը����� */
    private String linkerName = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ���Ա�־ */
    private String flag = "";
    /** ����ֵ������ */
    private String onDutyDay = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLscheduleCompanyMobileDtoBase����
     */
    public PrpLscheduleCompanyMobileDtoBase(){
    }

    /**
     * �������Ե������Ļ�������
     * @param comCode �����õ����Ե������Ļ��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ե������Ļ�������
     * @return ���Ե������Ļ��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �����������к���
     * @param serialNo �����õ��������к����ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������к���
     * @return �������к����ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������ֻ�����
     * @param mobileNo �����õ������ֻ������ֵ
     */
    public void setMobileNo(String mobileNo){
        this.mobileNo = StringUtils.rightTrim(mobileNo);
    }

    /**
     * ��ȡ�����ֻ�����
     * @return �����ֻ������ֵ
     */
    public String getMobileNo(){
        return mobileNo;
    }

    /**
     * �������Ը�����
     * @param linkerName �����õ����Ը����˵�ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ���Ը�����
     * @return ���Ը����˵�ֵ
     */
    public String getLinkerName(){
        return linkerName;
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
     * ��������ֵ������
     * @param onDutyDay �����õ�����ֵ�����ڵ�ֵ
     */
    public void setOnDutyDay(String onDutyDay){
        this.onDutyDay = StringUtils.rightTrim(onDutyDay);
    }

    /**
     * ��ȡ����ֵ������
     * @return ����ֵ�����ڵ�ֵ
     */
    public String getOnDutyDay(){
        return onDutyDay;
    }
}
