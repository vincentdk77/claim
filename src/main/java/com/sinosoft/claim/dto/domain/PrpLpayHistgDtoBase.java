package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * �����ﾯ�棺���ļ��������ֹ��޸ģ�������ʹ��JToolpad���ɣ�<br>
 * ����prpLpayHis�����ݴ���������<br>
 * ������ JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayHistgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** ����claimNo */
    private String claimNo = "";
    /** ����serialNo */
    private String serialNo = "";
    /** ����compensateNo */
    private String compensateNo = "";
    /** ����classCode */
    private String classCode = "";
    /** ����riskCode */
    private String riskCode = "";
    /** ����registNo */
    private String registNo = "";
    /** ����policyNo */
    private String policyNo = "";
    /** ����payType */
    private String payType = "";
    /** ����receiverType */
    private String receiverType = "";
    /** ����payAmount */
    private double payAmount = 0D;
    /** ����bankType */
    private String bankType = "";
    /** ����bank */
    private String bank = "";
    /** ����bankSite */
    private String bankSite = "";
    /** ����accountType */
    private String accountType = "";
    /** ����receiverFullName */
    private String receiverFullName = "";
    /** ����certifType */
    private String certifType = "";
    /** ����address */
    private String address = "";
    /** ����certifNo */
    private String certifNo = "";
    /** ����familyPhone */
    private String familyPhone = "";
    /** ����officePhone */
    private String officePhone = "";
    /** ����mobilePhone */
    private String mobilePhone = "";
    /** ����payreMark */
    private String payreMark = "";
    /** ����operatorCode */
    private String operatorCode = "";
    /** ����inputDate */
    private DateTime inputDate = new DateTime();
    /** ����payDate */
    private DateTime payDate = new DateTime();
    /** ����payCode */
    private String payCode = "";
    /** ����payFlag */
    private String payFlag = "";
    /** ����paymentTye */
    private String paymentType = "";
    /** ����bankAccount */
    private String bankAccount = "";
    /** ����node */
    private String node = "";
    /** ����uploadSerialno */
    private String uploadSerialno = "";
    /** ����vflag */
    private String vflag = "";
    /** ����comCode */
    private String comCode = "";
    /** ����serialNo2 */
    private String serialNo2 = "";
    /** ����provinceCode */
    private String provinceCode = "";
    /** ����cityCode */
    private String cityCode = "";
    /** ����urgentType */
    private String urgentType = "";
    /** ����qqNumber */
    private String qqNumber = "";
    /** ����email */
    private String email = "";
    /** ����unitLink */
    private String unitLink = "";
    /** ����postCode */
    private String postCode = "";
    /** ����operatorComCode */
    private String operatorComCode = "";
    /** ����editDate */
    private DateTime editDate = new DateTime();
    private String receivertypeothername = "";
    /** ����֧����ʽ*/
    private String payWay = "";
    /** ���Դ�ͳ֧��ԭ��*/
    private String payReason = "";
    /** ������;˵��*/
    private String payPurpose = "";
    /** �����˺�����*/
    private String accountFlag = "";
    /** ���Խӿ����� 1�󲡼�ʱ����*/
    private String interType = "";
    /** ����֧���к�*/
    private String routeNum = "";
    /** ���Ե�����֧������*/
    private String thirdPayType = "";
    /** ������������*/
    private String coinsCode = "";

    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrpLpayHistgDtoBase����
     */
    public PrpLpayHistgDtoBase(){
    }

    /**
     * ��������claimNo
     * @param claimNo �����õ�����claimNo��ֵ
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * ��ȡ����claimNo
     * @return ����claimNo��ֵ
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * ��������serialNo
     * @param serialNo �����õ�����serialNo��ֵ
     */
    public void setSerialNo(String serialNo){
        this.serialNo = StringUtils.rightTrim(serialNo);
    }

    /**
     * ��ȡ����serialNo
     * @return ����serialNo��ֵ
     */
    public String getSerialNo(){
        return serialNo;
    }

    /**
     * ��������compensateNo
     * @param compensateNo �����õ�����compensateNo��ֵ
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * ��ȡ����compensateNo
     * @return ����compensateNo��ֵ
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * ��������classCode
     * @param classCode �����õ�����classCode��ֵ
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * ��ȡ����classCode
     * @return ����classCode��ֵ
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * ��������riskCode
     * @param riskCode �����õ�����riskCode��ֵ
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * ��ȡ����riskCode
     * @return ����riskCode��ֵ
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * ��������registNo
     * @param registNo �����õ�����registNo��ֵ
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * ��ȡ����registNo
     * @return ����registNo��ֵ
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * ��������policyNo
     * @param policyNo �����õ�����policyNo��ֵ
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * ��ȡ����policyNo
     * @return ����policyNo��ֵ
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * ��������payType
     * @param payType �����õ�����payType��ֵ
     */
    public void setPayType(String payType){
        this.payType = StringUtils.rightTrim(payType);
    }

    /**
     * ��ȡ����payType
     * @return ����payType��ֵ
     */
    public String getPayType(){
        return payType;
    }

    /**
     * ��������receiverType
     * @param receiverType �����õ�����receiverType��ֵ
     */
    public void setReceiverType(String receiverType){
        this.receiverType = StringUtils.rightTrim(receiverType);
    }

    /**
     * ��ȡ����receiverType
     * @return ����receiverType��ֵ
     */
    public String getReceiverType(){
        return receiverType;
    }

    /**
     * ��������payAmount
     * @param payAmount �����õ�����payAmount��ֵ
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * ��ȡ����payAmount
     * @return ����payAmount��ֵ
     */
    public double getPayAmount(){
        return payAmount;
    }

    /**
     * ��������bankType
     * @param bankType �����õ�����bankType��ֵ
     */
    public void setBankType(String bankType){
        this.bankType = StringUtils.rightTrim(bankType);
    }

    /**
     * ��ȡ����bankType
     * @return ����bankType��ֵ
     */
    public String getBankType(){
        return bankType;
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
     * ��������bankSite
     * @param bankSite �����õ�����bankSite��ֵ
     */
    public void setBankSite(String bankSite){
        this.bankSite = StringUtils.rightTrim(bankSite);
    }

    /**
     * ��ȡ����bankSite
     * @return ����bankSite��ֵ
     */
    public String getBankSite(){
        return bankSite;
    }

    /**
     * ��������accountType
     * @param accountType �����õ�����accountType��ֵ
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * ��ȡ����accountType
     * @return ����accountType��ֵ
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * ��������receiverFullName
     * @param receiverFullName �����õ�����receiverFullName��ֵ
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * ��ȡ����receiverFullName
     * @return ����receiverFullName��ֵ
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * ��������certifType
     * @param certifType �����õ�����certifType��ֵ
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * ��ȡ����certifType
     * @return ����certifType��ֵ
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * ��������address
     * @param address �����õ�����address��ֵ
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * ��ȡ����address
     * @return ����address��ֵ
     */
    public String getAddress(){
        return address;
    }

    /**
     * ��������certifNo
     * @param certifNo �����õ�����certifNo��ֵ
     */
    public void setCertifNo(String certifNo){
        this.certifNo = StringUtils.rightTrim(certifNo);
    }

    /**
     * ��ȡ����certifNo
     * @return ����certifNo��ֵ
     */
    public String getCertifNo(){
        return certifNo;
    }

    /**
     * ��������familyPhone
     * @param familyPhone �����õ�����familyPhone��ֵ
     */
    public void setFamilyPhone(String familyPhone){
        this.familyPhone = StringUtils.rightTrim(familyPhone);
    }

    /**
     * ��ȡ����familyPhone
     * @return ����familyPhone��ֵ
     */
    public String getFamilyPhone(){
        return familyPhone;
    }

    /**
     * ��������officePhone
     * @param officePhone �����õ�����officePhone��ֵ
     */
    public void setOfficePhone(String officePhone){
        this.officePhone = StringUtils.rightTrim(officePhone);
    }

    /**
     * ��ȡ����officePhone
     * @return ����officePhone��ֵ
     */
    public String getOfficePhone(){
        return officePhone;
    }

    /**
     * ��������mobilePhone
     * @param mobilePhone �����õ�����mobilePhone��ֵ
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * ��ȡ����mobilePhone
     * @return ����mobilePhone��ֵ
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * ��������payreMark
     * @param payreMark �����õ�����payreMark��ֵ
     */
    public void setPayreMark(String payreMark){
        this.payreMark = StringUtils.rightTrim(payreMark);
    }

    /**
     * ��ȡ����payreMark
     * @return ����payreMark��ֵ
     */
    public String getPayreMark(){
        return payreMark;
    }

    /**
     * ��������operatorCode
     * @param operatorCode �����õ�����operatorCode��ֵ
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * ��ȡ����operatorCode
     * @return ����operatorCode��ֵ
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * ��������inputDate
     * @param inputDate �����õ�����inputDate��ֵ
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * ��ȡ����inputDate
     * @return ����inputDate��ֵ
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * ��������payDate
     * @param payDate �����õ�����payDate��ֵ
     */
    public void setPayDate(DateTime payDate){
        this.payDate = payDate;
    }

    /**
     * ��ȡ����payDate
     * @return ����payDate��ֵ
     */
    public DateTime getPayDate(){
        return payDate;
    }

    /**
     * ��������payCode
     * @param payCode �����õ�����payCode��ֵ
     */
    public void setPayCode(String payCode){
        this.payCode = StringUtils.rightTrim(payCode);
    }

    /**
     * ��ȡ����payCode
     * @return ����payCode��ֵ
     */
    public String getPayCode(){
        return payCode;
    }

    /**
     * ��������payFlag
     * @param payFlag �����õ�����payFlag��ֵ
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * ��ȡ����payFlag
     * @return ����payFlag��ֵ
     */
    public String getPayFlag(){
        return payFlag;
    }

    /**
     * ��������paymentTye
     * @param paymentTye �����õ�����paymentTye��ֵ
     */
    public void setPaymentType(String paymentType){
        this.paymentType = StringUtils.rightTrim(paymentType);
    }

    /**
     * ��ȡ����paymentTye
     * @return ����paymentTye��ֵ
     */
    public String getPaymentType(){
        return paymentType;
    }

    /**
     * ��������bankAccount
     * @param bankAccount �����õ�����bankAccount��ֵ
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * ��ȡ����bankAccount
     * @return ����bankAccount��ֵ
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * ��������node
     * @param node �����õ�����node��ֵ
     */
    public void setNode(String node){
        this.node = StringUtils.rightTrim(node);
    }

    /**
     * ��ȡ����node
     * @return ����node��ֵ
     */
    public String getNode(){
        return node;
    }

    /**
     * ��������uploadSerialno
     * @param uploadSerialno �����õ�����uploadSerialno��ֵ
     */
    public void setUploadSerialno(String uploadSerialno){
        this.uploadSerialno = StringUtils.rightTrim(uploadSerialno);
    }

    /**
     * ��ȡ����uploadSerialno
     * @return ����uploadSerialno��ֵ
     */
    public String getUploadSerialno(){
        return uploadSerialno;
    }

    /**
     * ��������vflag
     * @param vflag �����õ�����vflag��ֵ
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * ��ȡ����vflag
     * @return ����vflag��ֵ
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * ��������comCode
     * @param comCode �����õ�����comCode��ֵ
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * ��ȡ����comCode
     * @return ����comCode��ֵ
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * ��������serialNo2
     * @param serialNo2 �����õ�����serialNo2��ֵ
     */
    public void setSerialNo2(String serialNo2){
        this.serialNo2 = StringUtils.rightTrim(serialNo2);
    }

    /**
     * ��ȡ����serialNo2
     * @return ����serialNo2��ֵ
     */
    public String getSerialNo2(){
        return serialNo2;
    }

    /**
     * ��������provinceCode
     * @param provinceCode �����õ�����provinceCode��ֵ
     */
    public void setProvinceCode(String provinceCode){
        this.provinceCode = StringUtils.rightTrim(provinceCode);
    }

    /**
     * ��ȡ����provinceCode
     * @return ����provinceCode��ֵ
     */
    public String getProvinceCode(){
        return provinceCode;
    }

    /**
     * ��������cityCode
     * @param cityCode �����õ�����cityCode��ֵ
     */
    public void setCityCode(String cityCode){
        this.cityCode = StringUtils.rightTrim(cityCode);
    }

    /**
     * ��ȡ����cityCode
     * @return ����cityCode��ֵ
     */
    public String getCityCode(){
        return cityCode;
    }

    /**
     * ��������urgentType
     * @param urgentType �����õ�����urgentType��ֵ
     */
    public void setUrgentType(String urgentType){
        this.urgentType = StringUtils.rightTrim(urgentType);
    }

    /**
     * ��ȡ����urgentType
     * @return ����urgentType��ֵ
     */
    public String getUrgentType(){
        return urgentType;
    }

    /**
     * ��������qqNumber
     * @param qqNumber �����õ�����qqNumber��ֵ
     */
    public void setQqNumber(String qqNumber){
        this.qqNumber = StringUtils.rightTrim(qqNumber);
    }

    /**
     * ��ȡ����qqNumber
     * @return ����qqNumber��ֵ
     */
    public String getQqNumber(){
        return qqNumber;
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
     * ��������unitLink
     * @param unitLink �����õ�����unitLink��ֵ
     */
    public void setUnitLink(String unitLink){
        this.unitLink = StringUtils.rightTrim(unitLink);
    }

    /**
     * ��ȡ����unitLink
     * @return ����unitLink��ֵ
     */
    public String getUnitLink(){
        return unitLink;
    }

    /**
     * ��������postCode
     * @param postCode �����õ�����postCode��ֵ
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * ��ȡ����postCode
     * @return ����postCode��ֵ
     */
    public String getPostCode(){
        return postCode;
    }

	public String getOperatorComCode() {
		return operatorComCode;
	}

	public void setOperatorComCode(String operatorComCode) {
		this.operatorComCode = operatorComCode;
	}

	public DateTime getEditDate() {
		return editDate;
	}

	public void setEditDate(DateTime editDate) {
		this.editDate = editDate;
	}

	public String getReceivertypeothername() {
		return receivertypeothername;
	}

	public void setReceivertypeothername(String receivertypeothername) {
		this.receivertypeothername = receivertypeothername;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getPayReason() {
		return payReason;
	}

	public void setPayReason(String payReason) {
		this.payReason = payReason;
	}

	public String getPayPurpose() {
		return payPurpose;
	}

	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
	}

	public String getAccountFlag() {
		return accountFlag;
	}

	public void setAccountFlag(String accountFlag) {
		this.accountFlag = accountFlag;
	}

	public String getInterType() {
		return interType;
	}

	public void setInterType(String interType) {
		this.interType = interType;
	}

	public String getRouteNum() {
		return routeNum;
	}

	public void setRouteNum(String routeNum) {
		this.routeNum = routeNum;
	}

	public String getThirdPayType() {
		return thirdPayType;
	}

	public void setThirdPayType(String thirdPayType) {
		this.thirdPayType = thirdPayType;
	}

	public String getCoinsCode() {
		return coinsCode;
	}

	public void setCoinsCode(String coinsCode) {
		this.coinsCode = coinsCode;
	}
	
}
