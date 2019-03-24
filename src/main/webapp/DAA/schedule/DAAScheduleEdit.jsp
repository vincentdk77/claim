<%--
**************************************************************************** 
* DESC       �����ȴ���ҳ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-07-21
* MODIFYLIST ��   Name       Date            Reason/Contents
                
****************************************************************************
--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>    
<%@ page import="com.sinosoft.claim.dto.custom.UserDto" %>    
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.sysframework.common.util.*" %>
<%@ page import="java.util.*" %>
<%@page import="com.sinosoft.claim.util.*"%>
<head>

<html:html locale="true">

<meta http-equiv="Expires" CONTENT="0">
<meta http-equiv="Cache-Control" CONTENT="no-cache">
<meta http-equiv="Pragma" CONTENT="no-cache">


  <!--��title����-->  
  <title>���ȴ���</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/schedule/js/DAAScheduleEdit.js"></script>
  
  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
  <jsp:include page="/common/pub/StaticJavascript.jsp" />

 

 <script>
	<!-- 
    /**
     *@description ��ʼ������ժҪ
     *@param       ��
     *@return      ͨ������true,���򷵻�false
     */
  	function initRegistText(){
<%
  	  PrpLscheduleMainWFDto prpLscheduleMainWFDto = (PrpLscheduleMainWFDto)request.getAttribute("prpLscheduleMainWFDto");
  	  PrpLregistDto prpLregistDto = (PrpLregistDto)request.getAttribute("prpLregistDto"); 
      
      DateTime d1 = prpLregistDto.getDamageStartDate();
      DateTime d2= prpLregistDto.getReportDate(); 
      int hour1=Integer.parseInt(DataUtils.nullToZero(prpLregistDto.getDamageStartHour().substring(0,2 )));
      int hour2=Integer.parseInt(DataUtils.nullToZero(prpLregistDto.getReportHour().substring(0,2 )));
        
      DateCompute dateCompute = new DateCompute();
      int afterHour=dateCompute.getDaysHour(d1,hour1,d2,hour2);
      afterHour=48 -afterHour;
      if (afterHour<0) {
%>  	  
      fm.prplRegistFlag.value="����ʱ�䳬���˱������� <%=-afterHour %> Сʱ";
      var span1 = eval("showMessage1");
      span1.style.display="";  
      
<%      
    }  
%>  
    
  	} 

	//--> 
  </script>


</head> 

<%  
   //modify by ww add begin 2005-11-15
   //reason: ��ֹ�ظ��ύ
   session.setAttribute("oldScheduleLastAccessedTime","");
   //modify by ww add end 2005-11-15
   
  String editType=request.getParameter("editType");
  String saveType1=""; //�ж��ǲ��ǵ������͵�
  String nodeType=request.getParameter("nodeType"); //�ж����ĸ��ڵ��ϵ�
  String flowId=request.getParameter("swfLogFlowID"); //����������
  String getbackLogNo=request.getParameter("swfLogLogNo"); //���ɵĽڵ����
  String endflag=request.getParameter("endflag");
  UserDto user = (UserDto) session.getAttribute("user");
  boolean hasSchedFlag = false;         //�Ƿ�����Ŀ���������� add by liyanjie 2005-12-14
  
  if (editType.equals("SHOW")||editType.equals("DELETE")) {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');"> 
<%
  } else {
%>
<body class=interface onload="initPage();initSet();">
<%
  }
%>  

 
 <logic:equal name="prpLscheduleMainWFDto"  property="saveType" value="GETBACKEDIT">
   <% saveType1="GETBACKEDIT";%>
 </logic:equal>

    <form name=fm action="/claim/scheduleSave.do" method="post" onsubmit="return validateForm(this);">

   <input type="hidden" name=nowURL vlaue="<%=request.getRequestURI()%>">
   
  <script language="javascript"> 
<!-- 
javascript:window.history.forward(1); 
//--> 
</script>
</htm>

    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
     <%-- 1.��������Ϣͷ��Ϣ --%>
      <%@include file="/DAA/schedule/DAAScheduleMainEdit.jsp" %>
      <%  
          //�ж��Ƿ��޲鿱
          String noCheck="1";
      %>
      
    <%
        //�������ȴ���
       if (!"GETBACKEDIT".equals(saveType1))  {    
    %>  <%-- 2.�鿱���ȱ������,���������no�鿱���������� --%>
     
      <logic:equal name="prpLscheduleMainWFDto"  property="scheduleType" value="ALLS">
         <%@include file="/DAA/schedule/DAAScheduleCheckItemEdit.jsp" %>
         <%
             noCheck="0";
         %>
      </logic:equal>
    
            
      <%-- 3.������ȱ������ --%>
      <%@include file="/DAA/schedule/DAAScheduleItemEdit.jsp" %>
      <%-- 4.������Ϣ����˵�� --%>
      <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%> 
 
     <%
       } else { //���ɵĲ���
       if ("check".equals(nodeType)) { //�鿱����%>
    
        <%@include file="/DAA/schedule/DAAScheduleCheckItemEdit.jsp" %>
        <%noCheck="0";%>
     <% 
       } else {  //�������
     %>
          <%-- 3.������ȱ������ --%>
          <%@include file="/DAA/schedule/DAAScheduleItemEdit.jsp" %>
     <%  
       }
     %>
    
      
<%
  }
%>  
     <%-- 5.���ȱ��水ť --%>
     <%@include file="/DAA/schedule/DAAScheduleSave.jsp" %>  
<%     
if (!editType.equals("SHOW")){
%> 		
     <input type="hidden" name="prpLregistLicenseNo" value="<bean:write name='prpLregistDto' property='licenseNo' filter='true' />">
     <input type="hidden" name="newHandlerCode" value="">  <%//������ʾ�ǲ��ǻ����˵Ĳ���%> 
     <input type="hidden" name="nocheck" value="<%=noCheck%>">
     <input type="hidden" name=saveType value="<%=saveType1%>" >
     <input type="hidden" name=flowId value="<%=flowId%>" >
     <input type="hidden" name=endflag value="<%=endflag%>" >
     <input type="hidden" name=getbackLogNo value="<%=getbackLogNo%>" >
     <input type="hidden" name=getbackNodeType value="<%=nodeType%>" >
     <input type="hidden" name=comcode value="<%=user.getComCode()%>">    <%//�������ĵĴ���user.getScheduleComCode()%>
     <input type="hidden" name=newcomcode value="<%=user.getComCode()%>"> <%//ѡ����ȴ���λ�Ĵ��룬Ĭ���ǵ������ĵĴ���%>
     <input type="hidden" name=handlecomcode value="<%=user.getComCode()%>" > <%//��ǰ����Ա���������Ա�����Ʋ鿱��������Ӧ�ú͵���Ա��һ�����ŵ�%>
<%} %>     
</form>
</body>
</html:html>
