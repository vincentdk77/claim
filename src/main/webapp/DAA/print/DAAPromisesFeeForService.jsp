<%--
****************************************************************************
* DESC       ����ŵ֧��ҽ�Ʒ��õ�������ӡҳ��
* AUTHOR     ��zhaolu
* CREATEDATE ��2006-06-12
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=gb2312" %>

<%@ page import="java.util.Calendar;" %>
<%@ page import="java.util.GregorianCalendar;" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
  <%-- ��ʼ�� --%>
<%@include file="DAAPersonDamageInvesReportNoneFormatPrintIni.jsp"%>
<%
   Calendar calendar = new GregorianCalendar();

   String strGetYear = strdamageStartDate.substring(0,4);
   
   String strGetMonth = strdamageStartDate.substring(5,7);
   
   String strGetDate = strdamageStartDate.substring(8,10);
   
   String currYear = Integer.toString(calendar.get(Calendar.YEAR));
    
   String currMonth = Integer.toString(calendar.get(Calendar.MONTH) + 1);
    
   String currDay   = Integer.toString(calendar.get(Calendar.DAY_OF_MONTH));
   
   
%>
<html>
  <head>
    <title>��ŵ֧��ҽ�Ʒ��õ�����</title>
    
   <style type="text/css">
   INPUT.printline
{
    FONT-SIZE: 10pt;
    BORDER-TOP: #ececec 0px solid;
    WIDTH: 10px;
    COLOR: #000000;
    BORDER-BOTTOM: #400000 1px solid;
    BORDER-RIGHT-STYLE: none;
    BORDER-LEFT-STYLE: none;
    BACKGROUND-COLOR: #ffffff
    text-align:center
}
   </style> 
  </head>

  <body bgcolor="#FFFFFF">
  <div align="center">
    <table width="52%" border="0" align="center" cellpadding="0" cellspacing="0" style="font-family:����; font-size:10pt;">
      <tr height=30>
        <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg"/></span> </td>
      </tr>
      <tr height=30>
        <td colspan="2" align=center style=" font-family:����; font-size:14pt;"> <B>
          <center>
      ��ŵ֧��ҽ�Ʒ��õ�����
          <center>
            <B> </b>
          </center>
          </center>
        </b><br><br></td>
      </tr>
      <tr height=20>
        <td width="48%" height="25" align=left ><input type=text name="prplCommission"   readonly="true" class="printline" style=" width:150px;text-align:center" value="   <%=strHospital%>">:</td>
      </tr>
      <tr height=20>
        <td height="25" colspan="2" align=center >&nbsp;�ҹ�˾<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:150px;text-align:center" value="<%=strPolicyNo%>">���³б��ĳ���<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:90px;text-align:center" value="<%=strLicenseNo%>">,<br><br>��<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:30px;text-align:center" value="<%=strGetYear%>">��<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:20px;text-align:center" value="<%=strGetMonth%>">��<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:20px;text-align:center" value="<%=strGetDate%>">�շ����¹�,��<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:100px;text-align:center" value="<%=strD1%>">����,����ҽԺ����,<br><br>&nbsp;����<<��·��ͨ�¹���Ա��������ָ��>>�͹��һ���ҽ�Ʊ��ձ�׼,��ҽ<br><br>�Ʒ����⳥�޶���֧��<input type=text name="prplCommission"   readonly="true" class="printline" style=" width:100px;text-align:center" value="<%=strD1%>">�����ȷ���.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
        <tr height=20>
        <td height="25" colspan="2" align=right><br><br><br><br><br>�����˸���:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
      <tr height=20>
        <td height="25" colspan="2" align=right><br><br><%=currYear+"       "%>��<%="       "+currMonth+"       "%>��<%="       "+currDay+"       "%>��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp</td>
      </tr>
      </tr>
    </table>
  </div>
  <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
  <script language='javascript'>
    function printPage()
    {
      divButton.style.display = "none";
      window.print();
    }
  </script>
  </body>
</html>
