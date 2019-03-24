<%--
****************************************************************************
* DESC       ：定损结果
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-13
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<!--- add by zhaolu 20060803 start --->
<%@ page import="com.sinosoft.claim.dto.domain.PrpLverifyLossDto" %>
<!--- add by zhaolu 20060803 end --->
<html:html locale="true">
<head>
    <app:css />

  <title>
  <bean:message key="title.claimBeforeEdit.queryClaim"/>
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body  >
<!--- add by zhaolu 20060803 start --->
<form name="fm" action="/claim/certainLossQuery.do"  method="post">
 <!--- add by zhaolu 20060803 end --->
<table  class="common" cellpadding="5" cellspacing="1" >
<tr> <td colspan=7 class="formtitle">查询定损信息</td></tr>
   <tr>
      <td class="centertitle" >序号</td>
      <td class="centertitle" >案件状态</td>
      <td class="centertitle" >报案号</td>
      <td class="centertitle" >损失标的名称</td>
      <td class="centertitle" ><bean:message key="db.prpLclaim.policyNo"/></td>
      <td class="centertitle" >定损人代码</td>
      <td class="centertitle" >定损/代定损日期</td>
   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLverifyLossDto"  property="verifyLossList">
   <logic:iterate id="prpLverifyLoss1"  name="prpLverifyLossDto"  property="verifyLossList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");

%>
<tr class=common>
       <td align="center"><%=index+1%> </td>
       <td align="center">
        <logic:equal name="prpLverifyLoss1" property="status" value='0' >
         未处理
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='2' >
         正处理
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='3' >
         回退并处理
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='4' >
         已提交
        </logic:equal>
        <logic:equal name="prpLverifyLoss1" property="status" value='5' >
         已撤消
        </logic:equal>
      </td>
<%
	String nodeType = request.getParameter("nodeType");
	if("veriw".equals(nodeType)){
%>
      <td align="center"> <a href="/claim/verifyLossFinishQueryList.do?prpLverifyLossRegistNo=<bean:write name='prpLverifyLoss1' property='registNo'/>&nodeType=<%=nodeType %>&editType=<bean:write name='prpLverifyLossDto' property='editType'/>&riskCode=<bean:write name='prpLverifyLoss1' property='riskCode'/>&lossItemCode=<bean:write name='prpLverifyLoss1' property='lossItemCode'/>&lossItemName=<bean:write name='prpLverifyLoss1' property='lossItemName'/>"> <bean:write name="prpLverifyLoss1" property="registNo"/></a></td>
<%
	}else{
%>
      <td align="center"> <a href="/claim/certainLossFinishQueryList.do?prpLverifyLossRegistNo=<bean:write name='prpLverifyLoss1' property='registNo'/>&editType=<bean:write name='prpLverifyLossDto' property='editType'/>&riskCode=<bean:write name='prpLverifyLoss1' property='riskCode'/>&lossItemCode=<bean:write name='prpLverifyLoss1' property='lossItemCode'/>&lossItemName=<bean:write name='prpLverifyLoss1' property='lossItemName'/>"> <bean:write name="prpLverifyLoss1" property="registNo"/></a></td>
<%	} %>
     <td align="center">
     <%//Modify by caopeng add begin 20051216 Reason:使查询时损失标的名称值不会重复%>
     <logic:notEqual name="prpLverifyLoss1" property="lossItemCode" value='0' >
        <logic:notEqual name="prpLverifyLoss1" property="lossItemCode" value='-1' >
     <!--   <bean:write name="prpLverifyLoss1" property="lossItemCode"/>&nbsp;  -->
        </logic:notEqual>
     </logic:notEqual>
     <%//Modify by caopeng add end 20051216 Reason:使查询时损失标的名称值不会重复%>
     <bean:write name="prpLverifyLoss1" property="lossItemName"/>
     </td>
      <td align="center">
	  <!--add by zhouliu start at 2006-6-9
		  reason:强三查询
	   -->
      		<logic:iterate id="currelatepolicyNo"  name="prpLverifyLoss1"  property="relatepolicyNo">
        		<bean:write name="currelatepolicyNo"/><br>
        	</logic:iterate>
      <!--add by zhouliu end at 2006-6-9-->
      </td>
      <td align="center"><bean:write name="prpLverifyLoss1" property="handlerName"/></td>
      <td align="center"><bean:write name="prpLverifyLoss1" property="defLossDate"/></td>
    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr class="listtail">
	      <td colspan="7">
	      <!--- add by zhaolu 20060803 start--->
	       <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpLverifyLossDto" property="turnPageDto"/>  
<% 
          PrpLverifyLossDto prpLverifyLossDto = (PrpLverifyLossDto)request.getAttribute("prpLverifyLossDto"); 
            int curPage = prpLverifyLossDto.getTurnPageDto().getPageNo(); 
%>                   
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
          <!--- add by zhaolu 20060803 start--->
	      </td>
      </tr>
  </table>
  </tr>
</table>
<!--- add by zhaolu 20060803 start --->
<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
<input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
</form>
<!--- add by zhaolu 20060803 end --->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>