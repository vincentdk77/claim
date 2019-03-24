<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDriskDto" %>
<html:html locale="true">
<head>
  <title>核赔工作流信息补传</title>
  <%-- 公用函数 --%>
  <script src="/claim/common/Common.js"></script>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script type="text/javascript">
  	function submitform(button1){
  		if(fm.registNo.value.length==0)
  	    {
  	      errorMessage("请输入报案号 .");
  	      return false;
  	    }
  	    fm.action = "/claim/undwrtCaseStatus.do?editType=passVericSettleList";
  		button1.disabled = true;
  		fm.submit();
  	}
  	function submitform1(button1){

  	    fm.action = "/claim/undwrtCaseStatus.do?editType=query";
  		fm.submit();
  	}
  	</script>
  	<html:base/>
</head>
<body>
<form id="fm" name="fm" action=""  method="post" onsubmit="return validateForm(this);" target="resultList">
  <table width="98%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
  <tr> <td colspan=4 class="formtitle">核赔工作流信息补传</td></tr>
  <tr class='title'>
  	<td class='title' width = '30%'>报案号(支持批量查询)</td>
     <td class='input' width = '70%'>
      	<textarea cols="10" rows = "5" id="registNo" name="registNo"></textarea>
      </td>
  </tr>
  <tr align="center">
    <td colspan="4">
    <input type="button" class="button" value="查询" onclick="submitform1(this);"/>
    <input type="button" class="button" value="清单补传" onclick="submitform(this);"/>
    </td>
  </tr>
  
   </table>
   </form>
   <iframe name="resultList" style="width:100%;height:100%"  marginwidth="0" frameborder="0" scrolling="no"></iframe>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>

