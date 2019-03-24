package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcbatch批量保单附表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCbatchDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性单证号码 */
    private String visaCode = "";
    /** 属性起始单号 */
    private String billStartNo = "";
    /** 属性终止单号 */
    private String billEndNo = "";
    /** 属性总单数 */
    private int billCount = 0;
    /** 属性币别代码 */
    private String currency = "";
    /** 属性总保额 */
    private double sumAmount = 0d;
    /** 属性总保费 */
    private double sumPremium = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCbatchDtoBase对象
     */
    public PrpCbatchDtoBase(){
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
     * 设置属性序号
     * @param serialNo 待设置的属性序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性序号
     * @return 属性序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性单证号码
     * @param visaCode 待设置的属性单证号码的值
     */
    public void setVisaCode(String visaCode){
        this.visaCode = StringUtils.rightTrim(visaCode);
    }

    /**
     * 获取属性单证号码
     * @return 属性单证号码的值
     */
    public String getVisaCode(){
        return visaCode;
    }

    /**
     * 设置属性起始单号
     * @param billStartNo 待设置的属性起始单号的值
     */
    public void setBillStartNo(String billStartNo){
        this.billStartNo = StringUtils.rightTrim(billStartNo);
    }

    /**
     * 获取属性起始单号
     * @return 属性起始单号的值
     */
    public String getBillStartNo(){
        return billStartNo;
    }

    /**
     * 设置属性终止单号
     * @param billEndNo 待设置的属性终止单号的值
     */
    public void setBillEndNo(String billEndNo){
        this.billEndNo = StringUtils.rightTrim(billEndNo);
    }

    /**
     * 获取属性终止单号
     * @return 属性终止单号的值
     */
    public String getBillEndNo(){
        return billEndNo;
    }

    /**
     * 设置属性总单数
     * @param billCount 待设置的属性总单数的值
     */
    public void setBillCount(int billCount){
        this.billCount = billCount;
    }

    /**
     * 获取属性总单数
     * @return 属性总单数的值
     */
    public int getBillCount(){
        return billCount;
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
