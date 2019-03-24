package com.sinosoft.claim.webservice;

import java.io.Serializable;

public class ClaimHistoryListInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private ClaimHistoryPMainInfo[] claimHistoryPMainInfoList;
	
	private ClaimHistoryRegistInfo[] claimHistoryRegistInfoList;

	public ClaimHistoryPMainInfo[] getClaimHistoryPMainInfoList() {
		return claimHistoryPMainInfoList;
	}

	public void setClaimHistoryPMainInfoList(
			ClaimHistoryPMainInfo[] claimHistoryPMainInfoList) {
		this.claimHistoryPMainInfoList = claimHistoryPMainInfoList;
	}

	public ClaimHistoryRegistInfo[] getClaimHistoryRegistInfoList() {
		return claimHistoryRegistInfoList;
	}

	public void setClaimHistoryRegistInfoList(
			ClaimHistoryRegistInfo[] claimHistoryRegistInfoList) {
		this.claimHistoryRegistInfoList = claimHistoryRegistInfoList;
	}

}
