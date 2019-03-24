package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpidcode�ӿڴ��������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpIDCodeDtoBase implements Serializable{
    /** ���Խӿڴ������� */
    private String codeType = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Դ��� */
    private String codeCode = "";
    /** ���Դ����������� */
    private String codeCName = "";
    /** ���Դ���Ӣ������ */
    private String codeEName = "";
    /** ���Խӿ����ݿ���մ��� */
    private String excodecode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpIDCodeDtoBase����
     */
    public PrpIDCodeDtoBase(){
    }

    /**
     * �������Խӿڴ�������
     * @param codeType �����õ����Խӿڴ������͵�ֵ
     */
    public void setCodeType(String codeType){
        this.codeType = StringUtils.rightTrim(codeType);
    }

    /**
     * ��ȡ���Խӿڴ�������
     * @return ���Խӿڴ������͵�ֵ
     */
    public String getCodeType(){
        return codeType;
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
     * �������Դ���
     * @param codeCode �����õ����Դ����ֵ
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * ��ȡ���Դ���
     * @return ���Դ����ֵ
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * �������Դ�����������
     * @param codeCName �����õ����Դ����������Ƶ�ֵ
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * ��ȡ���Դ�����������
     * @return ���Դ����������Ƶ�ֵ
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * �������Դ���Ӣ������
     * @param codeEName �����õ����Դ���Ӣ�����Ƶ�ֵ
     */
    public void setCodeEName(String codeEName){
        this.codeEName = StringUtils.rightTrim(codeEName);
    }

    /**
     * ��ȡ���Դ���Ӣ������
     * @return ���Դ���Ӣ�����Ƶ�ֵ
     */
    public String getCodeEName(){
        return codeEName;
    }

    /**
     * �������Խӿ����ݿ���մ���
     * @param excodecode �����õ����Խӿ����ݿ���մ����ֵ
     */
    public void setExcodecode(String excodecode){
        this.excodecode = StringUtils.rightTrim(excodecode);
    }

    /**
     * ��ȡ���Խӿ����ݿ���մ���
     * @return ���Խӿ����ݿ���մ����ֵ
     */
    public String getExcodecode(){
        return excodecode;
    }
}
