<%--
****************************************************************************
* DESC       ：班表信息查询结果
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-28
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
	<%-- 页面样式  --%>
	<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
	<script src="/claim/common/js/showpage.js"> </script>
	<html:base />
</head>
<body>
	<!---add by zhaolu 20060803 start--->
	<form name="fm" action="/claim/areaSettingQuery.do" method="post">
		<!---add by zhaolu 20060803 end--->
		<table class="common" width="99%" cellpadding="0" cellspacing="0" border="1" style="border-collapse:collapse;background-color: #F7F7F7;" bordercolor="#3A81C8" >
			<tr>
				<td colspan="6" class="formtitle">查询区域设置信息</td>
			</tr>
			<tbody id="top9" style="">
				<tr class="listdragtitle">
					<td class="centertitle">
						序号
					</td>
					<td class="centertitle">
						班表机构
					</td>
					<td class="centertitle">
						被维护人
					</td>
					<td class="centertitle">
						维护人员
					</td>
					<td class="centertitle">
						维护时间
					</td>
				</tr>
				<logic:iterate id="prplareasetting" name="prplareasettingDtoList" indexId="count">
					<tr class=listodd>
						<td>
							${count+1}
						</td>
						<td>
							<a href="/claim/areaSettingEdit.do?editType=EDIT&classCode=${prplareasetting.classcode }&handledept=${prplareasetting.handledept}&state=many" target="_parent">${prplareasetting.handledeptName}</a>
						</td>
						<td>
							<a href="/claim/areaSettingEdit.do?editType=EDIT&classCode=${prplareasetting.classcode }&handledept=${prplareasetting.handledept}&handlercode=${prplareasetting.handlercode}&state=single" target="_parent">${prplareasetting.handlername}</a>
						</td>
						<td>
							${prplareasetting.operator}
						</td>
						<td>
							${prplareasetting.flowintime}
						</td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
		
		<table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prplareasettingDto" property="turnPageDto"/>  
                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
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