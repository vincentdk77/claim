package com.sinosoft.claim.dto.domain;

import java.io.Serializable;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

/**
 * ★★★★★警告：本文件不允许手工修改！！！请使用JToolpad生成！<br>
 * 这是prpLpayHis的数据传输对象基类<br>
 * 创建于 JToolpad(1.5.1) Vendor:zhouxianli1978@msn.com
 */
public class PrpLpayHistgDtoBase implements Serializable{

    private static final long serialVersionUID = 1L;
    /** 属性claimNo */
    private String claimNo = "";
    /** 属性serialNo */
    private String serialNo = "";
    /** 属性compensateNo */
    private String compensateNo = "";
    /** 属性classCode */
    private String classCode = "";
    /** 属性riskCode */
    private String riskCode = "";
    /** 属性registNo */
    private String registNo = "";
    /** 属性policyNo */
    private String policyNo = "";
    /** 属性payType */
    private String payType = "";
    /** 属性receiverType */
    private String receiverType = "";
    /** 属性payAmount */
    private double payAmount = 0D;
    /** 属性bankType */
    private String bankType = "";
    /** 属性bank */
    private String bank = "";
    /** 属性bankSite */
    private String bankSite = "";
    /** 属性accountType */
    private String accountType = "";
    /** 属性receiverFullName */
    private String receiverFullName = "";
    /** 属性certifType */
    private String certifType = "";
    /** 属性address */
    private String address = "";
    /** 属性certifNo */
    private String certifNo = "";
    /** 属性familyPhone */
    private String familyPhone = "";
    /** 属性officePhone */
    private String officePhone = "";
    /** 属性mobilePhone */
    private String mobilePhone = "";
    /** 属性payreMark */
    private String payreMark = "";
    /** 属性operatorCode */
    private String operatorCode = "";
    /** 属性inputDate */
    private DateTime inputDate = new DateTime();
    /** 属性payDate */
    private DateTime payDate = new DateTime();
    /** 属性payCode */
    private String payCode = "";
    /** 属性payFlag */
    private String payFlag = "";
    /** 属性paymentTye */
    private String paymentType = "";
    /** 属性bankAccount */
    private String bankAccount = "";
    /** 属性node */
    private String node = "";
    /** 属性uploadSerialno */
    private String uploadSerialno = "";
    /** 属性vflag */
    private String vflag = "";
    /** 属性comCode */
    private String comCode = "";
    /** 属性serialNo2 */
    private String serialNo2 = "";
    /** 属性provinceCode */
    private String provinceCode = "";
    /** 属性cityCode */
    private String cityCode = "";
    /** 属性urgentType */
    private String urgentType = "";
    /** 属性qqNumber */
    private String qqNumber = "";
    /** 属性email */
    private String email = "";
    /** 属性unitLink */
    private String unitLink = "";
    /** 属性postCode */
    private String postCode = "";
    /** 属性operatorComCode */
    private String operatorComCode = "";
    /** 属性editDate */
    private DateTime editDate = new DateTime();
    private String receivertypeothername = "";
    /** 属性支付方式*/
    private String payWay = "";
    /** 属性传统支付原因*/
    private String payReason = "";
    /** 属性用途说明*/
    private String payPurpose = "";
    /** 属性账号类型*/
    private String accountFlag = "";
    /** 属性接口类型 1大病即时即报*/
    private String interType = "";
    /** 属性支付行号*/
    private String routeNum = "";
    /** 属性第三方支付类型*/
    private String thirdPayType = "";
    /** 属性联共保人*/
    private String coinsCode = "";

    /**
     *  默认构造方法,构造一个默认的PrpLpayHistgDtoBase对象
     */
    public PrpLpayHistgDtoBase(){
    }

    /**
     * 设置属性claimNo
     * @param claimNo 待设置的属性claimNo的值
     */
    public void setClaimNo(String claimNo){
        this.claimNo = StringUtils.rightTrim(claimNo);
    }

    /**
     * 获取属性claimNo
     * @return 属性claimNo的值
     */
    public String getClaimNo(){
        return claimNo;
    }

    /**
     * 设置属性serialNo
     * @param serialNo 待设置的属性serialNo的值
     */
    public void setSerialNo(String serialNo){
        this.serialNo = StringUtils.rightTrim(serialNo);
    }

    /**
     * 获取属性serialNo
     * @return 属性serialNo的值
     */
    public String getSerialNo(){
        return serialNo;
    }

