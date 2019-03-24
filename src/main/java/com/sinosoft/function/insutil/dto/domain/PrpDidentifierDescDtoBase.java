package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdidentifierdesc�����ݴ���������<br>
 * ������ 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDescDtoBase implements Serializable{
    /** ����identifiercode */
    private String identifierCode = "";
    /** ����lineno */
    private int lineNo = 0;
    /** ����mark */
    private String mark = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDidentifierDescDtoBase����
     */
    public PrpDidentifierDescDtoBase(){
    }

    /**
     * ��������identifiercode
     * @param identifierCode �����õ�����identifiercode��ֵ
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * ��ȡ����identifiercode
     * @return ����identifiercode��ֵ
     */
    public String getIdentifierCode(){
        return identifierCode;
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

    /**
     * ��������mark
     * @param mark �����õ�����mark��ֵ
     */
    public void setMark(String mark){
        this.mark = StringUtils.rightTrim(mark);
    }

    /**
     * ��ȡ����mark
     * @return ����mark��ֵ
     */
    public String getMark(){
        return mark;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
