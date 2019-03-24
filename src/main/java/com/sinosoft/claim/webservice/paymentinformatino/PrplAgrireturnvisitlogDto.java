package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

/**
 * 这是PRPLAGRIRETURNVISITLOG的数据传输对象类<br>
 */
public class PrplAgrireturnvisitlogDto extends PrplAgrireturnvisitlogDtoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 属性BYCOMPLAINTCODE 被投诉人*/
    private String bycomplaintcode = "";
    
    /** 属性BYCOMPLAINTCOMCODE 被投诉机构*/
    private String bycomplaintcomcode = "";
    
    /** 属性COMPLAINTDATE 投诉时间*/
    private String complaintdate = "";
    
    /** 属性 接报案人*/
    private String receivername = "";
    
    /** 属性 报案时间(天)*/
    private String stReportDate = "";
    /** 属性 报案时间（时分秒）*/
    private String stReportHour = "";
	
	/**
     *  默认构造方法,构造一个默认的PrplAgrireturnvisitlogDto对象
     */
    public PrplAgrireturnvisitlogDto(){
    	
    }

	public String getBycomplaintcode() {
		return bycomplaintcode;
	}

	public void setBycomplaintcode(String bycomplaintcode) {
		this.bycomplaintcode = bycomplaintcode;
	}

	public String getBycomplaintcomcode() {
		return bycomplaintcomcode;
	}

	public void setBycomplaintcomcode(String bycomplaintcomcode) {
		this.bycomplaintcomcode = bycomplaintcomcode;
	}

	public String getComplaintdate() {
		return complaintdate;
	}

	public void setComplaintdate(String complaintdate) {
		this.complaintdate = complaintdate;
	}

	public String getReceivername() {
		return receivername;
	}

	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}

	public String getStReportDate() {
		return stReportDate;
	}

	public void setStReportDate(String stReportDate) {
		this.stReportDate = stReportDate;
	}

	public String getStReportHour() {
		return stReportHour;
	}

	public void setStReportHour(String stReportHour) {
		this.stReportHour = stReportHour;
	}
    
    
}
