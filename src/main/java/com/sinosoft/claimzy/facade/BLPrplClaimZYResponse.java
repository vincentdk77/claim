package com.sinosoft.claimzy.facade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sinosoft.aip.webservice.server.CaseDto;
import com.sinosoft.aip.webservice.server.ClaimDto;
import com.sinosoft.aip.webservice.server.ClaimResponseDto;
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
 * ����������Ϣ�������ϴ��ͷ�����Ϣ��
 * 
 * @author CDB
 * 
 */
public class BLPrplClaimZYResponse {
	/** �����������ص����ݵ���Ϣ */
	public void claimResponseSave(ClaimResponseDto claimResponseDto, int flag,int size) {

		if(claimResponseDto.getClaimResponseMainInfoList()!=null){
			
			for (int i = 0; i <claimResponseDto.getClaimResponseMainInfoList().length; i++) {
				AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
				/** �������κ� */
				agriClaimUploadLogDto.setBatchNo(claimResponseDto.getBatchNo());
				/** �ӿ���Ӧ���� */
				agriClaimUploadLogDto.setResponseCode(claimResponseDto.getResponseCode());
				/** ������� */
				agriClaimUploadLogDto.setErrorCode(claimResponseDto.getErrorCode());
				/** �������� */
				agriClaimUploadLogDto.setErrorDesc(claimResponseDto.getErrorDesc());

				/** ������� */
				ClaimResponseMainInfo[] crmi = claimResponseDto.getClaimResponseMainInfoList();
				ClaimResponseMainInfo claimResponseMainInfo = crmi[i];
				agriClaimUploadLogDto.setClaimCode(claimResponseMainInfo.getClaimSequenceNo());
				/** ������ */
				agriClaimUploadLogDto.setClaimNo(claimResponseMainInfo.getClaimNumber());
				/** ��ϸ��Ӧ���� */
				agriClaimUploadLogDto.setResponseMXCode(claimResponseMainInfo.getResponseCode());
				/** ��ϸ������� */
				agriClaimUploadLogDto.setErrorMXCode(claimResponseMainInfo.getErrorCode());
				/** ��ϸ����˵�� */
				agriClaimUploadLogDto.setErrorMXDesc(claimResponseMainInfo.getErrorDesc());
				/** �ϴ�ʱ�� */
				
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
				/** �ϴ���־λ��������ƴ��batchNo�� */
				agriClaimUploadLogDto.setFlag(flag);
				BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
				try {
					blacuf.insert(agriClaimUploadLogDto);
				} catch (Exception e) {
					System.out.println("������Ϣ�������ݴ洢�쳣");
					e.printStackTrace();
				}
			}	
		}else{
			AgriClaimUploadLogDto agriClaimUploadLogDto = null;
		    for(int i=0;i<size;i++){
			    agriClaimUploadLogDto = new AgriClaimUploadLogDto();
			    agriClaimUploadLogDto.setBatchNo(claimResponseDto.getBatchNo());
			    System.err.println(claimResponseDto.getBatchNo());
			    agriClaimUploadLogDto.setErrorCode(claimResponseDto.getErrorCode());
			    System.err.println(claimResponseDto.getErrorCode());
			    agriClaimUploadLogDto.setErrorDesc(claimResponseDto.getErrorDesc());
			    System.err.println(claimResponseDto.getErrorDesc());
			    agriClaimUploadLogDto.setResponseCode(claimResponseDto.getResponseCode());
			    System.err.println(claimResponseDto.getResponseCode());
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
	 * ��ȡ�����ϴ���������Ϣ
	 * 
	 * @throws Exception
	 * @throws UserException
	 */
	public void claimUploadIn(ClaimResponseDto claimResponseDto, ArrayList claimDtoList)
			throws UserException, Exception {
		if(claimResponseDto.getClaimResponseMainInfoList()!=null){
			for (int i = 0; i < claimResponseDto.getClaimResponseMainInfoList().length; i++) {
				AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto();
				/** ��ȡ���κ� */
				agriClaimDemandDto.setBatchNo(claimResponseDto.getBatchNo());
				/** ��ȡ�ӿ���Ӧ���� */
				agriClaimDemandDto.setResponseCode(claimResponseDto.getResponseCode());
				/** ������� */
				ClaimResponseMainInfo[] crmi = claimResponseDto.getClaimResponseMainInfoList();
				ClaimResponseMainInfo claimResponseMainInfo = crmi[i];
				agriClaimDemandDto.setClaimCode(claimResponseMainInfo.getClaimSequenceNo());
				/** ������ */
				String claimNo = claimResponseMainInfo.getClaimNumber();
				agriClaimDemandDto.setClaimNo(claimNo);
				/**��ȡ�ϴ���־λ*/
				String responseMXcode = claimResponseMainInfo.getResponseCode();
				if(responseMXcode.equals("1")){
					agriClaimDemandDto.setClaimUploadFlag("1");
				}else{
					agriClaimDemandDto.setClaimUploadFlag("0");
				}
				/** ��ȡ���ִ��� */
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
				String riskCode = prpLclaimDto.getRiskCode();
				agriClaimDemandDto.setRiskCode(riskCode);
				BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
				try {
					blacdf.insert(agriClaimDemandDto);
				} catch (Exception e) {
					System.out.println("������Ϣ�ϴ����ݴ洢�쳣");
					e.printStackTrace();
				}

			}
		}else{
			AgriClaimDemandDto agriClaimDemandDto = null;
			for(int i=0;i<claimDtoList.size();i++){
				ClaimDto claimDto =  (ClaimDto)claimDtoList.get(i);
				agriClaimDemandDto = new AgriClaimDemandDto();
				String ClaimNumber =  claimDto.getClaimMainInfo().getClaimNumber();
				agriClaimDemandDto.setBatchNo(claimResponseDto.getBatchNo());
				agriClaimDemandDto.setCaseNo(ClaimNumber);
				agriClaimDemandDto.setCaseUploadFlag(claimResponseDto.getResponseCode());
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
