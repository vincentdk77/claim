package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdclausekind�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDclauseKindDtoBase implements Serializable{
    /** ����riskcode */
    private String riskCode = "";
    /** ����clausetype */
    private String clauseType = "";
    /** ����kindcode */
    private String kindCode = "";
    /** ����relatekindcode */
    private String relateKindCode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDclauseKindDtoBase����
     */
    public PrpDclauseKindDtoBase(){
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
     * ��������clausetype
     * @param clauseType �����õ�����clausetype��ֵ
     */
    public void setClauseType(String clauseType){
        this.clauseType = StringUtils.rightTrim(clauseType);
    }

    /**
     * ��ȡ����clausetype
     * @return ����clausetype��ֵ
     */
    public String getClauseType(){
        return clauseType;
    }

    /**
     * ��������kindcode
     * @param kindCode �����õ�����kindcode��ֵ
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * ��ȡ����kindcode
     * @return ����kindcode��ֵ
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * ��������relatekindcode
     * @param relateKindCode �����õ�����relatekindcode��ֵ
     */
    public void setRelateKindCode(String relateKindCode){
        this.relateKindCode = StringUtils.rightTrim(relateKindCode);
    }

    /**
     * ��ȡ����relatekindcode
     * @return ����relatekindcode��ֵ
     */
    public String getRelateKindCode(){
        return relateKindCode;
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
