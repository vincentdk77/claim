package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utipsele��֤��ӡ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPseleDtoBase implements Serializable{
    /** �����ļ��� */
    private String fileName = "";
    /** ������� */
    private String orderNo = "";
    /** �����ֶ����� */
    private String fieldName = "";
    /** ����ȡ����־ */
    private String selFlag = "";
    /** ���Ա��� */
    private String tabName = "";
    /** ����WHERE���� */
    private String whereClause = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPseleDtoBase����
     */
    public UtiPseleDtoBase(){
    }

    /**
     * ���������ļ���
     * @param fileName �����õ������ļ�����ֵ
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * ��ȡ�����ļ���
     * @return �����ļ�����ֵ
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * �����������
     * @param orderNo �����õ�������ŵ�ֵ
     */
    public void setOrderNo(String orderNo){
        this.orderNo = StringUtils.rightTrim(orderNo);
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public String getOrderNo(){
        return orderNo;
    }

    /**
     * ���������ֶ�����
     * @param fieldName �����õ������ֶ����Ƶ�ֵ
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * ��ȡ�����ֶ�����
     * @return �����ֶ����Ƶ�ֵ
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * ��������ȡ����־
     * @param selFlag �����õ�����ȡ����־��ֵ
     */
    public void setSelFlag(String selFlag){
        this.selFlag = StringUtils.rightTrim(selFlag);
    }

    /**
     * ��ȡ����ȡ����־
     * @return ����ȡ����־��ֵ
     */
    public String getSelFlag(){
        return selFlag;
    }

    /**
     * �������Ա���
     * @param tabName �����õ����Ա�����ֵ
     */
    public void setTabName(String tabName){
        this.tabName = StringUtils.rightTrim(tabName);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public String getTabName(){
        return tabName;
    }

    /**
     * ��������WHERE����
     * @param whereClause �����õ�����WHERE������ֵ
     */
    public void setWhereClause(String whereClause){
        this.whereClause = StringUtils.rightTrim(whereClause);
    }

    /**
     * ��ȡ����WHERE����
     * @return ����WHERE������ֵ
     */
    public String getWhereClause(){
        return whereClause;
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
