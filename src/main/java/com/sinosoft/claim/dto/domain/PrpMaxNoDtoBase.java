package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpmaxno单证号表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpMaxNoDtoBase implements Serializable{
    /** 属性编组 */
    private String groupNo = "";
    /** 属性编号 */
    private String maxNo = "";
    /** 属性表名 */
    private String tableName = "";
    /** 属性标志 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpMaxNoDtoBase对象
     */
    public PrpMaxNoDtoBase(){
    }

    /**
     * 设置属性编组
     * @param groupNo 待设置的属性编组的值
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * 获取属性编组
     * @return 属性编组的值
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * 设置属性编号
     * @param maxNo 待设置的属性编号的值
     */
    public void setMaxNo(String maxNo){
        this.maxNo = StringUtils.rightTrim(maxNo);
    }

    /**
     * 获取属性编号
     * @return 属性编号的值
     */
    public String getMaxNo(){
        return maxNo;
    }

    /**
     * 设置属性表名
     * @param tableName 待设置的属性表名的值
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * 获取属性表名
     * @return 属性表名的值
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * 设置属性标志
     * @param flag 待设置的属性标志的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志
     * @return 属性标志的值
     */
    public String getFlag(){
        return flag;
    }
}
