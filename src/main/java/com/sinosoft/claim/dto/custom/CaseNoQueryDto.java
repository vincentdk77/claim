package com.sinosoft.claim.dto.custom;
/**
 * 用于案件号互查数据传输
 * @author Administrator
 *
 */
public class CaseNoQueryDto {
	private String policyno = "";
	private String registno = "";
	private String claimno = "";
	private String compensateno = "";
	private String caseno = "";
	private String flowid="";
	public String getPolicyno() {
		return policyno;
	}
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}
	public String getRegistno() {
		return registno;
	}
	public void setRegistno(String registno) {
		this.registno = registno;
	}
	public String getClaimno() {
		return claimno;
	}
	public void setClaimno(String claimno) {
		this.claimno = claimno;
	}
	public String getCompensateno() {
		return compensateno;
	}
	public void setCompensateno(String compensateno) {
		this.compensateno = compensateno;
	}
	public String getCaseno() {
		return caseno;
	}
	public void setCaseno(String caseno) {
		this.caseno = caseno;
	}
	
	/**
	 * @return the flowid
	 */
	public String getFlowid() {
		return flowid;
	}
	/**
	 * @param flowid the flowid to set
	 */
	public void setFlowid(String flowid) {
		this.flowid = flowid;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return this.caseno+" "+this.claimno+" "+this.compensateno+" "+this.policyno+" "+this.registno;
	}
	
	
	
}
