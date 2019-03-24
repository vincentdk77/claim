package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utipsele�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPseleDtoBase implements Serializable{
    /** ����filename */
    private String fileName = "";
    /** ����orderno */
    private String orderNo = "";
    /** ����fieldname */
    private String fieldName = "";
    /** ����selflag */
    private String selFlag = "";
    /** ����tabname */
    private String tabName = "";
    /** ����whereclause */
    private String whereClause = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPseleDtoBase����
     */
    public UtiPseleDtoBase(){
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
     * ��������orderno
     * @param orderNo �����õ�����orderno��ֵ
     */
    public void setOrderNo(String orderNo){
        this.orderNo = StringUtils.rightTrim(orderNo);
    }

    /**
     * ��ȡ����orderno
     * @return ����orderno��ֵ
     */
    public String getOrderNo(){
        return orderNo;
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
     * ��������whereclause
     * @param whereClause �����õ�����whereclause��ֵ
     */
    public void setWhereClause(String whereClause){
        this.whereClause = StringUtils.rightTrim(whereClause);
    }

    /**
     * ��ȡ����whereclause
     * @return ����whereclause��ֵ
     */
    public String getWhereClause(){
        return whereClause;
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
