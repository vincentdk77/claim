package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PrpDcompany的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDcompanyDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性COMCODE */
    private String comCode = "";
    /** 属性COMCNAME */
    private String comCName = "";
    /** 属性COMENAME */
    private String comEName = "";
    /** 属性ADDRESSCNAME */
    private String addressCName = "";
    /** 属性ADDRESSENAME */
    private String addressEName = "";
    /** 属性POSTCODE */
    private String postCode = "";
    /** 属性PHONENUMBER */
    private String phoneNumber = "";
    /** 属性TAXNUMBER */
    private String taxNumber = "";
    /** 属性FAXNUMBER */
    private String faxNumber = "";
    /** 属性UPPERCOMCODE */
    private String upperComCode = "";
    /** 属性INSURERNAME */
    private String insurerName = "";
    /** 属性COMATTRIBUTE */
    private String comAttribute = "";
    /** 属性COMTYPE */
    private String comType = "";
    /** 属性COMLEVEL */
    private String comLevel = "";
    /** 属性MANAGER */
    private String manager = "";
    /** 属性ACCOUNTLEADER */
    private String accountLeader = "";
    /** 属性CASHIER */
    private String cashier = "";
    /** 属性ACCOUNTANT */
    private String accountant = "";
    /** 属性REMARK */
    private String remark = "";
    /** 属性NEWCOMCODE */
    private String newComCode = "";
    /** 属性VALIDSTATUS */
    private String validStatus = "";
    /** 属性ACNTUNIT */
    private String acntUnit = "";
    /** 属性ARTICLECODE */
    private String articleCode = "";
    /** 属性ACcccode */
    private String acccode = "";
    /** 属性CENTERFLAG */
    private String centerFlag = "";
    /** 属性OUTERPAYCODE */
    private String outerPayCode = "";
    /** 属性INNERPAYCODE */
    private String innerPayCode = "";
    /** 属性FLAG */
    private String flag = "";
    /** 属性WEBADDRESS */
    private String webAddress = "";
    /** 属性SERVICEPHONE */
    private String servicePhone = "";
    /** 属性REPORTPHONE */
    private String reportPhone = "";
    /** 属性SysAreaCode */
    private String sysAreaCode = "";
    /** 属性CityCode */
    private String cityCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpDcompanyDtoBase对象
     */
    public PrpDcompanyDtoBase(){
    }

    /**
     * 设置属性COMCODE
     * @param comCode 待设置的属性COMCODE的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性COMCODE
     * @return 属性COMCODE的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性COMCNAME
     * @param comCName 待设置的属性COMCNAME的值
     */
    public void setComCName(String comCName){
        this.comCName = StringUtils.rightTrim(comCName);
    }

    /**
     * 获取属性COMCNAME
     * @return 属性COMCNAME的值
     */
    public String getComCName(){
        return comCName;
    }

    /**
     * 设置属性COMENAME
     * @param comEName 待设置的属性COMENAME的值
     */
    public void setComEName(String comEName){
        this.comEName = StringUtils.rightTrim(comEName);
    }

    /**
     * 获取属性COMENAME
     * @return 属性COMENAME的值
     */
    public String getComEName(){
        return comEName;
    }

    /**
     * 设置属性ADDRESSCNAME
     * @param addressCName 待设置的属性ADDRESSCNAME的值
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * 获取属性ADDRESSCNAME
     * @return 属性ADDRESSCNAME的值
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * 设置属性ADDRESSENAME
     * @param addressEName 待设置的属性ADDRESSENAME的值
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * 获取属性ADDRESSENAME
     * @return 属性ADDRESSENAME的值
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * 设置属性POSTCODE
     * @param postCode 待设置的属性POSTCODE的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性POSTCODE
     * @return 属性POSTCODE的值
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * 设置属性PHONENUMBER
     * @param phoneNumber 待设置的属性PHONENUMBER的值
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * 获取属性PHONENUMBER
     * @return 属性PHONENUMBER的值
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * 设置属性TAXNUMBER
     * @param taxNumber 待设置的属性TAXNUMBER的值
     */
    public void setTaxNumber(String taxNumber){
        this.taxNumber = StringUtils.rightTrim(taxNumber);
    }

    /**
     * 获取属性TAXNUMBER
     * @return 属性TAXNUMBER的值
     */
    public String getTaxNumber(){
        return taxNumber;
    }

    /**
     * 设置属性FAXNUMBER
     * @param faxNumber 待设置的属性FAXNUMBER的值
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * 获取属性FAXNUMBER
     * @return 属性FAXNUMBER的值
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * 设置属性UPPERCOMCODE
     * @param upperComCode 待设置的属性UPPERCOMCODE的值
     */
    public void setUpperComCode(String upperComCode){
        this.upperComCode = StringUtils.rightTrim(upperComCode);
    }

    /**
     * 获取属性UPPERCOMCODE
     * @return 属性UPPERCOMCODE的值
     */
    public String getUpperComCode(){
        return upperComCode;
    }

    /**
     * 设置属性INSURERNAME
     * @param insurerName 待设置的属性INSURERNAME的值
     */
    public void setInsurerName(String insurerName){
        this.insurerName = StringUtils.rightTrim(insurerName);
    }

    /**
     * 获取属性INSURERNAME
     * @return 属性INSURERNAME的值
     */
    public String getInsurerName(){
        return insurerName;
    }

    /**
     * 设置属性COMATTRIBUTE
     * @param comAttribute 待设置的属性COMATTRIBUTE的值
     */
    public void setComAttribute(String comAttribute){
        this.comAttribute = StringUtils.rightTrim(comAttribute);
    }

    /**
     * 获取属性COMATTRIBUTE
     * @return 属性COMATTRIBUTE的值
     */
    public String getComAttribute(){
        return comAttribute;
    }

    /**
     * 设置属性COMTYPE
     * @param comType 待设置的属性COMTYPE的值
     */
    public void setComType(String comType){
        this.comType = StringUtils.rightTrim(comType);
    }

    /**
     * 获取属性COMTYPE
     * @return 属性COMTYPE的值
     */
    public String getComType(){
        return comType;
    }

    /**
     * 设置属性COMLEVEL
     * @param comLevel 待设置的属性COMLEVEL的值
     */
    public void setComLevel(String comLevel){
        this.comLevel = StringUtils.rightTrim(comLevel);
    }

    /**
     * 获取属性COMLEVEL
     * @return 属性COMLEVEL的值
     */
    public String getComLevel(){
        return comLevel;
    }

    /**
     * 设置属性MANAGER
     * @param manager 待设置的属性MANAGER的值
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * 获取属性MANAGER
     * @return 属性MANAGER的值
     */
    public String getManager(){
        return manager;
    }

    /**
     * 设置属性ACCOUNTLEADER
     * @param accountLeader 待设置的属性ACCOUNTLEADER的值
     */
    public void setAccountLeader(String accountLeader){
        this.accountLeader = StringUtils.rightTrim(accountLeader);
    }

    /**
     * 获取属性ACCOUNTLEADER
     * @return 属性ACCOUNTLEADER的值
     */
    public String getAccountLeader(){
        return accountLeader;
    }

    /**
     * 设置属性CASHIER
     * @param cashier 待设置的属性CASHIER的值
     */
    public void setCashier(String cashier){
        this.cashier = StringUtils.rightTrim(cashier);
    }

    /**
     * 获取属性CASHIER
     * @return 属性CASHIER的值
     */
    public String getCashier(){
        return cashier;
    }

    /**
     * 设置属性ACCOUNTANT
     * @param accountant 待设置的属性ACCOUNTANT的值
     */
    public void setAccountant(String accountant){
        this.accountant = StringUtils.rightTrim(accountant);
    }

    /**
     * 获取属性ACCOUNTANT
     * @return 属性ACCOUNTANT的值
     */
    public String getAccountant(){
        return accountant;
    }

    /**
     * 设置属性REMARK
     * @param remark 待设置的属性REMARK的值
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * 获取属性REMARK
     * @return 属性REMARK的值
     */
    public String getRemark(){
        return remark;
    }

    /**
     * 设置属性NEWCOMCODE
     * @param newComCode 待设置的属性NEWCOMCODE的值
     */
    public void setNewComCode(String newComCode){
        this.newComCode = StringUtils.rightTrim(newComCode);
    }

    /**
     * 获取属性NEWCOMCODE
     * @return 属性NEWCOMCODE的值
     */
    public String getNewComCode(){
        return newComCode;
    }

    /**
     * 设置属性VALIDSTATUS
     * @param validStatus 待设置的属性VALIDSTATUS的值
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * 获取属性VALIDSTATUS
     * @return 属性VALIDSTATUS的值
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * 设置属性ACNTUNIT
     * @param acntUnit 待设置的属性ACNTUNIT的值
     */
    public void setAcntUnit(String acntUnit){
        this.acntUnit = StringUtils.rightTrim(acntUnit);
    }

    /**
     * 获取属性ACNTUNIT
     * @return 属性ACNTUNIT的值
     */
    public String getAcntUnit(){
        return acntUnit;
    }

    /**
     * 设置属性ARTICLECODE
     * @param articleCode 待设置的属性ARTICLECODE的值
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * 获取属性ARTICLECODE
     * @return 属性ARTICLECODE的值
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * 设置属性ACcccode
     * @param acccode 待设置的属性ACcccode的值
     */
    public void setAcccode(String acccode){
        this.acccode = StringUtils.rightTrim(acccode);
    }

    /**
     * 获取属性ACcccode
     * @return 属性ACcccode的值
     */
    public String getAcccode(){
        return acccode;
    }

    /**
     * 设置属性CENTERFLAG
     * @param centerFlag 待设置的属性CENTERFLAG的值
     */
    public void setCenterFlag(String centerFlag){
        this.centerFlag = StringUtils.rightTrim(centerFlag);
    }

    /**
     * 获取属性CENTERFLAG
     * @return 属性CENTERFLAG的值
     */
    public String getCenterFlag(){
        return centerFlag;
    }

    /**
     * 设置属性OUTERPAYCODE
     * @param outerPayCode 待设置的属性OUTERPAYCODE的值
     */
    public void setOuterPayCode(String outerPayCode){
        this.outerPayCode = StringUtils.rightTrim(outerPayCode);
    }

    /**
     * 获取属性OUTERPAYCODE
     * @return 属性OUTERPAYCODE的值
     */
    public String getOuterPayCode(){
        return outerPayCode;
    }

    /**
     * 设置属性INNERPAYCODE
     * @param innerPayCode 待设置的属性INNERPAYCODE的值
     */
    public void setInnerPayCode(String innerPayCode){
        this.innerPayCode = StringUtils.rightTrim(innerPayCode);
    }

    /**
     * 获取属性INNERPAYCODE
     * @return 属性INNERPAYCODE的值
     */
    public String getInnerPayCode(){
        return innerPayCode;
    }

    /**
     * 设置属性FLAG
     * @param flag 待设置的属性FLAG的值
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * 获取属性FLAG
     * @return 属性FLAG的值
     */
    public String getFlag(){
        return flag;
    }

    /**
     * 设置属性WEBADDRESS
     * @param webAddress 待设置的属性WEBADDRESS的值
     */
    public void setWebAddress(String webAddress){
        this.webAddress = StringUtils.rightTrim(webAddress);
    }

    /**
     * 获取属性WEBADDRESS
     * @return 属性WEBADDRESS的值
     */
    public String getWebAddress(){
        return webAddress;
    }

    /**
     * 设置属性SERVICEPHONE
     * @param servicePhone 待设置的属性SERVICEPHONE的值
     */
    public void setServicePhone(String servicePhone){
        this.servicePhone = StringUtils.rightTrim(servicePhone);
    }

    /**
     * 获取属性SERVICEPHONE
     * @return 属性SERVICEPHONE的值
     */
    public String getServicePhone(){
        return servicePhone;
    }

    /**
     * 设置属性REPORTPHONE
     * @param reportPhone 待设置的属性REPORTPHONE的值
     */
    public void setReportPhone(String reportPhone){
        this.reportPhone = StringUtils.rightTrim(reportPhone);
    }

    /**
     * 获取属性REPORTPHONE
     * @return 属性REPORTPHONE的值
     */
    public String getReportPhone(){
        return reportPhone;
    }

    /**
     * 设置属性SysAreaCode
     * @param sysAreaCode 待设置的属性SysAreaCode的值
     */
    public void setSysAreaCode(String sysAreaCode){
        this.sysAreaCode = StringUtils.rightTrim(sysAreaCode);
    }

    /**
     * 获取属性SysAreaCode
     * @return 属性SysAreaCode的值
     */
    public String getSysAreaCode(){
        return sysAreaCode;
    }

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
}
