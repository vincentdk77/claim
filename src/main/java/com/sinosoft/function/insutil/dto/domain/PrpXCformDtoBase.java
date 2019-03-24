package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpxcform�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXCformDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����filetype */
    private String fileType = "";
    /** ����layrow */
    private int layRow = 0;
    /** ����laycol */
    private int layCol = 0;
    /** ����filename */
    private String fileName = "";
    /** ����tablename */
    private String tableName = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpXCformDtoBase����
     */
    public PrpXCformDtoBase(){
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
     * ��������filetype
     * @param fileType �����õ�����filetype��ֵ
     */
    public void setFileType(String fileType){
        this.fileType = StringUtils.rightTrim(fileType);
    }

    /**
     * ��ȡ����filetype
     * @return ����filetype��ֵ
     */
    public String getFileType(){
        return fileType;
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
