package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;

/**
 * ɽ�������շ���Ԥ�������Ǽǣ�������Ϣ���������
 * @author Administrator
 *
 */
public class CIAcciSdClaimPolicyInfoDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
	public CIAcciSdClaimPolicyInfoDtoBase(){
		
	}
	private String policyNo = "";//������
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
}
