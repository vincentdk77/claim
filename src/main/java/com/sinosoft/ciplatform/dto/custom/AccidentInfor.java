package com.sinosoft.ciplatform.dto.custom;

import java.util.Date;

public class AccidentInfor {
	private Date accidentTime;//出险时间
	private String accidentPlace="";//出险地点
	private String accidentDesc="";//出险经过
	private String accidentdep=""; //事故处理部门
	private String indemnityDuty=""; //事故责任
	private String handleUnit="";  //事故处理部门
	private String damageTypeCode=""; //事故原因
	private String addressCode=""; //事故地点代码
	private String manageTypeCode = "";//事故处理类型
	private String accidentPlaceCode="";//出险地点唯一标识
	
	//add by liuxin 20080516 start for 北京交强险信息库接口调整
	private String damageAreaCode = "";   //事故管界代码
	//add by liuxin 20080516 end for 北京交强险信息库接口调整
	
	public String getAddressCode() {
		return addressCode;
	}
	public void setAddressCode(String addressCode) {
		this.addressCode = addressCode;
	}
	public String getDamageTypeCode() {
		return damageTypeCode;
	}
	public void setDamageTypeCode(String damageTypeCode) {
		this.damageTypeCode = damageTypeCode;
	}
	public String getHandleUnit() {
		return handleUnit;
	}
	public void setHandleUnit(String handleUnit) {
		this.handleUnit = handleUnit;
	}
	public String getManageTypeCode() {
		return manageTypeCode;
	}
	public void setManageTypeCode(String manageTypeCode) {
		this.manageTypeCode = manageTypeCode;
	}
	/**
	 * 事故处理部门
	 * @return
	 */
	public String getAccidentdep() {
		return accidentdep;
	}
	public void setAccidentdep(String accidentdep) {
		this.accidentdep = accidentdep;
	}
	public String getAccidentDesc() {
		return accidentDesc;
	}
	public void setAccidentDesc(String accidentDesc) {
		this.accidentDesc = accidentDesc;
	}
	public String getAccidentPlace() {
		return accidentPlace;
	}
	public void setAccidentPlace(String accidentPlace) {
		this.accidentPlace = accidentPlace;
	}
	public Date getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(Date accidentTime) {
		this.accidentTime = accidentTime;
	}
	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}
	
    //add by liuxin 20080516 start for 北京交强险信息库接口调整
	public String getDamageAreaCode() {
		return damageAreaCode;
	}
	public void setDamageAreaCode(String damageAreaCode) {
		this.damageAreaCode = damageAreaCode;
	}
	//add by liuxin 20080516 end for 北京交强险信息库接口调整
	
	public String getAccidentPlaceCode() {
		return accidentPlaceCode;
	}
	public void setAccidentPlaceCode(String accidentPlaceCode) {
		this.accidentPlaceCode = accidentPlaceCode;
	}

	
}
