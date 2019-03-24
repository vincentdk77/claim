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
	 * @param groupFlag //个/团险标志
	 * @return
	 * @throws Exception 
	 */
	public boolean upload(DBManager dbManager,String registType,String claimStatus, String businessNo,String policyNo,String groupFlag,String secodeComCode) throws SQLException, Exception{
		boolean isSuccessFlag = false;
		TransDataHelperProp transDataHelperProp = new TransDataHelperProp();//组装数据类
		System.out.println("*****开始调服务");
		CIClaimSHPropService service = CIClaimPropClient.getInstance();
		System.out.println("*****service="+service);
		if("C01,C04".indexOf(registType)>-1 && claimStatus.equals("01")){  //报案
			CIPropRegistRequestInDto ciPropRegistRequestInDto = transDataHelperProp.getRegist(dbManager, businessNo, policyNo, groupFlag, secodeComCode);
			System.out.println("调用意健险平台报案接口......");
			isSuccessFlag = service.registRequest(registType,claimStatus,ciPropRegistRequestInDto);
		}else if("C01,C04".indexOf(registType)>-1 && claimStatus.equals("02")){  //立案
			CIPropClaimRequestInDto ciPropClaimRequestInDto = transDataHelperProp.getCIPropClaimRequestInDto(dbManager, businessNo,policyNo,groupFlag,secodeComCode);
			System.out.println("*****调上意健险个/团立案接口claimStatus="+claimStatus);
			isSuccessFlag = service.claimRequest(registType, businessNo,policyNo,ciPropClaimRequestInDto,claimStatus);
		}else if("C01,C04".indexOf(registType)>-1 && claimStatus.equals("03")){  //结案
			CIPropEndcaseRequestInDto ciPropEndcaseRequestInDto = transDataHelperProp.getEndCaseProp(dbManager, businessNo, policyNo,groupFlag);
			System.out.println("*****调上意健险结案接口claimStatus="+claimStatus);
			isSuccessFlag = service.endcaseRequest(registType, businessNo, policyNo, ciPropEndcaseRequestInDto, claimStatus);
		}else if("C12,C14".indexOf(registType)>-1){  //报案注销、立案注销
			CIPropCancelCaseRequestInDto ciPropCancelCaseRequestInDto = transDataHelperProp.getCancelClaimCase(dbManager, businessNo,policyNo,groupFlag,claimStatus);
			System.out.println("*****调上意健险报案注销、立案注销接口claimStatus="+claimStatus);
			isSuccessFlag = service.cancelRequest(registType, businessNo, policyNo,ciPropCancelCaseRequestInDto,claimStatus);
		}	
		return isSuccessFlag;
	}
}
