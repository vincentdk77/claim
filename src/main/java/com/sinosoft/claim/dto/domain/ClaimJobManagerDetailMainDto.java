package com.sinosoft.claim.dto.domain;

import java.io.Serializable;

public class ClaimJobManagerDetailMainDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private ClaimJobManagerDetailDto[] claimJobManagerDetailList;

	private ClaimJobLinkDto[] claimJobLinkDto;

	public ClaimJobManagerDetailDto[] getClaimJobManagerDetailList() {
		return claimJobManagerDetailList;
	}

	public void setClaimJobManagerDetailList(
			ClaimJobManagerDetailDto[] claimJobManagerDetailList) {
		this.claimJobManagerDetailList = claimJobManagerDetailList;
	}

	public ClaimJobLinkDto[] getClaimJobLinkDto() {
		return claimJobLinkDto;
	}

	public void setClaimJobLinkDto(ClaimJobLinkDto[] claimJobLinkDto) {
		this.claimJobLinkDto = claimJobLinkDto;
	}

}
