<%--
****************************************************************************
* DESC       ：已决赔款汇总查询结果显示
* AUTHOR     ：lixiang
* CREATEDATE ：2004-10-08
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


<html:html locale="true">
<head>
    <app:css />

  <title>
  已决赔款汇总查询结果
  </title>
  <script src="/claim/common/js/showpage.js"> </script>
  <script language=javascript>
  function showClaimSumQueryList(){
    var win;
    var EndCaseSumListDetailDo="/claim/EndCaseSumDetailList.do?conditions="+fm.conditions.value;
    //win=window.showModalDialog(EndCaseSumListDetailDo,"NewWindow","status=no,resizable=no,scrollbars=yes,width=1200,Height=500");

    var newWindow = window.open(EndCaseSumListDetailDo,"EndCaseSumQueryList",'width=640,height=300,top=0,left=0,toolbar=0,location=0,directories=0,menubar=0,scrollbars=1,resizable=1,status=0');
    newWindow.focus();
   }
  </script>
  <html:base/>
</head>

<body  >
<form name="fm"  method="post">

      <table class=common  border="0" cellpadding="0" cellspacing="0">
        <tr>
         <td class=common>险种合计: <input type="button" class=button name="buttonList" value="清 单" onclick="showClaimSumQueryList();">
	        </td>
  </tr>
</table>
<table  class="common" cellpadding="4" cellspacing="1" >
<tr><td colspan=4 class="formtitle">已决赔款汇总查询结果显示</td></tr>
   <tr>
      <td class="centertitle" >险种代码</td>
      <td class="centertitle" >险种名称</td>
      <td class="centertitle" >币别</td>
      <td class="centertitle" >总赔付金额</td>
      </tr>
   </tr>
   <%int index=0;%>
   <logic:notEmpty  name="prpLclaimDto"  property="claimList">
   <logic:iterate id="prpLclaim1"  name="prpLclaimDto"  property="claimList">
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>
   <tr class=common>
      <td align="center"><bean:write name="prpLclaim1" property="riskCode"/></a></td>
      <td align="left"><bean:write name="prpLclaim1" property="riskCodeName"/></td>
      <td align="center"><bean:write name="prpLclaim1" property="currency"/></td>
      <td align="right"><bean:write name="prpLclaim1" property="sumPaid" format="###,###.00"/></td>

    </tr>
<%        index++;%>
    </logic:iterate>
    </logic:notEmpty>
      <tr class="listtail">
        <td colspan="4">
         共查询出<%= index %>条满足条件的记录

         <input type="hidden" name="conditions" value="<bean:write name='prpLclaimDto' property='remark'/>">
        </td>
      </tr>
  </table>
  </tr>
</table>
</form>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</body>
</html:html>