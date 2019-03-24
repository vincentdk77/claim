<%--
****************************************************************************
* DESC       �������ճ���֪ͨ���嵥��ӡ
* AUTHOR     ��wangwei
* CREATEDATE ��2005-5-22
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="java.util.*"%>
<%-- ��ʼ�� --%>
<%@include file="FreightDamageNoticeNoneFormatPrintIni.jsp"%>


<html>
  <head>
    <title>�����ճ���֪ͨ���嵥��ӡ</title>
    <link rel="stylesheet" type="text/css" href="Standard.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm()">
    <!-- ���ⲿ�� -->
    
    <table width="90%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr>
        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:14pt;">
          <B>������������ϢժҪ <B>
        </td>
      </tr>
      <tr>
        <td id="tdRegistNo" style="text-align:right; font-family:����; font-size:11pt;"> </td>
      </tr>
    </table>
<table border=1 width="90%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:11pt;">                                                                                                                                                                                     
  <tr> 
    <td width="20%">��������</td>
    <td width="30%" id="tdInsuredName" colspan="2"></td>
    <td width="20%">��������</td>
    <td width="30%" id="tdPolicyNo" colspan="2"></td>
  </tr>
  <tr> 
    <td>��������ձ�</td>
    <td  id="tdKindName" colspan="2"><%=strKindName%></td>
    <td>ԤԼЭ���</td>
    <td id="tdBargainNo" colspan="2"><%=strMainPolicyNo%></td>
  </tr>
  <tr>
    <td>���ս��</td>
    <td id="tdAmount" colspan="2"></td>
    <td rowspan="2">�������Ƽ�����</td>
    <td rowspan="2" id="tdQuantity" colspan="2"><%=strLossName%> <%=strLossQuantity%> <%=strUnit%></td>
  </tr>
  <tr>
    <td >��������</td>
    <td id="tdStartDate" colspan="2"></td>
  </tr>
  <tr> 
    <td >����·��</td>
    <td id="tdLindline" colspan="2"></td>
    <td >���䷽ʽ</td>
    <td id="tdConveyance" colspan="2"></td>
  </tr>
  <tr>
    <td>����/���乤��</td>
    <td colspan="2" ><%=strBLNo%></td>
    <td>������</td>
    <td id="tdEstimateLoss" colspan="2"></td>
  </tr>
  <tr> 
    <td>��������</td>
    <td id="tdDamageStartDate"></td>
    <td >���յص�</td>
    <td id="tdDamageAddress"></td>
    <td >����ԭ��</td>
    <td id="tdDamageName"></td>
  </tr>
  <tr> 
    <td>������</td>
    <td > <%=strReportorName%></td>
    <td >��ϵ�绰</td>
    <td > <%=strPhoneNumber%></td>
    <td >��������</td>
    <td > <%=strReportDate%></td>
  </tr>
  <tr>
    <td height="60pix" colspan="6" align="left" valign="top">����ժҪ�� <%=strContent%></td>
  </tr>
  <tr> 
    <td colspan="6">����Ϊ�����Ǽ���Ϣ���Ǽ��ˣ�<%=strReceiverName%>�����������Ǽ����ڣ�<%=strInputDate%></td>
  </tr>
  <tr> 
    <td>������ǩ��</td>
    <td > </td>
    <td >��������</td>
    <td > </td>
    <td >�������</td>
    <td > </td>
  </tr>
  <tr> 
    <td>������ǩ��</td>
    <td colspan="2"></td>
    <td >����</td>
    <td colspan="2"></td>
  </tr>
  <tr> 
    <td colspan="6" align="center">������Ϣ���⾭����д</td>
  </tr>
  <tr> 
    <td >��������</td>
    <td colspan="2">��������������������</td>
    <td >�Ƿ����׷��</td>
    <td colspan="2">�ǡ����������</td>
  </tr>
  <tr> 
    <td>���������/�鿱��</td>
    <td colspan="2"></td>
    <td>��������ʦ</td>
    <td colspan="2"></td>
  </tr>
  <tr> 
    <td>������</td>
    <td colspan="5"></td>
  </tr>
  <tr> 
    <td >������(�����)</td>
    <td colspan="2">&nbsp;</td>
    <td>�������</td>
    <td colspan="2">&nbsp;</td>
  </tr>
  <tr> 
    <td rowspan="4">��ȷ�����Ϣ</td>
    <td>�ջ���</td>
    <td colspan="4">&nbsp;</td>
  </tr>
  <tr> 
    <td colspan="5">����ԭ�򣠣������������������ڣ�������������ж�����ڣ�������������</td>
  </tr>
  <tr> 
    <td colspan="2">����/����/����/����/����</td>
    <td colspan="3"></td>
  </tr>
  <tr>
    <td >������</td>
    <td colspan="2"> </td>
    <td >�������</td>
    <td colspan="2"> </td>
  </tr>
  <tr>
    <td >������</td>
    <td colspan="5"></td>
  </tr>
  <tr> 
    <td>Լ���鿱����</td>
    <td colspan="2"></td>
    <td >ʵ�ʲ鿱��</td>
    <td colspan="2"></td>
  </tr>
  <tr> 
    <td colspan="6" height="150pix" valign="top">��ʧ������վ���:</td>
  </tr>
  <tr> 
    <td colspan="6" height="90pix" valign="top">������ϵ��¼:</td>
  </tr>
</table>
 
  <!--include��ӡ��ť-->
  <jsp:include page="/common/print/PrintButton.jsp" />   
  </body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
                        