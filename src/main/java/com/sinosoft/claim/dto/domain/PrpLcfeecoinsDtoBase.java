package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcfeecoins的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcfeecoinsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性businessNo */
    private String businessNo = "";
    /** 属性serialNo */
    private int serialNo = 0;
    /** 属性riskCode */
    private String riskCode = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性currency */
    private String currency = "";
    /** 属性coinsCode */
    private String coinsCode = "";
    /** 属性coinsName */
    private String coinsName = "";
    /** 属性coinsType */
    private String coinsType = "";
    /** 属性coinsRate */
    private double coinsRate = 0D;
    /** 属性chiefFlag */
    private String chiefFlag = "";
    /** 属性lossFeeType */
    private String lossFeeType = "";
    /** 属性chargeCode */
    private String chargeCode = "";
    /** 属性chargeName */
    private String chargeName = "";
    /** 属性sumpaid */
    private double sumpaid = 0D;
    /** 属性coinsSumpaid */
    private double coinsSumpaid = 0D;
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcfeecoinsDtoBase对象
     */
    public PrpLcfeecoinsDtoBase(){
    }

    /**
     * 设置属性businessNo
     * @param businessNo 待设置的属性businessNo的值
     */
    public void setBusinessNo(String businessNo){
        this.businessNo = StringUtils.rightTrim(businessNo);
    }

    /**
     * 获取属性businessNo
     * @return 属性businessNo的值
     */
    public String getBusinessNo(){
        return businessNo;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性riskCode
     * @param riskCode 待设置的属性riskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskCode
     * @return 属性riskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性currency
     * @param currency 待设置的属性currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性currency
     * @return 属性currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性coinsCode
     * @param coinsCode 待设置的属性coinsCode的值
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * 获取属性coinsCode
     * @return 属性coinsCode的值
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * 设置属性coinsName
     * @param coinsName 待设置的属性coinsName的值
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * 获取属性coinsName
     * @return 属性coinsName的值
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * 设置属性coinsType
     * @param coinsType 待设置的属性coinsType的值
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * 获取属性coinsType
     * @return 属性coinsType的值
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * 设置属性coinsRate
     * @param coinsRate 待设置的属性coinsRate的值
     */
    public void setCoinsRate(double coinsRate){
        this.coinsRate = coinsRate;
    }

    /**
     * 获取属性coinsRate
     * @return 属性coinsRate的值
     */
    public double getCoinsRate(){
        return coinsRate;
    }

    /**
     * 设置属性chiefFlag
     * @param chiefFlag 待设置的属性chiefFlag的值
     */
    public void setChiefFlag(String chiefFlag){
        this.chiefFlag = StringUtils.rightTrim(chiefFlag);
    }

    /**
     * 获取属性chiefFlag
     * @return 属性chiefFlag的值
     */
    public String getChiefFlag(){
        return chiefFlag;
    }

    /**
     * 设置属性lossFeeType
     * @param lossFeeType 待设置的属性lossFeeType的值
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * 获取属性lossFeeType
     * @return 属性lossFeeType的值
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * 设置属性chargeCode
     * @param chargeCode 待设置的属性chargeCode的值
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * 获取属性chargeCode
     * @return 属性chargeCode的值
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * 设置属性chargeName
     * @param chargeName 待设置的属性chargeName的值
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * 获取属性chargeName
     * @return 属性chargeName的值
     */
    public String getChargeName(){
        return chargeName;
    }

    /**
     * 设置属性sumpaid
     * @param sumpaid 待设置的属性sumpaid的值
     */
    public void setSumpaid(double sumpaid){
        this.sumpaid = sumpaid;
    }

    /**
     * 获取属性sumpaid
     * @return 属性sumpaid的值
     */
    public double getSumpaid(){
        return sumpaid;
    }

    /**
     * 设置属性coinsSumpaid
     * @param coinsSumpaid 待设置的属性coinsSumpaid的值
     */
    public void setCoinsSumpaid(double coinsSumpaid){
        this.coinsSumpaid = coinsSumpaid;
    }

    /**
     * 获取属性coinsSumpaid
     * @return 属性coinsSumpaid的值
     */
    public double getCoinsSumpaid(){
        return coinsSumpaid;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }
}
