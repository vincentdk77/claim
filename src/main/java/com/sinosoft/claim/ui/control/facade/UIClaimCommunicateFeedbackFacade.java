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
 * ���ã����⹵ͨ�����ӿ�
 * �����ڽ������⹵ͨ������Ϣ����Ԫ��������ʱ��
 * ��Ҫ�����⹵ͨ��������Ϣ�ش���
 * ���ô˽ӿڽ����⹵ͨ��Ϣ�ش���
 * �������룬�������ƣ�ҵ��Ա���ţ����⹵ͨ����������
 * @author Administrator
 *
 */
public class UIClaimCommunicateFeedbackFacade {
	GHBSendmessageLogger ghbSendmessageLogger = new GHBSendmessageLogger();
	/**
	 * ���ã����⹵ͨ�����ӿ�
	 * ������������
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
					
					System.out.println("<UICommunicationEditAction.java 676��>"+conditions);
					communicationCount = blPrplCommunicationFacade.getCount(conditions);
					String message = uiClaimCommunicateFeedback.feedback(serial,communicationCount, userCode,  "��Ԫũҵ���չɷ����޹�˾","0000000000");
					
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
	 * ���÷���
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
			ghbSendmessageLogger.log(serial,"���⹵ͨ�������������ݣ�"+paramsXml);
			String resultXML = facade.callProcedure(paramsXml);
			ghbSendmessageLogger.log(serial,"���⹵ͨ�������������ݣ�"+resultXML);
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
	 * ����
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
					
					System.out.println("<UICommunicationEditAction.java 676��>"+conditions);
					communicationCount = blPrplCommunicationFacade.getCount(conditions);
					String message = uiClaimCommunicateFeedback.feedback(serial,communicationCount, userCode,  "��Ԫũҵ���չɷ����޹�˾","0000000000");
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
