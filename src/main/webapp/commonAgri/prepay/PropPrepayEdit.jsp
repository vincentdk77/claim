<%--
* DESC       ��Ԥ��Ǽ�¼��/�޸�ҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-10-11
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<% 

PrpLprepayDto prpLprepayDto=(PrpLprepayDto)request.getAttribute("prpLprepayDto");
DBPrpCcoins dbPrpCcoins=new DBPrpCcoins();
dbPrpCcoins.getInfo(prpLprepayDto.getPolicyNo(), "2");
%>
<script language=javascript>
 //add by kangzhen start 061117  reason �鿴��ʱ���ý���Ԫ��ֻ��
 function disabledAll(tableId)
 {
   var elements = getTableElements(tableId);

   for(var i=0;i<elements.length;i++)
   {
   		if(elements[i].name=="buttonBack"){ //�������ΪbuttonBack�����
       	continue;
      } 
       //��button��ɲ�����
       if(elements[i].type == "button")
       {  
       	 elements[i].disabled = true;
       }
       //��submit��ɲ�����
       if(elements[i].type == "submit")
       {
          elements[i].disabled = true;
       }
       //��reset��ɲ�����
       if(elements[i].type == "reset")
       {
          elements[i].disabled = true;
       }
       if(elements[i].type == "text")
       {
        	elements[i].disabled = true;
       }

    }
 }
//add by kangzhen end
</script>

<%@page import="com.sinosoft.claim.dto.domain.PrpLprepayDto"%>
<%@page import="com.sinosoft.prpall.dbsvr.cb.DBPrpCcoins"%>
<html:html locale="true">
<head>
  <!--��title����-->
  <title>Ԥ��Ǽ�</title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/commonProp/prepay/js/PropPrepayEdit.js"></script>
</head>
<%
  String editType=request.getParameter("editType");
  if (editType.equals("SHOW"))
  {
%>
<body class="interface" onload="initPage();initSet();readonlyAllInput();disabledAll('Area');">
<%
}else
{
%>
<%if(dbPrpCcoins!=null){
    if(dbPrpCcoins.getCoinsTreatyNo()!=null&&!"".equals(dbPrpCcoins.getCoinsTreatyNo())){
%>
<body class=interface onload="initPage();initSet();initCoinsTreatyNo();" >
<%}else{%>
 <body class=interface onload="initPage();initSet();" >   
<%}}else{%>
<body class=interface onload="initPage();initSet();" >
<%}%>
<%
}
%>
  <form name=fm action="/claim/prepaySave.do" method="post" onsubmit="return validateForm(this);">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
    <%-- 1.Ԥ������Ϣ --%>
    <%@include file="/commonProp/prepay/PropPrepayMainEdit.jsp" %>
    <%-- 4.Ԥ�ⱸע��Ϣ --%>
    <%@include file="/commonProp/prepay/PropPrepayTextEdit.jsp"%>
    <%-- ����ͨ�ð�ť --%>
    <%@include file="/commonProp/prepay/PropPrepaySave.jsp"%>
  </form>
</body>

<!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>
