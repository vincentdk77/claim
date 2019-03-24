package com.sinosoft.claimciplatform.dto.custom;

public class CompelCrashAccidentInfor {
	/** 姓名 */
	private String name;

	/** 身份证号 */
	private String idNo;

	/** 车牌号 */
	private String carMark;

	/** 号牌种类 */
	private String vehicleType;

	/** 车型 */
	private String vehicleModel;

	/** 联系电话 */
	private String telNo;

	/** 保险公司代码 */
	private String companyCode;

	/** 保单号 */
	private String policyCode;

	/** 报案号 */
	private String reportNo;

	/** 碰撞损坏部位 */
	private String damagePart;

	public String getCarMark() {
		return carMark;
	}

	public void setCarMark(String carMark) {
		this.carMark = carMark;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getDamagePart() {
		return damagePart;
	}

	public void setDamagePart(String damagePart) {
		this.damagePart = damagePart;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPolicyCode() {
		return policyCode;
	}

	public void setPolicyCode(String policyCode) {
		this.policyCode = policyCode;
	}

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

}
