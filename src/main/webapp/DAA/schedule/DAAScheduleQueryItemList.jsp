<%--
****************************************************************************
* DESC       ：调度定损查询内容(schel)
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
 
  </script>
  
  <html:base/>
</head>

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<form name="fm" >
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common" style="width:100%">
    <tr> 
      <td width="184" height="26" valign="bottom"> 
        <table width="184" height="19" border="0" cellpadding="0" cellspacing="0" >
          <tr> 
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="161" class="formtitle">
              <!-- 显示需要调度的内容 -->
              调度定损任务清单
              </td>
            <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            
          </tr>
        </table>
      </td>
      <td valign="bottom"><font color="#666666">&nbsp;</td>
         
      </td>
    
    </tr>
  </table>
  <table bgcolor="#2D8EE1" class="common" cellpadding="4" cellspacing="1" style="width:100%" >
     <tr>
        <td class="centertitle"  style="width:10%">状态</td>
        <td class="centertitle" style="width:15%">报案号</td>
        <td class="centertitle" style="width:10%">调度标的</td>
        <td class="centertitle" style="width:10%">调度信息</td>
        <td class="centertitle" style="width:15%">调度时间</td>
        <td class="centertitle" style="width:10%">调度员</td>
        
        <td class="centertitle" style="width:10%">定损员</td>
       
     </tr>

  <%int index=0;%>
     <logic:notEmpty  name="prpLscheduleItemDto"  property="scheduleItemList" > 
     <logic:iterate id="prpLcheckTaskList"  name="prpLscheduleItemDto"  property="scheduleItemList">  
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else 
               out.print("<tr class=listeven>");
%>

        <td align="center">
        <logic:equal name="prpLcheckTaskList" property="surveyTimes" value='0' >
         新调度
        </logic:equal>
        
        <logic:equal name="prpLcheckTaskList" property="surveyTimes" value='1' >
         已提交
        </logic:equal>
        </td>
        
        <td > 
        <a href="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='registNo'/>&editType=SHOW&prpLscheduleMainWFScheduleID=1&scheduleType=schel"> <bean:write name="prpLcheckTaskList" property="registNo"/>
        </a></td>  
        <td ><bean:write name="prpLcheckTaskList" property="licenseNo"/></td>      
        <td ><bean:write name="prpLcheckTaskList" property="resultInfo"/></td>        <%// 金银牌客户标志   %>
        <td ><bean:write name="prpLcheckTaskList" property="inputDate"/></td>         <%// 是否被调度使用   %>      
        <td ><bean:write name="prpLcheckTaskList" property="operatorName"/></td> 
        
        <td ><bean:write name="prpLcheckTaskList" property="nextHandlerName"/></td>            <%// 承保险类 (DAA)   %>
        
       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      
      <tr class="listtail">
	      <td colspan="15">
	             <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>  
                  <bean:define id="pageview" name="prpLscheduleItemDto" property="turnPageDto"/>  
<%
  PrpLscheduleItemDto prpLscheduleItemDto = (PrpLscheduleItemDto)request.getAttribute("prpLscheduleItemDto"); 
  int curPage = prpLscheduleItemDto.getTurnPageDto().getPageNo(); 
%>                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
	      </td>
      </tr>
    </table> 
  </tr>
     <input type="hidden" name="editType" value="QUERY">  
     <input type="hidden" name="scheduleType" value="schel">  
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