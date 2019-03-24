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
 * 这是预赔案信息的数据上传和返回信息类
 * @author CDB
 *
 */
public class BLPrplPrepaidZYFResponse {
	/**设置预赔案返回的数据信息*/
	public void prepaidResponseSave(PrepaidResponseDto prepaidResponseDto,int flag,int size){
		AgriClaimUploadLogDto agriClaimUploadLogDto = new AgriClaimUploadLogDto();
		for(int i=0;i<size;i++){
			/**设置接口响应代码*/
			agriClaimUploadLogDto.setResponseCode(prepaidResponseDto.getResponseCode());
			/**设置错误代码*/
			agriClaimUploadLogDto.setErrorCode(prepaidResponseDto.getErrorCode());
			/**设置错误说明*/
			agriClaimUploadLogDto.setErrorDesc(prepaidResponseDto.getErrorDesc());
			/**设置批次号*/
			agriClaimUploadLogDto.setBatchNo(prepaidResponseDto.getBatchNo());
			
			/**理赔编码*/
		    PrepaidResultInfo[] pri = prepaidResponseDto.getPrepaidResultInfoList();
		    PrepaidResultInfo prepaidResultInfo = pri[i];
		    agriClaimUploadLogDto.setClaimCode(prepaidResultInfo.getClaimSequenceNo());
		    /**设置预赔案号*/
		    agriClaimUploadLogDto.setPreCompensateNo(prepaidResultInfo.getPrepayCaseNumber());
		    /**设置详细响应代码*/
		    agriClaimUploadLogDto.setResponseMXCode(prepaidResultInfo.getResponseCode());
		    /**设置详细错误代码*/
		    agriClaimUploadLogDto.setErrorMXCode(prepaidResultInfo.getErrorCode());
		    /**设置详细错误说明*/
		    agriClaimUploadLogDto.setErrorMXDesc(prepaidResultInfo.getErrorDesc());
		    /**上传标志位，（用于拼接batchNo）*/
		    agriClaimUploadLogDto.setFlag(flag);
		    /**上传时间*/
		    DateTime date = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_SECOND);
			agriClaimUploadLogDto.setUploadDate(date);
			BLAgriClaimUploadLogFacade blacuf = new BLAgriClaimUploadLogFacade();
			try {
				blacuf.insert(agriClaimUploadLogDto);
			} catch (Exception e) {
				System.out.println("预赔案信息返回数据存储异常");
				e.printStackTrace();
			}
		}
	}
	/**
	 * 获取预赔案上传的数据信息
	 * @throws Exception 
	 * @throws UserException 
	 */
	public void prepaidUploadInfo(PrepaidResponseDto prepaidResponseDto,int size) throws UserException, Exception{
		AgriClaimDemandDto agriClaimDemandDto = new AgriClaimDemandDto();
		for(int i=0;i<size;i++){
			/**获取批次号*/
			agriClaimDemandDto.setBatchNo(prepaidResponseDto.getBatchNo());
			/**获取接口响应代码*/
			agriClaimDemandDto.setResponseCode(prepaidResponseDto.getResponseCode());
			/**获取理赔编码*/
			PrepaidResultInfo[] pri = prepaidResponseDto.getPrepaidResultInfoList();
			PrepaidResultInfo prepaidResultInfo = pri[i];
			agriClaimDemandDto.setClaimCode(prepaidResultInfo.getClaimSequenceNo());
			/** 预赔案号 */
			String preCompensateNo = prepaidResultInfo.getPrepayCaseNumber();
			agriClaimDemandDto.setPreCompensateNo(preCompensateNo);
			/**获取上传标志位*/
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
	        	   System.out.println("预赔案信息上传数据存储异常");
	    		   e.printStackTrace();
	        }
		}
		}
}
