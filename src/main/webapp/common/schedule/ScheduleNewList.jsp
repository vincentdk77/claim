<%--
****************************************************************************
* DESC       : ����ڵ��ѯ�°������ȵĽ��ҳ��(���а����������������㷨)
* AUTHOR     : lixiang
* CREATEDATE ��2004-07-21
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
     ����������
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

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common" style="width:200%">
    <tr> 
      <td width="184" height="26" valign="bottom"> 
        <table width="184" height="19" border="0" cellpadding="0" cellspacing="0" >
          <tr> 
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="161" class="formtitle">
              <!-- ��ʾ��Ҫ���ȵ����� -->
              ������������
              </td>
            <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
            
          </tr>
        </table>
      </td>
      <td valign="bottom"><font color="#666666">&nbsp;</td>
      <td align="left"><font color="#FF0080">&nbsp;���±����ǼǺţ�������ȴ���&nbsp;&nbsp;  
      <input type=button name=bgetScheduleNew class='bigbutton' value="��ȡ�µ�������" style="align:center" onclick="cmdOK_onclick();">
    
      </td>
    
    </tr>
  </table>
  <table bgcolor="#2D8EE1" class="common" cellpadding="4" cellspacing="1" style="width:250%" >
     <tr>
     <td class="centertitle"  style="width:3%">���</td>
        <td class="centertitle" style="width:7%">�����ǼǺ�</td>
        <td class="centertitle" style="width:4%">����״̬</td>  
<%           //modify by lixiang add 20050310 start
             //reason:��ʾ����ͣ��ʱ��%>
        <td class="centertitle" style="width:6%">����ͣ��ʱ��</td>
        
<%          //modify by lixiang add 20050310 end%>     
        <td class="centertitle" style="width:4%">�ͻ�����</td>
        <td class="centertitle" style="width:4%">�鿱����</td>
        <td class="centertitle" style="width:4%">�б�����</td>
        <td class="centertitle" style="width:12%">�鿱��ַ</td>
        <td class="centertitle" style="width:11%">���յ�ַ</td>
        <td class="centertitle" style="width:6%">���ճ��ƺ�</td>
        <td class="centertitle" style="width:5%">��������</td>
        <td class="centertitle" style="width:6%">��ϵ�绰</td>
        <td class="centertitle" style="width:3%">�鿱����</td>
        <td class="centertitle" style="width:8%">������</td>
        <td class="centertitle" style="width:6%">�б�֧��˾</td>
        <td class="centertitle" style="width:5%">����;��</td>     
        
        <%// ����Ϊ���ص� �У�Ϊ�˼����ظ�ȡ���ݿ���Ϣ������%>    
     </tr>

  <%int index=0;%>
     <logic:notEmpty  name="prpLscheduleNewDto"  property="scheduleNewList" > 
     <logic:iterate id="prpLscheduleNewTaskList"  name="prpLscheduleNewDto"  property="scheduleNewList">  
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else 
               out.print("<tr class=listeven>");
%>

        <td>
        <%=index+1%>
        </td>
        <%// ���������
               %>
        <td > 
        <a href="/claim/scheduleDealRegist.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLscheduleNewTaskList' property='registNo'/>&editType=ADD&prpLscheduleMainWFSurveyNo=<bean:write name='prpLscheduleNewTaskList' property='surveyNo'/>"> <bean:write name="prpLscheduleNewTaskList" property="registNo"/>
        </a></td>       
  
        <td >
         <input type=hidden name=prpLscheduleNewscheduleFlag value="<bean:write name='prpLscheduleNewTaskList' property='scheduleFlag'/>" >
         <logic:equal name='prpLscheduleNewTaskList' property='scheduleFlag' value="0">
        �µ���
        </logic:equal>
        
        <logic:equal name='prpLscheduleNewTaskList' property='scheduleFlag' value="3">
        �˻ز�����
        </logic:equal>
        
        </td>         <%// �Ƿ񱻵���ʹ��   %>   
        
<%   //modify by lixiang add 20050310 start
     //reason:��ʾ����ͣ��ʱ��          %>        
        <td><bean:write name="prpLscheduleNewTaskList" property="waitTime"/></td>  
<%   //modify by lixiang add 20050310 end%>             
        
        <td ><bean:write name="prpLscheduleNewTaskList" property="signcustType"/></td>        <%// �����ƿͻ���־   %>
        <td >
        <input type=hidden name= prpLscheduleNewbookFlag value="<bean:write name='prpLscheduleNewTaskList' property='bookFlag'/>" >
        <logic:equal name='prpLscheduleNewTaskList' property='bookFlag' value="0">
        ��ԤԼ
        </logic:equal>
        <logic:notEqual name='prpLscheduleNewTaskList' property='bookFlag' value="0">
        ԤԼ
        </logic:notEqual>
        
        </td>            <%// ԤԼ�鿱(����)   %>
        
        <td ><bean:write name="prpLscheduleNewTaskList" property="riskCode"/></td>            <%// �б����� (DAA)   %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageAddress"/></td>       <%// ���յص�         %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageAddressType"/></td>   <%// ���յص����     %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="lostLicenseNo"/></td>       <%// ���ճ��ƺ���     %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="contactName"/></td>         <%// ��������         %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="phoneNumber"/></td>         <%// ��ϵ�绰         %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="surveyNo"/></td>            <%// �Ѳ鿱����       %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="policyNo"/></td>            <%// ������           %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="insureComCode"/></td>       <%// �б�֧��˾       %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="reportWay"/></td>           <%// ����;��         %>
      
 <!--
        <td ><bean:write name="prpLscheduleNewTaskList" property="allKindCode"/></td>          <%// ���ִ��루Ͷ��   %>            
        
        <td ><bean:write name="prpLscheduleNewTaskList" property="operatorCode"/></td>        <%// ����Ա����(����  %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="surveyLicenseNo"/></td>     <%// �鿱���ƺ���(��  %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageCode"/></td>          <%// ����ԭ����� ��  %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageName"/></td>          <%// ����ԭ��˵��     %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageTypeCode"/></td>      <%// �¹����ʹ���(��  %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageTypeName"/></td>      <%// �¹�����˵�� ��  %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageAreaCode"/></td>      <%// ����������� ��  %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageAreaName"/></td>      <%// ������������     %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="addressCode"/></td>         <%// ��ַ����         %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="damageAreaPostCode"/></td>  <%// ���յص�������? %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="accidentDetail"/></td>      <%// �������         %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="surveyType"/></td>          <%// �鿱�ص����ͣ�? %>
        
        <td ><bean:write name="prpLscheduleNewTaskList" property="customerName"/></td>        <%// ��������(��λ)? %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="surveyAddress"/></td>       <%// �鿱��ַ         %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="surveyDate"/></td>          <%//                  %>
        <td ><bean:write name="prpLscheduleNewTaskList" property="scheduleInfo"/></td>        <%// ������Ϣ         %> 
        <td ><bean:write name="prpLscheduleNewTaskList" property="flag"/></td>   
                    <%// ��ʶ             %>
       -->
      
       </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>
      
      <tr class="listtail">
	      <td colspan="16">
	       ����<%= index %>��������������Ҫ���д���
	       
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