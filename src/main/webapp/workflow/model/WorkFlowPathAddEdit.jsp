<%--
****************************************************************************
* DESC       ：路径增加编辑界面
* AUTHOR     ： weishixin
* CREATEDATE ： 2004-8-10
* MODIFYLIST ：   Name       Date            Reason/Contents
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
    <!--对title处理-->
    <title>
      路径增加编辑
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/workflow/model/js/WorkFlowPathAddEdit.js"></script>

 </head>
<body class="interface" onload="loadForm();">
  <form name=fm action="" method="post" >

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">

    <tr><td class="formtitle" colspan=4>工作流模板路径编辑</td></tr>
      <tr>

        <td class="title">路径号：</td>
        <td class="input" >
          <input type=text name="swfPathPathNo" class="readonly" readonly="true" value="">
        </td>
        <td class="title" style="valign:bottom" >路径名称：</td>
        <td class="input" style="valign:middle">
          <input type=text name="swfPathPathName"  class="common" value="">
        </td>
      </tr>
      <tr>
        <td class="title">起始节点：</td>
        <td class="input">
           <select name="swfPathStartNodeNo" class="three" onchange="resetStartNodeName();">
           </select>
        </td>
        <td class="title">起始节点名称：</td>
        <td class="input">
          <input type=text name="swfPathStartNodeName"  class="common" value="">
        </td>
      </tr>
      <tr>
        <td class="title">终止节点：</td>
        <td class="input">
           <select name="swfPathEndNodeNo" class="three" onchange="resetEndNodeName();">
           </select>
        </td>
        <td class="title">终止节点名称：</td>
        <td class="input">
          <input type=text name="swfPathEndNodeName"  class="common" value="">
        </td>
      </tr>
      <tr>
        <td class="title">优先级：</td>
        <td class="input">
           <input type=text name="swfPathPriority"  class="common" value="0">
        </td>
        <td class="title">缺省路径：</td>
        <td class="input">
          <select name="swfPathDefaultFlag"  size="1" class="three">
             <option value="0" SELECTED >否
             <option value="1" >是
             <option value="3" >供选择
          </select>
        </td>
      </tr>

    </table>
      <table cellpadding="10" cellspacing="0" width="100%">

            <tr>
              <td class=button style="width:50%" align="center">
                <!--保存按钮-->
                <input type="button" name=buttonSave class='button' value=" 确 定 " onclick="return saveModelForm();">
              </td>

             <td class=button style="width:50%" align="center">
                <!--取消按钮-->
                <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value'/>" onclick="window.close();" >
             </td>

        </tr>
      </table>
         <input type=hidden name="WorkFlowPathPageID" value="WorkFlowPath">
         <input type=hidden name="WorkFlowPathRecordOrder" value="">
  </form>
</body>
</html>