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
 * ��ʱ�����Զ��ϴ�ũ����������ƽ̨��
 * 
 * @author CDB
 * @����ʱ�䣺2015-06-24
 */
public class BLAGRIZYClaimUploadAction {
	private static Log logger = LogFactory.getLog(BLAGRIZYClaimUploadAction.class);
	private static BLAGRIZYClaimUploadAction instance = new BLAGRIZYClaimUploadAction();

	/**
	 * ���췽��
	 */
	public BLAGRIZYClaimUploadAction() {
		// ��ֹ����
	}

	/**
	 * ��ȡʵ��
	 */
	public static BLAGRIZYClaimUploadAction getInstance() {
		return instance;
	}

	/**
	 * �������ݶ�ʱ�����Զ��ϴ�
	 * 
	 * @throws Exception
	 */
	public String autoClaimUpload(String startTime, String endTime, String dataType, int uSize, String requestType) throws Exception {
		String message = "";//��ȡ������Ϣ
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(date);
		String comCode = AppConfig.get("sysconst.COMCODE");
		String user = AppConfig.get("sysconst.USER");
		String password = EncryptUtils.md5(AppConfig.get("sysconst.PASSWORD"));
		String riskCode = AppConfig.get("sysconst.RISKCODE");
		String async = "";//�ӱ��л�ȡͬ���첽��־
		UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Claim_AsyncFlag", 1);
		async = utiPlatConfigRuleDto.getRule();
		ClientInfo clientInfo = new ClientInfo();//�ӿ��������
		clientInfo.setInsuranceCompanyCode(comCode);
		clientInfo.setUser(user);
		clientInfo.setPassword(password);
		clientInfo.setRequestType(requestType);
		clientInfo.setAsync(async);
		clientInfo.setDataType(dataType);
		BLPrpLregistZYFacade blPrplRegistZYFacade = new BLPrpLregistZYFacade();//������Ϣ��
		BLPrpLclaimZYFacade blPrplClaimZYFacade = new BLPrpLclaimZYFacade();//������Ϣ��
		int flag = 0;
		// �����ϴ�
		ArrayList<UploadData> dataCollection = new ArrayList<UploadData>();
		String registNo = null;
		String claimNo = null;
		UploadData uploadData = null;
		BLFZClaimDto blFZClaimDto = new BLFZClaimDto();//�ӿڲ�����װ��
		while(true) {//����������ж�
			if("2".equals(requestType)){
				dataCollection = finRequestUploadData(uSize);
			}else{
				dataCollection = findClaimMainInfoUploadData(riskCode,startTime,endTime,uSize);	
			}
			 if (dataCollection.size() == 0 || dataCollection == null) {//�����������whileѭ��
				break;
			 }
//			int listSize = dataCollection.size();//�ϴ���������
//			ClaimDto[] claimDtoList = new ClaimDto[listSize];
			//int i = 0;
			ClaimResponseDto claimResponseDto = new ClaimResponseDto();
			//��ȡ���κ�
			BLGetMaxNo blGetMaxNo = new BLGetMaxNo();
			String batchNo = blGetMaxNo.getMaxNo(comCode);
			ArrayList claimDtoList = new ArrayList();
			// ѭ�����dataCollection�����е����ݣ�������÷�װ��Dto���ݷ������������
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
						String responseCode = claimResponseDto.getResponseCode();//��ȡ�ӿ���Ӧ����
						if("2".equals(requestType)){//���������ж�
							CorrectRequest_TempDto cRquestDto = new CorrectRequest_TempDto();
							BLCorrectRequest_TempFacade blCorrectRequest = new BLCorrectRequest_TempFacade();
							if("1".equals(responseCode)){//�����ж��������������ݱ��и�д��־λ
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
						System.out.println("��ʼʱ��1111111111��" + start1);
						System.out.println("����ʱ��2222222222��" + end1);
						BLPrplClaimZYResponse blPrpClaimZYResponse = new BLPrplClaimZYResponse();
						blPrpClaimZYResponse.claimResponseSave(claimResponseDto,flag,claimDtoList.size());// ����������Ϣ
						blPrpClaimZYResponse.claimUploadIn(claimResponseDto,claimDtoList);// �ϴ����ݵ���Ϣ
					} catch (Exception e) {
						e.printStackTrace();
						if (logger.isDebugEnabled()) {
							logger.debug("ũ��ƽ̨��ʱ�����ϴ�ʧ��(������Ϣ�ϴ�)�������ţ�"+ uploadData.getClaimNo());
						}
					}
				}
				message = claimResponseDto.getErrorDesc();
			}
		}
		System.out.println("��ʼʱ����:"+d);
		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = sdf1.format(date1);
		System.out.println("����ʱ����:"+dd );
		return message+"</br>"+"��ʼʱ����:"+d+"</br>"+"����ʱ����:"+dd;
	}

	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨����������
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
	 * ��ѯ��Ҫ�ϴ�ƽ̨����������������
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
