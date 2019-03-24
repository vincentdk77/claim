<%--
****************************************************************************
* DESC       ：单证结果
* AUTHOR     ：liubvo
* CREATEDATE ：2004-07-05
* MODIFYLIST ：   id  Sunhao     Date   2004-08-24         Reason/Contents
             1.在结果中增加案件状态
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<!--- add by zhaolu 20060803 start  --->
<%@ page import="com.sinosoft.claim.dto.domain.PrpLcertifyCollectDto" %>
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
<form name="fm" action="/claim/certifyQuery.do"  method="post"> 
<!--- add by zhaolu 20060803 end --->
<table class="common" cellpadding="5" cellspacing="1" >
<tr><td colspan=6 class="formtitle">查询单证收集信息</td></tr>
   <tr>
      <td class="centertitle" >案件状态</td>
      <td class="centertitle" >报案号码</td>
      <td class="centertitle" >开始收集日期</td>
      <td class="centertitle" >操作员</td>
      <td class="centertitle" >操作时间</td>
      <td class="centertitle" >收集标志</td>
   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLcertifyCollectDto"  property="certifyCollectList">
   <logic:iterate id="prpLcertify1"  name="prpLcertifyCollectDto"  property="certifyCollectList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>

       <td align="center">
        <logic:equal name="prpLcertify1" property="status" value='1' >
         未处理
        </logic:equal>
        <logic:equal name="prpLcertify1" property="status" value='2' >
         正处理
        </logic:equal>
        <logic:equal name="prpLcertify1" property="status" value='3' >
         已处理
        </logic:equal>
        <logic:equal name="prpLcertify1" property="status" value='4' >
         已提交
        </logic:equal>
        <logic:equal name="prpLcertify1" property="status" value='5' >
         已撤消
        </logic:equal>
      </td>
      <td align="center"> <a href="/claim/certifyFinishQueryList.do?prpLcertifyCertifyNo=<bean:write name='prpLcertify1' property='businessNo'/>&nodeType=certi&editType=<bean:write name='prpLcertifyCollectDto' property='editType'/>&riskCode=<bean:write name="prpLcertify1" property="riskCode"/>"> <bean:write name="prpLcertify1" property="businessNo"/></a></td>
      <td align="center"><bean:write name="prpLcertify1" property="startDate"/></td>
      <td align="center"><bean:write name="prpLcertify1" property="operatorCode"/></td>
      <td align="center"><bean:write name="prpLcertify1" property="operateDate"/></td>
      <td align="center"><bean:write name="prpLcertify1" property="collectFlag"/></td>
    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr class="listtail">
        <td colspan="6">
        <!--- add by zhaolu 20060803 start --->
          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>   
                  <bean:define id="pageview" name="prpLcertifyCollectDto" property="turnPageDto"/>  
<% 
  PrpLcertifyCollectDto prpLcertifyCollectDto = (PrpLcertifyCollectDto)request.getAttribute("prpLcertifyCollectDto"); 
  int curPage = prpLcertifyCollectDto.getTurnPageDto().getPageNo(); 
%>                   
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
          <!--- add by zhaolu 20060803 end --->
        </td>
      </tr>
  </table>
  </tr>
</table>
<!--- add by zhaolu 20060803 start--->
<input type="hidden" name="editType" value="<%=request.getParameter("editType")%>">
</form>
<!--- add by zhaolu 20060803 end--->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>