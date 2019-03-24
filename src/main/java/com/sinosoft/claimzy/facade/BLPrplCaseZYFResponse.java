package com.sinosoft.claimzy.facade;

import java.util.ArrayList;

import com.sinosoft.aip.webservice.server.CaseDto;
import com.sinosoft.aip.webservice.server.CaseResponseDto;
import com.sinosoft.aip.webservice.server.CaseResultInfo;
import com.sinosoft.claimzy.bl.facade.BLAgriClaimUploadLogFacade;
import com.sinosoft.claimzy.bl.facade.BLAgriDemandFacade;
import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.utility.error.UserException;

/**
 * �����ⰸ��Ϣ�������ϴ��ͷ�����Ϣ��
 * 
 * @author CDB
 * 
 */
public class BLPrplCaseZYFResponse {
	/** �����ⰸ���ص����ݵ���Ϣ 
	 * @throws Exception */
	public void caseResponseSave(CaseResponseDto caseResponseDto, int flag,  ArrayList caseDtoList,String batchNo) throws Exception {
		
		if(caseResponseDto.getCaseResultInfoList()!=null){
			
		
		
			for (int i = 0; i < caseResponseDto.getCaseResultInfoList().length; i++) {
				AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
				/** �������κ� */
				agriClaimUploadLogDto.setBatchNo(caseResponseDto.getBatchNo());
				/** �ӿ���Ӧ���� */
				agriClaimUploadLogDto.setResponseCode(caseResponseDto.getResponseCode());
				/** ������� */
				agriClaimUploadLogDto.setErrorCode(caseResponseDto.getErrorCode());
				/** �������� */
				agriClaimUploadLogDto.setErrorDesc(caseResponseDto.getErrorDesc());
	
				/** ������� */
				CaseResultInfo[] cri = caseResponseDto.getCaseResultInfoList();
				CaseResultInfo caseResultInfo = cri[i];
			    agriClaimUploadLogDto.setClaimCode(caseResultInfo.getClaimSequenceNo());
				/** �ⰸ�� */
				agriClaimUploadLogDto.setCaseNo(caseResultInfo.getCaseNumber());
				/** ��ϸ��Ӧ���� */
				agriClaimUploadLogDto.setResponseMXCode(caseResultInfo.getResponseCode());
				/** ��ϸ������� */
				agriClaimUploadLogDto.setErrorMXCode(caseResultInfo.getErrorCode());
				/** ��ϸ����˵�� */
				agriClaimUploadLogDto.setErrorMXDesc(caseResultInfo.getErrorDesc());
				/** �ϴ�ʱ�� */
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
				/** �ϴ����ⰸ�����ķֻ��⸶ũ������ */
				agriClaimUploadLogDto.setFlag(flag);
				BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
				blacuf.insert(agriClaimUploadLogDto);
			}
		}else{

			AgriClaimUploadLogDto agriClaimUploadLogDto = null;
			    for(int i=0;i<caseDtoList.size();i++){
			    	CaseDto caseDto =  (CaseDto)caseDtoList.get(i);
				    agriClaimUploadLogDto = new AgriClaimUploadLogDto();
				    String caseNumber =  caseDto.getCaseMainInfo().getCaseNumber();
				    agriClaimUploadLogDto.setCaseNo(caseNumber);
				    agriClaimUploadLogDto.setBatchNo(batchNo);
				    agriClaimUploadLogDto.setErrorCode(caseResponseDto.getErrorCode());
				    System.err.println(caseResponseDto.getErrorCode());
				    agriClaimUploadLogDto.setErrorDesc(caseResponseDto.getErrorDesc());
				    System.err.println(caseResponseDto.getErrorDesc());
				    agriClaimUploadLogDto.setResponseCode(caseResponseDto.getResponseCode());
				    System.err.println(caseResponseDto.getResponseCode());
				    /** �ϴ�ʱ�� */
					DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
					agriClaimUploadLogDto.setUploadDate(date);
					agriClaimUploadLogDto.setFlag(flag);
				    BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
					blacuf.insert(agriClaimUploadLogDto);
			}
		}

	}

	/**
	 * ��ȡ�ⰸ�ϴ���������Ϣ
	 * 
	 * @throws Exception
	 * @throws UserException
	 */
	public void caseUploadInfo(CaseResponseDto caseResponseDto, ArrayList caseDtoList,String batchNo)throws UserException, Exception {
		if(caseResponseDto.getCaseResultInfoList()!=null){
			AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto();
			for (int i = 0; i < caseResponseDto.getCaseResultInfoList().length; i++) {
				/** ��ȡ���κ� */
				agriClaimDemandDto.setBatchNo(caseResponseDto.getBatchNo());
				/** ��ȡ�ӿ���Ӧ���� */
				agriClaimDemandDto.setResponseCode(caseResponseDto.getResponseCode());
				/** ��ȡ������� */
				CaseResultInfo[] cri = caseResponseDto.getCaseResultInfoList();
				CaseResultInfo caseResultInfo = cri[i];
				agriClaimDemandDto.setClaimCode(caseResultInfo.getClaimSequenceNo());
				/** ��ȡ�ⰸ�� */
				String caseNo = caseResultInfo.getCaseNumber();
				agriClaimDemandDto.setCaseNo(caseNo);
				
				/**��ȡ�ϴ���־λ*/
				String responseMXcode = caseResultInfo.getResponseCode();
				if(responseMXcode.equals("1")){
					agriClaimDemandDto.setCaseUploadFlag("1");
				}else{
					agriClaimDemandDto.setCaseUploadFlag("0");
				}
				BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
                blacdf.insert(agriClaimDemandDto);
			}
		}else{
			AgriClaimDemandDto agriClaimDemandDto = null;
			for(int i=0;i<caseDtoList.size();i++){
				CaseDto caseDto =  (CaseDto)caseDtoList.get(i);
				agriClaimDemandDto = new AgriClaimDemandDto();
				String CaseNumber =  caseDto.getCaseMainInfo().getCaseNumber();
				agriClaimDemandDto.setBatchNo(batchNo);
				agriClaimDemandDto.setCaseNo(CaseNumber);
				agriClaimDemandDto.setCaseUploadFlag(caseResponseDto.getResponseCode());
				BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
				blacdf.insert(agriClaimDemandDto);		
			}
			
		}
	}

}
