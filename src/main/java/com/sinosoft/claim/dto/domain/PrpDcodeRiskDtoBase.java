package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcoderiskͨ�ô������ֶ��ձ�����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcodeRiskDtoBase implements Serializable{
    /** ���Դ������� */
    private String codeType = "";
    /** ����ҵ����� */
    private String codeCode = "";
    /** �������ִ��� */
    private String riskCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcodeRiskDtoBase����
     */
    public PrpDcodeRiskDtoBase(){
    }

    /**
     * �������Դ�������
     * @param codeType �����õ����Դ������͵�ֵ
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * ��ȡ���Դ�������
     * @return ���Դ������͵�ֵ
     */
    public String getCodeType(){
        return codeType;
    }

    /**
     * ��������ҵ�����
     * @param codeCode �����õ�����ҵ������ֵ
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * ��ȡ����ҵ�����
     * @return ����ҵ������ֵ
     */
    public String getCodeCode(){
        return codeCode;
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
}
