package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiplst�嵥��Ϣ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPlstDtoBase implements Serializable{
    /** �����ļ����� */
    private String fileName = "";
    /** ���Ա�� */
    private String labelNo = "";
    /** �����ֶ��� */
    private String fieldName = "";
    /** �����ֶκ��� */
    private String fieldMeaning = "";
    /** �����ֶθ�ʽ */
    private String fieldFormat = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPlstDtoBase����
     */
    public UtiPlstDtoBase(){
    }

    /**
     * ���������ļ�����
     * @param fileName �����õ������ļ����Ƶ�ֵ
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * ��ȡ�����ļ�����
     * @return �����ļ����Ƶ�ֵ
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * �������Ա��
     * @param labelNo �����õ����Ա�ŵ�ֵ
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * ��ȡ���Ա��
     * @return ���Ա�ŵ�ֵ
     */
    public String getLabelNo(){
        return labelNo;
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
     * ���������ֶκ���
     * @param fieldMeaning �����õ������ֶκ����ֵ
     */
    public void setFieldMeaning(String fieldMeaning){
        this.fieldMeaning = StringUtils.rightTrim(fieldMeaning);
    }

    /**
     * ��ȡ�����ֶκ���
     * @return �����ֶκ����ֵ
     */
    public String getFieldMeaning(){
        return fieldMeaning;
    }

    /**
     * ���������ֶθ�ʽ
     * @param fieldFormat �����õ������ֶθ�ʽ��ֵ
     */
    public void setFieldFormat(String fieldFormat){
        this.fieldFormat = StringUtils.rightTrim(fieldFormat);
    }

    /**
     * ��ȡ�����ֶθ�ʽ
     * @return �����ֶθ�ʽ��ֵ
     */
    public String getFieldFormat(){
        return fieldFormat;
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
