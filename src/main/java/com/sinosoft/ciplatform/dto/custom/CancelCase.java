package com.sinosoft.ciplatform.dto.custom;

public class CancelCase {
	private String claimCode="";	      	//�������
	private String policyNO="";			//������
	private String registNo="";			//������
	private String claimNo="";			//������
	private String comCode="";			//��������
	private String confirmSequenceNo=""; 	//Ͷ��ȷ����
	private String cancelDesc=""; //��������
	private String cancelCause=""; //����ע��ԭ��
	private String cancelType="";//����ע������ 1������2����
	
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

	/**
	 * �������
	 * @return
	 */
	public String getClaimCode() {
		return claimCode;
	}

	/**
	 * �����������
	 * @param claimCode
	 */
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	/**
	 * ��������
	 * @return
	 */
	public String getComCode() {
		return comCode;
	}

	/**
	 * ���ù�������
	 * @param claimCode
	 */
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	public String getConfirmSequenceNo() {
		return confirmSequenceNo;
	}
	public void setConfirmSequenceNo(String confirmSequenceNo) {
		this.confirmSequenceNo = confirmSequenceNo;
	}
	public String getCancelCause() {
		return cancelCause;
	}
	public void setCancelCause(String cancelCause) {
		this.cancelCause = cancelCause;
	}
	public String getCancelType() {
		return cancelType;
	}
	public void setCancelType(String cancelType) {
		this.cancelType = cancelType;
	}
}
