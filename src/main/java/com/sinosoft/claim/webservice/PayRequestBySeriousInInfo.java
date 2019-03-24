package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class PayRequestBySeriousInInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 客户端数据主键 */
	private String outId;
	/** 操作类型 A：新增支付U:更新支付信息 */
	private String operateType;
	/** 收付编号 */
	private String paymentNo;
	/** 领款人类型代码 */
	private String receiverTypeOther;
	/** 领款人类别名称 */
	private String receiverTypeOtherName;
	/** 领款人名称 */
	private String receiverFullName;
	/** 领款人证件类型 */
	private String certifType;
	/** 领款人证件类型名称 */
	private String certifTypeName;
	/** 证件号码 */
	private String certifNo;
	/** 紧急程度 */
	private String urgentType;
	/** 紧急程度名称 */
	private String urgentTypeName;
	/** 省份名称 */
	private String provinceCode;
	/** 城市名称 */
	private String cityCode;
	/** 账号属性(个人账号：1，单位账号：2) */
	private String accountType;
	/** 银行大类 */
	private String bankType;
	/** 开户银行 */
	private String bank;
	/** 银行账号 */
	private String bankAccount;
	/** 账号确认，需要跟银行账号一致 */
	private String bankAccount2;
	/** 手机号码 */
	private String mobilePhone;
	/** 家庭电话 */
	private String familyPhone;
	/** 办公电话 */
	private String officePhone;
	/** 详细地址 */
	private String address;
	/** QQ号码 */
	private String qqNumber;
	/** 电子邮件 */
	private String email;
	/** 单位联系人员 */
	private String unitLink;
	/** 邮政编码 */
	private String postCode;
	/** 支付方式(第三方支付：1，传统方式支付：2) */
	private String payWay;
	/** 支付原因 */
	private String payReason;
	/** 用途说明 */
	private String payPurpose;
	/** 赔付信息(至少一条) */
	private PaymentInfoBySeriousInDto[] paymentInfoBySeriousInDto;
	/** 处理意见(零条或多条) */
	private PayExtBySeriousInDto[] payExtBySeriousInDto;
	/** 操作人代码 */
	private String operatorCode;
	/** 操作人名称 */
	private String operatorName;
	/** 操作人机构代码 */
	private String makeCom;
	/** 操作人机构名称 */
	private String makeComName;
	/** 操作时间 */
	private Date operatorDate;
	/** 支付审批意见 */
	private String handleText;
	 /** 属性账号类型(00:银行卡,01:存折,02:信用卡) */
    private String accountFlag = "";
    /** 属性接口类型*/
    private String seriousInterType = "";
    /**支付审批通过时间 */
    private Date handleDate;
    /**支付审批人员代码*/
    private String  handleCode = "";

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getReceiverTypeOther() {
		return receiverTypeOther;
	}

	public void setReceiverTypeOther(String receiverTypeOther) {
		this.receiverTypeOther = receiverTypeOther;
	}

	public String getReceiverTypeOtherName() {
		return receiverTypeOtherName;
	}

	public void setReceiverTypeOtherName(String receiverTypeOtherName) {
		this.receiverTypeOtherName = receiverTypeOtherName;
	}

	public String getReceiverFullName() {
		return receiverFullName;
	}

	public void setReceiverFullName(String receiverFullName) {
		this.receiverFullName = receiverFullName;
	}

	public String getCertifType() {
		return certifType;
	}

	public void setCertifType(String certifType) {
		this.certifType = certifType;
	}

	public String getCertifTypeName() {
		return certifTypeName;
	}

	public void setCertifTypeName(String certifTypeName) {
		this.certifTypeName = certifTypeName;
	}

	public String getCertifNo() {
		return certifNo;
	}

	public void setCertifNo(String certifNo) {
		this.certifNo = certifNo;
	}

	public String getUrgentType() {
		return urgentType;
	}

	public void setUrgentType(String urgentType) {
		this.urgentType = urgentType;
	}

	public String getUrgentTypeName() {
		return urgentTypeName;
	}

	public void setUrgentTypeName(String urgentTypeName) {
		this.urgentTypeName = urgentTypeName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankAccount2() {
		return bankAccount2;
	}

	public void setBankAccount2(String bankAccount2) {
		this.bankAccount2 = bankAccount2;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnitLink() {
		return unitLink;
	}

	public void setUnitLink(String unitLink) {
		this.unitLink = unitLink;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
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

	public PaymentInfoBySeriousInDto[] getPaymentInfoBySeriousInDto() {
		return paymentInfoBySeriousInDto;
	}

	public PayExtBySeriousInDto[] getPayExtBySeriousInDto() {
		return payExtBySeriousInDto;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}

	public String getMakeComName() {
		return makeComName;
	}

	public void setMakeComName(String makeComName) {
		this.makeComName = makeComName;
	}

	public Date getOperatorDate() {
		return operatorDate;
	}

	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}

	public String getHandleText() {
		return handleText;
	}

	public void setHandleText(String handleText) {
		this.handleText = handleText;
	}  
	
	 /**
     * 设置属性账号类型(00:银行卡,01:存折,02:信用卡)
     * @param accountFlag 待设置的属性账号类型(00:银行卡,01:存折,02:信用卡)的值
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * 获取属性账号类型(00:银行卡,01:存折,02:信用卡)
     * @return 属性账号类型(00:银行卡,01:存折,02:信用卡)的值
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * 获取接口类型 1大病即时即报接口
     * @return 属性接口类型
     */
	public String getSeriousInterType() {
		return seriousInterType;
	}

	/**
     * 设置接口类型 1大病即时即报接口
     * @param seriousInterType 接口类型
     */
	public void setSeriousInterType(String seriousInterType) {
		this.seriousInterType = seriousInterType;
	}

	public void setPaymentInfoBySeriousInDto(
			PaymentInfoBySeriousInDto[] paymentInfoBySeriousInDto) {
		this.paymentInfoBySeriousInDto = paymentInfoBySeriousInDto;
	}

	public void setPayExtBySeriousInDto(PayExtBySeriousInDto[] payExtBySeriousInDto) {
		this.payExtBySeriousInDto = payExtBySeriousInDto;
	}

	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public String getHandleCode() {
		return handleCode;
	}

	public void setHandleCode(String handleCode) {
		this.handleCode = handleCode;
	}

    
}
