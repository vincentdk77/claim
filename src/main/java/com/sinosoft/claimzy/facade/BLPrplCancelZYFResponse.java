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
 * 这是注销/拒赔信息的数据上传和返回信息类
 * @author CDB
 *
 */
public class BLPrplCancelZYFResponse {
	/**设置注销/拒赔返回的数据信息*/
	public void cancelResponseSave(CancelResponseDto cancelResponseDto,int flag,int size){
	
		if(cancelResponseDto.getCancelResultInfoList()!=null){
			for(int i=0;i<cancelResponseDto.getCancelResultInfoList().length;i++){
				AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
				/**设置批次号*/
				agriClaimUploadLogDto.setBatchNo(cancelResponseDto.getBatchNo());
				/**接口响应代码*/
				agriClaimUploadLogDto.setResponseCode(cancelResponseDto.getResponseCode());
				/**错误代码*/
				agriClaimUploadLogDto.setErrorCode(cancelResponseDto.getErrorCode());
				/**错误说明*/
				agriClaimUploadLogDto.setErrorDesc(cancelResponseDto.getErrorDesc());
				
				/**理赔编码*/
				CancelResultInfo[] cri = cancelResponseDto.getCancelResultInfoList();
				CancelResultInfo cancelResultInfo = cri[i];
				agriClaimUploadLogDto.setClaimCode(cancelResultInfo.getClaimSequenceNo());
				/**立案号*/
				agriClaimUploadLogDto.setClaimNo(cancelResultInfo.getClaimNumber());
				/**明细响应代码*/
				agriClaimUploadLogDto.setResponseMXCode(cancelResultInfo.getResponseCode());
				/**明细错误代码*/
				agriClaimUploadLogDto.setErrorMXCode(cancelResultInfo.getErrorCode());
				/**明细错误说明*/
				agriClaimUploadLogDto.setErrorMXDesc(cancelResultInfo.getErrorDesc());
				/**上传时间*/
				DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
				agriClaimUploadLogDto.setUploadDate(date);
				/**上传标志位，（用于拼接batchNo）*/
				agriClaimUploadLogDto.setFlag(flag);
				BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
				try {
					blacuf.insert(agriClaimUploadLogDto);
				} catch (Exception e) {
					System.out.println("注销/拒赔信息返回数据存储异常");
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
	 * 获取注销/拒赔上传的数据信息
	 * @throws Exception 
	 * @throws UserException 
	 */
	public void cancelUploadInfo(CancelResponseDto cancelResponseDto,ArrayList cancelDtoList) throws UserException, Exception{
		if(cancelResponseDto.getCancelResultInfoList()!=null){
			for(int i=0;i<cancelResponseDto.getCancelResultInfoList().length;i++){
				AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto(); 
		    	/**获取批次号*/
		    	agriClaimDemandDto.setBatchNo(cancelResponseDto.getBatchNo());
		    	/**获取接口响应代码*/
		    	agriClaimDemandDto.setResponseCode(cancelResponseDto.getResponseCode());
		    	/** 理赔编码 */
				CancelResultInfo[] cri = cancelResponseDto.getCancelResultInfoList();
				CancelResultInfo cancelResultInfo = cri[i];
				agriClaimDemandDto.setClaimCode(cancelResultInfo.getClaimSequenceNo());
				/** 立案号 */
				String claimNo = cancelResultInfo.getClaimNumber();
				agriClaimDemandDto.setClaimNo(claimNo);
				/**获取上传标志位*/
				String responseMXcode = cancelResultInfo.getResponseCode();
				if(responseMXcode.equals("1")){
					agriClaimDemandDto.setCancelUploadFlag("1");
				}else{
					agriClaimDemandDto.setCancelUploadFlag("0");
				}
		    	/**获取险种代码*/
		    	BLPrpLclaimFacade blPrpLclaimFacade = new BLPrpLclaimFacade();
				PrpLclaimDto prpLclaimDto = blPrpLclaimFacade.findByPrimaryKey(claimNo);
				String riskCode = prpLclaimDto.getRiskCode();
				agriClaimDemandDto.setRiskCode(riskCode);
				BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
				try{
				blacdf.insert(agriClaimDemandDto);
		        }catch(Exception e){
		    	   System.out.println("注销/拒赔信息上传数据存储异常");
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
					System.out.println("立案信息上传数据存储异常");
					e.printStackTrace();
				}
				
			}
		}
		
		}
		
}
