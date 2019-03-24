package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpPcoins的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpPcoinsDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性endorseNo */
    private String endorseNo = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性serialNo */
    private int serialNo = 0;
    /** 属性mainPolicyNo */
    private String mainPolicyNo = "";
    /** 属性coinsCode */
    private String coinsCode = "";
    /** 属性coinsName */
    private String coinsName = "";
    /** 属性coinsType */
    private String coinsType = "";
    /** 属性coinsRate */
    private double coinsRate = 0D;
    /** 属性flag */
    private String flag = "";
    /** 属性chiefFlag */
    private String chiefFlag = "";
    /** 属性proportionFlag */
    private String proportionFlag = "";
    /** 属性chgCoinsRate */
    private double chgCoinsRate = 0D;

    /**
     *  默认构造方法,构造一个默认的PrpPcoinsDtoBase对象
     */
    public PrpPcoinsDtoBase(){
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
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性mainPolicyNo
     * @param mainPolicyNo 待设置的属性mainPolicyNo的值
     */
    public void setMainPolicyNo(String mainPolicyNo){
        this.mainPolicyNo = StringUtils.rightTrim(mainPolicyNo);
    }

    /**
     * 获取属性mainPolicyNo
     * @return 属性mainPolicyNo的值
     */
    public String getMainPolicyNo(){
        return mainPolicyNo;
    }

    /**
     * 设置属性coinsCode
     * @param coinsCode 待设置的属性coinsCode的值
     */
    public void setCoinsCode(String coinsCode){
        this.coinsCode = StringUtils.rightTrim(coinsCode);
    }

    /**
     * 获取属性coinsCode
     * @return 属性coinsCode的值
     */
    public String getCoinsCode(){
        return coinsCode;
    }

    /**
     * 设置属性coinsName
     * @param coinsName 待设置的属性coinsName的值
     */
    public void setCoinsName(String coinsName){
        this.coinsName = StringUtils.rightTrim(coinsName);
    }

    /**
     * 获取属性coinsName
     * @return 属性coinsName的值
     */
    public String getCoinsName(){
        return coinsName;
    }

    /**
     * 设置属性coinsType
     * @param coinsType 待设置的属性coinsType的值
     */
    public void setCoinsType(String coinsType){
        this.coinsType = StringUtils.rightTrim(coinsType);
    }

    /**
     * 获取属性coinsType
     * @return 属性coinsType的值
     */
    public String getCoinsType(){
        return coinsType;
    }

    /**
     * 设置属性coinsRate
     * @param coinsRate 待设置的属性coinsRate的值
     */
    public void setCoinsRate(double coinsRate){
        this.coinsRate = coinsRate;
    }

    /**
     * 获取属性coinsRate
     * @return 属性coinsRate的值
     */
    public double getCoinsRate(){
        return coinsRate;
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
     * 设置属性chiefFlag
     * @param chiefFlag 待设置的属性chiefFlag的值
     */
    public void setChiefFlag(String chiefFlag){
        this.chiefFlag = StringUtils.rightTrim(chiefFlag);
    }

    /**
     * 获取属性chiefFlag
     * @return 属性chiefFlag的值
     */
    public String getChiefFlag(){
        return chiefFlag;
    }

    /**
     * 设置属性proportionFlag
     * @param proportionFlag 待设置的属性proportionFlag的值
     */
    public void setProportionFlag(String proportionFlag){
        this.proportionFlag = StringUtils.rightTrim(proportionFlag);
    }

    /**
     * 获取属性proportionFlag
     * @return 属性proportionFlag的值
     */
    public String getProportionFlag(){
        return proportionFlag;
    }

    /**
     * 设置属性chgCoinsRate
     * @param chgCoinsRate 待设置的属性chgCoinsRate的值
     */
    public void setChgCoinsRate(double chgCoinsRate){
        this.chgCoinsRate = chgCoinsRate;
    }

    /**
     * 获取属性chgCoinsRate
     * @return 属性chgCoinsRate的值
     */
    public double getChgCoinsRate(){
        return chgCoinsRate;
    }
}
