package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdidentifierdesc�������ı�����������ݴ���������<br>
 * ������ 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDidentifierDescDtoBase implements Serializable{
    /** ���Լ����˴��� */
    private String identifierCode = "";
    /** ������� */
    private int lineNo = 0;
    /** ���Լ�������Ϣ */
    private String mark = "";
    /** ���Ա�־ */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDidentifierDescDtoBase����
     */
    public PrpDidentifierDescDtoBase(){
    }

    /**
     * �������Լ����˴���
     * @param identifierCode �����õ����Լ����˴����ֵ
     */
    public void setIdentifierCode(String identifierCode){
        this.identifierCode = StringUtils.rightTrim(identifierCode);
    }

    /**
     * ��ȡ���Լ����˴���
     * @return ���Լ����˴����ֵ
     */
    public String getIdentifierCode(){
        return identifierCode;
    }

    /**
     * �����������
     * @param lineNo �����õ�������ŵ�ֵ
     */
    public void setLineNo(int lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�������
     * @return ������ŵ�ֵ
     */
    public int getLineNo(){
        return lineNo;
    }

    /**
     * �������Լ�������Ϣ
     * @param mark �����õ����Լ�������Ϣ��ֵ
     */
    public void setMark(String mark){
        this.mark = StringUtils.rightTrim(mark);
    }

    /**
     * ��ȡ���Լ�������Ϣ
     * @return ���Լ�������Ϣ��ֵ
     */
    public String getMark(){
        return mark;
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
