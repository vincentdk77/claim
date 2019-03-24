package com.sinosoft.claim.bl.action.domain;

import java.io.Serializable;

public class PrpLinterInjuryPersonDtoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 属性主键pk */
    private String id = "";
    /** 属性AcciName */
    private String acciName = "";
    /** 属性Sex */
    private String sex = "";
    /** 属性IdentifyNumber */
    private String identifyNumber = "";
    
    public PrpLinterInjuryPersonDtoBase(){
    	
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

}
