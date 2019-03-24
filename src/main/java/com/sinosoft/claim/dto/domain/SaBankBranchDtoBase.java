package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是SaBankBranch的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class SaBankBranchDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性bankCode */
    private String bankCode = "";
    /** 属性bankBranchCode */
    private String bankBranchCode = "";
    /** 属性bankBranchCName */
    private String bankBranchCName = "";
    /** 属性thirdType */
    private String thirdType = "";
    /** 属性validStatus */
    private String validStatus = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的SaBankBranchDtoBase对象
     */
    public SaBankBranchDtoBase(){
    }

    /**
     * 设置属性bankCode
     * @param bankCode 待设置的属性bankCode的值
     */
    public void setBankCode(String bankCode){
        this.bankCode = StringUtils.rightTrim(bankCode);
    }

    /**
     * 获取属性bankCode
     * @return 属性bankCode的值
     */
    public String getBankCode(){
        return bankCode;
    }

    /**
     * 设置属性bankBranchCode
     * @param bankBranchCode 待设置的属性bankBranchCode的值
     */
    public void setBankBranchCode(String bankBranchCode){
        this.bankBranchCode = StringUtils.rightTrim(bankBranchCode);
    }

    /**
     * 获取属性bankBranchCode
     * @return 属性bankBranchCode的值
     */
    public String getBankBranchCode(){
        return bankBranchCode;
    }

    /**
     * 设置属性bankBranchCName
     * @param bankBranchCName 待设置的属性bankBranchCName的值
     */
    public void setBankBranchCName(String bankBranchCName){
        this.bankBranchCName = StringUtils.rightTrim(bankBranchCName);
    }

    /**
     * 获取属性bankBranchCName
     * @return 属性bankBranchCName的值
     */
    public String getBankBranchCName(){
        return bankBranchCName;
    }

    /**
     * 设置属性thirdType
     * @param thirdType 待设置的属性thirdType的值
     */
    public void setThirdType(String thirdType){
        this.thirdType = StringUtils.rightTrim(thirdType);
    }

    /**
     * 获取属性thirdType
     * @return 属性thirdType的值
     */
    public String getThirdType(){
        return thirdType;
    }

    /**
     * 设置属性validStatus
     * @param validStatus 待设置的属性validStatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validStatus
     * @return 属性validStatus的值
     */
    public String getValidStatus(){
        return validStatus;
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
