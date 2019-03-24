package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class HousepolicyDetailDtoInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**ũ������ */
	private String name;
	/**ũ�����֤�� */
	private String fidCard;
	/**���ڲ� */
	private String huKouBu;
	/**ũ����ַ */
	private String address;
	/**��ϵ�绰 */
	private String phone;
	/**������ */
	private String claimLoss = "0";
	/**������(Y����  N����) */
	private String handleType;
	/**¥������ */
	private String floor;
	/**¥������ */
	private String buildIngNumber;
	/**שǽ���� */
	private String zhuanNumber;
	/**��ǽ���� */
	private String waNumber;
	/**�������� */
	private String otherNumber;
	/**������������ */
	private String kitchenNumber;
	/**��ע */
	private String remark;
	
	public HousepolicyDetailDtoInfo() {
		
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

	public String getHuKouBu() {
		return huKouBu;
	}

	public void setHuKouBu(String huKouBu) {
		this.huKouBu = huKouBu;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getClaimLoss() {
		return claimLoss;
	}

	public void setClaimLoss(String claimLoss) {
		this.claimLoss = claimLoss;
	}

	public String getHandleType() {
		return handleType;
	}

	public void setHandleType(String handleType) {
		this.handleType = handleType;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getBuildIngNumber() {
		return buildIngNumber;
	}

	public void setBuildIngNumber(String buildIngNumber) {
		this.buildIngNumber = buildIngNumber;
	}

	public String getZhuanNumber() {
		return zhuanNumber;
	}

	public void setZhuanNumber(String zhuanNumber) {
		this.zhuanNumber = zhuanNumber;
	}

	public String getWaNumber() {
		return waNumber;
	}

	public void setWaNumber(String waNumber) {
		this.waNumber = waNumber;
	}

	public String getOtherNumber() {
		return otherNumber;
	}

	public void setOtherNumber(String otherNumber) {
		this.otherNumber = otherNumber;
	}

	public String getKitchenNumber() {
		return kitchenNumber;
	}

	public void setKitchenNumber(String kitchenNumber) {
		this.kitchenNumber = kitchenNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
