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

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common" style="width:100%">
    <tr> 
      <td width="184" height="26" valign="bottom"> 
        <table width="184" height="19" border="0" cellpadding="0" cellspacing="0" >
          <tr> 
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="161" class="formtitle">
              <!-- 显示需要调度的内容 -->
              调度查勘任务清单
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
     <td class="centertitle"  style="width:6%">序号</td>
        <td class="centertitle" style="width:18%">报案登记号</td>
        <td class="centertitle" style="width:8%">调度号</td>
        <td class="centertitle" style="width:10%">调度时间</td>
        <td class="centertitle" style="width:10%">调度操作员</td>
        <td class="centertitle" style="width:10%">调度对象代码</td>
        <td class="centertitle" style="width:38%">调度对象名称</td>

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
     <%=index+1%>
        </td>
        <%// 报案受理号
               %>
       
        
        <td > 
        <%//GETBACKEDIT 这个变量绝对重要，不可以随便修改，关系到保存%>
        <a href="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='registNo'/>&editType=GETBACKEDIT&prpLscheduleMainWFScheduleID=<bean:write name='prpLcheckTaskList' property='scheduleID'/>"> <bean:write name="prpLcheckTaskList" property="registNo"/>

        
        </a></td>       
        <td align="center"><bean:write name="prpLcheckTaskList" property="scheduleID"/></td> 
        <td ><bean:write name="prpLcheckTaskList" property="inputDate"/></td>         <%// 是否被调度使用   %>      
        <td ><bean:write name="prpLcheckTaskList" property="operatorName"/></td>            <%// 预约查勘(定损)   %>
        <td ><bean:write name="prpLcheckTaskList" property="scheduleObjectID"/></td>            <%// 预约查勘(定损)   %>
        <td ><bean:write name="prpLcheckTaskList" property="scheduleObjectName"/></td>            <%// 承保险类 (DAA)   %>
        
       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      
      <tr class="listtail">
	      <td colspan="15">
	       共查询到<%= index %>条查勘任务记录
	      </td>
      </tr>
    </table> 
  </tr>
    
  <table class="common" cellpadding="4" cellspacing="20"> 
    <tr>
    </tr>
    <tr>
    
    </tr>
  <table>
    
  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>