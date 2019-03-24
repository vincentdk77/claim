package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpxpform�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPformDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����endortype */
    private String endorType = "";
    /** ����endortypename */
    private String endorTypeName = "";
    /** ����layrow */
    private int layRow = 0;
    /** ����laycol */
    private int layCol = 0;
    /** ����formname */
    private String formName = "";
    /** ����tablename */
    private String tableName = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpXPformDtoBase����
     */
    public PrpXPformDtoBase(){
    }

    /**
     * ��������riskcode
     * @param riskCode �����õ�����riskcode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskcode
     * @return ����riskcode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������endortype
     * @param endorType �����õ�����endortype��ֵ
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * ��ȡ����endortype
     * @return ����endortype��ֵ
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * ��������endortypename
     * @param endorTypeName �����õ�����endortypename��ֵ
     */
    public void setEndorTypeName(String endorTypeName){
        this.endorTypeName = StringUtils.rightTrim(endorTypeName);
    }

    /**
     * ��ȡ����endortypename
     * @return ����endortypename��ֵ
     */
    public String getEndorTypeName(){
        return endorTypeName;
    }

    /**
     * ��������layrow
     * @param layRow �����õ�����layrow��ֵ
     */
    public void setLayRow(int layRow){
        this.layRow = layRow;
    }

    /**
     * ��ȡ����layrow
     * @return ����layrow��ֵ
     */
    public int getLayRow(){
        return layRow;
    }

    /**
     * ��������laycol
     * @param layCol �����õ�����laycol��ֵ
     */
    public void setLayCol(int layCol){
        this.layCol = layCol;
    }

    /**
     * ��ȡ����laycol
     * @return ����laycol��ֵ
     */
    public int getLayCol(){
        return layCol;
    }

    /**
     * ��������formname
     * @param formName �����õ�����formname��ֵ
     */
    public void setFormName(String formName){
        this.formName = StringUtils.rightTrim(formName);
    }

    /**
     * ��ȡ����formname
     * @return ����formname��ֵ
     */
    public String getFormName(){
        return formName;
    }

    /**
     * ��������tablename
     * @param tableName �����õ�����tablename��ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ����tablename
     * @return ����tablename��ֵ
     */
    public String getTableName(){
        return tableName;
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
