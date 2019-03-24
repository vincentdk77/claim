package com.sinosoft.claim.ui.control.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom.Element;

import com.sinosoft.claim.bl.facade.BLCallCenterSendStatusFacade;
import com.sinosoft.claim.dto.domain.CallCenterSendStatusDto;
import com.sinosoft.claim.util.GHBSendmessageLogger;
import com.sinosoft.claim.util.OperXML;
import com.sinosoft.claim.webservice.client.EliteGeneralWS.EliteDBWSImpl;
import com.sinosoft.claim.webservice.client.EliteGeneralWS.EliteDBWSImplServiceLocator;
import com.sinosoft.communication.bl.facade.BLPrplCommunicationFacade;
import com.sinosoft.platform.bl.facade.BLUtiUserGradeFacade;
import com.sinosoft.platform.dto.domain.UtiUserGradeDto;
import com.sinosoft.sysframework.common.datatype.DateTime;
import com.sinosoft.sysframework.reference.AppConfig;
/**
 * 调用：理赔沟通反馈接口
 * 机构在进行理赔沟通反馈信息给国元呼叫中心时，
 * 需要将理赔沟通反馈的信息回传。
 * 调用此接口将理赔沟通信息回传：
 * 机构代码，机构名称，业务员工号，理赔沟通待处理量。
 * @author Administrator
 *
 */
