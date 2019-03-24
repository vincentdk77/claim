<%--
****************************************************************************
* DESC       ：大病住院医疗计算书打印页面
* AUTHOR     ：hanliang
* CREATEDATE ：2005-12-12
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- 初始化 --%>
  <%@include file="HospCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>大病住院医疗补偿保险赔款计算书</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="40"  align=center style="font-family:宋体; font-size:14pt;">
            <B>大病住院医疗补偿保险赔款计算书<B>
          </td>
        </tr>
      </table>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;赔款计算书号:<%=prpLcompensateDto.getCompensateNo()%>
      
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      	<tr align="center">
      		<td height="30" width="15%">保险单号码</td>
      		<td width="30%" id="tdPolicyNo"></td>
      		<td width="15%">赔案编号</td>
      		<td>&nbsp;<%=strClaimNo%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">被保险人</td>
      		<td width="30%" id="tdInsuredName"></td>
      		<td width="15%">医疗证号</td>
      		<td><%=prpLregistDto.getDamageTypeName()%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">姓名</td>
      		<td width="30%"><%=strPersonName%></td>
      		<td width="15%">家庭住址</td>
      		<td><%=strInsuredAddress%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">入院日期</td>
      		<td width="30%"><%=strDamageStartDate%></td>
      		<td width="15%">出院日期</td>
      		<td><%=strDamageEndDate%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">入住医院</td>
      		<td width="30%"><%=prpLregistDto.getModelCode()%></td>
      		<td width="15%">诊断疾病</td>
      		<td><%=prpLregistDto.getBrandName()%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">保险期限</td>
      		<td colspan="3" id="tdInsuredDate"></td>
      	</tr>
      </table>
      
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      	<tr align="center">
      		<td width="3%" height="250">赔款计算方式</td>
      		<td align="left" valign="top"style="font-family:宋体; font-size:12pt;"><br><br>&nbsp;<%=strContext%></td>
      	</tr>
      	<tr>
      	  <td colspan="2" height="30">&nbsp;&nbsp;赔款金额合计（大写）人民币：&nbsp;<%=strCSumLossPay%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥：&nbsp;<%=strSumLossPay%>元</td>
      	</tr>
      </table>
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
      	<tr>
      		<td width="16%"height="30" align="center" colspan="2">赔款核定</td>
			    <td width="12%" align="center">金额</td>
			    <td width="30%" rowspan="6" align="left" valign="top" id="tdHandlerName"></td>
			    <td width="30%" rowspan="6" align="left" valign="top" id="tdUnderWriteName"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">赔款总额</td>
      		<td align="center"><%=strZongPayFee%></td>
      	</tr>
      	<tr>
      		<td align="center" width="3%" rowspan="2">其<br>中</td>
      		<td align="center">合管办</td>
      		<td align="center">&nbsp;<%=strHezuoFee%></td>
      	</tr>
      	<tr>
      		<td align="center">保险公司</td>
      		<td align="center">&nbsp;<%=strSumLossPay%></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">施救费</td>
      		<td id="tdRescueFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">查勘费</td>
      		<td id="tdCheckFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">检验鉴定费</td>
      		<td id="tdJudgeFee" align="center"></td>
      		<td width="60%" colspan="2" rowspan="6" align="left" valign="top">&nbsp;支公司意见：<br><br><br><br><br><br><br><br><br><br><br><p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;</p></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">共损救助费</td>
      		<td id="tdGsjzFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">公估费</td>
      		<td id="tdAssessFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">法律费</td>
      		<td id="tdFlFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">其他</td>
      		<td id="tdElseFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">保险公司赔款合计</td>
      		<td align="center"><%=strSumLossPay%></td>
      	</tr>
      </table>

	        <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
  </body>

</html>
