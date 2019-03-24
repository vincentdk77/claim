package com.sinosoft.common_claim.bl.action.custom;

import java.sql.SQLException;

import com.sinosoft.common_claim.dto.domain.CIPropCancelCaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropEndcaseRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIPropRegistRequestInDto;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ws.ciclaimpropservice.CIClaimSHPropService;
import com.sinosoft.ws.client.CIClaimPropClient;

public class BLCIClaimPropPlatFormInterfaceFacade {
	private static BLCIClaimPropPlatFormInterfaceFacade blCIClaimPropPlatFormInterfaceFacade = new BLCIClaimPropPlatFormInterfaceFacade();
	public static BLCIClaimPropPlatFormInterfaceFacade getInstance(){
		return blCIClaimPropPlatFormInterfaceFacade;
	}
	private BLCIClaimPropPlatFormInterfaceFacade(){
		
	}
	
	/**
	 * 
	 * @param dbManager
	 * @param registType
	 * @param claimStatus
	 * @param businessNo
	 * @param policyNo
	 * @param groupFlag //��/���ձ�־
	 * @return
	 * @throws Exception 
	 */
	public boolean upload(DBManager dbManager,String registType,String claimStatus, String businessNo,String policyNo,String groupFlag,String secodeComCode) throws SQLException, Exception{
		boolean isSuccessFlag = false;
		TransDataHelperProp transDataHelperProp = new TransDataHelperProp();//��װ������
		System.out.println("*****��ʼ������");
		CIClaimSHPropService service = CIClaimPropClient.getInstance();
		System.out.println("*****service="+service);
		if("C01,C04".indexOf(registType)>-1 && claimStatus.equals("01")){  //����
			CIPropRegistRequestInDto ciPropRegistRequestInDto = transDataHelperProp.getRegist(dbManager, businessNo, policyNo, groupFlag, secodeComCode);
			System.out.println("�����⽡��ƽ̨�����ӿ�......");
			isSuccessFlag = service.registRequest(registType,claimStatus,ciPropRegistRequestInDto);
		}else if("C01,C04".indexOf(registType)>-1 && claimStatus.equals("02")){  //����
			CIPropClaimRequestInDto ciPropClaimRequestInDto = transDataHelperProp.getCIPropClaimRequestInDto(dbManager, businessNo,policyNo,groupFlag,secodeComCode);
			System.out.println("*****�����⽡�ո�/�������ӿ�claimStatus="+claimStatus);
			isSuccessFlag = service.claimRequest(registType, businessNo,policyNo,ciPropClaimRequestInDto,claimStatus);
		}else if("C01,C04".indexOf(registType)>-1 && claimStatus.equals("03")){  //�᰸
			CIPropEndcaseRequestInDto ciPropEndcaseRequestInDto = transDataHelperProp.getEndCaseProp(dbManager, businessNo, policyNo,groupFlag);
			System.out.println("*****�����⽡�ս᰸�ӿ�claimStatus="+claimStatus);
			isSuccessFlag = service.endcaseRequest(registType, businessNo, policyNo, ciPropEndcaseRequestInDto, claimStatus);
		}else if("C12,C14".indexOf(registType)>-1){  //����ע��������ע��
			CIPropCancelCaseRequestInDto ciPropCancelCaseRequestInDto = transDataHelperProp.getCancelClaimCase(dbManager, businessNo,policyNo,groupFlag,claimStatus);
			System.out.println("*****�����⽡�ձ���ע��������ע���ӿ�claimStatus="+claimStatus);
			isSuccessFlag = service.cancelRequest(registType, businessNo, policyNo,ciPropCancelCaseRequestInDto,claimStatus);
		}	
		return isSuccessFlag;
	}
}