    /**
     * 设置属性compensateNo
     * @param compensateNo 待设置的属性compensateNo的值
     */
    public void setCompensateNo(String compensateNo){
        this.compensateNo = StringUtils.rightTrim(compensateNo);
    }

    /**
     * 获取属性compensateNo
     * @return 属性compensateNo的值
     */
    public String getCompensateNo(){
        return compensateNo;
    }

    /**
     * 设置属性classCode
     * @param classCode 待设置的属性classCode的值
     */
    public void setClassCode(String classCode){
        this.classCode = StringUtils.rightTrim(classCode);
    }

    /**
     * 获取属性classCode
     * @return 属性classCode的值
     */
    public String getClassCode(){
        return classCode;
    }

    /**
     * 设置属性riskCode
     * @param riskCode 待设置的属性riskCode的值
     */
    public void setRiskCode(String riskCode){
        this.riskCode = StringUtils.rightTrim(riskCode);
    }

    /**
     * 获取属性riskCode
     * @return 属性riskCode的值
     */
    public String getRiskCode(){
        return riskCode;
    }

    /**
     * 设置属性registNo
     * @param registNo 待设置的属性registNo的值
     */
    public void setRegistNo(String registNo){
        this.registNo = StringUtils.rightTrim(registNo);
    }

    /**
     * 获取属性registNo
     * @return 属性registNo的值
     */
    public String getRegistNo(){
        return registNo;
    }

    /**
     * 设置属性policyNo
     * @param policyNo 待设置的属性policyNo的值
     */
    public void setPolicyNo(String policyNo){
        this.policyNo = StringUtils.rightTrim(policyNo);
    }

    /**
     * 获取属性policyNo
     * @return 属性policyNo的值
     */
    public String getPolicyNo(){
        return policyNo;
    }

    /**
     * 设置属性payType
     * @param payType 待设置的属性payType的值
     */
    public void setPayType(String payType){
        this.payType = StringUtils.rightTrim(payType);
    }

    /**
     * 获取属性payType
     * @return 属性payType的值
     */
    public String getPayType(){
        return payType;
    }

    /**
     * 设置属性receiverType
     * @param receiverType 待设置的属性receiverType的值
     */
    public void setReceiverType(String receiverType){
        this.receiverType = StringUtils.rightTrim(receiverType);
    }

    /**
     * 获取属性receiverType
     * @return 属性receiverType的值
     */
    public String getReceiverType(){
        return receiverType;
    }

    /**
     * 设置属性payAmount
     * @param payAmount 待设置的属性payAmount的值
     */
    public void setPayAmount(double payAmount){
        this.payAmount = payAmount;
    }

    /**
     * 获取属性payAmount
     * @return 属性payAmount的值
     */
    public double getPayAmount(){
        return payAmount;
    }

    /**
     * 设置属性bankType
     * @param bankType 待设置的属性bankType的值
     */
    public void setBankType(String bankType){
        this.bankType = StringUtils.rightTrim(bankType);
    }

