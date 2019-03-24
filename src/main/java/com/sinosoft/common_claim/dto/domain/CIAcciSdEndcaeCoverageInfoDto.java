package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;

/**
 * 山东意外险风险预警结案登记，险种信息对象基础类
 * @author Administrator
 *
 */
public class CIAcciSdEndcaeCoverageInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	public CIAcciSdEndcaeCoverageInfoDto(){
		
	}
	private String comCoverageCode = "";//保险公司险种代码
	private double covClaimAmount = 0d ;//险种赔付金额
	public String getComCoverageCode() {
		return comCoverageCode;
	}
	public void setComCoverageCode(String comCoverageCode) {
		this.comCoverageCode = comCoverageCode;
	}
	public double getCovClaimAmount() {
		return covClaimAmount;
	}
	public void setCovClaimAmount(double covClaimAmount) {
		this.covClaimAmount = covClaimAmount;
	}
	
}
