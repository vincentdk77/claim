 <%--
****************************************************************************
* DESC       ��������ģ��������
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-25
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
      ������ģ��������
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/workflow/model/js/WorkFlowModelAssignEdit.js"></script>
</head>

<body class="interface" onload="initPage();">
    <form name=fm action="/claim/swfModelUseSave.do" method="post">


    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
      <tr>
        <td class="title" colspan="4"> ������ģ�����   </td>
      </tr>
      <tr>
        <td class="title" >ģ�壺</td>
        <td class="input"  >

         <html:select name="swfModelUseDto" property="modelNo" size="10"  styleClass="three"  >
         <html:options collection="modelMainList" property="modelNo"   labelProperty="modelName"/>
		    </html:select>

        </td>

        <td class="title"  style="valign:bottom" >���֣�</td>
        <td class="input"  style="valign:middle">
          <html:select name="swfModelUseDto" property="riskCode" size="10" multiple="true"   styleClass="three" >
             <html:options collection="riskList" property="riskCode"   labelProperty="riskCName"/>
		 </html:select>
        </td>
        </tr>
        <tr>
        <td class="title"  style="valign:bottom" >������</td>
        <td class="input"  style="valign:middle">
          <html:select name="swfModelUseDto" property="comCode" size="10" multiple="true" styleClass="three"  >
		    <html:options collection="companyList" property="comCode"   labelProperty="comCName"/>
		 </html:select>
        </td>
        <td class=title colspan="2"></td>
      </tr>

    </table>
    <input type=hidden name=swfModelUseModelStatus value='1'>
 <input type=hidden name="editType" value="<bean:write name='swfModelUseDto' property='editType' filter='true' />">

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
