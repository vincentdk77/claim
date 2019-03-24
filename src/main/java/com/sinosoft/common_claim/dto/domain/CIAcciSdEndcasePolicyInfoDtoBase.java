package com.sinosoft.common_claim.dto.domain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 山东意外险风险预警结案登记，保单信息对象基础类
 * @author Administrator
 *
 */
public class CIAcciSdEndcasePolicyInfoDtoBase implements Serializable {
	private static final long serialVersionUID = 1L;
	public CIAcciSdEndcasePolicyInfoDtoBase(){
		
	}
	private String policyNo = "";//保单号
	private double polClaimAmount = 0d;//保单赔付金额
	private ArrayList<CIAcciSdEndcaeCoverageInfoDto> ciAcciSdEndcaeCoverageInfoDtoList= new ArrayList<CIAcciSdEndcaeCoverageInfoDto>();//险种信息
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
