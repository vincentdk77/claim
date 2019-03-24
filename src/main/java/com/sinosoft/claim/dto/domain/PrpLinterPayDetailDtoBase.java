package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǽ�����Ϣ������------�켣������ݴ���������<br>
 */
public class PrpLinterPayDetailDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ��������pk */
    private String id = "";
    /** ���Կͻ����������� */
    private String outId = "";
    /** �����ո���� */
    private String paymentNo = "";
    /** ����֧������״̬(1�ɹ�) */
    private String paySuccFlag = "";
    /** ����˫����������״̬(1�ɹ�) */
    private String vericSuccFlag = "";
    /** ����֧��״̬ */
    private String thirdPayFlag = "";
    /** ��������ʱ�� */
    private DateTime inputDate = new DateTime();

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLinterPayDetailDtoBase����
     */
    public PrpLinterPayDetailDtoBase(){
    }

    /**
     * ������������pk
     * @param id �����õ���������pk��ֵ
     */
    public void setId(String id){
        this.id = StringUtils.rightTrim(id);
    }

    /**
     * ��ȡ��������pk
     * @return ��������pk��ֵ
     */
    public String getId(){
        return id;
    }

    /**
     * �������Կͻ�����������
     * @param outId �����õ����Կͻ�������������ֵ
     */
    public void setOutId(String outId){
        this.outId = StringUtils.rightTrim(outId);
    }

    /**
     * ��ȡ���Կͻ�����������
     * @return ���Կͻ�������������ֵ
     */
    public String getOutId(){
        return outId;
    }

    /**
     * ���������ո����
     * @param paymentNo �����õ������ո���ŵ�ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ�����ո����
     * @return �����ո���ŵ�ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * ��������֧������״̬(1�ɹ�)
     * @param paySuccFlag �����õ�����֧������״̬(1�ɹ�)��ֵ
     */
    public void setPaySuccFlag(String paySuccFlag){
        this.paySuccFlag = StringUtils.rightTrim(paySuccFlag);
    }

    /**
     * ��ȡ����֧������״̬(1�ɹ�)
     * @return ����֧������״̬(1�ɹ�)��ֵ
     */
    public String getPaySuccFlag(){
        return paySuccFlag;
    }

    /**
     * ��������˫����������״̬(1�ɹ�)
     * @param vericSuccFlag �����õ�����˫����������״̬(1�ɹ�)��ֵ
     */
    public void setVericSuccFlag(String vericSuccFlag){
        this.vericSuccFlag = StringUtils.rightTrim(vericSuccFlag);
    }

    /**
     * ��ȡ����˫����������״̬(1�ɹ�)
     * @return ����˫����������״̬(1�ɹ�)��ֵ
     */
    public String getVericSuccFlag(){
        return vericSuccFlag;
    }

    /**
     * ������������ʱ��
     * @param inputDate �����õ���������ʱ���ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ��������ʱ��
     * @return ��������ʱ���ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }
    
    public String getThirdPayFlag() {
		return thirdPayFlag;
	}

	public void setThirdPayFlag(String thirdPayFlag) {
		this.thirdPayFlag = thirdPayFlag;
	}
}
