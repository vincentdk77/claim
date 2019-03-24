package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class HousepolicyDetailDtoInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/**农户姓名 */
	private String name;
	/**农户身份证号 */
	private String fidCard;
	/**户口簿 */
	private String huKouBu;
	/**农户地址 */
	private String address;
	/**联系电话 */
	private String phone;
	/**估损金额 */
	private String claimLoss = "0";
	/**处理中(Y：是  N：否) */
	private String handleType;
	/**楼房层数 */
	private String floor;
	/**楼房间数 */
	private String buildIngNumber;
	/**砖墙间数 */
	private String zhuanNumber;
	/**土墙间数 */
	private String waNumber;
	/**其他间数 */
	private String otherNumber;
	/**单建厨房间数 */
	private String kitchenNumber;
	/**备注 */
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
