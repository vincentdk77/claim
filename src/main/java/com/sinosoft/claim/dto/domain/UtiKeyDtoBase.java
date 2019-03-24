package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utikey��ֵ��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiKeyDtoBase implements Serializable{
    /** ���Ա��� */
    private String tableName = "";
    /** �����ֶ��� */
    private String fieldName = "";
    /** �������� */
    private String fieldMeaning = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiKeyDtoBase����
     */
    public UtiKeyDtoBase(){
    }

    /**
     * �������Ա���
     * @param tableName �����õ����Ա�����ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա�����ֵ
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * ���������ֶ���
     * @param fieldName �����õ������ֶ�����ֵ
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * ��ȡ�����ֶ���
     * @return �����ֶ�����ֵ
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * ������������
     * @param fieldMeaning �����õ��������Ƶ�ֵ
     */
    public void setFieldMeaning(String fieldMeaning){
        this.fieldMeaning = StringUtils.rightTrim(fieldMeaning);
    }

    /**
     * ��ȡ��������
     * @return �������Ƶ�ֵ
     */
    public String getFieldMeaning(){
        return fieldMeaning;
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
