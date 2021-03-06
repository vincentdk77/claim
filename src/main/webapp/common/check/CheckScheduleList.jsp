<%--
****************************************************************************
* DESC       ：调度查勘内容
* AUTHOR     ：
* CREATEDATE ：2004-08-01
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
<html:html locale="true">
<meta http-equiv="Refresh" content="200;url=/claim/scheduleRegistNew.do">
<meta http-equiv="Pragma" content="no-cache">


<head>
    <app:css />

  <title>
     待查勘任务
  </title>
  <script src="/claim/common/js/showpage.js"> </script>

  <script language='javascript'>
    function cmdOK_onclick()
    {
	document.location.reload();
    }

  </script>

  <html:base/>
</head>

<body  >
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common" >
    <tr>
      <td align="left"><font color="#FF0080">&nbsp;按下报案登记号，进入查勘处理&nbsp;&nbsp;
      <input type=button name=bgetScheduleNew class='bigbutton' value="刷新查勘任务" style="align:center" onclick="cmdOK_onclick();">

      </td>

    </tr>
  </table>
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=6 class="formtitle">待查勘任务处理</td></tr>
     <tr>
     <td class="centertitle"  style="width:14%">案件状态</td>
        <td class="centertitle" style="width:18%">报案登记号</td>
        <td class="centertitle" style="width:14%">保存时间</td>
        <td class="centertitle" >调度信息</td>
        <td class="centertitle" style="width:14%">调度员</td>
        <td class="centertitle" >查勘回复</td>
        <%// 以下为隐藏的 列，为了减少重复取数据库信息的问题%>
     </tr>

  <%int index=0;%>
     <logic:notEmpty  name="prpLcheckItemDto"  property="checkItemList" >
     <logic:iterate id="prpLcheckTaskList"  name="prpLcheckItemDto"  property="checkItemList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
<tr class=common>
        <td>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='0' >
         新调度
        </logic:equal>

        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='1' >
         需等待
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='2' >
         正在处理
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='3' >
         案件已完成
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='4' >
         需要重新调度本案件
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='5' >
         需要另行调度
        </logic:equal>

        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='6' >
         查勘结束已提交定损
        </logic:equal>

        </td>
        <%// 报案受理号
               %>


        <td >
        <a href="/claim/checkScheduleDeal.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='registNo'/>&editType=DEALCHECKSCHEDULE&prpLscheduleMainWFScheduleID=<bean:write name='prpLcheckTaskList' property='scheduleID'/>"> <bean:write name="prpLcheckTaskList" property="registNo"/>
        </a></td>

        <td ><bean:write name="prpLcheckTaskList" property="inputDate"/></td>         <%// 是否被调度使用   %>
        <td ><bean:write name="prpLcheckTaskList" property="resultInfo"/></td>        <%// 金银牌客户标志   %>
        <td ><bean:write name="prpLcheckTaskList" property="operatorName"/></td>            <%// 预约查勘(定损)   %>
        <td ><bean:write name="prpLcheckTaskList" property="checkInfo"/></td>            <%// 承保险类 (DAA)   %>


       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>

      <tr class="listtail">
	      <td colspan="6">
	       共有<%= index %>条待查勘任务需要进行处理
	      </td>
      </tr>
    </table>
  </tr>



  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>