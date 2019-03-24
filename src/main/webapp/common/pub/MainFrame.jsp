<%--
****************************************************************************
* DESC       ：车险理赔框架页面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-03-02 
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="com.sinosoft.claim.ui.view.formbean.LogonForm"%>

   <% LogonForm logonForm=(LogonForm)request.getAttribute("logonForm");
      String userName=logonForm.getPrpDuserUserName();
      String visitDate=logonForm.getPrpDuserVisitDate();
      String subSystem=logonForm.getSubSystem();  
      String callSystem = (String)request.getAttribute("system");
      response.setHeader("P3P","CP=CAO PSA OUR");
   %>
<html:html xhtml="true" locale="true">
    <head>
      <title>理赔工作流系统</title>
      <script language="javascript">
        
        <%
           //呼叫中心链接时窗口不置顶
           if(!"callcenter".equals(callSystem)){
        %>
            if (self!=top){top.location=self.location;}
            var intPageWidth=screen.availWidth;
            var intPageHeight=screen.availHeight;
            window.resizeTo(intPageWidth,intPageHeight);
            window.focus();
        <%}%>
       
      </script>
      <html:base/>
    </head>
  <frameset rows="95,0,0,*" frameborder="yes" border="2" border-color="red" framespacing="0">
    <frame name="fraTitle"  scrolling="no" noresize src="/claim/common/pub/Title.jsp" border="2" border-color="red">
    <frame name="fraCalculate"  scrolling="yes" noresize src="about:blank" border="2" border-color="red">
    <frame name="fraSubmit"  scrolling="yes" noresize src="about:blank" border="2" border-color="red">
    <frameset name="fraSet" cols="180,*" frameborder="yes" border="1" border-color="red" framespacing="0" rows="*">
	 <!--- add by zhaolu 20060814 start --->
      <!---<frame id="fraMenu" name="fraMenu" scrolling="auto" noresize marginwidth=0 marginheight=0 src="/claim/common/pub/LeftMenu.jsp">--->
	  <frame id="fraMenu" name="fraMenu" scrolling="auto" noresize marginwidth=0 marginheight=0 src="/claim/common/pub/tree.jsp" border="2" border-color="red">
	  <!--- add by zhaolu 20060814 end --->
      <frameset name="fraRight" rows="100%,0%,0%" frameborder="yes" border="1" border-color="red" framespacing="0" rows="*">
        <!--modify by weishixin modify 20050227 start-->
        <!--reason:Unix要求大小写一致-->
        <frame id="fraInterface" name="fraInterface" scrolling="auto" src="/claim/common/pub/Welcome.jsp" border="2" border-color="red">
        <!--modify by weishixin modify 20050227 end-->
        <frame id="fraNext" name="fraNext" scrolling="auto" src="about:blank" border="2" border-color="red">
        <frame id="fraCode" name="fraCode" scrolling="auto" noresize src="/claim/common/pub/InputCode.jsp" border="2" border-color="red">
      </frameset>
    </frameset>
  </frameset>

  <noframes>
    <body bgcolor="#c1c1c1" text="#000000">
    </body>
  </noframes>

</html:html>