<%--
**************************************************************************** 
* DESC       ���鿱���ȴ���ҳ��
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
<head>

<html:html locale="true">
  <!--��title����-->  
  <title>���ȴ���</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/schedule/js/DAAScheduleCheckEdit.js"></script>
</head> 


<%  
  String editType=request.getParameter("editType");
  //System.out.println(editType);
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');"> 
<%
}else
{
%>
<body class=interface onload="initPage();initSet();">
<%
}
%>    


    <form name=fm action="/claim/scheduleSave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    
      <%-- 1.��������Ϣͷ��Ϣ --%>
      <%//System.out.println("-- 1.��������Ϣͷ��Ϣ --");%>
      <%@include file="/DAA/schedule/DAAScheduleCheckMainEdit.jsp" %>
      <%-- 3.������ʾ��Ϣ --%>
      <%-- // @include file="/DAA/claim/DAAClaimFeeEdit.jsp" --%>
        <%-- 4.������Ϣ����˵�� --%>
            <%@include file="/DAA/regist/DAARegistExtEdit.jsp"%> 
      <%-- 4.���ȱ��水ť --%>
      <%@include file="/DAA/schedule/DAAScheduleCheckSave.jsp" %>
      
 </form>   

</body>


<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>
