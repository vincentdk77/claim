<%--
****************************************************************************
* DESC       ����סԺҽ�Ƽ������ӡҳ��
* AUTHOR     ��hanliang
* CREATEDATE ��2005-12-12
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- ��ʼ�� --%>
  <%@include file="HospCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>��סԺҽ�Ʋ���������������</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="40"  align=center style="font-family:����; font-size:14pt;">
            <B>��סԺҽ�Ʋ���������������<B>
          </td>
        </tr>
      </table>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������:<%=prpLcompensateDto.getCompensateNo()%>
      
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      	<tr align="center">
      		<td height="30" width="15%">���յ�����</td>
      		<td width="30%" id="tdPolicyNo"></td>
      		<td width="15%">�ⰸ���</td>
      		<td>&nbsp;<%=strClaimNo%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">��������</td>
      		<td width="30%" id="tdInsuredName"></td>
      		<td width="15%">ҽ��֤��</td>
      		<td><%=prpLregistDto.getDamageTypeName()%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">����</td>
      		<td width="30%"><%=strPersonName%></td>
      		<td width="15%">��ͥסַ</td>
      		<td><%=strInsuredAddress%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">��Ժ����</td>
      		<td width="30%"><%=strDamageStartDate%></td>
      		<td width="15%">��Ժ����</td>
      		<td><%=strDamageEndDate%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">��סҽԺ</td>
      		<td width="30%"><%=prpLregistDto.getModelCode()%></td>
      		<td width="15%">��ϼ���</td>
      		<td><%=prpLregistDto.getBrandName()%></td>
      	</tr>
      	<tr align="center">
      		<td height="30" width="15%">��������</td>
      		<td colspan="3" id="tdInsuredDate"></td>
      	</tr>
      </table>
      
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      	<tr align="center">
      		<td width="3%" height="250">�����㷽ʽ</td>
      		<td align="left" valign="top"style="font-family:����; font-size:12pt;"><br><br>&nbsp;<%=strContext%></td>
      	</tr>
      	<tr>
      	  <td colspan="2" height="30">&nbsp;&nbsp;�����ϼƣ���д������ң�&nbsp;<%=strCSumLossPay%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)����&nbsp;<%=strSumLossPay%>Ԫ</td>
      	</tr>
      </table>
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      	<tr>
      		<td width="16%"height="30" align="center" colspan="2">���˶�</td>
			    <td width="12%" align="center">���</td>
			    <td width="30%" rowspan="6" align="left" valign="top" id="tdHandlerName"></td>
			    <td width="30%" rowspan="6" align="left" valign="top" id="tdUnderWriteName"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">����ܶ�</td>
      		<td align="center"><%=strZongPayFee%></td>
      	</tr>
      	<tr>
      		<td align="center" width="3%" rowspan="2">��<br>��</td>
      		<td align="center">�Ϲܰ�</td>
      		<td align="center">&nbsp;<%=strHezuoFee%></td>
      	</tr>
      	<tr>
      		<td align="center">���չ�˾</td>
      		<td align="center">&nbsp;<%=strSumLossPay%></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">ʩ�ȷ�</td>
      		<td id="tdRescueFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">�鿱��</td>
      		<td id="tdCheckFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">���������</td>
      		<td id="tdJudgeFee" align="center"></td>
      		<td width="60%" colspan="2" rowspan="6" align="left" valign="top">&nbsp;֧��˾�����<br><br><br><br><br><br><br><br><br><br><br><p align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;</p></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">���������</td>
      		<td id="tdGsjzFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">������</td>
      		<td id="tdAssessFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">���ɷ�</td>
      		<td id="tdFlFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">����</td>
      		<td id="tdElseFee" align="center"></td>
      	</tr>
      	<tr>
      		<td align="center" colspan="2">���չ�˾���ϼ�</td>
      		<td align="center"><%=strSumLossPay%></td>
      	</tr>
      </table>

	        <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
  </body>

</html>
