package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * ���������ѯ�ӿ�  ��ѯ�����б�� ������Ϣ��������Ϣ
 * @author Administrator
 *
 */

public class RegistCaseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	/** ����״̬ */
	private String caseFlag;
	/** ������ */
	private String registNo;
	/** ������ */
	private String policyNo;
	/** ������������ */
	private String insuredName;
	/** �ӱ�����Ա���� */
	private String operateName;
	/** ����ʱ�� */
	private String operateDate;
	public RegistCaseDto() {
		super();
	}
	public String getCaseFlag() {
		return caseFlag;
	}
	public void setCaseFlag(String caseFlag) {
		this.caseFlag = caseFlag;
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
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateName() {
		return operateName;
	}
	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}
	
}
