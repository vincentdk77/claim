<%--
****************************************************************************
* DESC       ���ط���Ϣ¼��/�޸�ҳ��
* AUTHOR     ��������Ŀ��
* CREATEDATE ��2005-03-24
* MODIFYLIST ��   Name       Date            Reason/Contents
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.claim.dto.domain.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="java.util.*"%>

<html:html locale="true">
<head>
    <!--��title����-->
    <title>
      �ط���Ϣ¼��
    </title>
  <app:css />
  <%-- ҳ����ʽ  --%>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/DAA/backVisit/js/DAABackVisitEdit.js"></script>

  <!--��������ǵ��������õ���ͨ��js�Ĺ��̣�һ�������õ�js�ĺ�����������StaticJavacript��-->
<jsp:include page="/common/pub/StaticJavascript.jsp" />

  <SCRIPT LANGUAGE="JavaScript">

  /**
  *@description ��ʼ���ط���ѯ��Ϣ
  *@param       ��
  *@return      ͨ������true,���򷵻�false
  */
  function initSet(){

<%
    BackVisitDto backVisitDto = (BackVisitDto)request.getAttribute("backVisitDto");


    List prpLbackVisitQueDtoList = (ArrayList)backVisitDto.getPrpLbackVisitQueDtoList();
    if(prpLbackVisitQueDtoList!=null&&prpLbackVisitQueDtoList.size()>0){
      for (int i = 0; i < prpLbackVisitQueDtoList.size(); i++) {
        PrpLbackVisitQueDto prpLbackVisitQueDto = (PrpLbackVisitQueDto)prpLbackVisitQueDtoList.get(i);
        if(prpLbackVisitQueDto.getQuestionResult().equals("0")){
%>

          fm.VisitBackQue<%= i+1 %>[1].checked=true;
<%
        } else if(prpLbackVisitQueDto.getQuestionResult().equals("1")){
%>
          fm.VisitBackQue<%= i+1 %>[0].checked=true;
<%
        } else if(prpLbackVisitQueDto.getQuestionResult().equals("2")){
%>
          fm.VisitBackQue<%= i+1 %>[2].checked=true;
<%
        }
%>
          fm.txtQuestionRemark<%= i+1 %>.value='<%= prpLbackVisitQueDto.getQuestionRemark() %>';
<%
      }
    }
%>
  return true;
  }

  </SCRIPT>

</head>

<%
  String editType=request.getParameter("editType");
  if(editType.equals("SHOW")||editType.equals("DELETE"))
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
   <form name=fm action="/claim/backVisitSave.do" method="post">
    <input type="hidden" name="org.apache.struts.taglib.html.TOKEN" value="<%= session.getAttribute("org.apache.struts.action.TOKEN") %>">
        <%-- 1.�ط�����Ϣ --%>
            <%@include file="/DAA/backVisit/DAABackVisitMainEdit.jsp" %>
        <%-- 1.�ط���ѯ��Ϣ --%>
            <%@include file="/DAA/backVisit/DAABackVisitQueEdit.jsp" %>
        <%-- 2.��ע��Ϣ --%>
            <%@include file="/DAA/backVisit/DAABackVisitTextEdit.jsp"%>
        <%-- 3.����ͨ�ð�ť --%>
            <%@include file="/DAA/backVisit/DAABackVisitSave.jsp"%>
   </form>
</body>

</html:html>