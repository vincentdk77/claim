package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcinsuredext关系人扩展信息表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCinsuredExtDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性扩充字段名 */
    private String columnName = "";
    /** 属性显示名称 */
    private String displayName = "";
    /** 属性扩充字段内容 */
    private String columnValue = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCinsuredExtDtoBase对象
     */
    public PrpCinsuredExtDtoBase(){
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
     * 设置属性扩充字段名
     * @param columnName 待设置的属性扩充字段名的值
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * 获取属性扩充字段名
     * @return 属性扩充字段名的值
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * 设置属性显示名称
     * @param displayName 待设置的属性显示名称的值
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * 获取属性显示名称
     * @return 属性显示名称的值
     */
    public String getDisplayName(){
        return displayName;
    }

    /**
     * 设置属性扩充字段内容
     * @param columnValue 待设置的属性扩充字段内容的值
     */
    public void setColumnValue(String columnValue){
        this.columnValue = StringUtils.rightTrim(columnValue);
    }

    /**
     * 获取属性扩充字段内容
     * @return 属性扩充字段内容的值
     */
    public String getColumnValue(){
        return columnValue;
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
