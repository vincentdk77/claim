package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是联系人表PrpLrelatePerson的数据传输对象基类<br>
 * 创建于 2005-05-31 19:50:52.453<br>
 * JToolpad(1.3.3) Vendor:zhouxianli1978@hotmail.com
 */
public class PrpLrelatePersonDtoBase implements Serializable{
    /** 属性出险登记号 */
    private String registNo = "";
    /** 属性人员类型 */
    private String personType = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性人员代码 */
    private String personCode = "";
    /** 属性人员名称 */
    private String personName = "";
    /** 属性联系电话 */
    private String phoneNumber = "";
    /** 属性移动电话 */
    private String mobile = "";
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性备注 */
    private String remark = "";
    /** 属性标志位 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpLrelatePersonDtoBase对象
     */
    public PrpLrelatePersonDtoBase(){
    }

    /**
     * 设置属性出险登记号
     * @param registNo 待设置的属性出险登记号的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性出险登记号
     * @return 属性出险登记号的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性人员类型
     * @param personType 待设置的属性人员类型的值
     */
    public void setPersonType(String personType){
        this.personType = StringUtils.rightTrim(personType);
    }

    /**
     * 获取属性人员类型
     * @return 属性人员类型的值
     */
    public String getPersonType(){
        return personType;
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
     * 设置属性人员代码
     * @param personCode 待设置的属性人员代码的值
     */
    public void setPersonCode(String personCode){
        this.personCode = StringUtils.rightTrim(personCode);
    }

    /**
     * 获取属性人员代码
     * @return 属性人员代码的值
     */
    public String getPersonCode(){
        return personCode;
    }

    /**
     * 设置属性人员名称
     * @param personName 待设置的属性人员名称的值
     */
    public void setPersonName(String personName){
        this.personName = StringUtils.rightTrim(personName);
    }

    /**
     * 获取属性人员名称
     * @return 属性人员名称的值
     */
    public String getPersonName(){
        return personName;
    }

    /**
     * 设置属性联系电话
     * @param phoneNumber 待设置的属性联系电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性联系电话
     * @return 属性联系电话的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性移动电话
     * @param mobile 待设置的属性移动电话的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性移动电话
     * @return 属性移动电话的值
     */
    public String getMobile(){
        return mobile;
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
     * 设置属性备注
     * @param remark 待设置的属性备注的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性备注
     * @return 属性备注的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性标志位
     * @param flag 待设置的属性标志位的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性标志位
     * @return 属性标志位的值
     */
    public String getFlag(){
        return flag;
    }
}
