<%--
****************************************************************************
* DESC       �����������ֳ��鿱��¼��ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ page import="java.util.*"%>
   <%-- ��ʼ�� --%>
<%@include file="LiabLocaleCheckReportNoneFormatPrintini.jsp"%>
  
<html>    
<link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  
  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <p align="center"><b>��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��&nbsp;��</b></p>
        </td>
      </tr>
      <tr>
        <td align="right" colspan="2" id="tdRegistNo">������ţ�</td>
      </tr>
    </table>  

	    <table border=1 width="90%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" 

		    bordercolor="#111111" style="font-family:����; font-size:10pt;"> 


			<tr align="center">

			    <td width="20%" height="25">��������</td>

				<td width="30%" id="tdInsuredName">&nbsp;</td>

				<td width="20%">���յ���</td>

				<td width="30%" id="tdPolicyNo">&nbsp;</td>

			</tr>
			<tr align="center">

			    <td width="20%" height="25">������</td>

				<td width="30%" id="tdEndorseNo">&nbsp;</td>

				<td width="20%">��������</td>

				<td width="30%" id="tdDate">&nbsp;</td>

			</tr>
			<tr align="center">

			    <td width="20%" height="25">���յص�</td>

				<td width="30%" id="tdDamageAddress">&nbsp;</td>

				<td width="20%">����ԭ��</td>

				<td width="30%" id="tdDamageClause">&nbsp;</td>

			</tr>
			<tr align="center">

			    <td width="20%" height="25">���ձ��</td>

				<td width="30%" id="tdLossName">&nbsp;</td>

				<td width="20%">������</td>

				<td width="30%" id="tdEstimateLoss">&nbsp;</td>

			</tr>
			<tr align="center">

			    <td width="20%" height="25">����ʱ��</td>

				<td width="30%" id="tdReportDate">&nbsp;</td>

				<td width="20%">����ʱ��</td>

				<td width="30%" id="tdDamageStartDate">&nbsp;</td>

			</tr>

			<tr align="center">

			    <td width="20%" height="25">��ϵ��</td>

				<td width="30%" id="tdLinkerName">&nbsp;</td>

				<td width="20%">��ϵ��ʽ</td>

				<td width="30%" id="tdPhoneNumber">&nbsp;</td>

			</tr>

			<tr height="300">

			    <td colspan="4" align="center">

				     <table width="100%" height="100%">

					     <tr><td colspan="2" valign="top" height="500">
						 <p>����д��������ԭ�򡢾����Լ���ʧ�������������ȫ����ʧ����д�鿱�������</p>
						 <%=strContext%>
						 </td></tr>


					 </table>

				</td>

			</tr>
			<tr >

			    <td colspan="4" align="left">
                 <br>
				 �鿱ʱ�䣺<%=strCheckDate%>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;				 
�鿱�ص㣺<%=strCheckSite%>
				 <br><br>
				 <br><br>
                 ��&nbsp;��&nbsp;�ˣ�<%=strChecker1%>
				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				  ������ǩ����&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��
				<br><br>
				</td>

			</tr>

		</table>

      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
          
  </body> 
</html>
 