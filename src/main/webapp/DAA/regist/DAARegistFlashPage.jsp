<%--
****************************************************************************
* DESC       �� ˢ�³��ձ���ҳ��
* AUTHOR     �� ��Ԫ
* CREATEDATE �� 2009-06-17
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html;charset=gb2312"%>    
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- ����bean�ಿ�� --%>
<%@page import="java.util.*"%>

<%
    String  mainPolicyNo = (String)request.getAttribute("mainPolicyNo");  
    String  qsFlag = (String)request.getAttribute("qsFlag");      
    String  qs_PerilCount = (String)request.getAttribute("intPerilCount");  
    String  qs_RecentCount = (String)request.getAttribute("intRecentCount");  
    String isStoppingCI = (String)request.getAttribute("isStoppingCI");//��ǿ����ͣʻ�ڼ��ڵñ�־
    String isStoppingBusiness = (String)request.getAttribute("isStoppingBusiness");//��ҵ����ͣʻ�ڼ��ڵı�־
    String isValidRelatedFlag = (String)request.getAttribute("isValidRelatedFlag");//��ҵ�ա���ǿ����Ч��������ı�־
    String immediateValidPeriod = (String)request.getAttribute("immediateValidPeriod");//��ʱ��Ч�ĵı����Ƿ��ڱ���������
%>
<script>
    parent.fraInterface.fm.mainPolicyNo.value               = '<%= mainPolicyNo%>';
    parent.fraInterface.fm.qsFlag.value                     = '<%= qsFlag%>';
    parent.fraInterface.fm.qs_PerilCount.value              = '<%= qs_PerilCount%>';
    parent.fraInterface.fm.qs_RecentCount.value             = '<%= qs_RecentCount%>';
    parent.fraInterface.fm.qs_prpLregistStartDate.value		= '<bean:write name='qs_prpCmainDto' property='startDate' filter='true' />';
    parent.fraInterface.fm.qs_prpLregistEndDate.value		= '<bean:write name='qs_prpCmainDto' property='endDate' filter='true' />';			

    
    
    parent.fraInterface.fm.isStoppingCI.value               = '<%= isStoppingCI%>';
    parent.fraInterface.fm.isStoppingBusiness.value         = '<%= isStoppingBusiness%>';
    parent.fraInterface.fm.isValidRelatedFlag.value         = '<%= isValidRelatedFlag%>';
    parent.fraInterface.fm.immediateValidPeriod.value       = '<%= immediateValidPeriod%>';    
    parent.fraInterface.fm.prpLregistInsuredCode.value      = '<bean:write name='prpCmainDto' property='insuredCode' filter='true' />';//�������˴��� 
    parent.fraInterface.fm.prpLregistInsuredName.value      = '<bean:write name='prpCmainDto' property='insuredName' filter='true' />';//������������  
    parent.fraInterface.fm.prpLregistEndDate.value          = '<bean:write name='prpCmainDto' property='endDate' filter='true' />';//�ձ�����
    parent.fraInterface.fm.prpLregistPolicyNo.value 		= '<bean:write name='prpCmainDto' property='policyNo' filter='true' />';
    parent.fraInterface.fm.prpLregistRiskCode.value 		= '<bean:write name='prpCmainDto' property='riskCode' filter='true' />';
    parent.fraInterface.fm.qsFlag.onblur();
    parent.fraInterface.fm.flashPageFlag.value="1";
</script>