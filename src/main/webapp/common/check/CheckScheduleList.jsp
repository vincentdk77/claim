<%--
****************************************************************************
* DESC       �����Ȳ鿱����
* AUTHOR     ��
* CREATEDATE ��2004-08-01
* MODIFYLIST ��   id       Date            Reason/Contents
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
     ���鿱����
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
      <td align="left"><font color="#FF0080">&nbsp;���±����ǼǺţ�����鿱����&nbsp;&nbsp;
      <input type=button name=bgetScheduleNew class='bigbutton' value="ˢ�²鿱����" style="align:center" onclick="cmdOK_onclick();">

      </td>

    </tr>
  </table>
  <table  class="common" cellpadding="5" cellspacing="1" >
  <tr><td colspan=6 class="formtitle">���鿱������</td></tr>
     <tr>
     <td class="centertitle"  style="width:14%">����״̬</td>
        <td class="centertitle" style="width:18%">�����ǼǺ�</td>
        <td class="centertitle" style="width:14%">����ʱ��</td>
        <td class="centertitle" >������Ϣ</td>
        <td class="centertitle" style="width:14%">����Ա</td>
        <td class="centertitle" >�鿱�ظ�</td>
        <%// ����Ϊ���ص� �У�Ϊ�˼����ظ�ȡ���ݿ���Ϣ������%>
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
         �µ���
        </logic:equal>

        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='1' >
         ��ȴ�
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='2' >
         ���ڴ���
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='3' >
         ���������
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='4' >
         ��Ҫ���µ��ȱ�����
        </logic:equal>
        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='5' >
         ��Ҫ���е���
        </logic:equal>

        <logic:equal name="prpLcheckTaskList" property="checkFlag" value='6' >
         �鿱�������ύ����
        </logic:equal>

        </td>
        <%// ���������
               %>


        <td >
        <a href="/claim/checkScheduleDeal.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='registNo'/>&editType=DEALCHECKSCHEDULE&prpLscheduleMainWFScheduleID=<bean:write name='prpLcheckTaskList' property='scheduleID'/>"> <bean:write name="prpLcheckTaskList" property="registNo"/>
        </a></td>

        <td ><bean:write name="prpLcheckTaskList" property="inputDate"/></td>         <%// �Ƿ񱻵���ʹ��   %>
        <td ><bean:write name="prpLcheckTaskList" property="resultInfo"/></td>        <%// �����ƿͻ���־   %>
        <td ><bean:write name="prpLcheckTaskList" property="operatorName"/></td>            <%// ԤԼ�鿱(����)   %>
        <td ><bean:write name="prpLcheckTaskList" property="checkInfo"/></td>            <%// �б����� (DAA)   %>


       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>

      <tr class="listtail">
	      <td colspan="6">
	       ����<%= index %>�����鿱������Ҫ���д���
	      </td>
      </tr>
    </table>
  </tr>



  </table>

<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>