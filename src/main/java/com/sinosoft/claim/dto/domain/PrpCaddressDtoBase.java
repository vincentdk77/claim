package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcaddress保险地址表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCaddressDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性地址序号 */
    private int addressNo = 0;
    /** 属性地址编码 */
    private String addressCode = "";
    /** 属性地址 */
    private String addressName = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCaddressDtoBase对象
     */
    public PrpCaddressDtoBase(){
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
     * 设置属性地址序号
     * @param addressNo 待设置的属性地址序号的值
     */
    public void setAddressNo(int addressNo){
        this.addressNo = addressNo;
    }

    /**
     * 获取属性地址序号
     * @return 属性地址序号的值
     */
    public int getAddressNo(){
        return addressNo;
    }

    /**
     * 设置属性地址编码
     * @param addressCode 待设置的属性地址编码的值
     */
    public void setAddressCode(String addressCode){
        this.addressCode = StringUtils.rightTrim(addressCode);
    }

    /**
     * 获取属性地址编码
     * @return 属性地址编码的值
     */
    public String getAddressCode(){
        return addressCode;
    }

    /**
     * 设置属性地址
     * @param addressName 待设置的属性地址的值
     */
    public void setAddressName(String addressName){
        this.addressName = StringUtils.rightTrim(addressName);
    }

    /**
     * 获取属性地址
     * @return 属性地址的值
     */
    public String getAddressName(){
        return addressName;
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
