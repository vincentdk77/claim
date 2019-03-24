package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;


public class Accounts {
	private int SerialNo=0;	                //���
	private String AccountsNo="";	            //������
	private String AccountsNoStatus="";			//������״̬
	private Date AccountDateStart;			//������ʼʱ����
	private Date AccountDateEnd;			//������ʼʱ��ֹ
	private String OppoentCompanyCode="";	    //�Է����չ�˾
	private String OppoentAreaCode=""; 	        //�Է��б�����
	private String CoverageCode="";             //׷��/�帶����
	private String RecoverStatus="";            //׷��/�帶����
	private String RecoverAmountStart="";       //׷�����������
	private String RecoverAmountEnd="";         //׷���������ֹ
	private String CompAmountStart="";          //�帶���������
	private String CompAmountEnd="";            //�帶�������ֹ
	private String recoverCompanyCodes="";	    //׷�������չ�˾
	private String recoverAreaCode=""; 	        //׷�����б�����
	private String recoverComCode=""; 	        //׷�����б�����
	
	
	private String AccountsStartDate="";	    //������ʼʱ��
	private String CompensateComCode="";	    //�Է����չ�˾
	private String CompensationAreaCode="";     //�Է��б�����
	private String RecoverAmount="";            //׷�����������
	private String CompensateAmount="";         //�帶���������
	private String RecoverCompanyCode="";	    //׷�������չ�˾
	private String RecoverAreaCode=""; 	        //׷�����б�����
	
