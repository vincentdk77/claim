package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class CIPropClaimPolicyInfoDtoBase  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 /**
     *  Ĭ�Ϲ��췽��,����һ��Ĭ�ϵ�CIPropClaimPolicyInfoDtoBase����
     */
    public CIPropClaimPolicyInfoDtoBase(){
    }
	private String policySequenceNo = "";//��������

	public String getPolicySequenceNo() {
		return policySequenceNo;
	}

	public void setPolicySequenceNo(String policySequenceNo) {
		this.policySequenceNo = policySequenceNo;
	}
	
	private ArrayList<CIPropClaimCoverageInfoDto> ciPropClaimCoverageList ;//�����б� �����ڱ�����Ϣ 
	
	public ArrayList<CIPropClaimCoverageInfoDto> getCiPropClaimCoverageList() {
		return ciPropClaimCoverageList;
	}

	public void setCiPropClaimCoverageList(
			ArrayList<CIPropClaimCoverageInfoDto> ciPropClaimCoverageList) {
		this.ciPropClaimCoverageList = ciPropClaimCoverageList;
	}
	
	

}
