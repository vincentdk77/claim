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
 * 这是赔案信息的数据上传和返回信息类
 * 
 * @author CDB
 * 
 */
public class BLPrplCaseZYFResponse {
	/** 设置赔案返回的数据的信息 
	 * @throws Exception */
	public void caseResponseSave(CaseResponseDto caseResponseDto, int flag,  ArrayList caseDtoList,String batchNo) throws Exception {
		
		if(caseResponseDto.getCaseResultInfoList()!=null){
			
		
		
			for (int i = 0; i < caseResponseDto.getCaseResultInfoList().length; i++) {
				AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
				/** 设置批次号 */
				agriClaimUploadLogDto.setBatchNo(caseResponseDto.getBatchNo());
				/** 接口响应代码 */
				agriClaimUploadLogDto.setResponseCode(caseResponseDto.getResponseCode());
				/** 错误代码 */
				agriClaimUploadLogDto.setErrorCode(caseResponseDto.getErrorCode());
				/** 错误描述 */
				agriClaimUploadLogDto.setErrorDesc(caseResponseDto.getErrorDesc());
	
				/** 理赔编码 */
				CaseResultInfo[] cri = caseResponseDto.getCaseResultInfoList();
				CaseResultInfo caseResultInfo = cri[i];
			    agriClaimUploadLogDto.setClaimCode(caseResultInfo.getClaimSequenceNo());
				/** 赔案号 */
				agriClaimUploadLogDto.setCaseNo(caseResultInfo.getCaseNumber());
				/** 明细响应代码 */
				agriClaimUploadLogDto.setResponseMXCode(caseResultInfo.getResponseCode());
				/** 明细错误代码 */
				agriClaimUploadLogDto.setErrorMXCode(caseResultInfo.getErrorCode());
				/** 明细错误说明 */
				agriClaimUploadLogDto.setErrorMXDesc(caseResultInfo.getErrorDesc());
				/** 上传时间 */
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
				/** 上传的赔案关联的分户赔付农户数量 */
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
				    /** 上传时间 */
					DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
					agriClaimUploadLogDto.setUploadDate(date);
					agriClaimUploadLogDto.setFlag(flag);
				    BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
					blacuf.insert(agriClaimUploadLogDto);
			}
		}

	}

	/**
	 * 获取赔案上传的数据信息
	 * 
	 * @throws Exception
	 * @throws UserException
	 */
	public void caseUploadInfo(CaseResponseDto caseResponseDto, ArrayList caseDtoList,String batchNo)throws UserException, Exception {
		if(caseResponseDto.getCaseResultInfoList()!=null){
			AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto();
			for (int i = 0; i < caseResponseDto.getCaseResultInfoList().length; i++) {
				/** 获取批次号 */
				agriClaimDemandDto.setBatchNo(caseResponseDto.getBatchNo());
				/** 获取接口响应代码 */
				agriClaimDemandDto.setResponseCode(caseResponseDto.getResponseCode());
				/** 获取理赔编码 */
				CaseResultInfo[] cri = caseResponseDto.getCaseResultInfoList();
				CaseResultInfo caseResultInfo = cri[i];
				agriClaimDemandDto.setClaimCode(caseResultInfo.getClaimSequenceNo());
				/** 获取赔案号 */
				String caseNo = caseResultInfo.getCaseNumber();
				agriClaimDemandDto.setCaseNo(caseNo);
				
				/**获取上传标志位*/
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
