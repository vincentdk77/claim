package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * 这是PRPLAGRIRETURNVISIT的数据传输对象基类
 * @author Administrator
 *
 */
public class PrplagrireturnvisitDtoBase implements Serializable {
	    private static final long serialVersionUID = 1L;
	    /** 属性REGISTNO */
	    private String businessNo = "";
        /** 属性SERIALNO */
	    private String serialno = "";
	    /** 属性CONTACT */
	    private String contact = "";
	    /** 属性RECORDERNO */
	    private String recorderno = "";
	    /** 属性SERVICE */
	    private String service = "";
	    /** 属性EXISTISSUE */
	    private String existissue = "";
	    /** 属性VISITSUCCESS */
	    private String visitsuccess = "";
	    /** 属性VISITNOCAUSE */
	    private String visitnocause = "";
	    /** 属性VISITOPINION */
	    private String visitopinion = "";
	    /** 属性ENTERINGCODE */
	    private String enteringcode = "";
	    /** 属性ENTERINGNAME */
	    private String enteringname = "";
	    /** 属性ENTERINGCOMCODE */
	    private String enteringcomcode = "";
	    /** 属性ENTERINGTIME */
	    private DateTime enteringtime = new DateTime();
	    
	    
	    /**
	     *  默认构造方法,构造一个默认的PrplagrireturnvisitDtoBase对象
	     */
	    public PrplagrireturnvisitDtoBase(){
	    	
	    }


		public String getBusinessNo() {
			return businessNo;
		}


		public void setBusinessNo(String businessNo) {
			this.businessNo = businessNo;
		}


		public String getSerialno() {
			return serialno;
		}


		public void setSerialno(String serialno) {
			this.serialno = serialno;
		}


		public String getContact() {
			return contact;
		}


		public void setContact(String contact) {
			this.contact = contact;
		}


		public String getRecorderno() {
			return recorderno;
		}


		public void setRecorderno(String recorderno) {
			this.recorderno = recorderno;
		}


		public String getService() {
			return service;
		}


		public void setService(String service) {
			this.service = service;
		}


		public String getExistissue() {
			return existissue;
		}


		public void setExistissue(String existissue) {
			this.existissue = existissue;
		}


		public String getVisitsuccess() {
			return visitsuccess;
		}


		public void setVisitsuccess(String visitsuccess) {
			this.visitsuccess = visitsuccess;
		}


		public String getVisitnocause() {
			return visitnocause;
		}


		public void setVisitnocause(String visitnocause) {
			this.visitnocause = visitnocause;
		}


		public String getVisitopinion() {
			return visitopinion;
		}


		public void setVisitopinion(String visitopinion) {
			this.visitopinion = visitopinion;
		}


		public String getEnteringcode() {
			return enteringcode;
		}


		public void setEnteringcode(String enteringcode) {
			this.enteringcode = enteringcode;
		}


		public String getEnteringname() {
			return enteringname;
		}


		public void setEnteringname(String enteringname) {
			this.enteringname = enteringname;
		}


		public String getEnteringcomcode() {
			return enteringcomcode;
		}


		public void setEnteringcomcode(String enteringcomcode) {
			this.enteringcomcode = enteringcomcode;
		}


		public DateTime getEnteringtime() {
			return enteringtime;
		}


		public void setEnteringtime(DateTime enteringtime) {
			this.enteringtime = enteringtime;
		}
	    
	    
}
