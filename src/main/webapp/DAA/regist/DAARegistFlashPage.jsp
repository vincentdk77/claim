<%--
****************************************************************************
* DESC       ： 刷新车险报案页面
* AUTHOR     ： 国元
* CREATEDATE ： 2009-06-17
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html;charset=gb2312"%>    
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- 引入bean类部分 --%>
<%@page import="java.util.*"%>

<%
    String  mainPolicyNo = (String)request.getAttribute("mainPolicyNo");  
    String  qsFlag = (String)request.getAttribute("qsFlag");      
    String  qs_PerilCount = (String)request.getAttribute("intPerilCount");  
    String  qs_RecentCount = (String)request.getAttribute("intRecentCount");  
    String isStoppingCI = (String)request.getAttribute("isStoppingCI");//交强险在停驶期间内得标志
    String isStoppingBusiness = (String)request.getAttribute("isStoppingBusiness");//商业险在停驶期间内的标志
    String isValidRelatedFlag = (String)request.getAttribute("isValidRelatedFlag");//商业险、交强险有效关联理赔的标志
    String immediateValidPeriod = (String)request.getAttribute("immediateValidPeriod");//即时生效的的保单是否在保险期限内
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
    parent.fraInterface.fm.prpLregistInsuredCode.value      = '<bean:write name='prpCmainDto' property='insuredCode' filter='true' />';//被保险人代码 
    parent.fraInterface.fm.prpLregistInsuredName.value      = '<bean:write name='prpCmainDto' property='insuredName' filter='true' />';//被保险人名称  
    parent.fraInterface.fm.prpLregistEndDate.value          = '<bean:write name='prpCmainDto' property='endDate' filter='true' />';//终保日期
    parent.fraInterface.fm.prpLregistPolicyNo.value 		= '<bean:write name='prpCmainDto' property='policyNo' filter='true' />';
    parent.fraInterface.fm.prpLregistRiskCode.value 		= '<bean:write name='prpCmainDto' property='riskCode' filter='true' />';
    parent.fraInterface.fm.qsFlag.onblur();
    parent.fraInterface.fm.flashPageFlag.value="1";
</script>