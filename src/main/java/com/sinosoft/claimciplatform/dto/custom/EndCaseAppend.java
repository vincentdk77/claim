package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

public class EndCaseAppend {
	private String claimCode="";	      	//理赔编码
	private String serialNo = "";			//追加序号
	private String appendDate = "";			//追加日期
	private String accidentDeath = "";		//追加期间是否发生有责交通死亡事故
	private String policyNO="";			//保单号
	private String registNo="";			//报案号
	private String claimNo="";			//立案号
	private List endCaseAppSituationList=new ArrayList();//追加赔偿情况
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public List getEndCaseAppSituationList() {
		return endCaseAppSituationList;
	}
	public void setEndCaseAppSituationList(List endCaseAppSituations) {
		this.endCaseAppSituationList = endCaseAppSituations;
	}
	public void addEndCaseAppSituation(EndCaseAppSituation endCaseAppSituation) {
		this.endCaseAppSituationList.add(endCaseAppSituation);
	}
	public String getClaimNo() {
		return claimNo;
	}
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}
	public String getPolicyNO() {
		return policyNO;
	}
	public void setPolicyNO(String policyNO) {
		this.policyNO = policyNO;
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getAppendDate() {
		return appendDate;
	}
	public void setAppendDate(String appendDate) {
		this.appendDate = appendDate;
	}
	public String getAccidentDeath() {
		return accidentDeath;
	}
	public void setAccidentDeath(String accidentDeath) {
		this.accidentDeath = accidentDeath;
	}
	
}