public class UIClaimCommunicateFeedbackFacade {
	GHBSendmessageLogger ghbSendmessageLogger = new GHBSendmessageLogger();
	/**
	 * 调用：理赔沟通反馈接口
	 * 发送数据整理
	 * @param registNo
	 * @param userCode
	 * @throws Exception 
	 * @throws Exception 
	 */
	public void ClaimCommunicateFeeback(String registNo,String communicationNo,String userCode){
		long serial = System.currentTimeMillis();
		BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
		CallCenterSendStatusDto callCenterSendStatusDto = new CallCenterSendStatusDto();
		callCenterSendStatusDto.setRegistNo(registNo);
		callCenterSendStatusDto.setSendSystem("newclaim");
		callCenterSendStatusDto.setSendType("2");
		callCenterSendStatusDto.setSendTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND));
		callCenterSendStatusDto.setCommunicationNo(communicationNo);
		callCenterSendStatusDto.setUserCode(userCode);
		try {
			BLPrplCommunicationFacade blPrplCommunicationFacade = new BLPrplCommunicationFacade();
			if(registNo == null || registNo.trim().length()==0){
				registNo = blPrplCommunicationFacade.findByComminicationNo(communicationNo).getRegistNo();
			}
			ghbSendmessageLogger.log(serial,"registNo: "+registNo+" communicationNo: "+communicationNo +" userCode: "+userCode);
			String sql = "gradecode='156' and usercode = '"+userCode+"' and comcode = '0000000000'";
			BLUtiUserGradeFacade blUtiUserGradeFacade = new BLUtiUserGradeFacade();
			ArrayList<UtiUserGradeDto> utiusergradeList = (ArrayList<UtiUserGradeDto>)blUtiUserGradeFacade.findByConditions(sql);
			if(utiusergradeList !=null && utiusergradeList.size()>0){
				UIClaimCommunicateFeedbackFacade uiClaimCommunicateFeedback = new UIClaimCommunicateFeedbackFacade();
				int communicationCount = 0;
				if(registNo!=null&&!"".equals(registNo)){
					String conditions = " registNo = '"+registNo+"' 				"+
					"	   and (c.validata = '1' )									"+
					"	   and (communicationNo in									"+
					"	       (select communicationNo								"+
					"	           from prplcommunicatperson p						"+
					"	          where  p.communicationno = c.communicationno and  usercode = '"+userCode+"'      "+
					"                   and (p.communicationflag is null or p.communicationflag in ('0','2') )) or c.usercode='"+userCode+"')	";
					
					System.out.println("<UICommunicationEditAction.java 676行>"+conditions);
					communicationCount = blPrplCommunicationFacade.getCount(conditions);
					String message = uiClaimCommunicateFeedback.feedback(serial,communicationCount, userCode,  "国元农业保险股份有限公司","0000000000");
					
					callCenterSendStatusDto.setSendStatus(message, "0");
					blCallCenterSendStatusFacade.insert(callCenterSendStatusDto);
				}
			}
		} catch (Exception e) {
			try {
				callCenterSendStatusDto.setSendStatus("", "0");
				blCallCenterSendStatusFacade.insert(callCenterSendStatusDto);
			} catch (Exception e1) {
				e1.printStackTrace();
				ghbSendmessageLogger.log(serial,e);
			}
			e.printStackTrace();
			ghbSendmessageLogger.log(serial,e);
		}
	}
	/**
	 * 调用方法
	 * @param count
	 * @param deptno
	 * @param deptname
	 * @param deptcode
	 * @throws Exception 
	 */
	public String feedback(long serial,int count,String deptno,String deptname,String deptcode) throws Exception{
		try {
			EliteDBWSImplServiceLocator service = new EliteDBWSImplServiceLocator();
			String SERVER_URL = AppConfig.get("sysconst.GHBSYNSTATUS_URL");
			service.setEliteDBWSImplEndpointAddress(SERVER_URL);
			EliteDBWSImpl facade = service.getEliteDBWSImpl();
			String paramsXml = this.sendXMLData(count,deptno,deptname,deptcode);
			ghbSendmessageLogger.log(serial,"理赔沟通反馈：发送数据："+paramsXml);
			String resultXML = facade.callProcedure(paramsXml);
			ghbSendmessageLogger.log(serial,"理赔沟通反馈：返回数据："+resultXML);
			String message = this.doTransData(resultXML);
			System.out.println("message="+message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			ghbSendmessageLogger.log(serial,e);
			throw e;
		}
	}
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

	private String sendXMLData(int count, String deptno, String deptname,
			String deptcode) {
		String paramsXml = "<root>";
			paramsXml += "<sp name=\"SP_BBS_MESSAGEGET\" timeout=\"20\">";
			paramsXml += "<spparam name=\"in_count\">";
			paramsXml += count;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"in_deptno\">";
			paramsXml += deptno;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"in_deptname\">";
			paramsXml += deptname;
			paramsXml += "</spparam>";
			paramsXml += "<spparam name=\"in_deptcode\">";
			paramsXml += deptcode;
			paramsXml += "</spparam>";
			paramsXml += "</sp>";
			paramsXml += "</root>";
		
		return paramsXml;
	}
	
	/**
	 * 补传
	 * @param registNo
	 * @param communicationNo
	 * @param userCode
	 * @throws Exception 
	 */
	public void reissueClaimCommunicateFeeback(String registNo,String communicationNo,String userCode,double serialNo,String type) throws Exception{
		long serial = System.currentTimeMillis();
		BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
		CallCenterSendStatusDto callCenterSendStatusDto = blCallCenterSendStatusFacade.findByPrimaryKey(serialNo);
		callCenterSendStatusDto.setAgainSendTime(new DateTime(new Date(),DateTime.YEAR_TO_SECOND));
		try {
			BLPrplCommunicationFacade blPrplCommunicationFacade = new BLPrplCommunicationFacade();
			if(registNo == null || registNo.trim().length()==0){
				registNo = blPrplCommunicationFacade.findByComminicationNo(communicationNo).getRegistNo();
			}
			ghbSendmessageLogger.log(serial,"registNo: "+registNo+" communicationNo: "+communicationNo +" userCode: "+userCode);
			String sql = "gradecode='156' and usercode = '"+userCode+"' and comcode = '0000000000'";
			BLUtiUserGradeFacade blUtiUserGradeFacade = new BLUtiUserGradeFacade();
			ArrayList<UtiUserGradeDto> utiusergradeList = (ArrayList<UtiUserGradeDto>)blUtiUserGradeFacade.findByConditions(sql);
			if(utiusergradeList !=null && utiusergradeList.size()>0){
				UIClaimCommunicateFeedbackFacade uiClaimCommunicateFeedback = new UIClaimCommunicateFeedbackFacade();
				int communicationCount = 0;
				if(registNo!=null&&!"".equals(registNo)){
					String conditions = " registNo = '"+registNo+"' 				"+
					"	   and (c.validata = '1' )									"+
					"	   and (communicationNo in									"+
					"	       (select communicationNo								"+
					"	           from prplcommunicatperson p						"+
					"	          where  p.communicationno = c.communicationno and  usercode = '"+userCode+"'      "+
					"                   and (p.communicationflag is null or p.communicationflag in ('0','2') )) or c.usercode='"+userCode+"')	";
					
					System.out.println("<UICommunicationEditAction.java 676行>"+conditions);
					communicationCount = blPrplCommunicationFacade.getCount(conditions);
					String message = uiClaimCommunicateFeedback.feedback(serial,communicationCount, userCode,  "国元农业保险股份有限公司","0000000000");
					callCenterSendStatusDto.setSendStatus(message, type);
					blCallCenterSendStatusFacade.update(callCenterSendStatusDto);
				}
			}
		} catch (Exception e) {
			callCenterSendStatusDto.setSendStatus("", type);
			try {
				blCallCenterSendStatusFacade.update(callCenterSendStatusDto);
			} catch (Exception e1) {
				e1.printStackTrace();
				ghbSendmessageLogger.log(serial,e);
			}
			e.printStackTrace();
			ghbSendmessageLogger.log(serial,e);
		}
	}
}
