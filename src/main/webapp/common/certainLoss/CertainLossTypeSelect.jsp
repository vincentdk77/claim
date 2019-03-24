<%
  System.out.println("---------1--------------");
%>
<%--
****************************************************************************
* DESC       ：录入定损前输入报案号页面
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

<html:html locale="true">
<head>
  <title>录入单证</title>
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

  <jsp:include page="/common/pub/StaticJavascript.jsp" />
<script language="javascript">
  function submitForm()
  {
    //alert(fm.lossTypeFlag[2].checked==true);
    if(fm.lossTypeFlag[2].checked==true){
      fm.sLossItemCode.value=-1;
    }
    if(fm.lossTypeFlag[1].checked==true){
      fm.sLossItemCode.value=0;
    }
    if(fm.lossTypeFlag[3].checked==true){
      fm.sLossItemCode.value=-2;
    }
    if(fm.lossTypeFlag[0].checked==true){
      fm.sLossItemCode.value=<%= request.getParameter("sLossItemCode") %>;
    }
      //alert("****1****"+fm.sLossItemCode.value);
    fm.submit(); //提交
  }
</script>
</head>

<body  onload="initPage();">
<form name="fm" action="/claim/certainLossBeforeEdit.do"  method="post"  onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=2 class="formtitle">选择定损类型</td></tr>
      <tr>
        <td class='title2'  align="center">报案号：</td>
        <td class='input2' >
<%
          String registNo=request.getParameter("RegistNo");
          if(registNo==null||registNo.length()<1){
            registNo=request.getParameter("prpLverifyLossRegistNo");
          }
%>
          <input type=text name="RegistNo" class="readonly" readonly value="<%= registNo %>">
        </td>

      </tr>
        <tr>
        <td class='common'   align="center" colspan=2>
          <input type="button" class='button' value="下一步" name="buttonNext" onclick="submitForm();">
        </td>
        </tr>
      <tr>
        <td class='title2'  align="center">定损类型：</td>
        <td class='input2' >
          <input type="hidden" name="caseFlag">
          <input type="radio" name="lossTypeFlag" value="1" checked>车损
          <input type="radio" name="lossTypeFlag" value="0">人伤
          <input type="radio" name="lossTypeFlag" value="-1">物损
          <input type="radio" name="lossTypeFlag" value="4">全损
        </td>
      </tr>
    </table>
    <%
      String nodeStatus=request.getParameter("status");
      String editType = "ADD";
      if(nodeStatus!=null){
        if (nodeStatus.equals("2")||nodeStatus.equals("3"))
        {
          editType="EDIT";
        } else if(nodeStatus.equals("4")){
          editType="SHOW";
        }else if(nodeStatus.equals("0")){
          editType="ADD";
        }
     }
      System.out.println("------1--status-----"+request.getParameter("status")+"---editType------------"+editType);
    %>
    <input type="hidden" name="editType" value="<%= editType %>">
    <input type="hidden" name="sInsureCarFlag" value="<%= request.getParameter("sInsureCarFlag") %>">
    <input type="hidden" name="sLossItemCode" value="<%= request.getParameter("sLossItemCode") %>">
    <input type="hidden" name="sLossItemName" value="<%= request.getParameter("sLossItemName") %>">
        <input type="hidden" name="swfLogFlowID" value="<%= request.getParameter("swfLogFlowID") %>">
        <input type="hidden" name="swfLogLogNo" value="<%= request.getParameter("swfLogLogNo") %>">
  </form>
</body>
</html:html>



