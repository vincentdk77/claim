package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpxcform�б������ֵ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpXCformDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** �����ļ����� */
    private String fileType = "";
    /** ����form�������� */
    private int row = 0;
    /** ����form�������� */
    private int col = 0;
    /** �����ļ����� */
    private String fileName = "";
    /** ����������ݱ��� */
    private String tableName = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpXCformDtoBase����
     */
    public PrpXCformDtoBase(){
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
     * ���������ļ�����
     * @param fileType �����õ������ļ����͵�ֵ
     */
    public void setFileType(String fileType){
        this.fileType = StringUtils.rightTrim(fileType);
    }

    /**
     * ��ȡ�����ļ�����
     * @return �����ļ����͵�ֵ
     */
    public String getFileType(){
        return fileType;
    }

    /**
     * ��������form��������
     * @param row �����õ�����form���������ֵ
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * ��ȡ����form��������
     * @return ����form���������ֵ
     */
    public int getRow(){
        return row;
    }

    /**
     * ��������form��������
     * @param col �����õ�����form���������ֵ
     */
    public void setCol(int col){
        this.col = col;
    }

    /**
     * ��ȡ����form��������
     * @return ����form���������ֵ
     */
    public int getCol(){
        return col;
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
     * ��������������ݱ���
     * @param tableName �����õ�����������ݱ�����ֵ
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * ��ȡ����������ݱ���
     * @return ����������ݱ�����ֵ
     */
    public String getTableName(){
        return tableName;
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
