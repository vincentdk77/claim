package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdclause������������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseDtoBase implements Serializable{
    /** ����������� */
    private String clauseCode = "";
    /** ������������ */
    private String clauseName = "";
    /** ��������(C/E/��) */
    private String language = "";
    /** �����к� */
    private int lineNo = 0;
    /** ������������ */
    private String context = "";
    /** ������������� */
    private String newClauseCode = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDclauseDtoBase����
     */
    public PrpDclauseDtoBase(){
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
     * ����������������
     * @param clauseName �����õ������������Ƶ�ֵ
     */
    public void setClauseName(String clauseName){
        this.clauseName = StringUtils.rightTrim(clauseName);
    }

    /**
     * ��ȡ������������
     * @return �����������Ƶ�ֵ
     */
    public String getClauseName(){
        return clauseName;
    }

    /**
     * ������������(C/E/��)
     * @param language �����õ���������(C/E/��)��ֵ
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * ��ȡ��������(C/E/��)
     * @return ��������(C/E/��)��ֵ
     */
    public String getLanguage(){
        return language;
    }

    /**
     * ���������к�
     * @param lineNo �����õ������кŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * ����������������
     * @param context �����õ������������ݵ�ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ������������
     * @return �����������ݵ�ֵ
     */
    public String getContext(){
        return context;
    }

    /**
     * �����������������
     * @param newClauseCode �����õ���������������ֵ
     */
    public void setNewClauseCode(String newClauseCode){
        this.newClauseCode = StringUtils.rightTrim(newClauseCode);
    }

    /**
     * ��ȡ�������������
     * @return ��������������ֵ
     */
    public String getNewClauseCode(){
        return newClauseCode;
    }

    /**
     * ��������Ч��״̬(0ʧЧ/1��Ч)
     * @param validStatus �����õ�����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬(0ʧЧ/1��Ч)
     * @return ����Ч��״̬(0ʧЧ/1��Ч)��ֵ
     */
    public String getValidStatus(){
        return validStatus;
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
