package com.sinosoft.claimciplatform.dto.custom;

import java.util.Date;

public class AccidentInfor {
	private String accidentTime;//出险时间
	private String accidentPlace="";//出险地点
	private String accidentDesc="";//出险经过
	private String accidentdep=""; //事故处理部门
	private String indemnityDuty=""; //事故责任
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

	public String getIndemnityDuty() {
		return indemnityDuty;
	}
	public void setIndemnityDuty(String indemnityDuty) {
		this.indemnityDuty = indemnityDuty;
	}
	public String getAccidentTime() {
		return accidentTime;
	}
	public void setAccidentTime(String accidentTime) {
		this.accidentTime = accidentTime;
	}

}
