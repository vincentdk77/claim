package com.sinosoft.claim.webservice.paymentinformatino;

import java.io.Serializable;

/**
 * 这是PRPLAGRIRETURNVISITLOG的数据传输对象基类
 * @author Administrator
 *
 */
public class PrplAgrireturnvisitlogDtoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 属性BUSINESSNO */
    private String businessno = "";
    /** 属性REGISTNO */
    private String registno = "";
    /** 属性POLICYNO */
    private String policyno = "";
    /** 属性COMCODE */
    private String comcode = "";
    /** 属性COMCODENAME */
    private String comcodename = "";
    /** 属性INSUREDNAME */
    private String insuredname = "";
    /** 属性HANDLERCODE */
    private String handlercode = "";
    /** 属性HANDLERNAME */
    private String handlername = "";
    /** 属性HANDLERCOMCODE */
    private String handlercomcode = "";
    
    /**
     *  默认构造方法,构造一个默认的PrplAgrireturnvisitlogDtoBase对象
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
