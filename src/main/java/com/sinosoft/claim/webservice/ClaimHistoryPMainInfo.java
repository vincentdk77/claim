package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimHistoryPMainInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** �������� */
	private String endorseNo = "";
	/** ����������� */
	private String underWriteEndDate = "";

	public String getEndorseNo() {
		return endorseNo;
	}

	public void setEndorseNo(String endorseNo) {
		this.endorseNo = endorseNo;
	}

	public String getUnderWriteEndDate() {
		return underWriteEndDate;
	}

	public void setUnderWriteEndDate(String underWriteEndDate) {
		this.underWriteEndDate = underWriteEndDate;
	}
}
