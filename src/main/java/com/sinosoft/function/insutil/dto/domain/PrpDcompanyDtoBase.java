package com.sinosoft.function.insutil.dto.domain;

import java.io.Serializable;

import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ����prpdcompany�����ݴ���������<br>
 * ������ 2004-4-5 15:22:07<br>
 * JToolpad(1.2.3) Vendor:zhouxianli@sinosoft.com.cn
 */
public class PrpDcompanyDtoBase implements Serializable{
    /** ����comcode */
    private String comCode = "";
    /** ����comcname */
    private String comCName = "";
    /** ����comename */
    private String comEName = "";
    /** ����addresscname */
    private String addressCName = "";
    /** ����addressename */
    private String addressEName = "";
    /** ����postcode */
    private String postCode = "";
    /** ����phonenumber */
    private String phoneNumber = "";
    /** ����˰�� */
    private String taxNumber = "";
    /** ����faxnumber */
    private String faxNumber = "";
    /** ����uppercomcode */
    private String upperComCode = "";
    /** ����insurername */
    private String insurerName = "";
    /** ���Ե�λ���� */
    private String comAttribute = "";
    /** ����comtype */
    private String comType = "";
    /** ����comlevel */
    private String comLevel = "";
    /** ����manager */
    private String manager = "";
    /** ���Բ����쵼 */
    private String accountLeader = "";
    /** ���Գ���Ա */
    private String cashier = "";
    /** ����accountant */
    private String accountant = "";
    /** ����remark */
    private String remark = "";
    /** ����newcomcode */
    private String newComCode = "";
    /** ����validstatus */
    private String validStatus = "";
    /** ����acntunit */
    private String acntUnit = "";
    /** ����articlecode */
    private String articleCode = "";
    /** ����acccode */
    private String accCode = "";
    /** ���Ժ��㵥λ��־ */
    private String centerFlag = "";
    /** ����OuterPayCode */
    private String outerPayCode = "";
    /** ����InnerPayCode */
    private String innerPayCode = "";
    /** ����flag */
    private String flag = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpDcompanyDtoBase����
     */
    public PrpDcompanyDtoBase(){
    }

    /**
     * ��������comcode
     * @param comCode �����õ�����comcode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comcode
     * @return ����comcode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������comcname
     * @param comCName �����õ�����comcname��ֵ
     */
    public void setComCName(String comCName){
        this.comCName = StringUtils.rightTrim(comCName);
    }

    /**
     * ��ȡ����comcname
     * @return ����comcname��ֵ
     */
    public String getComCName(){
        return comCName;
    }

    /**
     * ��������comename
     * @param comEName �����õ�����comename��ֵ
     */
    public void setComEName(String comEName){
        this.comEName = StringUtils.rightTrim(comEName);
    }

