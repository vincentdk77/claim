package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����EdaComplainTextͶ�����ֱ�����ݴ���������<br>
 * ������ 2005-08-20 17:55:58.210<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class EdaComplainTextDtoBase implements Serializable{
    /** ����Ͷ�ߵǼǺ� */
    private double acceptNo = 0d;
    /** �����ı����� */
    private String textType = "";
    /** ������� */
    private double serialNo = 0d;
    /** �����к� */
    private double lineNo = 0d;
    /** ����¼������ */
    private DateTime inputDate = new DateTime();
    /** �������� */
    private String context = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�EdaComplainTextDtoBase����
     */
    public EdaComplainTextDtoBase(){
    }

    /**
     * ��������Ͷ�ߵǼǺ�
     * @param acceptNo �����õ�����Ͷ�ߵǼǺŵ�ֵ
     */
    public void setAcceptNo(double acceptNo){
        this.acceptNo = acceptNo;
    }

    /**
     * ��ȡ����Ͷ�ߵǼǺ�
     * @return ����Ͷ�ߵǼǺŵ�ֵ
     */
    public double getAcceptNo(){
        return acceptNo;
    }

    /**
     * ���������ı�����
     * @param textType �����õ������ı����͵�ֵ
     */
    public void setTextType(String textType){
        this.textType = StringUtils.rightTrim(textType);
    }

    /**
     * ��ȡ�����ı�����
     * @return �����ı����͵�ֵ
     */
    public String getTextType(){
        return textType;
    }

    /**
     * �����������
     * @param serialNo �����õ�������ŵ�ֵ
     */
    public void setSerialNo(double serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public double getSerialNo(){
        return serialNo;
    }

    /**
     * ���������к�
     * @param lineNo �����õ������кŵ�ֵ
     */
    public void setLineNo(double lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public double getLineNo(){
        return lineNo;
    }

    /**
     * ��������¼������
     * @param inputDate �����õ�����¼�����ڵ�ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����¼������
     * @return ����¼�����ڵ�ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
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
