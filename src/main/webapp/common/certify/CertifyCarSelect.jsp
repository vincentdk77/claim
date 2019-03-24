<%--
****************************************************************************
* DESC       ：录入单证前输入报案号页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-07-05
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.ui.control.action.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>

<html:html locale="true">
<head>
  <title>录入单证</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
  function submitForm()
  {
    fm.buttonNext.disabled = true;
    var ref="";
    if(fm.carFlag.length>0){
      for(i=0;i<fm.carFlag.length;i++){
        if(fm.carFlag[i].checked==true){
          ref = ref+fm.carFlag[i].value+",";
        }
      }
    } else {
      if(fm.carFlag.checked==true){
        ref=fm.carFlag.value+",";
      }
    }
    fm.carLossFlag.value = ref;
    fm.submit(); //提交
  }
</script>
</head>
<body  onload="initPage();">
<form name="fm" action="/claim/certifyBeforeEdit.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1" class="common">
    <tr> <td colspan=2 class="formtitle">选择车辆标的</td></tr>
      <tr>
        <td class='title2' >车辆标的:</td>
        <td class='input2' >
          <input type="hidden" name="carLossFlag">
          <logic:notEmpty  name="registDto"  property="prpLthirdPartyDtoList">
          <logic:iterate id="registList1"  name="registDto"  property="prpLthirdPartyDtoList">
            <input type="checkbox" name="carFlag" value="<bean:write name='registList1' property='licenseNo'/>"><bean:write name="registList1" property="licenseNo"/>&nbsp;&nbsp;
          </logic:iterate>
          </logic:notEmpty>
        </td>
         <input type="hidden" name="caseFlag" value="<%= request.getParameter("caseFlag") %>">
        <input type="hidden" name="RegistNo" class="common" value="<%= request.getParameter("RegistNo") %>">

        </tr>
        <tr><td class='button' align="center" colspan="2">
          <input type="button" class='button' value="下一步" name="buttonNext" onclick="submitForm();">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="ADD">
  </form>
</body>
<%
  Object compensateFlag = request.getAttribute("strCompensateFlag");
  System.out.println("================compensateflag===="+compensateFlag);
  if(compensateFlag!=null){
%>
<SCRIPT LANGUAGE="JavaScript">
<!--
  alert("车 "+compensateFlag+" 已出赔款计算书,不能再收集单证");
//-->
</SCRIPT>
<%
  }
%>
</html:html>



