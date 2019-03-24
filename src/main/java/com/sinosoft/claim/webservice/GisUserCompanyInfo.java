package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class GisUserCompanyInfo implements Serializable {
	/** ����Ա������ */
	private String userCode = "";
	/** ����Ա������ */
	private String userName = "";
	/** ����Ա������E */
	private String userEName = "";
	/** �������� */
	private String password = "";
	/** ����ӡ�� */
	private String seal = "";
	/** ���������������� */
	private Date passwordSetDate = new Date();
	/** ��������������� */
	private Date passwordExpireDate = new Date();
	/** ���Թ����������� */
	private String user_ComCode = "";
	/** ���Գ����������� */
	private String makeCom = "";
	/** �����˺Ŵ��� */
	private String accountCode = "";
	/** ���Ե绰���� */
	private String phone = "";
	/** �����ֻ����� */
	private String mobile = "";
	/** ����ͨ�ŵ�ַ */
	private String address = "";
	/** ������������ */
	private String user_PostCode = "";
	/** �������� */
	private String email = "";
	/** ����Ա����־ */
	private String userFlag = "";
	/** ���������¼��Ӧ��ϵͳ */
	private String loginSystem = "";
	/** ��������Ա������ */
	private String newUserCode = "";
	/** ����Ч��״̬ */
	private String user_ValidStatus = "";
	/** ����ר����� */
	private String user_ArticleCode = "";
	/** ���Ա�־�ֶ� */
	private String user_Flag = "";

	/** ���Ի������� */
	private String comCode = "";
	/** ���Ի����������� */
	private String comCName = "";
	/** ���Ի���Ӣ������ */
	private String comEName = "";
	/** ���Ե�ַ�������� */
	private String addressCName = "";
	/** ���Ե�ַӢ������ */
	private String addressEName = "";
	/** �����ʱ� */
	private String postCode = "";
	/** ���Ե绰 */
	private String phoneNumber = "";
	/** ���Ա��չ�˾��˰��ʶ��� */
	private String taxNumber = "";
	/** ���Դ��� */
	private String faxNumber = "";
	/** �����ϼ��������� */
	private String upperComCode = "";
	/** ���Ա��������� */
	private String insurerName = "";
	/** ���Ի������� */
	private String comAttribute = "";
	/** ���Ի������� */
	private String comType = "";
	/** ���Ի������� */
	private String comLevel = "";
	/** ���Ծ��� */
	private String manager = "";
	/** ���Բ������� */
	private String accountLeader = "";
	/** ���Գ��� */
	private String cashier = "";
	/** ���Ի�� */
	private String accountant = "";
	/** ���Ա�ע */
	private String remark = "";
	/** �����µĻ������� */
	private String newComCode = "";
	/** �����Ƿ���Ч */
	private String validStatus = "";
	/** ���Բ������ */
	private String acntUnit = "";
	/** ����ר����� */
	private String articleCode = "";
	/** ���Թ������� */
	private String accCode = "";
	/** ���Ի������ͱ�־ */
	private String centerFlag = "";
	/** ���Զ���������� */
	private String outerPayCode = "";
	/** ���Զ��ڻ������� */
	private String innerPayCode = "";
	/** ���Ա�־ */
	private String flag = "";
	/** ������ַ */
	private String webAddress = "";
	/** ���Է���绰 */
	private String servicePhone = "";
	/** ���Ա����绰 */
	private String reportPhone = "";
	/** ���Դ����˴��� */
	private String agentCode = "";
	/** ���Դ�����Э��� */
	private String agreementNo = "";
	/** ���Թ�˾����־ */
	private String companyFlag = "";
	/** ���Ի������ */
	private String shortComCName = "";
	/** ���Է��񲿱�־ */
	private String serviceFlag = "";
	/** ����ƽ̨��ϵͳ�������� */
	private String daaplatformComCode = "";
	/** ����ϵͳʱ�� */
	private Date webTime = new Date();

	/**
	 * Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�GisCompanyInfo����
	 */
	public GisUserCompanyInfo() {
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		if (null != userCode) {
			this.userCode = userCode;
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		if (null != userName) {
			this.userName = userName;
		}
	}

	public String getUserEName() {
		return userEName;
	}

	public void setUserEName(String userEName) {
		if (null != userEName) {
			this.userEName = userEName;
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (null != password) {
			this.password = password;
		}
	}

	public String getSeal() {
		return seal;
	}

	public void setSeal(String seal) {
		if (null != seal) {
			this.seal = seal;
		}
	}

	public Date getPasswordSetDate() {
		return passwordSetDate;
	}

	public void setPasswordSetDate(Date passwordSetDate) {
		if (null != passwordSetDate) {
			this.passwordSetDate = passwordSetDate;
		}
	}

	public Date getPasswordExpireDate() {
		return passwordExpireDate;
	}

	public void setPasswordExpireDate(Date passwordExpireDate) {
		if (null != passwordExpireDate) {
			this.passwordExpireDate = passwordExpireDate;
		}
	}

	public String getUser_ComCode() {
		return user_ComCode;
	}

	public void setUser_ComCode(String user_ComCode) {
		if (null != user_ComCode) {
			this.user_ComCode = user_ComCode;
		}
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		if (null != makeCom) {
			this.makeCom = makeCom;
		}
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		if (null != accountCode) {
			this.accountCode = accountCode;
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (null != phone) {
			this.phone = phone;
		}
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		if (null != mobile) {
			this.mobile = mobile;
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (null != address) {
			this.address = address;
		}
	}

	public String getUser_PostCode() {
		return user_PostCode;
	}

	public void setUser_PostCode(String user_PostCode) {
		if (null != user_PostCode) {
			this.user_PostCode = user_PostCode;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (null != email) {
			this.email = email;
		}
	}

	public String getUserFlag() {
		return userFlag;
	}

	public void setUserFlag(String userFlag) {
		if (null != userFlag) {
			this.userFlag = userFlag;
		}
	}

	public String getLoginSystem() {
		return loginSystem;
	}

	public void setLoginSystem(String loginSystem) {
		if (null != loginSystem) {
			this.loginSystem = loginSystem;
		}
	}

	public String getNewUserCode() {
		return newUserCode;
	}

	public void setNewUserCode(String newUserCode) {
		if (null != newUserCode) {
			this.newUserCode = newUserCode;
		}
	}

	public String getUser_ValidStatus() {
		return user_ValidStatus;
	}

	public void setUser_ValidStatus(String user_ValidStatus) {
		if (null != user_ValidStatus) {
			this.user_ValidStatus = user_ValidStatus;
		}
	}

	public String getUser_ArticleCode() {
		return user_ArticleCode;
	}

	public void setUser_ArticleCode(String user_ArticleCode) {
		if (null != user_ArticleCode) {
			this.user_ArticleCode = user_ArticleCode;
		}
	}

	public String getUser_Flag() {
		return user_Flag;
	}

	public void setUser_Flag(String user_Flag) {
		if (null != user_Flag) {
			this.user_Flag = user_Flag;
		}
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		if (null != comCode) {
			this.comCode = comCode;
		}
	}

	public String getComCName() {
		return comCName;
	}

	public void setComCName(String comCName) {
		if (null != comCName) {
			this.comCName = comCName;
		}
	}

	public String getComEName() {
		return comEName;
	}

	public void setComEName(String comEName) {
		if (null != comEName) {
			this.comEName = comEName;
		}
	}

	public String getAddressCName() {
		return addressCName;
	}

	public void setAddressCName(String addressCName) {
		if (null != addressCName) {
			this.addressCName = addressCName;
		}
	}

	public String getAddressEName() {
		return addressEName;
	}

	public void setAddressEName(String addressEName) {
		if (null != addressEName) {
			this.addressEName = addressEName;
		}
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		if (null != postCode) {
			this.postCode = postCode;
		}
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (null != phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		if (null != taxNumber) {
			this.taxNumber = taxNumber;
		}
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		if (null != faxNumber) {
			this.faxNumber = faxNumber;
		}
	}

	public String getUpperComCode() {
		return upperComCode;
	}

	public void setUpperComCode(String upperComCode) {
		if (null != upperComCode) {
			this.upperComCode = upperComCode;
		}
	}

	public String getInsurerName() {
		return insurerName;
	}

	public void setInsurerName(String insurerName) {
		if (null != insurerName) {
			this.insurerName = insurerName;
		}
	}

	public String getComAttribute() {
		return comAttribute;
	}

	public void setComAttribute(String comAttribute) {
		if (null != comAttribute) {
			this.comAttribute = comAttribute;
		}
	}

	public String getComType() {
		return comType;
	}

	public void setComType(String comType) {
		if (null != comType) {
			this.comType = comType;
		}
	}

	public String getComLevel() {
		return comLevel;
	}

	public void setComLevel(String comLevel) {
		if (null != comLevel) {
			this.comLevel = comLevel;
		}
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		if (null != manager) {
			this.manager = manager;
		}
	}

	public String getAccountLeader() {
		return accountLeader;
	}

	public void setAccountLeader(String accountLeader) {
		if (null != accountLeader) {
			this.accountLeader = accountLeader;
		}
	}

	public String getCashier() {
		return cashier;
	}

	public void setCashier(String cashier) {
		if (null != cashier) {
			this.cashier = cashier;
		}
	}

	public String getAccountant() {
		return accountant;
	}

	public void setAccountant(String accountant) {
		if (null != accountant) {
			this.accountant = accountant;
		}
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		if (null != remark) {
			this.remark = remark;
		}
	}

	public String getNewComCode() {
		return newComCode;
	}

	public void setNewComCode(String newComCode) {
		if (null != newComCode) {
			this.newComCode = newComCode;
		}
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		if (null != validStatus) {
			this.validStatus = validStatus;
		}
	}

	public String getAcntUnit() {
		return acntUnit;
	}

	public void setAcntUnit(String acntUnit) {
		if (null != acntUnit) {
			this.acntUnit = acntUnit;
		}
	}

	public String getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(String articleCode) {
		if (null != articleCode) {
			this.articleCode = articleCode;
		}
	}

	public String getAccCode() {
		return accCode;
	}

	public void setAccCode(String accCode) {
		if (null != accCode) {
			this.accCode = accCode;
		}
	}

	public String getCenterFlag() {
		return centerFlag;
	}

	public void setCenterFlag(String centerFlag) {
		if (null != centerFlag) {
			this.centerFlag = centerFlag;
		}
	}

	public String getOuterPayCode() {
		return outerPayCode;
	}

	public void setOuterPayCode(String outerPayCode) {
		if (null != outerPayCode) {
			this.outerPayCode = outerPayCode;
		}
	}

	public String getInnerPayCode() {
		return innerPayCode;
	}

	public void setInnerPayCode(String innerPayCode) {
		if (null != innerPayCode) {
			this.innerPayCode = innerPayCode;
		}
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		if (null != flag) {
			this.flag = flag;
		}
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		if (null != webAddress) {
			this.webAddress = webAddress;
		}
	}

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		if (null != servicePhone) {
			this.servicePhone = servicePhone;
		}
	}

	public String getReportPhone() {
		return reportPhone;
	}

	public void setReportPhone(String reportPhone) {
		if (null != reportPhone) {
			this.reportPhone = reportPhone;
		}
	}

	public String getAgentCode() {
		return agentCode;
	}

	public void setAgentCode(String agentCode) {
		if (null != agentCode) {
			this.agentCode = agentCode;
		}
	}

	public String getAgreementNo() {
		return agreementNo;
	}

	public void setAgreementNo(String agreementNo) {
		if (null != agreementNo) {
			this.agreementNo = agreementNo;
		}
	}

	public String getCompanyFlag() {
		return companyFlag;
	}

	public void setCompanyFlag(String companyFlag) {
		if (null != companyFlag) {
			this.companyFlag = companyFlag;
		}
	}

	public String getShortComCName() {
		return shortComCName;
	}

	public void setShortComCName(String shortComCName) {
		if (null != shortComCName) {
			this.shortComCName = shortComCName;
		}
	}

	public String getServiceFlag() {
		return serviceFlag;
	}

	public void setServiceFlag(String serviceFlag) {
		if (null != serviceFlag) {
			this.serviceFlag = serviceFlag;
		}
	}

	public String getDaaplatformComCode() {
		return daaplatformComCode;
	}

	public void setDaaplatformComCode(String daaplatformComCode) {
		if (null != daaplatformComCode) {
			this.daaplatformComCode = daaplatformComCode;
		}
	}

	public Date getWebTime() {
		return webTime;
	}

	public void setWebTime(Date webTime) {
		if (null != webTime) {
			this.webTime = webTime;
		}
	}

}
