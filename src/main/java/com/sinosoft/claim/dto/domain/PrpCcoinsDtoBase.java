package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpccoins共保信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCcoinsDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性主保单号码 */
    private String mainPolicyNo = "";
    /** 属性共保人机构代码 */
    private String coinsCode = "";
    /** 属性共保人名称 */
    private String coinsName = "";
    /** 属性共保类型 */
    private String coinsType = "";
    /** 属性共保份额 */
    private double coinsRate = 0d;
    /** 属性标志字段 */
    private String flag = "";
    /** 属性ChiefFlag */
    private String chiefFlag = "";
    /** 属性ProportionFlag */
    private String proportionFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCcoinsDtoBase对象
     */
    public PrpCcoinsDtoBase(){
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
     * 设置属性主保单号码
     * @param mainPolicyNo 待设置的属性主保单号码的值
     */
    public void setMainPolicyNo(String mainPolicyNo){
        this.mainPolicyNo = StringUtils.rightTrim(mainPolicyNo);
    }

    /**
     * 获取属性主保单号码
     * @return 属性主保单号码的值
     */
    public String getMainPolicyNo(){
        return mainPolicyNo;
    }

    /**
     * 设置属性共保人机构代码
     * @param coinsCode 待设置的属性共保人机构代码的值
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * 获取属性共保人机构代码
     * @return 属性共保人机构代码的值
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * 设置属性共保人名称
     * @param coinsName 待设置的属性共保人名称的值
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * 获取属性共保人名称
     * @return 属性共保人名称的值
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * 设置属性共保类型
     * @param coinsType 待设置的属性共保类型的值
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * 获取属性共保类型
     * @return 属性共保类型的值
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * 设置属性共保份额
     * @param coinsRate 待设置的属性共保份额的值
     */
    public void setCoinsRate(double coinsRate){
        this.coinsRate = coinsRate;
    }

    /**
     * 获取属性共保份额
     * @return 属性共保份额的值
     */
    public double getCoinsRate(){
        return coinsRate;
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

    /**
     * 设置属性ChiefFlag
     * @param chiefFlag 待设置的属性ChiefFlag的值
     */
    public void setChiefFlag(String chiefFlag){
        this.chiefFlag = StringUtils.rightTrim(chiefFlag);
    }

    /**
     * 获取属性ChiefFlag
     * @return 属性ChiefFlag的值
     */
    public String getChiefFlag(){
        return chiefFlag;
    }

    /**
     * 设置属性ProportionFlag
     * @param proportionFlag 待设置的属性ProportionFlag的值
     */
    public void setProportionFlag(String proportionFlag){
        this.proportionFlag = StringUtils.rightTrim(proportionFlag);
    }

    /**
     * 获取属性ProportionFlag
     * @return 属性ProportionFlag的值
     */
    public String getProportionFlag(){
        return proportionFlag;
    }
}
