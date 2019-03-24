package com.sinosoft.claim.webservice;

import java.io.Serializable;
/**
 * 理赔系统改派列表查询:主信息(ScheduleGetBackQueryMainDtoInfo)
 * @author Administrator
 *
 */
public class ScheduleGetBackQueryMainDtoInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private int pageNo;
	private int recordPerPage;
	private int totalCount;
	private int totalPage;
	private ScheduleGetBackQueryDetailDtoInfo[] ScheduleGetBackQueryDetailDtoInfoList;
	public ScheduleGetBackQueryMainDtoInfo() {
		super();
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

	public ScheduleGetBackQueryDetailDtoInfo[] getScheduleGetBackQueryDetailDtoInfoList() {
		return ScheduleGetBackQueryDetailDtoInfoList;
	}
	public void setScheduleGetBackQueryDetailDtoInfoList(
			ScheduleGetBackQueryDetailDtoInfo[] scheduleGetBackQueryDetailDtoInfoList) {
		ScheduleGetBackQueryDetailDtoInfoList = scheduleGetBackQueryDetailDtoInfoList;
	}
	

}
