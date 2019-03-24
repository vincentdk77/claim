package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是PrpLcheckExt-查勘/代查勘扩展表(修改)的数据传输对象基类<br>
 * 创建于 2005-03-18 17:53:35.281<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLcheckExtDtoBase implements Serializable{
    /** 属性报案号码 */
    private String registNo = "";
    /** 属性赔案号码 */
    private String claimNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性查勘项目代码 */
    private String columnName = "";
    /** 属性查勘项目名称 */
    private String displayName = "";
    /** 属性扩充字段内容 */
    private String columnValue = "";
    /** 属性标志 */
    private String flag = "";
    /** 属性关联理赔车辆序号 */
    private int referSerialNo = 0;

    /**
     *  默认构造方法,构造一个默认的PrpLcheckExtDtoBase对象
     */
    public PrpLcheckExtDtoBase(){
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
     * 设置属性赔案号码
     * @param claimNo 待设置的属性赔案号码的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性赔案号码
     * @return 属性赔案号码的值
     */
    public String getClaimNo(){
        return claimNo;
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
     * 设置属性查勘项目代码
     * @param columnName 待设置的属性查勘项目代码的值
     */
    public void setColumnName(String columnName){
        this.columnName = StringUtils.rightTrim(columnName);
    }

    /**
     * 获取属性查勘项目代码
     * @return 属性查勘项目代码的值
     */
    public String getColumnName(){
        return columnName;
    }

    /**
     * 设置属性查勘项目名称
     * @param displayName 待设置的属性查勘项目名称的值
     */
    public void setDisplayName(String displayName){
        this.displayName = StringUtils.rightTrim(displayName);
    }

    /**
     * 获取属性查勘项目名称
     * @return 属性查勘项目名称的值
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
     * 设置属性关联理赔车辆序号
     * @param referSerialNo 待设置的属性关联理赔车辆序号的值
     */
    public void setReferSerialNo(int referSerialNo){
        this.referSerialNo = referSerialNo;
    }

    /**
     * 获取属性关联理赔车辆序号
     * @return 属性关联理赔车辆序号的值
     */
    public int getReferSerialNo(){
        return referSerialNo;
    }
}
