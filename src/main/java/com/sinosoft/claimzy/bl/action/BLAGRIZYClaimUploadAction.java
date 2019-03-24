package com.sinosoft.claimzy.bl.action;


import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.AgriXZrequest.bl.facade.BLCorrectRequest_TempFacade;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.aip.webservice.server.AIPWebService;
import com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceLocator;
import com.sinosoft.aip.webservice.server.ClaimDto;
import com.sinosoft.aip.webservice.server.ClaimResponseDto;
import com.sinosoft.aip.webservice.server.ClientInfo;
import com.sinosoft.claim.bl.facade.BLClaimFacade;
import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claimzy.dto.domain.UploadData;
import com.sinosoft.claimzy.facade.BLPrpLclaimZYFacade;
import com.sinosoft.claimzy.facade.BLPrpLregistZYFacade;
import com.sinosoft.claimzy.facade.BLPrplClaimZYResponse;
import com.sinosoft.claimzy.util.BLFZClaimDto;
import com.sinosoft.claimzy.util.BLGetMaxNo;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.sysframework.common.util.EncryptUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;


/**
 * 定时任务自动上传农险立案数据平台类
 * 
 * @author CDB
 * @创建时间：2015-06-24
 */
public class BLAGRIZYClaimUploadAction {
	private static Log logger = LogFactory.getLog(BLAGRIZYClaimUploadAction.class);
	private static BLAGRIZYClaimUploadAction instance = new BLAGRIZYClaimUploadAction();

	/**
	 * 构造方法
	 */
	public BLAGRIZYClaimUploadAction() {
		// 禁止构造
	}

	/**
	 * 获取实例
	 */
	public static BLAGRIZYClaimUploadAction getInstance() {
		return instance;
	}

	/**
	 * 立案数据定时任务自动上传
	 * 
	 * @throws Exception
	 */
	public String autoClaimUpload(String startTime, String endTime, String dataType, int uSize, String requestType) throws Exception {
		String message = "";//获取返回信息
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(date);
		String comCode = AppConfig.get("sysconst.COMCODE");
		String user = AppConfig.get("sysconst.USER");
		String password = EncryptUtils.md5(AppConfig.get("sysconst.PASSWORD"));
		String riskCode = AppConfig.get("sysconst.RISKCODE");
		String async = "";//从表中获取同、异步标志
		UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Claim_AsyncFlag", 1);
		async = utiPlatConfigRuleDto.getRule();
		ClientInfo clientInfo = new ClientInfo();//接口请求参数
		clientInfo.setInsuranceCompanyCode(comCode);
		clientInfo.setUser(user);
		clientInfo.setPassword(password);
		clientInfo.setRequestType(requestType);
		clientInfo.setAsync(async);
		clientInfo.setDataType(dataType);
		BLPrpLregistZYFacade blPrplRegistZYFacade = new BLPrpLregistZYFacade();//报案信息类
		BLPrpLclaimZYFacade blPrplClaimZYFacade = new BLPrpLclaimZYFacade();//立案信息类
		int flag = 0;
		// 立案上传
		ArrayList<UploadData> dataCollection = new ArrayList<UploadData>();
		String registNo = null;
		String claimNo = null;
		UploadData uploadData = null;
		BLFZClaimDto blFZClaimDto = new BLFZClaimDto();//接口参数封装类
		while(true) {//修正请求的判断
			if("2".equals(requestType)){
				dataCollection = finRequestUploadData(uSize);
			}else{
				dataCollection = findClaimMainInfoUploadData(riskCode,startTime,endTime,uSize);	
			}
			 if (dataCollection.size() == 0 || dataCollection == null) {//用于跳出外层while循环
				break;
			 }
//			int listSize = dataCollection.size();//上传数据条数
//			ClaimDto[] claimDtoList = new ClaimDto[listSize];
			//int i = 0;
			ClaimResponseDto claimResponseDto = new ClaimResponseDto();
			//获取批次号
			BLGetMaxNo blGetMaxNo = new BLGetMaxNo();
			String batchNo = blGetMaxNo.getMaxNo(comCode);
			ArrayList claimDtoList = new ArrayList();
			// 循环获得dataCollection集合中的数据，并将获得封装的Dto数据放入参数数组中
			for (Iterator iter = dataCollection.iterator(); iter.hasNext();) {
				uploadData = (UploadData) iter.next();
				if("2".equals(requestType)){
					claimNo = uploadData.getBusinessNo();
					String strWhere = "Select registNo from prplclaim Where claimNo = '"+claimNo+"' ";
					DBManager dbManager = new DBManager();
					ResultSet resultSet = null;
					try{
						dbManager.open(AppConfig.get("sysconst.DBJNDI")) ;
						resultSet = dbManager.executeQuery(strWhere);
						if(resultSet.next()){	
							registNo = dbManager.getString(resultSet, 1);
						}	
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						if (resultSet != null) {
							resultSet.close();
						}
						dbManager.close();
					}
					String batchNo1 = uploadData.getBatchNo();
					batchNo = batchNo+"/"+batchNo1;
				}else{
					registNo = blPrplRegistZYFacade.findByPrimaryKey(uploadData.getRegistNo()).getNotificationNumber();
					claimNo = blPrplClaimZYFacade.findByPrimaryKey(uploadData.getClaimNo()).getClaimNumber();
				}
				ClaimDto claimDto = new ClaimDto();
				claimDto = blFZClaimDto.FZClaimDto(registNo, claimNo);
				claimDtoList.add(claimDto);
				//i++;
				
				if (claimDtoList.size()==dataCollection.size()) {
					try {
						clientInfo.setBatchNo(batchNo);
						clientInfo.setListSize(claimDtoList.size());
						ClaimDto[] claimFarmerArray = (ClaimDto[])claimDtoList.toArray(new ClaimDto[claimDtoList.size()]);
						AIPWebServiceImplServiceLocator service = new AIPWebServiceImplServiceLocator();
						AIPWebService facade = service.getAIPWebServiceImplPort();
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String start1 = sdf1.format(new Date());
						claimResponseDto = facade.uploadClaimInfo(clientInfo, claimFarmerArray);
						String responseCode = claimResponseDto.getResponseCode();//获取接口响应代码
						if("2".equals(requestType)){//修正请求判断
							CorrectRequest_TempDto cRquestDto = new CorrectRequest_TempDto();
							BLCorrectRequest_TempFacade blCorrectRequest = new BLCorrectRequest_TempFacade();
							if("1".equals(responseCode)){//增加判断用于向修正数据表中改写标志位
								cRquestDto.setBusinessNo(claimNo);
								cRquestDto.setBusinessType("Claim");
								cRquestDto.setFlag("1");
								blCorrectRequest.update(cRquestDto);
							}else{
								cRquestDto.setBusinessNo(claimNo);
								cRquestDto.setBusinessType("Claim");
								cRquestDto.setFlag("0");
								blCorrectRequest.update(cRquestDto);
							}
						}
						String end1 = sdf1.format(new Date());
						System.out.println("开始时间1111111111：" + start1);
						System.out.println("结束时间2222222222：" + end1);
						BLPrplClaimZYResponse blPrpClaimZYResponse = new BLPrplClaimZYResponse();
						blPrpClaimZYResponse.claimResponseSave(claimResponseDto,flag,claimDtoList.size());// 返回数据信息
						blPrpClaimZYResponse.claimUploadIn(claimResponseDto,claimDtoList);// 上传数据的信息
					} catch (Exception e) {
						e.printStackTrace();
						if (logger.isDebugEnabled()) {
							logger.debug("农险平台定时任务上传失败(立案信息上传)！立案号："+ uploadData.getClaimNo());
						}
					}
				}
				message = claimResponseDto.getErrorDesc();
			}
		}
		System.out.println("开始时间是:"+d);
		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = sdf1.format(date1);
		System.out.println("结束时间是:"+dd );
		return message+"</br>"+"开始时间是:"+d+"</br>"+"结束时间是:"+dd;
	}

