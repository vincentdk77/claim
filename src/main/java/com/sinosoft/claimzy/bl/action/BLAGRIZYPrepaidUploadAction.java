package com.sinosoft.claimzy.bl.action;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sinosoft.AgriXZrequest.bl.facade.BLCorrectRequest_TempFacade;
import com.sinosoft.AgriXZrequest.dto.domain.CorrectRequest_TempDto;
import com.sinosoft.aip.webservice.server.AIPWebService;
import com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceLocator;
import com.sinosoft.aip.webservice.server.ClientInfo;
import com.sinosoft.aip.webservice.server.PrepaidDto;
import com.sinosoft.aip.webservice.server.PrepaidResponseDto;
import com.sinosoft.claimzy.common.NXZYAppConfig;
import com.sinosoft.claimzy.dto.domain.UploadData;
import com.sinosoft.claimzy.facade.BLPrpLprepaidZYFacade;
import com.sinosoft.claimzy.facade.BLPrplPrepaidZYFResponse;
import com.sinosoft.claimzy.util.BLFZPrepaidDto;
import com.sinosoft.claimzy.util.BLGetMaxNo;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.sysframework.common.util.EncryptUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;

/**
 * ��ʱ�����Զ��ϴ�ũ��Ԥ�ⰸ����ƽ̨��
 * 
 * @author CDB
 * @����ʱ�䣺2015-07-10
 */
public class BLAGRIZYPrepaidUploadAction {
	private static Log logger = LogFactory.getLog(BLAGRIZYCancelUploadAction.class);
	private static BLAGRIZYPrepaidUploadAction instance = new BLAGRIZYPrepaidUploadAction();

	/**
	 * ���췽��
	 */
	public BLAGRIZYPrepaidUploadAction() {
		
	}

	/**
	 * ��ȡʵ��
	 */
	public static BLAGRIZYPrepaidUploadAction getInstance() {
		return instance;
	}

