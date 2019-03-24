package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpxpform���������ֵ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPformDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ������������ */
    private String endorType = "";
    /** ���������������� */
    private String endorTypeName = "";
    /** ����form�������� */
    private int row = 0;
    /** ����form�������� */
    private int col = 0;
    /** ����FORM���� */
    private String formName = "";
    /** ����������ݱ����� */
    private String tableName = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpXPformDtoBase����
     */
    public PrpXPformDtoBase(){
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
     * ����������������
     * @param endorType �����õ������������͵�ֵ
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * ��ȡ������������
     * @return �����������͵�ֵ
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * ��������������������
     * @param endorTypeName �����õ����������������Ƶ�ֵ
     */
    public void setEndorTypeName(String endorTypeName){
        this.endorTypeName = StringUtils.rightTrim(endorTypeName);
    }

    /**
     * ��ȡ����������������
     * @return ���������������Ƶ�ֵ
     */
    public String getEndorTypeName(){
        return endorTypeName;
    }

    /**
     * ��������form��������
     * @param row �����õ�����form���������ֵ
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * ��ȡ����form��������
     * @return ����form���������ֵ
     */
    public int getRow(){
        return row;
    }

    /**
     * ��������form��������
     * @param col �����õ�����form���������ֵ
     */
    public void setCol(int col){
        this.col = col;
    }

    /**
     * ��ȡ����form��������
     * @return ����form���������ֵ
     */
    public int getCol(){
        return col;
    }

    /**
     * ��������FORM����
     * @param formName �����õ�����FORM���Ƶ�ֵ
     */
    public void setFormName(String formName){
        this.formName = StringUtils.rightTrim(formName);
    }

    /**
     * ��ȡ����FORM����
     * @return ����FORM���Ƶ�ֵ
     */
    public String getFormName(){
        return formName;
    }

    /**
     * ��������������ݱ�����
     * @param tableName �����õ�����������ݱ����Ƶ�ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ����������ݱ�����
     * @return ����������ݱ����Ƶ�ֵ
     */
    public String getTableName(){
        return tableName;
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
