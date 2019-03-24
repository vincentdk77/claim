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
	System.out.println("针对核心传到过河兵失败的数据，定时任务补传开始");
	System.out.println("--1.获取数据");
	//1.补传案件状态返回接口数据
	String conditions1 = " sendtype = '1' and sendsystem in ('claim','newclaim') and sendstatus in ('00','01','10','11','20','21')  order by serial";
	String conditions2 = " sendtype = '2' and sendsystem in ('claim','newclaim') and sendstatus in ('00','01','10','11','20','21')  order by serial";
	String conditions3 = " sendtype = '3' and sendsystem in ('claim','newclaim') and sendstatus in ('00','01','10','11','20','21')  order by serial";
	BLCallCenterSendStatusFacade blCallCenterSendStatusFacade = new BLCallCenterSendStatusFacade();
	//获取失败数据
	ArrayList<CallCenterSendStatusDto> callCenterSendStatusDtoList1 = (ArrayList<CallCenterSendStatusDto>)blCallCenterSendStatusFacade.findByConditions(conditions1);
	ArrayList<CallCenterSendStatusDto> callCenterSendStatusDtoList2 = (ArrayList<CallCenterSendStatusDto>)blCallCenterSendStatusFacade.findByConditions(conditions2);
	ArrayList<CallCenterSendStatusDto> callCenterSendStatusDtoList3 = (ArrayList<CallCenterSendStatusDto>)blCallCenterSendStatusFacade.findByConditions(conditions3);
	
	System.out.println("--1.补传案件状态返回接口数据--开始");
	UIClaimSynStatusFacade uiClaimSynStatusFacade = new UIClaimSynStatusFacade();
	for(int i = 0;i<callCenterSendStatusDtoList1.size();i++){
		CallCenterSendStatusDto csDto = callCenterSendStatusDtoList1.get(i);
		uiClaimSynStatusFacade.reissueSynRegistStatus(csDto.getRegistNo(),csDto.getCaseStatus(),csDto.getSerial(),"1");
	}
	System.out.println("--1.补传案件状态返回接口数据--结束");
	System.out.println("--2.理赔沟通反馈接口数据--开始");
	UIClaimCommunicateFeedbackFacade uiClaimCommunicateFeedbackFacade = new UIClaimCommunicateFeedbackFacade();
	for(int i = 0;i<callCenterSendStatusDtoList2.size();i++){
		CallCenterSendStatusDto csDto = callCenterSendStatusDtoList2.get(i);
		uiClaimCommunicateFeedbackFacade.reissueClaimCommunicateFeeback(csDto.getRegistNo(),csDto.getCommunicationNo(),csDto.getUserCode(),csDto.getSerial(),"1");
	}
	System.out.println("--2.理赔沟通反馈接口数据--结束");
	System.out.println("--3.回访数据传入接口：案件有支付信息时调用--开始");
	UIPaymentReturnDataInFacade uiPaymentReturnDataInFacade = new UIPaymentReturnDataInFacade();
	for(int i = 0;i<callCenterSendStatusDtoList3.size();i++){
		CallCenterSendStatusDto csDto = callCenterSendStatusDtoList3.get(i);
		uiPaymentReturnDataInFacade.reissuePaymentReturnDate(csDto.getRegistNo(),csDto.getSerial(),"1");
	}
	System.out.println("--3.回访数据传入接口：案件有支付信息时调用--结束");
	System.out.println("针对核心传到过河兵失败的数据，定时任务补传结束");
%>