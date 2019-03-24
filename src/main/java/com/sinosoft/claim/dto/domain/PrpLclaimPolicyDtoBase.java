package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLclaimPolicy-立案保单清单表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.609<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimPolicyDtoBase implements Serializable{
    /** 属性赔案号 */
    private String claimNo = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性总保额 */
    private double sumAmount = 0d;
    /** 属性总保费 */
    private double sumPremium = 0d;
    /** 属性备用 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLclaimPolicyDtoBase对象
     */
    public PrpLclaimPolicyDtoBase(){
    }

    /**
     * 设置属性赔案号
     * @param claimNo 待设置的属性赔案号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号
     * @return 属性赔案号的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性保单号
     * @param policyNo 待设置的属性保单号的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保单号
     * @return 属性保单号的值
     */
    public String getPolicyNo(){
        return policyNo;
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
     * 设置属性总保额
     * @param sumAmount 待设置的属性总保额的值
     */
    public void setSumAmount(double sumAmount){
        this.sumAmount = sumAmount;
    }

    /**
     * 获取属性总保额
     * @return 属性总保额的值
     */
    public double getSumAmount(){
        return sumAmount;
    }

    /**
     * 设置属性总保费
     * @param sumPremium 待设置的属性总保费的值
     */
    public void setSumPremium(double sumPremium){
        this.sumPremium = sumPremium;
    }

    /**
     * 获取属性总保费
     * @return 属性总保费的值
     */
    public double getSumPremium(){
        return sumPremium;
    }

    /**
     * 设置属性备用
     * @param flag 待设置的属性备用的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性备用
     * @return 属性备用的值
     */
    public String getFlag(){
        return flag;
    }
}
