package com.sinosoft.claim.webservice;

import java.io.Serializable;
/**
 * 理赔系统改派列表查询传入参数(ScheduleGetBackQueryReqInfo)
 * @author Administrator
 *
 */
public class ScheduleGetBackQueryReqInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**报案号*/
	private String registNo;
	/**车牌号码*/
	private String licenseNo;
	/**调度员*/
	private String handlerCode;
	/**查勘定损人*/
	private String NhandlerCode;
	/**开始时间(yyyy-mm-dd)*/
	private String startDate;
	/**结束时间(yyyy-mm-dd)*/
	private String endDate;
	/**调度去向类型*/
	private String nodeType;
	private String userCode;
	private String comCode;
	private int pageNo;
	private int recordPerPage;

	public ScheduleGetBackQueryReqInfo() {
		super();
	}
	public String getRegistNo() {
		return registNo;
	}
	public void setRegistNo(String registNo) {
		this.registNo = registNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getHandlerCode() {
		return handlerCode;
	}
	public void setHandlerCode(String handlerCode) {
		this.handlerCode = handlerCode;
	}
	public String getNhandlerCode() {
		return NhandlerCode;
	}
	public void setNhandlerCode(String nhandlerCode) {
		NhandlerCode = nhandlerCode;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getRecordPerPage() {
		return recordPerPage;
	}
	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getComCode() {
		return comCode;
	}
	public void setComCode(String comCode) {
		this.comCode = comCode;
	}
	

}
