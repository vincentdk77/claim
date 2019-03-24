package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class AcciPersonDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ��� */
	private String serialNo;
	/** �¹������ */
	private String familyNo;
	/** �¹��߱��� */
	private String acciCode;
	/** �¹������� */
	private String acciName;
	/** �¹����Ա� 1���� 2��Ů */
	private String sex;
	/** �¹������� */
	private String age;
	/** ���֤�� */
	private String identifyNumber;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(String familyNo) {
		this.familyNo = familyNo;
	}

	public String getAcciCode() {
		return acciCode;
	}

	public void setAcciCode(String acciCode) {
		this.acciCode = acciCode;
	}

	public String getAcciName() {
		return acciName;
	}

	public void setAcciName(String acciName) {
		this.acciName = acciName;
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

}
