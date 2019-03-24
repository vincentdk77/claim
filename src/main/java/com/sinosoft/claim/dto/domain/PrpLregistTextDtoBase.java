package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLregistText-�������ֱ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLregistTextDtoBase implements Serializable{
    /** ���Գ��յǼǺ� */
    private String registNo = "";
    /** �����ı����� */
    private String textType = "";
    /** �����к� */
    private int lineNo = 0;
    /** �������� */
    private String context = "";
    /** ���Ա�־λ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLregistTextDtoBase����
     */
    public PrpLregistTextDtoBase(){
    }

    /**
     * �������Գ��յǼǺ�
     * @param registNo �����õ����Գ��յǼǺŵ�ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ���Գ��յǼǺ�
     * @return ���Գ��յǼǺŵ�ֵ
     */
    public String getRegistNo(){
        return registNo;
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
     * ���������к�
     * @param lineNo �����õ������кŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
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
