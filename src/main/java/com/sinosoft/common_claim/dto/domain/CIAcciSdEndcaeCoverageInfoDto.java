package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;

/**
 * ɽ�������շ���Ԥ���᰸�Ǽǣ�������Ϣ���������
 * @author Administrator
 *
 */
public class CIAcciSdEndcaeCoverageInfoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	public CIAcciSdEndcaeCoverageInfoDto(){
		
	}
	private String comCoverageCode = "";//���չ�˾���ִ���
	private double covClaimAmount = 0d ;//�����⸶���
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
