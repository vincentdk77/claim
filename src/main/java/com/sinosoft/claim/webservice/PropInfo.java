package com.sinosoft.claim.webservice;

public class PropInfo {
	/** ���Ա����� */
	private String registNo = "";
	/** ������� */
	private int serialNo = 0;
	/** �Ʋ���ʧ��λ���� */
	private String lossItemName = "";
	/** ��ʧ�̶�����*/
	private String lossItemDesc = "";
	/** �ձ���� */
	private String kindCode = "";
	/** ��ʧ��� */
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
