package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLdeductCond-��������������������ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLdeductCondDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ���Լ������ */
    private String compensateNo = "";
    /** ���������������� */
    private String deductCondCode = "";
    /** ���������������� */
    private String deductCondName = "";
    /** �����û�����ĳ��մ�����֤���� */
    private int times = 0;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLdeductCondDtoBase����
     */
    public PrpLdeductCondDtoBase(){
    }

    /**
     * �������Լ������
     * @param compensateNo �����õ����Լ�����ŵ�ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ���Լ������
     * @return ���Լ�����ŵ�ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ��������������������
     * @param deductCondCode �����õ������������������ֵ
     */
    public void setDeductCondCode(String deductCondCode){
        this.deductCondCode = StringUtils.rightTrim(deductCondCode);
    }

    /**
     * ��ȡ����������������
     * @return �����������������ֵ
     */
    public String getDeductCondCode(){
        return deductCondCode;
    }

    /**
     * ��������������������
     * @param deductCondName �����õ����������������Ƶ�ֵ
     */
    public void setDeductCondName(String deductCondName){
        this.deductCondName = StringUtils.rightTrim(deductCondName);
    }

    /**
     * ��ȡ����������������
     * @return ���������������Ƶ�ֵ
     */
    public String getDeductCondName(){
        return deductCondName;
    }

    /**
     * ���������û�����ĳ��մ�����֤����
     * @param times �����õ������û�����ĳ��մ�����֤������ֵ
     */
    public void setTimes(int times){
        this.times = times;
    }

    /**
     * ��ȡ�����û�����ĳ��մ�����֤����
     * @return �����û�����ĳ��մ�����֤������ֵ
     */
    public int getTimes(){
        return times;
    }
}
