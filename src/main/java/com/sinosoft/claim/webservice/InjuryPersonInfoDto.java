package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class InjuryPersonInfoDto implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	/**  Ù–‘AcciName */
    private String acciName = "";
    /**  Ù–‘Sex */
    private String sex = "";
    /**  Ù–‘IdentifyNumber */
    private String identifyNumber = "";
    public InjuryPersonInfoDto(){
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
//	public String getId() {
//		return Id;
//	}
//	public void setId(String id) {
//		Id = id;
//	}
    
}
