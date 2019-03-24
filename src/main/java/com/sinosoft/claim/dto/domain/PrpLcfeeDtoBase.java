package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcfee-赔款计算金额表的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.218<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcfeeDtoBase implements Serializable{
    /** 属性赔款计算书号 */
    private String compensateNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号 */
    private String policyNo = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性赔付金额 */
    private double sumPaid = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcfeeDtoBase对象
     */
    public PrpLcfeeDtoBase(){
    }

    /**
     * 设置属性赔款计算书号
     * @param compensateNo 待设置的属性赔款计算书号的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性赔款计算书号
     * @return 属性赔款计算书号的值
     */
    public String getCompensateNo(){
        return compensateNo;
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
     * 设置属性赔付金额
     * @param sumPaid 待设置的属性赔付金额的值
     */
    public void setSumPaid(double sumPaid){
        this.sumPaid = sumPaid;
    }

    /**
     * 获取属性赔付金额
     * @return 属性赔付金额的值
     */
    public double getSumPaid(){
        return sumPaid;
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
