package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����UtiCodeTransfer-�������������ձ�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class UtiCodeTransferDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Գ����д��� */
    private String configCode = "";
    /** �����ⲿ���� */
    private String outerCode = "";
    /** �����ڲ����� */
    private String innerCode = "";
    /** ���Խӿڴ������� */
    private String codeType = "";
    /** ����Ч��״̬ */
    private String validStatus = "";
    /** �����ձ���� */
    private String riskType = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiCodeTransferDtoBase����
     */
    public UtiCodeTransferDtoBase(){
    }

    /**
     * �������Գ����д���
     * @param configCode �����õ����Գ����д����ֵ
     */
    public void setConfigCode(String configCode){
        this.configCode = StringUtils.rightTrim(configCode);
    }

    /**
     * ��ȡ���Գ����д���
     * @return ���Գ����д����ֵ
     */
    public String getConfigCode(){
        return configCode;
    }

    /**
     * ���������ⲿ����
     * @param outerCode �����õ������ⲿ�����ֵ
     */
    public void setOuterCode(String outerCode){
        this.outerCode = StringUtils.rightTrim(outerCode);
    }

    /**
     * ��ȡ�����ⲿ����
     * @return �����ⲿ�����ֵ
     */
    public String getOuterCode(){
        return outerCode;
    }

    /**
     * ���������ڲ�����
     * @param innerCode �����õ������ڲ������ֵ
     */
    public void setInnerCode(String innerCode){
        this.innerCode = StringUtils.rightTrim(innerCode);
    }

    /**
     * ��ȡ�����ڲ�����
     * @return �����ڲ������ֵ
     */
    public String getInnerCode(){
        return innerCode;
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
     * ��������Ч��״̬
     * @param validStatus �����õ�����Ч��״̬��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����Ч��״̬
     * @return ����Ч��״̬��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ���������ձ����
     * @param riskType �����õ������ձ�����ֵ
     */
    public void setRiskType(String riskType){
        this.riskType = StringUtils.rightTrim(riskType);
    }

    /**
     * ��ȡ�����ձ����
     * @return �����ձ�����ֵ
     */
    public String getRiskType(){
        return riskType;
    }
}
