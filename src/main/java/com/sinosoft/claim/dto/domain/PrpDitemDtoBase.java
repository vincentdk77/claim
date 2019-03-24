package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpditem标的项目代码表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDitemDtoBase implements Serializable{
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性标的项目代码 */
    private String itemCode = "";
    /** 属性标的项目中文名称 */
    private String itemCName = "";
    /** 属性标的项目英文名称 */
    private String itemEName = "";
    /** 属性标的项目类别标志 */
    private String itemFlag = "";
    /** 属性新的标的项目类别代码 */
    private String newItemCode = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDitemDtoBase对象
     */
    public PrpDitemDtoBase(){
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
     * 设置属性标的项目代码
     * @param itemCode 待设置的属性标的项目代码的值
     */
    public void setItemCode(String itemCode){
        this.itemCode = StringUtils.rightTrim(itemCode);
    }

    /**
     * 获取属性标的项目代码
     * @return 属性标的项目代码的值
     */
    public String getItemCode(){
        return itemCode;
    }

    /**
     * 设置属性标的项目中文名称
     * @param itemCName 待设置的属性标的项目中文名称的值
     */
    public void setItemCName(String itemCName){
        this.itemCName = StringUtils.rightTrim(itemCName);
    }

    /**
     * 获取属性标的项目中文名称
     * @return 属性标的项目中文名称的值
     */
    public String getItemCName(){
        return itemCName;
    }

    /**
     * 设置属性标的项目英文名称
     * @param itemEName 待设置的属性标的项目英文名称的值
     */
    public void setItemEName(String itemEName){
        this.itemEName = StringUtils.rightTrim(itemEName);
    }

    /**
     * 获取属性标的项目英文名称
     * @return 属性标的项目英文名称的值
     */
    public String getItemEName(){
        return itemEName;
    }

    /**
     * 设置属性标的项目类别标志
     * @param itemFlag 待设置的属性标的项目类别标志的值
     */
    public void setItemFlag(String itemFlag){
        this.itemFlag = StringUtils.rightTrim(itemFlag);
    }

    /**
     * 获取属性标的项目类别标志
     * @return 属性标的项目类别标志的值
     */
    public String getItemFlag(){
        return itemFlag;
    }

    /**
     * 设置属性新的标的项目类别代码
     * @param newItemCode 待设置的属性新的标的项目类别代码的值
     */
    public void setNewItemCode(String newItemCode){
        this.newItemCode = StringUtils.rightTrim(newItemCode);
    }

    /**
     * 获取属性新的标的项目类别代码
     * @return 属性新的标的项目类别代码的值
     */
    public String getNewItemCode(){
        return newItemCode;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
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
