<%--
****************************************************************************
* DESC       �����Ȳ鿱����(sched)
* AUTHOR     ��
* CREATEDATE ��2004-08-04
* MODIFYLIST ��   id       Date            Reason/Contents
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
    ���������嵥
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

           <td colspan="9" class="formtitle">���Ȳ鿱�����嵥</td>

          </tr>
     <tr>
     <td class="centertitle"  style="width:9%">״̬</td>
        <td class="centertitle" style="width:17%">������</td>
        <td class="centertitle" style="width:10%">������Ϣ</td>
        <td class="centertitle" style="width:11%">����ʱ��</td>
        <td class="centertitle" style="width:10%">���Ȳ���Ա</td>
        <td class="centertitle" style="width:10%">�鿱����Ա</td>
        <td class="centertitle" style="width:6%">���Ͷ���</td>
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
         �µ���
        </logic:equal>
     
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='4' >
         ���ύ
        </logic:equal>
               
        </td>
        <%// ��������� %>
         <td > 
        <a href="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='registNo'/>&riskCode=<bean:write name='prpLcheckTaskList' property='riskCode'/>&editType=SHOW&prpLscheduleMainWFScheduleID=1&scheduleType=schel"> <bean:write name="prpLcheckTaskList" property="registNo"/>
        </a></td>       
        <td ><bean:write name="prpLcheckTaskList" property="checkInfo"/></td>        <%// �����ƿͻ���־   %>
        <td ><bean:write name="prpLcheckTaskList" property="inputDate"/></td>         <%// �Ƿ񱻵���ʹ��   %>      
        <td ><bean:write name="prpLcheckTaskList" property="operatorName"/></td>            <%// ԤԼ�鿱(����)   %>
        <td ><bean:write name="prpLcheckTaskList" property="nextHandlerName"/></td>            <%// �б����� (DAA)   %>
    	<td ><a href="javascript:;" onclick="sendMessage('${prpLcheckTaskList.registNo }');">����</a></td>
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