package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

/**
 * ����PRPLAGRIRETURNVISITLOG�����ݴ��������<br>
 */
public class PrplAgrireturnvisitlogDto extends PrplAgrireturnvisitlogDtoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ����BYCOMPLAINTCODE ��Ͷ����*/
    private String bycomplaintcode = "";
    
    /** ����BYCOMPLAINTCOMCODE ��Ͷ�߻���*/
    private String bycomplaintcomcode = "";
    
    /** ����COMPLAINTDATE Ͷ��ʱ��*/
    private String complaintdate = "";
    
    /** ���� �ӱ�����*/
    private String receivername = "";
    
    /** ���� ����ʱ��(��)*/
    private String stReportDate = "";
    /** ���� ����ʱ�䣨ʱ���룩*/
    private String stReportHour = "";
	
	/**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplAgrireturnvisitlogDto����
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
