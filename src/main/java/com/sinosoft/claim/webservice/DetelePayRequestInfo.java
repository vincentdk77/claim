package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class DetelePayRequestInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** �ͻ����������� */
	private String outId;
	/** �����˴��� */
	private String operatorCode;
	/** ���������� */
	private String operatorName;
	/** �����˻������� */
	private String makeCom;
	/** �����˻������� */
	private String makeComName;
	/** ����ʱ�� */
	private Date operatorDate;
	/** ֧��������� */
	private String handleText;

	public String getOutId() {
		return outId;
	}

	public void setOutId(String outId) {
		this.outId = outId;
	}


	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getMakeCom() {
		return makeCom;
	}

	public void setMakeCom(String makeCom) {
		this.makeCom = makeCom;
	}

	public String getMakeComName() {
		return makeComName;
	}

	public void setMakeComName(String makeComName) {
		this.makeComName = makeComName;
	}

	public Date getOperatorDate() {
		return operatorDate;
	}

	public void setOperatorDate(Date operatorDate) {
		this.operatorDate = operatorDate;
	}

	public String getHandleText() {
		return handleText;
	}

	public void setHandleText(String handleText) {
		this.handleText = handleText;
	}  
	
}
