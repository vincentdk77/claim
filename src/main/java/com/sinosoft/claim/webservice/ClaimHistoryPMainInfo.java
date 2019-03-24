package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimHistoryPMainInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 批单号码 */
	private String endorseNo = "";
	/** 核批完成日期 */
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
