package com.sinosoft.ws.ciclaimpropservice;

import com.sinosoft.common_claim.dto.domain.CIAcciSdClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdEndcaseRequestInDto;

/**
 * ɽ�������շ���Ԥ���ϴ��ӿ�
 * @author Administrator
 *
 */
public interface CIClaimAcciSdService {
	/**
	 * �����Ǽǽӿ�
	 */
	public boolean claimRequest(String requestType,CIAcciSdClaimRequestInDto ciAcciSdClaimRequestInDto,String registNo);
	
	/**
	 * �᰸�Ǽǽӿ�
	 */
	public boolean endCaseRequest(String requestType,CIAcciSdEndcaseRequestInDto ciAcciSdEndcaseRequestInDto,String registNo);
	
	/**
	 * ������ղ�ѯ�ӿ�
	 */
}
