<%--
****************************************************************************
* DESC       ���������Ƿ�ͨ�������ѯ
* AUTHOR     ��liubvo
* CREATEDATE ��2004-05-19
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>

<html:html locale="true">
<head>
    <app:css />

  <title><bean:message key="title.claimBeforeEdit.queryClaim"/></title>
  <script src="/claim/common/js/showpage.js"> </script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <script language="javascript">
  <%--����״̬��־����--%>
  <!--
  function submitForm()
  {
    var ref2="";

    for(i=0;i<fm.UnderWriteFlag.length;i++){
      if(fm.UnderWriteFlag[i].checked==true){
        ref2 = ref2+fm.UnderWriteFlag[i].value+",";
      }
    }
    fm.compensateFlag.value = ref2;
    fm.searchFlag.value="true";
    fm.submit();//�ύ
  }
  //-->
  </script>
  <html:base/>
</head>

<body  >
<form name="fm" action="/claim/compensatePassQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=4 class="formtitle">��ѯ������Ϣ</td></tr>
      <tr>
        <td class='title'>��������ţ�</td>
        <td class='input'>
          <select class=tag name="CompensateNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="CompensateNo" class="query">
        </td>
        <td class='title'>�����ţ�</td>
        <td class='input'>
          <select class=tag name="ClaimNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query">
        </td>

      </tr>
      <tr>
        <td class='title'>�����ţ�</td>
        <td class='input'>
          <select class=tag name="PolicyNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query">
        </td>
        <td class='title'>����ʱ�䣺</td>
        <td class='input'>
          <select class=tag name="OperateDateSign">
	          <option value="=">=&nbsp;</option>
	          <option value=">">&gt;&nbsp;</option>
	          <option value="<">&lt;&nbsp;</option>
	          <option value=">=">&gt;=</option>
	          <option value="<=">&lt;=</option>
          </select> <input type=text name="OperateDate" class="Wdate" onfocus="WdatePicker()"> <!-- <img style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDate', '2007', '2017')"> -->
        </td>
      </tr>
      <tr>
        <td class='title'>�����־��</td>
        <td  class='input' >
          <input type="hidden" name="compensateFlag">
          <input type="checkbox" name="UnderWriteFlag" value="0">��ʼֵ
          <input type="checkbox" name="UnderWriteFlag" value="1">ͨ��
          <input type="checkbox" name="UnderWriteFlag" value="2">��ͨ��
          <input type="checkbox" name="UnderWriteFlag" value="3">�������
          <input type="checkbox" name="UnderWriteFlag" value="9">������
        </td>
        <td colspan="2"></td>
      </tr>
      <tr>  <td class='button'  colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
        </tr>
    </table>



  <table  class="common" cellpadding="5" cellspacing="1">
     <tr>
        <td class="centertitle" >���������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >������</td>
        <td class="centertitle" >���⸶���(��CNY)</td>
        <td class="centertitle" >״̬</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="prpLcompensateDto"  property="compensateList">
     <logic:iterate id="prpLcompensate1"  name="prpLcompensateDto"  property="compensateList">
<%
          if(index % 2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
       <tr class=common> <td><a href="/claim/compensateFinishQueryList.do?prpLcompensateCompensateNo=<bean:write name='prpLcompensate1' property='compensateNo'/>&editType=<bean:write name='prpLcompensateDto' property='editType'/>"> <bean:write name="prpLcompensate1" property="compensateNo"/></a></td>
        <td><bean:write name="prpLcompensate1" property="claimNo"/></td>
        <td><bean:write name="prpLcompensate1" property="policyNo"/></td>
        <td><bean:write name="prpLcompensate1" property="sumPaid"/></td>
        <td>
          <logic:equal name="prpLcompensate1" property="underWriteFlag" value="0">��ʼֵ</logic:equal>
          <logic:equal name="prpLcompensate1" property="underWriteFlag" value="1">ͨ��</logic:equal>
          <logic:equal name="prpLcompensate1" property="underWriteFlag" value="2">��ͨ��</logic:equal>
          <logic:equal name="prpLcompensate1" property="underWriteFlag" value="3">�������</logic:equal>
          <logic:equal name="prpLcompensate1" property="underWriteFlag" value="9">������</logic:equal>
        </td>
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>



      <tr class="listtail">
        <td colspan="7">
          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>
                  <bean:define id="pageview" name="prpLcompensateDto" property="turnPageDto"/>
<%
  PrpLcompensateDto prpLcompensateDto = (PrpLcompensateDto)request.getAttribute("prpLcompensateDto");
  int curPage = prpLcompensateDto.getTurnPageDto().getPageNo();
%>
                  <%@include file="/common/pub/TurnOverPage.jsp" %>
              </tr>
          </table>
        </td>
      </tr>



    </table>
    </tr>
  </table>
  <input type="hidden" name="searchFlag"  value="">
    <input type="hidden" name="editType" value="SHOW">
  </form>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>