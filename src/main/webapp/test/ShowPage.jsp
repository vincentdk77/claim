<%--
****************************************************************************
* DESC       �����Դ�����ʾ����
* AUTHOR     ��weishixin
* CREATEDATE ��2004-08-04
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      ��ʾ����Ĵ���
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/test/ShowPage.js"> </script>
 </head>
<body class="interface" onload="readonlyAllInput();disabledAllButton('buttonArea');">

   <!--������ʾ��¼����������������ʾ��-->
      <!--������ʾ��¼����������������ʾ��-->


   <input type='hidden' name='pageCode' value="PersonLoss">
   <input type='hidden' name='recordCount'>
   "����Ϊ��ͬ��������"
   <table id="inputArea" class="common" align="center" cellspcing="1" cellpadding="0">
      <tr>
        <td><input type="text" name="testText"><input type="text" name="testText"><input type="text" name="testText"></td>
      </tr>
      <tr>
        <td><select class='common' style="width:110" name="testSelect">
                       <option value="1">��A0001</option>
                       <option value="2">��A0002</option>
                       <option value="3">��A0003</option>
                       <option value="4">��A0004</option>
                    </select>
                    <select class='common' style="width:110" name="testSelect">
                       <option value="1">��A0001</option>
                       <option value="2">��A0002</option>
                       <option value="3">��A0003</option>
                       <option value="4">��A0004</option>
                    </select></td>
      </tr>
      <tr>
        <td>
        <input type=text class="codecode" name="prpLregistDamageCode"  style="width:40px" title="����ԭ��" value=""
             ondblclick="code_CodeSelect(this, 'DamageCode');"
             onkeyup= "code_CodeSelect(this, 'DamageCode');">
           <input type=text class="codecode" name="prpLregistDamageName"  title="����ԭ��" style="width:125px" value=""
             ondblclick="code_CodeSelect(this, 'DamageCode','-1','always','none','post');"
             onkeyup= "code_CodeSelect(this, 'DamageCode','-1','always','none','post');">
          <img src="/claim/images/bgDoubleClick1.gif" width="13" height="13" align="absmiddle">
          <img src="/claim/images/bgMarkMustInput.jpg">       </td>
      </tr>
      <tr>
        <td>
           <input type=radio  name="testRadio" value="Y">��
           <input type=radio  name="testRadio" value="N">��
        </td>
      </tr>

   </table>
   <textarea name=Context wrap="hard" rows=15 cols=80 class=common>
   </textarea>

   <table id="buttonArea" class="common" align="center" cellspcing="1" cellpadding="0">
      <tr>
        <td><input type="button" name="testButton" value="ȷ��"></td>
      </tr>
      <tr>
        <td><input type="reset" name="testCancel" value="ȡ��"></td>
      </tr>
      <tr>
        <td><input type="submit" name="testSubmit" value="�ύ"></td>
      </tr>
   </table>
   <input type="button" name="showPage" onclick="return readonlyAllInput();" value=" ����ֻ�� ">
   <input type="button" name="showPage" onclick="return disabledAllButton('buttonArea');" value=" ��ť������ ">
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>