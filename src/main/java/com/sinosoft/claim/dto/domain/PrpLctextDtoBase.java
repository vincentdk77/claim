package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLctext-���������ֱ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.593<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLctextDtoBase implements Serializable{
    /** ������������� */
    private String compensateNo = "";
    /** ��������˵������ ��
--** ������/��ע/�� */
    private String textType = "";
    /** �����к� */
    private int lineNo = 0;
    /** ��������˵�� */
    private String context = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLctextDtoBase����
     */
    public PrpLctextDtoBase(){
    }

    /**
     * �����������������
     * @param compensateNo �����õ�������������ŵ�ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ�������������
     * @return ������������ŵ�ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ������������˵������ ��
--** ������/��ע/��
     * @param textType �����õ���������˵������ ��
--** ������/��ע/����ֵ
     */
    public void setTextType(String textType){
        this.textType = StringUtils.rightTrim(textType);
    }

    /**
     * ��ȡ��������˵������ ��
--** ������/��ע/��
     * @return ��������˵������ ��
--** ������/��ע/����ֵ
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
