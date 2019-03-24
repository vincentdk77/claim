package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class ZH03CaseListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private ZH03CaseListInfo[] zh03CaseListInfoList;
	private int pageNo;
	private int recordPerPage;
	private int totalCount;
	private int totalPage;
	public ZH03CaseListMainInfo() {
		super();
	}
	public ZH03CaseListInfo[] getZh03CaseListInfoList() {
		return zh03CaseListInfoList;
	}
	public void setZh03CaseListInfoList(ZH03CaseListInfo[] zh03CaseListInfoList) {
		this.zh03CaseListInfoList = zh03CaseListInfoList;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	

}
