<%--

****************************************************************************

* DESC       ���⽡�ղ�������֪ͨ�顡

* AUTHOR     ��dongchengliang

* CREATEDATE ��2005-8-17

* MODIFYLIST ��   id       Date            Reason/Contents

*          ------------------------------------------------------

****************************************************************************/

--%>

<%@ page contentType="text/html; charset=GBK" %>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 



<% 

    DateTime currentDate = new DateTime().current();

%>



<%-- ��ʼ�� --%>

<%@include file="AcciNotClaimNoneFormatPrintIni.jsp"%>



<html>

  <head>

    <title>�⽡�ղ�������֪ͨ��</title>

    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

    <meta http-equiv="Content-Type" content="text/html; charset=gb2312">

  </head>



  <body bgcolor="#FFFFFF" onload="loadForm();">

    <!-- ���ⲿ�� -->

    

    <table width="90%" align="center" cellspacing="0" cellpadding="0" border="0">

      <tr>

        <td colspan="2" height="40" align=top align=center style="text-align:center; font-family:����; font-size:16pt;">

          <B>  ��������֪ͨ��   <B>

        </td>

      </tr>

      <tr>

        <td colspan="2" height="40" align=top align=center style="text-align:right; font-family:����; font-size:10pt;" id="tdRregistNo">

          ������:

        </td>

      </tr>                                                                                       

      <tr> 

        <td id="tdContext" colspan=2 align=center>

 <textarea style="wrap:hard;width:80%" rows="15" cols="80" class=readonlyWhite readonly style="overflow:hidden;"><%= strContext %></textarea>

        </td>

     </tr>

</table>

  <!--include��ӡ��ť-->

  <jsp:include page="/common/print/PrintButton.jsp" />   

  </body>

</html>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        

                        