    /**
     * ��ȡ����comename
     * @return ����comename��ֵ
     */
    public String getComEName(){
        return comEName;
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
     * ��������˰��
     * @param taxNumber �����õ�����˰�ŵ�ֵ
     */
    public void setTaxNumber(String taxNumber){
        this.taxNumber = StringUtils.rightTrim(taxNumber);
    }

    /**
     * ��ȡ����˰��
     * @return ����˰�ŵ�ֵ
     */
    public String getTaxNumber(){
        return taxNumber;
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
     * ��������uppercomcode
     * @param upperComCode �����õ�����uppercomcode��ֵ
     */
    public void setUpperComCode(String upperComCode){
        this.upperComCode = StringUtils.rightTrim(upperComCode);
    }

    /**
     * ��ȡ����uppercomcode
     * @return ����uppercomcode��ֵ
     */
    public String getUpperComCode(){
        return upperComCode;
    }

    /**
     * ��������insurername
     * @param insurerName �����õ�����insurername��ֵ
     */
    public void setInsurerName(String insurerName){
        this.insurerName = StringUtils.rightTrim(insurerName);
    }

    /**
     * ��ȡ����insurername
     * @return ����insurername��ֵ
     */
    public String getInsurerName(){
        return insurerName;
    }

    /**
     * �������Ե�λ����
     * @param comAttribute �����õ����Ե�λ���ʵ�ֵ
     */
    public void setComAttribute(String comAttribute){
        this.comAttribute = StringUtils.rightTrim(comAttribute);
    }

    /**
     * ��ȡ���Ե�λ����
     * @return ���Ե�λ���ʵ�ֵ
     */
    public String getComAttribute(){
        return comAttribute;
    }

    /**
     * ��������comtype
     * @param comType �����õ�����comtype��ֵ
     */
    public void setComType(String comType){
        this.comType = StringUtils.rightTrim(comType);
    }

    /**
     * ��ȡ����comtype
     * @return ����comtype��ֵ
     */
    public String getComType(){
        return comType;
    }

    /**
     * ��������comlevel
     * @param comLevel �����õ�����comlevel��ֵ
     */
    public void setComLevel(String comLevel){
        this.comLevel = StringUtils.rightTrim(comLevel);
    }

    /**
     * ��ȡ����comlevel
     * @return ����comlevel��ֵ
     */
    public String getComLevel(){
        return comLevel;
    }

    /**
     * ��������manager
     * @param manager �����õ�����manager��ֵ
     */
    public void setManager(String manager){
        this.manager = StringUtils.rightTrim(manager);
    }

    /**
     * ��ȡ����manager
     * @return ����manager��ֵ
     */
    public String getManager(){
        return manager;
    }

    /**
     * �������Բ����쵼
     * @param accountLeader �����õ����Բ����쵼��ֵ
     */
    public void setAccountLeader(String accountLeader){
        this.accountLeader = StringUtils.rightTrim(accountLeader);
    }

    /**
     * ��ȡ���Բ����쵼
     * @return ���Բ����쵼��ֵ
     */
    public String getAccountLeader(){
        return accountLeader;
    }

    /**
     * �������Գ���Ա
     * @param cashier �����õ����Գ���Ա��ֵ
     */
    public void setCashier(String cashier){
        this.cashier = StringUtils.rightTrim(cashier);
    }

    /**
     * ��ȡ���Գ���Ա
     * @return ���Գ���Ա��ֵ
     */
    public String getCashier(){
        return cashier;
    }

    /**
     * ��������accountant
     * @param accountant �����õ�����accountant��ֵ
     */
    public void setAccountant(String accountant){
        this.accountant = StringUtils.rightTrim(accountant);
    }

    /**
     * ��ȡ����accountant
     * @return ����accountant��ֵ
     */
    public String getAccountant(){
        return accountant;
    }

    /**
     * ��������remark
     * @param remark �����õ�����remark��ֵ
     */
    public void setRemark(String remark){
        this.remark = StringUtils.rightTrim(remark);
    }

    /**
     * ��ȡ����remark
     * @return ����remark��ֵ
     */
    public String getRemark(){
        return remark;
    }

    /**
     * ��������newcomcode
     * @param newComCode �����õ�����newcomcode��ֵ
     */
    public void setNewComCode(String newComCode){
        this.newComCode = StringUtils.rightTrim(newComCode);
    }

    /**
     * ��ȡ����newcomcode
     * @return ����newcomcode��ֵ
     */
    public String getNewComCode(){
        return newComCode;
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
     * ��������acntunit
     * @param acntUnit �����õ�����acntunit��ֵ
     */
    public void setAcntUnit(String acntUnit){
        this.acntUnit = StringUtils.rightTrim(acntUnit);
    }

    /**
     * ��ȡ����acntunit
     * @return ����acntunit��ֵ
     */
    public String getAcntUnit(){
        return acntUnit;
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
     * ��������acccode
     * @param accCode �����õ�����acccode��ֵ
     */
    public void setAccCode(String accCode){
        this.accCode = StringUtils.rightTrim(accCode);
    }

    /**
     * ��ȡ����acccode
     * @return ����acccode��ֵ
     */
    public String getAccCode(){
        return accCode;
    }

    /**
     * �������Ժ��㵥λ��־
     * @param centerFlag �����õ����Ժ��㵥λ��־��ֵ
     */
    public void setCenterFlag(String centerFlag){
        this.centerFlag = StringUtils.rightTrim(centerFlag);
    }

    /**
     * ��ȡ���Ժ��㵥λ��־
     * @return ���Ժ��㵥λ��־��ֵ
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
