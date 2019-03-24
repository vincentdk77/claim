package com.sinosoft.claim.dto.custom;

import java.io.Serializable;


public class HospTimeListingDto implements Serializable
{
	private String compensateNo;
	private String townName;
	private String address;
	private String insuredName;
	private String content;
	private String fee;
	private String quFee;
	private String anxinFee;
	private String payFee;
	
	public String getCompensateNo(){
		return compensateNo;
	}
	
	public void setCompensateNo(String compensateNo){
		this.compensateNo = compensateNo;
	}
	
	public String getTownName(){
		return townName;
	}
	
	public void setTownName(String townName){
		this.townName = townName;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getInsuredName(){
		return insuredName;
	}
	
	public void setInsuredName(String insuredName){
		this.insuredName = insuredName;
	}
	
	public String getContent(){
		return content;
	}
	
	public void setContent(String content){
		this.content = content;
	}
	
	public String getFee(){
		return fee;
	}
	
	public void setFee(String fee){
		this.fee = fee;
	}
	
	public String getQuFee(){
		return quFee;
	}
	
	public void setQuFee(String quFee){
		this.quFee = quFee;
	}
	
	public String getAnxinFee(){
		return anxinFee;
	}
	
	public void setAnxinFee(String anxinFee){
		this.anxinFee = anxinFee;
	}
	
	public String getPayFee(){
		return payFee;
	}
	
	public void setPayFee(String payFee){
		this.payFee = payFee;
	}
}