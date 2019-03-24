package com.sinosoft.claimzy.bl.action;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.AgriXZrequest.bl.facade.BLCorrectRequest_TempFacade;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.aip.webservice.server.AIPWebService;
import com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceLocator;
import com.sinosoft.aip.webservice.server.CancelDto;
import com.sinosoft.aip.webservice.server.CancelResponseDto;
import com.sinosoft.aip.webservice.server.ClaimDto;
import com.sinosoft.aip.webservice.server.ClientInfo;
import com.sinosoft.claimzy.bl.facade.BLAgriDemandFacade;
import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.UploadData;
import com.sinosoft.claimzy.facade.BLPrpLcancelZYFacade;
import com.sinosoft.claimzy.facade.BLPrplCancelZYFResponse;
import com.sinosoft.claimzy.util.BLFZCancelDto;
import com.sinosoft.claimzy.util.BLGetMaxNo;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.sysframework.common.util.EncryptUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * 定时任务自动上传农险注销/拒赔数据平台类
 * 
 * @author CDB
 * @创建时间：2015-07-06
 */
public class BLAGRIZYCancelUploadAction {
	private static Log logger = LogFactory.getLog(BLAGRIZYCancelUploadAction.class);
	
	private static BLAGRIZYCancelUploadAction instance = new BLAGRIZYCancelUploadAction();

	/**
	 * 构造方法
	 */
	public BLAGRIZYCancelUploadAction() {
		// 禁止构造
	}

	/**
	 * 获取实例
	 */
	public static BLAGRIZYCancelUploadAction getInstance() {
		return instance;
	}

