package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prppengage�ر�Լ��������ݴ���������<br>
 * ������ 2004-11-22 15:24:12.875<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpPengageDtoBase implements Serializable{
    /** ������������ */
    private String endorseNo = "";
    /** ���Ա������� */
    private String policyNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ��������� */
    private int lineNo = 0;
    /** ����������� */
    private String clauseCode = "";
    /** ���������������� */
    private String clauses = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpPengageDtoBase����
     */
    public PrpPengageDtoBase(){
    }

    /**
     * ����������������
     * @param endorseNo �����õ��������������ֵ
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * ��ȡ������������
     * @return �������������ֵ
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * �������Ա�������
     * @param policyNo �����õ����Ա��������ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getPolicyNo(){
        return policyNo;
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
     * �������������
     * @param lineNo �����õ���������ŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ���������
     * @return ��������ŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * ���������������
     * @param clauseCode �����õ�������������ֵ
     */
    public void setClauseCode(String clauseCode){
        this.clauseCode = StringUtils.rightTrim(clauseCode);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClauseCode(){
        return clauseCode;
    }

    /**
     * ��������������������
     * @param clauses �����õ�������������������ֵ
     */
    public void setClauses(String clauses){
        this.clauses = StringUtils.rightTrim(clauses);
    }

    /**
     * ��ȡ����������������
     * @return ������������������ֵ
     */
    public String getClauses(){
        return clauses;
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
