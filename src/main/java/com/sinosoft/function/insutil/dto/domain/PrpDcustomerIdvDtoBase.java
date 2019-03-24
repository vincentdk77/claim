package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * 这是prpdcustomeridv的数据传输对象基类<br>
 * 创建于 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerIdvDtoBase implements Serializable{
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
    /** 属性identifytype */
    private String identifyType = "";
    /** 属性identifynumber */
    private String identifyNumber = "";
    /** 属性creditlevel */
    private String creditLevel = "";
    /** 属性sex */
    private String sex = "";
    /** 属性age */
    private int age = 0;
    /** 属性health */
    private String health = "";
    /** 属性occupationcode */
    private String occupationCode = "";
    /** 属性educationcode */
    private String educationCode = "";
    /** 属性unit */
    private String unit = "";
    /** 属性unitaddress */
    private String unitAddress = "";
    /** 属性customerkind */
    private String customerKind = "";
    /** 属性customerflag */
    private String customerFlag = "";
    /** 属性phonenumber */
    private String phoneNumber = "";
    /** 属性faxnumber */
    private String faxNumber = "";
    /** 属性mobile */
    private String mobile = "";
    /** 属性linkaddress */
    private String linkAddress = "";
    /** 属性postcode */
    private String postCode = "";
    /** 属性pager */
    private String pager = "";
    /** 属性email */
    private String email = "";
    /** 属性bank */
    private String bank = "";
    /** 属性account */
    private String account = "";
    /** 属性deathdate */
    private DateTime deathDate = new DateTime();
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
     *  默认构造方法,构造一个默认的PrpDcustomerIdvDtoBase对象
     */
    public PrpDcustomerIdvDtoBase(){
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
     * 设置属性identifytype
     * @param identifyType 待设置的属性identifytype的值
     */
    public void setIdentifyType(String identifyType){
        this.identifyType = StringUtils.rightTrim(identifyType);
    }

    /**
     * 获取属性identifytype
     * @return 属性identifytype的值
     */
    public String getIdentifyType(){
        return identifyType;
    }

    /**
     * 设置属性identifynumber
     * @param identifyNumber 待设置的属性identifynumber的值
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * 获取属性identifynumber
     * @return 属性identifynumber的值
     */
    public String getIdentifyNumber(){
        return identifyNumber;
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
     * 设置属性sex
     * @param sex 待设置的属性sex的值
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * 获取属性sex
     * @return 属性sex的值
     */
    public String getSex(){
        return sex;
    }

    /**
     * 设置属性age
     * @param age 待设置的属性age的值
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * 获取属性age
     * @return 属性age的值
     */
    public int getAge(){
        return age;
    }

    /**
     * 设置属性health
     * @param health 待设置的属性health的值
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * 获取属性health
     * @return 属性health的值
     */
    public String getHealth(){
        return health;
    }

    /**
     * 设置属性occupationcode
     * @param occupationCode 待设置的属性occupationcode的值
     */
    public void setOccupationCode(String occupationCode){
        this.occupationCode = StringUtils.rightTrim(occupationCode);
    }

    /**
     * 获取属性occupationcode
     * @return 属性occupationcode的值
     */
    public String getOccupationCode(){
        return occupationCode;
    }

    /**
     * 设置属性educationcode
     * @param educationCode 待设置的属性educationcode的值
     */
    public void setEducationCode(String educationCode){
        this.educationCode = StringUtils.rightTrim(educationCode);
    }

    /**
     * 获取属性educationcode
     * @return 属性educationcode的值
     */
    public String getEducationCode(){
        return educationCode;
    }

    /**
     * 设置属性unit
     * @param unit 待设置的属性unit的值
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * 获取属性unit
     * @return 属性unit的值
     */
    public String getUnit(){
        return unit;
    }

    /**
     * 设置属性unitaddress
     * @param unitAddress 待设置的属性unitaddress的值
     */
    public void setUnitAddress(String unitAddress){
        this.unitAddress = StringUtils.rightTrim(unitAddress);
    }

    /**
     * 获取属性unitaddress
     * @return 属性unitaddress的值
     */
    public String getUnitAddress(){
        return unitAddress;
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
     * 设置属性linkaddress
     * @param linkAddress 待设置的属性linkaddress的值
     */
    public void setLinkAddress(String linkAddress){
        this.linkAddress = StringUtils.rightTrim(linkAddress);
    }

    /**
     * 获取属性linkaddress
     * @return 属性linkaddress的值
     */
    public String getLinkAddress(){
        return linkAddress;
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
     * 设置属性pager
     * @param pager 待设置的属性pager的值
     */
    public void setPager(String pager){
        this.pager = StringUtils.rightTrim(pager);
    }

    /**
     * 获取属性pager
     * @return 属性pager的值
     */
    public String getPager(){
        return pager;
    }

    /**
     * 设置属性email
     * @param email 待设置的属性email的值
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * 获取属性email
     * @return 属性email的值
     */
    public String getEmail(){
        return email;
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
     * 设置属性deathdate
     * @param deathDate 待设置的属性deathdate的值
     */
    public void setDeathDate(DateTime deathDate){
        this.deathDate = deathDate;
    }

    /**
     * 获取属性deathdate
     * @return 属性deathdate的值
     */
    public DateTime getDeathDate(){
        return deathDate;
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
