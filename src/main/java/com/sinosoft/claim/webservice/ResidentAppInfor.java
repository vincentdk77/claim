package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.claim.webservice.ResidentAppInforList;



public class ResidentAppInfor implements Serializable{
	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private ResidentAppInforList[] residentAppInforList;
    public ResidentAppInfor(){
		
	}
	public ResidentAppInforList[] getResidentAppInforList() {
		return residentAppInforList;
	}
	public void setResidentAppInforList(ResidentAppInforList[] residentAppInforList) {
		this.residentAppInforList = residentAppInforList;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
