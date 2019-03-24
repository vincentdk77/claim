package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcfee保单保额保费表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCfeeDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性总保额 */
    private double amount = 0d;
    /** 属性总保费 */
    private double premium = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCfeeDtoBase对象
     */
    public PrpCfeeDtoBase(){
    }

    /**
     * 设置属性保单号码
     * @param policyNo 待设置的属性保单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号码
     * @return 属性保单号码的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性险种代码
     * @param riskCode 待设置的属性险种代码的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性险种代码
     * @return 属性险种代码的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性币别代码
     * @param currency 待设置的属性币别代码的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码
     * @return 属性币别代码的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性总保额
     * @param amount 待设置的属性总保额的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性总保额
     * @return 属性总保额的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性总保费
     * @param premium 待设置的属性总保费的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性总保费
     * @return 属性总保费的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性标志字段
     * @param flag 待设置的属性标志字段的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志字段
     * @return 属性标志字段的值
     */
    public String getFlag(){
        return flag;
    }
}
