package com.sinosoft.common_claim.bl.action.custom;

import java.util.ArrayList;
import java.util.Collection;

import com.sinosoft.claim.bl.facade.BLPrpLaccipersonFacade;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.domain.PrpLacciPersonDto;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdClaimRequestInDto;
import com.sinosoft.common_claim.dto.domain.CIAcciSdEndcaseRequestInDto;
import com.sinosoft.sysframework.reference.DBManager;
import com.sinosoft.ws.ciclaimpropservice.CIClaimAcciSdService;
import com.sinosoft.ws.client.CIClaimAcciSdClient;

/**
 * 山东意外险风险预警上传处理类
 * @author Administrator
 *
 */
public class BLCIClaimAcciSdPlatFormInterfaceFacade {
	private static BLCIClaimAcciSdPlatFormInterfaceFacade blCIClaimAcciSdPlatFormInterfaceFacade = new BLCIClaimAcciSdPlatFormInterfaceFacade();
	public static BLCIClaimAcciSdPlatFormInterfaceFacade getInstance(){
		return blCIClaimAcciSdPlatFormInterfaceFacade;
	}
	private BLCIClaimAcciSdPlatFormInterfaceFacade(){
		
	}
	public boolean upload(DBManager dbManager,String requestType,String businessNo,String groupFlag) throws Exception{
		boolean isSuccessFlag = false;
		TransDataHelperSdAcci transDataHelperSdAcci = new TransDataHelperSdAcci();//数据组装类
		String registNo = "";
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(businessNo);
		if(prpLclaimDto!=null){
			registNo = prpLclaimDto.getRegistNo();
		}
		ArrayList acciPersonList = (ArrayList)new BLPrpLaccipersonFacade().findByConditions("certino = '"+registNo+"' ");
		if(acciPersonList !=null && acciPersonList.size()>0){
			for(int i=0;i<acciPersonList.size();i++){
				PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)acciPersonList.get(i);
				
				System.out.println("*****开始调服务");
				CIClaimAcciSdService service = CIClaimAcciSdClient.getInstance();
				System.out.println("*****service="+service);
				if("L01".indexOf(requestType)>-1){//立案登记接口
					CIAcciSdClaimRequestInDto ciAcciSdClaimRequestInDto = transDataHelperSdAcci.getClaim(dbManager, businessNo, prpLacciPersonDto.getSerialNo()+"", groupFlag);
					System.out.println("调用意外险风险预警平台立案登记接口......");
					isSuccessFlag = service.claimRequest(requestType, ciAcciSdClaimRequestInDto, registNo);
				}else if("L02".indexOf(requestType)>-1){//结案登记接口
					CIAcciSdEndcaseRequestInDto ciAcciSdEndcaseRequestInDto = transDataHelperSdAcci.getEndcase(dbManager, businessNo, prpLacciPersonDto.getSerialNo()+"", groupFlag,prpLacciPersonDto.getAcciName());
					System.out.println("调用意外险风险预警平台结案登记接口......");
					isSuccessFlag = service.endCaseRequest(requestType, ciAcciSdEndcaseRequestInDto, registNo);
				}
			}
		}
		return isSuccessFlag;
	}
}
