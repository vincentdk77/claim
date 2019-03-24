package com.sinosoft.function.power.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����PrpDcompany�������������ݴ���������<br>
 * ������ 2004-11-09 18:30:39.076<br>
 * JToolpad(1.2.14) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcompanyDtoBase implements Serializable{
    /** ����ComCode */
    private String comCode = "";
    /** ����ComCName */
    private String comCName = "";
    /** ����ComEName */
    private String comEName = "";
    /** ����AddressCName */
    private String addressCName = "";
    /** ����AddressEName */
    private String addressEName = "";
    /** ����PostCode */
    private String postCode = "";
    /** ����PhoneNumber */
    private String phoneNumber = "";
    /** ����FaxNumber */
    private String faxNumber = "";
    /** ����TaxNumber */
    private String taxNumber = "";
    /** ����UpperComCode */
    private String upperComCode = "";
    /** ����InsurerName */
    private String insurerName = "";
    /** ����ComAttribute */
    private String comAttribute = "";
    /** ����Manager */
    private String manager = "";
    /** ����AccountLeader */
    private String accountLeader = "";
    /** ����Cashier */
    private String cashier = "";
    /** ����ComType */
    private String comType = "";
    /** ����ComLevel */
    private String comLevel = "";
    /** ����Accountant */
    private String accountant = "";
    /** ����Remark */
    private String remark = "";
    /** ����NewComCode */
    private String newComCode = "";
    /** ����ValidStatus */
    private String validStatus = "";
    /** ����AcntUnit */
    private String acntUnit = "";
    /** ����ArticleCode */
    private String articleCode = "";
    /** ����AccCode */
    private String accCode = "";
    /** ����CenterFlag */
    private String centerFlag = "";
    /** ����OuterPayCode */
    private String outerPayCode = "";
    /** ����InnerPayCode */
    private String innerPayCode = "";
    /** ����Flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcompanyDtoBase����
     */
    public PrpDcompanyDtoBase(){
    }

    /**
     * ��������ComCode
     * @param comCode �����õ�����ComCode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����ComCode
     * @return ����ComCode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������ComCName
     * @param comCName �����õ�����ComCName��ֵ
     */
    public void setComCName(String comCName){
        this.comCName = StringUtils.rightTrim(comCName);
    }

    /**
     * ��ȡ����ComCName
     * @return ����ComCName��ֵ
     */
    public String getComCName(){
        return comCName;
    }

    /**
     * ��������ComEName
     * @param comEName �����õ�����ComEName��ֵ
     */
    public void setComEName(String comEName){
        this.comEName = StringUtils.rightTrim(comEName);
    }

    /**
     * ��ȡ����ComEName
     * @return ����ComEName��ֵ
     */
    public String getComEName(){
        return comEName;
    }

    /**
     * ��������AddressCName
     * @param addressCName �����õ�����AddressCName��ֵ
     */
    public void setAddressCName(String addressCName){
        this.addressCName = StringUtils.rightTrim(addressCName);
    }

    /**
     * ��ȡ����AddressCName
     * @return ����AddressCName��ֵ
     */
    public String getAddressCName(){
        return addressCName;
    }

    /**
     * ��������AddressEName
     * @param addressEName �����õ�����AddressEName��ֵ
     */
    public void setAddressEName(String addressEName){
        this.addressEName = StringUtils.rightTrim(addressEName);
    }

    /**
     * ��ȡ����AddressEName
     * @return ����AddressEName��ֵ
     */
    public String getAddressEName(){
        return addressEName;
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
     * ��������FaxNumber
     * @param faxNumber �����õ�����FaxNumber��ֵ
     */
    public void setFaxNumber(String faxNumber){
        this.faxNumber = StringUtils.rightTrim(faxNumber);
    }

    /**
     * ��ȡ����FaxNumber
     * @return ����FaxNumber��ֵ
     */
    public String getFaxNumber(){
        return faxNumber;
    }

    /**
     * ��������TaxNumber
     * @param taxNumber �����õ�����TaxNumber��ֵ
     */
    public void setTaxNumber(String taxNumber){
        this.taxNumber = StringUtils.rightTrim(taxNumber);
    }

    /**
     * ��ȡ����TaxNumber
     * @return ����TaxNumber��ֵ
     */
    public String getTaxNumber(){
        return taxNumber;
    }

    /**
     * ��������UpperComCode
     * @param upperComCode �����õ�����UpperComCode��ֵ
     */
    public void setUpperComCode(String upperComCode){
        this.upperComCode = StringUtils.rightTrim(upperComCode);
    }

    /**
     * ��ȡ����UpperComCode
     * @return ����UpperComCode��ֵ
     */
    public String getUpperComCode(){
        return upperComCode;
    }

    /**
     * ��������InsurerName
     * @param insurerName �����õ�����InsurerName��ֵ
     */
    public void setInsurerName(String insurerName){
        this.insurerName = StringUtils.rightTrim(insurerName);
    }

    /**
     * ��ȡ����InsurerName
     * @return ����InsurerName��ֵ
     */
    public String getInsurerName(){
        return insurerName;
    }

    /**
     * ��������ComAttribute
     * @param comAttribute �����õ�����ComAttribute��ֵ
     */
    public void setComAttribute(String comAttribute){
        this.comAttribute = StringUtils.rightTrim(comAttribute);
    }

    /**
     * ��ȡ����ComAttribute
     * @return ����ComAttribute��ֵ
     */
    public String getComAttribute(){
        return comAttribute;
    }

    /**
     * ��������Manager
     * @param manager �����õ�����Manager��ֵ
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * ��ȡ����Manager
     * @return ����Manager��ֵ
     */
    public String getManager(){
        return manager;
    }

    /**
     * ��������AccountLeader
     * @param accountLeader �����õ�����AccountLeader��ֵ
     */
    public void setAccountLeader(String accountLeader){
        this.accountLeader = StringUtils.rightTrim(accountLeader);
    }

    /**
     * ��ȡ����AccountLeader
     * @return ����AccountLeader��ֵ
     */
    public String getAccountLeader(){
        return accountLeader;
    }

    /**
     * ��������Cashier
     * @param cashier �����õ�����Cashier��ֵ
     */
    public void setCashier(String cashier){
        this.cashier = StringUtils.rightTrim(cashier);
    }

    /**
     * ��ȡ����Cashier
     * @return ����Cashier��ֵ
     */
    public String getCashier(){
        return cashier;
    }

    /**
     * ��������ComType
     * @param comType �����õ�����ComType��ֵ
     */
    public void setComType(String comType){
        this.comType = StringUtils.rightTrim(comType);
    }

    /**
     * ��ȡ����ComType
     * @return ����ComType��ֵ
     */
    public String getComType(){
        return comType;
    }

    /**
     * ��������ComLevel
     * @param comLevel �����õ�����ComLevel��ֵ
     */
    public void setComLevel(String comLevel){
        this.comLevel = StringUtils.rightTrim(comLevel);
    }

    /**
     * ��ȡ����ComLevel
     * @return ����ComLevel��ֵ
     */
    public String getComLevel(){
        return comLevel;
    }

    /**
     * ��������Accountant
     * @param accountant �����õ�����Accountant��ֵ
     */
    public void setAccountant(String accountant){
        this.accountant = StringUtils.rightTrim(accountant);
    }

    /**
     * ��ȡ����Accountant
     * @return ����Accountant��ֵ
     */
    public String getAccountant(){
        return accountant;
    }

    /**
     * ��������Remark
     * @param remark �����õ�����Remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����Remark
     * @return ����Remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������NewComCode
     * @param newComCode �����õ�����NewComCode��ֵ
     */
    public void setNewComCode(String newComCode){
        this.newComCode = StringUtils.rightTrim(newComCode);
    }

    /**
     * ��ȡ����NewComCode
     * @return ����NewComCode��ֵ
     */
    public String getNewComCode(){
        return newComCode;
    }

    /**
     * ��������ValidStatus
     * @param validStatus �����õ�����ValidStatus��ֵ
     */
    public void setValidStatus(String validStatus){
        this.validStatus = StringUtils.rightTrim(validStatus);
    }

    /**
     * ��ȡ����ValidStatus
     * @return ����ValidStatus��ֵ
     */
    public String getValidStatus(){
        return validStatus;
    }

    /**
     * ��������AcntUnit
     * @param acntUnit �����õ�����AcntUnit��ֵ
     */
    public void setAcntUnit(String acntUnit){
        this.acntUnit = StringUtils.rightTrim(acntUnit);
    }

    /**
     * ��ȡ����AcntUnit
     * @return ����AcntUnit��ֵ
     */
    public String getAcntUnit(){
        return acntUnit;
    }

    /**
     * ��������ArticleCode
     * @param articleCode �����õ�����ArticleCode��ֵ
     */
    public void setArticleCode(String articleCode){
        this.articleCode = StringUtils.rightTrim(articleCode);
    }

    /**
     * ��ȡ����ArticleCode
     * @return ����ArticleCode��ֵ
     */
    public String getArticleCode(){
        return articleCode;
    }

    /**
     * ��������AccCode
     * @param accCode �����õ�����AccCode��ֵ
     */
    public void setAccCode(String accCode){
        this.accCode = StringUtils.rightTrim(accCode);
    }

    /**
     * ��ȡ����AccCode
     * @return ����AccCode��ֵ
     */
    public String getAccCode(){
        return accCode;
    }

    /**
     * ��������CenterFlag
     * @param centerFlag �����õ�����CenterFlag��ֵ
     */
    public void setCenterFlag(String centerFlag){
        this.centerFlag = StringUtils.rightTrim(centerFlag);
    }

    /**
     * ��ȡ����CenterFlag
     * @return ����CenterFlag��ֵ
     */
    public String getCenterFlag(){
        return centerFlag;
    }

    /**
     * ��������OuterPayCode
     * @param outerPayCode �����õ�����OuterPayCode��ֵ
     */
    public void setOuterPayCode(String outerPayCode){
        this.outerPayCode = StringUtils.rightTrim(outerPayCode);
    }

    /**
     * ��ȡ����OuterPayCode
     * @return ����OuterPayCode��ֵ
     */
    public String getOuterPayCode(){
        return outerPayCode;
    }

    /**
     * ��������InnerPayCode
     * @param innerPayCode �����õ�����InnerPayCode��ֵ
     */
    public void setInnerPayCode(String innerPayCode){
        this.innerPayCode = StringUtils.rightTrim(innerPayCode);
    }

    /**
     * ��ȡ����InnerPayCode
     * @return ����InnerPayCode��ֵ
     */
    public String getInnerPayCode(){
        return innerPayCode;
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
