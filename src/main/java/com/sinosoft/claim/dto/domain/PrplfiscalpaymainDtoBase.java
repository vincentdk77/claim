package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLFISCALpaymain�����ݴ���������<br>
 */
public class PrplfiscalpaymainDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����֧���嵥�� */
    private String fiscalno = "";
    /** ���Ա����� */
    private String registno = "";
    /** �����嵥�ܽ�� */
    private double sumamount = 0D;
    /** ���Բ����� */
    private String operatorcode = "";
    /** ���Բ���ʱ�� */
    private DateTime inputdate = new DateTime();
    /** ���Բ������� */
    private String operatorcomcode = "";
    /** ���Ա�ʶ */
    private String vflag = "";
    /** ����״̬ */
    private String status = "";
    /** �����������*/
    private String paymenttype = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplfiscalpaymainDtoBase����
     */
    public PrplfiscalpaymainDtoBase(){
    }

    /**
     * ��������֧���嵥��
     * @param fiscalno �����õ�����֧���嵥�ŵ�ֵ
     */
    public void setFiscalno(String fiscalno){
        this.fiscalno = StringUtils.rightTrim(fiscalno);
    }

    /**
     * ��ȡ����֧���嵥��
     * @return ����֧���嵥�ŵ�ֵ
     */
    public String getFiscalno(){
        return fiscalno;
    }

    /**
     * �������Ա�����
     * @param registno �����õ����Ա����ŵ�ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ���Ա�����
     * @return ���Ա����ŵ�ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ���������嵥�ܽ��
     * @param sumamount �����õ������嵥�ܽ���ֵ
     */
    public void setSumamount(double sumamount){
        this.sumamount = sumamount;
    }

    /**
     * ��ȡ�����嵥�ܽ��
     * @return �����嵥�ܽ���ֵ
     */
    public double getSumamount(){
        return sumamount;
    }

    /**
     * �������Բ�����
     * @param operatorcode �����õ����Բ����˵�ֵ
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * ��ȡ���Բ�����
     * @return ���Բ����˵�ֵ
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * �������Բ���ʱ��
     * @param inputdate �����õ����Բ���ʱ���ֵ
     */
    public void setInputdate(DateTime inputdate){
        this.inputdate = inputdate;
    }

    /**
     * ��ȡ���Բ���ʱ��
     * @return ���Բ���ʱ���ֵ
     */
    public DateTime getInputdate(){
        return inputdate;
    }

    /**
     * �������Բ�������
     * @param operatorcomcode �����õ����Բ���������ֵ
     */
    public void setOperatorcomcode(String operatorcomcode){
        this.operatorcomcode = StringUtils.rightTrim(operatorcomcode);
    }

    /**
     * ��ȡ���Բ�������
     * @return ���Բ���������ֵ
     */
    public String getOperatorcomcode(){
        return operatorcomcode;
    }

    /**
     * �������Ա�ʶ
     * @param vflag �����õ����Ա�ʶ��ֵ
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * ��ȡ���Ա�ʶ
     * @return ���Ա�ʶ��ֵ
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * ��������״̬
     * @param status �����õ�����״̬��ֵ
     */
    public void setStatus(String status){
        this.status = StringUtils.rightTrim(status);
    }

    /**
     * ��ȡ����״̬
     * @return ����״̬��ֵ
     */
    public String getStatus(){
        return status;
    }

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}
    
    
}
