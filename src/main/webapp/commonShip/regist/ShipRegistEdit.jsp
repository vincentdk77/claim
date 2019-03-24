<%--
****************************************************************************
* DESC       �������Ǽ�¼��/�޸�ҳ��/�ǳ���ͨ��
* AUTHOR     ��lixiang
* CREATEDATE ��2004-10-12
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>

<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@ page import="com.sinosoft.claim.ui.control.action.UIEndorseAction" %>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonShip/regist/js/ShipRegistEdit.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>
<%
  //modify by liuyanmei add 20051111 start
  
   String policyNo = (String)request.getAttribute("policyNo");
   String curRegistNo = (String)request.getAttribute("curRegistNo");
   UIEndorseAction uiEndorseAction = new UIEndorseAction();
   int checkFlag =0;
   checkFlag = uiEndorseAction.checkStatus(policyNo);
   System.out.println("----���Ľ���-----"+checkFlag);
 
  //modify by liuyanmei add 20051111 end

 
  String editType=request.getParameter("editType");
  System.out.println(editType);
  String flag = "Ship";
  session.putValue("oldRegistLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body  onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
}else
{
%>
<body  onload="initPage();initSet();">
<%
}

%>

    <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="checkFlag" value="<%=checkFlag %>"> 
        <%-- 1.��������Ϣͷ --%>
            <%@include file="/commonShip/regist/ShipRegistMainHeadEdit.jsp" %>
        <%-- 2.��������Ϣ�� --%>
            <%@include file="/commonShip/regist/ShipRegistMainMiddleEdit.jsp"%>
        <%-- 3.��������Ϣ��β --%>
            <%@include file="/commonShip/regist/ShipRegistMainTailEdit.jsp"%>
        <!--modify by qinyongli add start 20050901 �������ʱ�������Ϣ-->
      <%@include file="/DAA/regist/DAARegistPolicyRiskEdit.jsp"%>
        <!--modify by qinyongli add end 20050901-->
        
        <%--5.����ժҪ //add by qinyongli 2005-8-15--%>          
             <%@include file="/common/regist/RegistTextEdit.jsp"%>
        <%-- modify by liyanjie move 4.���ִ���  20051024--%>
         <%-- 4.���ִ���--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%>
        <%-- ����ͨ�ð�ť --%>
            <%@include file="/commonShip/regist/ShipRegistSave.jsp"%>

  <%-- ����������ӡ��ť --%>
            <%@include file="/common/print/RegistPrintButton.jsp"%>
            <%-- �������鷵�ذ��o--%>
             <c:if test="${not empty param.caseNoQuery1 and param.caseNoQuery1 eq 'caseNoQuery1'}">
              <center> 
                <input type="button" class="button" onclick="window.close()" value="�ر�"/>
              </center>
        </c:if>
     </form>

           
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

</html:html>