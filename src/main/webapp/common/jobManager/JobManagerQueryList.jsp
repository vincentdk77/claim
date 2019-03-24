
<%@page import="com.sinosoft.claim.dto.domain.PrpljobmanagerDto"%>
<%@page import="com.sinosoft.reins.utility.ui.control.action.UICodeAction"%>
<%@page import="java.util.Iterator"%><%--
****************************************************************************
* DESC       ：班表信息查询结果
* AUTHOR     ：chengyupeng
* CREATEDATE ：2011-11-14
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>
<html:html locale="true">
<head>
	<app:css />

	<title><bean:message key="title.claimBeforeEdit.queryClaim" /></title>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/common/js/showpage.js"> </script>
	<html:base />
</head>

<body>
	<!---add by zhaolu 20060803 start--->
	<form name="fm" action="/claim/jobManagerQuery.do" method="post">
		<!---add by zhaolu 20060803 end--->
		<table class="common" width="99%" cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;background-color: #F7F7F7;" bordercolor="#3A81C8" >
			<tbody id="top9" style="">

				<tr class="listdragtitle">
					<td class="centertitle">
						序号
					</td>
					<td class="centertitle">
						班表机构
					</td>
					<td class="centertitle">
						当班人员 
					</td>
					<td class="centertitle">
						班表月份
					</td>
					<td class="centertitle">
						险类
					</td>
					<td class="centertitle">
						维护人员
					</td>
					<td class="centertitle">
						维护时间
					</td>
				</tr>
				<logic:iterate id="prpljobmanager" name="prpljobmanagerDtoList" indexId="count">
					<tr class=listodd>
						<td>
							${count+1}
						</td>
						<td>
							<a href="/claim/jobManagerEdit.do?editType=${editType}&handledept=${prpljobmanager.handledept}&systemCode=${prpljobmanager.systemCode }&classCode=${prpljobmanager.classcode }&month=${prpljobmanager.month}&updateType=institution" target="_parent"/>${prpljobmanager.deptname}</a>
						</td>
						<td>
							<a href="/claim/jobManagerEdit.do?editType=${editType}&handledept=${prpljobmanager.handledept}&systemCode=${prpljobmanager.systemCode }&classCode=${prpljobmanager.classcode }&month=${prpljobmanager.month}&handlercode=${prpljobmanager.handlercode}&updateType=individual" target="_parent"/>${prpljobmanager.handlername}</a>
						</td>
						<td>
							${prpljobmanager.month}
						</td>
						<td>
							<logic:equal value="05" name="prpljobmanager" property="classcode">车险保险类</logic:equal>
							<logic:equal value="31" name="prpljobmanager" property="classcode">种植保险类</logic:equal>
							<logic:equal value="32" name="prpljobmanager" property="classcode">养殖保险类</logic:equal>
							<logic:equal value="99" name="prpljobmanager" property="classcode">非农保险类</logic:equal>
						</td>
						<td>
							${prpljobmanager.operator}
						</td>
						<td>
							${prpljobmanager.flowintime}
						</td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
		
		<table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpljobmanagerDto" property="turnPageDto" toScope="request"/>
                  <jsp:include page="/common/pub/TurnOverPage.jsp" />
              </tr> 
          </table>
		
		<!--- add by zhaolu 20060803 start --->
		<input type="hidden" name="editType"
			value="<%=request.getParameter("editType")%>">
	</form>
	<!--- add by zhaolu 20060803 end  --->
	<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>