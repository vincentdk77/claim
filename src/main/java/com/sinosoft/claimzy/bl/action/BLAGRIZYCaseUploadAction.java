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
import com.sinosoft.NXCaseUp.bl.facade.BLCasefarmerFacadeBase;
import com.sinosoft.NXCaseUp.bl.facade.BLCasemaininfoFacadeBase;
import com.sinosoft.aip.webservice.server.AIPWebService;
import com.sinosoft.aip.webservice.server.AIPWebServiceImplServiceLocator;
import com.sinosoft.aip.webservice.server.CaseDto;
import com.sinosoft.aip.webservice.server.CaseResponseDto;
import com.sinosoft.aip.webservice.server.ClientInfo;
import com.sinosoft.claimzy.bl.facade.BLAgriClaimUploadLogFacade;
import com.sinosoft.claimzy.bl.facade.BLAgriDemandFacade;
import com.sinosoft.claimzy.dto.domain.AgriClaimDemandDto;
import com.sinosoft.claimzy.dto.domain.AgriClaimUploadLogDto;
import com.sinosoft.claimzy.dto.domain.UploadData;
import com.sinosoft.claimzy.facade.BLPrpLcaseZYFacade;
import com.sinosoft.claimzy.facade.BLPrplCaseZYFResponse;
import com.sinosoft.claimzy.util.BLFZCaseDto;
import com.sinosoft.claimzy.util.BLGetMaxNo;
import com.sinosoft.platform.bl.facade.BLUtiPlatConfigRuleFacade;
import com.sinosoft.platform.dto.domain.UtiPlatConfigRuleDto;
import com.sinosoft.sysframework.common.util.EncryptUtils;
import com.sinosoft.sysframework.reference.AppConfig;
import com.sinosoft.sysframework.reference.DBManager;
import com.thoughtworks.xstream.XStream;




/**
 * ��ʱ�����Զ��ϴ�ũ���ⰸ����ƽ̨��
 * 
 * @author CDB
 * @����ʱ�䣺2015-07-06
 */
public class BLAGRIZYCaseUploadAction {
	private static Log logger = LogFactory.getLog(BLAGRIZYCaseUploadAction.class);
	private static BLAGRIZYCaseUploadAction instance = new BLAGRIZYCaseUploadAction();

	/**
	 * ���췽��
	 */
	public BLAGRIZYCaseUploadAction() {
		
	}

	/**
	 * ��ȡʵ��
	 */
	public static BLAGRIZYCaseUploadAction getInstance() {
		return instance;
	}

