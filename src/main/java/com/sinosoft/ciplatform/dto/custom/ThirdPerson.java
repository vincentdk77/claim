package com.sinosoft.ciplatform.dto.custom;

public class ThirdPerson {
	
	private String personName="";//����
	private String identifyNumber="";//���֤��
	public ThirdPerson() {

	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public ThirdPerson(String personName, String identifyNumber) {
		this.personName = personName;
		this.identifyNumber = identifyNumber;
	}

}
