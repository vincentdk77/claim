package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLltext-�������ֱ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLltextDtoBase implements Serializable{
    /** �����ⰸ���� */
    private String claimNo = "";
    /** ��������˵������ ��
--** ����ժҪ/�鿱����/�᰸���� */
    private String textType = "";
    /** �����к� */
    private int lineNo = 0;
    /** ��������˵�� */
    private String context = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLltextDtoBase����
     */
    public PrpLltextDtoBase(){
    }

    /**
     * ���������ⰸ����
     * @param claimNo �����õ������ⰸ�����ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ�����ⰸ����
     * @return �����ⰸ�����ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ������������˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @param textType �����õ���������˵������ ��
--** ����ժҪ/�鿱����/�᰸�����ֵ
     */
    public void setTextType(String textType){
        this.textType = StringUtils.rightTrim(textType);
    }

    /**
     * ��ȡ��������˵������ ��
--** ����ժҪ/�鿱����/�᰸����
     * @return ��������˵������ ��
--** ����ժҪ/�鿱����/�᰸�����ֵ
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
     * ������������˵��
     * @param context �����õ���������˵����ֵ
     */
    public void setContext(String context){
        this.context = StringUtils.rightTrim(context);
    }

    /**
     * ��ȡ��������˵��
     * @return ��������˵����ֵ
     */
    public String getContext(){
        return context;
    }

    /**
     * �������Ա�־�ֶ�
     * @param flag �����õ����Ա�־�ֶε�ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ���Ա�־�ֶ�
     * @return ���Ա�־�ֶε�ֵ
     */
    public String getFlag(){
        return flag;
    }
}
