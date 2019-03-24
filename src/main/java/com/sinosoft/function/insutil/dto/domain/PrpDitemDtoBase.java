package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpditem的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDitemDtoBase implements Serializable{
    /** 属性riskcode */
    private String riskCode = "";
    /** 属性itemcode */
    private String itemCode = "";
    /** 属性itemcname */
    private String itemCName = "";
    /** 属性itemename */
    private String itemEName = "";
    /** 属性itemflag */
    private String itemFlag = "";
    /** 属性newitemcode */
    private String newItemCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDitemDtoBase对象
     */
    public PrpDitemDtoBase(){
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
     * 设置属性itemcode
     * @param itemCode 待设置的属性itemcode的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性itemcode
     * @return 属性itemcode的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性itemcname
     * @param itemCName 待设置的属性itemcname的值
     */
    public void setItemCName(String itemCName){
        this.itemCName = StringUtils.rightTrim(itemCName);
    }

    /**
     * 获取属性itemcname
     * @return 属性itemcname的值
     */
    public String getItemCName(){
        return itemCName;
    }

    /**
     * 设置属性itemename
     * @param itemEName 待设置的属性itemename的值
     */
    public void setItemEName(String itemEName){
        this.itemEName = StringUtils.rightTrim(itemEName);
    }

    /**
     * 获取属性itemename
     * @return 属性itemename的值
     */
    public String getItemEName(){
        return itemEName;
    }

    /**
     * 设置属性itemflag
     * @param itemFlag 待设置的属性itemflag的值
     */
    public void setItemFlag(String itemFlag){
        this.itemFlag = StringUtils.rightTrim(itemFlag);
    }

    /**
     * 获取属性itemflag
     * @return 属性itemflag的值
     */
    public String getItemFlag(){
        return itemFlag;
    }

    /**
     * 设置属性newitemcode
     * @param newItemCode 待设置的属性newitemcode的值
     */
    public void setNewItemCode(String newItemCode){
        this.newItemCode = StringUtils.rightTrim(newItemCode);
    }

    /**
     * 获取属性newitemcode
     * @return 属性newitemcode的值
     */
    public String getNewItemCode(){
        return newItemCode;
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
