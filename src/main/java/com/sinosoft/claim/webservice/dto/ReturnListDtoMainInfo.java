package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;

/**
 * 待回访清单接口
 * 主信息（ReturnListDtoMainInfo）
 * @author Administrator
 *
 */
public class ReturnListDtoMainInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private ReturnListDtoInfo[] returnListDtoInfoList;
	private int pageNo;
	private int recordPerPage;
	private int totalCount;
	private int totalPage;
	public ReturnListDtoMainInfo() {
		super();
	}
	public ReturnListDtoInfo[] getReturnListDtoInfoList() {
		return returnListDtoInfoList;
	}
	public void setReturnListDtoInfoList(ReturnListDtoInfo[] returnListDtoInfoList) {
		this.returnListDtoInfoList = returnListDtoInfoList;
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
