package com.sinosoft.claim.webservice;

public class PersonInfo {
	/** ���Ա������� */
	private String registNo = "";
	/** ������Ա��� */
	private int personNo = 0;
	/** ������Ա���� */
	private String personName = "";
	/** �����Ա� */
	private String personSex = "";
	/** �������� */
	private int personAge = 0;
	/** ������ҵ���� */
	private String jobName = "";
	/** �����漰���� */
	private String referKind = "";
	/** �������˲�λ */
	private String partDesc = "";
	/** ���Ծ���ҽԺ */
	private String hospital = "";
	/** �����Ƿ����о�ҽ */
	private String motionFlag = "";
	/** ������������*/
	private String woundRemark = "";
	
	public PersonInfo() {
		
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	
	public int getPersonNo() {
		return personNo;
	}

	public void setPersonNo(int personNo) {
		this.personNo = personNo;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonSex() {
		return personSex;
	}

	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getReferKind() {
		return referKind;
	}

	public void setReferKind(String referKind) {
		this.referKind = referKind;
	}

	public String getPartDesc() {
		return partDesc;
	}

	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getMotionFlag() {
		return motionFlag;
	}

	public void setMotionFlag(String motionFlag) {
		this.motionFlag = motionFlag;
	}

	public String getWoundRemark() {
		return woundRemark;
	}

	public void setWoundRemark(String woundRemark) {
		this.woundRemark = woundRemark;
	}

	
}