	/**
	 * 注销/拒赔数据定时任务自动上传
	 * 
	 * @throws Exception
	 * 
	 */
	public String autoCancelUpload(String startTime, String endTime, String dataType, int uSize, String requestType) throws Exception {
		String message="";//获取返回信息
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(date);
		String comCode = AppConfig.get("sysconst.COMCODE");
		String user = AppConfig.get("sysconst.USER");
		String password = EncryptUtils.md5(AppConfig.get("sysconst.PASSWORD"));
		String riskCode = AppConfig.get("sysconst.RISKCODE");
		String async = "";
		UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Cancel_AsyncFlag", 1);
		async = utiPlatConfigRuleDto.getRule();
		ClientInfo clientInfo = new ClientInfo();//接口请求参数
		clientInfo.setInsuranceCompanyCode(comCode);
		clientInfo.setUser(user);
		clientInfo.setPassword(password);
		clientInfo.setRequestType(requestType);
		clientInfo.setAsync(async);
		clientInfo.setDataType(dataType);
		BLPrpLcancelZYFacade blPrpLcancelZYFacade = new BLPrpLcancelZYFacade();
		int flag=0;
		ArrayList<UploadData> dataCollection = new ArrayList<UploadData>();
		String claimNo = null;
		UploadData uploadData = null;
		BLFZCancelDto blFZCancelDto = new BLFZCancelDto();//对象参数封装类
		try{
		 while(true) {
			 if("2".equals(requestType)){//修正请求判断
				 dataCollection = finRequestUploadData(uSize);
			 }else{
				 dataCollection = findCancelMainInfoUploadData(riskCode, startTime, endTime, uSize);
			 }
			  if (dataCollection.size() == 0 || dataCollection == null) {
				break;
			  }
//			int listSize = dataCollection.size();
//			CancelDto[] cancelDtoList = new CancelDto[listSize];
//			int i = 0;
			CancelResponseDto cancelResponseDto = new CancelResponseDto();
			//获取上传批次号  
			BLGetMaxNo blGetMaxNo = new BLGetMaxNo();
		    String batchNo = blGetMaxNo.getMaxNo(comCode);
			ArrayList cancelDtoList = new ArrayList();
			// 循环获得dataCollection集合中的数据，并获得封装的Dto数据放入参数数组中
			for (Iterator iter = dataCollection.iterator(); iter.hasNext();) {
				uploadData = (UploadData) iter.next();
				if("2".equals(requestType)){//修正请求判断
					claimNo = uploadData.getBusinessNo();
					String batchNo1 = uploadData.getBatchNo();
			    	batchNo = batchNo+"/"+batchNo1;
				}else{
					claimNo = blPrpLcancelZYFacade.findByPrimaryKey(uploadData.getClaimNo()).getClaimNumber();
				}
				CancelDto cancelDto = new CancelDto();
				cancelDto = blFZCancelDto.FZCancelDto(claimNo);
				cancelDtoList.add(cancelDto);
				//i++;
				if (cancelDtoList.size() ==dataCollection.size() ) {
					try {
						clientInfo.setBatchNo(batchNo);
						clientInfo.setListSize(cancelDtoList.size());
						CancelDto[] cancelFarmerArray = (CancelDto[])cancelDtoList.toArray(new CancelDto[cancelDtoList.size()]);
						AIPWebServiceImplServiceLocator service = new AIPWebServiceImplServiceLocator();
						AIPWebService facade = service.getAIPWebServiceImplPort();
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String start1 = sdf1.format(new Date());
						cancelResponseDto = facade.uploadCancelInfo(clientInfo, cancelFarmerArray);
						String responseCode = cancelResponseDto.getResponseCode();//获取接口响应代码
						if("2".equals(requestType)){//修正请求判断
							CorrectRequest_TempDto cRquestDto = new CorrectRequest_TempDto();
							BLCorrectRequest_TempFacade blCorrectRequest = new BLCorrectRequest_TempFacade();
							if("1".equals(responseCode)){//增加判断用于向修正数据表中改写标志位
								cRquestDto.setBusinessNo(claimNo);
								cRquestDto.setBusinessType("Cancel");
								cRquestDto.setFlag("1");
								blCorrectRequest.update(cRquestDto);
							}else{
								cRquestDto.setBusinessNo(claimNo);
								cRquestDto.setBusinessType("Cancel");
								cRquestDto.setFlag("0");
								blCorrectRequest.update(cRquestDto);
							}
						}
						String end1 = sdf1.format(new Date());
						System.out.println("开始时间1111111111：" + start1);
						System.out.println("结束时间2222222222：" + end1);
						BLPrplCancelZYFResponse blPrplCancelZYFResponse = new BLPrplCancelZYFResponse();
						// 返回数据信息
						blPrplCancelZYFResponse.cancelResponseSave(cancelResponseDto, flag, cancelDtoList.size());
						// 上传数据信息
						blPrplCancelZYFResponse.cancelUploadInfo(cancelResponseDto, cancelDtoList);
						message = cancelResponseDto.getErrorDesc();
					} catch (Exception e) {
						e.printStackTrace();
						if (logger.isDebugEnabled()) {
							logger.debug("农险平台定时任务上传失败(注销/拒赔信息上传)！立案号："+ uploadData.getClaimNo());
						}
					}
				}
				message = cancelResponseDto.getErrorDesc();
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("开始时间是："+d);
		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = sdf1.format(date1);
		System.out.println("结束时间是："+dd);
		return message+"</br>"+"开始时间是:"+d+"</br>"+"结束时间是:"+dd;
	}

	/**
	 * 查询需要上传平台的注销/拒赔数据
	 * 
	 * @throws Exception
	 */
	public ArrayList<UploadData> findCancelMainInfoUploadData(String riskCode, String sDate, String eDate, int Rnumber)
			throws Exception {
		String[] arrRiskCode = riskCode.split(",");
		String strRiskCode = "";
		for (int i = 0; i < arrRiskCode.length; i++) {
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0, strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append("  Select prplclaim.claimNo                              ");
		buffer.append("  From prplclaim,prpcmain                        ");
		buffer.append("  Where prplclaim.policyno=prpcmain.policyno    ");
		buffer.append("  And not exists(                                       ");
		buffer.append("  Select 1 From agriclaimdemand                         ");
		buffer.append("  Where agriclaimdemand.claimNo=prplclaim.claimNo       ");
		buffer.append("  And agriclaimdemand.canceluploadflag='1'              ");
		buffer.append("  )                                                     ");
		buffer.append("  And not exists(                                       ");
		buffer.append("  Select 0 from agriclaimdemand                         ");
		buffer.append("  Where agriclaimdemand.claimNo=prplclaim.claimNo       ");
		buffer.append("  And agriclaimdemand.canceluploadflag='0'              ");
		buffer.append("  )                                                     ");
		buffer.append("  And prplclaim.riskcode In (" + strRiskCode + ")       ");
		buffer.append(" And prplclaim.canceldate  between Date '"+sDate+"' and Date '"+eDate+"' ");
		buffer.append(" And prpcmain.underwriteenddate>= Date '2013-01-01'     ");
		buffer.append("  And rownum<=" + Rnumber + "   ");
		strWhere = buffer.toString();
		if (logger.isDebugEnabled()) {
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList resultList = new ArrayList();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			resultSet = dbManager.executeQuery(strWhere);
			while (resultSet.next()) {
				UploadData uploadData = new UploadData();
				uploadData.setClaimNo(dbManager.getString(resultSet, 1));
				resultList.add(uploadData);
			}
		} catch (Exception exception) {
			throw exception;
		} finally {
			if (resultSet != null) {
				resultSet.close();
			}
			dbManager.close();
		}
		return resultList;

	}
	
	/**
	 * 查询需要上传平台的注销/拒赔的修正数据
	 * @throws Exception 
	 */
	public ArrayList<UploadData> finRequestUploadData(int Rum) throws Exception{
		String strWhere ="";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append(" Select batchno,businessno from CORRECTREQUEST_TEMP ");
		buffer.append(" Where businesstype = 'Cancel' ");
		buffer.append(" And flag is null             ");
		buffer.append(" And rownum<=" + Rum + "      ");
		strWhere = buffer.toString();
		if(logger.isDebugEnabled()){
			logger.debug(strWhere);
		}
		DBManager dbManager = new DBManager();
		ResultSet resultSet = null;
		ArrayList<UploadData> resultList = new ArrayList<UploadData>();
		try {
			dbManager.open(AppConfig.get("sysconst.DBJNDI"));
			resultSet = dbManager.executeQuery(strWhere);
			while (resultSet.next()) {
				UploadData uploadData = new UploadData();
				uploadData.setBatchNo(dbManager.getString(resultSet, 1));
				uploadData.setBusinessNo(dbManager.getString(resultSet, 2));
				resultList.add(uploadData);
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
			}
			dbManager.close();
		}
		return resultList;
		
	}
}

	