package com.sinosoft.claimzy.facade;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sinosoft.aip.webservice.server.CancelResultInfo;
import com.sinosoft.aip.webservice.server.PrepaidResponseDto;
import com.sinosoft.aip.webservice.server.PrepaidResultInfo;
import com.sinosoft.claimzy.bl.facade.BLAgriClaimUploadLogFacade;
import com.sinosoft.claimzy.bl.facade.BLAgriDemandFacade;
import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.utility.error.UserException;

/**
 * ����Ԥ�ⰸ��Ϣ�������ϴ��ͷ�����Ϣ��
 * @author CDB
 *
 */
public class BLPrplPrepaidZYFResponse {
	/**����Ԥ�ⰸ���ص�������Ϣ*/
	public void prepaidResponseSave(PrepaidResponseDto prepaidResponseDto,int flag,int size){
		AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
		for(int i=0;i<size;i++){
			/**���ýӿ���Ӧ����*/
			agriClaimUploadLogDto.setResponseCode(prepaidResponseDto.getResponseCode());
			/**���ô������*/
			agriClaimUploadLogDto.setErrorCode(prepaidResponseDto.getErrorCode());
			/**���ô���˵��*/
			agriClaimUploadLogDto.setErrorDesc(prepaidResponseDto.getErrorDesc());
			/**�������κ�*/
			agriClaimUploadLogDto.setBatchNo(prepaidResponseDto.getBatchNo());
			
			/**�������*/
		    PrepaidResultInfo[] pri = prepaidResponseDto.getPrepaidResultInfoList();
		    PrepaidResultInfo prepaidResultInfo = pri[i];
		    agriClaimUploadLogDto.setClaimCode(prepaidResultInfo.getClaimSequenceNo());
		    /**����Ԥ�ⰸ��*/
		    agriClaimUploadLogDto.setPreCompensateNo(prepaidResultInfo.getPrepayCaseNumber());
		    /**������ϸ��Ӧ����*/
		    agriClaimUploadLogDto.setResponseMXCode(prepaidResultInfo.getResponseCode());
		    /**������ϸ�������*/
		    agriClaimUploadLogDto.setErrorMXCode(prepaidResultInfo.getErrorCode());
		    /**������ϸ����˵��*/
		    agriClaimUploadLogDto.setErrorMXDesc(prepaidResultInfo.getErrorDesc());
		    /**�ϴ���־λ��������ƴ��batchNo��*/
		    agriClaimUploadLogDto.setFlag(flag);
		    /**�ϴ�ʱ��*/
		    DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
			agriClaimUploadLogDto.setUploadDate(date);
			BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
			try {
				blacuf.insert(agriClaimUploadLogDto);
			} catch (Exception e) {
				System.out.println("Ԥ�ⰸ��Ϣ�������ݴ洢�쳣");
				e.printStackTrace();
			}
		}
	}
	/**
	 * ��ȡԤ�ⰸ�ϴ���������Ϣ
	 * @throws Exception 
	 * @throws UserException 
	 */
	public void prepaidUploadInfo(PrepaidResponseDto prepaidResponseDto,int size) throws UserException, Exception{
		AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto();
		for(int i=0;i<size;i++){
			/**��ȡ���κ�*/
			agriClaimDemandDto.setBatchNo(prepaidResponseDto.getBatchNo());
			/**��ȡ�ӿ���Ӧ����*/
			agriClaimDemandDto.setResponseCode(prepaidResponseDto.getResponseCode());
			/**��ȡ�������*/
			PrepaidResultInfo[] pri = prepaidResponseDto.getPrepaidResultInfoList();
			PrepaidResultInfo prepaidResultInfo = pri[i];
			agriClaimDemandDto.setClaimCode(prepaidResultInfo.getClaimSequenceNo());
			/** Ԥ�ⰸ�� */
			String preCompensateNo = prepaidResultInfo.getPrepayCaseNumber();
			agriClaimDemandDto.setPreCompensateNo(preCompensateNo);
			/**��ȡ�ϴ���־λ*/
			String responseMXcode = prepaidResultInfo.getResponseCode();
			if(responseMXcode.equals("1")){
				agriClaimDemandDto.setPrepaidUploadFlag("1");
			}else{
				agriClaimDemandDto.setPrepaidUploadFlag("0");
			}
	    	BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
	    	try{
	    		blacdf.insert(agriClaimDemandDto);
	            }catch(Exception e){
	        	   System.out.println("Ԥ�ⰸ��Ϣ�ϴ����ݴ洢�쳣");
	    		   e.printStackTrace();
	        }
		}
		}
}
