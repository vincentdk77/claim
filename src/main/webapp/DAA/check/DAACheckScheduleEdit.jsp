<%--
****************************************************************************
* DESC       ���鿱����ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-08-03
* MODIFYLIST ��   Name       Date            Reason/Contents

****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>

 <script language="JavaScript">
    <!--
javascript:window.history.forward(1);
    //-->
  </script>

<html:html locale="true">
  <!--��title����-->
  <title>�鿱����</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/check/js/DAACheckEdit.js"></script>
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</head>

<body class=interface onload="initPage();initSet1();">
    <form name=fm action="/claim/checkScheduleSave.do" method="post" onsubmit="return validateForm(this);">

      <%-- 1.�鿱����Ϣͷ��Ϣ --%>

      <%@include file="/DAA/check/DAACheckScheduleMainEdit.jsp" %>
      <%-- 2.�鿱������� --%>
      <%@include file="/DAA/check/DAACheckScheduleItemEdit.jsp" %>
      <%-- 3.�鿱��ʾ��Ϣ --%>
      <%-- // @include file="/DAA/claim/DAAClaimFeeEdit.jsp" --%>


      <%-- �鿱�ύͨ�ð�ť --%>

     <table cellpadding="0" cellspacing="10" width="80%" style="display:">

      <%--
      --%>
      <tr>

         <td class="button" style="width:50%" align="center">
                  <!--�鿱���水ť-->
           <input type=submit name=buttonSave class='button' value="����"  >
          </td>

         <td class="button" style="width:50%" align="center">
            <!--ȡ����ť-->
            <input type="button" name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
          </td>
      </tr>
    </table>
 </form>

</body>
</html:html>
