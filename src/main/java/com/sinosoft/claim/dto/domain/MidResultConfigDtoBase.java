package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是MidResultConfig结果页面配置表的数据传输对象基类<br>
 * 创建于 2005-03-13 11:18:20.250<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class MidResultConfigDtoBase implements Serializable{
    /** 属性配置归属者 */
    private String configOwner = "";
    /** 属性结果页面类型 */
    private String resultType = "";
    /** 属性结果页面名称 */
    private String resultTypeName = "";
    /** 属性项目序号 */
    private int itemNo = 0;
    /** 属性项目归属表 */
    private String itemTable = "";
    /** 属性项目字段名称 */
    private String itemColumn = "";
    /** 属性项目字段说明 */
    private String itemColumnName = "";
    /** 属性项目字段数据类型 */
    private String dataType = "";
    /** 属性项目字段选择类型 */
    private String columnType = "";
    /** 属性分组标志 */
    private String groupFlag = "";
    /** 属性排序类型 */
    private String orderType = "";
    /** 属性选择标志 */
    private String selectFlag = "";
    /** 属性显示状态 */
    private String showStatus = "";
    /** 属性显示位置 */
    private String showAlign = "";
    /** 属性显示宽度 */
    private int showWidth = 0;
    /** 属性链接标志 */
    private String linkFlag = "";

    /**
     *  默认构造方法,构造一个默认的MidResultConfigDtoBase对象
     */
    public MidResultConfigDtoBase(){
    }

    /**
     * 设置属性配置归属者
     * @param configOwner 待设置的属性配置归属者的值
     */
    public void setConfigOwner(String configOwner){
        this.configOwner = StringUtils.rightTrim(configOwner);
    }

    /**
     * 获取属性配置归属者
     * @return 属性配置归属者的值
     */
    public String getConfigOwner(){
        return configOwner;
    }

    /**
     * 设置属性结果页面类型
     * @param resultType 待设置的属性结果页面类型的值
     */
    public void setResultType(String resultType){
        this.resultType = StringUtils.rightTrim(resultType);
    }

    /**
     * 获取属性结果页面类型
     * @return 属性结果页面类型的值
     */
    public String getResultType(){
        return resultType;
    }

    /**
     * 设置属性结果页面名称
     * @param resultTypeName 待设置的属性结果页面名称的值
     */
    public void setResultTypeName(String resultTypeName){
        this.resultTypeName = StringUtils.rightTrim(resultTypeName);
    }

    /**
     * 获取属性结果页面名称
     * @return 属性结果页面名称的值
     */
    public String getResultTypeName(){
        return resultTypeName;
    }

    /**
     * 设置属性项目序号
     * @param itemNo 待设置的属性项目序号的值
     */
    public void setItemNo(int itemNo){
        this.itemNo = itemNo;
    }

    /**
     * 获取属性项目序号
     * @return 属性项目序号的值
     */
    public int getItemNo(){
        return itemNo;
    }

    /**
     * 设置属性项目归属表
     * @param itemTable 待设置的属性项目归属表的值
     */
    public void setItemTable(String itemTable){
        this.itemTable = StringUtils.rightTrim(itemTable);
    }

    /**
     * 获取属性项目归属表
     * @return 属性项目归属表的值
     */
    public String getItemTable(){
        return itemTable;
    }

    /**
     * 设置属性项目字段名称
     * @param itemColumn 待设置的属性项目字段名称的值
     */
    public void setItemColumn(String itemColumn){
        this.itemColumn = StringUtils.rightTrim(itemColumn);
    }

    /**
     * 获取属性项目字段名称
     * @return 属性项目字段名称的值
     */
    public String getItemColumn(){
        return itemColumn;
    }

    /**
     * 设置属性项目字段说明
     * @param itemColumnName 待设置的属性项目字段说明的值
     */
    public void setItemColumnName(String itemColumnName){
        this.itemColumnName = StringUtils.rightTrim(itemColumnName);
    }

    /**
     * 获取属性项目字段说明
     * @return 属性项目字段说明的值
     */
    public String getItemColumnName(){
        return itemColumnName;
    }

    /**
     * 设置属性项目字段数据类型
     * @param dataType 待设置的属性项目字段数据类型的值
     */
    public void setDataType(String dataType){
        this.dataType = StringUtils.rightTrim(dataType);
    }

    /**
     * 获取属性项目字段数据类型
     * @return 属性项目字段数据类型的值
     */
    public String getDataType(){
        return dataType;
    }

    /**
     * 设置属性项目字段选择类型
     * @param columnType 待设置的属性项目字段选择类型的值
     */
    public void setColumnType(String columnType){
        this.columnType = StringUtils.rightTrim(columnType);
    }

    /**
     * 获取属性项目字段选择类型
     * @return 属性项目字段选择类型的值
     */
    public String getColumnType(){
        return columnType;
    }

    /**
     * 设置属性分组标志
     * @param groupFlag 待设置的属性分组标志的值
     */
    public void setGroupFlag(String groupFlag){
        this.groupFlag = StringUtils.rightTrim(groupFlag);
    }

    /**
     * 获取属性分组标志
     * @return 属性分组标志的值
     */
    public String getGroupFlag(){
        return groupFlag;
    }

    /**
     * 设置属性排序类型
     * @param orderType 待设置的属性排序类型的值
     */
    public void setOrderType(String orderType){
        this.orderType = StringUtils.rightTrim(orderType);
    }

    /**
     * 获取属性排序类型
     * @return 属性排序类型的值
     */
    public String getOrderType(){
        return orderType;
    }

    /**
     * 设置属性选择标志
     * @param selectFlag 待设置的属性选择标志的值
     */
    public void setSelectFlag(String selectFlag){
        this.selectFlag = StringUtils.rightTrim(selectFlag);
    }

    /**
     * 获取属性选择标志
     * @return 属性选择标志的值
     */
    public String getSelectFlag(){
        return selectFlag;
    }

    /**
     * 设置属性显示状态
     * @param showStatus 待设置的属性显示状态的值
     */
    public void setShowStatus(String showStatus){
        this.showStatus = StringUtils.rightTrim(showStatus);
    }

    /**
     * 获取属性显示状态
     * @return 属性显示状态的值
     */
    public String getShowStatus(){
        return showStatus;
    }

    /**
     * 设置属性显示位置
     * @param showAlign 待设置的属性显示位置的值
     */
    public void setShowAlign(String showAlign){
        this.showAlign = StringUtils.rightTrim(showAlign);
    }

    /**
     * 获取属性显示位置
     * @return 属性显示位置的值
     */
    public String getShowAlign(){
        return showAlign;
    }

    /**
     * 设置属性显示宽度
     * @param showWidth 待设置的属性显示宽度的值
     */
    public void setShowWidth(int showWidth){
        this.showWidth = showWidth;
    }

    /**
     * 获取属性显示宽度
     * @return 属性显示宽度的值
     */
    public int getShowWidth(){
        return showWidth;
    }

    /**
     * 设置属性链接标志
     * @param linkFlag 待设置的属性链接标志的值
     */
    public void setLinkFlag(String linkFlag){
        this.linkFlag = StringUtils.rightTrim(linkFlag);
    }

    /**
     * 获取属性链接标志
     * @return 属性链接标志的值
     */
    public String getLinkFlag(){
        return linkFlag;
    }
}