	/**
	 * �ⰸ���ݶ�ʱ�����Զ��ϴ�
	 * 
	 * @throws Exception
	 * 
	 */
	public String autoPrepaidUpload(String startTime, String endTime, String dataType, int uSize, String requestType) throws Exception {
		String message = "";//��ȡ��������
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String d = sdf.format(date);
		String comCode = AppConfig.get("sysconst.COMCODE");
		String user = AppConfig.get("sysconst.USER");
		String password = EncryptUtils.md5(AppConfig.get("sysconst.PASSWORD"));
		String async = "";
		UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
		BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
		utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Prepaid_AsyncFlag", 1);
		async = utiPlatConfigRuleDto.getRule();
		String riskCode = AppConfig.get("sysconst.RISKCODE");
		ClientInfo clientInfo = new ClientInfo();//�ӿ��������
		clientInfo.setInsuranceCompanyCode(comCode);
		clientInfo.setUser(user);
		clientInfo.setPassword(password);
		clientInfo.setRequestType(requestType);
		clientInfo.setAsync(async);
		clientInfo.setDataType(dataType);
		BLPrpLprepaidZYFacade blPrpLprepaidZYFacade = new BLPrpLprepaidZYFacade();
		int flag=0;
		// Ԥ�ⰸ�ϴ�
		Collection dataCollection = new ArrayList();
		String preCompensateNo = null;
		UploadData uploadData = null;
		BLFZPrepaidDto blFZPrepaidDto = new BLFZPrepaidDto();//���������װ��
		while (true) {
			if("2".equals(requestType)){//���������ж�
				dataCollection = finRequestUploadData(uSize);
			}else{
				dataCollection = findPrepaidMainInfoUploadData(riskCode,startTime, endTime+"23:59:59",uSize);	
			}
			 if (dataCollection.size() == 0 || dataCollection == null) {
				break;
			 }
			int listSize = dataCollection.size();
			PrepaidDto[] prepaidDtoList = new PrepaidDto[listSize];
			int i = 0;
			PrepaidResponseDto prepaidResponseDto = new PrepaidResponseDto();
			//��ȡ���κ�
			BLGetMaxNo blGetMaxNo = new BLGetMaxNo();
			String batchNo =blGetMaxNo.getMaxNo(comCode);
			// ѭ�����dataCollection�����е����ݣ�������÷�װ��Dto���ݷ������������
			for (Iterator iter = dataCollection.iterator(); iter.hasNext();) {
				uploadData = (UploadData) iter.next();
				if("2".equals(requestType)){//���������ж�
					preCompensateNo = uploadData.getBusinessNo();
					String batchNo1 = uploadData.getBatchNo();
			    	batchNo = batchNo+"/"+batchNo1;
				}else{
					preCompensateNo = blPrpLprepaidZYFacade.findByPrimaryKey(uploadData.getPreCompensateNo()).getPrepayCaseNumber();
				}
			    prepaidDtoList[i] = blFZPrepaidDto.FZPrepaidDto(preCompensateNo);
				i++;
				if (i == prepaidDtoList.length) {
					try {
						clientInfo.setBatchNo(batchNo);
						clientInfo.setListSize(listSize);
						AIPWebServiceImplServiceLocator service = new AIPWebServiceImplServiceLocator();
						AIPWebService facade = service.getAIPWebServiceImplPort();
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String start1 = sdf1.format(new Date());
						prepaidResponseDto = facade.uploadPrepaidInfo(clientInfo, prepaidDtoList);
						String responseCode = prepaidResponseDto.getResponseCode();//��ȡ�ӿ���Ӧ����
						if("2".equals(requestType)){//���������ж�
							CorrectRequest_TempDto cRquestDto = new CorrectRequest_TempDto();
							BLCorrectRequest_TempFacade blCorrectRequest = new BLCorrectRequest_TempFacade();
							if("1".equals(responseCode)){//�����ж��������������ݱ��и�д��־λ
								cRquestDto.setBusinessNo(preCompensateNo);
								cRquestDto.setBusinessType("Prepaid");
								cRquestDto.setFlag("1");
								blCorrectRequest.update(cRquestDto);
							}else{
								cRquestDto.setBusinessNo(preCompensateNo);
								cRquestDto.setBusinessType("Prepaid");
								cRquestDto.setFlag("0");
								blCorrectRequest.update(cRquestDto);
							}
						}
						String end1 = sdf1.format(new Date());
						System.out.println("��ʼʱ��1111111111��" + start1);
						System.out.println("����ʱ��2222222222��" + end1);
						BLPrplPrepaidZYFResponse blPrplPrepaidZYFResponse = new BLPrplPrepaidZYFResponse();
						// ����������Ϣ
						blPrplPrepaidZYFResponse.prepaidResponseSave(prepaidResponseDto, flag, listSize);
						// �ϴ�������Ϣ
						blPrplPrepaidZYFResponse.prepaidUploadInfo(prepaidResponseDto, listSize);
						message = prepaidResponseDto.getErrorDesc();
					} catch (Exception e) {
						e.printStackTrace();
						if (logger.isDebugEnabled()) {
							logger.debug("ũ��ƽ̨��ʱ�����ϴ�ʧ��(Ԥ�ⰸ��Ϣ�ϴ�)��Ԥ�ⰸ�ţ�"
									+ uploadData.getPreCompensateNo());
						}
					}
				}
				message = prepaidResponseDto.getErrorDesc();
			}
		}
		System.out.println("��ʼʱ���ǣ�"+d);
		Date date1 = new Date();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = sdf1.format(date1);
		System.out.println("����ʱ���ǣ�"+dd);
		return message+"</br>"+"��ʼʱ����:"+d+"</br>"+"����ʱ����:"+dd;
	}

	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨��Ԥ�ⰸ����
	 * 
	 * @throws Exception
	 */
	public Collection findPrepaidMainInfoUploadData(String riskCode, String sDate, String eDate,  int Rnumber)
			throws Exception {
		String[] arrRiskCode = riskCode.split(",");
		String strRiskCode = "";
		for (int i = 0; i < arrRiskCode.length; i++) {
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		strRiskCode = strRiskCode.substring(0, strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append(" select prplprepay.precompensateno                            ");
		buffer.append(" from prplprepay,prpcmain                                     ");
		buffer.append(" where prplprepay.policyno = prpcmain.policyno                ");
		buffer.append(" and prplprepay.riskcode in (" + strRiskCode + ")              ");
		buffer.append(" And not exists(                                               ");
		buffer.append("     Select 1 From agriclaimdemand                             ");
		buffer.append("     Where agriclaimdemand.precompensateNo = prplprepay.precompensateNo ");
		buffer.append("     And agriclaimdemand.prepaiduploadflag='1'                 ");
		buffer.append(" )                                                             ");
		buffer.append(" And not exists(                                               ");
		buffer.append(" select 0 from agriclaimdemand                                 ");
		buffer.append(" Where agriclaimdemand.precompensateNo = prplprepay.precompensateNo");
		buffer.append(" And agriclaimdemand.prepaiduploadflag='0'                     ");
		buffer.append(" )                                                             ");
		buffer.append(" And prplprepay.underwriteenddate between Date '"+sDate+"' and to_date('"+eDate+"','yyyy-mm-dd hh24:mi:ss') ");
		buffer.append(" And prpcmain.underwriteenddate >= Date '2013-01-01'           ");
		buffer.append(" And rownum<=" +Rnumber+ "                                      ");
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
				uploadData.setPreCompensateNo(dbManager.getString(resultSet, 1));
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
	 * ��ѯ��Ҫ�ϴ�ƽ̨��Ԥ�ⰸ����������
	 * @throws Exception 
	 */
	public ArrayList<UploadData> finRequestUploadData(int Rum) throws Exception{
		String strWhere ="";
		StringBuffer buffer = new StringBuffer(100);
		buffer.append(" Select batchno,businessno from CORRECTREQUEST_TEMP ");
		buffer.append(" Where businesstype = 'Prepaid' ");
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
