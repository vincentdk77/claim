<%--
****************************************************************************
* DESC       ��������ģ��¼��/�޸�ҳ��
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-10
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      ������ģ��༭����
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/workflow/model/js/WorkFlowModelEdit.js"></script>
</head>

<body class="interface" onload="initPage();">
    <form name=fm action="/claim/swfModelSave.do" method="post" onsubmit="return validateForm(this,'WorkFlowNode_Data');">
        <%-- 1.ģ������Ϣ --%>
            <%@include file="/workflow/model/WorkFlowModelMainEdit.jsp" %>
        <%-- 2.ģ��ڵ���Ϣ --%>
            <%@include file="/workflow/model/WorkFlowNodeEdit.jsp"%>
        <%-- 3.ģ��·����Ϣ--%>
            <%@include file="/workflow/model/WorkFlowPathEdit.jsp"%>
        <%-- 4.ģ������� --%>
            <%-- @include file="/workflow/model/WorkFlowConditionEdit.jsp" --%>
        <%-- ����ͨ�ð�ť --%>

          <table cellpadding="0" cellspacing="0" width="100%" style="display:">

            <tr>
              <td class=button style="width:50%" align="center">
                <!--���水ť-->
                <input type="button" name=buttonSave class='button' value="<bean:message key='button.save.value'/>" onclick="return submitForm();">
              </td>

             <td class=button style="width:50%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="return resetForm();" >
             </td>

        </tr>
      </table>
     </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