	private String OppoentInsurerCode="";	     //�Է����չ�˾
	private String OppoentInsurerArea="";	     //�Է��б�����
	private String OppoentCoverageCode="";       //�Է�������������
	private String OppoentRegistNo="";           // �Է�������
	private String RecoverComCode="";            //����������������
	private String RecoveryRegistNo="";	         //����������
	private String RecoveryRiskCode=""; 	     //��������
	private String FailureTime="";	             //������ʧЧʱ��
	private String FailureCause=""; 	         //������ʧЧԭ���
	
	
	private String claimCode=""; 	             //�������
	/**
	 * @return the accountsNo
	 */
	public String getAccountsNo() {
		return AccountsNo;
	}
	/**
	 * @param accountsNo the accountsNo to set
	 */
	public void setAccountsNo(String accountsNo) {
		AccountsNo = accountsNo;
	}	
	/**
	 * @return the accountsNoStatus
	 */
	public String getAccountsNoStatus() {
		return AccountsNoStatus;
	}
	/**
	 * @param accountsNoStatus the accountsNoStatus to set
	 */
	public void setAccountsNoStatus(String accountsNoStatus) {
		AccountsNoStatus = accountsNoStatus;
	}
	/**
	 * @return the oppoentCompanyCode
	 */
	public String getOppoentCompanyCode() {
		return OppoentCompanyCode;
	}
	/**
	 * @param oppoentCompanyCode the oppoentCompanyCode to set
	 */
	public void setOppoentCompanyCode(String oppoentCompanyCode) {
		OppoentCompanyCode = oppoentCompanyCode;
	}
	/**
	 * @return the oppoentAreaCode
	 */
	public String getOppoentAreaCode() {
		return OppoentAreaCode;
	}
	/**
	 * @param oppoentAreaCode the oppoentAreaCode to set
	 */
	public void setOppoentAreaCode(String oppoentAreaCode) {
		OppoentAreaCode = oppoentAreaCode;
	}
	/**
	 * @return the coverageCode
	 */
	public String getCoverageCode() {
		return CoverageCode;
	}
	/**
	 * @param coverageCode the coverageCode to set
	 */
	public void setCoverageCode(String coverageCode) {
		CoverageCode = coverageCode;
	}
	/**
	 * @return the recoverStatus
	 */
	public String getRecoverStatus() {
		return RecoverStatus;
	}
	/**
	 * @param recoverStatus the recoverStatus to set
	 */
	public void setRecoverStatus(String recoverStatus) {
		RecoverStatus = recoverStatus;
	}
	/**
	 * @return the recoverAmountStart
	 */
	public String getRecoverAmountStart() {
		return RecoverAmountStart;
	}
	/**
	 * @param recoverAmountStart the recoverAmountStart to set
	 */
	public void setRecoverAmountStart(String recoverAmountStart) {
		RecoverAmountStart = recoverAmountStart;
	}
	/**
	 * @return the recoverAmountEnd
	 */
	public String getRecoverAmountEnd() {
		return RecoverAmountEnd;
	}
	/**
	 * @param recoverAmountEnd the recoverAmountEnd to set
	 */
	public void setRecoverAmountEnd(String recoverAmountEnd) {
		RecoverAmountEnd = recoverAmountEnd;
	}
	/**
	 * @return the compAmountStart
	 */
	public String getCompAmountStart() {
		return CompAmountStart;
	}
	/**
	 * @param compAmountStart the compAmountStart to set
	 */
	public void setCompAmountStart(String compAmountStart) {
		CompAmountStart = compAmountStart;
	}
	/**
	 * @return the compAmountEnd
	 */
	public String getCompAmountEnd() {
		return CompAmountEnd;
	}
	/**
	 * @param compAmountEnd the compAmountEnd to set
	 */
	public void setCompAmountEnd(String compAmountEnd) {
		CompAmountEnd = compAmountEnd;
	}
	/**
	 * @return the recoverCompanyCodes
	 */
	public String getRecoverCompanyCodes() {
		return recoverCompanyCodes;
	}
	/**
	 * @param recoverCompanyCodes the recoverCompanyCodes to set
	 */
	public void setRecoverCompanyCodes(String recoverCompanyCodes) {
		this.recoverCompanyCodes = recoverCompanyCodes;
	}
	/**
	 * @return the recoverAreaCode
	 */
	public String getRecoverAreaCode() {
		return recoverAreaCode;
	}
	/**
	 * @param recoverAreaCode the recoverAreaCode to set
	 */
	public void setRecoverAreaCode(String recoverAreaCode) {
		this.recoverAreaCode = recoverAreaCode;
	}
	/**
	 * @return the recoverComCode
	 */
	public String getRecoverComCode() {
		return recoverComCode;
	}
	/**
	 * @param recoverComCode the recoverComCode to set
	 */
	public void setRecoverComCode(String recoverComCode) {
		this.recoverComCode = recoverComCode;
	}
	/**
	 * @param serialNo the serialNo to set
	 */
	public void setSerialNo(int serialNo) {
		SerialNo = serialNo;
	}
	/**
	 * @return the accountsStartDate
	 */
	public String getAccountsStartDate() {
		return AccountsStartDate;
	}
	/**
	 * @param accountsStartDate the accountsStartDate to set
	 */
	public void setAccountsStartDate(String accountsStartDate) {
		AccountsStartDate = accountsStartDate;
	}
	/**
	 * @return the compensateComCode
	 */
	public String getCompensateComCode() {
		return CompensateComCode;
	}
	/**
	 * @param compensateComCode the compensateComCode to set
	 */
	public void setCompensateComCode(String compensateComCode) {
		CompensateComCode = compensateComCode;
	}
	/**
	 * @return the compensationAreaCode
	 */
	public String getCompensationAreaCode() {
		return CompensationAreaCode;
	}
	/**
	 * @param compensationAreaCode the compensationAreaCode to set
	 */
	public void setCompensationAreaCode(String compensationAreaCode) {
		CompensationAreaCode = compensationAreaCode;
	}
	/**
	 * @return the recoverAmount
	 */
	public String getRecoverAmount() {
		return RecoverAmount;
	}
	/**
	 * @param recoverAmount the recoverAmount to set
	 */
	public void setRecoverAmount(String recoverAmount) {
		RecoverAmount = recoverAmount;
	}
	/**
	 * @return the compensateAmount
	 */
	public String getCompensateAmount() {
		return CompensateAmount;
	}
	/**
	 * @param compensateAmount the compensateAmount to set
	 */
	public void setCompensateAmount(String compensateAmount) {
		CompensateAmount = compensateAmount;
	}
	/**
	 * @return the recoverCompanyCode
	 */
	public String getRecoverCompanyCode() {
		return RecoverCompanyCode;
	}
	/**
	 * @param recoverCompanyCode the recoverCompanyCode to set
	 */
	public void setRecoverCompanyCode(String recoverCompanyCode) {
		RecoverCompanyCode = recoverCompanyCode;
	}
	/**
	 * @return the serialNo
	 */
	public int getSerialNo() {
		return SerialNo;
	}
	/**
	 * @return the oppoentInsurerCode
	 */
	public String getOppoentInsurerCode() {
		return OppoentInsurerCode;
	}
	/**
	 * @param oppoentInsurerCode the oppoentInsurerCode to set
	 */
	public void setOppoentInsurerCode(String oppoentInsurerCode) {
		OppoentInsurerCode = oppoentInsurerCode;
	}
	/**
	 * @return the oppoentInsurerArea
	 */
	public String getOppoentInsurerArea() {
		return OppoentInsurerArea;
	}
	/**
	 * @param oppoentInsurerArea the oppoentInsurerArea to set
	 */
	public void setOppoentInsurerArea(String oppoentInsurerArea) {
		OppoentInsurerArea = oppoentInsurerArea;
	}
	/**
	 * @return the oppoentCoverageCode
	 */
	public String getOppoentCoverageCode() {
		return OppoentCoverageCode;
	}
	/**
	 * @param oppoentCoverageCode the oppoentCoverageCode to set
	 */
	public void setOppoentCoverageCode(String oppoentCoverageCode) {
		OppoentCoverageCode = oppoentCoverageCode;
	}
	/**
	 * @return the oppoentRegistNo
	 */
	public String getOppoentRegistNo() {
		return OppoentRegistNo;
	}
	/**
	 * @param oppoentRegistNo the oppoentRegistNo to set
	 */
	public void setOppoentRegistNo(String oppoentRegistNo) {
		OppoentRegistNo = oppoentRegistNo;
	}
	/**
	 * @return the recoveryRegistNo
	 */
	public String getRecoveryRegistNo() {
		return RecoveryRegistNo;
	}
	/**
	 * @param recoveryRegistNo the recoveryRegistNo to set
	 */
	public void setRecoveryRegistNo(String recoveryRegistNo) {
		RecoveryRegistNo = recoveryRegistNo;
	}
	/**
	 * @return the recoveryRiskCode
	 */
	public String getRecoveryRiskCode() {
		return RecoveryRiskCode;
	}
	/**
	 * @param recoveryRiskCode the recoveryRiskCode to set
	 */
	public void setRecoveryRiskCode(String recoveryRiskCode) {
		RecoveryRiskCode = recoveryRiskCode;
	}
	/**
	 * @return the failureTime
	 */
	public String getFailureTime() {
		return FailureTime;
	}
	/**
	 * @param failureTime the failureTime to set
	 */
	public void setFailureTime(String failureTime) {
		FailureTime = failureTime;
	}
	/**
	 * @return the failureCause
	 */
	public String getFailureCause() {
		return FailureCause;
	}
	/**
	 * @param failureCause the failureCause to set
	 */
	public void setFailureCause(String failureCause) {
		FailureCause = failureCause;
	}
	/**
	 * @return the claimCode
	 */
	public String getClaimCode() {
		return claimCode;
	}
	/**
	 * @param claimCode the claimCode to set
	 */
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	/**
	 * @return the accountDateStart
	 */
	public Date getAccountDateStart() {
		return AccountDateStart;
	}
	/**
	 * @param accountDateStart the accountDateStart to set
	 */
	public void setAccountDateStart(Date accountDateStart) {
		AccountDateStart = accountDateStart;
	}
	/**
	 * @return the accountDateEnd
	 */
	public Date getAccountDateEnd() {
		return AccountDateEnd;
	}
	/**
	 * @param accountDateEnd the accountDateEnd to set
	 */
	public void setAccountDateEnd(Date accountDateEnd) {
		AccountDateEnd = accountDateEnd;
	}
	

}
