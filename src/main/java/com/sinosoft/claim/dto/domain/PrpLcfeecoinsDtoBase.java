package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpLcfeecoins�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcfeecoinsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����businessNo */
    private String businessNo = "";
    /** ����serialNo */
    private int serialNo = 0;
    /** ����riskCode */
    private String riskCode = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����currency */
    private String currency = "";
    /** ����coinsCode */
    private String coinsCode = "";
    /** ����coinsName */
    private String coinsName = "";
    /** ����coinsType */
    private String coinsType = "";
    /** ����coinsRate */
    private double coinsRate = 0D;
    /** ����chiefFlag */
    private String chiefFlag = "";
    /** ����lossFeeType */
    private String lossFeeType = "";
    /** ����chargeCode */
    private String chargeCode = "";
    /** ����chargeName */
    private String chargeName = "";
    /** ����sumpaid */
    private double sumpaid = 0D;
    /** ����coinsSumpaid */
    private double coinsSumpaid = 0D;
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLcfeecoinsDtoBase����
     */
    public PrpLcfeecoinsDtoBase(){
    }

    /**
     * ��������businessNo
     * @param businessNo �����õ�����businessNo��ֵ
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * ��ȡ����businessNo
     * @return ����businessNo��ֵ
     */
    public String getBusinessNo(){
        return businessNo;
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
     * ��������riskCode
     * @param riskCode �����õ�����riskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskCode
     * @return ����riskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������currency
     * @param currency �����õ�����currency��ֵ
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * ��ȡ����currency
     * @return ����currency��ֵ
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * ��������coinsCode
     * @param coinsCode �����õ�����coinsCode��ֵ
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * ��ȡ����coinsCode
     * @return ����coinsCode��ֵ
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * ��������coinsName
     * @param coinsName �����õ�����coinsName��ֵ
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * ��ȡ����coinsName
     * @return ����coinsName��ֵ
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * ��������coinsType
     * @param coinsType �����õ�����coinsType��ֵ
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * ��ȡ����coinsType
     * @return ����coinsType��ֵ
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * ��������coinsRate
     * @param coinsRate �����õ�����coinsRate��ֵ
     */
    public void setCoinsRate(double coinsRate){
        this.coinsRate = coinsRate;
    }

    /**
     * ��ȡ����coinsRate
     * @return ����coinsRate��ֵ
     */
    public double getCoinsRate(){
        return coinsRate;
    }

    /**
     * ��������chiefFlag
     * @param chiefFlag �����õ�����chiefFlag��ֵ
     */
    public void setChiefFlag(String chiefFlag){
        this.chiefFlag = StringUtils.rightTrim(chiefFlag);
    }

    /**
     * ��ȡ����chiefFlag
     * @return ����chiefFlag��ֵ
     */
    public String getChiefFlag(){
        return chiefFlag;
    }

    /**
     * ��������lossFeeType
     * @param lossFeeType �����õ�����lossFeeType��ֵ
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * ��ȡ����lossFeeType
     * @return ����lossFeeType��ֵ
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * ��������chargeCode
     * @param chargeCode �����õ�����chargeCode��ֵ
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * ��ȡ����chargeCode
     * @return ����chargeCode��ֵ
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * ��������chargeName
     * @param chargeName �����õ�����chargeName��ֵ
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * ��ȡ����chargeName
     * @return ����chargeName��ֵ
     */
    public String getChargeName(){
        return chargeName;
    }

    /**
     * ��������sumpaid
     * @param sumpaid �����õ�����sumpaid��ֵ
     */
    public void setSumpaid(double sumpaid){
        this.sumpaid = sumpaid;
    }

    /**
     * ��ȡ����sumpaid
     * @return ����sumpaid��ֵ
     */
    public double getSumpaid(){
        return sumpaid;
    }

    /**
     * ��������coinsSumpaid
     * @param coinsSumpaid �����õ�����coinsSumpaid��ֵ
     */
    public void setCoinsSumpaid(double coinsSumpaid){
        this.coinsSumpaid = coinsSumpaid;
    }

    /**
     * ��ȡ����coinsSumpaid
     * @return ����coinsSumpaid��ֵ
     */
    public double getCoinsSumpaid(){
        return coinsSumpaid;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
