package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLregistExt-������Ϣ����˵�������ݴ���������<br>
 * ������ 2005-06-24 11:04:01.453<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpLregistExtDtoBase implements Serializable{
    /** ���Ա������� */
    private String registNo = "";
    /** �������ִ��� */
    private String riskCode = "";
    /** ������� */
    private int serialNo = 0;
    /** ����ʱ�� */
    private DateTime inputDate = new DateTime();
    /** ����Сʱ */
    private String inputHour = "";
    /** ���Բ���Ա���� */
    private String operatorCode = "";
    /** ����ҵ������������� */
    private String comCode = "";
    /** �������� */
    private String context = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLregistExtDtoBase����
     */
    public PrpLregistExtDtoBase(){
    }

    /**
     * �������Ա�������
     * @param registNo �����õ����Ա��������ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Ա�������
     * @return ���Ա��������ֵ
     */
    public String getRegistNo(){
        return registNo;
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
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������ʱ��
     * @param inputDate �����õ�����ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����ʱ��
     * @return ����ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������Сʱ
     * @param inputHour �����õ�����Сʱ��ֵ
     */
    public void setInputHour(String inputHour){
        this.inputHour = StringUtils.rightTrim(inputHour);
    }

    /**
     * ��ȡ����Сʱ
     * @return ����Сʱ��ֵ
     */
    public String getInputHour(){
        return inputHour;
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
     * ��������ҵ�������������
     * @param comCode �����õ�����ҵ��������������ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ҵ�������������
     * @return ����ҵ��������������ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ������������
     * @param context �����õ��������ݵ�ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ��������
     * @return �������ݵ�ֵ
     */
    public String getContext(){
        return context;
    }
}
