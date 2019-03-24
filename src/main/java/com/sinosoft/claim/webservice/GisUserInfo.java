package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

import com.sinosoft.sysframework.common.datatype.DateTime;

public class GisUserInfo implements Serializable {
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
	private String comCode = "";
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
	private String postCode = "";
	/** �������� */
	private String email = "";
	/** ����Ա����־ */
	private String userFlag = "";
	/** ���������¼��Ӧ��ϵͳ */
	private String loginSystem = "";
	/** ��������Ա������ */
	private String newUserCode = "";
	/** ����Ч��״̬ */
	private String validStatus = "";
	/** ����ר����� */
	private String articleCode = "";
	/** ���Ա�־�ֶ� */
	private String flag = "";

	/**
	 * Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�GisUserInfo����
	 */
	public GisUserInfo() {
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

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		if (null != comCode) {
			this.comCode = comCode;
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

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		if (null != postCode) {
			this.postCode = postCode;
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

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		if (null != validStatus) {
			this.validStatus = validStatus;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		if (null != flag) {
			this.flag = flag;
		}
	}

}
