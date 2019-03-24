package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpUndoCancelFee作废或删除操作轨迹附表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:06<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpUndoCancelFeeDtoBase implements Serializable{
    /** 属性操作类型代码 */
    private String operateTypeCode = "";
    /** 属性单证号 */
    private String certiNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性币别代码 */
    private String currency = "";
    /** 属性总保额（变化） */
    private double amount = 0d;
    /** 属性总保费（变化） */
    private double premium = 0d;
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpUndoCancelFeeDtoBase对象
     */
    public PrpUndoCancelFeeDtoBase(){
    }

    /**
     * 设置属性操作类型代码
     * @param operateTypeCode 待设置的属性操作类型代码的值
     */
    public void setOperateTypeCode(String operateTypeCode){
        this.operateTypeCode = StringUtils.rightTrim(operateTypeCode);
    }

    /**
     * 获取属性操作类型代码
     * @return 属性操作类型代码的值
     */
    public String getOperateTypeCode(){
        return operateTypeCode;
    }

    /**
     * 设置属性单证号
     * @param certiNo 待设置的属性单证号的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性单证号
     * @return 属性单证号的值
     */
    public String getCertiNo(){
        return certiNo;
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
     * 设置属性总保额（变化）
     * @param amount 待设置的属性总保额（变化）的值
     */
    public void setAmount(double amount){
        this.amount = amount;
    }

    /**
     * 获取属性总保额（变化）
     * @return 属性总保额（变化）的值
     */
    public double getAmount(){
        return amount;
    }

    /**
     * 设置属性总保费（变化）
     * @param premium 待设置的属性总保费（变化）的值
     */
    public void setPremium(double premium){
        this.premium = premium;
    }

    /**
     * 获取属性总保费（变化）
     * @return 属性总保费（变化）的值
     */
    public double getPremium(){
        return premium;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
