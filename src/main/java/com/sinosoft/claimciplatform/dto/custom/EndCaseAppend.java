package com.sinosoft.claimciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

public class EndCaseAppend {
	private String claimCode="";	      	//�������
	private String serialNo = "";			//׷�����
	private String appendDate = "";			//׷������
	private String accidentDeath = "";		//׷���ڼ��Ƿ�������ͨ�����¹�
	private String policyNO="";			//������
	private String registNo="";			//������
	private String claimNo="";			//������
	private List endCaseAppSituationList=new ArrayList();//׷���⳥���
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
