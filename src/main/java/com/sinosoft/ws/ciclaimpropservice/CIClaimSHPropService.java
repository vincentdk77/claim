package com.sinosoft.ws.ciclaimpropservice;

import com.sinosoft.common_claim.dto.domain.CIPropCancelCaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropEndcaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropRegistRequestInDto;

/**
 * 上海平台意健险上传接口
 * @author feigai1
 *
 */
public interface CIClaimSHPropService {
	/**
	 * 意健险报案接口(？？添加返回对象)
	 * */
	public boolean registRequest(String registType,String claimStatus,CIPropRegistRequestInDto ciPropRegistRequestInDto);
	
	/***
	 * 意健险立案接口
	 */
	public boolean claimRequest(String registType,String businessNo,String policyNo,CIPropClaimRequestInDto ciPropClaimRequestInDto, String claimStatus);
	/***
	 * 意健险结案接口
	 */
	public boolean endcaseRequest(String registType,String businessNo,String policyNo,CIPropEndcaseRequestInDto ciPropEndcaseRequestInDto, String claimStatus);
	/**
	 * 意健险案件注销
	 */
	public boolean cancelRequest(String registType,String businessNo,String policyNo,CIPropCancelCaseRequestInDto ciPropCancelCaseRequestInDto, String claimStatus);
}
