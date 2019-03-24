package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是调查费用表-PrpLAcciCheckCharge的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLAcciCheckChargeDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLAcciCheckChargeDtoBase.class.getName().hashCode();
    /** 属性调查号-CheckNo */
    private String checkNo = "";
    /** 属性序号-SerialNo */
    private int serialNo = 0;
    /** 属性费用类别代码-ChargeCode */
    private String chargeCode = "";
    /** 属性费用名称-ChargeName */
    private String chargeName = "";
    /** 属性币别代码-Currency */
    private String currency = "";
    /** 属性费用金额-ChargeAmount */
    private double chargeAmount = 0D;

    /**
     *  默认构造方法,构造一个默认的PrpLAcciCheckChargeDtoBase对象
     */
    public PrpLAcciCheckChargeDtoBase(){
    }

    /**
     * 设置属性调查号-CheckNo
     * @param checkNo 待设置的属性调查号-CheckNo的值
     */
    public void setCheckNo(String checkNo){
        this.checkNo = StringUtils.rightTrim(checkNo);
    }

    /**
     * 获取属性调查号-CheckNo
     * @return 属性调查号-CheckNo的值
     */
    public String getCheckNo(){
        return checkNo;
    }

    /**
     * 设置属性序号-SerialNo
     * @param serialNo 待设置的属性序号-SerialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号-SerialNo
     * @return 属性序号-SerialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性费用类别代码-ChargeCode
     * @param chargeCode 待设置的属性费用类别代码-ChargeCode的值
     */
    public void setChargeCode(String chargeCode){
        this.chargeCode = StringUtils.rightTrim(chargeCode);
    }

    /**
     * 获取属性费用类别代码-ChargeCode
     * @return 属性费用类别代码-ChargeCode的值
     */
    public String getChargeCode(){
        return chargeCode;
    }

    /**
     * 设置属性费用名称-ChargeName
     * @param chargeName 待设置的属性费用名称-ChargeName的值
     */
    public void setChargeName(String chargeName){
        this.chargeName = StringUtils.rightTrim(chargeName);
    }

    /**
     * 获取属性费用名称-ChargeName
     * @return 属性费用名称-ChargeName的值
     */
    public String getChargeName(){
        return chargeName;
    }

    /**
     * 设置属性币别代码-Currency
     * @param currency 待设置的属性币别代码-Currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码-Currency
     * @return 属性币别代码-Currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性费用金额-ChargeAmount
     * @param chargeAmount 待设置的属性费用金额-ChargeAmount的值
     */
    public void setChargeAmount(double chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    /**
     * 获取属性费用金额-ChargeAmount
     * @return 属性费用金额-ChargeAmount的值
     */
    public double getChargeAmount(){
        return chargeAmount;
    }
}
