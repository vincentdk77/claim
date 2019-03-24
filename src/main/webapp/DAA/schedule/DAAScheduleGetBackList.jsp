<%--
****************************************************************************
* DESC       ：调度查勘内容
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

<%


%>
<html:html>
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
    调度取回任务清单
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  </script>
  <html:base/>
</head>

<body>
<form name="fm" >

  
 <table  class="common" cellpadding="5" cellspacing="1" >
 <tr>

            <td colspan="6" class="formtitle"> 调度<bean:write name="swfLogDto" property="nodeName"/>任务清单</td>

          </tr>
     <tr>
     <td class="centertitle"  style="width:6%">序号</td>
        <td class="centertitle" style="width:18%">报案登记号</td>
        <td class="centertitle" style="width:20%">调度时间</td>
        <td class="centertitle" style="width:10%">调度操作员</td>
        <td class="centertitle" style="width:10%">查勘/定损人员</td>
        <td class="centertitle" style="width:28%">调度对象名称</td>
     </tr>
  <%int index=0;%>

     <logic:notEmpty  name="swfLogDto"  property="swfLogList" > 
     <logic:iterate id="prpLcheckTaskList"  name="swfLogDto"  property="swfLogList">  

<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else 
               out.print("<tr class=listeven>");
%>

        <td align="center">
     <%=index+1%>
        </td>
<%String scheduleType="sched";//调度类型 %>
         <td > 
        <%//GETBACKEDIT 这个变量绝对重要，不可以随便修改，关系到保存%>
        <logic:equal name="swfLogDto" property="nodeType" value="certa">
       <% scheduleType="schel";%>
        </logic:equal>
        
        <a href="/claim/schedulegetBackEdit.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='keyIn'/>&editType=GETBACKEDIT&nodeType=<bean:write name='prpLcheckTaskList' property='nodeType'/>&lossItemCode=<bean:write name='prpLcheckTaskList' property='lossItemCode'/>&scheduleType=<%=scheduleType%>&swfLogFlowID=<bean:write name='prpLcheckTaskList' property='flowID'/>&swfLogLogNo=<bean:write name='prpLcheckTaskList' property='logNo'/>&policyNo=<bean:write name='prpLcheckTaskList' property='policyNo'/>&handleDept=<bean:write name='prpLcheckTaskList' property='handleDept'/>&riskCode=<bean:write name='prpLcheckTaskList' property='riskCode'/>"> <bean:write name="prpLcheckTaskList" property="keyIn"/>

        </a></td>       
        <td ><bean:write name="prpLcheckTaskList" property="flowInTime"/></td>         <%// 是否被调度使用   %>      
        <td ><bean:write name="prpLcheckTaskList" property="beforeHandlerName"/></td>            <%// 预约查勘(定损)   %>
        <td ><bean:write name="prpLcheckTaskList" property="handlerName"/></td>
        <td ><bean:write name="prpLcheckTaskList" property="lossItemName"/></td>
       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      
      <tr class="listtail">
	      <td colspan="15">
	          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>  
                  <bean:define id="pageview" name="swfLogDto" property="turnPageDto"/>  
<%
  SwfLogDto swfLogDto = (SwfLogDto)request.getAttribute("swfLogDto"); 
  int curPage = swfLogDto.getTurnPageDto().getPageNo(); 
%>                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
	      </td>
      </tr>
    </table> 
  </tr>
  
 <input type="hidden" name="editType" value="GETBACKQUERY">   
    
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