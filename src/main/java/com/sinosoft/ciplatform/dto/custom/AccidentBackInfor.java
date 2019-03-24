package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;



public class AccidentBackInfor {

	/** 事故信息上传请求返回的公共部分信息 */
	private CompePlatFormRetrunParam compePlatFormRetrunParam;

	/** 事故码 */
	private String accidentNo;

	/** 甲方车辆理赔记录部分 */
	private ArrayList aClaimList;

	/** 乙方车辆理赔记录部分 */
	private ArrayList bClaimList;

	public String getAccidentNo() {
		return accidentNo;
	}

	public void setAccidentNo(String accidentNo) {
		this.accidentNo = accidentNo;
	}

	public ArrayList getAClaimList() {
		return aClaimList;
	}

	public void setAClaimList(ArrayList claimList) {
		aClaimList = claimList;
	}

	public ArrayList getBClaimList() {
		return bClaimList;
	}

	public void setBClaimList(ArrayList claimList) {
		bClaimList = claimList;
	}

	public CompePlatFormRetrunParam getCompePlatFormRetrunParam() {
		return compePlatFormRetrunParam;
	}

	public void setCompePlatFormRetrunParam(
			CompePlatFormRetrunParam compePlatFormRetrunParam) {
		this.compePlatFormRetrunParam = compePlatFormRetrunParam;
	}

}
