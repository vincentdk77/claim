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
 * 这是立案信息的数据上传和返回信息类
 * 
 * @author CDB
 * 
 */
public class BLPrplClaimZYResponse {
	/** 设置立案返回的数据的信息 */
	public void claimResponseSave(ClaimResponseDto claimResponseDto, int flag,int size) {

		if(claimResponseDto.getClaimResponseMainInfoList()!=null){
			
			for (int i = 0; i <claimResponseDto.getClaimResponseMainInfoList().length; i++) {
				AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
				/** 设置批次号 */
				agriClaimUploadLogDto.setBatchNo(claimResponseDto.getBatchNo());
				/** 接口响应代码 */
				agriClaimUploadLogDto.setResponseCode(claimResponseDto.getResponseCode());
				/** 错误代码 */
				agriClaimUploadLogDto.setErrorCode(claimResponseDto.getErrorCode());
				/** 错误描述 */
				agriClaimUploadLogDto.setErrorDesc(claimResponseDto.getErrorDesc());

				/** 理赔编码 */
				ClaimResponseMainInfo[] crmi = claimResponseDto.getClaimResponseMainInfoList();
				ClaimResponseMainInfo claimResponseMainInfo = crmi[i];
				agriClaimUploadLogDto.setClaimCode(claimResponseMainInfo.getClaimSequenceNo());
				/** 立案号 */
				agriClaimUploadLogDto.setClaimNo(claimResponseMainInfo.getClaimNumber());
				/** 明细响应代码 */
				agriClaimUploadLogDto.setResponseMXCode(claimResponseMainInfo.getResponseCode());
				/** 明细错误代码 */
				agriClaimUploadLogDto.setErrorMXCode(claimResponseMainInfo.getErrorCode());
				/** 明细错误说明 */
				agriClaimUploadLogDto.setErrorMXDesc(claimResponseMainInfo.getErrorDesc());
				/** 上传时间 */
				
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
				/** 上传标志位，（用于拼接batchNo） */
				agriClaimUploadLogDto.setFlag(flag);
				BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
				try {
					blacuf.insert(agriClaimUploadLogDto);
				} catch (Exception e) {
					System.out.println("立案信息返回数据存储异常");
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
			    /** 上传时间 */
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
			    BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
				try {	
					blacuf.insert(agriClaimUploadLogDto);
				} catch (Exception e) {
					System.out.println("立案信息返回数据存储异常");
					e.printStackTrace();
				}
		}
		}
		
	}

	/**
	 * 获取立案上传的数据信息
	 * 
	 * @throws Exception
	 * @throws UserException
	 */
	public void claimUploadIn(ClaimResponseDto claimResponseDto, ArrayList claimDtoList)
			throws UserException, Exception {
		if(claimResponseDto.getClaimResponseMainInfoList()!=null){
			for (int i = 0; i < claimResponseDto.getClaimResponseMainInfoList().length; i++) {
				AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto();
				/** 获取批次号 */
				agriClaimDemandDto.setBatchNo(claimResponseDto.getBatchNo());
				/** 获取接口响应代码 */
				agriClaimDemandDto.setResponseCode(claimResponseDto.getResponseCode());
				/** 理赔编码 */
				ClaimResponseMainInfo[] crmi = claimResponseDto.getClaimResponseMainInfoList();
				ClaimResponseMainInfo claimResponseMainInfo = crmi[i];
				agriClaimDemandDto.setClaimCode(claimResponseMainInfo.getClaimSequenceNo());
				/** 立案号 */
				String claimNo = claimResponseMainInfo.getClaimNumber();
				agriClaimDemandDto.setClaimNo(claimNo);
				/**获取上传标志位*/
				String responseMXcode = claimResponseMainInfo.getResponseCode();
				if(responseMXcode.equals("1")){
					agriClaimDemandDto.setClaimUploadFlag("1");
				}else{
					agriClaimDemandDto.setClaimUploadFlag("0");
				}
				/** 获取险种代码 */
				BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
				String riskCode = prpLclaimDto.getRiskCode();
				agriClaimDemandDto.setRiskCode(riskCode);
				BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
				try {
					blacdf.insert(agriClaimDemandDto);
				} catch (Exception e) {
					System.out.println("立案信息上传数据存储异常");
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
					System.out.println("立案信息上传数据存储异常");
					e.printStackTrace();
				}
				
			}
		}	
	}
}
