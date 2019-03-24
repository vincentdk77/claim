package com.sinosoft.claimzy.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sinosoft.aip.webservice.server.CancelDto;
import com.sinosoft.aip.webservice.server.CancelResponseDto;
import com.sinosoft.aip.webservice.server.CancelResultInfo;
import com.sinosoft.aip.webservice.server.ClaimDto;
import com.sinosoft.aip.webservice.server.ClaimResponseMainInfo;
import com.sinosoft.claim.bl.facade.BLPrpLclaimFacade;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claimzy.bl.facade.BLAgriClaimUploadLogFacade;
import com.sinosoft.claimzy.bl.facade.BLAgriDemandFacade;
import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.utility.error.UserException;

/**
 * ����ע��/������Ϣ�������ϴ��ͷ�����Ϣ��
 * @author CDB
 *
 */
public class BLPrplCancelZYFResponse {
	/**����ע��/���ⷵ�ص�������Ϣ*/
	public void cancelResponseSave(CancelResponseDto cancelResponseDto,int flag,int size){
	
		if(cancelResponseDto.getCancelResultInfoList()!=null){
			for(int i=0;i<cancelResponseDto.getCancelResultInfoList().length;i++){
				AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
				/**�������κ�*/
				agriClaimUploadLogDto.setBatchNo(cancelResponseDto.getBatchNo());
				/**�ӿ���Ӧ����*/
				agriClaimUploadLogDto.setResponseCode(cancelResponseDto.getResponseCode());
				/**�������*/
				agriClaimUploadLogDto.setErrorCode(cancelResponseDto.getErrorCode());
				/**����˵��*/
				agriClaimUploadLogDto.setErrorDesc(cancelResponseDto.getErrorDesc());
				
				/**�������*/
				CancelResultInfo[] cri = cancelResponseDto.getCancelResultInfoList();
				CancelResultInfo cancelResultInfo = cri[i];
				agriClaimUploadLogDto.setClaimCode(cancelResultInfo.getClaimSequenceNo());
				/**������*/
				agriClaimUploadLogDto.setClaimNo(cancelResultInfo.getClaimNumber());
				/**��ϸ��Ӧ����*/
				agriClaimUploadLogDto.setResponseMXCode(cancelResultInfo.getResponseCode());
				/**��ϸ�������*/
				agriClaimUploadLogDto.setErrorMXCode(cancelResultInfo.getErrorCode());
				/**��ϸ����˵��*/
				agriClaimUploadLogDto.setErrorMXDesc(cancelResultInfo.getErrorDesc());
				/**�ϴ�ʱ��*/
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
				/**�ϴ���־λ��������ƴ��batchNo��*/
				agriClaimUploadLogDto.setFlag(flag);
				BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
				try {
					blacuf.insert(agriClaimUploadLogDto);
				} catch (Exception e) {
					System.out.println("ע��/������Ϣ�������ݴ洢�쳣");
					e.printStackTrace();
				}
			}	
		}else{

			AgriClaimUploadLogDto agriClaimUploadLogDto = null;
		    for(int i=0;i<size;i++){
			    agriClaimUploadLogDto = new AgriClaimUploadLogDto();
			    agriClaimUploadLogDto.setBatchNo(cancelResponseDto.getBatchNo());
			    agriClaimUploadLogDto.setErrorCode(cancelResponseDto.getErrorCode());
			    agriClaimUploadLogDto.setErrorDesc(cancelResponseDto.getErrorDesc());
			    agriClaimUploadLogDto.setResponseCode(cancelResponseDto.getResponseCode());
			    /** �ϴ�ʱ�� */
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
			    BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
				try {	
					blacuf.insert(agriClaimUploadLogDto);
				} catch (Exception e) {
					System.out.println("������Ϣ�������ݴ洢�쳣");
					e.printStackTrace();
				}
		 }
		
		}
		
		
	}

	/**
	 * ��ȡע��/�����ϴ���������Ϣ
	 * @throws Exception 
	 * @throws UserException 
	 */
	public void cancelUploadInfo(CancelResponseDto cancelResponseDto,ArrayList cancelDtoList) throws UserException, Exception{
		if(cancelResponseDto.getCancelResultInfoList()!=null){
			for(int i=0;i<cancelResponseDto.getCancelResultInfoList().length;i++){
				AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto(); 
		    	/**��ȡ���κ�*/
		    	agriClaimDemandDto.setBatchNo(cancelResponseDto.getBatchNo());
		    	/**��ȡ�ӿ���Ӧ����*/
		    	agriClaimDemandDto.setResponseCode(cancelResponseDto.getResponseCode());
		    	/** ������� */
				CancelResultInfo[] cri = cancelResponseDto.getCancelResultInfoList();
				CancelResultInfo cancelResultInfo = cri[i];
				agriClaimDemandDto.setClaimCode(cancelResultInfo.getClaimSequenceNo());
				/** ������ */
				String claimNo = cancelResultInfo.getClaimNumber();
				agriClaimDemandDto.setClaimNo(claimNo);
				/**��ȡ�ϴ���־λ*/
				String responseMXcode = cancelResultInfo.getResponseCode();
				if(responseMXcode.equals("1")){
					agriClaimDemandDto.setCancelUploadFlag("1");
				}else{
					agriClaimDemandDto.setCancelUploadFlag("0");
				}
		    	/**��ȡ���ִ���*/
		    	BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
				String riskCode = prpLclaimDto.getRiskCode();
				agriClaimDemandDto.setRiskCode(riskCode);
				BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
				try{
				blacdf.insert(agriClaimDemandDto);
		        }catch(Exception e){
		    	   System.out.println("ע��/������Ϣ�ϴ����ݴ洢�쳣");
				   e.printStackTrace();
		     }
			}
		}else{
			AgriClaimDemandDto agriClaimDemandDto = null;
			for(int i=0;i<cancelDtoList.size();i++){
				CancelDto cancelDto =  (CancelDto)cancelDtoList.get(i);
				agriClaimDemandDto = new AgriClaimDemandDto();
				String ClaimNumber =  cancelDto.getCancelMainInfo().getClaimNumber();
				agriClaimDemandDto.setBatchNo(cancelResponseDto.getBatchNo());
				agriClaimDemandDto.setCaseNo(ClaimNumber);
				agriClaimDemandDto.setCaseUploadFlag(cancelResponseDto.getResponseCode());
				BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
				try {
					blacdf.insert(agriClaimDemandDto);
				} catch (Exception e) {
					System.out.println("������Ϣ�ϴ����ݴ洢�쳣");
					e.printStackTrace();
				}
				
			}
		}
		
		}
		
}
