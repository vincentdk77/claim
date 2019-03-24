package com.sinosoft.claimciplatform.dto.custom;


/**
 * 事故信息上传请求返回的信息（成功）
 */

public class CompelCrashDto {
	
	/**事故信息回写返回信息的公共部分信息*/
	private CompePlatFormRetrunParam compePlatFormRetrunParam;

	/** 甲方事故上传信息 */
	private CompelCrashAccidentInfor ownAccidentInfor;

	/** 乙方事故上传信息 */
	private CompelCrashAccidentInfor otherAccidentInfor;

	/**事故号*/
	private String accidentNo;
	/** 过错方 */
	private String faultParty;

	/** 一方当事人过错行为 */
	private String faultBehavior;

	/** 发生时间 */
	private String accidentTime;

	/** 发生地点 */
	private String accidentPlace;

	/** 报案时间 */
	private String reportTime;

	/** 申请定损时间 */
	private String applyAssessmentTime;

	/** 定损起始时间 */
	private String assessStartTime;

	public CompelCrashAccidentInfor getOwnAccidentInfor() {
		return ownAccidentInfor;
	}

	public void setOwnAccidentInfor(CompelCrashAccidentInfor ownAccidentInfor) {
		this.ownAccidentInfor = ownAccidentInfor;
	}

	public String getAccidentPlace() {
		return accidentPlace;
	}

	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}

	public String getAccidentTime() {
		return accidentTime;
	}

	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}

	public String getApplyAssessmentTime() {
		return applyAssessmentTime;
	}

	public void setApplyAssessmentTime(String applyAssessmentTime) {
		this.applyAssessmentTime = applyAssessmentTime;
	}

	public String getAssessStartTime() {
		return assessStartTime;
	}

	public void setAssessStartTime(String assessStartTime) {
		this.assessStartTime = assessStartTime;
	}

	public String getFaultBehavior() {
		return faultBehavior;
	}

	public void setFaultBehavior(String faultBehavior) {
		this.faultBehavior = faultBehavior;
	}

	public String getFaultParty() {
		return faultParty;
	}

	public void setFaultParty(String faultParty) {
		this.faultParty = faultParty;
	}

	public CompelCrashAccidentInfor getOtherAccidentInfor() {
		return otherAccidentInfor;
	}

	public void setOtherAccidentInfor(
			CompelCrashAccidentInfor otherAccidentInfor) {
		this.otherAccidentInfor = otherAccidentInfor;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public String getAccidentNo() {
		return accidentNo;
	}

	public void setAccidentNo(String accidentNo) {
		this.accidentNo = accidentNo;
	}

	public CompePlatFormRetrunParam getCompePlatFormRetrunParam() {
		return compePlatFormRetrunParam;
	}

	public void setCompePlatFormRetrunParam(
			CompePlatFormRetrunParam compePlatFormRetrunParam) {
		this.compePlatFormRetrunParam = compePlatFormRetrunParam;
	}

}
