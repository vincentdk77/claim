package com.sinosoft.ciplatform.dto.custom;

import java.util.ArrayList;



public class AccidentBackInfor {

	/** �¹���Ϣ�ϴ����󷵻صĹ���������Ϣ */
	private CompePlatFormRetrunParam compePlatFormRetrunParam;

	/** �¹��� */
	private String accidentNo;

	/** �׷����������¼���� */
	private ArrayList aClaimList;

	/** �ҷ����������¼���� */
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
