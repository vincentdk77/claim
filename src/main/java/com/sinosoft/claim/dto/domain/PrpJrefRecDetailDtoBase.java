package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpjrefrecdetail付费登记明细表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpJrefRecDetailDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性单号类型 */
    private String certiType = "";
    /** 属性保单号码/批单号码/赔款计算书号码 */
    private String certiNo = "";
    /** 属性本次付费序号 */
    private int serialNo = 0;
    /** 属性标的险别序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性标的代码 */
    private String itemCode = "";
    /** 属性应付币种 */
    private String currency1 = "";
    /** 属性应付金额 */
    private double refundFee = 0d;

    /**
     *  默认构造方法,构造一个默认的PrpJrefRecDetailDtoBase对象
     */
    public PrpJrefRecDetailDtoBase(){
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
     * 设置属性单号类型
     * @param certiType 待设置的属性单号类型的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性单号类型
     * @return 属性单号类型的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性保单号码/批单号码/赔款计算书号码
     * @param certiNo 待设置的属性保单号码/批单号码/赔款计算书号码的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性保单号码/批单号码/赔款计算书号码
     * @return 属性保单号码/批单号码/赔款计算书号码的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性本次付费序号
     * @param serialNo 待设置的属性本次付费序号的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性本次付费序号
     * @return 属性本次付费序号的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性标的险别序号
     * @param itemKindNo 待设置的属性标的险别序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的险别序号
     * @return 属性标的险别序号的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性险别代码
     * @param kindCode 待设置的属性险别代码的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性险别代码
     * @return 属性险别代码的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性标的代码
     * @param itemCode 待设置的属性标的代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的代码
     * @return 属性标的代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性应付币种
     * @param currency1 待设置的属性应付币种的值
     */
    public void setCurrency1(String currency1){
        this.currency1 = StringUtils.rightTrim(currency1);
    }

    /**
     * 获取属性应付币种
     * @return 属性应付币种的值
     */
    public String getCurrency1(){
        return currency1;
    }

    /**
     * 设置属性应付金额
     * @param refundFee 待设置的属性应付金额的值
     */
    public void setRefundFee(double refundFee){
        this.refundFee = refundFee;
    }

    /**
     * 获取属性应付金额
     * @return 属性应付金额的值
     */
    public double getRefundFee(){
        return refundFee;
    }
}
