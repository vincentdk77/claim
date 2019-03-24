package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����utipvalue�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class UtiPvalueDtoBase implements Serializable{
    /** ����ttyname */
    private String ttyName = "";
    /** ����labelno */
    private String labelNo = "";
    /** ����fieldvalu */
    private String fieldValu = "";
    /** ����lineno */
    private int lineNo = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�UtiPvalueDtoBase����
     */
    public UtiPvalueDtoBase(){
    }

    /**
     * ��������ttyname
     * @param ttyName �����õ�����ttyname��ֵ
     */
    public void setTtyName(String ttyName){
        this.ttyName = StringUtils.rightTrim(ttyName);
    }

    /**
     * ��ȡ����ttyname
     * @return ����ttyname��ֵ
     */
    public String getTtyName(){
        return ttyName;
    }

    /**
     * ��������labelno
     * @param labelNo �����õ�����labelno��ֵ
     */
    public void setLabelNo(String labelNo){
        this.labelNo = StringUtils.rightTrim(labelNo);
    }

    /**
     * ��ȡ����labelno
     * @return ����labelno��ֵ
     */
    public String getLabelNo(){
        return labelNo;
    }

    /**
     * ��������fieldvalu
     * @param fieldValu �����õ�����fieldvalu��ֵ
     */
    public void setFieldValu(String fieldValu){
        this.fieldValu = StringUtils.rightTrim(fieldValu);
    }

    /**
     * ��ȡ����fieldvalu
     * @return ����fieldvalu��ֵ
     */
    public String getFieldValu(){
        return fieldValu;
    }

    /**
     * ��������lineno
     * @param lineNo �����õ�����lineno��ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ����lineno
     * @return ����lineno��ֵ
     */
    public int getLineNo(){
        return lineNo;
    }
}
