package com.sinosoft.claim.webservice;

public class PropInfo {
	/** 属性报案号 */
	private String registNo = "";
	/** 属性序号 */
	private int serialNo = 0;
	/** 财产损失部位名称 */
	private String lossItemName = "";
	/** 损失程度描述*/
	private String lossItemDesc = "";
	/** 险别代码 */
	private String kindCode = "";
	/** 损失金额 */
	private double lossAmount = 0;
	
	public PropInfo() {
		
	}

	public String getRegistNo() {
		return registNo;
	}

	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}


	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getKindCode() {
		return kindCode;
	}

	public void setKindCode(String kindCode) {
		this.kindCode = kindCode;
	}

	public double getLossAmount() {
		return lossAmount;
	}

	public void setLossAmount(double lossAmount) {
		this.lossAmount = lossAmount;
	}

	public String getLossItemName() {
		return lossItemName;
	}

	public void setLossItemName(String lossItemName) {
		this.lossItemName = lossItemName;
	}

	public String getLossItemDesc() {
		return lossItemDesc;
	}

	public void setLossItemDesc(String lossItemDesc) {
		this.lossItemDesc = lossItemDesc;
	}

	
}
