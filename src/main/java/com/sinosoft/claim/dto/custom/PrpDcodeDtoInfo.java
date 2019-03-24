package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class PrpDcodeDtoInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** ����ҵ����� */
	private String codeCode = "";
	/** ����ҵ��������ĺ��� */
	private String codeCName = "";

	public PrpDcodeDtoInfo(String codeCode,String codeCName){
		this.codeCode = codeCode;
    	this.codeCName = codeCName;
	}
	
	public String getCodeCode() {
		return codeCode;
	}

	public void setCodeCode(String codeCode) {
		this.codeCode = codeCode;
	}

	public String getCodeCName() {
		return codeCName;
	}

	public void setCodeCName(String codeCName) {
		this.codeCName = codeCName;
	}

}
