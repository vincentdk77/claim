package com.sinosoft.claimzy.dto.domain;
/**
 * ��ѯ����Ҫ�ϴ���������
 * @author CDB
 *
 */
public class UploadData {
	/* ���� ������ */
	private String registNo = "";
	/* ���� ������ */
	private String claimNo = "";
	/* ���� ������ */
	private String policyNo = "";
	/* ���� �ⰸ�� */
	private String caseNo = "";
	/* ���� Ԥ�ⰸ�� */
	private String preCompensateNo = "";
	/* ���� ��������� */
	private String compensateNo = "";
	/*���� ���κ�*/
	private String batchNo = "";
	/*���� ҵ���*/
	private String businessNo = "";
	/*���� �ϴ���־*/
	private String flag = "";
	/*���� ҵ��ӿ�����*/
	private String businessType = "";

    public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
     * ���췽��
     */
	public UploadData() {

	}

	/**
	 * ��ȡ���� registNo
	 * 
	 * @return the registNo
	 */
	public String getRegistNo() {
		return registNo;
	}

	/**
	 * �������� registNo
	 * 
	 * @param registNo
	 *            the registNo to set
	 */
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}

	/**
	 * ��ȡ���� claimNo
	 * 
	 * @return the claimNo
	 */
	public String getClaimNo() {
		return claimNo;
	}

	/**
	 * �������� claimNo
	 * 
	 * @param claimNo
	 *            the claimNo to set
	 */
	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	
	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getPreCompensateNo() {
		return preCompensateNo;
	}

	public void setPreCompensateNo(String preCompensateNo) {
		this.preCompensateNo = preCompensateNo;
	}

	public String getCompensateNo() {
		return compensateNo;
	}

	public void setCompensateNo(String compensateNo) {
		this.compensateNo = compensateNo;

	}
	
}