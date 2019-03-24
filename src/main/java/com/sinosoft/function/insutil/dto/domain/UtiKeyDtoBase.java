package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utikey�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiKeyDtoBase implements Serializable{
    /** ����tablename */
    private String tableName = "";
    /** ����fieldname */
    private String fieldName = "";
    /** ����fieldmeaning */
    private String fieldMeaning = "";
    /** ����headid */
    private String headID = "";
    /** ����ColLength */
    private int colLength = 0;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiKeyDtoBase����
     */
    public UtiKeyDtoBase(){
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
     * ��������headid
     * @param headID �����õ�����headid��ֵ
     */
    public void setHeadID(String headID){
        this.headID = StringUtils.rightTrim(headID);
    }

    /**
     * ��ȡ����headid
     * @return ����headid��ֵ
     */
    public String getHeadID(){
        return headID;
    }

    /**
     * ��������ColLength
     * @param colLength �����õ�����ColLength��ֵ
     */
    public void setColLength(int colLength){
        this.colLength = colLength;
    }

    /**
     * ��ȡ����ColLength
     * @return ����ColLength��ֵ
     */
    public int getColLength(){
        return colLength;
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
