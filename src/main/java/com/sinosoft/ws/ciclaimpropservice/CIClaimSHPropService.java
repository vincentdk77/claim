package com.sinosoft.ws.ciclaimpropservice;

import com.sinosoft.common_claim.dto.domain.CIPropCancelCaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropEndcaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropRegistRequestInDto;

/**
 * �Ϻ�ƽ̨�⽡���ϴ��ӿ�
 * @author feigai1
 *
 */
public interface CIClaimSHPropService {
	/**
	 * �⽡�ձ����ӿ�(������ӷ��ض���)
	 * */
	public boolean registRequest(String registType,String claimStatus,CIPropRegistRequestInDto ciPropRegistRequestInDto);
	
	/***
	 * �⽡�������ӿ�
	 */
	public boolean claimRequest(String registType,String businessNo,String policyNo,CIPropClaimRequestInDto ciPropClaimRequestInDto, String claimStatus);
	/***
	 * �⽡�ս᰸�ӿ�
	 */
	public boolean endcaseRequest(String registType,String businessNo,String policyNo,CIPropEndcaseRequestInDto ciPropEndcaseRequestInDto, String claimStatus);
	/**
	 * �⽡�հ���ע��
	 */
	public boolean cancelRequest(String registType,String businessNo,String policyNo,CIPropCancelCaseRequestInDto ciPropCancelCaseRequestInDto, String claimStatus);
}
