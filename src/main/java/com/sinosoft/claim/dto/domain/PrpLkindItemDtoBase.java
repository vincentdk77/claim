package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是承保险别标的表的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLkindItemDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性险别代码 */
    private String kindCode = "";
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
    /** 属性效力状态 */
    private String validStatus = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLkindItemDtoBase对象
     */
    public PrpLkindItemDtoBase(){
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
     * 设置属性效力状态
     * @param validStatus 待设置的属性效力状态的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态
     * @return 属性效力状态的值
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
