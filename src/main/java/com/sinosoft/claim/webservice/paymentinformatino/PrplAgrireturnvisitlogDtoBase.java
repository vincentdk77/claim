package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

/**
 * ����PRPLAGRIRETURNVISITLOG�����ݴ���������
 * @author Administrator
 *
 */
public class PrplAgrireturnvisitlogDtoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** ����BUSINESSNO */
    private String businessno = "";
    /** ����REGISTNO */
    private String registno = "";
    /** ����POLICYNO */
    private String policyno = "";
    /** ����COMCODE */
    private String comcode = "";
    /** ����COMCODENAME */
    private String comcodename = "";
    /** ����INSUREDNAME */
    private String insuredname = "";
    /** ����HANDLERCODE */
    private String handlercode = "";
    /** ����HANDLERNAME */
    private String handlername = "";
    /** ����HANDLERCOMCODE */
    private String handlercomcode = "";
    
    /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�PrplAgrireturnvisitlogDtoBase����
     */
    public PrplAgrireturnvisitlogDtoBase(){
    }

	public String getBusinessno() {
		return businessno;
	}

	public void setBusinessno(String businessno) {
		this.businessno = businessno;
	}

	public String getRegistno() {
		return registno;
	}

	public void setRegistno(String registno) {
		this.registno = registno;
	}

	public String getPolicyno() {
		return policyno;
	}

	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public String getComcodename() {
		return comcodename;
	}

	public void setComcodename(String comcodename) {
		this.comcodename = comcodename;
	}

	public String getInsuredname() {
		return insuredname;
	}

	public void setInsuredname(String insuredname) {
		this.insuredname = insuredname;
	}

	public String getHandlercode() {
		return handlercode;
	}

	public void setHandlercode(String handlercode) {
		this.handlercode = handlercode;
	}

	public String getHandlername() {
		return handlername;
	}

	public void setHandlername(String handlername) {
		this.handlername = handlername;
	}

	public String getHandlercomcode() {
		return handlercomcode;
	}

	public void setHandlercomcode(String handlercomcode) {
		this.handlercomcode = handlercomcode;
	}
    
    
}
