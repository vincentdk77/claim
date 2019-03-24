<%--
****************************************************************************
* DESC       ：调度查勘内容(sched)
* AUTHOR     ：
* CREATEDATE ：2004-08-04
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>

<html:html locale="true">

<head>
    <app:css />
    <STYLE>BODY {
	       SCROLLBAR-FACE-COLOR:#EFFAFF;
	       SCROLLBAR-HIGHLIGHT-COLOR:#4D9AC4;
	       SCROLLBAR-SHADOW-COLOR:#4D9AC4;
	       SCROLLBAR-3DLIGHT-COLOR:#EFFAFF;
	       SCROLLBAR-ARROW-COLOR:#EFFAFF;
	       SCROLLBAR-TRACK-COLOR:#EFFAFF;
	       SCROLLBAR-DARKSHADOW-COLOR:#EFFAFF;
	      }
      </STYLE>  
  <title>
    调度任务清单
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <script type="text/javascript">
  function sendMessage(registNo){
  	var linkURL = "/claim/common/schedule/ScheduleSendMessage.jsp?registNo="+registNo;
	window.showModalDialog(linkURL,"NewWindow","scroll=0;status=0;dialogWidth=500px;dialogHeight=300px;dialogTop=387px;dialogLeft=390px");
  }
  
  </script>
  
  <html:base/>
</head>

<body >

<form name="fm" action="/claim/scheduleCheckQuery.do"  method="post"> 
  
 <table  class="common" cellpadding="5" cellspacing="1" >
 <tr>

           <td colspan="9" class="formtitle">调度查勘任务清单</td>

          </tr>
     <tr>
     <td class="centertitle"  style="width:9%">状态</td>
        <td class="centertitle" style="width:17%">报案号</td>
        <td class="centertitle" style="width:10%">调度信息</td>
        <td class="centertitle" style="width:11%">调度时间</td>
        <td class="centertitle" style="width:10%">调度操作员</td>
        <td class="centertitle" style="width:10%">查勘操作员</td>
        <td class="centertitle" style="width:6%">发送短信</td>
     </tr>

  <%int index=0;%>
     <logic:notEmpty  name="prpLscheduleMainWFDto"  property="scheduleList" > 
     <logic:iterate id="prpLcheckTaskList"  name="prpLscheduleMainWFDto"  property="scheduleList">  
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else 
               out.print("<tr class=listeven>");
%>

        <td align="center">
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='0' >
         新调度
        </logic:equal>
     
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='4' >
         已提交
        </logic:equal>
               
        </td>
        <%// 报案受理号 %>
         <td > 
        <a href="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='registNo'/>&riskCode=<bean:write name='prpLcheckTaskList' property='riskCode'/>&editType=SHOW&prpLscheduleMainWFScheduleID=1&scheduleType=schel"> <bean:write name="prpLcheckTaskList" property="registNo"/>
        </a></td>       
        <td ><bean:write name="prpLcheckTaskList" property="checkInfo"/></td>        <%// 金银牌客户标志   %>
        <td ><bean:write name="prpLcheckTaskList" property="inputDate"/></td>         <%// 是否被调度使用   %>      
        <td ><bean:write name="prpLcheckTaskList" property="operatorName"/></td>            <%// 预约查勘(定损)   %>
        <td ><bean:write name="prpLcheckTaskList" property="nextHandlerName"/></td>            <%// 承保险类 (DAA)   %>
    	<td ><a href="javascript:;" onclick="sendMessage('${prpLcheckTaskList.registNo }');">发送</a></td>
       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      
      <tr class="listtail">
	      <td colspan="15">
	      
	       <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>  
                  <bean:define id="pageview" name="prpLscheduleMainWFDto" property="turnPageDto"/>  
<%
  PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)request.getAttribute("prpLscheduleMainWFDto"); 
  int curPage = prpLscheduleMainWFDto.getTurnPageDto().getPageNo(); 
%>                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
          
	      </td>
      </tr>
    </table> 
  </tr>
    <input type="hidden" name="editType" value="QUERY"> 
    <input type="hidden" name="scheduleType" value="sched">   
    
  <table class="common" cellpadding="4" cellspacing="20"> 
    <tr>
    </tr>
    <tr>
    
    </tr>
  <table>
    
  </table>
</form>
</body>
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>