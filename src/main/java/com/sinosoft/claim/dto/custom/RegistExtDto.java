package com.sinosoft.claim.dto.custom;

import java.io.Serializable;

public class RegistExtDto implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 序号 */
	private String serialno;
	/** 时间 */
	private String inputDate;
	/** 小时 */
	private String inputHour;
	/** 操作员 */
	private String operatorCode;
	/** 内容 */
	private String context;

	public String getSerialno() {
		return serialno;
	}

	public void setSerialno(String serialno) {
		this.serialno = serialno;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getInputHour() {
		return inputHour;
	}

	public void setInputHour(String inputHour) {
		this.inputHour = inputHour;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

}
