<%--
****************************************************************************
* DESC       ：测试处理显示界面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-08-04
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--对title处理-->
    <title>
      显示界面的处理
    </title>
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/test/ShowPage.js"> </script>
 </head>
<body class="interface" onload="readonlyAllInput();disabledAllButton('buttonArea');">

   <!--建立显示的录入条，可以收缩显示的-->
      <!--建立显示的录入条，可以收缩显示的-->


   <input type='hidden' name='pageCode' value="PersonLoss">
   <input type='hidden' name='recordCount'>
   "以下为不同的输入域"
   <table id="inputArea" class="common" align="center" cellspcing="1" cellpadding="0">
      <tr>
        <td><input type="text" name="testText"><input type="text" name="testText"><input type="text" name="testText"></td>
      </tr>
      <tr>
        <td><select class='common' style="width:110" name="testSelect">
                       <option value="1">京A0001</option>
                       <option value="2">京A0002</option>
                       <option value="3">京A0003</option>
                       <option value="4">京A0004</option>
                    </select>
                    <select class='common' style="width:110" name="testSelect">
                       <option value="1">京A0001</option>
                       <option value="2">京A0002</option>
                       <option value="3">京A0003</option>
                       <option value="4">京A0004</option>
                    </select></td>
      </tr>
      <tr>
        <td>
        <input type=text class="codecode" name="prpLregistDamageCode"  style="width:40px" title="出险原因" value=""
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
           <input type=text class="codecode" name="prpLregistDamageName"  title="出险原因" style="width:125px" value=""
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','always','none','post');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
          <img src="/claim/images/bgMarkMustInput.jpg">       </td>
      </tr>
      <tr>
        <td>
           <input type=radio  name="testRadio" value="Y">是
           <input type=radio  name="testRadio" value="N">否
        </td>
      </tr>

   </table>
   <textarea name=Context wrap="hard" rows=15 cols=80 class=common>
   </textarea>

   <table id="buttonArea" class="common" align="center" cellspcing="1" cellpadding="0">
      <tr>
        <td><input type="button" name="testButton" value="确定"></td>
      </tr>
      <tr>
        <td><input type="reset" name="testCancel" value="取消"></td>
      </tr>
      <tr>
        <td><input type="submit" name="testSubmit" value="提交"></td>
      </tr>
   </table>
   <input type="button" name="showPage" onclick="return readonlyAllInput();" value=" 测试只读 ">
   <input type="button" name="showPage" onclick="return disabledAllButton('buttonArea');" value=" 按钮不可用 ">
  <!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>