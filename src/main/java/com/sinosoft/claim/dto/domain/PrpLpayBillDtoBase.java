package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLpayBill�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayBillDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����billNo*/
    private String billNo = "";
    /** ����paymentNo */
    private String paymentNo = "";
    /** ����registNo */
    private String registNo = "";
    /** ����compensateNo */
    private String compensateNo = "";
    /** ����serialNo */
    private int serialNo = 0;
    /** ����payAmount */
    private double payAmount = 0D;
    /** ����businessNo */
    private String businessNo = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayBillDtoBase����
     */
    public PrpLpayBillDtoBase(){
    }

    
    public String getBillNo() {
		return billNo;
	}


	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}


	/**
     * ��������paymentNo
     * @param paymentNo �����õ�����paymentNo��ֵ
     */
    public void setPaymentNo(String paymentNo){
        this.paymentNo = StringUtils.rightTrim(paymentNo);
    }

    /**
     * ��ȡ����paymentNo
     * @return ����paymentNo��ֵ
     */
    public String getPaymentNo(){
        return paymentNo;
    }

    /**
     * ��������registNo
     * @param registNo �����õ�����registNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����registNo
     * @return ����registNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������compensateNo
     * @param compensateNo �����õ�����compensateNo��ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ����compensateNo
     * @return ����compensateNo��ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * ��������payAmount
     * @param payAmount �����õ�����payAmount��ֵ
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * ��ȡ����payAmount
     * @return ����payAmount��ֵ
     */
    public double getPayAmount(){
        return payAmount;
    }


	public String getBusinessNo() {
		return businessNo;
	}


	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
    
}
