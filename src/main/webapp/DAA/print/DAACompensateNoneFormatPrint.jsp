<%--
****************************************************************************
* DESC       ：机动车辆保险赔款计算书打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：22004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%
			String configCode = (String)request.getAttribute("configCode");
			if("RISKCODE_DAZ".equals(configCode)||"RISKCODE_DAY".equals(configCode)||"RISKCODE_DAU".equals(configCode))
			{
%>

 <%@include file="DAABZCompensateNoneFormatPrint.jsp"%>
 
<%
			}
		else
			{
%>

   <%@include file="DAADCompensateNoneFormatPrint.jsp"%>
   
<%
			}
%>