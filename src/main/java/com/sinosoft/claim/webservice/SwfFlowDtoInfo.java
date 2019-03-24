package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class SwfFlowDtoInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	/***/
	private SwfFlowDto[] SwfFlowDtoList;
	/***/
	private int pageNo;
	/***/
	private int recordPerPage;
	/***/
	private int totalCount;
	/***/
	private int totalPage;
	public SwfFlowDtoInfo() {
	}
	public SwfFlowDto[] getSwfFlowDtoList() {
		return SwfFlowDtoList;
	}
	public void setSwfFlowDtoList(SwfFlowDto[] swfFlowDtoList) {
		SwfFlowDtoList = swfFlowDtoList;
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
