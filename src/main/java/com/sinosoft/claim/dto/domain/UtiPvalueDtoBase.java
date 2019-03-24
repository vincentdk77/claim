package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utipvalue��֤��ӡ���ݵ����ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPvalueDtoBase implements Serializable{
    /** �����ն˺� */
    private String ttyName = "";
    /** ���Ա�� */
    private String labelNo = "";
    /** ����ֵ */
    private String fieldValu = "";
    /** �����к� */
    private int lineNo = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPvalueDtoBase����
     */
    public UtiPvalueDtoBase(){
    }

    /**
     * ���������ն˺�
     * @param ttyName �����õ������ն˺ŵ�ֵ
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * ��ȡ�����ն˺�
     * @return �����ն˺ŵ�ֵ
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * �������Ա��
     * @param labelNo �����õ����Ա�ŵ�ֵ
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * ��ȡ���Ա��
     * @return ���Ա�ŵ�ֵ
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * ��������ֵ
     * @param fieldValu �����õ�����ֵ��ֵ
     */
    public void setFieldValu(String fieldValu){
        this.fieldValu = StringUtils.rightTrim(fieldValu);
    }

    /**
     * ��ȡ����ֵ
     * @return ����ֵ��ֵ
     */
    public String getFieldValu(){
        return fieldValu;
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
}
