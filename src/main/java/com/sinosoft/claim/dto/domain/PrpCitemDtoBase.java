package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcitem保险标的项目表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCitemDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性标的序号 */
    private int itemNo = 0;
    /** 属性标的项目类别代码 */
    private String itemCode = "";
    /** 属性标的项目类别名称 */
    private String itemName = "";
    /** 属性加成比例 */
    private double plusRate = 0d;
    /** 属性标的地址序号 */
    private int addressNo = 0;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCitemDtoBase对象
     */
    public PrpCitemDtoBase(){
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
     * 设置属性标的序号
     * @param itemNo 待设置的属性标的序号的值
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性标的项目类别代码
     * @param itemCode 待设置的属性标的项目类别代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的项目类别代码
     * @return 属性标的项目类别代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性标的项目类别名称
     * @param itemName 待设置的属性标的项目类别名称的值
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * 获取属性标的项目类别名称
     * @return 属性标的项目类别名称的值
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * 设置属性加成比例
     * @param plusRate 待设置的属性加成比例的值
     */
    public void setPlusRate(double plusRate){
        this.plusRate = plusRate;
    }

    /**
     * 获取属性加成比例
     * @return 属性加成比例的值
     */
    public double getPlusRate(){
        return plusRate;
    }

    /**
     * 设置属性标的地址序号
     * @param addressNo 待设置的属性标的地址序号的值
     */
    public void setAddressNo(int addressNo){
        this.addressNo = addressNo;
    }

    /**
     * 获取属性标的地址序号
     * @return 属性标的地址序号的值
     */
    public int getAddressNo(){
        return addressNo;
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
