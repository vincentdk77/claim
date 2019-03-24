package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class GisUserCompanyInfo implements Serializable {
	/** 属性员工代码 */
	private String userCode = "";
	/** 属性员工名称 */
	private String userName = "";
	/** 属性员工名称E */
	private String userEName = "";
	/** 属性密码 */
	private String password = "";
	/** 属性印鉴 */
	private String seal = "";
	/** 属性密码设置日期 */
	private Date passwordSetDate = new Date();
	/** 属性密码过期日期 */
	private Date passwordExpireDate = new Date();
	/** 属性归属机构代码 */
	private String user_ComCode = "";
	/** 属性出单机构代码 */
	private String makeCom = "";
	/** 属性账号代码 */
	private String accountCode = "";
	/** 属性电话号码 */
	private String phone = "";
	/** 属性手机号码 */
	private String mobile = "";
	/** 属性通信地址 */
	private String address = "";
	/** 属性邮政编码 */
	private String user_PostCode = "";
	/** 属性邮箱 */
	private String email = "";
	/** 属性员工标志 */
	private String userFlag = "";
	/** 属性允许登录的应用系统 */
	private String loginSystem = "";
	/** 属性最新员工代码 */
	private String newUserCode = "";
	/** 属性效力状态 */
	private String user_ValidStatus = "";
	/** 属性专项代码 */
	private String user_ArticleCode = "";
	/** 属性标志字段 */
	private String user_Flag = "";

	/** 属性机构代码 */
	private String comCode = "";
	/** 属性机构中文名称 */
	private String comCName = "";
	/** 属性机构英文名称 */
	private String comEName = "";
	/** 属性地址中文名称 */
	private String addressCName = "";
	/** 属性地址英文名称 */
	private String addressEName = "";
	/** 属性邮编 */
	private String postCode = "";
	/** 属性电话 */
	private String phoneNumber = "";
	/** 属性保险公司纳税人识别号 */
	private String taxNumber = "";
	/** 属性传真 */
	private String faxNumber = "";
	/** 属性上级机构代码 */
	private String upperComCode = "";
	/** 属性保险人名称 */
	private String insurerName = "";
	/** 属性机构属性 */
	private String comAttribute = "";
	/** 属性机构类型 */
	private String comType = "";
	/** 属性机构级别 */
	private String comLevel = "";
	/** 属性经理 */
	private String manager = "";
	/** 属性财务主管 */
	private String accountLeader = "";
	/** 属性出纳 */
	private String cashier = "";
	/** 属性会计 */
	private String accountant = "";
	/** 属性备注 */
	private String remark = "";
	/** 属性新的机构代码 */
	private String newComCode = "";
	/** 属性是否有效 */
	private String validStatus = "";
	/** 属性财务机构 */
	private String acntUnit = "";
	/** 属性专项代码 */
	private String articleCode = "";
	/** 属性归属帐套 */
	private String accCode = "";
	/** 属性机构类型标志 */
	private String centerFlag = "";
	/** 属性对外机构代码 */
	private String outerPayCode = "";
	/** 属性对内机构代码 */
	private String innerPayCode = "";
	/** 属性标志 */
	private String flag = "";
	/** 属性网址 */
	private String webAddress = "";
	/** 属性服务电话 */
	private String servicePhone = "";
	/** 属性报案电话 */
	private String reportPhone = "";
	/** 属性代理人代码 */
	private String agentCode = "";
	/** 属性代理人协议号 */
	private String agreementNo = "";
	/** 属性公司类别标志 */
	private String companyFlag = "";
	/** 属性机构简称 */
	private String shortComCName = "";
	/** 属性服务部标志 */
	private String serviceFlag = "";
	/** 属性平台子系统机构代码 */
	private String daaplatformComCode = "";
	/** 属性系统时间 */
	private Date webTime = new Date();

	/**
	 * 默认构造方法,构造一个默认的GisCompanyInfo对象
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
