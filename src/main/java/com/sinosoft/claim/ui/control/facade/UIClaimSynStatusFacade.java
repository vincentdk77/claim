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
	 * 解析返回数据 message :000表示成功，其他显示表错误信息
	 * @throws Exception 
	 */
	private String doTransData(String iData) throws Exception {
		OperXML operXML = new OperXML();
		String message = "";
		try {
			operXML.parserFromXMLString(iData);
			System.out.println("接收的XML:" + iData);
			System.out.println("开始解析基本数据！");
			List<?> responseCodeList = operXML.getChildrenElement(iData, "datas");
			System.out.println("业务数据codesize____:" + responseCodeList.size());
			if (responseCodeList.size() < 1) {
				throw new Exception("数据类型不匹配！");
			}
			Element responseCode = (Element) responseCodeList.get(0);
			Element rowList = responseCode.getChild("row");
			String codevalue = rowList.getAttributeValue("col1").trim();
			message = codevalue;
		} catch (Exception e) {
			e.printStackTrace();
			message = "解析失败";
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
	 * 正常发送
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
//			ghbSendmessageLogger.log(serial,"案件状态：发送数据："+paramsXml);
//			String resultXML = facade.callProcedure(paramsXml);
//			ghbSendmessageLogger.log(serial,"案件状态：接收数据："+resultXML);
//			String message = this.doTransData(resultXML);//返回状态
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
	 * 补发
	 * @param registNo 案件号
	 * @param status 状态
	 * @param serialNo 同步数据记录编号
	 * @param type	1：定时任务补发，2：手工补发
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
			ghbSendmessageLogger.log(serial,"案件状态：发送数据："+paramsXml);
			String resultXML = facade.callProcedure(paramsXml);
			ghbSendmessageLogger.log(serial,"案件状态：接收数据："+resultXML);
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
