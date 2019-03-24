package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcustomerunit的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerUnitDtoBase implements Serializable{
    /** 属性customercode */
    private String customerCode = "";
    /** 属性password */
    private String password = "";
    /** 属性shorthandcode */
    private String shortHandCode = "";
    /** 属性customercname */
    private String customerCName = "";
    /** 属性customerename */
    private String customerEName = "";
    /** 属性addresscname */
    private String addressCName = "";
    /** 属性addressename */
    private String addressEName = "";
    /** 属性possessnature */
    private String possessNature = "";
    /** 属性businesssource */
    private String businessSource = "";
    /** 属性businesssort */
    private String businessSort = "";
    /** 属性customerkind */
    private String customerKind = "";
    /** 属性customerflag */
    private String customerFlag = "";
    /** 属性organizecode */
    private String organizeCode = "";
    /** 属性creditlevel */
    private String creditLevel = "";
    /** 属性leadername */
    private String leaderName = "";
    /** 属性phonenumber */
    private String phoneNumber = "";
    /** 属性faxnumber */
    private String faxNumber = "";
    /** 属性mobile */
    private String mobile = "";
    /** 属性netaddress */
    private String netAddress = "";
    /** 属性emailaddress */
    private String emailAddress = "";
    /** 属性postaddress */
    private String postAddress = "";
    /** 属性postcode */
    private String postCode = "";
    /** 属性linkername */
    private String linkerName = "";
    /** 属性bank */
    private String bank = "";
    /** 属性account */
    private String account = "";
    /** 属性industrycode */
    private String industryCode = "";
    /** 属性economycode */
    private String economyCode = "";
    /** 属性measurecode */
    private String measureCode = "";
    /** 属性fathercode */
    private String fatherCode = "";
    /** 属性sponsorname */
    private String sponsorName = "";
    /** 属性businessrange */
    private String businessRange = "";
    /** 属性registfund */
    private double registFund = 0d;
    /** 属性regioncode */
    private String regionCode = "";
    /** 属性blackstate */
    private String blackState = "";
    /** 属性newcustomercode */
    private String newCustomerCode = "";
    /** 属性validstatus */
    private String validStatus = "";
    /** 属性articlecode */
    private String articleCode = "";
    /** 属性flag */
    private String flag = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcustomerUnitDtoBase对象
     */
    public PrpDcustomerUnitDtoBase(){
    }

    /**
     * 设置属性customercode
     * @param customerCode 待设置的属性customercode的值
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * 获取属性customercode
     * @return 属性customercode的值
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * 设置属性password
     * @param password 待设置的属性password的值
     */
    public void setPassword(String password){
        this.password = StringUtils.rightTrim(password);
    }

    /**
     * 获取属性password
     * @return 属性password的值
     */
    public String getPassword(){
        return password;
    }

    /**
     * 设置属性shorthandcode
     * @param shortHandCode 待设置的属性shorthandcode的值
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * 获取属性shorthandcode
     * @return 属性shorthandcode的值
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * 设置属性customercname
     * @param customerCName 待设置的属性customercname的值
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * 获取属性customercname
     * @return 属性customercname的值
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * 设置属性customerename
     * @param customerEName 待设置的属性customerename的值
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * 获取属性customerename
     * @return 属性customerename的值
     */
    public String getCustomerEName(){
        return customerEName;
    }

    /**
     * 设置属性addresscname
     * @param addressCName 待设置的属性addresscname的值
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * 获取属性addresscname
     * @return 属性addresscname的值
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * 设置属性addressename
     * @param addressEName 待设置的属性addressename的值
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * 获取属性addressename
     * @return 属性addressename的值
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * 设置属性possessnature
     * @param possessNature 待设置的属性possessnature的值
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * 获取属性possessnature
     * @return 属性possessnature的值
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * 设置属性businesssource
     * @param businessSource 待设置的属性businesssource的值
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * 获取属性businesssource
     * @return 属性businesssource的值
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * 设置属性businesssort
     * @param businessSort 待设置的属性businesssort的值
     */
    public void setBusinessSort(String businessSort){
        this.businessSort = StringUtils.rightTrim(businessSort);
    }

    /**
     * 获取属性businesssort
     * @return 属性businesssort的值
     */
    public String getBusinessSort(){
        return businessSort;
    }

    /**
     * 设置属性customerkind
     * @param customerKind 待设置的属性customerkind的值
     */
    public void setCustomerKind(String customerKind){
        this.customerKind = StringUtils.rightTrim(customerKind);
    }

    /**
     * 获取属性customerkind
     * @return 属性customerkind的值
     */
    public String getCustomerKind(){
        return customerKind;
    }

    /**
     * 设置属性customerflag
     * @param customerFlag 待设置的属性customerflag的值
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * 获取属性customerflag
     * @return 属性customerflag的值
     */
    public String getCustomerFlag(){
        return customerFlag;
    }

    /**
     * 设置属性organizecode
     * @param organizeCode 待设置的属性organizecode的值
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * 获取属性organizecode
     * @return 属性organizecode的值
     */
    public String getOrganizeCode(){
        return organizeCode;
    }

    /**
     * 设置属性creditlevel
     * @param creditLevel 待设置的属性creditlevel的值
     */
    public void setCreditLevel(String creditLevel){
        this.creditLevel = StringUtils.rightTrim(creditLevel);
    }

    /**
     * 获取属性creditlevel
     * @return 属性creditlevel的值
     */
    public String getCreditLevel(){
        return creditLevel;
    }

    /**
     * 设置属性leadername
     * @param leaderName 待设置的属性leadername的值
     */
    public void setLeaderName(String leaderName){
        this.leaderName = StringUtils.rightTrim(leaderName);
    }

    /**
     * 获取属性leadername
     * @return 属性leadername的值
     */
    public String getLeaderName(){
        return leaderName;
    }

    /**
     * 设置属性phonenumber
     * @param phoneNumber 待设置的属性phonenumber的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性phonenumber
     * @return 属性phonenumber的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性faxnumber
     * @param faxNumber 待设置的属性faxnumber的值
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * 获取属性faxnumber
     * @return 属性faxnumber的值
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * 设置属性mobile
     * @param mobile 待设置的属性mobile的值
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * 获取属性mobile
     * @return 属性mobile的值
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * 设置属性netaddress
     * @param netAddress 待设置的属性netaddress的值
     */
    public void setNetAddress(String netAddress){
        this.netAddress = StringUtils.rightTrim(netAddress);
    }

    /**
     * 获取属性netaddress
     * @return 属性netaddress的值
     */
    public String getNetAddress(){
        return netAddress;
    }

    /**
     * 设置属性emailaddress
     * @param emailAddress 待设置的属性emailaddress的值
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = StringUtils.rightTrim(emailAddress);
    }

    /**
     * 获取属性emailaddress
     * @return 属性emailaddress的值
     */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * 设置属性postaddress
     * @param postAddress 待设置的属性postaddress的值
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * 获取属性postaddress
     * @return 属性postaddress的值
     */
    public String getPostAddress(){
        return postAddress;
    }

    /**
     * 设置属性postcode
     * @param postCode 待设置的属性postcode的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性postcode
     * @return 属性postcode的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性linkername
     * @param linkerName 待设置的属性linkername的值
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * 获取属性linkername
     * @return 属性linkername的值
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * 设置属性bank
     * @param bank 待设置的属性bank的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性bank
     * @return 属性bank的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性account
     * @param account 待设置的属性account的值
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * 获取属性account
     * @return 属性account的值
     */
    public String getAccount(){
        return account;
    }

    /**
     * 设置属性industrycode
     * @param industryCode 待设置的属性industrycode的值
     */
    public void setIndustryCode(String industryCode){
        this.industryCode = StringUtils.rightTrim(industryCode);
    }

    /**
     * 获取属性industrycode
     * @return 属性industrycode的值
     */
    public String getIndustryCode(){
        return industryCode;
    }

    /**
     * 设置属性economycode
     * @param economyCode 待设置的属性economycode的值
     */
    public void setEconomyCode(String economyCode){
        this.economyCode = StringUtils.rightTrim(economyCode);
    }

    /**
     * 获取属性economycode
     * @return 属性economycode的值
     */
    public String getEconomyCode(){
        return economyCode;
    }

    /**
     * 设置属性measurecode
     * @param measureCode 待设置的属性measurecode的值
     */
    public void setMeasureCode(String measureCode){
        this.measureCode = StringUtils.rightTrim(measureCode);
    }

    /**
     * 获取属性measurecode
     * @return 属性measurecode的值
     */
    public String getMeasureCode(){
        return measureCode;
    }

    /**
     * 设置属性fathercode
     * @param fatherCode 待设置的属性fathercode的值
     */
    public void setFatherCode(String fatherCode){
        this.fatherCode = StringUtils.rightTrim(fatherCode);
    }

    /**
     * 获取属性fathercode
     * @return 属性fathercode的值
     */
    public String getFatherCode(){
        return fatherCode;
    }

    /**
     * 设置属性sponsorname
     * @param sponsorName 待设置的属性sponsorname的值
     */
    public void setSponsorName(String sponsorName){
        this.sponsorName = StringUtils.rightTrim(sponsorName);
    }

    /**
     * 获取属性sponsorname
     * @return 属性sponsorname的值
     */
    public String getSponsorName(){
        return sponsorName;
    }

    /**
     * 设置属性businessrange
     * @param businessRange 待设置的属性businessrange的值
     */
    public void setBusinessRange(String businessRange){
        this.businessRange = StringUtils.rightTrim(businessRange);
    }

    /**
     * 获取属性businessrange
     * @return 属性businessrange的值
     */
    public String getBusinessRange(){
        return businessRange;
    }

    /**
     * 设置属性registfund
     * @param registFund 待设置的属性registfund的值
     */
    public void setRegistFund(double registFund){
        this.registFund = registFund;
    }

    /**
     * 获取属性registfund
     * @return 属性registfund的值
     */
    public double getRegistFund(){
        return registFund;
    }

    /**
     * 设置属性regioncode
     * @param regionCode 待设置的属性regioncode的值
     */
    public void setRegionCode(String regionCode){
        this.regionCode = StringUtils.rightTrim(regionCode);
    }

    /**
     * 获取属性regioncode
     * @return 属性regioncode的值
     */
    public String getRegionCode(){
        return regionCode;
    }

    /**
     * 设置属性blackstate
     * @param blackState 待设置的属性blackstate的值
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * 获取属性blackstate
     * @return 属性blackstate的值
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * 设置属性newcustomercode
     * @param newCustomerCode 待设置的属性newcustomercode的值
     */
    public void setNewCustomerCode(String newCustomerCode){
        this.newCustomerCode = StringUtils.rightTrim(newCustomerCode);
    }

    /**
     * 获取属性newcustomercode
     * @return 属性newcustomercode的值
     */
    public String getNewCustomerCode(){
        return newCustomerCode;
    }

    /**
     * 设置属性validstatus
     * @param validStatus 待设置的属性validstatus的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性validstatus
     * @return 属性validstatus的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性articlecode
     * @param articleCode 待设置的属性articlecode的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性articlecode
     * @return 属性articlecode的值
     */
    public String getArticleCode(){
        return articleCode;
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
