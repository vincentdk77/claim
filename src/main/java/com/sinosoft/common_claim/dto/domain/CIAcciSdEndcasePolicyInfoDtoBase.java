package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * ɽ�������շ���Ԥ���᰸�Ǽǣ�������Ϣ���������
 * @author Administrator
 *
 */
public class CIAcciSdEndcasePolicyInfoDtoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	public CIAcciSdEndcasePolicyInfoDtoBase(){
		
	}
	private String policyNo = "";//������
	private double polClaimAmount = 0d;//�����⸶���
	private ArrayList<CIAcciSdEndcaeCoverageInfoDto> ciAcciSdEndcaeCoverageInfoDtoList= new ArrayList<CIAcciSdEndcaeCoverageInfoDto>();//������Ϣ
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public double getPolClaimAmount() {
		return polClaimAmount;
	}
	public void setPolClaimAmount(double polClaimAmount) {
		this.polClaimAmount = polClaimAmount;
	}
	public ArrayList<CIAcciSdEndcaeCoverageInfoDto> getCiAcciSdEndcaeCoverageInfoDtoList() {
		return ciAcciSdEndcaeCoverageInfoDtoList;
	}
	public void setCiAcciSdEndcaeCoverageInfoDtoList(
			ArrayList<CIAcciSdEndcaeCoverageInfoDto> ciAcciSdEndcaeCoverageInfoDtoList) {
		this.ciAcciSdEndcaeCoverageInfoDtoList = ciAcciSdEndcaeCoverageInfoDtoList;
	}
	
}
