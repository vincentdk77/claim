<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.PrpChospitalPersonDto"%>

<%
ArrayList insuredList = (ArrayList)request.getAttribute("insuredList");
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<script src="/claim/commonAcci/regist/js/AcciRegistEdit.js"></script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
	</head>
	<body>
		<form name="fm" method="post">
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td colspan="4" class="formtitle">被保险人信息查询结果</td>
				</tr>
				<tr>
					<td class="centertitle">医疗证号</td>
					<td class="centertitle">身份证号</td>
					<td class="centertitle">姓名</td>
					<td class="centertitle">地址</td>
				</tr>
				<%
				if(insuredList!=null&&insuredList.size()>0)
				{
				  for(int i=0;i<insuredList.size();i++)
				  {
				    PrpChospitalPersonDto prpChospitalPersonDto = new PrpChospitalPersonDto();
				    prpChospitalPersonDto = (PrpChospitalPersonDto)insuredList.get(i);
				%>
				<tr>
				  <td align="center"><a href="/claim/0807registBeforeEdit.do?hospitalNumber=<%=prpChospitalPersonDto.getHospitalNumber()%>&editType=ADD&prpCmainPolicyNo=<%=prpChospitalPersonDto.getPolicyNo()%>"><%=prpChospitalPersonDto.getHospitalNumber()%></a></td>
				  <td align="center"><%=prpChospitalPersonDto.getIdentifyNumber()%></td>
				  <td align="center"><%=prpChospitalPersonDto.getInsuredName()%></td>
				  <td align="center"><%=prpChospitalPersonDto.getInsuredAddress()%></td>
				</tr>
				<%
				  }
				}
				%>
			</table>
		</form>
	</body>
</html>