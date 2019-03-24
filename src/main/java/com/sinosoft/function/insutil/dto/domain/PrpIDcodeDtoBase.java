package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpidcode�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDcodeDtoBase implements Serializable{
    /** ����codetype */
    private String codeType = "";
    /** ����riskcode */
    private String riskCode = "";
    /** ����codecode */
    private String codeCode = "";
    /** ����codecname */
    private String codeCName = "";
    /** ����codeename */
    private String codeEName = "";
    /** ����excodecode */
    private String excodecode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpIDcodeDtoBase����
     */
    public PrpIDcodeDtoBase(){
    }

    /**
     * ��������codetype
     * @param codeType �����õ�����codetype��ֵ
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * ��ȡ����codetype
     * @return ����codetype��ֵ
     */
    public String getCodeType(){
        return codeType;
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
     * ��������codecode
     * @param codeCode �����õ�����codecode��ֵ
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * ��ȡ����codecode
     * @return ����codecode��ֵ
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * ��������codecname
     * @param codeCName �����õ�����codecname��ֵ
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * ��ȡ����codecname
     * @return ����codecname��ֵ
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * ��������codeename
     * @param codeEName �����õ�����codeename��ֵ
     */
    public void setCodeEName(String codeEName){
        this.codeEName = StringUtils.rightTrim(codeEName);
    }

    /**
     * ��ȡ����codeename
     * @return ����codeename��ֵ
     */
    public String getCodeEName(){
        return codeEName;
    }

    /**
     * ��������excodecode
     * @param excodecode �����õ�����excodecode��ֵ
     */
    public void setExcodecode(String excodecode){
        this.excodecode = StringUtils.rightTrim(excodecode);
    }

    /**
     * ��ȡ����excodecode
     * @return ����excodecode��ֵ
     */
    public String getExcodecode(){
        return excodecode;
    }
}
