package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerQueryMainDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 当前页数 */
	private int pageNo;
	/** 每页条数 */
	private int recordPerPage;
	/** 条数 */
	private int totalCount;
	/** 页数 */
	private int totalPage;

	private ClaimJobManagerQueryDto[] claimJobManagerQueryList;

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

	public ClaimJobManagerQueryDto[] getClaimJobManagerQueryList() {
		return claimJobManagerQueryList;
	}

	public void setClaimJobManagerQueryList(
			ClaimJobManagerQueryDto[] claimJobManagerQueryList) {
		this.claimJobManagerQueryList = claimJobManagerQueryList;
	}

}
