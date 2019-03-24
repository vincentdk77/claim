package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpxpcol�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXPcolDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����tablename */
    private String tableName = "";
    /** ����colseq */
    private int colSeq = 0;
    /** ����colname */
    private String colName = "";
    /** ����dispseq */
    private int dispSeq = 0;
    /** ����colcname */
    private String colCName = "";
    /** ����colename */
    private String colEName = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpXPcolDtoBase����
     */
    public PrpXPcolDtoBase(){
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
     * ��������colseq
     * @param colSeq �����õ�����colseq��ֵ
     */
    public void setColSeq(int colSeq){
        this.colSeq = colSeq;
    }

    /**
     * ��ȡ����colseq
     * @return ����colseq��ֵ
     */
    public int getColSeq(){
        return colSeq;
    }

    /**
     * ��������colname
     * @param colName �����õ�����colname��ֵ
     */
    public void setColName(String colName){
        this.colName = StringUtils.rightTrim(colName);
    }

    /**
     * ��ȡ����colname
     * @return ����colname��ֵ
     */
    public String getColName(){
        return colName;
    }

    /**
     * ��������dispseq
     * @param dispSeq �����õ�����dispseq��ֵ
     */
    public void setDispSeq(int dispSeq){
        this.dispSeq = dispSeq;
    }

    /**
     * ��ȡ����dispseq
     * @return ����dispseq��ֵ
     */
    public int getDispSeq(){
        return dispSeq;
    }

    /**
     * ��������colcname
     * @param colCName �����õ�����colcname��ֵ
     */
    public void setColCName(String colCName){
        this.colCName = StringUtils.rightTrim(colCName);
    }

    /**
     * ��ȡ����colcname
     * @return ����colcname��ֵ
     */
    public String getColCName(){
        return colCName;
    }

    /**
     * ��������colename
     * @param colEName �����õ�����colename��ֵ
     */
    public void setColEName(String colEName){
        this.colEName = StringUtils.rightTrim(colEName);
    }

    /**
     * ��ȡ����colename
     * @return ����colename��ֵ
     */
    public String getColEName(){
        return colEName;
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
