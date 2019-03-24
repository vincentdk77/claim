package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PrpDcompany�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpDcompanyDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����COMCODE */
    private String comCode = "";
    /** ����COMCNAME */
    private String comCName = "";
    /** ����COMENAME */
    private String comEName = "";
    /** ����ADDRESSCNAME */
    private String addressCName = "";
    /** ����ADDRESSENAME */
    private String addressEName = "";
    /** ����POSTCODE */
    private String postCode = "";
    /** ����PHONENUMBER */
    private String phoneNumber = "";
    /** ����TAXNUMBER */
    private String taxNumber = "";
    /** ����FAXNUMBER */
    private String faxNumber = "";
    /** ����UPPERCOMCODE */
    private String upperComCode = "";
    /** ����INSURERNAME */
    private String insurerName = "";
    /** ����COMATTRIBUTE */
    private String comAttribute = "";
    /** ����COMTYPE */
    private String comType = "";
    /** ����COMLEVEL */
    private String comLevel = "";
    /** ����MANAGER */
    private String manager = "";
    /** ����ACCOUNTLEADER */
    private String accountLeader = "";
    /** ����CASHIER */
    private String cashier = "";
    /** ����ACCOUNTANT */
    private String accountant = "";
    /** ����REMARK */
    private String remark = "";
    /** ����NEWCOMCODE */
    private String newComCode = "";
    /** ����VALIDSTATUS */
    private String validStatus = "";
    /** ����ACNTUNIT */
    private String acntUnit = "";
    /** ����ARTICLECODE */
    private String articleCode = "";
    /** ����ACcccode */
    private String acccode = "";
    /** ����CENTERFLAG */
    private String centerFlag = "";
    /** ����OUTERPAYCODE */
    private String outerPayCode = "";
    /** ����INNERPAYCODE */
    private String innerPayCode = "";
    /** ����FLAG */
    private String flag = "";
    /** ����WEBADDRESS */
    private String webAddress = "";
    /** ����SERVICEPHONE */
    private String servicePhone = "";
    /** ����REPORTPHONE */
    private String reportPhone = "";
    /** ����SysAreaCode */
    private String sysAreaCode = "";
    /** ����CityCode */
    private String cityCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcompanyDtoBase����
     */
    public PrpDcompanyDtoBase(){
    }

    /**
     * ��������COMCODE
     * @param comCode �����õ�����COMCODE��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����COMCODE
     * @return ����COMCODE��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������COMCNAME
     * @param comCName �����õ�����COMCNAME��ֵ
     */
    public void setComCName(String comCName){
        this.comCName = StringUtils.rightTrim(comCName);
    }

    /**
     * ��ȡ����COMCNAME
     * @return ����COMCNAME��ֵ
     */
    public String getComCName(){
        return comCName;
    }

    /**
     * ��������COMENAME
     * @param comEName �����õ�����COMENAME��ֵ
     */
    public void setComEName(String comEName){
        this.comEName = StringUtils.rightTrim(comEName);
    }

    /**
     * ��ȡ����COMENAME
     * @return ����COMENAME��ֵ
     */
    public String getComEName(){
        return comEName;
    }

    /**
     * ��������ADDRESSCNAME
     * @param addressCName �����õ�����ADDRESSCNAME��ֵ
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * ��ȡ����ADDRESSCNAME
     * @return ����ADDRESSCNAME��ֵ
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * ��������ADDRESSENAME
     * @param addressEName �����õ�����ADDRESSENAME��ֵ
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * ��ȡ����ADDRESSENAME
     * @return ����ADDRESSENAME��ֵ
     */
    public String getAddressEName(){
        return addressEName;
    }

    /**
     * ��������POSTCODE
     * @param postCode �����õ�����POSTCODE��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ����POSTCODE
     * @return ����POSTCODE��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

    /**
     * ��������PHONENUMBER
     * @param phoneNumber �����õ�����PHONENUMBER��ֵ
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = StringUtils.rightTrim(phoneNumber);
    }

    /**
     * ��ȡ����PHONENUMBER
     * @return ����PHONENUMBER��ֵ
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * ��������TAXNUMBER
     * @param taxNumber �����õ�����TAXNUMBER��ֵ
     */
    public void setTaxNumber(String taxNumber){
        this.taxNumber = StringUtils.rightTrim(taxNumber);
    }

    /**
     * ��ȡ����TAXNUMBER
     * @return ����TAXNUMBER��ֵ
     */
    public String getTaxNumber(){
        return taxNumber;
    }

    /**
     * ��������FAXNUMBER
     * @param faxNumber �����õ�����FAXNUMBER��ֵ
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * ��ȡ����FAXNUMBER
     * @return ����FAXNUMBER��ֵ
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * ��������UPPERCOMCODE
     * @param upperComCode �����õ�����UPPERCOMCODE��ֵ
     */
    public void setUpperComCode(String upperComCode){
        this.upperComCode = StringUtils.rightTrim(upperComCode);
    }

    /**
     * ��ȡ����UPPERCOMCODE
     * @return ����UPPERCOMCODE��ֵ
     */
    public String getUpperComCode(){
        return upperComCode;
    }

    /**
     * ��������INSURERNAME
     * @param insurerName �����õ�����INSURERNAME��ֵ
     */
    public void setInsurerName(String insurerName){
        this.insurerName = StringUtils.rightTrim(insurerName);
    }

    /**
     * ��ȡ����INSURERNAME
     * @return ����INSURERNAME��ֵ
     */
    public String getInsurerName(){
        return insurerName;
    }

    /**
     * ��������COMATTRIBUTE
     * @param comAttribute �����õ�����COMATTRIBUTE��ֵ
     */
    public void setComAttribute(String comAttribute){
        this.comAttribute = StringUtils.rightTrim(comAttribute);
    }

    /**
     * ��ȡ����COMATTRIBUTE
     * @return ����COMATTRIBUTE��ֵ
     */
    public String getComAttribute(){
        return comAttribute;
    }

    /**
     * ��������COMTYPE
     * @param comType �����õ�����COMTYPE��ֵ
     */
    public void setComType(String comType){
        this.comType = StringUtils.rightTrim(comType);
    }

    /**
     * ��ȡ����COMTYPE
     * @return ����COMTYPE��ֵ
     */
    public String getComType(){
        return comType;
    }

    /**
     * ��������COMLEVEL
     * @param comLevel �����õ�����COMLEVEL��ֵ
     */
    public void setComLevel(String comLevel){
        this.comLevel = StringUtils.rightTrim(comLevel);
    }

    /**
     * ��ȡ����COMLEVEL
     * @return ����COMLEVEL��ֵ
     */
    public String getComLevel(){
        return comLevel;
    }

    /**
     * ��������MANAGER
     * @param manager �����õ�����MANAGER��ֵ
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * ��ȡ����MANAGER
     * @return ����MANAGER��ֵ
     */
    public String getManager(){
        return manager;
    }

    /**
     * ��������ACCOUNTLEADER
     * @param accountLeader �����õ�����ACCOUNTLEADER��ֵ
     */
    public void setAccountLeader(String accountLeader){
        this.accountLeader = StringUtils.rightTrim(accountLeader);
    }

    /**
     * ��ȡ����ACCOUNTLEADER
     * @return ����ACCOUNTLEADER��ֵ
     */
    public String getAccountLeader(){
        return accountLeader;
    }

    /**
     * ��������CASHIER
     * @param cashier �����õ�����CASHIER��ֵ
     */
    public void setCashier(String cashier){
        this.cashier = StringUtils.rightTrim(cashier);
    }

    /**
     * ��ȡ����CASHIER
     * @return ����CASHIER��ֵ
     */
    public String getCashier(){
        return cashier;
    }

    /**
     * ��������ACCOUNTANT
     * @param accountant �����õ�����ACCOUNTANT��ֵ
     */
    public void setAccountant(String accountant){
        this.accountant = StringUtils.rightTrim(accountant);
    }

    /**
     * ��ȡ����ACCOUNTANT
     * @return ����ACCOUNTANT��ֵ
     */
    public String getAccountant(){
        return accountant;
    }

    /**
     * ��������REMARK
     * @param remark �����õ�����REMARK��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����REMARK
     * @return ����REMARK��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������NEWCOMCODE
     * @param newComCode �����õ�����NEWCOMCODE��ֵ
     */
    public void setNewComCode(String newComCode){
        this.newComCode = StringUtils.rightTrim(newComCode);
    }

    /**
     * ��ȡ����NEWCOMCODE
     * @return ����NEWCOMCODE��ֵ
     */
    public String getNewComCode(){
        return newComCode;
    }

    /**
     * ��������VALIDSTATUS
     * @param validStatus �����õ�����VALIDSTATUS��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����VALIDSTATUS
     * @return ����VALIDSTATUS��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������ACNTUNIT
     * @param acntUnit �����õ�����ACNTUNIT��ֵ
     */
    public void setAcntUnit(String acntUnit){
        this.acntUnit = StringUtils.rightTrim(acntUnit);
    }

    /**
     * ��ȡ����ACNTUNIT
     * @return ����ACNTUNIT��ֵ
     */
    public String getAcntUnit(){
        return acntUnit;
    }

    /**
     * ��������ARTICLECODE
     * @param articleCode �����õ�����ARTICLECODE��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����ARTICLECODE
     * @return ����ARTICLECODE��ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * ��������ACcccode
     * @param acccode �����õ�����ACcccode��ֵ
     */
    public void setAcccode(String acccode){
        this.acccode = StringUtils.rightTrim(acccode);
    }

    /**
     * ��ȡ����ACcccode
     * @return ����ACcccode��ֵ
     */
    public String getAcccode(){
        return acccode;
    }

    /**
     * ��������CENTERFLAG
     * @param centerFlag �����õ�����CENTERFLAG��ֵ
     */
    public void setCenterFlag(String centerFlag){
        this.centerFlag = StringUtils.rightTrim(centerFlag);
    }

    /**
     * ��ȡ����CENTERFLAG
     * @return ����CENTERFLAG��ֵ
     */
    public String getCenterFlag(){
        return centerFlag;
    }

    /**
     * ��������OUTERPAYCODE
     * @param outerPayCode �����õ�����OUTERPAYCODE��ֵ
     */
    public void setOuterPayCode(String outerPayCode){
        this.outerPayCode = StringUtils.rightTrim(outerPayCode);
    }

    /**
     * ��ȡ����OUTERPAYCODE
     * @return ����OUTERPAYCODE��ֵ
     */
    public String getOuterPayCode(){
        return outerPayCode;
    }

    /**
     * ��������INNERPAYCODE
     * @param innerPayCode �����õ�����INNERPAYCODE��ֵ
     */
    public void setInnerPayCode(String innerPayCode){
        this.innerPayCode = StringUtils.rightTrim(innerPayCode);
    }

    /**
     * ��ȡ����INNERPAYCODE
     * @return ����INNERPAYCODE��ֵ
     */
    public String getInnerPayCode(){
        return innerPayCode;
    }

    /**
     * ��������FLAG
     * @param flag �����õ�����FLAG��ֵ
     */
    public void setFlag(String flag){
        this.flag = StringUtils.rightTrim(flag);
    }

    /**
     * ��ȡ����FLAG
     * @return ����FLAG��ֵ
     */
    public String getFlag(){
        return flag;
    }

    /**
     * ��������WEBADDRESS
     * @param webAddress �����õ�����WEBADDRESS��ֵ
     */
    public void setWebAddress(String webAddress){
        this.webAddress = StringUtils.rightTrim(webAddress);
    }

    /**
     * ��ȡ����WEBADDRESS
     * @return ����WEBADDRESS��ֵ
     */
    public String getWebAddress(){
        return webAddress;
    }

    /**
     * ��������SERVICEPHONE
     * @param servicePhone �����õ�����SERVICEPHONE��ֵ
     */
    public void setServicePhone(String servicePhone){
        this.servicePhone = StringUtils.rightTrim(servicePhone);
    }

    /**
     * ��ȡ����SERVICEPHONE
     * @return ����SERVICEPHONE��ֵ
     */
    public String getServicePhone(){
        return servicePhone;
    }

    /**
     * ��������REPORTPHONE
     * @param reportPhone �����õ�����REPORTPHONE��ֵ
     */
    public void setReportPhone(String reportPhone){
        this.reportPhone = StringUtils.rightTrim(reportPhone);
    }

    /**
     * ��ȡ����REPORTPHONE
     * @return ����REPORTPHONE��ֵ
     */
    public String getReportPhone(){
        return reportPhone;
    }

    /**
     * ��������SysAreaCode
     * @param sysAreaCode �����õ�����SysAreaCode��ֵ
     */
    public void setSysAreaCode(String sysAreaCode){
        this.sysAreaCode = StringUtils.rightTrim(sysAreaCode);
    }

    /**
     * ��ȡ����SysAreaCode
     * @return ����SysAreaCode��ֵ
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
