<%--
****************************************************************************
* DESC       �����ȶ����ѯ����(schel)
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
              <!-- ��ʾ��Ҫ���ȵ����� -->
              ���ȶ��������嵥
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
        <td class="centertitle"  style="width:10%">״̬</td>
        <td class="centertitle" style="width:15%">������</td>
        <td class="centertitle" style="width:10%">���ȱ��</td>
        <td class="centertitle" style="width:10%">������Ϣ</td>
        <td class="centertitle" style="width:15%">����ʱ��</td>
        <td class="centertitle" style="width:10%">����Ա</td>
        
        <td class="centertitle" style="width:10%">����Ա</td>
       
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
         �µ���
        </logic:equal>
        
        <logic:equal name="prpLcheckTaskList" property="surveyTimes" value='1' >
         ���ύ
        </logic:equal>
        </td>
        
        <td > 
        <a href="/claim/scheduleFinishQueryList.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='registNo'/>&editType=SHOW&prpLscheduleMainWFScheduleID=1&scheduleType=schel"> <bean:write name="prpLcheckTaskList" property="registNo"/>
        </a></td>  
        <td ><bean:write name="prpLcheckTaskList" property="licenseNo"/></td>      
        <td ><bean:write name="prpLcheckTaskList" property="resultInfo"/></td>        <%// �����ƿͻ���־   %>
        <td ><bean:write name="prpLcheckTaskList" property="inputDate"/></td>         <%// �Ƿ񱻵���ʹ��   %>      
        <td ><bean:write name="prpLcheckTaskList" property="operatorName"/></td> 
        
        <td ><bean:write name="prpLcheckTaskList" property="nextHandlerName"/></td>            <%// �б����� (DAA)   %>
        
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