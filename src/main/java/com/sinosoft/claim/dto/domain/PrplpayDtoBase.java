package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����PRPLPAY�����ݴ���������<br>
 */
public class PrplpayDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����CLAIMNO */
    private String claimno = "";
    /** ����SERIALNO */
    private String serialno = "";
    /** ����COMPENSATENO */
    private String compensateno = "";
    /** ����CLASSCODE */
    private String classcode = "";
    /** ����RISKCODE */
    private String riskcode = "";
    /** ����REGISTNO */
    private String registno = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����PAYTYPE */
    private String paytype = "";
    /** ����RECEIVERTYPE */
    private String receivertype = "";
    /** ����PAYAMOUNT */
    private double payamount = 0D;
    /** ����BANKTYPE */
    private String banktype = "";
    /** ����BANK */
    private String bank = "";
    /** ����BANKSITE */
    private String banksite = "";
    /** ����ACCOUNTTYPE */
    private String accounttype = "";
    /** ����RECEIVERFULLNAME */
    private String receiverfullname = "";
    /** ����CERTIFTYPE */
    private String certiftype = "";
    /** ����ADDRESS */
    private String address = "";
    /** ����CERTIFNO */
    private String certifno = "";
    /** ����FAMILYPHONE */
    private String familyphone = "";
    /** ����OFFICEPHONE */
    private String officephone = "";
    /** ����MOBILEPHONE */
    private String mobilephone = "";
    /** ����PAYREMARK */
    private String payremark = "";
    /** ����OPERATORCODE */
    private String operatorcode = "";
    /** ����INPUTDATE */
    private DateTime inputdate = new DateTime();
    /** ����PAYDATE */
    private DateTime paydate = new DateTime();
    /** ����PAYCODE */
    private String paycode = "";
    /** ����PAYFLAG */
    private String payflag = "";
    /**�������*/
    private String paymenttype="";
    /**�����˺�*/
    private String bankaccount="";
    /**���̻���*/
    private String node="";
    /** ����SERIALNO2 */
    private String serialNo2 = "";
    /** ������������*/
    private String coinsCode = "";
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplpayDtoBase����
     */
    public PrplpayDtoBase(){
    }

    /**
     * ��������CLAIMNO
     * @param claimno �����õ�����CLAIMNO��ֵ
     */
    public void setClaimno(String claimno){
        this.claimno = StringUtils.rightTrim(claimno);
    }

    /**
     * ��ȡ����CLAIMNO
     * @return ����CLAIMNO��ֵ
     */
    public String getClaimno(){
        return claimno;
    }

    /**
     * ��������SERIALNO
     * @param serialno �����õ�����SERIALNO��ֵ
     */
    public void setSerialno(String serialno){
        this.serialno = StringUtils.rightTrim(serialno);
    }

    /**
     * ��ȡ����SERIALNO
     * @return ����SERIALNO��ֵ
     */
    public String getSerialno(){
        return serialno;
    }

    /**
     * ��������COMPENSATENO
     * @param compensateno �����õ�����COMPENSATENO��ֵ
     */
    public void setCompensateno(String compensateno){
        this.compensateno = StringUtils.rightTrim(compensateno);
    }

    /**
     * ��ȡ����COMPENSATENO
     * @return ����COMPENSATENO��ֵ
     */
    public String getCompensateno(){
        return compensateno;
    }

    /**
     * ��������CLASSCODE
     * @param classcode �����õ�����CLASSCODE��ֵ
     */
    public void setClasscode(String classcode){
        this.classcode = StringUtils.rightTrim(classcode);
    }

    /**
     * ��ȡ����CLASSCODE
     * @return ����CLASSCODE��ֵ
     */
    public String getClasscode(){
        return classcode;
    }

    /**
     * ��������RISKCODE
     * @param riskcode �����õ�����RISKCODE��ֵ
     */
    public void setRiskcode(String riskcode){
        this.riskcode = StringUtils.rightTrim(riskcode);
    }

    /**
     * ��ȡ����RISKCODE
     * @return ����RISKCODE��ֵ
     */
    public String getRiskcode(){
        return riskcode;
    }

    /**
     * ��������REGISTNO
     * @param registno �����õ�����REGISTNO��ֵ
     */
    public void setRegistno(String registno){
        this.registno = StringUtils.rightTrim(registno);
    }

    /**
     * ��ȡ����REGISTNO
     * @return ����REGISTNO��ֵ
     */
    public String getRegistno(){
        return registno;
    }

    /**
     * ��������POLICYNO
     * @param policyno �����õ�����POLICYNO��ֵ
     */
    public void setPolicyno(String policyno){
        this.policyno = StringUtils.rightTrim(policyno);
    }

    /**
     * ��ȡ����POLICYNO
     * @return ����POLICYNO��ֵ
     */
    public String getPolicyno(){
        return policyno;
    }

    /**
     * ��������PAYTYPE
     * @param paytype �����õ�����PAYTYPE��ֵ
     */
    public void setPaytype(String paytype){
        this.paytype = StringUtils.rightTrim(paytype);
    }

    /**
     * ��ȡ����PAYTYPE
     * @return ����PAYTYPE��ֵ
     */
    public String getPaytype(){
        return paytype;
    }

    /**
     * ��������RECEIVERTYPE
     * @param receivertype �����õ�����RECEIVERTYPE��ֵ
     */
    public void setReceivertype(String receivertype){
        this.receivertype = StringUtils.rightTrim(receivertype);
    }

    /**
     * ��ȡ����RECEIVERTYPE
     * @return ����RECEIVERTYPE��ֵ
     */
    public String getReceivertype(){
        return receivertype;
    }

    /**
     * ��������PAYAMOUNT
     * @param payamount �����õ�����PAYAMOUNT��ֵ
     */
    public void setPayamount(double payamount){
        this.payamount = payamount;
    }
    public void setPayamount(String payamount){
        this.payamount = Double.parseDouble(payamount==null||payamount.equals("")||payamount.equals("null")?"0":payamount);
    }

    /**
     * ��ȡ����PAYAMOUNT
     * @return ����PAYAMOUNT��ֵ
     */
    public double getPayamount(){
        return payamount;
    }

    /**
     * ��������BANKTYPE
     * @param banktype �����õ�����BANKTYPE��ֵ
     */
    public void setBanktype(String banktype){
        this.banktype = StringUtils.rightTrim(banktype);
    }

    /**
     * ��ȡ����BANKTYPE
     * @return ����BANKTYPE��ֵ
     */
    public String getBanktype(){
        return banktype;
    }

    /**
     * ��������BANK
     * @param bank �����õ�����BANK��ֵ
     */
    public void setBank(String bank){
        this.bank = StringUtils.rightTrim(bank);
    }

    /**
     * ��ȡ����BANK
     * @return ����BANK��ֵ
     */
    public String getBank(){
        return bank;
    }

    /**
     * ��������BANKSITE
     * @param banksite �����õ�����BANKSITE��ֵ
     */
    public void setBanksite(String banksite){
        this.banksite = StringUtils.rightTrim(banksite);
    }

    /**
     * ��ȡ����BANKSITE
     * @return ����BANKSITE��ֵ
     */
    public String getBanksite(){
        return banksite;
    }

    /**
     * ��������ACCOUNTTYPE
     * @param accounttype �����õ�����ACCOUNTTYPE��ֵ
     */
    public void setAccounttype(String accounttype){
        this.accounttype = StringUtils.rightTrim(accounttype);
    }

    /**
     * ��ȡ����ACCOUNTTYPE
     * @return ����ACCOUNTTYPE��ֵ
     */
    public String getAccounttype(){
        return accounttype;
    }

    /**
     * ��������RECEIVERFULLNAME
     * @param receiverfullname �����õ�����RECEIVERFULLNAME��ֵ
     */
    public void setReceiverfullname(String receiverfullname){
        this.receiverfullname = StringUtils.rightTrim(receiverfullname);
    }

    /**
     * ��ȡ����RECEIVERFULLNAME
     * @return ����RECEIVERFULLNAME��ֵ
     */
    public String getReceiverfullname(){
        return receiverfullname;
    }

    /**
     * ��������CERTIFTYPE
     * @param certiftype �����õ�����CERTIFTYPE��ֵ
     */
    public void setCertiftype(String certiftype){
        this.certiftype = StringUtils.rightTrim(certiftype);
    }

    /**
     * ��ȡ����CERTIFTYPE
     * @return ����CERTIFTYPE��ֵ
     */
    public String getCertiftype(){
        return certiftype;
    }

    /**
     * ��������ADDRESS
     * @param address �����õ�����ADDRESS��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����ADDRESS
     * @return ����ADDRESS��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������CERTIFNO
     * @param certifno �����õ�����CERTIFNO��ֵ
     */
    public void setCertifno(String certifno){
        this.certifno = StringUtils.rightTrim(certifno);
    }

    /**
     * ��ȡ����CERTIFNO
     * @return ����CERTIFNO��ֵ
     */
    public String getCertifno(){
        return certifno;
    }

    /**
     * ��������FAMILYPHONE
     * @param familyphone �����õ�����FAMILYPHONE��ֵ
     */
    public void setFamilyphone(String familyphone){
        this.familyphone = StringUtils.rightTrim(familyphone);
    }

    /**
     * ��ȡ����FAMILYPHONE
     * @return ����FAMILYPHONE��ֵ
     */
    public String getFamilyphone(){
        return familyphone;
    }

    /**
     * ��������OFFICEPHONE
     * @param officephone �����õ�����OFFICEPHONE��ֵ
     */
    public void setOfficephone(String officephone){
        this.officephone = StringUtils.rightTrim(officephone);
    }

    /**
     * ��ȡ����OFFICEPHONE
     * @return ����OFFICEPHONE��ֵ
     */
    public String getOfficephone(){
        return officephone;
    }

    /**
     * ��������MOBILEPHONE
     * @param mobilephone �����õ�����MOBILEPHONE��ֵ
     */
    public void setMobilephone(String mobilephone){
        this.mobilephone = StringUtils.rightTrim(mobilephone);
    }

    /**
     * ��ȡ����MOBILEPHONE
     * @return ����MOBILEPHONE��ֵ
     */
    public String getMobilephone(){
        return mobilephone;
    }

    /**
     * ��������PAYREMARK
     * @param payremark �����õ�����PAYREMARK��ֵ
     */
    public void setPayremark(String payremark){
        this.payremark = StringUtils.rightTrim(payremark);
    }

    /**
     * ��ȡ����PAYREMARK
     * @return ����PAYREMARK��ֵ
     */
    public String getPayremark(){
        return payremark;
    }

    /**
     * ��������OPERATORCODE
     * @param operatorcode �����õ�����OPERATORCODE��ֵ
     */
    public void setOperatorcode(String operatorcode){
        this.operatorcode = StringUtils.rightTrim(operatorcode);
    }

    /**
     * ��ȡ����OPERATORCODE
     * @return ����OPERATORCODE��ֵ
     */
    public String getOperatorcode(){
        return operatorcode;
    }

    /**
     * ��������INPUTDATE
     * @param inputdate �����õ�����INPUTDATE��ֵ
     */
    public void setInputdate(DateTime inputdate){
        this.inputdate = inputdate;
    }

    /**
     * ��ȡ����INPUTDATE
     * @return ����INPUTDATE��ֵ
     */
    public DateTime getInputdate(){
        return inputdate;
    }

    /**
     * ��������PAYDATE
     * @param paydate �����õ�����PAYDATE��ֵ
     */
    public void setPaydate(DateTime paydate){
        this.paydate = paydate;
    }

    /**
     * ��ȡ����PAYDATE
     * @return ����PAYDATE��ֵ
     */
    public DateTime getPaydate(){
        return paydate;
    }

    /**
     * ��������PAYCODE
     * @param paycode �����õ�����PAYCODE��ֵ
     */
    public void setPaycode(String paycode){
        this.paycode = StringUtils.rightTrim(paycode);
    }

    /**
     * ��ȡ����PAYCODE
     * @return ����PAYCODE��ֵ
     */
    public String getPaycode(){
        return paycode;
    }

    /**
     * ��������PAYFLAG
     * @param payflag �����õ�����PAYFLAG��ֵ
     */
    public void setPayflag(String payflag){
        this.payflag = StringUtils.rightTrim(payflag);
    }

    /**
     * ��ȡ����PAYFLAG
     * @return ����PAYFLAG��ֵ
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
