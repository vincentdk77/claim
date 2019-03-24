<%--
****************************************************************************
* DESC       :δ���ⰸ��ѯ����¼�����
* AUTHOR     :
* CREATEDATE : 2004-09-28
* MODIFYLIST :   Name       Date            Reason/Contents

****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import = "java.util.Calendar"%>
<%@ page import = "com.sinosoft.sysframework.common.datatype.DateTime"%>
<%
 //�õ�������һ�����յ�����
  //Date date = new Date();
  //String strMonday = ""; //date.getMondayOFWeek();
  //String strSunday = ""; //date.getSundayOFWeek();

  String strSunday =DateTime.current().toString();
  String strMonday = new DateTime(DateTime.current().addMonth(-1),DateTime.YEAR_TO_DAY ).toString() ;
 %>

<html:html locale="true">
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

   <script language=javascript>
    function submitForm()
    {
      fm.submit();
    }
    function resetForm()
    {
      fm.reset();
    }

  </script>


</head>

<body  onload="initPage();">
<form name="fm" action="/claim/NoEndCaseSumQuery.do?"  method="post" onsubmit="return validateForm(this);">

    <table border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr><td colspan=4 class="formtitle">δ���ⰸ��ѯ</td></tr>
      <tr>
      <td class='title' >������룺</td>
      <td class=input >
        <select class=tag    name="ClassCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="ClassCode"  maxlength="3"  class="query" ></td>
 	  <td class='title' >���ִ��룺</td>
      <td class=input >
          <select class=tag  name="RiskCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="RiskCode"  class="query"  maxlength="3"></td>
    </tr>
    <tr>
	  <td  class='title'>�������룺</td>
      <td class=input>
         <select class=tag  name="PolicyNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="PolicyNo" class="query"   maxlength="22"></td>
	  <td class=title>�������룺</td>
      <td class="input">
        <select class=tag  name="ClaimNoCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="ClaimNo" class="query"   maxlength="22"></td>
    </tr>
<!--
    <tr>
      <td class=title>Ͷ���˴���:</td>
      <td class=input>
        <select class=tag name="AppliCodeSign">
          <jsp://include page="/common/pub/UIStringOption.html" />
        </select><input name="AppliCode" class="common" maxlength="16"></td>
      <td class=title>Ͷ��������:</td>
      <td class=input>
        <select class=tag name="AppliNameSign">
          <jsp://include page="/common/pub/UIStringOption.html" />
        </select><input name="AppliName" class="common" maxlength="120"></td>
    </tr>
-->
    <tr>
      <td class=title>�������˴��룺</td>
      <td class=input>
        <select class=tag  name="InsuredCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="InsuredCode" class="query"   maxlength="16"></td>
      <td class=title>�����������ƣ�</td>
      <td class=input>
        <select class=tag   name="InsuredNameSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="InsuredName" class="query"   maxlength="120"></td>
    </tr>
    <tr>
      <td class=title>������ʼ���ڣ�</td>
      <td class=input>
        <select class=tag  name="StartDateSign" >
          <option value="=">=&nbsp;</option>
          <option value=">">&gt;&nbsp;</option>
          <option value="<">&lt;&nbsp;</option>
          <option value=">="  SELECTED>&gt;=</option>
          <option value="<=">&lt;=</option>
          </select> <input name="StartDate" class="Wdate" onfocus="WdatePicker()"  maxlength="21" value=<%=strMonday%> > <!-- <img align="absmiddle" style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.StartDate', '2007', '2017')"></td> -->
      <td class=title>������������:</td>
      <td class=input>
        <select class=tag   name="EndDateSign" >
           <option value="=">=&nbsp;</option>
          <option value=">">&gt;&nbsp;</option>
          <option value="<">&lt;&nbsp;</option>
          <option value=">=">&gt;=</option>
          <option value="<="  SELECTED>&lt;=</option>
          </select> <input name="EndDate" class="Wdate" onfocus="WdatePicker()"  maxlength="21" value=<%=strSunday%> > <!-- <img align="absmiddle" style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.EndDate', '2007', '2017')"></td> -->
    </tr>
    <tr>
	  <td class=title>ҵ����Դ:</td>
      <td class="input">
        <select class=tag  name="CurBusinessNatureSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="BusinessNature" class="query"   maxlength="22"></td>
      <td class=title>�ұ�:</td>
      <td class=input>
        <select class=tag  name="CurrencySign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="Currency" class="query"   maxlength="3"></td>
    </tr>
<!--
      <td class=title>�ܱ��ս��:</td>
      <td class=input>
        <select class=tag name="SumAmountSign">
                    <jsp://include page="/common/pub/UINumOption.html" />
        </select><input name="SumAmount" class="common" onkeypress="return pressDecimal(event)"></td>
    </tr>
    <tr>
      <td class=title>�ܱ��շ�:</td>
      <td class=input>
        <select class=tag name="SumPremiumSign">
                    <jsp://include page="/common/pub/UINumOption.html" />
        </select><input name="SumPremium" class="common" onkeypress="return pressDecimal(event)"></td>
-->
    <tr>
      <td class=title>��������:</td>
      <td class=input>
        <select class=tag  name="MakeComSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="MakeCom" class="query"   maxlength="8"></td>
      <td class=title>��������:</td>
      <td class=input>
        <select class=tag  name="ComCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="ComCode" class="query"   maxlength="8"></td>
    </tr>
    <tr>
		<td class=title>ҵ��Ա����:</td>
      <td class=input>
        <select class=tag   name="Handler1CodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="Handler1Code" class="query"   maxlength="10"></td>
	  <td class=title>�����˴���:</td>
      <td class=input>
        <select class=tag  name="HandlerCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="HandlerCode" class="query"   maxlength="10"></td>
    </tr>
    <tr>
      <td class=title>����Ա����:</td>
      <td class=input>
        <select class=tag  name="OperatorCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="OperatorCode" class="query"   maxlength="10"></td>
<!--
    <tr>
      <td class=title>ǩ������:</td>
      <td class=input>
        <select class=tag name="OperateDateSign">
          <jsp://include page="/common/pub/UIDateOption.html" />
        </select><input name="OperateDate" class="common" maxlength="21" onkeypress="return pressDatetime(event)" onblur="checkBetweenDate(this,'YEAR','DAY');"></td>
      <td class=title>������䵥����:</td>
      <td class=input>
        <select class=tag name="InputDateSign">
                    <jsp://include page="/common/pub/UIDateOption.html" />
        </select><input name="InputDate" class="common" maxlength="21" onkeypress="return pressDatetime(event)" onblur="checkBetweenDate(this,'YEAR','DAY');"></td>
    </tr>
-->
	  <td class=title>�����˴���:</td>
      <td class=input>
        <select class=tag  name="AgentCodeSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input name="AgentCode" class="query"   maxlength="12"></td>
<!--
      <td class=title>�±�/����:</td>
      <td class=input>
        <input type="checkbox" name="OthFlag1" value="0">�±�
        <input type="checkbox" name="OthFlag1" value="1">����
      </td>
-->
    </tr>
</table>
<table width=100%>
    <tr>
      <td colspan=2 class=button>
        <input type="button" name="buttonSubmit" class="button" value=" �� ѯ " onclick="submitForm()">
      </td>
      <td colspan=2 class=button>
        <input type="button" name="buttonCancel" class="button" value=" �� �� " onclick="resetForm()">
      </td>
    </tr>

    </table>
    <input type="hidden" name="editType" value="EDIT">
    <input type="hidden" name="conditions" value="">

  </form>
</body>
</html:html>