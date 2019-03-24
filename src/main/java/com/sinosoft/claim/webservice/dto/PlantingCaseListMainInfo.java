package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

public class PlantingCaseListMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private PlantingCaseListInfo[] plantingCaseListInfoList;
	private int pageNo;
	private int recordPerPage;
	private int totalCount;
	private int totalPage;
	public PlantingCaseListMainInfo() {
		super();
	}
	public PlantingCaseListInfo[] getPlantingCaseListInfoList() {
		return plantingCaseListInfoList;
	}
	public void setPlantingCaseListInfoList(
			PlantingCaseListInfo[] plantingCaseListInfoList) {
		this.plantingCaseListInfoList = plantingCaseListInfoList;
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
