<!--***************************************************************************
* Description:  轨迹信息显示
* Author     :  Pao
* CreateDate :  2013-10-16 20:32
* UpdateLog：   Name       Date            Reason/Contents
****************************************************************************-->

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>

<!-- 滚动条样式定义 -->
<%@ include file="CommonStyle.html"%>

<html>
  <head>
   <app:css />
    <title>信息查询</title>

    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <!--公用信息-->
    <script src="/claim/common/js/Common.js"></script>

    <script language='javascript'>

    </script>
</head>

<body onload="">
  <form name="fm" action="">
    <table class="common" cellpadding="5" cellspacing="1" align="center" id="Tinsure">
      <tr class=listtitle>
        <td colspan="4">审核意见</td>
      </tr>

   <logic:notEmpty  name="TraceInfoList"  >
   <logic:iterate indexId="index" id="traceInfo" name="TraceInfoList" >
   <tr><td colspan=4></tr>
      <tr>
        <td  class="title4">级别名称：</td>
        <td  class="input4" colspan=3><bean:write name="traceInfo" property="nodeName" /></td>
      </tr>
      <tr>
        <td  class="title4">处理人员：</td>
        <td  class="input4"><bean:write name="traceInfo" property="operatorName" /></td>
        <td  class="title4">处理部门：</td>
        <td  class="input4"><bean:write name="traceInfo" property="deptCode" /></td>
      </tr>
      <tr>
        <td  class="title4">级别状态：</td>
        <td  class="input4"><bean:write name="traceInfo" property="nodeStatusName" /></td>
        <td  class="title4">流向：</td>
        <td  class="input4"><bean:write name="traceInfo" property="flowStatusName" /></td>
      </tr>
      <tr>
        <td  class="title4">提交时间：</td>
        <td  class="input4"><bean:write name="traceInfo" property="flowInTime" /></td>
        <td  class="title4">处理完毕时间：</td>
        <td  class="input4"><bean:write name="traceInfo" property="submitTime" /></td>
      </tr>
      <tr>
        <td class=title4>审核意见：</td>
        <td readonly class=input4 colspan="3">
          <textarea class=common name="HandleTextMemo" rows="4" readonly > <bean:write name="traceInfo" property="handleText" /></textarea></td>
      </tr>
     
   </logic:iterate>
   </logic:notEmpty>
   
    </table>
    <table class=two>
      <tr>
        <td align="center">
          <Input class="button" name="buttonClose" type="button" alt="关闭" value="关 闭" onclick="closeWindow()"></td>
      </tr>
    </table>
</form>
</body>
</html>