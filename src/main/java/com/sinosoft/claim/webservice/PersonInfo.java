package com.sinosoft.claim.webservice;

public class PersonInfo {
	/** 属性报案号码 */
	private String registNo = "";
	/** 属性人员序号 */
	private int personNo = 0;
	/** 属性人员姓名 */
	private String personName = "";
	/** 属性性别 */
	private String personSex = "";
	/** 属性年龄 */
	private int personAge = 0;
	/** 属性行业名称 */
	private String jobName = "";
	/** 属性涉及险种 */
	private String referKind = "";
	/** 属性受伤部位 */
	private String partDesc = "";
	/** 属性就诊医院 */
	private String hospital = "";
	/** 属性是否自行就医 */
	private String motionFlag = "";
	/** 属性伤情描述*/
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
