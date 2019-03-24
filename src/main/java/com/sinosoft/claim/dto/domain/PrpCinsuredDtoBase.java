package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpcinsured保险关系人表的数据传输对象基类<br>
 * 创建于 2004-4-5 15:32:05<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpCinsuredDtoBase implements Serializable{
    /** 属性保单号码 */
    private String policyNo = "";
    /** 属性险种代码 */
    private String riskCode = "";
    /** 属性序号 */
    private int serialNo = 0;
    /** 属性语种 */
    private String language = "";
    /** 属性关系人类型 */
    private String insuredType = "";
    /** 属性关系人代码 */
    private String insuredCode = "";
    /** 属性关系人名称 */
    private String insuredName = "";
    /** 属性关系人地址 */
    private String insuredAddress = "";
    /** 属性关系人性质 */
    private String insuredNature = "";
    /** 属性关系人标志 */
    private String insuredFlag = "";
    /** 属性是被保险人的 */
    private String insuredidentity = "";
    /** 属性关联人序号 */
    private int relateserialno = 0;
    /** 属性证件类型 */
    private String identifytype = "";
    /** 属性身份证号/法人代码 */
    private String identifyNumber = "";
    /** 属性资信等级 */
    private String creditLevel = "";
    /** 属性占用性质代码 */
    private String possessNature = "";
    /** 属性行业代码 */
    private String businessSource = "";
    /** 属性所有制代码（单位性质代码） */
    private String businessSort = "";
    /** 属性个人职业代码 */
    private String occupationCode = "";
    /** 属性个人学历代码 */
    private String educationCode = "";
    /** 属性开户银行 */
    private String bank = "";
    /** 属性帐户名（投保-缴费/被保-领取） */
    private String accountname = "";
    /** 属性开户账号 */
    private String account = "";
    /** 属性联系人名称 */
    private String linkerName = "";
    /** 属性通讯地址 */
    private String postAddress = "";
    /** 属性邮政编码 */
    private String postCode = "";
    /** 属性电话 */
    private String phoneNumber = "";
    /** 属性移动电话 */
    private String mobile = "";
    /** 属性电子邮件 */
    private String email = "";
    /** 属性受益人标志 */
    private String benefitFlag = "";
    /** 属性受益份额 */
    private double benefitRate = 0d;
    /** 属性标志字段 */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpCinsuredDtoBase对象
     */
    public PrpCinsuredDtoBase(){
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
     * 设置属性语种
     * @param language 待设置的属性语种的值
     */
    public void setLanguage(String language){
        this.language = StringUtils.rightTrim(language);
    }

    /**
     * 获取属性语种
     * @return 属性语种的值
     */
    public String getLanguage(){
        return language;
    }

    /**
     * 设置属性关系人类型
     * @param insuredType 待设置的属性关系人类型的值
     */
    public void setInsuredType(String insuredType){
        this.insuredType = StringUtils.rightTrim(insuredType);
    }

    /**
     * 获取属性关系人类型
     * @return 属性关系人类型的值
     */
    public String getInsuredType(){
        return insuredType;
    }

    /**
     * 设置属性关系人代码
     * @param insuredCode 待设置的属性关系人代码的值
     */
    public void setInsuredCode(String insuredCode){
        this.insuredCode = StringUtils.rightTrim(insuredCode);
    }

    /**
     * 获取属性关系人代码
     * @return 属性关系人代码的值
     */
    public String getInsuredCode(){
        return insuredCode;
    }

    /**
     * 设置属性关系人名称
     * @param insuredName 待设置的属性关系人名称的值
     */
    public void setInsuredName(String insuredName){
        this.insuredName = StringUtils.rightTrim(insuredName);
    }

    /**
     * 获取属性关系人名称
     * @return 属性关系人名称的值
     */
    public String getInsuredName(){
        return insuredName;
    }

    /**
     * 设置属性关系人地址
     * @param insuredAddress 待设置的属性关系人地址的值
     */
    public void setInsuredAddress(String insuredAddress){
        this.insuredAddress = StringUtils.rightTrim(insuredAddress);
    }

    /**
     * 获取属性关系人地址
     * @return 属性关系人地址的值
     */
    public String getInsuredAddress(){
        return insuredAddress;
    }

    /**
     * 设置属性关系人性质
     * @param insuredNature 待设置的属性关系人性质的值
     */
    public void setInsuredNature(String insuredNature){
        this.insuredNature = StringUtils.rightTrim(insuredNature);
    }

    /**
     * 获取属性关系人性质
     * @return 属性关系人性质的值
     */
    public String getInsuredNature(){
        return insuredNature;
    }

    /**
     * 设置属性关系人标志
     * @param insuredFlag 待设置的属性关系人标志的值
     */
    public void setInsuredFlag(String insuredFlag){
        this.insuredFlag = StringUtils.rightTrim(insuredFlag);
    }

    /**
     * 获取属性关系人标志
     * @return 属性关系人标志的值
     */
    public String getInsuredFlag(){
        return insuredFlag;
    }

    /**
     * 设置属性是被保险人的
     * @param insuredidentity 待设置的属性是被保险人的的值
     */
    public void setInsuredidentity(String insuredidentity){
        this.insuredidentity = StringUtils.rightTrim(insuredidentity);
    }

    /**
     * 获取属性是被保险人的
     * @return 属性是被保险人的的值
     */
    public String getInsuredidentity(){
        return insuredidentity;
    }

    /**
     * 设置属性关联人序号
     * @param relateserialno 待设置的属性关联人序号的值
     */
    public void setRelateserialno(int relateserialno){
        this.relateserialno = relateserialno;
    }

    /**
     * 获取属性关联人序号
     * @return 属性关联人序号的值
     */
    public int getRelateserialno(){
        return relateserialno;
    }

    /**
     * 设置属性证件类型
     * @param identifytype 待设置的属性证件类型的值
     */
    public void setIdentifytype(String identifytype){
        this.identifytype = StringUtils.rightTrim(identifytype);
    }

    /**
     * 获取属性证件类型
     * @return 属性证件类型的值
     */
    public String getIdentifytype(){
        return identifytype;
    }

    /**
     * 设置属性身份证号/法人代码
     * @param identifyNumber 待设置的属性身份证号/法人代码的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性身份证号/法人代码
     * @return 属性身份证号/法人代码的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
    }

    /**
     * 设置属性资信等级
     * @param creditLevel 待设置的属性资信等级的值
     */
    public void setCreditLevel(String creditLevel){
        this.creditLevel = StringUtils.rightTrim(creditLevel);
    }

    /**
     * 获取属性资信等级
     * @return 属性资信等级的值
     */
    public String getCreditLevel(){
        return creditLevel;
    }

    /**
     * 设置属性占用性质代码
     * @param possessNature 待设置的属性占用性质代码的值
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * 获取属性占用性质代码
     * @return 属性占用性质代码的值
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * 设置属性行业代码
     * @param businessSource 待设置的属性行业代码的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性行业代码
     * @return 属性行业代码的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性所有制代码（单位性质代码）
     * @param businessSort 待设置的属性所有制代码（单位性质代码）的值
     */
    public void setBusinessSort(String businessSort){
        this.businessSort = StringUtils.rightTrim(businessSort);
    }

    /**
     * 获取属性所有制代码（单位性质代码）
     * @return 属性所有制代码（单位性质代码）的值
     */
    public String getBusinessSort(){
        return businessSort;
    }

    /**
     * 设置属性个人职业代码
     * @param occupationCode 待设置的属性个人职业代码的值
     */
    public void setOccupationCode(String occupationCode){
        this.occupationCode = StringUtils.rightTrim(occupationCode);
    }

    /**
     * 获取属性个人职业代码
     * @return 属性个人职业代码的值
     */
    public String getOccupationCode(){
        return occupationCode;
    }

    /**
     * 设置属性个人学历代码
     * @param educationCode 待设置的属性个人学历代码的值
     */
    public void setEducationCode(String educationCode){
        this.educationCode = StringUtils.rightTrim(educationCode);
    }

    /**
     * 获取属性个人学历代码
     * @return 属性个人学历代码的值
     */
    public String getEducationCode(){
        return educationCode;
    }

    /**
     * 设置属性开户银行
     * @param bank 待设置的属性开户银行的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性开户银行
     * @return 属性开户银行的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性帐户名（投保-缴费/被保-领取）
     * @param accountname 待设置的属性帐户名（投保-缴费/被保-领取）的值
     */
    public void setAccountname(String accountname){
        this.accountname = StringUtils.rightTrim(accountname);
    }

    /**
     * 获取属性帐户名（投保-缴费/被保-领取）
     * @return 属性帐户名（投保-缴费/被保-领取）的值
     */
    public String getAccountname(){
        return accountname;
    }

    /**
     * 设置属性开户账号
     * @param account 待设置的属性开户账号的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性开户账号
     * @return 属性开户账号的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性联系人名称
     * @param linkerName 待设置的属性联系人名称的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性联系人名称
     * @return 属性联系人名称的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性通讯地址
     * @param postAddress 待设置的属性通讯地址的值
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * 获取属性通讯地址
     * @return 属性通讯地址的值
     */
    public String getPostAddress(){
        return postAddress;
    }

    /**
     * 设置属性邮政编码
     * @param postCode 待设置的属性邮政编码的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性邮政编码
     * @return 属性邮政编码的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性电话
     * @param phoneNumber 待设置的属性电话的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性电话
     * @return 属性电话的值
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
     * 设置属性电子邮件
     * @param email 待设置的属性电子邮件的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性电子邮件
     * @return 属性电子邮件的值
     */
    public String getEmail(){
        return email;
    }

    /**
     * 设置属性受益人标志
     * @param benefitFlag 待设置的属性受益人标志的值
     */
    public void setBenefitFlag(String benefitFlag){
        this.benefitFlag = StringUtils.rightTrim(benefitFlag);
    }

    /**
     * 获取属性受益人标志
     * @return 属性受益人标志的值
     */
    public String getBenefitFlag(){
        return benefitFlag;
    }

    /**
     * 设置属性受益份额
     * @param benefitRate 待设置的属性受益份额的值
     */
    public void setBenefitRate(double benefitRate){
        this.benefitRate = benefitRate;
    }

    /**
     * 获取属性受益份额
     * @return 属性受益份额的值
     */
    public double getBenefitRate(){
        return benefitRate;
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
