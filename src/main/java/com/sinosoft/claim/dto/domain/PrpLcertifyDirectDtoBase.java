package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLcertifyDirect－索赔指引的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLcertifyDirectDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性标的代码 */
    private String lossItemCode = "";
    /** 属性单证类型代码 */
    private String typeCode = "";
    /** 属性单证类型名称 */
    private String typeName = "";
    /** 属性扩充字段内容 */
    private String columnValue = "";
    /** 属性标志 */
    private String flag = "";
    /** 属性强制保险收集标志 */
    private String compelFlag = "";
    /** 属性商业保险收集标志 */
    private String businessFlag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLcertifyDirectDtoBase对象
     */
    public PrpLcertifyDirectDtoBase(){
    }

    /**
     * 设置属性报案号码
     * @param registNo 待设置的属性报案号码的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性报案号码
     * @return 属性报案号码的值
     */
    public String getRegistNo(){
        return registNo;
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
     * 设置属性标的代码
     * @param lossItemCode 待设置的属性标的代码的值
     */
    public void setLossItemCode(String lossItemCode){
        this.lossItemCode = StringUtils.rightTrim(lossItemCode);
    }

    /**
     * 获取属性标的代码
     * @return 属性标的代码的值
     */
    public String getLossItemCode(){
        return lossItemCode;
    }

    /**
     * 设置属性单证类型代码
     * @param typeCode 待设置的属性单证类型代码的值
     */
    public void setTypeCode(String typeCode){
        this.typeCode = StringUtils.rightTrim(typeCode);
    }

    /**
     * 获取属性单证类型代码
     * @return 属性单证类型代码的值
     */
    public String getTypeCode(){
        return typeCode;
    }

    /**
     * 设置属性单证类型名称
     * @param typeName 待设置的属性单证类型名称的值
     */
    public void setTypeName(String typeName){
        this.typeName = StringUtils.rightTrim(typeName);
    }

    /**
     * 获取属性单证类型名称
     * @return 属性单证类型名称的值
     */
    public String getTypeName(){
        return typeName;
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

    /**
     * 设置属性强制保险收集标志
     * @param compelFlag 待设置的属性强制保险收集标志的值
     */
    public void setCompelFlag(String compelFlag){
        this.compelFlag = StringUtils.rightTrim(compelFlag);
    }

    /**
     * 获取属性强制保险收集标志
     * @return 属性强制保险收集标志的值
     */
    public String getCompelFlag(){
        return compelFlag;
    }

    /**
     * 设置属性商业保险收集标志
     * @param businessFlag 待设置的属性商业保险收集标志的值
     */
    public void setBusinessFlag(String businessFlag){
        this.businessFlag = StringUtils.rightTrim(businessFlag);
    }

    /**
     * 获取属性商业保险收集标志
     * @return 属性商业保险收集标志的值
     */
    public String getBusinessFlag(){
        return businessFlag;
    }
}
