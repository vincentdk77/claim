<%--
****************************************************************************
* DESC       ��·�����ӱ༭����
* AUTHOR     �� weishixin
* CREATEDATE �� 2004-8-10
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"  %>

<html>
<head>
    <!--��title����-->
    <title>
      ·�����ӱ༭
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/workflow/model/js/WorkFlowPathAddEdit.js"></script>

 </head>
<body class="interface" onload="loadForm();">
  <form name=fm action="" method="post" >

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">

    <tr><td class="formtitle" colspan=4>������ģ��·���༭</td></tr>
      <tr>

        <td class="title">·���ţ�</td>
        <td class="input" >
          <input type=text name="swfPathPathNo" class="readonly" readonly="true" value="">
        </td>
        <td class="title" style="valign:bottom" >·�����ƣ�</td>
        <td class="input" style="valign:middle">
          <input type=text name="swfPathPathName"  class="common" value="">
        </td>
      </tr>
      <tr>
        <td class="title">��ʼ�ڵ㣺</td>
        <td class="input">
           <select name="swfPathStartNodeNo" class="three" onchange="resetStartNodeName();">
           </select>
        </td>
        <td class="title">��ʼ�ڵ����ƣ�</td>
        <td class="input">
          <input type=text name="swfPathStartNodeName"  class="common" value="">
        </td>
      </tr>
      <tr>
        <td class="title">��ֹ�ڵ㣺</td>
        <td class="input">
           <select name="swfPathEndNodeNo" class="three" onchange="resetEndNodeName();">
           </select>
        </td>
        <td class="title">��ֹ�ڵ����ƣ�</td>
        <td class="input">
          <input type=text name="swfPathEndNodeName"  class="common" value="">
        </td>
      </tr>
      <tr>
        <td class="title">���ȼ���</td>
        <td class="input">
           <input type=text name="swfPathPriority"  class="common" value="0">
        </td>
        <td class="title">ȱʡ·����</td>
        <td class="input">
          <select name="swfPathDefaultFlag"  size="1" class="three">
             <option value="0" SELECTED >��
             <option value="1" >��
             <option value="3" >��ѡ��
          </select>
        </td>
      </tr>

    </table>
      <table cellpadding="10" cellspacing="0" width="100%">

            <tr>
              <td class=button style="width:50%" align="center">
                <!--���水ť-->
                <input type="button" name=buttonSave class='button' value=" ȷ �� " onclick="return saveModelForm();">
              </td>

             <td class=button style="width:50%" align="center">
                <!--ȡ����ť-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="window.close();" >
             </td>

        </tr>
      </table>
         <input type=hidden name="WorkFlowPathPageID" value="WorkFlowPath">
         <input type=hidden name="WorkFlowPathRecordOrder" value="">
  </form>
</body>
</html>