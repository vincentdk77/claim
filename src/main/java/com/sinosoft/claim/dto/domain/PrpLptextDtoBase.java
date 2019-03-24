package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpLptext-Ԥ�����ֱ�����ݴ���������<br>
 * ������ 2005-03-18 17:53:35.437<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLptextDtoBase implements Serializable{
    /** ����Ԥ��ǼǺ� */
    private String preCompensateNo = "";
    /** �����к� */
    private int lineNo = 0;
    /** ��������˵�� */
    private String context = "";
    /** ���Ա�־�ֶ� */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLptextDtoBase����
     */
    public PrpLptextDtoBase(){
    }

    /**
     * ��������Ԥ��ǼǺ�
     * @param preCompensateNo �����õ�����Ԥ��ǼǺŵ�ֵ
     */
    public void setPreCompensateNo(String preCompensateNo){
        this.preCompensateNo = StringUtils.rightTrim(preCompensateNo);
    }

    /**
     * ��ȡ����Ԥ��ǼǺ�
     * @return ����Ԥ��ǼǺŵ�ֵ
     */
    public String getPreCompensateNo(){
        return preCompensateNo;
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
