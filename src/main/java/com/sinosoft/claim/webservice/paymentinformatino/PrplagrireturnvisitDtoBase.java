package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * ����PRPLAGRIRETURNVISIT�����ݴ���������
 * @author Administrator
 *
 */
public class PrplagrireturnvisitDtoBase implements Serializable {
	    private static final long serialVersionUID = 1L;
	    /** ����REGISTNO */
	    private String businessNo = "";
        /** ����SERIALNO */
	    private String serialno = "";
	    /** ����CONTACT */
	    private String contact = "";
	    /** ����RECORDERNO */
	    private String recorderno = "";
	    /** ����SERVICE */
	    private String service = "";
	    /** ����EXISTISSUE */
	    private String existissue = "";
	    /** ����VISITSUCCESS */
	    private String visitsuccess = "";
	    /** ����VISITNOCAUSE */
	    private String visitnocause = "";
	    /** ����VISITOPINION */
	    private String visitopinion = "";
	    /** ����ENTERINGCODE */
	    private String enteringcode = "";
	    /** ����ENTERINGNAME */
	    private String enteringname = "";
	    /** ����ENTERINGCOMCODE */
	    private String enteringcomcode = "";
	    /** ����ENTERINGTIME */
	    private DateTime enteringtime = new DateTime();
	    
	    
	    /**
	     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplagrireturnvisitDtoBase����
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
