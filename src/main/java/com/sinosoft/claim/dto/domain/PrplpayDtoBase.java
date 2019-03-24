package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是PRPLPAY的数据传输对象基类<br>
 */
public class PrplpayDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性CLAIMNO */
    private String claimno = "";
    /** 属性SERIALNO */
    private String serialno = "";
    /** 属性COMPENSATENO */
    private String compensateno = "";
    /** 属性CLASSCODE */
    private String classcode = "";
    /** 属性RISKCODE */
    private String riskcode = "";
    /** 属性REGISTNO */
    private String registno = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性PAYTYPE */
    private String paytype = "";
    /** 属性RECEIVERTYPE */
    private String receivertype = "";
    /** 属性PAYAMOUNT */
    private double payamount = 0D;
    /** 属性BANKTYPE */
    private String banktype = "";
    /** 属性BANK */
    private String bank = "";
    /** 属性BANKSITE */
    private String banksite = "";
    /** 属性ACCOUNTTYPE */
    private String accounttype = "";
    /** 属性RECEIVERFULLNAME */
    private String receiverfullname = "";
    /** 属性CERTIFTYPE */
    private String certiftype = "";
    /** 属性ADDRESS */
    private String address = "";
    /** 属性CERTIFNO */
    private String certifno = "";
    /** 属性FAMILYPHONE */
    private String familyphone = "";
    /** 属性OFFICEPHONE */
    private String officephone = "";
    /** 属性MOBILEPHONE */
    private String mobilephone = "";
    /** 属性PAYREMARK */
    private String payremark = "";
    /** 属性OPERATORCODE */
    private String operatorcode = "";
    /** 属性INPUTDATE */
    private DateTime inputdate = new DateTime();
    /** 属性PAYDATE */
    private DateTime paydate = new DateTime();
    /** 属性PAYCODE */
    private String paycode = "";
    /** 属性PAYFLAG */
    private String payflag = "";
    /**赔款类型*/
    private String paymenttype="";
    /**银行账号*/
    private String bankaccount="";
    /**流程环节*/
    private String node="";
    /** 属性SERIALNO2 */
    private String serialNo2 = "";
    /** 属性联共保人*/
    private String coinsCode = "";
    /**
     *  默认构造方法,构造一个默认的PrplpayDtoBase对象
     */
    public PrplpayDtoBase(){
    }

    /**
     * 设置属性CLAIMNO
     * @param claimno 待设置的属性CLAIMNO的值
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * 获取属性CLAIMNO
     * @return 属性CLAIMNO的值
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * 设置属性SERIALNO
     * @param serialno 待设置的属性SERIALNO的值
     */
    public void setSerialno(String serialno){
        this.serialno = StringUtils.rightTrim(serialno);
    }

    /**
     * 获取属性SERIALNO
     * @return 属性SERIALNO的值
     */
    public String getSerialno(){
        return serialno;
    }

    /**
     * 设置属性COMPENSATENO
     * @param compensateno 待设置的属性COMPENSATENO的值
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * 获取属性COMPENSATENO
     * @return 属性COMPENSATENO的值
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * 设置属性CLASSCODE
     * @param classcode 待设置的属性CLASSCODE的值
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * 获取属性CLASSCODE
     * @return 属性CLASSCODE的值
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * 设置属性RISKCODE
     * @param riskcode 待设置的属性RISKCODE的值
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * 获取属性RISKCODE
     * @return 属性RISKCODE的值
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * 设置属性REGISTNO
     * @param registno 待设置的属性REGISTNO的值
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * 获取属性REGISTNO
     * @return 属性REGISTNO的值
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * 设置属性POLICYNO
     * @param policyno 待设置的属性POLICYNO的值
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * 获取属性POLICYNO
     * @return 属性POLICYNO的值
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * 设置属性PAYTYPE
     * @param paytype 待设置的属性PAYTYPE的值
     */
    public void setPaytype(String paytype){
        this.paytype = StringUtils.rightTrim(paytype);
    }

    /**
     * 获取属性PAYTYPE
     * @return 属性PAYTYPE的值
     */
    public String getPaytype(){
        return paytype;
    }

    /**
     * 设置属性RECEIVERTYPE
     * @param receivertype 待设置的属性RECEIVERTYPE的值
     */
    public void setReceivertype(String receivertype){
        this.receivertype = StringUtils.rightTrim(receivertype);
    }

    /**
     * 获取属性RECEIVERTYPE
     * @return 属性RECEIVERTYPE的值
     */
    public String getReceivertype(){
        return receivertype;
    }

    /**
     * 设置属性PAYAMOUNT
     * @param payamount 待设置的属性PAYAMOUNT的值
     */
    public void setPayamount(double payamount){
        this.payamount = payamount;
    }
    public void setPayamount(String payamount){
        this.payamount = Double.parseDouble(payamount==null||payamount.equals("")||payamount.equals("null")?"0":payamount);
    }

    /**
     * 获取属性PAYAMOUNT
     * @return 属性PAYAMOUNT的值
     */
    public double getPayamount(){
        return payamount;
    }

    /**
     * 设置属性BANKTYPE
     * @param banktype 待设置的属性BANKTYPE的值
     */
    public void setBanktype(String banktype){
        this.banktype = StringUtils.rightTrim(banktype);
    }

    /**
     * 获取属性BANKTYPE
     * @return 属性BANKTYPE的值
     */
    public String getBanktype(){
        return banktype;
    }

    /**
     * 设置属性BANK
     * @param bank 待设置的属性BANK的值
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * 获取属性BANK
     * @return 属性BANK的值
     */
    public String getBank(){
        return bank;
    }

    /**
     * 设置属性BANKSITE
     * @param banksite 待设置的属性BANKSITE的值
     */
    public void setBanksite(String banksite){
        this.banksite = StringUtils.rightTrim(banksite);
    }

    /**
     * 获取属性BANKSITE
     * @return 属性BANKSITE的值
     */
    public String getBanksite(){
        return banksite;
    }

    /**
     * 设置属性ACCOUNTTYPE
     * @param accounttype 待设置的属性ACCOUNTTYPE的值
     */
    public void setAccounttype(String accounttype){
        this.accounttype = StringUtils.rightTrim(accounttype);
    }

    /**
     * 获取属性ACCOUNTTYPE
     * @return 属性ACCOUNTTYPE的值
     */
    public String getAccounttype(){
        return accounttype;
    }

    /**
     * 设置属性RECEIVERFULLNAME
     * @param receiverfullname 待设置的属性RECEIVERFULLNAME的值
     */
    public void setReceiverfullname(String receiverfullname){
        this.receiverfullname = StringUtils.rightTrim(receiverfullname);
    }

    /**
     * 获取属性RECEIVERFULLNAME
     * @return 属性RECEIVERFULLNAME的值
     */
    public String getReceiverfullname(){
        return receiverfullname;
    }

    /**
     * 设置属性CERTIFTYPE
     * @param certiftype 待设置的属性CERTIFTYPE的值
     */
    public void setCertiftype(String certiftype){
        this.certiftype = StringUtils.rightTrim(certiftype);
    }

    /**
     * 获取属性CERTIFTYPE
     * @return 属性CERTIFTYPE的值
     */
    public String getCertiftype(){
        return certiftype;
    }

    /**
     * 设置属性ADDRESS
     * @param address 待设置的属性ADDRESS的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性ADDRESS
     * @return 属性ADDRESS的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性CERTIFNO
     * @param certifno 待设置的属性CERTIFNO的值
     */
    public void setCertifno(String certifno){
        this.certifno = StringUtils.rightTrim(certifno);
    }

    /**
     * 获取属性CERTIFNO
     * @return 属性CERTIFNO的值
     */
    public String getCertifno(){
        return certifno;
    }

    /**
     * 设置属性FAMILYPHONE
     * @param familyphone 待设置的属性FAMILYPHONE的值
     */
    public void setFamilyphone(String familyphone){
        this.familyphone = StringUtils.rightTrim(familyphone);
    }

    /**
     * 获取属性FAMILYPHONE
     * @return 属性FAMILYPHONE的值
     */
    public String getFamilyphone(){
        return familyphone;
    }

    /**
     * 设置属性OFFICEPHONE
     * @param officephone 待设置的属性OFFICEPHONE的值
     */
    public void setOfficephone(String officephone){
        this.officephone = StringUtils.rightTrim(officephone);
    }

    /**
     * 获取属性OFFICEPHONE
     * @return 属性OFFICEPHONE的值
     */
    public String getOfficephone(){
        return officephone;
    }

    /**
     * 设置属性MOBILEPHONE
     * @param mobilephone 待设置的属性MOBILEPHONE的值
     */
    public void setMobilephone(String mobilephone){
        this.mobilephone = StringUtils.rightTrim(mobilephone);
    }

    /**
     * 获取属性MOBILEPHONE
     * @return 属性MOBILEPHONE的值
     */
    public String getMobilephone(){
        return mobilephone;
    }

    /**
     * 设置属性PAYREMARK
     * @param payremark 待设置的属性PAYREMARK的值
     */
    public void setPayremark(String payremark){
        this.payremark = StringUtils.rightTrim(payremark);
    }

    /**
     * 获取属性PAYREMARK
     * @return 属性PAYREMARK的值
     */
    public String getPayremark(){
        return payremark;
    }

    /**
     * 设置属性OPERATORCODE
     * @param operatorcode 待设置的属性OPERATORCODE的值
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * 获取属性OPERATORCODE
     * @return 属性OPERATORCODE的值
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * 设置属性INPUTDATE
     * @param inputdate 待设置的属性INPUTDATE的值
     */
    public void setInputdate(DateTime inputdate){
        this.inputdate = inputdate;
    }

    /**
     * 获取属性INPUTDATE
     * @return 属性INPUTDATE的值
     */
    public DateTime getInputdate(){
        return inputdate;
    }

    /**
     * 设置属性PAYDATE
     * @param paydate 待设置的属性PAYDATE的值
     */
    public void setPaydate(DateTime paydate){
        this.paydate = paydate;
    }

    /**
     * 获取属性PAYDATE
     * @return 属性PAYDATE的值
     */
    public DateTime getPaydate(){
        return paydate;
    }

    /**
     * 设置属性PAYCODE
     * @param paycode 待设置的属性PAYCODE的值
     */
    public void setPaycode(String paycode){
        this.paycode = StringUtils.rightTrim(paycode);
    }

    /**
     * 获取属性PAYCODE
     * @return 属性PAYCODE的值
     */
    public String getPaycode(){
        return paycode;
    }

    /**
     * 设置属性PAYFLAG
     * @param payflag 待设置的属性PAYFLAG的值
     */
    public void setPayflag(String payflag){
        this.payflag = StringUtils.rightTrim(payflag);
    }

    /**
     * 获取属性PAYFLAG
     * @return 属性PAYFLAG的值
     */
    public String getPayflag(){
        return payflag;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

	public String getSerialNo2() {
		return serialNo2;
	}

	public void setSerialNo2(String serialNo2) {
		this.serialNo2 = serialNo2;
	}

	public String getCoinsCode() {
		return coinsCode;
	}

	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}

}
