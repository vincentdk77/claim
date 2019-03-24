package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����SwfModelUseģ��ʹ�����ã������������ݴ���������<br>
 * ������ 2005-04-26 15:20:13.468<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfModelUseDtoBase implements Serializable{
    /** ����ģ���� */
    private int modelNo = 0;
    /** �������ִ��� */
    private String riskCode = "";
    /** ���Բ��ű��� */
    private String comCode = "";
    /** ����ģ������ */
    private String modelType = "";
    /** ����ģ��״̬ */
    private String modelStatus = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�SwfModelUseDtoBase����
     */
    public SwfModelUseDtoBase(){
    }

    /**
     * ��������ģ����
     * @param modelNo �����õ�����ģ���ŵ�ֵ
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * ��ȡ����ģ����
     * @return ����ģ���ŵ�ֵ
     */
    public int getModelNo(){
        return modelNo;
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
     * �������Բ��ű���
     * @param comCode �����õ����Բ��ű����ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ���Բ��ű���
     * @return ���Բ��ű����ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������ģ������
     * @param modelType �����õ�����ģ�����͵�ֵ
     */
    public void setModelType(String modelType){
        this.modelType = StringUtils.rightTrim(modelType);
    }

    /**
     * ��ȡ����ģ������
     * @return ����ģ�����͵�ֵ
     */
    public String getModelType(){
        return modelType;
    }

    /**
     * ��������ģ��״̬
     * @param modelStatus �����õ�����ģ��״̬��ֵ
     */
    public void setModelStatus(String modelStatus){
        this.modelStatus = StringUtils.rightTrim(modelStatus);
    }

    /**
     * ��ȡ����ģ��״̬
     * @return ����ģ��״̬��ֵ
     */
    public String getModelStatus(){
        return modelStatus;
    }

    /**
     * �������Ա�־
     * @param flag �����õ����Ա�־��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־
     * @return ���Ա�־��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