    /**
     * 获取属性bankType
     * @return 属性bankType的值
     */
    public String getBankType(){
        return bankType;
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
     * 设置属性bankSite
     * @param bankSite 待设置的属性bankSite的值
     */
    public void setBankSite(String bankSite){
        this.bankSite = StringUtils.rightTrim(bankSite);
    }

    /**
     * 获取属性bankSite
     * @return 属性bankSite的值
     */
    public String getBankSite(){
        return bankSite;
    }

    /**
     * 设置属性accountType
     * @param accountType 待设置的属性accountType的值
     */
    public void setAccountType(String accountType){
        this.accountType = StringUtils.rightTrim(accountType);
    }

    /**
     * 获取属性accountType
     * @return 属性accountType的值
     */
    public String getAccountType(){
        return accountType;
    }

    /**
     * 设置属性receiverFullName
     * @param receiverFullName 待设置的属性receiverFullName的值
     */
    public void setReceiverFullName(String receiverFullName){
        this.receiverFullName = StringUtils.rightTrim(receiverFullName);
    }

    /**
     * 获取属性receiverFullName
     * @return 属性receiverFullName的值
     */
    public String getReceiverFullName(){
        return receiverFullName;
    }

    /**
     * 设置属性certifType
     * @param certifType 待设置的属性certifType的值
     */
    public void setCertifType(String certifType){
        this.certifType = StringUtils.rightTrim(certifType);
    }

    /**
     * 获取属性certifType
     * @return 属性certifType的值
     */
    public String getCertifType(){
        return certifType;
    }

    /**
     * 设置属性address
     * @param address 待设置的属性address的值
     */
    public void setAddress(String address){
        this.address = StringUtils.rightTrim(address);
    }

    /**
     * 获取属性address
     * @return 属性address的值
     */
    public String getAddress(){
        return address;
    }

    /**
     * 设置属性certifNo
     * @param certifNo 待设置的属性certifNo的值
     */
    public void setCertifNo(String certifNo){
        this.certifNo = StringUtils.rightTrim(certifNo);
    }

    /**
     * 获取属性certifNo
     * @return 属性certifNo的值
     */
    public String getCertifNo(){
        return certifNo;
    }

    /**
     * 设置属性familyPhone
     * @param familyPhone 待设置的属性familyPhone的值
     */
    public void setFamilyPhone(String familyPhone){
        this.familyPhone = StringUtils.rightTrim(familyPhone);
    }

    /**
     * 获取属性familyPhone
     * @return 属性familyPhone的值
     */
    public String getFamilyPhone(){
        return familyPhone;
    }

    /**
     * 设置属性officePhone
     * @param officePhone 待设置的属性officePhone的值
     */
    public void setOfficePhone(String officePhone){
        this.officePhone = StringUtils.rightTrim(officePhone);
    }

    /**
     * 获取属性officePhone
     * @return 属性officePhone的值
     */
    public String getOfficePhone(){
        return officePhone;
    }

    /**
     * 设置属性mobilePhone
     * @param mobilePhone 待设置的属性mobilePhone的值
     */
    public void setMobilePhone(String mobilePhone){
        this.mobilePhone = StringUtils.rightTrim(mobilePhone);
    }

    /**
     * 获取属性mobilePhone
     * @return 属性mobilePhone的值
     */
    public String getMobilePhone(){
        return mobilePhone;
    }

    /**
     * 设置属性payreMark
     * @param payreMark 待设置的属性payreMark的值
     */
    public void setPayreMark(String payreMark){
        this.payreMark = StringUtils.rightTrim(payreMark);
    }

    /**
     * 获取属性payreMark
     * @return 属性payreMark的值
     */
    public String getPayreMark(){
        return payreMark;
    }

    /**
     * 设置属性operatorCode
     * @param operatorCode 待设置的属性operatorCode的值
     */
    public void setOperatorCode(String operatorCode){
        this.operatorCode = StringUtils.rightTrim(operatorCode);
    }

    /**
     * 获取属性operatorCode
     * @return 属性operatorCode的值
     */
    public String getOperatorCode(){
        return operatorCode;
    }

    /**
     * 设置属性inputDate
     * @param inputDate 待设置的属性inputDate的值
     */
    public void setInputDate(DateTime inputDate){
        this.inputDate = inputDate;
    }

    /**
     * 获取属性inputDate
     * @return 属性inputDate的值
     */
    public DateTime getInputDate(){
        return inputDate;
    }

    /**
     * 设置属性payDate
     * @param payDate 待设置的属性payDate的值
     */
    public void setPayDate(DateTime payDate){
        this.payDate = payDate;
    }

    /**
     * 获取属性payDate
     * @return 属性payDate的值
     */
    public DateTime getPayDate(){
        return payDate;
    }

    /**
     * 设置属性payCode
     * @param payCode 待设置的属性payCode的值
     */
    public void setPayCode(String payCode){
        this.payCode = StringUtils.rightTrim(payCode);
    }

    /**
     * 获取属性payCode
     * @return 属性payCode的值
     */
    public String getPayCode(){
        return payCode;
    }

    /**
     * 设置属性payFlag
     * @param payFlag 待设置的属性payFlag的值
     */
    public void setPayFlag(String payFlag){
        this.payFlag = StringUtils.rightTrim(payFlag);
    }

    /**
     * 获取属性payFlag
     * @return 属性payFlag的值
     */
    public String getPayFlag(){
        return payFlag;
    }

    /**
     * 设置属性paymentTye
     * @param paymentTye 待设置的属性paymentTye的值
     */
    public void setPaymentType(String paymentType){
        this.paymentType = StringUtils.rightTrim(paymentType);
    }

    /**
     * 获取属性paymentTye
     * @return 属性paymentTye的值
     */
    public String getPaymentType(){
        return paymentType;
    }

    /**
     * 设置属性bankAccount
     * @param bankAccount 待设置的属性bankAccount的值
     */
    public void setBankAccount(String bankAccount){
        this.bankAccount = StringUtils.rightTrim(bankAccount);
    }

    /**
     * 获取属性bankAccount
     * @return 属性bankAccount的值
     */
    public String getBankAccount(){
        return bankAccount;
    }

    /**
     * 设置属性node
     * @param node 待设置的属性node的值
     */
    public void setNode(String node){
        this.node = StringUtils.rightTrim(node);
    }

    /**
     * 获取属性node
     * @return 属性node的值
     */
    public String getNode(){
        return node;
    }

    /**
     * 设置属性uploadSerialno
     * @param uploadSerialno 待设置的属性uploadSerialno的值
     */
    public void setUploadSerialno(String uploadSerialno){
        this.uploadSerialno = StringUtils.rightTrim(uploadSerialno);
    }

    /**
     * 获取属性uploadSerialno
     * @return 属性uploadSerialno的值
     */
    public String getUploadSerialno(){
        return uploadSerialno;
    }

    /**
     * 设置属性vflag
     * @param vflag 待设置的属性vflag的值
     */
    public void setVflag(String vflag){
        this.vflag = StringUtils.rightTrim(vflag);
    }

    /**
     * 获取属性vflag
     * @return 属性vflag的值
     */
    public String getVflag(){
        return vflag;
    }

    /**
     * 设置属性comCode
     * @param comCode 待设置的属性comCode的值
     */
    public void setComCode(String comCode){
        this.comCode = StringUtils.rightTrim(comCode);
    }

    /**
     * 获取属性comCode
     * @return 属性comCode的值
     */
    public String getComCode(){
        return comCode;
    }

    /**
     * 设置属性serialNo2
     * @param serialNo2 待设置的属性serialNo2的值
     */
    public void setSerialNo2(String serialNo2){
        this.serialNo2 = StringUtils.rightTrim(serialNo2);
    }

    /**
     * 获取属性serialNo2
     * @return 属性serialNo2的值
     */
    public String getSerialNo2(){
        return serialNo2;
    }

    /**
     * 设置属性provinceCode
     * @param provinceCode 待设置的属性provinceCode的值
     */
    public void setProvinceCode(String provinceCode){
        this.provinceCode = StringUtils.rightTrim(provinceCode);
    }

    /**
     * 获取属性provinceCode
     * @return 属性provinceCode的值
     */
    public String getProvinceCode(){
        return provinceCode;
    }

    /**
     * 设置属性cityCode
     * @param cityCode 待设置的属性cityCode的值
     */
    public void setCityCode(String cityCode){
        this.cityCode = StringUtils.rightTrim(cityCode);
    }

    /**
     * 获取属性cityCode
     * @return 属性cityCode的值
     */
    public String getCityCode(){
        return cityCode;
    }

    /**
     * 设置属性urgentType
     * @param urgentType 待设置的属性urgentType的值
     */
    public void setUrgentType(String urgentType){
        this.urgentType = StringUtils.rightTrim(urgentType);
    }

    /**
     * 获取属性urgentType
     * @return 属性urgentType的值
     */
    public String getUrgentType(){
        return urgentType;
    }

    /**
     * 设置属性qqNumber
     * @param qqNumber 待设置的属性qqNumber的值
     */
    public void setQqNumber(String qqNumber){
        this.qqNumber = StringUtils.rightTrim(qqNumber);
    }

    /**
     * 获取属性qqNumber
     * @return 属性qqNumber的值
     */
    public String getQqNumber(){
        return qqNumber;
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
     * 设置属性unitLink
     * @param unitLink 待设置的属性unitLink的值
     */
    public void setUnitLink(String unitLink){
        this.unitLink = StringUtils.rightTrim(unitLink);
    }

    /**
     * 获取属性unitLink
     * @return 属性unitLink的值
     */
    public String getUnitLink(){
        return unitLink;
    }

    /**
     * 设置属性postCode
     * @param postCode 待设置的属性postCode的值
     */
    public void setPostCode(String postCode){
        this.postCode = StringUtils.rightTrim(postCode);
    }

    /**
     * 获取属性postCode
     * @return 属性postCode的值
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
