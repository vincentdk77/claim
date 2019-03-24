package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class PrepayFeeInfoDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性序号 PK */
    private int serialNo = 0;
    /** 属性费用代码 */
    private String chargeCode = "";
    /** 属性费用名称 */
    private String chargeName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性费用金额 */
    private double chargeReport = 0D;

    /**
     *  默认构造方法,构造一个默认的PrepayFeeInfoDto对象
     */
    public PrepayFeeInfoDto(){
    }

    /**
     * 设置属性序号 PK
     * @param serialNo 待设置的属性序号 PK的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号 PK
     * @return 属性序号 PK的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性费用代码
     * @param chargeCode 待设置的属性费用代码的值
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * 获取属性费用代码
     * @return 属性费用代码的值
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * 设置属性费用名称
     * @param chargeName 待设置的属性费用名称的值
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getChargeName(){
        return chargeName;
    }

    /**
     * 设置属性币别
     * @param currency 待设置的属性币别的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别
     * @return 属性币别的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode() {
		return kindCode;
	}

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	/**
     * 设置属性费用金额
     * @param chargeReport 待设置的属性费用金额的值
     */
    public void setChargeReport(double chargeReport){
        this.chargeReport = chargeReport;
    }

    /**
     * 获取属性费用金额
     * @return 属性费用金额的值
     */
    public double getChargeReport(){
        return chargeReport;
    }
}