	/**
	 * �ⰸ���ݶ�ʱ�����Զ��ϴ�
	 * 
	 * @throws Exception
	 * 
	 */
	public String autoCaseUpload(String startTime, String endTime, String dataType, int uSize,String requestType) throws Exception {
		    String message = "";//������Ϣ
		    Date date = new Date();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String d = sdf.format(date);
			String comCode = AppConfig.get("sysconst.COMCODE");
			String user = AppConfig.get("sysconst.USER");
			String password = EncryptUtils.md5(AppConfig.get("sysconst.PASSWORD"));
			String async = "";
			UtiPlatConfigRuleDto utiPlatConfigRuleDto = new UtiPlatConfigRuleDto();
			BLUtiPlatConfigRuleFacade  blUtiPlatConfigRuleFacade = new BLUtiPlatConfigRuleFacade();
			utiPlatConfigRuleDto = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "Case_AsyncFlag", 1);
			async = utiPlatConfigRuleDto.getRule();//�ӱ���ȡͬ���첽��־
			int xmlSize = 0;//��ȡ�Զ�ת�첽�ķ�ֵ
			UtiPlatConfigRuleDto utiPlatConfigRuleDto1 = new UtiPlatConfigRuleDto();
			utiPlatConfigRuleDto1 = blUtiPlatConfigRuleFacade.findByPrimaryKey("claim", "XmlSize", 1);
			xmlSize = Integer.parseInt(utiPlatConfigRuleDto1.getRule());
			String riskCode = AppConfig.get("sysconst.RISKCODE");
			ClientInfo clientInfo = new ClientInfo();//�ӿ��������
			clientInfo.setInsuranceCompanyCode(comCode);
			clientInfo.setUser(user);
			clientInfo.setPassword(password);
			clientInfo.setRequestType(requestType);
			clientInfo.setAsync(async);
			clientInfo.setDataType(dataType);
			BLPrpLcaseZYFacade blPrpLcaseZYFacade = new BLPrpLcaseZYFacade();
			int flag = 0;
			// �ⰸ�ϴ�
			ArrayList<UploadData> dataCollection = new ArrayList<UploadData>();
			String caseNo = null;
			UploadData uploadData = null;
			BLFZCaseDto blFZCaseDto = new BLFZCaseDto();//���������װ��
			 while(true) {//ѭ������
				   if("2".equals(requestType)){//���������ж�
					   dataCollection = findRequestUploadData(uSize);
				   }else{
					   dataCollection = findCaseMainInfoUploadData(riskCode,startTime,endTime+" 23:59:59",uSize);
				   }
			       if (dataCollection.size() == 0 || dataCollection == null) {
			       break;
			 }
			 CaseResponseDto caseResponseDto = new CaseResponseDto();
			 // ��ȡ�ϴ����κ�
			 BLGetMaxNo blGetMaxNo = new BLGetMaxNo();
		     String batchNo = blGetMaxNo.getMaxNo(comCode);
			 ArrayList caseDtoList = new ArrayList();      
			 // ѭ�����dataCollection�����е����ݣ�������÷�װ��Dto���ݷ������������
			 for (Iterator iter = dataCollection.iterator(); iter.hasNext();) {
				 uploadData = (UploadData) iter.next();
				    if("2".equals(requestType)){//���������ж�
				    	caseNo = uploadData.getBusinessNo();
				    	String batchNo1 = uploadData.getBatchNo();
				    	batchNo = batchNo+"/"+batchNo1;
				    }else{	    	
						caseNo = blPrpLcaseZYFacade.findByPrimaryKey(uploadData.getCompensateNo()).getCaseNumber();	
				    }
					CaseDto caseDto = new CaseDto();
					caseDto = blFZCaseDto.FZCaseDto(caseNo);
					flag = caseDto.getCaseMainInfo().getFarmerCount().intValue();
					caseDtoList.add(caseDto);
					if (caseDtoList.size()==dataCollection.size()){//��ʼ�ϴ��ӿڵ�����
						try {
							clientInfo.setBatchNo(batchNo);
							clientInfo.setListSize(caseDtoList.size());
							XStream stream = new XStream();
							String xml = stream.toXML(caseDtoList);
							String xml1= stream.toXML(clientInfo);
							int length =xml.getBytes().length+xml1.getBytes().length;
							if(length>=xmlSize){
								async = "1";
								clientInfo.setAsync(async);
							}
							CaseDto[] caseFarmerArray = (CaseDto[]) caseDtoList.toArray(new CaseDto[caseDtoList.size()]);
							AIPWebServiceImplServiceLocator service = new AIPWebServiceImplServiceLocator();
							AIPWebService facade = service.getAIPWebServiceImplPort();
							SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							String start1 = sdf1.format(new Date());
							caseResponseDto = facade.uploadCaseInfo(clientInfo, caseFarmerArray);
							String responseCode = caseResponseDto.getResponseCode();//��ȡ�ӿ���Ӧ����
								CorrectRequest_TempDto cRquestDto = new CorrectRequest_TempDto();
								BLCorrectRequest_TempFacade blCorrectRequest = new BLCorrectRequest_TempFacade();
						  if("2".equals(requestType)){
								if("1".equals(responseCode)){//�����ж��������������ݱ��и�д��־λ
									cRquestDto.setBusinessNo(caseNo);
									cRquestDto.setBusinessType("Case");
									cRquestDto.setFlag("1");
									blCorrectRequest.update(cRquestDto);
								}else{
									cRquestDto.setBusinessNo(caseNo);
									cRquestDto.setBusinessType("Case");
									cRquestDto.setFlag("0");
									blCorrectRequest.update(cRquestDto);
								}
						  }
							String end1 = sdf1.format(new Date());
							System.out.println("��ʼʱ��1111111111��" + start1);
							System.out.println("����ʱ��2222222222��" + end1);
							BLPrplCaseZYFResponse blPrplCaseZYFResponse = new BLPrplCaseZYFResponse();
							// ����������Ϣ
							blPrplCaseZYFResponse.caseResponseSave(caseResponseDto, flag, caseDtoList,batchNo);
							// �ϴ�������Ϣ
							blPrplCaseZYFResponse.caseUploadInfo(caseResponseDto, caseDtoList,batchNo);
						} catch (Exception e) {
							e.printStackTrace();
							if (logger.isDebugEnabled()) {
								logger.debug("ũ��ƽ̨��ʱ�����ϴ�ʧ��(�ⰸ��Ϣ�ϴ�)���ⰸ�ţ�"+ uploadData.getCompensateNo());
							}
							//��һ�������ϴ������쳣ʱ�����в���ʹ���´�ѭ�������ñ����ݣ���������ѭ����
							BLAgriDemandFacade blacdf = new BLAgriDemandFacade();
							AgriClaimDemandDto agriclaimDemandDto = new AgriClaimDemandDto();
							agriclaimDemandDto.setBatchNo(batchNo);
							agriclaimDemandDto.setCaseNo(caseNo);
							agriclaimDemandDto.setCaseUploadFlag("2");
							blacdf.insert(agriclaimDemandDto);
							break;
						}
					}
					message = caseResponseDto.getErrorDesc();
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
	 * ��ѯ��Ҫ�ϴ�ƽ̨���ⰸ����
	 * 
	 * @return List<UploadData>
	 * @throws Exception
	 */
	public ArrayList<UploadData> findCaseMainInfoUploadData(String riskCode, String sDate, String eDate,  int Rnumber)
			throws Exception {
		String[] arrRiskCode = riskCode.split(",");
		String strRiskCode = "";
		for (int i = 0; i < arrRiskCode.length; i++) {
			strRiskCode += "'" + arrRiskCode[i] + "',";
		}
		if(strRiskCode==null||strRiskCode.trim().length()==0){
			throw new Exception("�������ò���Ϊ�գ�");
		}
		strRiskCode = strRiskCode.substring(0, strRiskCode.length() - 1);
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(200);
		buffer.append(" Select compensateno ");//
        buffer.append(" from prplcompensate,prplclaim,prpcmain ");
		buffer.append(" Where prplclaim.claimno = prplcompensate.claimno ");
		buffer.append("  And not exists(                                       ");
		buffer.append("  Select 1 From agriclaimdemand                         ");
		buffer.append("  Where agriclaimdemand.caseno = prplcompensate.compensateno    ");
		buffer.append("  And agriclaimdemand.caseuploadflag='1'                ");
		buffer.append("  )                                                     ");
		buffer.append("  And not exists(                                       ");
		buffer.append("  Select 0 from agriclaimdemand                         ");
		buffer.append("  Where agriclaimdemand.caseno = prplcompensate.compensateno ");
		buffer.append("  And agriclaimdemand.caseuploadflag='0'               ");
		buffer.append("  )                                                          ");
		buffer.append("  And not exists(                                       ");
		buffer.append("  Select 2 from agriclaimdemand                         ");
		buffer.append("  Where agriclaimdemand.caseno = prplcompensate.compensateno ");
		buffer.append("  And agriclaimdemand.caseuploadflag='2'               ");
		buffer.append("  )                                                          ");
		buffer.append(" And  prplcompensate.underwriteenddate between Date '"+sDate+"' and to_date('"+eDate+"','yyyy-mm-dd hh24:mi:ss') ");
		buffer.append("  And prplcompensate.riskcode In (" + strRiskCode + ")       ");
		buffer.append(" And prplclaim.endcasedate is  not null ");
		buffer.append(" And prplcompensate.underwriteflag in('1','3')         ");
		buffer.append(" And prpcmain.policyno=prplcompensate.policyno         ");
		buffer.append(" And prpcmain.underwriteenddate >=Date '2013-01-01'    ");
		buffer.append("  And rownum<=" + Rnumber + "                          ");
		strWhere = buffer.toString();
		if (logger.isDebugEnabled()) {
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
				uploadData.setCompensateNo(dbManager.getString(resultSet, 1));
				resultList.add(uploadData);
			}
			resultSet.close();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (resultSet != null) {
				
			}
			dbManager.close();
		}
		return resultList;
	}

	/**
	 * ��ѯ��Ҫ�ϴ�ƽ̨���ⰸ���������������
	 * @throws Exception 
	 */
	public ArrayList<UploadData> findRequestUploadData(int Rum) throws Exception{
		String strWhere = "";
		StringBuffer buffer = new StringBuffer(200);
		buffer.append(" Select batchno,businessno from CORRECTREQUEST_TEMP ");
		buffer.append(" Where businesstype='Case' ");
		buffer.append(" And flag is null          ");
		buffer.append(" And rownum<=" + Rum + "   ");
		strWhere = buffer.toString();
		if (logger.isDebugEnabled()) {
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
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			if (resultSet != null) {
			}
			dbManager.close();
		}
		return resultList;
		
	}
	
}
