<%--
****************************************************************************
* DESC       �����Ȳ鿱����
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
    ����ȡ�������嵥
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  </script>
  <html:base/>
</head>

<body>
<form name="fm" >

  
 <table  class="common" cellpadding="5" cellspacing="1" >
 <tr>

            <td colspan="6" class="formtitle"> ����<bean:write name="swfLogDto" property="nodeName"/>�����嵥</td>

          </tr>
     <tr>
     <td class="centertitle"  style="width:6%">���</td>
        <td class="centertitle" style="width:18%">�����ǼǺ�</td>
        <td class="centertitle" style="width:20%">����ʱ��</td>
        <td class="centertitle" style="width:10%">���Ȳ���Ա</td>
        <td class="centertitle" style="width:10%">�鿱/������Ա</td>
        <td class="centertitle" style="width:28%">���ȶ�������</td>
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
<%String scheduleType="sched";//�������� %>
         <td > 
        <%//GETBACKEDIT �������������Ҫ������������޸ģ���ϵ������%>
        <logic:equal name="swfLogDto" property="nodeType" value="certa">
       <% scheduleType="schel";%>
        </logic:equal>
        
        <a href="/claim/schedulegetBackEdit.do?prpLscheduleMainWFRegistNo=<bean:write name='prpLcheckTaskList' property='keyIn'/>&editType=GETBACKEDIT&nodeType=<bean:write name='prpLcheckTaskList' property='nodeType'/>&lossItemCode=<bean:write name='prpLcheckTaskList' property='lossItemCode'/>&scheduleType=<%=scheduleType%>&swfLogFlowID=<bean:write name='prpLcheckTaskList' property='flowID'/>&swfLogLogNo=<bean:write name='prpLcheckTaskList' property='logNo'/>&policyNo=<bean:write name='prpLcheckTaskList' property='policyNo'/>&handleDept=<bean:write name='prpLcheckTaskList' property='handleDept'/>&riskCode=<bean:write name='prpLcheckTaskList' property='riskCode'/>"> <bean:write name="prpLcheckTaskList" property="keyIn"/>

        </a></td>       
        <td ><bean:write name="prpLcheckTaskList" property="flowInTime"/></td>         <%// �Ƿ񱻵���ʹ��   %>      
        <td ><bean:write name="prpLcheckTaskList" property="beforeHandlerName"/></td>            <%// ԤԼ�鿱(����)   %>
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