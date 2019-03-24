package com.sinosoft.claimprop;

public class PropReturnInfo {
	private String requestType=""; //��������
	private String claimStatus=""; //����״̬
	private String sendContext = "";			//���͸�ƽ̨�ı���
	private String returnContext = "";			//ƽ̨���صı���
	private String returnType=""; //ƽ̨��������
	private String errorCode="";//�������
	private String errorMessage="";//��������	
	private String claimCode="";//�������	
	private String cancellationNo="";//����ע�����ر���	
	
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getSendContext() {
		return sendContext;
	}
	public void setSendContext(String sendContext) {
		this.sendContext = sendContext;
	}
	public String getReturnContext() {
		return returnContext;
	}
	public void setReturnContext(String returnContext) {
		this.returnContext = returnContext;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getClaimCode() {
		return claimCode;
	}
	public void setClaimCode(String claimCode) {
		this.claimCode = claimCode;
	}
	public String getCancellationNo() {
		return cancellationNo;
	}
	public void setCancellationNo(String cancellationNo) {
		this.cancellationNo = cancellationNo;
	}
	
}
