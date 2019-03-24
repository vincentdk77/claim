package com.sinosoft.ws.ciclaimpropservice;

import com.sinosoft.common_claim.dto.domain.CIAcciSdClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdEndcaseRequestInDto;

/**
 * 山东意外险风险预警上传接口
 * @author Administrator
 *
 */
public interface CIClaimAcciSdService {
	/**
	 * 立案登记接口
	 */
	public boolean claimRequest(String requestType,CIAcciSdClaimRequestInDto ciAcciSdClaimRequestInDto,String registNo);
	
	/**
	 * 结案登记接口
	 */
	public boolean endCaseRequest(String requestType,CIAcciSdEndcaseRequestInDto ciAcciSdEndcaseRequestInDto,String registNo);
	
	/**
	 * 理赔风险查询接口
	 */
}
