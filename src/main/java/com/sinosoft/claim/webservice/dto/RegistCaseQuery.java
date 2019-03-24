package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * ���������ѯ�ӿ�  ��ѯ�����б�����
 *
 */
public class RegistCaseQuery implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ������ */
	private String registNo;
	/** ������ */
	private String policyNo;
	/** ���ƺ� */
	private String licenseNo;
	/** ���� */
	private String comcode;
	/** ������������ */
	private String insuredName;
	/** �Ƿ�ע��(1:�ǡ�2:��) */
	private String cancelFlag;
	/** ע����ʼʱ�䣨���cancelFlag=2������ */
	private String registStartCancelDate;
	/** ע������ʱ�䣨���cancelFlag=2������ */
	private String registEndCancelDate;
	/** ����״̬��2:���ڴ���4:�Ѵ��� */
	private String[] caseFlag;
	/** ����ţ�������������ֳ�գ� */
	private String earLabel;
	/** ũ��������������������ֳ��ר�ã� */
	private String fName;
	/** ���֤�ţ���ֲ��ר�ã� */
	private String fCardID;
	/** ũ����������ֲ��ר�ã� */
	private String fName1;
	/** ����ʱ����ʼ */
	private String operateDate;
	/** ����ʱ���ֹ */
	private String operateDateEnd;
	/** ���ִ��� */
	private String riskCategory;
	/** ���� */
	private String queryRiskCode;
	/** ������� */
	private String callInPhoneNumber;
	/** �������� */
	private String engineNo;
	/** ���ܺ� */
	private String frameNo;
	
	
	/** ҳ����Ĭ��1�� */
	private int pageNo;
	/** ÿҳ������Ĭ����ʾ20���� */
	private int recordPerPage;
	public RegistCaseQuery() {
		super();
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getComcode() {
		return comcode;
	}
	public void setComcode(String comcode) {
		this.comcode = comcode;
	}
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	
	public String[] getCaseFlag() {
		return caseFlag;
	}
	public void setCaseFlag(String[] caseFlag) {
		this.caseFlag = caseFlag;
	}
	public String getEarLabel() {
		return earLabel;
	}
	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}
	public String getFName() {
		return fName;
	}
	public void setFName(String name) {
		fName = name;
	}
	public String getFCardID() {
		return fCardID;
	}
	public void setFCardID(String cardID) {
		fCardID = cardID;
	}
	public String getFName1() {
		return fName1;
	}
	public void setFName1(String name1) {
		fName1 = name1;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateDateEnd() {
		return operateDateEnd;
	}
	public void setOperateDateEnd(String operateDateEnd) {
		this.operateDateEnd = operateDateEnd;
	}
	public String getRiskCategory() {
		return riskCategory;
	}
	public void setRiskCategory(String riskCategory) {
		this.riskCategory = riskCategory;
	}
	public String getQueryRiskCode() {
		return queryRiskCode;
	}
	public void setQueryRiskCode(String queryRiskCode) {
		this.queryRiskCode = queryRiskCode;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public String getRegistStartCancelDate() {
		return registStartCancelDate;
	}
	public void setRegistStartCancelDate(String registStartCancelDate) {
		this.registStartCancelDate = registStartCancelDate;
	}
	public String getRegistEndCancelDate() {
		return registEndCancelDate;
	}
	public void setRegistEndCancelDate(String registEndCancelDate) {
		this.registEndCancelDate = registEndCancelDate;
	}
	public String getCallInPhoneNumber() {
		return callInPhoneNumber;
	}
	public void setCallInPhoneNumber(String callInPhoneNumber) {
		this.callInPhoneNumber = callInPhoneNumber;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getFrameNo() {
		return frameNo;
	}
	public void setFrameNo(String frameNo) {
		this.frameNo = frameNo;
	}
	

}
