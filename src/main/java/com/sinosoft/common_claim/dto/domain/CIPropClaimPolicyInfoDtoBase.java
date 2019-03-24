package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class CIPropClaimPolicyInfoDtoBase  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 /**
     *  默认构造方法,构造一个默认的CIPropClaimPolicyInfoDtoBase对象
     */
    public CIPropClaimPolicyInfoDtoBase(){
    }
	private String policySequenceNo = "";//保单编码

	public String getPolicySequenceNo() {
		return policySequenceNo;
	}

	public void setPolicySequenceNo(String policySequenceNo) {
		this.policySequenceNo = policySequenceNo;
	}
	
	private ArrayList<CIPropClaimCoverageInfoDto> ciPropClaimCoverageList ;//险种列表 隶属于保单信息 
	
	public ArrayList<CIPropClaimCoverageInfoDto> getCiPropClaimCoverageList() {
		return ciPropClaimCoverageList;
	}

	public void setCiPropClaimCoverageList(
			ArrayList<CIPropClaimCoverageInfoDto> ciPropClaimCoverageList) {
		this.ciPropClaimCoverageList = ciPropClaimCoverageList;
	}
	
	

}
