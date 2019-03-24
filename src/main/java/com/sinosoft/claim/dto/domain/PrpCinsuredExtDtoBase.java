package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpcinsuredext��ϵ����չ��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCinsuredExtDtoBase implements Serializable{
    /** ���Ա������� */
    private String policyNo = "";
    /** ������� */
    private int serialNo = 0;
    /** ���������ֶ��� */
    private String columnName = "";
    /** ������ʾ���� */
    private String displayName = "";
    /** ���������ֶ����� */
    private String columnValue = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpCinsuredExtDtoBase����
     */
    public PrpCinsuredExtDtoBase(){
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
     * �������������ֶ���
     * @param columnName �����õ����������ֶ�����ֵ
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * ��ȡ���������ֶ���
     * @return ���������ֶ�����ֵ
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * ����������ʾ����
     * @param displayName �����õ�������ʾ���Ƶ�ֵ
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * ��ȡ������ʾ����
     * @return ������ʾ���Ƶ�ֵ
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
