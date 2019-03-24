<%@page import="com.sinosoft.claim.ui.control.facade.UIPaymentReturnDataInFacade"%>
<%@page import="com.sinosoft.claim.ui.control.facade.UIClaimCommunicateFeedbackFacade"%>
<%@page import="com.sinosoft.claim.ui.control.facade.UIClaimSynStatusFacade"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sinosoft.claim.bl.facade.BLCallCenterSendStatusFacade"%>
<%@page import="com.sinosoft.claim.dto.domain.CallCenterSendStatusDto"%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%
	System.out.println("��Ժ��Ĵ������ӱ�ʧ�ܵ����ݣ���ʱ���񲹴���ʼ");
	System.out.println("--1.��ȡ����");
	//1.��������״̬���ؽӿ�����
	String conditions1 = " sendtype = '1' and sendsystem in ('claim','newclaim') and sendstatus in ('00','01','10','11','20','21')  order by serial";
	String conditions2 = " sendtype = '2' and sendsystem in ('claim','newclaim') and sendstatus in ('00','01','10','11','20','21')  order by serial";
	String conditions3 = " sendtype = '3' and sendsystem in ('claim','newclaim') and sendstatus in ('00','01','10','11','20','21')  order by serial";
	BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
	//��ȡʧ������
	ArrayList<CallCenterSendStatusDto> callCenterSendStatusDtoList1 = (ArrayList<CallCenterSendStatusDto>)blCallCenterSendStatusFacade.findByConditions(conditions1);
	ArrayList<CallCenterSendStatusDto> callCenterSendStatusDtoList2 = (ArrayList<CallCenterSendStatusDto>)blCallCenterSendStatusFacade.findByConditions(conditions2);
	ArrayList<CallCenterSendStatusDto> callCenterSendStatusDtoList3 = (ArrayList<CallCenterSendStatusDto>)blCallCenterSendStatusFacade.findByConditions(conditions3);
	
	System.out.println("--1.��������״̬���ؽӿ�����--��ʼ");
	UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
	for(int i = 0;i<callCenterSendStatusDtoList1.size();i++){
		CallCenterSendStatusDto csDto = callCenterSendStatusDtoList1.get(i);
		uiClaimSynStatusFacade.reissueSynRegistStatus(csDto.getRegistNo(),csDto.getCaseStatus(),csDto.getSerial(),"1");
	}
	System.out.println("--1.��������״̬���ؽӿ�����--����");
	System.out.println("--2.���⹵ͨ�����ӿ�����--��ʼ");
	UIClaimCommunicateFeedbackFacade uiClaimCommunicateFeedbackFacade = new UIClaimCommunicateFeedbackFacade();
	for(int i = 0;i<callCenterSendStatusDtoList2.size();i++){
		CallCenterSendStatusDto csDto = callCenterSendStatusDtoList2.get(i);
		uiClaimCommunicateFeedbackFacade.reissueClaimCommunicateFeeback(csDto.getRegistNo(),csDto.getCommunicationNo(),csDto.getUserCode(),csDto.getSerial(),"1");
	}
	System.out.println("--2.���⹵ͨ�����ӿ�����--����");
	System.out.println("--3.�ط����ݴ���ӿڣ�������֧����Ϣʱ����--��ʼ");
	UIPaymentReturnDataInFacade uiPaymentReturnDataInFacade = new UIPaymentReturnDataInFacade();
	for(int i = 0;i<callCenterSendStatusDtoList3.size();i++){
		CallCenterSendStatusDto csDto = callCenterSendStatusDtoList3.get(i);
		uiPaymentReturnDataInFacade.reissuePaymentReturnDate(csDto.getRegistNo(),csDto.getSerial(),"1");
	}
	System.out.println("--3.�ط����ݴ���ӿڣ�������֧����Ϣʱ����--����");
	System.out.println("��Ժ��Ĵ������ӱ�ʧ�ܵ����ݣ���ʱ���񲹴�����");
%>