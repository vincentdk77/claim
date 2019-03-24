package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLendor的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLendorDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性claimNo */
    private String claimNo = "";
    /** 属性compensateNo */
    private String compensateNo = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性itemKindNo */
    private int itemKindNo = 0;
    /** 属性itemCode */
    private String itemCode = "";
    /** 属性itemName */
    private String itemName = "";
    /** 属性kindCode */
    private String kindCode = "";
    /** 属性kindName */
    private String kindName = "";
    /** 属性currency */
    private String currency = "";
    /** 属性endorAmount */
    private double endorAmount = 0D;
    /** 属性inputDate */
    private DateTime inputDate = new DateTime();
    /** 属性flag */
    private String flag = "";
    /** 属性endorseNo */
    private String endorseNo = "";
    /** 属性endorType */
    private String endorType = "";
    /** 属性endorGrossQuantity */
    private double endorGrossQuantity = 0D;

    /**
     *  默认构造方法,构造一个默认的PrpLendorDtoBase对象
     */
    public PrpLendorDtoBase(){
    }

    /**
     * 设置属性claimNo
     * @param claimNo 待设置的属性claimNo的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性claimNo
     * @return 属性claimNo的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性compensateNo
     * @param compensateNo 待设置的属性compensateNo的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性compensateNo
     * @return 属性compensateNo的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性itemKindNo
     * @param itemKindNo 待设置的属性itemKindNo的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性itemKindNo
     * @return 属性itemKindNo的值
     */
    public int getItemKindNo(){
        return itemKindNo;
    }

    /**
     * 设置属性itemCode
     * @param itemCode 待设置的属性itemCode的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性itemCode
     * @return 属性itemCode的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性itemName
     * @param itemName 待设置的属性itemName的值
     */
    public void setItemName(String itemName){
        this.itemName = StringUtils.rightTrim(itemName);
    }

    /**
     * 获取属性itemName
     * @return 属性itemName的值
     */
    public String getItemName(){
        return itemName;
    }

    /**
     * 设置属性kindCode
     * @param kindCode 待设置的属性kindCode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性kindCode
     * @return 属性kindCode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性kindName
     * @param kindName 待设置的属性kindName的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性kindName
     * @return 属性kindName的值
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * 设置属性currency
     * @param currency 待设置的属性currency的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性currency
     * @return 属性currency的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性endorAmount
     * @param endorAmount 待设置的属性endorAmount的值
     */
    public void setEndorAmount(double endorAmount){
        this.endorAmount = endorAmount;
    }

    /**
     * 获取属性endorAmount
     * @return 属性endorAmount的值
     */
    public double getEndorAmount(){
        return endorAmount;
    }

    /**
     * 设置属性inputDate
     * @param inputDate 待设置的属性inputDate的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性inputDate
     * @return 属性inputDate的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性flag
     * @param flag 待设置的属性flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性flag
     * @return 属性flag的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性endorseNo
     * @param endorseNo 待设置的属性endorseNo的值
     */
    public void setEndorseNo(String endorseNo){
        this.endorseNo = StringUtils.rightTrim(endorseNo);
    }

    /**
     * 获取属性endorseNo
     * @return 属性endorseNo的值
     */
    public String getEndorseNo(){
        return endorseNo;
    }

    /**
     * 设置属性endorType
     * @param endorType 待设置的属性endorType的值
     */
    public void setEndorType(String endorType){
        this.endorType = StringUtils.rightTrim(endorType);
    }

    /**
     * 获取属性endorType
     * @return 属性endorType的值
     */
    public String getEndorType(){
        return endorType;
    }

    /**
     * 设置属性endorGrossQuantity
     * @param endorGrossQuantity 待设置的属性endorGrossQuantity的值
     */
    public void setEndorGrossQuantity(double endorGrossQuantity){
        this.endorGrossQuantity = endorGrossQuantity;
    }

    /**
     * 获取属性endorGrossQuantity
     * @return 属性endorGrossQuantity的值
     */
    public double getEndorGrossQuantity(){
        return endorGrossQuantity;
    }
}
