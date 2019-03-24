<%--
****************************************************************************
* DESC       ��������������ҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE ��2005-09-06
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
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/claim/js/DAAClaimEdit.js"></script>
</head>

<body class=interface onload="initPage();">
<form name=fm action="/claim/notGrandClaim.do" method="post" 
  onsubmit="if(document.fm.temp.value==0) return false;else document.fm.temp.value=0;" >
      <INPUT type=hidden value="1"  name="temp">
      <table  cellpadding="5" cellspacing="1" class=common>
         <tr class=listtitle>
            <td  colspan="4">�⽡�ղ�����������
                <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
                <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
           </td>

         </tr>

         <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" colspan=3>
               <input type="text" name="prpLclaimRegistNo" class="readonly"  title="������" maxlength="22"  readonly="true"  value="<bean:write name='prpLregistDto' property='registNo' filter='true' />">
            </td>
         </tr>

          <tr>
            <td class="title" >��������:</td>
            <td class="input">
               <input type=text name="prpLclaimInsuredName" title="��������" class="readonly" value="<bean:write name='prpLregistDto' property='insuredName' filter='true' />">

            </td>

            <td class="title" >�����ţ�
            </td>
            <td class="input">
                <input type=text name="prpLclaimPolicyNo" title="������" class="readonly"  value="<bean:write name='prpLregistDto' property='policyNo' filter='true' />">
            </td>
         </tr>

          <tr>
            <td class="title" >����ʱ��:</td>
            <td class="input">
               <input type=text name="prpLclaimDealerName" title="����ʱ��" class="readonly" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />">

            </td>

            <td class="title" >���յص㣺
            </td>
            <td class="input">
                <input type=text name="prpLclaimDamageAddress" title="���յص�" class="readonly"  value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">

            </td>
         </tr>




          <tr>
            <td class="title" >������:</td>
            <td class="input">
               <input type="hidden" name="prpLclaimDealerCode" title="ע���ⰸ������" class="readonly" value="<bean:write name='prpLregistDto' property='dealerCode' filter='true' />">
               <input type=text name="prpLclaimDealerName" title="ע���ⰸ������" class="readonly" value="<bean:write name='prpLregistDto' property='comName' filter='true' />">

            </td>

            <td class="title" >����ʱ�䣺
            </td>
            <td class="input">
                <input type=text name="prpLclaimCancelDate" title="����ʱ��" class="readonly"  value="<bean:write name='prpLregistDto' property='cancelDate' filter='true' />">

            </td>
         </tr>

         <tr>
             <td class="title" colspan="4">
              ��������ԭ��
             </td>
         </tr>
         <tr>
           <td class="input" colspan="4" align="center">
             <textarea name='prpLclaimContext' wrap="hard" rows=15 cols=80 class=common ></textarea>
             <input type="button" name="btnRegistText" class=bigbutton value="���ɲ��������ı�" onclick="return generateNoClaimText();">
           </td>
         </tr>
     </table>

     <table class="common" align="center">
        <tr >
      	   <td class=button  align="center">
              <!--ȷ ����ť-->
              <input type=submit name=buttonSave class='button' value="<bean:message key='button.submit.value' />">
           </td>
           
	       <td class=button  align="center">
	          <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
              <input type=hidden name="editType" title="��������" class="readonly" value="<bean:write name='prpLregistDto' property='editType' filter='true' />">
              <input type=hidden name="nodeType" title="�ڵ�����" class="readonly" value="<%=request.getParameter("nodeType")%>">
              <input type=hidden name="businessNo" title="ҵ�����" class="readonly" value="<%=request.getParameter("bussinessNo")%>">
              <input type=hidden name="riskCode" title="ҵ�����" class="readonly" value="<%=request.getParameter("riskCode")%>">
              <input type=hidden name="prpLcancelclaimPrintFlag" title="ҵ�����" class="readonly" value='0'>
          </td>
	</tr>
     </table>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>