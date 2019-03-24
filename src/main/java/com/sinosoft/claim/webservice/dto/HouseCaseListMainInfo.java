package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class HouseCaseListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private HouseCaseListInfo[] houseCaseListInfoList;
	private int pageNo;
	private int recordPerPage;
	private int totalCount;
	private int totalPage;
	public HouseCaseListMainInfo() {
		super();
	}
	public HouseCaseListInfo[] getHouseCaseListInfoList() {
		return houseCaseListInfoList;
	}
	public void setHouseCaseListInfoList(HouseCaseListInfo[] houseCaseListInfoList) {
		this.houseCaseListInfoList = houseCaseListInfoList;
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
