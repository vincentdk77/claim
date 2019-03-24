package com.sinosoft.claim.webservice;

import java.io.Serializable;
import java.util.Date;

public class DetelePayRequestInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** 客户端数据主键 */
	private String outId;
	/** 操作人代码 */
	private String operatorCode;
	/** 操作人名称 */
	private String operatorName;
	/** 操作人机构代码 */
	private String makeCom;
	/** 操作人机构名称 */
	private String makeComName;
	/** 操作时间 */
	private Date operatorDate;
	/** 支付审批意见 */
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
