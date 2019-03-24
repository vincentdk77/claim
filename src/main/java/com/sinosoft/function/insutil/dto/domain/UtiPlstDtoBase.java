package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utiplst�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPlstDtoBase implements Serializable{
    /** ����filename */
    private String fileName = "";
    /** ����labelno */
    private String labelNo = "";
    /** ����fieldname */
    private String fieldName = "";
    /** ����fieldmeaning */
    private String fieldMeaning = "";
    /** ����fieldformat */
    private String fieldFormat = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPlstDtoBase����
     */
    public UtiPlstDtoBase(){
    }

    /**
     * ��������filename
     * @param fileName �����õ�����filename��ֵ
     */
    public void setFileName(String fileName){
        this.fileName = StringUtils.rightTrim(fileName);
    }

    /**
     * ��ȡ����filename
     * @return ����filename��ֵ
     */
    public String getFileName(){
        return fileName;
    }

    /**
     * ��������labelno
     * @param labelNo �����õ�����labelno��ֵ
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * ��ȡ����labelno
     * @return ����labelno��ֵ
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * ��������fieldname
     * @param fieldName �����õ�����fieldname��ֵ
     */
    public void setFieldName(String fieldName){
        this.fieldName = StringUtils.rightTrim(fieldName);
    }

    /**
     * ��ȡ����fieldname
     * @return ����fieldname��ֵ
     */
    public String getFieldName(){
        return fieldName;
    }

    /**
     * ��������fieldmeaning
     * @param fieldMeaning �����õ�����fieldmeaning��ֵ
     */
    public void setFieldMeaning(String fieldMeaning){
        this.fieldMeaning = StringUtils.rightTrim(fieldMeaning);
    }

    /**
     * ��ȡ����fieldmeaning
     * @return ����fieldmeaning��ֵ
     */
    public String getFieldMeaning(){
        return fieldMeaning;
    }

    /**
     * ��������fieldformat
     * @param fieldFormat �����õ�����fieldformat��ֵ
     */
    public void setFieldFormat(String fieldFormat){
        this.fieldFormat = StringUtils.rightTrim(fieldFormat);
    }

    /**
     * ��ȡ����fieldformat
     * @return ����fieldformat��ֵ
     */
    public String getFieldFormat(){
        return fieldFormat;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
