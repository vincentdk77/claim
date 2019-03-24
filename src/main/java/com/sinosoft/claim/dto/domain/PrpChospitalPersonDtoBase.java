package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpChospitalPerson的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpChospitalPersonDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性PolicyNo */
    private String policyNo = "";
    /** 属性RiskCode */
    private String riskCode = "";
    /** 属性SerialNo */
    private long serialNo = 0L;
    /** 属性InsuredType */
    private String insuredType = "";
    /** 属性InsuredCode */
    private String insuredCode = "";
    /** 属性InsuredName */
    private String insuredName = "";
    /** 属性Sex */
    private String sex = "";
    /** 属性Age */
    private String age = "";
    /** 属性TownName */
    private String townName = "";
    /** 属性TownCode */
    private String townCode = "";
    /** 属性InsuredAddress */
    private String insuredAddress = "";
    /** 属性InsuredNature */
    private String insuredNature = "";
    /** 属性InsuredFlag */
    private String insuredFlag = "";
    /** 属性HospitalNumber */
    private String hospitalNumber = "";
    /** 属性IdentifyNumber */
    private String identifyNumber = "";
    /** 属性Bank */
    private String bank = "";
    /** 属性AccountName */
    private String accountName = "";
    /** 属性Account */
    private String account = "";
    /** 属性LinkerName */
    private String linkerName = "";
    /** 属性PostAddress */
    private String postAddress = "";
    /** 属性PostCode */
    private String postCode = "";
    /** 属性PhoneNumber */
    private String phoneNumber = "";
    /** 属性Mobile */
    private String mobile = "";
    /** 属性Email */
    private String email = "";
    /** 属性Flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpChospitalPersonDtoBase对象
     */
    public PrpChospitalPersonDtoBase(){
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
     * 设置属性RiskCode
     * @param riskCode 待设置的属性RiskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性RiskCode
     * @return 属性RiskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性SerialNo
     * @param serialNo 待设置的属性SerialNo的值
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * 获取属性SerialNo
     * @return 属性SerialNo的值
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性InsuredType
     * @param insuredType 待设置的属性InsuredType的值
     */
    public void setInsuredType(String insuredType){
        this.insuredType = StringUtils.rightTrim(insuredType);
    }

    /**
     * 获取属性InsuredType
     * @return 属性InsuredType的值
     */
    public String getInsuredType(){
        return insuredType;
    }

    /**
     * 设置属性InsuredCode
     * @param insuredCode 待设置的属性InsuredCode的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性InsuredCode
     * @return 属性InsuredCode的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性InsuredName
     * @param insuredName 待设置的属性InsuredName的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性InsuredName
     * @return 属性InsuredName的值
     */
    public String getInsuredName(){
        return insuredName;
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
    public void setAge(String age){
        this.age = StringUtils.rightTrim(age);
    }

    /**
     * 获取属性Age
     * @return 属性Age的值
     */
    public String getAge(){
        return age;
    }

    /**
     * 设置属性TownName
     * @param townName 待设置的属性TownName的值
     */
    public void setTownName(String townName){
        this.townName = StringUtils.rightTrim(townName);
    }

    /**
     * 获取属性TownName
     * @return 属性TownName的值
     */
    public String getTownName(){
        return townName;
    }

    /**
     * 设置属性TownCode
     * @param townCode 待设置的属性TownCode的值
     */
    public void setTownCode(String townCode){
        this.townCode = StringUtils.rightTrim(townCode);
    }

    /**
     * 获取属性TownCode
     * @return 属性TownCode的值
     */
    public String getTownCode(){
        return townCode;
    }

    /**
     * 设置属性InsuredAddress
     * @param insuredAddress 待设置的属性InsuredAddress的值
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * 获取属性InsuredAddress
     * @return 属性InsuredAddress的值
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * 设置属性InsuredNature
     * @param insuredNature 待设置的属性InsuredNature的值
     */
    public void setInsuredNature(String insuredNature){
        this.insuredNature = StringUtils.rightTrim(insuredNature);
    }

    /**
     * 获取属性InsuredNature
     * @return 属性InsuredNature的值
     */
    public String getInsuredNature(){
        return insuredNature;
    }

    /**
     * 设置属性InsuredFlag
     * @param insuredFlag 待设置的属性InsuredFlag的值
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * 获取属性InsuredFlag
     * @return 属性InsuredFlag的值
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * 设置属性HospitalNumber
     * @param hospitalNumber 待设置的属性HospitalNumber的值
     */
    public void setHospitalNumber(String hospitalNumber){
        this.hospitalNumber = StringUtils.rightTrim(hospitalNumber);
    }

    /**
     * 获取属性HospitalNumber
     * @return 属性HospitalNumber的值
     */
    public String getHospitalNumber(){
        return hospitalNumber;
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
     * 设置属性Bank
     * @param bank 待设置的属性Bank的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性Bank
     * @return 属性Bank的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性AccountName
     * @param accountName 待设置的属性AccountName的值
     */
    public void setAccountName(String accountName){
        this.accountName = StringUtils.rightTrim(accountName);
    }

    /**
     * 获取属性AccountName
     * @return 属性AccountName的值
     */
    public String getAccountName(){
        return accountName;
    }

    /**
     * 设置属性Account
     * @param account 待设置的属性Account的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性Account
     * @return 属性Account的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性LinkerName
     * @param linkerName 待设置的属性LinkerName的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性LinkerName
     * @return 属性LinkerName的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性PostAddress
     * @param postAddress 待设置的属性PostAddress的值
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * 获取属性PostAddress
     * @return 属性PostAddress的值
     */
    public String getPostAddress(){
        return postAddress;
    }

    /**
     * 设置属性PostCode
     * @param postCode 待设置的属性PostCode的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性PostCode
     * @return 属性PostCode的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性PhoneNumber
     * @param phoneNumber 待设置的属性PhoneNumber的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性PhoneNumber
     * @return 属性PhoneNumber的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性Mobile
     * @param mobile 待设置的属性Mobile的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性Mobile
     * @return 属性Mobile的值
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * 设置属性Email
     * @param email 待设置的属性Email的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性Email
     * @return 属性Email的值
     */
    public String getEmail(){
        return email;
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
}
