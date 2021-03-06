package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

public class ClaimKindDto implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性事故者名称 */
    private String familyName = "";
    /** 属性标的序号 */
    private int itemKindNo = 0;
    /** 属性险别代码 */
    private String kindCode = "";
    /** 属性险别名称 */
    private String kindName = "";
    /** 属性币别代码 */
    private String currency = "";
    /** 属性预计给付金额 */
    private double sumClaim = 0D;
    /** 属性类别:p赔款z费用 */
    private String lossFeeType = "";
    /** 属性残值 */
    private double kindRest = 0D;

    /**
     *  默认构造方法,构造一个默认的ClaimKindDto对象
     */
    public ClaimKindDto(){
    }

    /**
     * 设置属性事故者名称
     * @param familyName 待设置的属性事故者名称的值
     */
    public void setFamilyName(String familyName){
        this.familyName = StringUtils.rightTrim(familyName);
    }

    /**
     * 获取属性事故者名称
     * @return 属性事故者名称的值
     */
    public String getFamilyName(){
        return familyName;
    }

    /**
     * 设置属性标的序号
     * @param itemKindNo 待设置的属性标的序号的值
     */
    public void setItemKindNo(int itemKindNo){
        this.itemKindNo = itemKindNo;
    }

    /**
     * 获取属性标的序号
     * @return 属性标的序号的值
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
     * 设置属性险别名称
     * @param kindName 待设置的属性险别名称的值
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
     * 设置属性预计给付金额
     * @param sumClaim 待设置的属性预计给付金额的值
     */
    public void setSumClaim(double sumClaim){
        this.sumClaim = sumClaim;
    }

    /**
     * 获取属性预计给付金额
     * @return 属性预计给付金额的值
     */
    public double getSumClaim(){
        return sumClaim;
    }

    /**
     * 设置属性类别:p赔款z费用
     * @param lossFeeType 待设置的属性类别:p赔款z费用的值
     */
    public void setLossFeeType(String lossFeeType){
        this.lossFeeType = StringUtils.rightTrim(lossFeeType);
    }

    /**
     * 获取属性类别:p赔款z费用
     * @return 属性类别:p赔款z费用的值
     */
    public String getLossFeeType(){
        return lossFeeType;
    }

    /**
     * 设置属性残值
     * @param kindRest 待设置的属性残值的值
     */
    public void setKindRest(double kindRest){
        this.kindRest = kindRest;
    }

    /**
     * 获取属性残值
     * @return 属性残值的值
     */
    public double getKindRest(){
        return kindRest;
    }
}
