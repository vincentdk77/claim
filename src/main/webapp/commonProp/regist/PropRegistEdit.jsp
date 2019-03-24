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

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      <bean:message key="title.registBeforeEdit.editRegist" />
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonProp/regist/js/PropRegistEdit.js"></script>
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
</head>
<%
//add by ���� for 0310����
 PrpLregistDto  prpLregistDto4 = (PrpLregistDto)request.getAttribute("prpLregistDto");
 String riskcodefortemp = prpLregistDto4.getRiskCode();
 System.err.println("riskcode"+riskcodefortemp);
 
  String editType=request.getParameter("editType");
  String riskType=(String)request.getAttribute("riskType");
  String flay = "";
  String comcode = (String)request.getAttribute("comCode");
  String shortRiskCode = riskcodefortemp.substring(0,2);
  System.err.println(comcode + shortRiskCode);
  
  String flag = "Prop";
  session.putValue("oldRegistLastAccessedTime","");
  if (editType.equals("SHOW")||editType.equals("DELETE"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAllButton('buttonArea');">
<%
  }else
  {
%>
<body class="interface" onload="initPage();initSet();initForAdd();">
<%
  }

%>
  <form name=fm action="/claim/registSave.do" method="post" onsubmit="return validateForm(this,'Driver','');">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <input type="hidden" name="businessFlag" value="<%=(String)request.getAttribute("businessFlag") %>">
    <input type="hidden" name="comCodeClassCode" value="<%=comcode + shortRiskCode %>">
        <%-- 1.��������Ϣͷ --%>
            <%@include file="/commonProp/regist/PropRegistMainHeadEdit.jsp" %>
        <%-- 2.��������Ϣ�� --%>
            <%@include file="/commonProp/regist/PropRegistMainMiddleEdit.jsp"%>
        <%-- 3.��������Ϣ��β --%>
            <%@include file="/commonProp/regist/PropRegistMainTailEdit.jsp"%>
        <%if("0310".equals(riskcodefortemp)||"0312".equals(riskcodefortemp)){ %>
         <%@include file="/commonProp/check/HouseIDcardEdit.jsp" %>
        <%} %>
        <%
        if("J".equals(riskType)){
        %>
          <%-- 4.��������Ϣ --%>
          <%@include file="/commonProp/regist/PropRegistPropPerson.jsp"%>
        <%
        }else{
        %>
           <%-- 4.�б���Ϣ --%>
           <%@include file="/DAA/regist/DAARegistPolicyRiskEdit.jsp"%>
           <%
           if((comcode + shortRiskCode).equals("31ZH")){
           %>
           		<%@include file="/commonProp/regist/PropRegistPropPerson.jsp"%>
           <%	   
           }
           %>
        <%
        }
        %>
        <%-- 5.����ժҪ--%>          
             <%@include file="/common/regist/RegistTextEdit.jsp"%>
        <%-- 6.���ִ���--%>
            <%@include file="/common/regist/RegistKelpInfo.jsp"%>             
        <%-- 7.����ͨ�ð�ť --%>
            <%@include file="/commonProp/regist/PropRegistSave.jsp"%>
        <%-- 8.����������ӡ��ť --%>
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