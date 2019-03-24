package com.sinosoft.claimciplatform.dto.custom;


/**
 * �¹���Ϣ�ϴ����󷵻ص���Ϣ���ɹ���
 */

public class CompelCrashDto {
	
	/**�¹���Ϣ��д������Ϣ�Ĺ���������Ϣ*/
	private CompePlatFormRetrunParam compePlatFormRetrunParam;

	/** �׷��¹��ϴ���Ϣ */
	private CompelCrashAccidentInfor ownAccidentInfor;

	/** �ҷ��¹��ϴ���Ϣ */
	private CompelCrashAccidentInfor otherAccidentInfor;

	/**�¹ʺ�*/
	private String accidentNo;
	/** ���� */
	private String faultParty;

	/** һ�������˹�����Ϊ */
	private String faultBehavior;

	/** ����ʱ�� */
	private String accidentTime;

	/** �����ص� */
	private String accidentPlace;

	/** ����ʱ�� */
	private String reportTime;

	/** ���붨��ʱ�� */
	private String applyAssessmentTime;

	/** ������ʼʱ�� */
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
