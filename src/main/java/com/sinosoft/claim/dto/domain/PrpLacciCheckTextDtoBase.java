package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLacciCheckText--�����ı���Ϣ������ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciCheckTextDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciCheckTextDtoBase.class.getName().hashCode();
    /** ���Ե���� */
    private String checkNo = "";
    /** ��������˵������ */
    private String textType = "";
    /** �����к� */
    private long lineNo = 0L;
    /** ��������˵�� */
    private String context = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLacciCheckTextDtoBase����
     */
    public PrpLacciCheckTextDtoBase(){
    }

    /**
     * �������Ե����
     * @param checkNo �����õ����Ե���ŵ�ֵ
     */
    public void setCheckNo(String checkNo){
        this.checkNo = StringUtils.rightTrim(checkNo);
    }

    /**
     * ��ȡ���Ե����
     * @return ���Ե���ŵ�ֵ
     */
    public String getCheckNo(){
        return checkNo;
    }

    /**
     * ������������˵������
     * @param textType �����õ���������˵�����͵�ֵ
     */
    public void setTextType(String textType){
        this.textType = StringUtils.rightTrim(textType);
    }

    /**
     * ��ȡ��������˵������
     * @return ��������˵�����͵�ֵ
     */
    public String getTextType(){
        return textType;
    }

    /**
     * ���������к�
     * @param lineNo �����õ������кŵ�ֵ
     */
    public void setLineNo(long lineNo){
        this.lineNo = lineNo;
    }

    /**
     * ��ȡ�����к�
     * @return �����кŵ�ֵ
     */
    public long getLineNo(){
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
