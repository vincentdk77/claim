package com.sinosoft.claimciplatform.dto.custom;

import java.util.Date;

public class AccidentInfor {
	private String accidentTime;//����ʱ��
	private String accidentPlace="";//���յص�
	private String accidentDesc="";//���վ���
	private String accidentdep=""; //�¹ʴ�����
	private String indemnityDuty=""; //�¹�����
	/**
	 * �¹ʴ�����
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
