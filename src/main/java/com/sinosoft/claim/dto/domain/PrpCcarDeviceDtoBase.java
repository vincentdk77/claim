package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpccardevice投保机动车新增设备信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcarDeviceDtoBase implements Serializable{
    /** 属性保险单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性标的序号 */
    private int itemNo = 0;
    /** 属性顺序号 */
    private int serialNo = 0;
    /** 属性设备名称 */
    private String deviceName = "";
    /** 属性币别 */
    private String currency = "";
    /** 属性数量 */
    private int quantity = 0;
    /** 属性新件购置价 */
    private double purchasePrice = 0d;
    /** 属性实际价值 */
    private double actualValue = 0d;
    /** 属性备注 */
    private String remark = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCcarDeviceDtoBase对象
     */
    public PrpCcarDeviceDtoBase(){
    }

    /**
     * 设置属性保险单号码
     * @param policyNo 待设置的属性保险单号码的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性保险单号码
     * @return 属性保险单号码的值
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
     * 设置属性顺序号
     * @param serialNo 待设置的属性顺序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性顺序号
     * @return 属性顺序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性设备名称
     * @param deviceName 待设置的属性设备名称的值
     */
    public void setDeviceName(String deviceName){
        this.deviceName = StringUtils.rightTrim(deviceName);
    }

    /**
     * 获取属性设备名称
     * @return 属性设备名称的值
     */
    public String getDeviceName(){
        return deviceName;
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
     * 设置属性数量
     * @param quantity 待设置的属性数量的值
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * 获取属性数量
     * @return 属性数量的值
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * 设置属性新件购置价
     * @param purchasePrice 待设置的属性新件购置价的值
     */
    public void setPurchasePrice(double purchasePrice){
        this.purchasePrice = purchasePrice;
    }

    /**
     * 获取属性新件购置价
     * @return 属性新件购置价的值
     */
    public double getPurchasePrice(){
        return purchasePrice;
    }

    /**
     * 设置属性实际价值
     * @param actualValue 待设置的属性实际价值的值
     */
    public void setActualValue(double actualValue){
        this.actualValue = actualValue;
    }

    /**
     * 获取属性实际价值
     * @return 属性实际价值的值
     */
    public double getActualValue(){
        return actualValue;
    }

    /**
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
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
