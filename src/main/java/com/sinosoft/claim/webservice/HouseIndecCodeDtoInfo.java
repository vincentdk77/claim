package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class HouseIndecCodeDtoInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**姓名 */
	private String name = "";
	/**农户身份证号 */
	private String fidCard = "";
	/**户编号 */
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
