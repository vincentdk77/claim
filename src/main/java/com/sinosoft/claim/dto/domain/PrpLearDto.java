package com.sinosoft.claim.dto.domain;

import java.util.ArrayList;
import java.util.Collection;

public class PrpLearDto{
	/**������ **/
	private String policyNo;
	/**����� **/
	private String earNo;
	/**������ **/
	private String registNo = "";
	/**������������ **/
	private String insuredName = "";
	/**����ע����־ **/
	private String validStatus = "";

   public PrpLearDto(){
	   
   }

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getEarNo() {
		return earNo;
	}

	public void setEarNo(String earNo) {
		this.earNo = earNo;
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	public String getValidStatus() {
		return validStatus;
	}

	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}	

}
