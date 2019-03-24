package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ���ǵ�����ñ�-PrpLAcciCheckCharge�����ݴ���������<br>
 * ������ JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLAcciCheckChargeDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLAcciCheckChargeDtoBase.class.getName().hashCode();
    /** ���Ե����-CheckNo */
    private String checkNo = "";
    /** �������-SerialNo */
    private int serialNo = 0;
    /** ���Է���������-ChargeCode */
    private String chargeCode = "";
    /** ���Է�������-ChargeName */
    private String chargeName = "";
    /** ���Աұ����-Currency */
    private String currency = "";
    /** ���Է��ý��-ChargeAmount */
    private double chargeAmount = 0D;

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLAcciCheckChargeDtoBase����
     */
    public PrpLAcciCheckChargeDtoBase(){
    }

    /**
     * �������Ե����-CheckNo
     * @param checkNo �����õ����Ե����-CheckNo��ֵ
     */
    public void setCheckNo(String checkNo){
        this.checkNo = StringUtils.rightTrim(checkNo);
    }

    /**
     * ��ȡ���Ե����-CheckNo
     * @return ���Ե����-CheckNo��ֵ
     */
    public String getCheckNo(){
        return checkNo;
    }

    /**
     * �����������-SerialNo
     * @param serialNo �����õ��������-SerialNo��ֵ
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ�������-SerialNo
     * @return �������-SerialNo��ֵ
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * �������Է���������-ChargeCode
     * @param chargeCode �����õ����Է���������-ChargeCode��ֵ
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * ��ȡ���Է���������-ChargeCode
     * @return ���Է���������-ChargeCode��ֵ
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * �������Է�������-ChargeName
     * @param chargeName �����õ����Է�������-ChargeName��ֵ
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * ��ȡ���Է�������-ChargeName
     * @return ���Է�������-ChargeName��ֵ
     */
    public String getChargeName(){
        return chargeName;
    }

    /**
     * �������Աұ����-Currency
     * @param currency �����õ����Աұ����-Currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ���Աұ����-Currency
     * @return ���Աұ����-Currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * �������Է��ý��-ChargeAmount
     * @param chargeAmount �����õ����Է��ý��-ChargeAmount��ֵ
     */
    public void setChargeAmount(double chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    /**
     * ��ȡ���Է��ý��-ChargeAmount
     * @return ���Է��ý��-ChargeAmount��ֵ
     */
    public double getChargeAmount(){
        return chargeAmount;
    }
}
