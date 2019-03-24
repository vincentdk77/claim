package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdreport�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDreportDtoBase implements Serializable{
    /** ����reportcode */
    private String reportCode = "";
    /** ����reportname */
    private String reportName = "";
    /** ����serialno */
    private int serialNo = 0;
    /** ����layrow */
    private int layRow = 0;
    /** ����laycol */
    private int layCol = 0;
    /** ����workfield */
    private String workField = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDreportDtoBase����
     */
    public PrpDreportDtoBase(){
    }

    /**
     * ��������reportcode
     * @param reportCode �����õ�����reportcode��ֵ
     */
    public void setReportCode(String reportCode){
        this.reportCode = StringUtils.rightTrim(reportCode);
    }

    /**
     * ��ȡ����reportcode
     * @return ����reportcode��ֵ
     */
    public String getReportCode(){
        return reportCode;
    }

    /**
     * ��������reportname
     * @param reportName �����õ�����reportname��ֵ
     */
    public void setReportName(String reportName){
        this.reportName = StringUtils.rightTrim(reportName);
    }

    /**
     * ��ȡ����reportname
     * @return ����reportname��ֵ
     */
    public String getReportName(){
        return reportName;
    }

    /**
     * ��������serialno
     * @param serialNo �����õ�����serialno��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialno
     * @return ����serialno��ֵ
     */
    public int getSerialNo(){
        return serialNo;
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
     * ��������workfield
     * @param workField �����õ�����workfield��ֵ
     */
    public void setWorkField(String workField){
        this.workField = StringUtils.rightTrim(workField);
    }

    /**
     * ��ȡ����workfield
     * @return ����workfield��ֵ
     */
    public String getWorkField(){
        return workField;
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
