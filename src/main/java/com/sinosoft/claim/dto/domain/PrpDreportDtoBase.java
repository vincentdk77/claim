package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdreport���������ļ������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDreportDtoBase implements Serializable{
    /** ���Ա���� */
    private String reportCode = "";
    /** ���Ա������� */
    private String reportName = "";
    /** ������� */
    private int serialNo = 0;
    /** �����к� */
    private int row = 0;
    /** �����к� */
    private int col = 0;
    /** ���Թ������� */
    private String workField = "";
    /** ���Ա��� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDreportDtoBase����
     */
    public PrpDreportDtoBase(){
    }

    /**
     * �������Ա����
     * @param reportCode �����õ����Ա���ŵ�ֵ
     */
    public void setReportCode(String reportCode){
        this.reportCode = StringUtils.rightTrim(reportCode);
    }

    /**
     * ��ȡ���Ա����
     * @return ���Ա���ŵ�ֵ
     */
    public String getReportCode(){
        return reportCode;
    }

    /**
     * �������Ա�������
     * @param reportName �����õ����Ա������Ƶ�ֵ
     */
    public void setReportName(String reportName){
        this.reportName = StringUtils.rightTrim(reportName);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա������Ƶ�ֵ
     */
    public String getReportName(){
        return reportName;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ���������к�
     * @param row �����õ������кŵ�ֵ
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public int getRow(){
        return row;
    }

    /**
     * ���������к�
     * @param col �����õ������кŵ�ֵ
     */
    public void setCol(int col){
        this.col = col;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public int getCol(){
        return col;
    }

    /**
     * �������Թ�������
     * @param workField �����õ����Թ��������ֵ
     */
    public void setWorkField(String workField){
        this.workField = StringUtils.rightTrim(workField);
    }

    /**
     * ��ȡ���Թ�������
     * @return ���Թ��������ֵ
     */
    public String getWorkField(){
        return workField;
    }

    /**
     * �������Ա���
     * @param flag �����õ����Ա��õ�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա���
     * @return ���Ա��õ�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
