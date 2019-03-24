<%--
****************************************************************************
* DESC       ：工作流查询条件输入页面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-09-07
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
 
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="java.util.*"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.DateTime" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDriskDto" %>
<%
   DateTime strFlowinTime = new DateTime().current();
   strFlowinTime.setTime(System.currentTimeMillis() - Long.parseLong("7776000000"));
   
   List riskCodeCollection = (List)new BLPrpDriskFacade().findRiskCodeByConditions(" k.validstatus = '1'");
   String[] riskCategory = new String[riskCodeCollection.size()];
   String[] riskCode = new String[riskCodeCollection.size()];
   String[] riskName = new String[riskCodeCollection.size()];
   PrpDriskDto prpdRiskDto = null;
   for(int i=0; i<riskCodeCollection.size(); i++)
   {
	   prpdRiskDto = (PrpDriskDto)riskCodeCollection.get(i);
       riskCategory[i] = prpdRiskDto.getRiskType();
       riskCode[i] = prpdRiskDto.getRiskCode();
       riskName[i] = prpdRiskDto.getRiskCName();
   }
   //默认时间
		String statStartDate = "";
		String statEndDate ="";
		DateTime dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
		statStartDate = dateTime.toString();
		statEndDate = dateTime.addDay(-7).toString();
   
%>
<html:html locale="true">
<head>
  <title>工作流查询信息</title>
  <%-- 公用函数 --%>
  <script src="/claim/common/Common.js"></script>
  <script src="/claim/workflow/flow/js/WorkFlowFlowBeforeQuery.js"></script>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">

</head>

<body  onload="initPage();">
<form name="fm" action="/claim/swfFlowQueryDxfl.do"  method="post" onsubmit="return validateForm(this);">

    <table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=4 class="formtitle">工作流查询信息</td></tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.registNo" />：</td>
        <td class='input' >
          <select name="RegistNoSign" class=tag >
            <option value="=">=</option>
           
          </select> <input type=text name="prpLregistRegistNo" class="query" onblur="changeRiskCode(this)">
        </td>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />：</td>
        <td class='input' >
        <select name="PolicyNoSign" class=tag >
            <option value="=">=</option>
            
           
          </select> <input type=text name="prpLregistPolicyNo" class="query" onblur="changeRiskCode(this)">
        </td>

      </tr>

      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />：</td>
        <td class='input' >
        <select name="LicenseNoSign" class=tag >
            <option value="=">=</option>
            <option value="*">*</option>
           
          </select> <input type=text name="prpLregistLicenseNo" class="query" onblur="changeRiskGategory(this)" >
        </td>
        
        <td class='title'>险种大类：</td>
        <td class='title'>
        <select class="common" name="riskCategory" 
                                onchange="buildRiskCodeSelect(fm.riskCategory, fm.prpLregistRiskCode);">
                            <option value="">请选择</option>
                            <option value="D">车险</option>
                            <option value="Y">水险</option>
                            <option value="Q">非水</option>
                            <option value="E">意健</option>
                            <option value="H">种植</option>
                            <option value="I">养殖</option>
                        </select>
       </td>
      </tr>


 <tr>
       <td class='title' style="width:10%">案件状态：</td>
        <td class='input' style="width:25%">
          <input type="radio" name="caseType" value="0" checked>未结案
          <input type="radio" name="caseType" value="1">已结案 
          <input type="radio" name="caseType" value="" >所有案件
        </td>    
        <td class='title' rowspan="4">险种：</td>
        <td class="input" rowspan="4">
            <select class=tag name="RiskCodeSign" style="display:none">
                <option value="=">=</option>
            </select> 
            <input type="hidden" name="riskCodeTag" value="=">
            <select class="common" name="prpLregistRiskCode" size="7" >
            </select>
        </td>
      </tr>
      <tr>
        <td class='title' >报案流入时间：</td>
        <td class='input' >
        <select name="FlowinTimeNoSign" class=tag  >
            <option value=">=">>=</option>
            <option value="<="><=</option>
           
          </select> <input type=text name="prpLregistFlowinTime" class="query"  value=<%=statEndDate  %>>
        </td>
      </tr>
      <tr>
      </tr>
      <tr>
        <td class='title' >被保险人名称：</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign"  >
            <option value="=">=</option>
           <!--  <option value="*">*</option> -->
            
          </select> <input type=text name="prpLregistInsuredName" class="query"  >
        </td>
      </tr>
      <tr>
      <td colspan="4" class='input'><font color="red">为了提高您的查询速度，请尽量录入精确的查询条件。同时系统不允许险种条件为空的查询</font></td>
      </tr>
      <tr> <td class='button' colspan="4">
          <input type=button class='button' id='backButton' value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
        </tr>
    </table>
    <input type="hidden" name="editType" value="WorkFlow">
    <input type="hidden" name="taskCodeC" value="lplc">
  </form>
</body>
<script language="javascript">
    var riskCodeCount = <%=riskCodeCollection.size()%>;
    var riskCodes = new Array();
    <%for(int i=0; i<riskCodeCollection.size(); i++){%>
        riskCodes[<%=i%>] = new Array("<%=riskCategory[i]%>", "<%=riskCode[i]%>", "<%=riskName[i]%>");
    <%}%>

</script>
<jsp:include page="/common/pub/StaticJavascript.jsp" />
</html:html>

