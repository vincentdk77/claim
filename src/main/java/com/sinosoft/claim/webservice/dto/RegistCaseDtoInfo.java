package com.sinosoft.claim.webservice.dto;

import java.io.Serializable;
/**
 * 报案任务查询接口  查询报案列表的返回参数主信息
 *
 */
public class RegistCaseDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private RegistCaseDto[] registCaseDtoList;
	private int pageNo = 0;
	private int recordPerPage = 0;
	private int totalCount = 0;
	private int totalPage = 0;
	public RegistCaseDtoInfo() {
		super();
	}
	public RegistCaseDto[] getRegistCaseDtoList() {
		return registCaseDtoList;
	}
	public void setRegistCaseDtoList(RegistCaseDto[] registCaseDtoList) {
		this.registCaseDtoList = registCaseDtoList;
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
