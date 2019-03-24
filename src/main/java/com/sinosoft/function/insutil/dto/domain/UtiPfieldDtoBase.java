package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utipfield�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPfieldDtoBase implements Serializable{
    /** ����filename */
    private String fileName = "";
    /** ����labelno */
    private String labelNo = "";
    /** ����fieldname */
    private String fieldName = "";
    /** ����selflag */
    private String selFlag = "";
    /** ����tabname */
    private String tabName = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPfieldDtoBase����
     */
    public UtiPfieldDtoBase(){
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
     * ��������selflag
     * @param selFlag �����õ�����selflag��ֵ
     */
    public void setSelFlag(String selFlag){
        this.selFlag = StringUtils.rightTrim(selFlag);
    }

    /**
     * ��ȡ����selflag
     * @return ����selflag��ֵ
     */
    public String getSelFlag(){
        return selFlag;
    }

    /**
     * ��������tabname
     * @param tabName �����õ�����tabname��ֵ
     */
    public void setTabName(String tabName){
        this.tabName = StringUtils.rightTrim(tabName);
    }

    /**
     * ��ȡ����tabname
     * @return ����tabname��ֵ
     */
    public String getTabName(){
        return tabName;
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
