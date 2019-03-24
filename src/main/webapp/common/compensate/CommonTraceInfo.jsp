<!--***************************************************************************
* Description:  �켣��Ϣ��ʾ
* Author     :  Pao
* CreateDate :  2013-10-16 20:32
* UpdateLog��   Name       Date            Reason/Contents
****************************************************************************-->

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app"%>

<!-- ��������ʽ���� -->
<%@ include file="CommonStyle.html"%>

<html>
  <head>
   <app:css />
    <title>��Ϣ��ѯ</title>

    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <!--������Ϣ-->
    <script src="/claim/common/js/Common.js"></script>

    <script language='javascript'>

    </script>
</head>

<body onload="">
  <form name="fm" action="">
    <table class="common" cellpadding="5" cellspacing="1" align="center" id="Tinsure">
      <tr class=listtitle>
        <td colspan="4">������</td>
      </tr>

   <logic:notEmpty  name="TraceInfoList"  >
   <logic:iterate indexId="index" id="traceInfo" name="TraceInfoList" >
   <tr><td colspan=4></tr>
      <tr>
        <td  class="title4">�������ƣ�</td>
        <td  class="input4" colspan=3><bean:write name="traceInfo" property="nodeName" /></td>
      </tr>
      <tr>
        <td  class="title4">������Ա��</td>
        <td  class="input4"><bean:write name="traceInfo" property="operatorName" /></td>
        <td  class="title4">�����ţ�</td>
        <td  class="input4"><bean:write name="traceInfo" property="deptCode" /></td>
      </tr>
      <tr>
        <td  class="title4">����״̬��</td>
        <td  class="input4"><bean:write name="traceInfo" property="nodeStatusName" /></td>
        <td  class="title4">����</td>
        <td  class="input4"><bean:write name="traceInfo" property="flowStatusName" /></td>
      </tr>
      <tr>
        <td  class="title4">�ύʱ�䣺</td>
        <td  class="input4"><bean:write name="traceInfo" property="flowInTime" /></td>
        <td  class="title4">�������ʱ�䣺</td>
        <td  class="input4"><bean:write name="traceInfo" property="submitTime" /></td>
      </tr>
      <tr>
        <td class=title4>��������</td>
        <td readonly class=input4 colspan="3">
          <textarea class=common name="HandleTextMemo" rows="4" readonly > <bean:write name="traceInfo" property="handleText" /></textarea></td>
      </tr>
     
   </logic:iterate>
   </logic:notEmpty>
   
    </table>
    <table class=two>
      <tr>
        <td align="center">
          <Input class="button" name="buttonClose" type="button" alt="�ر�" value="�� ��" onclick="closeWindow()"></td>
      </tr>
    </table>
</form>
</body>
</html>