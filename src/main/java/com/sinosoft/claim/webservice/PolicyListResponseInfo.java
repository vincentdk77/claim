package com.sinosoft.claim.webservice;

import java.io.Serializable;

import com.sinosoft.claim.dto.custom.PolicyListInfoDto;

public class PolicyListResponseInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private PolicyListInfoDto[] policyListInfoDtoList;
	/** ��ǰҳ�� */
	private int pageNo;
	/** ÿҳ���� Ĭ����ʾ20�� */
	private int recordPerPage;
	/** ���� */
	private int totalCount;
	/** ҳ�� */
	private int totalPage;

	public PolicyListInfoDto[] getPolicyListInfoDtoList() {
		return policyListInfoDtoList;
	}

	public void setPolicyListInfoDtoList(
			PolicyListInfoDto[] policyListInfoDtoList) {
		this.policyListInfoDtoList = policyListInfoDtoList;
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
