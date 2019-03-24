package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * 农家福保险报案主连带被保险人信息
 * @author Administrator
 *
 */
public class RegistInsuredDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**户编号*/
	private String indexCode;
	/**序号*/
	private String serialNo;
	/**主被保险人*/
	private String insuredMainName;
	/**身份证号*/
	private String identifyNumber;
	/**连带被保险人*/
	private String insuredLinkName;
	
	public RegistInsuredDtoInfo() {
		super();
	}
	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getInsuredMainName() {
		return insuredMainName;
	}
	public void setInsuredMainName(String insuredMainName) {
		this.insuredMainName = insuredMainName;
	}
	public String getIdentifyNumber() {
		return identifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		this.identifyNumber = identifyNumber;
	}
	public String getInsuredLinkName() {
		return insuredLinkName;
	}
	public void setInsuredLinkName(String insuredLinkName) {
		this.insuredLinkName = insuredLinkName;
	}
	
	

}
