package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class PolicyListRequestInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** ������ */
	private String policyNo;
	/**�����Ų�ѯ������־*/
	private String policyNoFlag;
	/** ������������ */
	private String insuredName;
	/** ���֤�� */
	private String identifyNumber;
	/** ���֤�Ų�ѯ������־ */
	private String identifyNumberFlag;
	/** �������� */
	private String startDate;
	/** ����ֹ�� */
	private String endDate;
	/** ���ִ��� */
	private String riskType;
	/** ԭ������ */
	private String oldPolicyNo;
	/** ������ˮ�� */
	private String policyNoPrintNo;
	/** ����ţ�(������������ֳ��ר��) */
	private String earLabel;
	/** ����Ų�ѯ������־��(������������ֳ��ר��) ��=��Ϊ��ȷ��ѯ����*��Ϊģ����ѯ Ĭ��Ϊģ����ѯ **/
	private String earLabelFlag;
	/** ũ��������(������������ֳ��ר��) */
	private String fname;
	/** ���֤�ţ�(��ֲ��ר��) */
	private String fCardID;
	/** ���֤�Ų�ѯ������־��(��ֲ��ר��)*/
	private String  fCardIDFlag;
	/** ũ��������(��ֲ��ר��) */
	private String fname1;
	/** ����ţ�(ũ�Ҹ���ϱ���ר��) */
	private String familyNo;
	/** ����Ų�ѯ������־��(ũ�Ҹ���ϱ���ר��) */
	private String familyNoFlag;
	/** �������֤�ţ�(ũ�Ҹ���ϱ���ר��) */
	private String familyFIDCard;
	/** �������֤�Ų�ѯ������־ ��(ũ�Ҹ���ϱ���ר��)*/
	private String familyFIDCardFlag;
	/** �����������������˺���ר�ã� */
	private String insuredName_2743;
	/** ���֤�ţ������������˺���ר�ã� */
	private String identifyNumber_2743;
	/** ���֤�Ų�ѯ������־�������������˺���ר�ã� */
	private String identifyNumber_2743Flag;
	/** ���ũ���յĸ��Ի����� */
	private String identifyNumberSign_0310;
	/**ũ����ѯ������־*/
	private String identifyNumberSign_0310Flag;
	/** ����������� */
	private String areasCode;
	/** ������Ա */
	private String userCode;
	/** �������� */
	private String comCode;
	/** ��ǰҳ�� */
	private int pageNo;
	/** ÿҳ���� Ĭ����ʾ20�� */
	private int recordPerPage;
	/** ���֤�ţ����������������˺�����ר�ã� */
	private String identifyNumber_2714;
	/** ���������� */
	private String areaFlag;//0�������Ϲ������� 1�������¹�������
    /** ��������㼶 */
	private String areaLevel;
	

	public String getIdentifyNumber_2714() {
		return identifyNumber_2714;
	}

	public void setIdentifyNumber_2714(String identifyNumber_2714) {
		this.identifyNumber_2714 = identifyNumber_2714;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredName() {
		return insuredName;
	}

	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}

	public String getIdentifyNumber() {
		return identifyNumber;
	}

	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getOldPolicyNo() {
		return oldPolicyNo;
	}

	public void setOldPolicyNo(String oldPolicyNo) {
		this.oldPolicyNo = oldPolicyNo;
	}

	public String getPolicyNoPrintNo() {
		return policyNoPrintNo;
	}

	public void setPolicyNoPrintNo(String policyNoPrintNo) {
		this.policyNoPrintNo = policyNoPrintNo;
	}

	public String getEarLabel() {
		return earLabel;
	}

	public void setEarLabel(String earLabel) {
		this.earLabel = earLabel;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFCardID() {
		return fCardID;
	}

	public void setFCardID(String cardID) {
		fCardID = cardID;
	}

	public String getFname1() {
		return fname1;
	}

	public void setFname1(String fname1) {
		this.fname1 = fname1;
	}

	public String getFamilyNo() {
		return familyNo;
	}

	public void setFamilyNo(String familyNo) {
		this.familyNo = familyNo;
	}

	public String getFamilyFIDCard() {
		return familyFIDCard;
	}

	public void setFamilyFIDCard(String familyFIDCard) {
		this.familyFIDCard = familyFIDCard;
	}

	public String getInsuredName_2743() {
		return insuredName_2743;
	}

	public void setInsuredName_2743(String insuredName_2743) {
		this.insuredName_2743 = insuredName_2743;
	}

	public String getIdentifyNumber_2743() {
		return identifyNumber_2743;
	}

	public void setIdentifyNumber_2743(String identifyNumber_2743) {
		this.identifyNumber_2743 = identifyNumber_2743;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getComCode() {
		return comCode;
	}

	public void setComCode(String comCode) {
		this.comCode = comCode;
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

	public String getIdentifyNumberSign_0310() {
		return identifyNumberSign_0310;
	}

	public void setIdentifyNumberSign_0310(String identifyNumberSign_0310) {
		this.identifyNumberSign_0310 = identifyNumberSign_0310;
	}

	public String getAreasCode() {
		return areasCode;
	}

	public void setAreasCode(String areasCode) {
		this.areasCode = areasCode;
	}

	public String getPolicyNoFlag() {
		return policyNoFlag;
	}

	public void setPolicyNoFlag(String policyNoFlag) {
		this.policyNoFlag = policyNoFlag;
	}

	public String getIdentifyNumberFlag() {
		return identifyNumberFlag;
	}

	public void setIdentifyNumberFlag(String identifyNumberFlag) {
		this.identifyNumberFlag = identifyNumberFlag;
	}

	public String getFCardIDFlag() {
		return fCardIDFlag;
	}

	public void setFCardIDFlag(String cardIDFlag) {
		fCardIDFlag = cardIDFlag;
	}

	public String getFamilyNoFlag() {
		return familyNoFlag;
	}

	public void setFamilyNoFlag(String familyNoFlag) {
		this.familyNoFlag = familyNoFlag;
	}

	public String getFamilyFIDCardFlag() {
		return familyFIDCardFlag;
	}

	public void setFamilyFIDCardFlag(String familyFIDCardFlag) {
		this.familyFIDCardFlag = familyFIDCardFlag;
	}

	public String getIdentifyNumber_2743Flag() {
		return identifyNumber_2743Flag;
	}

	public void setIdentifyNumber_2743Flag(String identifyNumber_2743Flag) {
		this.identifyNumber_2743Flag = identifyNumber_2743Flag;
	}

	public String getIdentifyNumberSign_0310Flag() {
		return identifyNumberSign_0310Flag;
	}

	public void setIdentifyNumberSign_0310Flag(String identifyNumberSign_0310Flag) {
		this.identifyNumberSign_0310Flag = identifyNumberSign_0310Flag;
	}

	public String getEarLabelFlag() {
		return earLabelFlag;
	}

	public void setEarLabelFlag(String earLabelFlag) {
		this.earLabelFlag = earLabelFlag;
	}

	public String getAreaFlag() {
		return areaFlag;
	}

	public void setAreaFlag(String areaFlag) {
		this.areaFlag = areaFlag;
	}

	public String getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(String areaLevel) {
		this.areaLevel = areaLevel;
	}
	
	
}
