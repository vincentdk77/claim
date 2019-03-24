package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdagentcom承保地区,承保公司表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentComDtoBase implements Serializable{
    /** 属性承保地区代码 */
    private String centreCode = "";
    /** 属性承保地区名称 */
    private String centreName = "";
    /** 属性承保公司代码 */
    private String unitCode = "";
    /** 属性承保公司名称 */
    private String unitName = "";

    /**
     *  默认构造方法,构造一个默认的PrpDagentComDtoBase对象
     */
    public PrpDagentComDtoBase(){
    }

    /**
     * 设置属性承保地区代码
     * @param centreCode 待设置的属性承保地区代码的值
     */
    public void setCentreCode(String centreCode){
        this.centreCode = StringUtils.rightTrim(centreCode);
    }

    /**
     * 获取属性承保地区代码
     * @return 属性承保地区代码的值
     */
    public String getCentreCode(){
        return centreCode;
    }

    /**
     * 设置属性承保地区名称
     * @param centreName 待设置的属性承保地区名称的值
     */
    public void setCentreName(String centreName){
        this.centreName = StringUtils.rightTrim(centreName);
    }

    /**
     * 获取属性承保地区名称
     * @return 属性承保地区名称的值
     */
    public String getCentreName(){
        return centreName;
    }

    /**
     * 设置属性承保公司代码
     * @param unitCode 待设置的属性承保公司代码的值
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * 获取属性承保公司代码
     * @return 属性承保公司代码的值
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * 设置属性承保公司名称
     * @param unitName 待设置的属性承保公司名称的值
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * 获取属性承保公司名称
     * @return 属性承保公司名称的值
     */
    public String getUnitName(){
        return unitName;
    }
}
