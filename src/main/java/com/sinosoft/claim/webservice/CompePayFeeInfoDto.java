package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class CompePayFeeInfoDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性标的序号 PK */
    private int itemKindNoForCharge = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性费用代码 */
    private String codeCode = "";
    /** 属性费用名称 */
    private String codeCName = "";
    /** 属性代查勘机构名称 */
    private String checkDeptName = "";
    /** 属性币别代码默认CNY */
    private String currency = "";
    /** 属性币别名称 */
    private String currencyName = "";
    /** 属性费用金额 */
    private double chargeAmount = 0D;
    /** 属性预付费用 */
    private double preChargeAmount = 0D;
    /** 属性计入赔款金额 */
    private double sumRealPay = 0D;
    /** 属性代查勘机构代码 */
    private String checkDeptCode = "";

    /**
     *  默认构造方法,构造一个默认的CompePayFeeInfoDto对象
     */
    public CompePayFeeInfoDto(){
    }

    /**
     * 设置属性标的序号 PK
     * @param itemKindNo 待设置的属性标的序号 PK的值
     */
    public void setItemKindNoForCharge(int itemKindNoForCharge){
        this.itemKindNoForCharge = itemKindNoForCharge;
    }

    /**
     * 获取属性标的序号 PK
     * @return 属性标的序号 PK的值
     */
    public int getItemKindNoForCharge(){
        return itemKindNoForCharge;
    }
    
    /**
     * 设置属性险别代码
     * @param currency 待设置的属性险别代码的值
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
     * 设置属性险别名称
     * @param currency 待设置的属性险别名称的值
     */
    public void setKindName(String kindName){
        this.kindName = StringUtils.rightTrim(kindName);
    }

    /**
     * 获取属性险别名称
     * @return 属性险别名称的值
     */
    public String getKindName(){
        return kindName;
    }

    /**
     * 设置属性费用代码
     * @param codeCode 待设置的属性费用代码的值
     */
    public void setCodeCode(String codeCode){
        this.codeCode = StringUtils.rightTrim(codeCode);
    }

    /**
     * 获取属性费用代码
     * @return 属性费用代码的值
     */
    public String getCodeCode(){
        return codeCode;
    }

    /**
     * 设置属性费用名称
     * @param codeCName 待设置的属性费用名称的值
     */
    public void setCodeCName(String codeCName){
        this.codeCName = StringUtils.rightTrim(codeCName);
    }

    /**
     * 获取属性费用名称
     * @return 属性费用名称的值
     */
    public String getCodeCName(){
        return codeCName;
    }

    /**
     * 设置属性代查勘机构名称
     * @param checkDeptName 待设置的属性代查勘机构名称的值
     */
    public void setCheckDeptName(String checkDeptName){
        this.checkDeptName = StringUtils.rightTrim(checkDeptName);
    }

    /**
     * 获取属性代查勘机构名称
     * @return 属性代查勘机构名称的值
     */
    public String getCheckDeptName(){
        return checkDeptName;
    }

    /**
     * 设置属性币别代码默认CNY
     * @param currency 待设置的属性币别代码默认CNY的值
     */
    public void setCurrency(String currency){
        this.currency = StringUtils.rightTrim(currency);
    }

    /**
     * 获取属性币别代码默认CNY
     * @return 属性币别代码默认CNY的值
     */
    public String getCurrency(){
        return currency;
    }

    /**
     * 设置属性币别名称
     * @param currencyName 待设置的属性币别名称的值
     */
    public void setCurrencyName(String currencyName){
        this.currencyName = StringUtils.rightTrim(currencyName);
    }

    /**
     * 获取属性币别名称
     * @return 属性币别名称的值
     */
    public String getCurrencyName(){
        return currencyName;
    }

    /**
     * 设置属性费用金额
     * @param chargeAmount 待设置的属性费用金额的值
     */
    public void setChargeAmount(double chargeAmount){
        this.chargeAmount = chargeAmount;
    }

    /**
     * 获取属性费用金额
     * @return 属性费用金额的值
     */
    public double getChargeAmount(){
        return chargeAmount;
    }

    /**
     * 设置属性预付费用
     * @param preChargeAmount 待设置的属性预付费用的值
     */
    public void setPreChargeAmount(double preChargeAmount){
        this.preChargeAmount = preChargeAmount;
    }

    /**
     * 获取属性预付费用
     * @return 属性预付费用的值
     */
    public double getPreChargeAmount(){
        return preChargeAmount;
    }

    /**
     * 设置属性计入赔款金额
     * @param sumRealPay 待设置的属性计入赔款金额的值
     */
    public void setSumRealPay(double sumRealPay){
        this.sumRealPay = sumRealPay;
    }

    /**
     * 获取属性计入赔款金额
     * @return 属性计入赔款金额的值
     */
    public double getSumRealPay(){
        return sumRealPay;
    }
    
    /**
     * 设置属性代查勘机构代码
     * @param checkDeptName 待设置的属性代查勘机构代码的值
     */
    public void setCheckDeptCode(String checkDeptCode){
        this.checkDeptCode = StringUtils.rightTrim(checkDeptCode);
    }

    /**
     * 获取属性代查勘机构代码
     * @return 属性代查勘机构代码的值
     */
    public String getCheckDeptCode(){
        return checkDeptCode;
    }
}
