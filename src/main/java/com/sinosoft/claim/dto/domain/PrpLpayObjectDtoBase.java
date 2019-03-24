package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLpayObject-֧��������������ݴ���������<br>
 * ������ 2006-08-03 14:43:23.159<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLpayObjectDtoBase implements Serializable{
    /** ����֧���������� */
    private String payObjectType = "";
    /** ����֧��������� */
    private String payObjectCode = "";
    /** ����֧���������� */
    private String payObjectName = "";
    /** ���Ի������� */
    private String comCode = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ���Ա�ע */
    private String remark = "";
    /** ����Ч��״̬(0ʧЧ/1��Ч) */
    private String validStatus = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayObjectDtoBase����
     */
    public PrpLpayObjectDtoBase(){
    }

    /**
     * ��������֧����������
     * @param payObjectType �����õ�����֧���������͵�ֵ
     */
    public void setPayObjectType(String payObjectType){
        this.payObjectType = StringUtils.rightTrim(payObjectType);
    }

    /**
     * ��ȡ����֧����������
     * @return ����֧���������͵�ֵ
     */
    public String getPayObjectType(){
        return payObjectType;
    }

    /**
     * ��������֧���������
     * @param payObjectCode �����õ�����֧����������ֵ
     */
    public void setPayObjectCode(String payObjectCode){
        this.payObjectCode = StringUtils.rightTrim(payObjectCode);
    }

    /**
     * ��ȡ����֧���������
     * @return ����֧����������ֵ
     */
    public String getPayObjectCode(){
        return payObjectCode;
    }

    /**
     * ��������֧����������
     * @param payObjectName �����õ�����֧���������Ƶ�ֵ
     */
    public void setPayObjectName(String payObjectName){
        this.payObjectName = StringUtils.rightTrim(payObjectName);
    }

    /**
     * ��ȡ����֧����������
     * @return ����֧���������Ƶ�ֵ
     */
    public String getPayObjectName(){
        return payObjectName;
    }

    /**
     * �������Ի�������
     * @param comCode �����õ����Ի��������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Ի�������
     * @return ���Ի��������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * �������Բ���Ա����
     * @param operatorCode �����õ����Բ���Ա�����ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ���Բ���Ա����
     * @return ���Բ���Ա�����ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * �������Ա�ע
     * @param remark �����õ����Ա�ע��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ���Ա�ע
     * @return ���Ա�ע��ֵ
     */
    public String getRemark(){
        return remark;
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
}
