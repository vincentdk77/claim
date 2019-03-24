package com.sinosoft.claim.webservice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sinosoft.claim.dto.domain.PrpLclaimDto;
import com.sinosoft.claim.dto.domain.PrpLmessageDto;
import com.sinosoft.claim.ui.control.action.UICodeAction;
import com.sinosoft.claim.ui.control.action.UIMessageAction;
import com.sinosoft.claim.ui.control.action.UIRelateAction;
import com.sinosoft.claim.util.CallCenterInterfaceLogger;
import com.sinosoft.sysframework.common.datatype.DateTime;

/**
 * ���⹵ͨ�ӿ�(��������)
 * @author Administrator
 *
 */
public class UICommunicationService {
	CallCenterInterfaceLogger logger = new CallCenterInterfaceLogger();
	/**
	 * ����ϵͳ���⹵ͨ�б��ѯ
	 * @param registNo
	 * @return
	 */
	public CommunicationDetailDtoInfo[] getCommunicationDetail (String registNo){
		long serial = System.currentTimeMillis();
		logger.log("����ϵͳ���⹵ͨ�б��ѯ", 1,serial, "[registNo:"+registNo+"]");
		CommunicationDetailDtoInfo[] communicationDetailDtoInfoList = null;
		try {
			if(registNo == null||"".equals(registNo.trim())){
				throw new Exception("������������������!");
			}
		    String  conditions = " RegistNo  = '" + registNo + "' Order By InputDate desc";
		    Collection messageList = new ArrayList();
		    UIMessageAction uiMessageAction = new UIMessageAction();
		    UICodeAction uiCodeAction= new UICodeAction();
		    messageList = (Collection) uiMessageAction.findByConditions1(conditions);
		    communicationDetailDtoInfoList = new CommunicationDetailDtoInfo[messageList.size()];
		    Iterator iterator = messageList.iterator();
		    for(int i = 0;i<messageList.size();i++){
		    	PrpLmessageDto prpLmessageDto = (PrpLmessageDto) iterator.next();
		    	CommunicationDetailDtoInfo communicationDetailDtoInfo = new CommunicationDetailDtoInfo();
		    	communicationDetailDtoInfo.setRegistNo(prpLmessageDto.getRegistNo());
		    	communicationDetailDtoInfo.setNodeType(prpLmessageDto.getNodeType());
		    	String nodetypeName = "";
		    	if(prpLmessageDto.getNodeType()!=null){
		    		 nodetypeName = uiCodeAction.translateCodeCode("ClaimNodeType",prpLmessageDto.getNodeType(), true);
		    	}
		    	communicationDetailDtoInfo.setNodeName(nodetypeName);
		    	communicationDetailDtoInfo.setInputDate(prpLmessageDto.getInputDate().toString());
		    	communicationDetailDtoInfo.setUserCode(prpLmessageDto.getOperatorCode());
		    	communicationDetailDtoInfo.setUserName(prpLmessageDto.getOperatorName());
		    	communicationDetailDtoInfo.setContext(prpLmessageDto.getContext());
		    	communicationDetailDtoInfoList[i] = communicationDetailDtoInfo;
		    }
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("����ϵͳ���⹵ͨ�б��ѯ",serial,e);
		}
		logger.log("����ϵͳ���⹵ͨ�б��ѯ", 0,serial, communicationDetailDtoInfoList);
		return communicationDetailDtoInfoList;
		
	}
	/**
	 * ����ϵͳ���⹵ͨ
	 * ��ͨ���棬����ѯ��Ӧ����������
	 * @param CommunicationReqInfo
	 * @return
	 */
	public PrpLmessageDtoInfo[] saveCommunication (CommunicationReqInfo communicationReqInfo){
		long serial = System.currentTimeMillis();
		logger.log("����ϵͳ���⹵ͨ",1,serial,communicationReqInfo);
		PrpLmessageDtoInfo[] prpLmessageDtoInfoLsit = null;
		try {
			//��
			checkCommunicationReqInfo(communicationReqInfo);
			 int messgeID  = 0 ;
		      String  registNo = communicationReqInfo.getRegistNo();
		      UIMessageAction uiMessageAction = new UIMessageAction();
		      messgeID = uiMessageAction.getNo(registNo);
		      
		      PrpLmessageDto prpLmessageDto = new PrpLmessageDto();
		      prpLmessageDto.setContext(communicationReqInfo.getContext());
		      prpLmessageDto.setRegistNo(registNo);
		      prpLmessageDto.setClaimNo(communicationReqInfo.getClaimNo());
		      prpLmessageDto.setSerialNo(messgeID);
		      prpLmessageDto.setLineNo(1);
		      prpLmessageDto.setInputDate(new DateTime(communicationReqInfo.getInputDate(),DateTime.YEAR_TO_SECOND));
		      prpLmessageDto.setRiskCode(communicationReqInfo.getRiskCode());
		      prpLmessageDto.setPolicyNo(communicationReqInfo.getPolicyNo());
		      prpLmessageDto.setNodeType(communicationReqInfo.getNodeType());
		      prpLmessageDto.setOperatorName(communicationReqInfo.getOperatorName());
			
	          uiMessageAction.save(prpLmessageDto);
	          
	          //ȡ
	          String  conditions = " RegistNo  = '" + registNo + "' Order By InputDate desc";
			    Collection messageList = new ArrayList();
			    UICodeAction uiCodeAction= new UICodeAction();
			    messageList = (Collection) uiMessageAction.findByConditions1(conditions);
			    prpLmessageDtoInfoLsit = new PrpLmessageDtoInfo[messageList.size()];
			    Iterator iterator = messageList.iterator();
			    for(int i = 0;i<messageList.size();i++){
			    	PrpLmessageDto prpLmessageDtoTemp = (PrpLmessageDto) iterator.next();
			    	PrpLmessageDtoInfo prpLmessageDtoInfo = new PrpLmessageDtoInfo();
			    	prpLmessageDtoInfo.setRegistNo(prpLmessageDtoTemp.getRegistNo());
			    	prpLmessageDtoInfo.setNodeType(prpLmessageDtoTemp.getNodeType());
			    	String nodetypeName = "";
			    	if(prpLmessageDtoTemp.getNodeType()!=null){
			    		 nodetypeName = uiCodeAction.translateCodeCode("ClaimNodeType",prpLmessageDtoTemp.getNodeType(), true);
			    	}
			    	prpLmessageDtoInfo.setNodeName(nodetypeName);
			    	prpLmessageDtoInfo.setInputDate(prpLmessageDtoTemp.getInputDate().toString());
			    	prpLmessageDtoInfo.setOperatorCode(prpLmessageDtoTemp.getOperatorCode());
			    	prpLmessageDtoInfo.setOperatorName(prpLmessageDtoTemp.getOperatorName());
			    	prpLmessageDtoInfo.setContext(prpLmessageDtoTemp.getContext());
			    	prpLmessageDtoInfoLsit[i] = prpLmessageDtoInfo;
			    }
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.log("����ϵͳ���⹵ͨ",serial,e);
		}
		logger.log("����ϵͳ���⹵ͨ", 0,serial, prpLmessageDtoInfoLsit);
		return prpLmessageDtoInfoLsit;
		
	}
	/**
	 * У�� ����ϵͳ���⹵ͨ ��� ����  
	 * @param communicationReqInfo
	 * @throws Exception 
	 */
	private void checkCommunicationReqInfo(
			CommunicationReqInfo crinfo) throws Exception {
		if(crinfo.getRegistNo()==null||"".equals(crinfo.getRegistNo().trim())){
			throw new Exception("�������Ǳش����������飡");
		}
		if(crinfo.getPolicyNo()==null||"".equals(crinfo.getPolicyNo().trim())){
			throw new Exception("�������Ǳش����������飡");
		}
		if(crinfo.getRiskCode()==null||"".equals(crinfo.getRiskCode().trim())){
			throw new Exception("���ִ����Ǳش����������飡");
		}
		if(crinfo.getOperatorCode()==null||"".equals(crinfo.getOperatorCode().trim())){
			throw new Exception("�����˴����Ǳش����������飡");
		}
		if(crinfo.getOperatorName()==null||"".equals(crinfo.getOperatorName().trim())){
			throw new Exception("�����������Ǳش����������飡");
		}
		if(crinfo.getNodeType()==null||"".equals(crinfo.getNodeType().trim())){
			throw new Exception("�ڵ������Ǳش����������飡");
		}
		if(crinfo.getInputDate()==null||"".equals(crinfo.getInputDate().trim())){
			throw new Exception("�䵥ʱ���Ǳش����������飡");
		}
		if(crinfo.getContext()==null||"".equals(crinfo.getContext().trim())){
			throw new Exception("��ͨ�����Ǳش����������飡");
		}
	}
}
