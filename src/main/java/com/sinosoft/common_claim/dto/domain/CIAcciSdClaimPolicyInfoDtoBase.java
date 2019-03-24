package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;

/**
 * 山东意外险风险预警立案登记，保单信息对象基础类
 * @author Administrator
 *
 */
public class CIAcciSdClaimPolicyInfoDtoBase implements Serializable{
	private static final long serialVersionUID = 1L;
	public CIAcciSdClaimPolicyInfoDtoBase(){
		
	}
	private String policyNo = "";//保单号
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
}
