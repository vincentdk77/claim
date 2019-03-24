<%--
****************************************************************************
* DESC       ：已出险信息显示画面（非车险）
* AUTHOR     ： Sinosoft
* CREATEDATE ： 2005-09-26
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>

<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>

<html>
<head>
<title>：历次报案信息显示</title>
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
<SCRIPT LANGUAGE="JavaScript">
//按钮单击事件，用于相同保单号码多报案的显示

<!--
//modify by liujianbo modify 20050321 start
//reason:在报案登记画面中，已出险次数的历次出险事故的清单中,可以点击报案号关联到相关案件信息  
/**
 *@description 弹出关联报案信息页面
 *@param       无
 *@return      通过返回true,否则返回false
 */
function showRegist(registNo){	       
	     
    var linkURL = "/claim/registFinishQueryList.do?prpLregistRegistNo="+registNo+"&editType=SHOW";	  
    var newWindow = window.open(linkURL,"NewWindow","width=640,height=500,top=0,left=0,toolbar=yes,location=no,directories=no,menubar=no,scrollbars=yes,resizable=yes,status=no");    
}   


//modify by liujianbo modify 20050321 end

//--> 
</SCRIPT>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginhigh="0">
<form name="fm">
<table class="common" cellpadding="5" cellspacing="1">
	<tr>
		<td class="prompttitle">序号</td>
		<td class="prompttitle">报案号</td>
		<td class="prompttitle">出险时间</td>
		<td class="prompttitle">出险地点</td>
		<td class="prompttitle">状态</td>
	</tr>


	<!-- 插入出险次数详细信息-->
	<%
		//String curRegistNo = (String)request.getAttribute("curRegistNo");

		//原因：从立案信息表中带出部分信息
		ArrayList registClaimDtoList = (ArrayList) request
				.getAttribute("registClaimDtoList");

		if (registClaimDtoList != null) {
			for (int count = 0; count < registClaimDtoList.size(); count++) {
				RegistClaimInfoDto registClaimDto = (RegistClaimInfoDto) registClaimDtoList
				.get(count);
				System.out.println("fasdfjasdf");
				//过滤本案件
				//if(registClaimDto.getRegistNo().equals(curRegistNo))
				//continue;

				int sequenceNo = count + 1;
	%>
	<tr>
		<td class="prompt"><%=sequenceNo%></td>
		<td class="prompt"><a
			href="javascript:showRegist('<%= registClaimDto.getRegistNo() %>')"><%=registClaimDto.getRegistNo()%></a>
		</td>
		<td class="prompt"><%=registClaimDto.getDamageStartDate()%></td>
		<td class="prompt"><%=registClaimDto.getDamageAreaName()%></td>
		<td class="prompt"><%=registClaimDto.getStatus()%></td>
	</tr>
	<%
		}
		}
	%>
	<tr>
		<td colspan=14 class="common" align="center"><input type=button
			name='button_Peril_Close_Context' class=button value='(O)关闭'
			ACCESSKEY="O" onclick="window.close()"></td>
	</tr>
</table>
</form>
</body>
</html>
