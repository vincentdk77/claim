package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;
import java.util.List;

import com.sinosoft.claim.dto.domain.PrpLlocklogDto;

public class ReturnAccountsInfo {
	private String AccountsNo="";	            //������
	private String AccountsNoStatus="";			//������״̬
	private String AccountsStartDate="";	    //������ʼʱ��
	private String CompensateComCode="";	    //�Է����չ�˾
	private String CompensationAreaCode="";     //�Է��б�����
	private String CoverageCode="";             //׷��/�帶����
	private String RecoverAmount="";            //׷�����������
	private String CompensateAmount="";         //�帶���������
	private String RecoverCompanyCode="";	    //׷�������չ�˾
	private String RecoverAreaCode=""; 	        //׷�����б�����
	private String RequestType=""; 	        //��������
	private String ResponseCode=""; 	        //
	private String ErrorCode=""; 	        //�������
	private String ErrorMessage=""; 	        //
    private List accountsList = new ArrayList();    //
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
	 * @return the recoverAreaCode
	 */
	public String getRecoverAreaCode() {
		return RecoverAreaCode;
	}
	/**
	 * @param recoverAreaCode the recoverAreaCode to set
	 */
	public void setRecoverAreaCode(String recoverAreaCode) {
		RecoverAreaCode = recoverAreaCode;
	}
	/**
	 * @return the requestType
	 */
	public String getRequestType() {
		return RequestType;
	}
	/**
	 * @param requestType the requestType to set
	 */
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return ResponseCode;
	}
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		ResponseCode = responseCode;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return ErrorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		ErrorCode = errorCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return ErrorMessage;
	}
	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	/**
	 * @return the accountsList
	 */
	public List getAccountsList() {
		return accountsList;
	}
	/**
	 * @param accountsList the accountsList to set
	 */
	public void setAccountsList(List accountsList) {
		this.accountsList = accountsList;
	}
	public void addAccounts(Accounts accounts){
		this.accountsList.add(accounts);
	}
}
