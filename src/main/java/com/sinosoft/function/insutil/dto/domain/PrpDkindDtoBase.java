package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdkind的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDkindDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性kindcode */
    private String kindCode = "";
    /** 属性kindcname */
    private String kindCName = "";
    /** 属性kindename */
    private String kindEName = "";
    /** 属性calculateflag */
    private String calculateFlag = "";
    /** 属性newkindcode */
    private String newKindCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDkindDtoBase对象
     */
    public PrpDkindDtoBase(){
    }

    /**
     * 设置属性riskcode
     * @param riskCode 待设置的属性riskcode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskcode
     * @return 属性riskcode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性kindcode
     * @param kindCode 待设置的属性kindcode的值
     */
    public void setKindCode(String kindCode){
        this.kindCode = StringUtils.rightTrim(kindCode);
    }

    /**
     * 获取属性kindcode
     * @return 属性kindcode的值
     */
    public String getKindCode(){
        return kindCode;
    }

    /**
     * 设置属性kindcname
     * @param kindCName 待设置的属性kindcname的值
     */
    public void setKindCName(String kindCName){
        this.kindCName = StringUtils.rightTrim(kindCName);
    }

    /**
     * 获取属性kindcname
     * @return 属性kindcname的值
     */
    public String getKindCName(){
        return kindCName;
    }

    /**
     * 设置属性kindename
     * @param kindEName 待设置的属性kindename的值
     */
    public void setKindEName(String kindEName){
        this.kindEName = StringUtils.rightTrim(kindEName);
    }

    /**
     * 获取属性kindename
     * @return 属性kindename的值
     */
    public String getKindEName(){
        return kindEName;
    }

    /**
     * 设置属性calculateflag
     * @param calculateFlag 待设置的属性calculateflag的值
     */
    public void setCalculateFlag(String calculateFlag){
        this.calculateFlag = StringUtils.rightTrim(calculateFlag);
    }

    /**
     * 获取属性calculateflag
     * @return 属性calculateflag的值
     */
    public String getCalculateFlag(){
        return calculateFlag;
    }

    /**
     * 设置属性newkindcode
     * @param newKindCode 待设置的属性newkindcode的值
     */
    public void setNewKindCode(String newKindCode){
        this.newKindCode = StringUtils.rightTrim(newKindCode);
    }

    /**
     * 获取属性newkindcode
     * @return 属性newkindcode的值
     */
    public String getNewKindCode(){
        return newKindCode;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
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
}
