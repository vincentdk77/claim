<%--
****************************************************************************
* DESC       ：关联页面
* AUTHOR     ：sunhao
* CREATEDATE ：2004-09-02
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.sinosoft.claim.util.*" %>


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
  <title>报案关联信息</title>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/>
</head>

<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<form name="fm">
<input type="hidden" name="pageFlag">
  <table border="0" align="center" cellpadding="0" cellspacing="0" class="common">
    <tr>
      <td width="184" height="26" valign="bottom">
        <table width="184" height="19" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td><img src="/claim/images/bgBarLeft.gif" width="12" height="19"></td>
            <td width="161" class="formtitle">报案关联信息</td>
            <td><img src="/claim/images/bgBarRight.gif" width="11" height="19"></td>
          </tr>
        </table>
      </td>
      <td valign="bottom"><font color="#666666">&nbsp;</td>
    </tr>
  </table>

  <table bgcolor="#2D8EE1" class="common" cellpadding="4" cellspacing="1"  >
     <tr>
       <td class="title" width="30%">报案号:</td>
       <td class="input" >
<%
   String registNo = "";

  PrpLregistDto prpLregistDto = (PrpLregistDto)request.getAttribute("prpLregistDto");
  Collection registList = prpLregistDto.getRegistList();
  Iterator registListTemp = registList.iterator();
  while(registListTemp.hasNext()){
    PrpLregistDto prpLregistDtoTemp = (PrpLregistDto) registListTemp.next();
    registNo = prpLregistDtoTemp.getRegistNo();

%>  
    
           <a href="/claim/ClaimPrint.do?printType=Regist&RegistNo=<%=registNo%>"><%=registNo%><br></a>
           
     
<%
  }
%> 
       </td>       
    </tr>
  </table>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</form>
</body>
</html:html>