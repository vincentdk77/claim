package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class HouseIndecCodeDtoInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**���� */
	private String name = "";
	/**ũ�����֤�� */
	private String fidCard = "";
	/**����� */
	private String indexCode = "";
	
	public HouseIndecCodeDtoInfo() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFidCard() {
		return fidCard;
	}
	public void setFidCard(String fidCard) {
		this.fidCard = fidCard;
	}
	public String getIndexCode() {
		return indexCode;
	}
	public void setIndexCode(String indexCode) {
		this.indexCode = indexCode;
	}
	
}
