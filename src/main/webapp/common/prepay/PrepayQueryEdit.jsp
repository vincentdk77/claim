<%--
****************************************************************************
* DESC       ��Ԥ���ѯ�����������
* AUTHOR     �� liubvo
* CREATEDATE �� 2004-06-07
* MODIFYLIST ��   Name       Date            Reason/Contents
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
  <title><bean:message key="title.registBeforeEdit.titleName" /></title>
  <%-- ���ú��� --%>
  <script src="/claim/common/js/Common.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script language="javascript">
<%--����״̬��־����--%>
<!--

  function submitForm()
  {
    var ref1="";
    var ref2="";
    for(i=0;i<fm.status.length;i++){

      if(fm.status[i].checked==true){
        ref1 = ref1+fm.status[i].value+",";
      }
    }

	for(i=0;i<fm.UnderWriteFlag.length;i++){

	  if(fm.UnderWriteFlag[i].checked==true){
	    ref2 = ref2+fm.UnderWriteFlag[i].value+",";
	  }
	}
    fm.caseFlag.value = ref1;
    fm.prepayFlag.value = ref2;
    fm.submit();//�ύ
  }
//-->
</script>
</head>

<body onload="initPage();">
<form name="fm" action="/claim/prepayQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=4 class="formtitle">��ѯԤ����Ϣ</td></tr>
      <tr>
        <td class='title' >Ԥ��ǼǺţ�</td>
        <td class='input' >
          <select class=tag name="PrepayNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PrepayNo" class="query" >
        </td>
        <td class='title' >�����ţ�</td>
        <td class='input' >
          <select class=tag name="ClaimNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query" >
        </td>

      </tr>
      <tr>
        <td class='title' >�����ţ�</td>
        <td class='input' >
          <select class=tag name="PolicyNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query" >
        </td>
        <td class='title' >����ʱ�䣺</td>
        <td class='input' >
          <select class=tag name="OperateDateSign" >
	          <option value="=">=&nbsp;</option>
	          <option value=">">&gt;&nbsp;</option>
	          <option value="<">&lt;&nbsp;</option>
	          <option value=">=">&gt;=</option>
	          <option value="<=">&lt;=</option>
          </select> <input type=text name="OperateDate" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDate', '2007', '2017')"> -->
        </td>
      </tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />:</td>
        <td class='input'  >
        <select class=tag name="LicenseNoSign" >
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="LicenseNo" class="query" >
        </td>
        <td class='title' style="width:30%" colspan="2">
      </tr>
      <tr>
        <td class='title' >�����־:</td>
        <td colspan="3" class='input'>
          <input type="hidden" name="prepayFlag">
          <input type="checkbox" name="UnderWriteFlag" value="0">��ʼֵ
          <input type="checkbox" name="UnderWriteFlag" value="1">ͨ��
          <input type="checkbox" name="UnderWriteFlag" value="2">��ͨ��
          <input type="checkbox" name="UnderWriteFlag" value="3">�������
          <input type="checkbox" name="UnderWriteFlag" value="9">������
        </td>
      </tr>
      <tr>
        <td class='title' >����״̬:</td>
         <td colspan="3" class='input' >
         <input type="hidden" name="caseFlag" >
         <input type="checkbox" name="status" value="1">δ����
         <input type="checkbox" name="status" value="2">������
         <input type="checkbox" name="status" value="3">�Ѵ���
         <input type="checkbox" name="status" value="4">���ύ
         <input type="checkbox" name="status" value="5">�ѳ���
         </td>
      </tr>
      <tr>
         <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
      </tr>
    </table>
    <input type="hidden" name="editType" value="SHOW">
  </form>
</body>
</html:html>