	/**
	 * 查询需要上传平台的立案数据
	 * 
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public ArrayList<UploadData> findClaimMainInfoUploadData(String riskCode, String sDate, String eDate,  int Rnumber)
			throws Exception {
		String[] arrRiskCode = riskCode.split(",");
		String strRiskCode = "";
		for (int i = 0; i < arrRiskCode.length; i++) {
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0, strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append(" Select prplclaim.claimno,prplclaim.registno From prplclaim,prpcmain ");
		buffer.append(" Where not exists(                                       ");
		buffer.append("     Select 1 From agriclaimdemand                         ");
		buffer.append("     Where agriclaimdemand.claimNo=prplclaim.claimNo     ");
		buffer.append("     And agriclaimdemand.claimuploadflag='1'               ");
		buffer.append("     And agriclaimdemand.riskcode In ( "+ strRiskCode +" ) ");
		buffer.append(")                                                          ");
		buffer.append("     And not exists(                                       ");
		buffer.append("     Select 0 from agriclaimdemand                         ");
		buffer.append("     Where agriclaimdemand.claimNo=prplclaim.claimNo       ");
		buffer.append("     And agriclaimdemand.claimuploadflag='0'             ");
		buffer.append("     And agriclaimdemand.riskcode In ( "+ strRiskCode +" ) ");
		buffer.append(" )                                                         ");
		buffer.append("     And prplclaim.riskcode In (" + strRiskCode + ")       ");
		buffer.append(" And prplclaim.claimdate  between Date '"+sDate+"' and Date '"+eDate+"' ");
		buffer.append(" And prpcmain.underwriteenddate >= Date '2013-01-01'       ");
		buffer.append(" And prplclaim.policyno=prpcmain.policyno                  ");
		buffer.append("     And rownum<=" + Rnumber + " ");
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
				uploadData.setRegistNo(dbManager.getString(resultSet, 2));
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
	 * 查询需要上传平台的立案的修正数据
	 * @throws Exception 
	 */
	public ArrayList<UploadData> finRequestUploadData(int Rum) throws Exception{
		String strWhere ="";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append(" Select batchno,businessno from CORRECTREQUEST_TEMP ");
		buffer.append(" Where businesstype = 'Claim' ");
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
