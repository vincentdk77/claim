<%--
****************************************************************************
* DESC       ���᰸�в�ѯ��ӡ�������鸽ҳ�����ʾҳ��
* AUTHOR     ��zhaozhuo
* CREATEDATE ��2005-04-06
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/endcase/js/DAAEndcaseEdit.js"> </script>
</head>
<body >
<table class=common cellpadding="5" cellspacing="1">
 <%
       String strcompensateNo = (String)request.getParameter("compensateNo");
       String[] strcompensateNoList;
       strcompensateNoList = strcompensateNo.split(",");
       for (int i=1;i<strcompensateNoList.length;i++){
  %>
     <tr>
       <td width="33%">��������<%out.print(i);%></td>
       <td width="33%" align="center"><%out.print(strcompensateNoList[i]);%></td>
       <td width="33%" align="center"class="input"> <input type="button" name=buttonPrint13 class='bigbutton' value="��ӡ��ҳ" onclick="return printForm1(this,'<%=strcompensateNoList[i]%>','CompensateAdd');">  </td>
     </tr>
      <%
     }
      %>
</table>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>