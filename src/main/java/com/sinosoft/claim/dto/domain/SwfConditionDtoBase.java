package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是SwfCondition-工作流条件描述表（新增）的数据传输对象基类<br>
 * 创建于 2005-04-26 15:20:39.375<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class SwfConditionDtoBase implements Serializable{
    /** 属性模板编码 */
    private int modelNo = 0;
    /** 属性流程边编码 */
    private int pathNo = 0;
    /** 属性条件编码 */
    private int conditionNo = 0;
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性部门代码 */
    private String comCode = "";
    /** 属性是否有效标 */
    private String validStatus = "";
    /** 属性配置类型标志 */
    private String configType = "";
    /** 属性配置描述 */
    private String configText = "";
    /** 属性业务键值 */
    private String businessKey = "";
    /** 属性数据库名称 */
    private String dBName = "";
    /** 属性表名 */
    private String tableName = "";
    /** 属性字段数据类型 */
    private String dataType = "";
    /** 属性字段名 */
    private String columnName = "";
    /** 属性字段描述 */
    private String columnDesc = "";
    /** 属性运算符 */
    private String operator = "";
    /** 属性比较值 */
    private String value = "";
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SwfConditionDtoBase对象
     */
    public SwfConditionDtoBase(){
    }

    /**
     * 设置属性模板编码
     * @param modelNo 待设置的属性模板编码的值
     */
    public void setModelNo(int modelNo){
        this.modelNo = modelNo;
    }

    /**
     * 获取属性模板编码
     * @return 属性模板编码的值
     */
    public int getModelNo(){
        return modelNo;
    }

    /**
     * 设置属性流程边编码
     * @param pathNo 待设置的属性流程边编码的值
     */
    public void setPathNo(int pathNo){
        this.pathNo = pathNo;
    }

    /**
     * 获取属性流程边编码
     * @return 属性流程边编码的值
     */
    public int getPathNo(){
        return pathNo;
    }

    /**
     * 设置属性条件编码
     * @param conditionNo 待设置的属性条件编码的值
     */
    public void setConditionNo(int conditionNo){
        this.conditionNo = conditionNo;
    }

    /**
     * 获取属性条件编码
     * @return 属性条件编码的值
     */
    public int getConditionNo(){
        return conditionNo;
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
     * 设置属性部门代码
     * @param comCode 待设置的属性部门代码的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性部门代码
     * @return 属性部门代码的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性是否有效标
     * @param validStatus 待设置的属性是否有效标的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性是否有效标
     * @return 属性是否有效标的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性配置类型标志
     * @param configType 待设置的属性配置类型标志的值
     */
    public void setConfigType(String configType){
        this.configType = StringUtils.rightTrim(configType);
    }

    /**
     * 获取属性配置类型标志
     * @return 属性配置类型标志的值
     */
    public String getConfigType(){
        return configType;
    }

    /**
     * 设置属性配置描述
     * @param configText 待设置的属性配置描述的值
     */
    public void setConfigText(String configText){
        this.configText = StringUtils.rightTrim(configText);
    }

    /**
     * 获取属性配置描述
     * @return 属性配置描述的值
     */
    public String getConfigText(){
        return configText;
    }

    /**
     * 设置属性业务键值
     * @param businessKey 待设置的属性业务键值的值
     */
    public void setBusinessKey(String businessKey){
        this.businessKey = StringUtils.rightTrim(businessKey);
    }

    /**
     * 获取属性业务键值
     * @return 属性业务键值的值
     */
    public String getBusinessKey(){
        return businessKey;
    }

    /**
     * 设置属性数据库名称
     * @param dBName 待设置的属性数据库名称的值
     */
    public void setDBName(String dBName){
        this.dBName = StringUtils.rightTrim(dBName);
    }

    /**
     * 获取属性数据库名称
     * @return 属性数据库名称的值
     */
    public String getDBName(){
        return dBName;
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
     * 设置属性字段数据类型
     * @param dataType 待设置的属性字段数据类型的值
     */
    public void setDataType(String dataType){
        this.dataType = StringUtils.rightTrim(dataType);
    }

    /**
     * 获取属性字段数据类型
     * @return 属性字段数据类型的值
     */
    public String getDataType(){
        return dataType;
    }

    /**
     * 设置属性字段名
     * @param columnName 待设置的属性字段名的值
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * 获取属性字段名
     * @return 属性字段名的值
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * 设置属性字段描述
     * @param columnDesc 待设置的属性字段描述的值
     */
    public void setColumnDesc(String columnDesc){
        this.columnDesc = StringUtils.rightTrim(columnDesc);
    }

    /**
     * 获取属性字段描述
     * @return 属性字段描述的值
     */
    public String getColumnDesc(){
        return columnDesc;
    }

    /**
     * 设置属性运算符
     * @param operator 待设置的属性运算符的值
     */
    public void setOperator(String operator){
        this.operator = StringUtils.rightTrim(operator);
    }

    /**
     * 获取属性运算符
     * @return 属性运算符的值
     */
    public String getOperator(){
        return operator;
    }

    /**
     * 设置属性比较值
     * @param value 待设置的属性比较值的值
     */
    public void setValue(String value){
        this.value = StringUtils.rightTrim(value);
    }

    /**
     * 获取属性比较值
     * @return 属性比较值的值
     */
    public String getValue(){
        return value;
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
