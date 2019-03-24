package com.sinosoft.claimprop;

public class PropReturnInfo {
	private String requestType=""; //请求类型
	private String claimStatus=""; //理赔状态
	private String sendContext = "";			//发送给平台的报文
	private String returnContext = "";			//平台返回的报文
	private String returnType=""; //平台返回类型
	private String errorCode="";//错误代码
	private String errorMessage="";//错误描述	
	private String claimCode="";//理赔编码	
	private String cancellationNo="";//理赔注销返回编码	
	
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
