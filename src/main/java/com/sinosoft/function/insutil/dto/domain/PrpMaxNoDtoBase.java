package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpmaxno的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:08<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpMaxNoDtoBase implements Serializable{
    /** 属性groupno */
    private String groupNo = "";
    /** 属性tablename */
    private String tableName = "";
    /** 属性maxno */
    private String maxNo = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpMaxNoDtoBase对象
     */
    public PrpMaxNoDtoBase(){
    }

    /**
     * 设置属性groupno
     * @param groupNo 待设置的属性groupno的值
     */
    public void setGroupNo(String groupNo){
        this.groupNo = StringUtils.rightTrim(groupNo);
    }

    /**
     * 获取属性groupno
     * @return 属性groupno的值
     */
    public String getGroupNo(){
        return groupNo;
    }

    /**
     * 设置属性tablename
     * @param tableName 待设置的属性tablename的值
     */
    public void setTableName(String tableName){
        this.tableName = StringUtils.rightTrim(tableName);
    }

    /**
     * 获取属性tablename
     * @return 属性tablename的值
     */
    public String getTableName(){
        return tableName;
    }

    /**
     * 设置属性maxno
     * @param maxNo 待设置的属性maxno的值
     */
    public void setMaxNo(String maxNo){
        this.maxNo = StringUtils.rightTrim(maxNo);
    }

    /**
     * 获取属性maxno
     * @return 属性maxno的值
     */
    public String getMaxNo(){
        return maxNo;
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
