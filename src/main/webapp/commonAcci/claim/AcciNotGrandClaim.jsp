<%--
****************************************************************************
* DESC       ：不予立案处理页面
* AUTHOR     ： 项目组
* CREATEDATE ：2005-09-06
* MODIFYLIST ：   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>

<html:html locale="true">
<head>
  <!--对title处理-->
  <app:css />
  <%-- 页面样式  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/claim/js/DAAClaimEdit.js"></script>
</head>

<body class=interface onload="initPage();">
<form name=fm action="/claim/notGrandClaim.do" method="post" 
  onsubmit="if(document.fm.temp.value==0) return false;else document.fm.temp.value=0;" >
      <INPUT type=hidden value="1"  name="temp">
      <table  cellpadding="5" cellspacing="1" class=common>
         <tr class=listtitle>
            <td  colspan="4">意健险不予立案处理
                <input type="hidden" name="swfLogFlowID" class="common" value="<%=request.getParameter("swfLogFlowID")%>">
                <input type="hidden" name="swfLogLogNo" class="common" value="<%=request.getParameter("swfLogLogNo")%>">
           </td>

         </tr>

         <tr>
            <td class="title" style="width:15%;valign:bottom"><bean:message key="db.prpLclaim.registNo" />:</td>
            <td class="input" style="width:35%;valign:bottom" colspan=3>
               <input type="text" name="prpLclaimRegistNo" class="readonly"  title="报案号" maxlength="22"  readonly="true"  value="<bean:write name='prpLregistDto' property='registNo' filter='true' />">
            </td>
         </tr>

          <tr>
            <td class="title" >被保险人:</td>
            <td class="input">
               <input type=text name="prpLclaimInsuredName" title="被保险人" class="readonly" value="<bean:write name='prpLregistDto' property='insuredName' filter='true' />">

            </td>

            <td class="title" >保单号：
            </td>
            <td class="input">
                <input type=text name="prpLclaimPolicyNo" title="保单号" class="readonly"  value="<bean:write name='prpLregistDto' property='policyNo' filter='true' />">
            </td>
         </tr>

          <tr>
            <td class="title" >出险时间:</td>
            <td class="input">
               <input type=text name="prpLclaimDealerName" title="出险时间" class="readonly" value="<bean:write name='prpLregistDto' property='damageStartDate' filter='true' />">

            </td>

            <td class="title" >出险地点：
            </td>
            <td class="input">
                <input type=text name="prpLclaimDamageAddress" title="出险地点" class="readonly"  value="<bean:write name='prpLregistDto' property='damageAddress' filter='true' />">

            </td>
         </tr>




          <tr>
            <td class="title" >申请人:</td>
            <td class="input">
               <input type="hidden" name="prpLclaimDealerCode" title="注销赔案申请人" class="readonly" value="<bean:write name='prpLregistDto' property='dealerCode' filter='true' />">
               <input type=text name="prpLclaimDealerName" title="注销赔案申请人" class="readonly" value="<bean:write name='prpLregistDto' property='comName' filter='true' />">

            </td>

            <td class="title" >申请时间：
            </td>
            <td class="input">
                <input type=text name="prpLclaimCancelDate" title="申请时间" class="readonly"  value="<bean:write name='prpLregistDto' property='cancelDate' filter='true' />">

            </td>
         </tr>

         <tr>
             <td class="title" colspan="4">
              不予立案原因：
             </td>
         </tr>
         <tr>
           <td class="input" colspan="4" align="center">
             <textarea name='prpLclaimContext' wrap="hard" rows=15 cols=80 class=common ></textarea>
             <input type="button" name="btnRegistText" class=bigbutton value="生成不予立案文本" onclick="return generateNoClaimText();">
           </td>
         </tr>
     </table>

     <table class="common" align="center">
        <tr >
      	   <td class=button  align="center">
              <!--确 定按钮-->
              <input type=submit name=buttonSave class='button' value="<bean:message key='button.submit.value' />">
           </td>
           
	       <td class=button  align="center">
	          <input type=button name=buttonCancel class='button' value="<bean:message key='button.cancel.value' />" onclick="return resetForm();" >
              <input type=hidden name="editType" title="操作类型" class="readonly" value="<bean:write name='prpLregistDto' property='editType' filter='true' />">
              <input type=hidden name="nodeType" title="节点类型" class="readonly" value="<%=request.getParameter("nodeType")%>">
              <input type=hidden name="businessNo" title="业务号码" class="readonly" value="<%=request.getParameter("bussinessNo")%>">
              <input type=hidden name="riskCode" title="业务号码" class="readonly" value="<%=request.getParameter("riskCode")%>">
              <input type=hidden name="prpLcancelclaimPrintFlag" title="业务号码" class="readonly" value='0'>
          </td>
	</tr>
     </table>
  </form>
</body>

<!--这个函数是调动所能用到的通用js的过程，一般包括最常用的js的函数声明都在StaticJavacript中-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>