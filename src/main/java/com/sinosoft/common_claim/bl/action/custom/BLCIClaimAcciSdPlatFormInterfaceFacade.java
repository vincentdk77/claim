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
 * ɽ�������շ���Ԥ���ϴ�������
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
		TransDataHelperSdAcci transDataHelperSdAcci = new TransDataHelperSdAcci();//������װ��
		String registNo = "";
		PrpLclaimDto prpLclaimDto = new BLPrpLclaimFacade().findByPrimaryKey(businessNo);
		if(prpLclaimDto!=null){
			registNo = prpLclaimDto.getRegistNo();
		}
		ArrayList acciPersonList = (ArrayList)new BLPrpLaccipersonFacade().findByConditions("certino = '"+registNo+"' ");
		if(acciPersonList !=null && acciPersonList.size()>0){
			for(int i=0;i<acciPersonList.size();i++){
				PrpLacciPersonDto prpLacciPersonDto = (PrpLacciPersonDto)acciPersonList.get(i);
				
				System.out.println("*****��ʼ������");
				CIClaimAcciSdService service = CIClaimAcciSdClient.getInstance();
				System.out.println("*****service="+service);
				if("L01".indexOf(requestType)>-1){//�����Ǽǽӿ�
					CIAcciSdClaimRequestInDto ciAcciSdClaimRequestInDto = transDataHelperSdAcci.getClaim(dbManager, businessNo, prpLacciPersonDto.getSerialNo()+"", groupFlag);
					System.out.println("���������շ���Ԥ��ƽ̨�����Ǽǽӿ�......");
					isSuccessFlag = service.claimRequest(requestType, ciAcciSdClaimRequestInDto, registNo);
				}else if("L02".indexOf(requestType)>-1){//�᰸�Ǽǽӿ�
					CIAcciSdEndcaseRequestInDto ciAcciSdEndcaseRequestInDto = transDataHelperSdAcci.getEndcase(dbManager, businessNo, prpLacciPersonDto.getSerialNo()+"", groupFlag,prpLacciPersonDto.getAcciName());
					System.out.println("���������շ���Ԥ��ƽ̨�᰸�Ǽǽӿ�......");
					isSuccessFlag = service.endCaseRequest(requestType, ciAcciSdEndcaseRequestInDto, registNo);
				}
			}
		}
		return isSuccessFlag;
	}
}
