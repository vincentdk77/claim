package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpChospitalPerson�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpChospitalPersonDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����PolicyNo */
    private String policyNo = "";
    /** ����RiskCode */
    private String riskCode = "";
    /** ����SerialNo */
    private long serialNo = 0L;
    /** ����InsuredType */
    private String insuredType = "";
    /** ����InsuredCode */
    private String insuredCode = "";
    /** ����InsuredName */
    private String insuredName = "";
    /** ����Sex */
    private String sex = "";
    /** ����Age */
    private String age = "";
    /** ����TownName */
    private String townName = "";
    /** ����TownCode */
    private String townCode = "";
    /** ����InsuredAddress */
    private String insuredAddress = "";
    /** ����InsuredNature */
    private String insuredNature = "";
    /** ����InsuredFlag */
    private String insuredFlag = "";
    /** ����HospitalNumber */
    private String hospitalNumber = "";
    /** ����IdentifyNumber */
    private String identifyNumber = "";
    /** ����Bank */
    private String bank = "";
    /** ����AccountName */
    private String accountName = "";
    /** ����Account */
    private String account = "";
    /** ����LinkerName */
    private String linkerName = "";
    /** ����PostAddress */
    private String postAddress = "";
    /** ����PostCode */
    private String postCode = "";
    /** ����PhoneNumber */
    private String phoneNumber = "";
    /** ����Mobile */
    private String mobile = "";
    /** ����Email */
    private String email = "";
    /** ����Flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpChospitalPersonDtoBase����
     */
    public PrpChospitalPersonDtoBase(){
    }

    /**
     * ��������PolicyNo
     * @param policyNo �����õ�����PolicyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����PolicyNo
     * @return ����PolicyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������RiskCode
     * @param riskCode �����õ�����RiskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����RiskCode
     * @return ����RiskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������SerialNo
     * @param serialNo �����õ�����SerialNo��ֵ
     */
    public void setSerialNo(long serialNo){
        this.serialNo = serialNo;
    }

    /**
     * ��ȡ����SerialNo
     * @return ����SerialNo��ֵ
     */
    public long getSerialNo(){
        return serialNo;
    }

    /**
     * ��������InsuredType
     * @param insuredType �����õ�����InsuredType��ֵ
     */
    public void setInsuredType(String insuredType){
        this.insuredType = StringUtils.rightTrim(insuredType);
    }

    /**
     * ��ȡ����InsuredType
     * @return ����InsuredType��ֵ
     */
    public String getInsuredType(){
        return insuredType;
    }

    /**
     * ��������InsuredCode
     * @param insuredCode �����õ�����InsuredCode��ֵ
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * ��ȡ����InsuredCode
     * @return ����InsuredCode��ֵ
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * ��������InsuredName
     * @param insuredName �����õ�����InsuredName��ֵ
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * ��ȡ����InsuredName
     * @return ����InsuredName��ֵ
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * ��������Sex
     * @param sex �����õ�����Sex��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ����Sex
     * @return ����Sex��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ��������Age
     * @param age �����õ�����Age��ֵ
     */
    public void setAge(String age){
        this.age = StringUtils.rightTrim(age);
    }

    /**
     * ��ȡ����Age
     * @return ����Age��ֵ
     */
    public String getAge(){
        return age;
    }

    /**
     * ��������TownName
     * @param townName �����õ�����TownName��ֵ
     */
    public void setTownName(String townName){
        this.townName = StringUtils.rightTrim(townName);
    }

    /**
     * ��ȡ����TownName
     * @return ����TownName��ֵ
     */
    public String getTownName(){
        return townName;
    }

    /**
     * ��������TownCode
     * @param townCode �����õ�����TownCode��ֵ
     */
    public void setTownCode(String townCode){
        this.townCode = StringUtils.rightTrim(townCode);
    }

    /**
     * ��ȡ����TownCode
     * @return ����TownCode��ֵ
     */
    public String getTownCode(){
        return townCode;
    }

    /**
     * ��������InsuredAddress
     * @param insuredAddress �����õ�����InsuredAddress��ֵ
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * ��ȡ����InsuredAddress
     * @return ����InsuredAddress��ֵ
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * ��������InsuredNature
     * @param insuredNature �����õ�����InsuredNature��ֵ
     */
    public void setInsuredNature(String insuredNature){
        this.insuredNature = StringUtils.rightTrim(insuredNature);
    }

    /**
     * ��ȡ����InsuredNature
     * @return ����InsuredNature��ֵ
     */
    public String getInsuredNature(){
        return insuredNature;
    }

    /**
     * ��������InsuredFlag
     * @param insuredFlag �����õ�����InsuredFlag��ֵ
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * ��ȡ����InsuredFlag
     * @return ����InsuredFlag��ֵ
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * ��������HospitalNumber
     * @param hospitalNumber �����õ�����HospitalNumber��ֵ
     */
    public void setHospitalNumber(String hospitalNumber){
        this.hospitalNumber = StringUtils.rightTrim(hospitalNumber);
    }

    /**
     * ��ȡ����HospitalNumber
     * @return ����HospitalNumber��ֵ
     */
    public String getHospitalNumber(){
        return hospitalNumber;
    }

    /**
     * ��������IdentifyNumber
     * @param identifyNumber �����õ�����IdentifyNumber��ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ����IdentifyNumber
     * @return ����IdentifyNumber��ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * ��������Bank
     * @param bank �����õ�����Bank��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����Bank
     * @return ����Bank��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������AccountName
     * @param accountName �����õ�����AccountName��ֵ
     */
    public void setAccountName(String accountName){
        this.accountName = StringUtils.rightTrim(accountName);
    }

    /**
     * ��ȡ����AccountName
     * @return ����AccountName��ֵ
     */
    public String getAccountName(){
        return accountName;
    }

    /**
     * ��������Account
     * @param account �����õ�����Account��ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ����Account
     * @return ����Account��ֵ
     */
    public String getAccount(){
        return account;
    }

    /**
     * ��������LinkerName
     * @param linkerName �����õ�����LinkerName��ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ����LinkerName
     * @return ����LinkerName��ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ��������PostAddress
     * @param postAddress �����õ�����PostAddress��ֵ
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * ��ȡ����PostAddress
     * @return ����PostAddress��ֵ
     */
    public String getPostAddress(){
        return postAddress;
    }

    /**
     * ��������PostCode
     * @param postCode �����õ�����PostCode��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ����PostCode
     * @return ����PostCode��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ��������PhoneNumber
     * @param phoneNumber �����õ�����PhoneNumber��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ����PhoneNumber
     * @return ����PhoneNumber��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ��������Mobile
     * @param mobile �����õ�����Mobile��ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ����Mobile
     * @return ����Mobile��ֵ
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * ��������Email
     * @param email �����õ�����Email��ֵ
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * ��ȡ����Email
     * @return ����Email��ֵ
     */
    public String getEmail(){
        return email;
    }

    /**
     * ��������Flag
     * @param flag �����õ�����Flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����Flag
     * @return ����Flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
