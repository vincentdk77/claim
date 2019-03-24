package com.sinosoft.claim.ui.control.facade;

import java.util.Date;
import java.util.List;

import org.jdom.Element;

import com.sinosoft.claim.bl.facade.BLCallCenterSendStatusFacade;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.util.GHBSendmessageLogger;
import com.sinosoft.claim.util.OperXML;
import com.sinosoft.claim.webservice.client.EliteGeneralWS.EliteDBWSImpl;
import com.sinosoft.claim.webservice.client.EliteGeneralWS.EliteDBWSImplServiceLocator;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;

public class UIClaimSynStatusFacade {
	GHBSendmessageLogger ghbSendmessageLogger = new GHBSendmessageLogger();
	/**
	 * ������������ message :000��ʾ�ɹ���������ʾ�������Ϣ
	 * @throws Exception 
	 */
	private String doTransData(String iData) throws Exception {
		OperXML operXML = new OperXML();
		String message = "";
		try {
			operXML.parserFromXMLString(iData);
			System.out.println("���յ�XML:" + iData);
			System.out.println("��ʼ�����������ݣ�");
			List<?> responseCodeList = operXML.getChildrenElement(iData, "datas");
			System.out.println("ҵ������codesize____:" + responseCodeList.size());
			if (responseCodeList.size() < 1) {
				throw new Exception("�������Ͳ�ƥ�䣡");
			}
			Element responseCode = (Element) responseCodeList.get(0);
			Element rowList = responseCode.getChild("row");
			String codevalue = rowList.getAttributeValue("col1").trim();
			message = codevalue;
		} catch (Exception e) {
			e.printStackTrace();
			message = "����ʧ��";
			throw e;
		}
		return message;
	}

	public String sendXMLData(String registNo, String status){
		String paramsXml="<root>";
		paramsXml += "<sp name='sp_registstatus' timeout='20'>";
		paramsXml += "<spparam name='var_registno'>";
		paramsXml += registNo;
		paramsXml += "</spparam>";
		paramsXml += "<spparam name='var_status'>";
		paramsXml += status;
		paramsXml += "</spparam>";
		paramsXml += "</sp>";
		paramsXml += "</root>";
		
		return paramsXml;
	}
	/**
	 * ��������
	 * @param registNo
	 * @param status
	 * @throws Exception
	 */
	public void synRegistStatus(String registNo, String status) throws Exception {
//		long serial = System.currentTimeMillis();
//		BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
//		CallCenterSendStatusDto callCenterSendStatusDto = new CallCenterSendStatusDto();
//		callCenterSendStatusDto.setRegistNo(registNo);
//		callCenterSendStatusDto.setCaseStatus(status);
//		callCenterSendStatusDto.setSendSystem("claim");
//		callCenterSendStatusDto.setSendType("1");
//		callCenterSendStatusDto.setSendTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND));
//		try{
//			EliteDBWSImplServiceLocator service = new EliteDBWSImplServiceLocator();
//			String SERVER_URL = AppConfig.get("sysconst.GHBSYNSTATUS_URL");
//			service.setEliteDBWSImplEndpointAddress(SERVER_URL);
//			EliteDBWSImpl facade = service.getEliteDBWSImpl();
//			String paramsXml = this.sendXMLData(registNo, status);
//			ghbSendmessageLogger.log(serial,"����״̬���������ݣ�"+paramsXml);
//			String resultXML = facade.callProcedure(paramsXml);
//			ghbSendmessageLogger.log(serial,"����״̬���������ݣ�"+resultXML);
//			String message = this.doTransData(resultXML);//����״̬
//			System.out.println("message="+message);
//			callCenterSendStatusDto.setSendStatus(message, "0");
//			blCallCenterSendStatusFacade.insert(callCenterSendStatusDto);
//			
//		}catch(Exception e){
//			callCenterSendStatusDto.setSendStatus("", "0");
//			try {
//				blCallCenterSendStatusFacade.insert(callCenterSendStatusDto);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//				ghbSendmessageLogger.log(serial,e);
//			}
//			e.printStackTrace();
//			ghbSendmessageLogger.log(serial, e);
//		}
	}
	/**
	 * ����
	 * @param registNo ������
	 * @param status ״̬
	 * @param serialNo ͬ�����ݼ�¼���
	 * @param type	1����ʱ���񲹷���2���ֹ�����
	 * @throws Exception
	 */
	public void reissueSynRegistStatus(String registNo, String status,double serialNo,String type) throws Exception {
		long serial = System.currentTimeMillis();
		BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
		CallCenterSendStatusDto callCenterSendStatusDto = blCallCenterSendStatusFacade.findByPrimaryKey(serialNo);
		callCenterSendStatusDto.setAgainSendTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND));
		try{
			EliteDBWSImplServiceLocator service = new EliteDBWSImplServiceLocator();
			String SERVER_URL = AppConfig.get("sysconst.GHBSYNSTATUS_URL");
			service.setEliteDBWSImplEndpointAddress(SERVER_URL);
			EliteDBWSImpl facade = service.getEliteDBWSImpl();
			String paramsXml = this.sendXMLData(registNo, status);
			ghbSendmessageLogger.log(serial,"����״̬���������ݣ�"+paramsXml);
			String resultXML = facade.callProcedure(paramsXml);
			ghbSendmessageLogger.log(serial,"����״̬���������ݣ�"+resultXML);
			String message = this.doTransData(resultXML);
			System.out.println("message="+message);
			callCenterSendStatusDto.setSendStatus(message, type);
			blCallCenterSendStatusFacade.update(callCenterSendStatusDto);
			
		}catch(Exception e){
			callCenterSendStatusDto.setSendStatus("", type);
			try {
				blCallCenterSendStatusFacade.update(callCenterSendStatusDto);
			} catch (Exception e1) {
				e1.printStackTrace();
				ghbSendmessageLogger.log(serial,e);
			}
			e.printStackTrace();
			ghbSendmessageLogger.log(serial, e);
		}
	}

}
