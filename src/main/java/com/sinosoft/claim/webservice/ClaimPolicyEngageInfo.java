package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimPolicyEngageInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** Ãû³Æ */
	private String clauseName;
	/** ´úÂë */
	private String clauseCode;
	/** ÄÚÈÝ */
	private String clausesContext;

	public String getClauseName() {
		return clauseName;
	}

	public void setClauseName(String clauseName) {
		this.clauseName = clauseName;
	}

	public String getClauseCode() {
		return clauseCode;
	}

	public void setClauseCode(String clauseCode) {
		this.clauseCode = clauseCode;
	}

	public String getClausesContext() {
		return clausesContext;
	}

	public void setClausesContext(String clausesContext) {
		this.clausesContext = clausesContext;
	}
}
