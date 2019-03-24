package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;

public class CIPropClaimDiseaseInfoDtoBase implements Serializable{

	private static final long serialVersionUID = 1L;
	   /**
     *  默认构造方法,构造一个默认的CIPropClaimDiseaseInfoDtoBase对象
     */
    public CIPropClaimDiseaseInfoDtoBase(){
    }
	private String diseaseCode = "";//疾病代码	DISEASE_CODE

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	
}
