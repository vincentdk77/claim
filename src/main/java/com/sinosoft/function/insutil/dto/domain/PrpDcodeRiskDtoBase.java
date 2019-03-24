package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcoderisk�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeRiskDtoBase implements Serializable{
    /** ����codetype */
    private String codeType = "";
    /** ����codecode */
    private String codeCode = "";
    /** ����riskcode */
    private String riskCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcodeRiskDtoBase����
     */
    public PrpDcodeRiskDtoBase(){
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
}
