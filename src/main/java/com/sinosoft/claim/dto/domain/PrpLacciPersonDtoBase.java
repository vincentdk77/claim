package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpLacciPerson的数据传输对象基类<br>
 * 创建于 JToolpad(1.4.0) Vendor:zhouxianli1978@msn.com
 */
public class PrpLacciPersonDtoBase implements Serializable{

    private static final long serialVersionUID = PrpLacciPersonDtoBase.class.getName().hashCode();
    /** 属性CertiNo */
    private String certiNo = "";
    /** 属性CertiType */
    private String certiType = "";
    /** 属性PolicyNo */
    private String policyNo = "";
    /** 属性SerialNo */
    private int serialNo = 0;
    /** 属性AcciCode */
    private String acciCode = "";
    /** 属性FamilyNo */
    private int familyNo = 0;
    /** 属性AcciName */
    private String acciName = "";
    /** 属性Sex */
    private String sex = "";
    /** 属性Age */
    private int age = 0;
    /** 属性IdentifyType */
    private String identifyType = "";
    /** 属性IdentifyNumber */
    private String identifyNumber = "";
    /** 属性Flag */
    private String flag = "";
    /** 属性Remark */
    private String remark = "";
    /** 属性Birthday */
    private String birthday = "";//新增出生日期字段，供山东意外险风险信息查询接口使用

    /**
     *  默认构造方法,构造一个默认的PrpLacciPersonDtoBase对象
     */
    public PrpLacciPersonDtoBase(){
    }

    /**
     * 设置属性CertiNo
     * @param certiNo 待设置的属性CertiNo的值
     */
    public void setCertiNo(String certiNo){
        this.certiNo = StringUtils.rightTrim(certiNo);
    }

    /**
     * 获取属性CertiNo
     * @return 属性CertiNo的值
     */
    public String getCertiNo(){
        return certiNo;
    }

    /**
     * 设置属性CertiType
     * @param certiType 待设置的属性CertiType的值
     */
    public void setCertiType(String certiType){
        this.certiType = StringUtils.rightTrim(certiType);
    }

    /**
     * 获取属性CertiType
     * @return 属性CertiType的值
     */
    public String getCertiType(){
        return certiType;
    }

    /**
     * 设置属性PolicyNo
     * @param policyNo 待设置的属性PolicyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性PolicyNo
     * @return 属性PolicyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性SerialNo
     * @param serialNo 待设置的属性SerialNo的值
     */
    public void setSerialNo(int serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性SerialNo
     * @return 属性SerialNo的值
     */
    public int getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性AcciCode
     * @param acciCode 待设置的属性AcciCode的值
     */
    public void setAcciCode(String acciCode){
        this.acciCode = StringUtils.rightTrim(acciCode);
    }

    /**
     * 获取属性AcciCode
     * @return 属性AcciCode的值
     */
    public String getAcciCode(){
        return acciCode;
    }

    /**
     * 设置属性FamilyNo
     * @param familyNo 待设置的属性FamilyNo的值
     */
    public void setFamilyNo(int familyNo){
        this.familyNo = familyNo;
    }

    /**
     * 获取属性FamilyNo
     * @return 属性FamilyNo的值
     */
    public int getFamilyNo(){
        return familyNo;
    }

    /**
     * 设置属性AcciName
     * @param acciName 待设置的属性AcciName的值
     */
    public void setAcciName(String acciName){
        this.acciName = StringUtils.rightTrim(acciName);
    }

    /**
     * 获取属性AcciName
     * @return 属性AcciName的值
     */
    public String getAcciName(){
        return acciName;
    }

    /**
     * 设置属性Sex
     * @param sex 待设置的属性Sex的值
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * 获取属性Sex
     * @return 属性Sex的值
     */
    public String getSex(){
        return sex;
    }

    /**
     * 设置属性Age
     * @param age 待设置的属性Age的值
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * 获取属性Age
     * @return 属性Age的值
     */
    public int getAge(){
        return age;
    }

    /**
     * 设置属性IdentifyType
     * @param identifyType 待设置的属性IdentifyType的值
     */
    public void setIdentifyType(String identifyType){
        this.identifyType = StringUtils.rightTrim(identifyType);
    }

    /**
     * 获取属性IdentifyType
     * @return 属性IdentifyType的值
     */
    public String getIdentifyType(){
        return identifyType;
    }

    /**
     * 设置属性IdentifyNumber
     * @param identifyNumber 待设置的属性IdentifyNumber的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性IdentifyNumber
     * @return 属性IdentifyNumber的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性Flag
     * @param flag 待设置的属性Flag的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性Flag
     * @return 属性Flag的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性Remark
     * @param remark 待设置的属性Remark的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性Remark
     * @return 属性Remark的值
     */
    public String getRemark(){
        return remark;
    }

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
