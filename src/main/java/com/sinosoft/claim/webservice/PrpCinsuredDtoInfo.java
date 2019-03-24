package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class PrpCinsuredDtoInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** ���������кţ��ŵ���familyno */
	private String familyno;
	/** �ֻ����� */
	private String insuredName;
	/** �ֻ��Ա� */
	private String sex;
	/** �ֻ����� */
	private String age;
	/** �ֻ����֤�� */
	private String identifyNumber;
	/** �ֻ����룬���ŵ�û�д�ֵ�������д�ֵ */
	private String insuredCode;

	public String getFamilyno() {
		return familyno;
	}

	public void setFamilyno(String familyno) {
		this.familyno = familyno;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getInsuredCode() {
		return insuredCode;
	}

	public void setInsuredCode(String insuredCode) {
		this.insuredCode = insuredCode;
	}

}
