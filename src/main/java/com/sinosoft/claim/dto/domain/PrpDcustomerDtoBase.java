package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcustomer客户信息的数据传输对象基类<br>
 * 创建于 2004-4-5 15:33:39<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerDtoBase implements Serializable{
    /** 属性客户类型(1个人/2单位) */
    private String customerType = "";
    /** 属性客户代码 */
    private String customerCode = "";
    /** 属性速查索引码 */
    private String shortHandCode = "";
    /** 属性客户中文名称 */
    private String customerCName = "";
    /** 属性客户英文名称 */
    private String customerEName = "";
    /** 属性地址中文名称 */
    private String addressCName = "";
    /** 属性地址英文名称 */
    private String addressEName = "";
    /** 属性法人组织机构代码/个人身份证号码 */
    private String organizeCode = "";
    /** 属性黑名单标志 */
    private String blackState = "";
    /** 属性临时/正式标志 */
    private String customerFlag = "";
    /** 属性效力状态(0失效/1有效) */
    private String validStatus = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcustomerDtoBase对象
     */
    public PrpDcustomerDtoBase(){
    }

    /**
     * 设置属性客户类型(1个人/2单位)
     * @param customerType 待设置的属性客户类型(1个人/2单位)的值
     */
    public void setCustomerType(String customerType){
        this.customerType = StringUtils.rightTrim(customerType);
    }

    /**
     * 获取属性客户类型(1个人/2单位)
     * @return 属性客户类型(1个人/2单位)的值
     */
    public String getCustomerType(){
        return customerType;
    }

    /**
     * 设置属性客户代码
     * @param customerCode 待设置的属性客户代码的值
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * 获取属性客户代码
     * @return 属性客户代码的值
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * 设置属性速查索引码
     * @param shortHandCode 待设置的属性速查索引码的值
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * 获取属性速查索引码
     * @return 属性速查索引码的值
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * 设置属性客户中文名称
     * @param customerCName 待设置的属性客户中文名称的值
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * 获取属性客户中文名称
     * @return 属性客户中文名称的值
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * 设置属性客户英文名称
     * @param customerEName 待设置的属性客户英文名称的值
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * 获取属性客户英文名称
     * @return 属性客户英文名称的值
     */
    public String getCustomerEName(){
        return customerEName;
    }

    /**
     * 设置属性地址中文名称
     * @param addressCName 待设置的属性地址中文名称的值
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * 获取属性地址中文名称
     * @return 属性地址中文名称的值
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * 设置属性地址英文名称
     * @param addressEName 待设置的属性地址英文名称的值
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * 获取属性地址英文名称
     * @return 属性地址英文名称的值
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * 设置属性法人组织机构代码/个人身份证号码
     * @param organizeCode 待设置的属性法人组织机构代码/个人身份证号码的值
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * 获取属性法人组织机构代码/个人身份证号码
     * @return 属性法人组织机构代码/个人身份证号码的值
     */
    public String getOrganizeCode(){
        return organizeCode;
    }

    /**
     * 设置属性黑名单标志
     * @param blackState 待设置的属性黑名单标志的值
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * 获取属性黑名单标志
     * @return 属性黑名单标志的值
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * 设置属性临时/正式标志
     * @param customerFlag 待设置的属性临时/正式标志的值
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * 获取属性临时/正式标志
     * @return 属性临时/正式标志的值
     */
    public String getCustomerFlag(){
        return customerFlag;
    }

    /**
     * 设置属性效力状态(0失效/1有效)
     * @param validStatus 待设置的属性效力状态(0失效/1有效)的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性效力状态(0失效/1有效)
     * @return 属性效力状态(0失效/1有效)的值
     */
    public String getValidStatus(){
        return validStatus;
    }
}
