package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcustomerunit�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerUnitDtoBase implements Serializable{
    /** ����customercode */
    private String customerCode = "";
    /** ����password */
    private String password = "";
    /** ����shorthandcode */
    private String shortHandCode = "";
    /** ����customercname */
    private String customerCName = "";
    /** ����customerename */
    private String customerEName = "";
    /** ����addresscname */
    private String addressCName = "";
    /** ����addressename */
    private String addressEName = "";
    /** ����possessnature */
    private String possessNature = "";
    /** ����businesssource */
    private String businessSource = "";
    /** ����businesssort */
    private String businessSort = "";
    /** ����customerkind */
    private String customerKind = "";
    /** ����customerflag */
    private String customerFlag = "";
    /** ����organizecode */
    private String organizeCode = "";
    /** ����creditlevel */
    private String creditLevel = "";
    /** ����leadername */
    private String leaderName = "";
    /** ����phonenumber */
    private String phoneNumber = "";
    /** ����faxnumber */
    private String faxNumber = "";
    /** ����mobile */
    private String mobile = "";
    /** ����netaddress */
    private String netAddress = "";
    /** ����emailaddress */
    private String emailAddress = "";
    /** ����postaddress */
    private String postAddress = "";
    /** ����postcode */
    private String postCode = "";
    /** ����linkername */
    private String linkerName = "";
    /** ����bank */
    private String bank = "";
    /** ����account */
    private String account = "";
    /** ����industrycode */
    private String industryCode = "";
    /** ����economycode */
    private String economyCode = "";
    /** ����measurecode */
    private String measureCode = "";
    /** ����fathercode */
    private String fatherCode = "";
    /** ����sponsorname */
    private String sponsorName = "";
    /** ����businessrange */
    private String businessRange = "";
    /** ����registfund */
    private double registFund = 0d;
    /** ����regioncode */
    private String regionCode = "";
    /** ����blackstate */
    private String blackState = "";
    /** ����newcustomercode */
    private String newCustomerCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����articlecode */
    private String articleCode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcustomerUnitDtoBase����
     */
    public PrpDcustomerUnitDtoBase(){
    }

    /**
     * ��������customercode
     * @param customerCode �����õ�����customercode��ֵ
     */
    public void setCustomerCode(String customerCode){
        this.customerCode = StringUtils.rightTrim(customerCode);
    }

    /**
     * ��ȡ����customercode
     * @return ����customercode��ֵ
     */
    public String getCustomerCode(){
        return customerCode;
    }

    /**
     * ��������password
     * @param password �����õ�����password��ֵ
     */
    public void setPassword(String password){
        this.password = StringUtils.rightTrim(password);
    }

    /**
     * ��ȡ����password
     * @return ����password��ֵ
     */
    public String getPassword(){
        return password;
    }

    /**
     * ��������shorthandcode
     * @param shortHandCode �����õ�����shorthandcode��ֵ
     */
    public void setShortHandCode(String shortHandCode){
        this.shortHandCode = StringUtils.rightTrim(shortHandCode);
    }

    /**
     * ��ȡ����shorthandcode
     * @return ����shorthandcode��ֵ
     */
    public String getShortHandCode(){
        return shortHandCode;
    }

    /**
     * ��������customercname
     * @param customerCName �����õ�����customercname��ֵ
     */
    public void setCustomerCName(String customerCName){
        this.customerCName = StringUtils.rightTrim(customerCName);
    }

    /**
     * ��ȡ����customercname
     * @return ����customercname��ֵ
     */
    public String getCustomerCName(){
        return customerCName;
    }

    /**
     * ��������customerename
     * @param customerEName �����õ�����customerename��ֵ
     */
    public void setCustomerEName(String customerEName){
        this.customerEName = StringUtils.rightTrim(customerEName);
    }

    /**
     * ��ȡ����customerename
     * @return ����customerename��ֵ
     */
    public String getCustomerEName(){
        return customerEName;
    }

    /**
     * ��������addresscname
     * @param addressCName �����õ�����addresscname��ֵ
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * ��ȡ����addresscname
     * @return ����addresscname��ֵ
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * ��������addressename
     * @param addressEName �����õ�����addressename��ֵ
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * ��ȡ����addressename
     * @return ����addressename��ֵ
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * ��������possessnature
     * @param possessNature �����õ�����possessnature��ֵ
     */
    public void setPossessNature(String possessNature){
        this.possessNature = StringUtils.rightTrim(possessNature);
    }

    /**
     * ��ȡ����possessnature
     * @return ����possessnature��ֵ
     */
    public String getPossessNature(){
        return possessNature;
    }

    /**
     * ��������businesssource
     * @param businessSource �����õ�����businesssource��ֵ
     */
    public void setBusinessSource(String businessSource){
        this.businessSource = StringUtils.rightTrim(businessSource);
    }

    /**
     * ��ȡ����businesssource
     * @return ����businesssource��ֵ
     */
    public String getBusinessSource(){
        return businessSource;
    }

    /**
     * ��������businesssort
     * @param businessSort �����õ�����businesssort��ֵ
     */
    public void setBusinessSort(String businessSort){
        this.businessSort = StringUtils.rightTrim(businessSort);
    }

    /**
     * ��ȡ����businesssort
     * @return ����businesssort��ֵ
     */
    public String getBusinessSort(){
        return businessSort;
    }

    /**
     * ��������customerkind
     * @param customerKind �����õ�����customerkind��ֵ
     */
    public void setCustomerKind(String customerKind){
        this.customerKind = StringUtils.rightTrim(customerKind);
    }

    /**
     * ��ȡ����customerkind
     * @return ����customerkind��ֵ
     */
    public String getCustomerKind(){
        return customerKind;
    }

    /**
     * ��������customerflag
     * @param customerFlag �����õ�����customerflag��ֵ
     */
    public void setCustomerFlag(String customerFlag){
        this.customerFlag = StringUtils.rightTrim(customerFlag);
    }

    /**
     * ��ȡ����customerflag
     * @return ����customerflag��ֵ
     */
    public String getCustomerFlag(){
        return customerFlag;
    }

    /**
     * ��������organizecode
     * @param organizeCode �����õ�����organizecode��ֵ
     */
    public void setOrganizeCode(String organizeCode){
        this.organizeCode = StringUtils.rightTrim(organizeCode);
    }

    /**
     * ��ȡ����organizecode
     * @return ����organizecode��ֵ
     */
    public String getOrganizeCode(){
        return organizeCode;
    }

    /**
     * ��������creditlevel
     * @param creditLevel �����õ�����creditlevel��ֵ
     */
    public void setCreditLevel(String creditLevel){
        this.creditLevel = StringUtils.rightTrim(creditLevel);
    }

    /**
     * ��ȡ����creditlevel
     * @return ����creditlevel��ֵ
     */
    public String getCreditLevel(){
        return creditLevel;
    }

    /**
     * ��������leadername
     * @param leaderName �����õ�����leadername��ֵ
     */
    public void setLeaderName(String leaderName){
        this.leaderName = StringUtils.rightTrim(leaderName);
    }

    /**
     * ��ȡ����leadername
     * @return ����leadername��ֵ
     */
    public String getLeaderName(){
        return leaderName;
    }

    /**
     * ��������phonenumber
     * @param phoneNumber �����õ�����phonenumber��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ����phonenumber
     * @return ����phonenumber��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ��������faxnumber
     * @param faxNumber �����õ�����faxnumber��ֵ
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * ��ȡ����faxnumber
     * @return ����faxnumber��ֵ
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * ��������mobile
     * @param mobile �����õ�����mobile��ֵ
     */
    public void setMobile(String mobile){
        this.mobile = StringUtils.rightTrim(mobile);
    }

    /**
     * ��ȡ����mobile
     * @return ����mobile��ֵ
     */
    public String getMobile(){
        return mobile;
    }

    /**
     * ��������netaddress
     * @param netAddress �����õ�����netaddress��ֵ
     */
    public void setNetAddress(String netAddress){
        this.netAddress = StringUtils.rightTrim(netAddress);
    }

    /**
     * ��ȡ����netaddress
     * @return ����netaddress��ֵ
     */
    public String getNetAddress(){
        return netAddress;
    }

    /**
     * ��������emailaddress
     * @param emailAddress �����õ�����emailaddress��ֵ
     */
    public void setEmailAddress(String emailAddress){
        this.emailAddress = StringUtils.rightTrim(emailAddress);
    }

    /**
     * ��ȡ����emailaddress
     * @return ����emailaddress��ֵ
     */
    public String getEmailAddress(){
        return emailAddress;
    }

    /**
     * ��������postaddress
     * @param postAddress �����õ�����postaddress��ֵ
     */
    public void setPostAddress(String postAddress){
        this.postAddress = StringUtils.rightTrim(postAddress);
    }

    /**
     * ��ȡ����postaddress
     * @return ����postaddress��ֵ
     */
    public String getPostAddress(){
        return postAddress;
    }

    /**
     * ��������postcode
     * @param postCode �����õ�����postcode��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ����postcode
     * @return ����postcode��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ��������linkername
     * @param linkerName �����õ�����linkername��ֵ
     */
    public void setLinkerName(String linkerName){
        this.linkerName = StringUtils.rightTrim(linkerName);
    }

    /**
     * ��ȡ����linkername
     * @return ����linkername��ֵ
     */
    public String getLinkerName(){
        return linkerName;
    }

    /**
     * ��������bank
     * @param bank �����õ�����bank��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����bank
     * @return ����bank��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������account
     * @param account �����õ�����account��ֵ
     */
    public void setAccount(String account){
        this.account = StringUtils.rightTrim(account);
    }

    /**
     * ��ȡ����account
     * @return ����account��ֵ
     */
    public String getAccount(){
        return account;
    }

    /**
     * ��������industrycode
     * @param industryCode �����õ�����industrycode��ֵ
     */
    public void setIndustryCode(String industryCode){
        this.industryCode = StringUtils.rightTrim(industryCode);
    }

    /**
     * ��ȡ����industrycode
     * @return ����industrycode��ֵ
     */
    public String getIndustryCode(){
        return industryCode;
    }

    /**
     * ��������economycode
     * @param economyCode �����õ�����economycode��ֵ
     */
    public void setEconomyCode(String economyCode){
        this.economyCode = StringUtils.rightTrim(economyCode);
    }

    /**
     * ��ȡ����economycode
     * @return ����economycode��ֵ
     */
    public String getEconomyCode(){
        return economyCode;
    }

    /**
     * ��������measurecode
     * @param measureCode �����õ�����measurecode��ֵ
     */
    public void setMeasureCode(String measureCode){
        this.measureCode = StringUtils.rightTrim(measureCode);
    }

    /**
     * ��ȡ����measurecode
     * @return ����measurecode��ֵ
     */
    public String getMeasureCode(){
        return measureCode;
    }

    /**
     * ��������fathercode
     * @param fatherCode �����õ�����fathercode��ֵ
     */
    public void setFatherCode(String fatherCode){
        this.fatherCode = StringUtils.rightTrim(fatherCode);
    }

    /**
     * ��ȡ����fathercode
     * @return ����fathercode��ֵ
     */
    public String getFatherCode(){
        return fatherCode;
    }

    /**
     * ��������sponsorname
     * @param sponsorName �����õ�����sponsorname��ֵ
     */
    public void setSponsorName(String sponsorName){
        this.sponsorName = StringUtils.rightTrim(sponsorName);
    }

    /**
     * ��ȡ����sponsorname
     * @return ����sponsorname��ֵ
     */
    public String getSponsorName(){
        return sponsorName;
    }

    /**
     * ��������businessrange
     * @param businessRange �����õ�����businessrange��ֵ
     */
    public void setBusinessRange(String businessRange){
        this.businessRange = StringUtils.rightTrim(businessRange);
    }

    /**
     * ��ȡ����businessrange
     * @return ����businessrange��ֵ
     */
    public String getBusinessRange(){
        return businessRange;
    }

    /**
     * ��������registfund
     * @param registFund �����õ�����registfund��ֵ
     */
    public void setRegistFund(double registFund){
        this.registFund = registFund;
    }

    /**
     * ��ȡ����registfund
     * @return ����registfund��ֵ
     */
    public double getRegistFund(){
        return registFund;
    }

    /**
     * ��������regioncode
     * @param regionCode �����õ�����regioncode��ֵ
     */
    public void setRegionCode(String regionCode){
        this.regionCode = StringUtils.rightTrim(regionCode);
    }

    /**
     * ��ȡ����regioncode
     * @return ����regioncode��ֵ
     */
    public String getRegionCode(){
        return regionCode;
    }

    /**
     * ��������blackstate
     * @param blackState �����õ�����blackstate��ֵ
     */
    public void setBlackState(String blackState){
        this.blackState = StringUtils.rightTrim(blackState);
    }

    /**
     * ��ȡ����blackstate
     * @return ����blackstate��ֵ
     */
    public String getBlackState(){
        return blackState;
    }

    /**
     * ��������newcustomercode
     * @param newCustomerCode �����õ�����newcustomercode��ֵ
     */
    public void setNewCustomerCode(String newCustomerCode){
        this.newCustomerCode = StringUtils.rightTrim(newCustomerCode);
    }

    /**
     * ��ȡ����newcustomercode
     * @return ����newcustomercode��ֵ
     */
    public String getNewCustomerCode(){
        return newCustomerCode;
    }

    /**
     * ��������validstatus
     * @param validStatus �����õ�����validstatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����validstatus
     * @return ����validstatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������articlecode
     * @param articleCode �����õ�����articlecode��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����articlecode
     * @return ����articlecode��ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * ��������flag
     * @param flag �����õ�����flag��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����flag
     * @return ����flag��ֵ
     */
    public String getFlag(){
        return flag;
    }
}
