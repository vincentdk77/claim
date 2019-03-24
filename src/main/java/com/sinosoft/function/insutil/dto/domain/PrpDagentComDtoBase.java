package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdagentcom的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDagentComDtoBase implements Serializable{
    /** 属性centrecode */
    private String centreCode = "";
    /** 属性centrename */
    private String centreName = "";
    /** 属性unitcode */
    private String unitCode = "";
    /** 属性unitname */
    private String unitName = "";

    /**
     *  默认构造方法,构造一个默认的PrpDagentComDtoBase对象
     */
    public PrpDagentComDtoBase(){
    }

    /**
     * 设置属性centrecode
     * @param centreCode 待设置的属性centrecode的值
     */
    public void setCentreCode(String centreCode){
        this.centreCode = StringUtils.rightTrim(centreCode);
    }

    /**
     * 获取属性centrecode
     * @return 属性centrecode的值
     */
    public String getCentreCode(){
        return centreCode;
    }

    /**
     * 设置属性centrename
     * @param centreName 待设置的属性centrename的值
     */
    public void setCentreName(String centreName){
        this.centreName = StringUtils.rightTrim(centreName);
    }

    /**
     * 获取属性centrename
     * @return 属性centrename的值
     */
    public String getCentreName(){
        return centreName;
    }

    /**
     * 设置属性unitcode
     * @param unitCode 待设置的属性unitcode的值
     */
    public void setUnitCode(String unitCode){
        this.unitCode = StringUtils.rightTrim(unitCode);
    }

    /**
     * 获取属性unitcode
     * @return 属性unitcode的值
     */
    public String getUnitCode(){
        return unitCode;
    }

    /**
     * 设置属性unitname
     * @param unitName 待设置的属性unitname的值
     */
    public void setUnitName(String unitName){
        this.unitName = StringUtils.rightTrim(unitName);
    }

    /**
     * 获取属性unitname
     * @return 属性unitname的值
     */
    public String getUnitName(){
        return unitName;
    }
}
