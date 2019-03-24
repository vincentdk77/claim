package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcustomeridv�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcustomerIdvDtoBase implements Serializable{
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
    /** ����identifytype */
    private String identifyType = "";
    /** ����identifynumber */
    private String identifyNumber = "";
    /** ����creditlevel */
    private String creditLevel = "";
    /** ����sex */
    private String sex = "";
    /** ����age */
    private int age = 0;
    /** ����health */
    private String health = "";
    /** ����occupationcode */
    private String occupationCode = "";
    /** ����educationcode */
    private String educationCode = "";
    /** ����unit */
    private String unit = "";
    /** ����unitaddress */
    private String unitAddress = "";
    /** ����customerkind */
    private String customerKind = "";
    /** ����customerflag */
    private String customerFlag = "";
    /** ����phonenumber */
    private String phoneNumber = "";
    /** ����faxnumber */
    private String faxNumber = "";
    /** ����mobile */
    private String mobile = "";
    /** ����linkaddress */
    private String linkAddress = "";
    /** ����postcode */
    private String postCode = "";
    /** ����pager */
    private String pager = "";
    /** ����email */
    private String email = "";
    /** ����bank */
    private String bank = "";
    /** ����account */
    private String account = "";
    /** ����deathdate */
    private DateTime deathDate = new DateTime();
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
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcustomerIdvDtoBase����
     */
    public PrpDcustomerIdvDtoBase(){
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
     * ��������identifytype
     * @param identifyType �����õ�����identifytype��ֵ
     */
    public void setIdentifyType(String identifyType){
        this.identifyType = StringUtils.rightTrim(identifyType);
    }

    /**
     * ��ȡ����identifytype
     * @return ����identifytype��ֵ
     */
    public String getIdentifyType(){
        return identifyType;
    }

    /**
     * ��������identifynumber
     * @param identifyNumber �����õ�����identifynumber��ֵ
     */
    public void setIdentifyNumber(String identifyNumber){
        this.identifyNumber = StringUtils.rightTrim(identifyNumber);
    }

    /**
     * ��ȡ����identifynumber
     * @return ����identifynumber��ֵ
     */
    public String getIdentifyNumber(){
        return identifyNumber;
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
     * ��������sex
     * @param sex �����õ�����sex��ֵ
     */
    public void setSex(String sex){
        this.sex = StringUtils.rightTrim(sex);
    }

    /**
     * ��ȡ����sex
     * @return ����sex��ֵ
     */
    public String getSex(){
        return sex;
    }

    /**
     * ��������age
     * @param age �����õ�����age��ֵ
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * ��ȡ����age
     * @return ����age��ֵ
     */
    public int getAge(){
        return age;
    }

    /**
     * ��������health
     * @param health �����õ�����health��ֵ
     */
    public void setHealth(String health){
        this.health = StringUtils.rightTrim(health);
    }

    /**
     * ��ȡ����health
     * @return ����health��ֵ
     */
    public String getHealth(){
        return health;
    }

    /**
     * ��������occupationcode
     * @param occupationCode �����õ�����occupationcode��ֵ
     */
    public void setOccupationCode(String occupationCode){
        this.occupationCode = StringUtils.rightTrim(occupationCode);
    }

    /**
     * ��ȡ����occupationcode
     * @return ����occupationcode��ֵ
     */
    public String getOccupationCode(){
        return occupationCode;
    }

    /**
     * ��������educationcode
     * @param educationCode �����õ�����educationcode��ֵ
     */
    public void setEducationCode(String educationCode){
        this.educationCode = StringUtils.rightTrim(educationCode);
    }

    /**
     * ��ȡ����educationcode
     * @return ����educationcode��ֵ
     */
    public String getEducationCode(){
        return educationCode;
    }

    /**
     * ��������unit
     * @param unit �����õ�����unit��ֵ
     */
    public void setUnit(String unit){
        this.unit = StringUtils.rightTrim(unit);
    }

    /**
     * ��ȡ����unit
     * @return ����unit��ֵ
     */
    public String getUnit(){
        return unit;
    }

    /**
     * ��������unitaddress
     * @param unitAddress �����õ�����unitaddress��ֵ
     */
    public void setUnitAddress(String unitAddress){
        this.unitAddress = StringUtils.rightTrim(unitAddress);
    }

    /**
     * ��ȡ����unitaddress
     * @return ����unitaddress��ֵ
     */
    public String getUnitAddress(){
        return unitAddress;
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
     * ��������linkaddress
     * @param linkAddress �����õ�����linkaddress��ֵ
     */
    public void setLinkAddress(String linkAddress){
        this.linkAddress = StringUtils.rightTrim(linkAddress);
    }

    /**
     * ��ȡ����linkaddress
     * @return ����linkaddress��ֵ
     */
    public String getLinkAddress(){
        return linkAddress;
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
     * ��������pager
     * @param pager �����õ�����pager��ֵ
     */
    public void setPager(String pager){
        this.pager = StringUtils.rightTrim(pager);
    }

    /**
     * ��ȡ����pager
     * @return ����pager��ֵ
     */
    public String getPager(){
        return pager;
    }

    /**
     * ��������email
     * @param email �����õ�����email��ֵ
     */
    public void setEmail(String email){
        this.email = StringUtils.rightTrim(email);
    }

    /**
     * ��ȡ����email
     * @return ����email��ֵ
     */
    public String getEmail(){
        return email;
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
     * ��������deathdate
     * @param deathDate �����õ�����deathdate��ֵ
     */
    public void setDeathDate(DateTime deathDate){
        this.deathDate = deathDate;
    }

    /**
     * ��ȡ����deathdate
     * @return ����deathdate��ֵ
     */
    public DateTime getDeathDate(){
        return deathDate;
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
