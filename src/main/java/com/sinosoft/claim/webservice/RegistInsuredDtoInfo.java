package com.sinosoft.claim.webservice;

import java.io.Serializable;

/**
 * ũ�Ҹ����ձ�������������������Ϣ
 * @author Administrator
 *
 */
public class RegistInsuredDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**�����*/
	private String indexCode;
	/**���*/
	private String serialNo;
	/**����������*/
	private String insuredMainName;
	/**���֤��*/
	private String identifyNumber;
	/**������������*/
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
