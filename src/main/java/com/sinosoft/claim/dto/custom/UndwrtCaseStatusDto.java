package com.sinosoft.claim.dto.custom;
/**
 * 核赔通过 理赔工作流会写失败
 * 的数据对象
 * @author Administrator
 *
 */
public class UndwrtCaseStatusDto {
	private String compensateno  = "";  
	private String claimno       = "";  
	private String registno      = ""; 
	private String submittime    = "";  
	private String lflowid       = "";
	private String llogno        = "";
	private String hflowid       = "";
	private String hlogno        = "";
	private String notionInfo    = "";
	private String handlerCode   = "";
	public UndwrtCaseStatusDto() {
		super();
	}
	public String getCompensateno() {
		return compensateno;
	}
	public void setCompensateno(String compensateno) {
		this.compensateno = compensateno;
	}
	public String getClaimno() {
		return claimno;
	}
	public void setClaimno(String claimno) {
		this.claimno = claimno;
	}
	public String getRegistno() {
		return registno;
	}
	public void setRegistno(String registno) {
		this.registno = registno;
	}
	public String getSubmittime() {
		return submittime;
	}
	public void setSubmittime(String submittime) {
		this.submittime = submittime;
	}
	public String getLflowid() {
		return lflowid;
	}
	public void setLflowid(String lflowid) {
		this.lflowid = lflowid;
	}
	public String getLlogno() {
		return llogno;
	}
	public void setLlogno(String llogno) {
		this.llogno = llogno;
	}
	public String getHflowid() {
		return hflowid;
	}
	public void setHflowid(String hflowid) {
		this.hflowid = hflowid;
	}
	public String getHlogno() {
		return hlogno;
	}
	public void setHlogno(String hlogno) {
		this.hlogno = hlogno;
	}
	public String getNotionInfo() {
		return notionInfo;
	}
	public void setNotionInfo(String notionInfo) {
		this.notionInfo = notionInfo;
	}
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}   
	
}
