package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerQueryDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/** 班表机构代码 */
	private String deptCode = "";
	/** 班表机构名称 */
	private String deptName = "";
	/** 当班人员代码 */
	private String handlerCode = "";
	/** 当班人员姓名 */
	private String handlerName = "";
	/** 班表月份 */
	private String month = "";
	/** 险类 */
	private String classcode = "";
	/** 维护人员 */
	private String operator = "";
	/** 维护时间 */
	private String modifytime = "";

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getHandlerCode() {
		return handlerCode;
	}

	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}

	public String getHandlerName() {
		return handlerName;
	}

	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getModifytime() {
		return modifytime;
	}

	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

}
