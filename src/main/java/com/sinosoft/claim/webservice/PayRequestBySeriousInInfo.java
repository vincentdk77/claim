package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.common.util.StringUtils;

public class PayRequestBySeriousInInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** �ͻ����������� */
	private String outId;
	/** �������� A������֧��U:����֧����Ϣ */
	private String operateType;
	/** �ո���� */
	private String paymentNo;
	/** ��������ʹ��� */
	private String receiverTypeOther;
	/** ������������ */
	private String receiverTypeOtherName;
	/** ��������� */
	private String receiverFullName;
	/** �����֤������ */
	private String certifType;
	/** �����֤���������� */
	private String certifTypeName;
	/** ֤������ */
	private String certifNo;
	/** �����̶� */
	private String urgentType;
	/** �����̶����� */
	private String urgentTypeName;
	/** ʡ������ */
	private String provinceCode;
	/** �������� */
	private String cityCode;
	/** �˺�����(�����˺ţ�1����λ�˺ţ�2) */
	private String accountType;
	/** ���д��� */
	private String bankType;
	/** �������� */
	private String bank;
	/** �����˺� */
	private String bankAccount;
	/** �˺�ȷ�ϣ���Ҫ�������˺�һ�� */
	private String bankAccount2;
	/** �ֻ����� */
	private String mobilePhone;
	/** ��ͥ�绰 */
	private String familyPhone;
	/** �칫�绰 */
	private String officePhone;
	/** ��ϸ��ַ */
	private String address;
	/** QQ���� */
	private String qqNumber;
	/** �����ʼ� */
	private String email;
	/** ��λ��ϵ��Ա */
	private String unitLink;
	/** �������� */
	private String postCode;
	/** ֧����ʽ(������֧����1����ͳ��ʽ֧����2) */
	private String payWay;
	/** ֧��ԭ�� */
	private String payReason;
	/** ��;˵�� */
	private String payPurpose;
	/** �⸶��Ϣ(����һ��) */
	private PaymentInfoBySeriousInDto[] paymentInfoBySeriousInDto;
	/** �������(���������) */
	private PayExtBySeriousInDto[] payExtBySeriousInDto;
	/** �����˴��� */
	private String operatorCode;
	/** ���������� */
	private String operatorName;
	/** �����˻������� */
	private String makeCom;
	/** �����˻������� */
	private String makeComName;
	/** ����ʱ�� */
	private Date operatorDate;
	/** ֧��������� */
	private String handleText;
	 /** �����˺�����(00:���п�,01:����,02:���ÿ�) */
    private String accountFlag = "";
    /** ���Խӿ�����*/
    private String seriousInterType = "";
    /**֧������ͨ��ʱ�� */
    private Date handleDate;
    /**֧��������Ա����*/
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
     * ���������˺�����(00:���п�,01:����,02:���ÿ�)
     * @param accountFlag �����õ������˺�����(00:���п�,01:����,02:���ÿ�)��ֵ
     */
    public void setAccountFlag(String accountFlag){
        this.accountFlag = StringUtils.rightTrim(accountFlag);
    }

    /**
     * ��ȡ�����˺�����(00:���п�,01:����,02:���ÿ�)
     * @return �����˺�����(00:���п�,01:����,02:���ÿ�)��ֵ
     */
    public String getAccountFlag(){
        return accountFlag;
    }

    /**
     * ��ȡ�ӿ����� 1�󲡼�ʱ�����ӿ�
     * @return ���Խӿ�����
     */
	public String getSeriousInterType() {
		return seriousInterType;
	}

	/**
     * ���ýӿ����� 1�󲡼�ʱ�����ӿ�
     * @param seriousInterType �ӿ�����
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
