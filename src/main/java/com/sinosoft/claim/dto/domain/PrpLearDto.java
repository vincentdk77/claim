package com.sinosoft.claim.dto.domain;

import java.util.ArrayList;
import java.util.Collection;

public class PrpLearDto{
	/**保单号 **/
	private String policyNo;
	/**耳标号 **/
	private String earNo;
	/**报案号 **/
	private String registNo = "";
	/**被保险人姓名 **/
	private String insuredName = "";
	/**报案注销标志 **/
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
