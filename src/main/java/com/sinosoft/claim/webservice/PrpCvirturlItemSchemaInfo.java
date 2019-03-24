package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class PrpCvirturlItemSchemaInfo implements Serializable {
	private String PolicyNo;
	
    private String RiskCode;
    private String FamilyNo;
    private String FamilyName;
    private String IdentifyNumber;
    private String FamilyAge;
    private String FamilySex;
    private String BenName;
    private String BenSex;
    
    
	public PrpCvirturlItemSchemaInfo() {
		
	}
	
	
	public PrpCvirturlItemSchemaInfo(String familyNo, String familyName, 
			String identifyNumber,String familyAge, String familySex) {
		
		this.FamilyNo = familyNo;
		this.FamilyName = familyName;
		this.IdentifyNumber = identifyNumber;
		this.FamilyAge = familyAge;
		this.FamilySex = familySex;
	}


	public String getPolicyNo() {
		return PolicyNo;
	}
	public void setPolicyNo(String policyNo) {
		PolicyNo = policyNo;
	}
	public String getRiskCode() {
		return RiskCode;
	}
	public void setRiskCode(String riskCode) {
		RiskCode = riskCode;
	}
	public String getFamilyNo() {
		return FamilyNo;
	}
	public void setFamilyNo(String familyNo) {
		FamilyNo = familyNo;
	}
	public String getFamilyName() {
		return FamilyName;
	}
	public void setFamilyName(String familyName) {
		FamilyName = familyName;
	}
	public String getIdentifyNumber() {
		return IdentifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		IdentifyNumber = identifyNumber;
	}
	public String getFamilyAge() {
		return FamilyAge;
	}
	public void setFamilyAge(String familyAge) {
		FamilyAge = familyAge;
	}
	public String getFamilySex() {
		return FamilySex;
	}
	public void setFamilySex(String familySex) {
		FamilySex = familySex;
	}
	public String getBenName() {
		return BenName;
	}
	public void setBenName(String benName) {
		BenName = benName;
	}
	public String getBenSex() {
		return BenSex;
	}
	public void setBenSex(String benSex) {
		BenSex = benSex;
	}
    
    


}
