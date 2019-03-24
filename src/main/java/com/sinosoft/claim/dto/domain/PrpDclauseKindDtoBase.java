package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdclausekind�����ձ��ϵ������ݴ���������<br>
 * ������ 2004-4-5 15:33:40<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseKindDtoBase implements Serializable{
    /** �������ִ��� */
    private String riskCode = "";
    /** ����������� */
    private String clauseType = "";
    /** �����ձ���� */
    private String kindCode = "";
    /** ���Թ����ձ���� */
    private String relateKindCode = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDclauseKindDtoBase����
     */
    public PrpDclauseKindDtoBase(){
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
     * ���������������
     * @param clauseType �����õ�������������ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ�����������
     * @return ������������ֵ
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * ���������ձ����
     * @param kindCode �����õ������ձ�����ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * �������Թ����ձ����
     * @param relateKindCode �����õ����Թ����ձ�����ֵ
     */
    public void setRelateKindCode(String relateKindCode){
        this.relateKindCode = StringUtils.rightTrim(relateKindCode);
    }

    /**
     * ��ȡ���Թ����ձ����
     * @return ���Թ����ձ�����ֵ
     */
    public String getRelateKindCode(){
        return relateKindCode;
    }

    /**
     * �������Ա�־λ
     * @param flag �����õ����Ա�־λ��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־λ
     * @return ���Ա�־λ��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
