package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpxpcol���������ֵ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPcolDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** �������ݱ��� */
    private String tableName = "";
    /** �����ֶ�˳�� */
    private int colSeq = 0;
    /** �����ֶ��� */
    private String colName = "";
    /** ������ʾ˳�� */
    private int dispSeq = 0;
    /** �����ֶ�����˵�� */
    private String colCName = "";
    /** �����ֶ�Ӣ��˵�� */
    private String colEName = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpXPcolDtoBase����
     */
    public PrpXPcolDtoBase(){
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
     * �����������ݱ���
     * @param tableName �����õ��������ݱ�����ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ�������ݱ���
     * @return �������ݱ�����ֵ
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * ���������ֶ�˳��
     * @param colSeq �����õ������ֶ�˳���ֵ
     */
    public void setColSeq(int colSeq){
        this.colSeq = colSeq;
    }

    /**
     * ��ȡ�����ֶ�˳��
     * @return �����ֶ�˳���ֵ
     */
    public int getColSeq(){
        return colSeq;
    }

    /**
     * ���������ֶ���
     * @param colName �����õ������ֶ�����ֵ
     */
    public void setColName(String colName){
        this.colName = StringUtils.rightTrim(colName);
    }

    /**
     * ��ȡ�����ֶ���
     * @return �����ֶ�����ֵ
     */
    public String getColName(){
        return colName;
    }

    /**
     * ����������ʾ˳��
     * @param dispSeq �����õ�������ʾ˳���ֵ
     */
    public void setDispSeq(int dispSeq){
        this.dispSeq = dispSeq;
    }

    /**
     * ��ȡ������ʾ˳��
     * @return ������ʾ˳���ֵ
     */
    public int getDispSeq(){
        return dispSeq;
    }

    /**
     * ���������ֶ�����˵��
     * @param colCName �����õ������ֶ�����˵����ֵ
     */
    public void setColCName(String colCName){
        this.colCName = StringUtils.rightTrim(colCName);
    }

    /**
     * ��ȡ�����ֶ�����˵��
     * @return �����ֶ�����˵����ֵ
     */
    public String getColCName(){
        return colCName;
    }

    /**
     * ���������ֶ�Ӣ��˵��
     * @param colEName �����õ������ֶ�Ӣ��˵����ֵ
     */
    public void setColEName(String colEName){
        this.colEName = StringUtils.rightTrim(colEName);
    }

    /**
     * ��ȡ�����ֶ�Ӣ��˵��
     * @return �����ֶ�Ӣ��˵����ֵ
     */
    public String getColEName(){
        return colEName;
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
