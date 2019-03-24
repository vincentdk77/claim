<%--
****************************************************************************
* DESC       ：查勘结果
* AUTHOR     ：liubvo
* CREATEDATE ：2004-06-07
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<!--- add by zhaolu 20060802 start --->
<%@ page import="com.sinosoft.claim.dto.domain.PrpLcheckDto" %>
<!--- add by zhaolu 20060802 end --->
<%@page import="java.util.ArrayList"%>
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
<!--- add by zhaolu 20060802 start--->
<form name="fm" action="/claim/checkQuery.do"  method="post">
<!--- add by zhaolu 20060802 end--->
<table  class="common" cellpadding="5" cellspacing="1" >
<tr>  <td colspan=6 class="formtitle">查询查勘信息</td></tr>
   <tr>
      <td class="centertitle" >选择</td>
      <td class="centertitle" >案件状态</td>
      <td class="centertitle" >报案号</td>
      <td class="centertitle" ><bean:message key="db.prpLclaim.policyNo"/></td>
      <td class="centertitle" >查勘人</td>
      <td class="centertitle" >操作时间</td>
   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLcheckDto"  property="checkList">
   <logic:iterate id="prpLcheck1"  name="prpLcheckDto"  property="checkList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");


%>
     <tr class=common> 
    <td align="center">
    <% 
    String classcode = ((PrpLcheckDto)prpLcheck1).getRiskCode().substring(0,2);
    if("05".equals(classcode)){
    %>
      <input type="checkbox" name="check"  onClick="setCheckFlag(<%=index%>);">
    <%	
    }else{
    %>
     <input type="checkbox" name="check"    onClick="setCheckFlag(<%=index%>);" disabled>
     <%	
    }
    %>
    
    
                       <input type="hidden" name="CheckFlag" value="N">
                       <input type="hidden" name="RegistNo" value="<bean:write name='prpLcheck1' property='registNo'/>">    
    </td>
    <td align="center">
        <logic:equal name="prpLcheck1" property="status" value='1' >
         未处理
        </logic:equal>
        <logic:equal name="prpLcheck1" property="status" value='2' >
         正处理
        </logic:equal>
        <logic:equal name="prpLcheck1" property="status" value='3' >
         已处理
        </logic:equal>
        <logic:equal name="prpLcheck1" property="status" value='4' >
         已提交
        </logic:equal>
        <logic:equal name="prpLcheck1" property="status" value='5' >
         已撤消
        </logic:equal>
      </td>
      <td align="center"> <a href="/claim/checkFinishQueryList.do?prpLcheckCheckNo=<bean:write name='prpLcheck1' property='registNo'/>&editType=<bean:write name='prpLcheckDto' property='editType'/>&riskCode=<bean:write name="prpLcheck1" property="riskCode"/>"><bean:write name="prpLcheck1" property="registNo"/></a></td>
      <td align="center">
	  <!--
		add by zhouliu start at 2006-6-9
		reason:强三查询
	  -->
      		<logic:iterate id="currelatepolicyNo" name="prpLcheck1" property="relatepolicyNo">
      			<bean:write name="currelatepolicyNo"/><br>
      		</logic:iterate>
      <!--add by zhouliu end at 2006-6-9-->
      </td>
      <td align="center"><bean:write name="prpLcheck1" property="checker1"/></td>
      <td align="center"><bean:write name="prpLcheck1" property="operateDate"/></td>
    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr align="center" class="listtail">
        <td colspan="5">
         <input class="button" type="button" name= "deleteButton" alt="退回" value="退 回" onclick="deleteLS()">
         <input class="button" type="button" alt=" 返回 " value="返 回" onclick="history.back()">
        <!--- add by zhaolu 20060802 start --->
        <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpLcheckDto" property="turnPageDto"/>  
<% 
  PrpLcheckDto prpLcheckDto = (PrpLcheckDto)request.getAttribute("prpLcheckDto"); 
  int curPage = prpLcheckDto.getTurnPageDto().getPageNo(); 
%>                   
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
			 
          </table>
          <!--- add by zhaolu 20060802 start --->
        </td>
      </tr>
  </table>
  </tr>
</table>
<!---add by zhaolu 20060802 start --->
<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
<input type="hidden" name="nodeType" value="<%=request.getParameter("nodeType")%>">
<input type="hidden" name="deleteFlag" value="0">
</form>
    <div id="doing" style="position:absolute; top:295px; left:8px; visibility:hidden; z-index:0; width: 772px; height: 40px;"> 
        <TABLE WIDTH=100% BORDER=0 CELLSPACING=0 CELLPADDING=0>

            <TR>
                <td width=30%></td>

                <TD bgcolor=#2D8EE1>

                    <TABLE WIDTH=100% height=40 BORDER=0 CELLSPACING=2 CELLPADDING=0>

                        <TR>

                            <td bgcolor=#eeeeee align=center>正在执行操作, 请稍候...</td>

                        </tr>

                    </table>
                </td>
                <td width=30%></td>
           </tr>
        </table>

    </div>
<!---add by zhaolu 20060802 end --->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>