package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;

public class CIPropClaimDiseaseInfoDtoBase implements Serializable{

	private static final long serialVersionUID = 1L;
	   /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIPropClaimDiseaseInfoDtoBase����
     */
    public CIPropClaimDiseaseInfoDtoBase(){
    }
	private String diseaseCode = "";//��������	DISEASE_CODE

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	
}
