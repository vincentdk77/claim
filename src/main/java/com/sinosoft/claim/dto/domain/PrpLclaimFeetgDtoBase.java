package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLclaimFee-估损金额表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.281<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLclaimFeetgDtoBase implements Serializable{
    /** 属性赔案号号 */
    private String claimNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性索赔金额 */
    private double sumClaim = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLclaimFeetgDtoBase对象
     */
    public PrpLclaimFeetgDtoBase(){
    }

    /**
     * 设置属性赔案号号
     * @param claimNo 待设置的属性赔案号号的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号号
     * @return 属性赔案号号的值
     */
    public String getClaimNo(){
        return claimNo;
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
     * 设置属性索赔金额
     * @param sumClaim 待设置的属性索赔金额的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性索赔金额
     * @return 属性索赔金额的值
     */
    public double getSumClaim(){
        return sumClaim;
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
