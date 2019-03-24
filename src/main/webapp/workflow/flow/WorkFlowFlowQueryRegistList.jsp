<%--
****************************************************************************
* DESC       ：工作流查询报案信息结果页面
* AUTHOR     ：weishixin
* CREATEDATE ：2004-03-01
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.claim.query.bl.facade.BLPrpDriskFacade" %>
<%@ page import="java.util.*" %>

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
  <title>工作流流程查询结果显示</title>
  <script> 
  		function mysubmit(){
  		    if(fm.caseType[0].checked != true && fm.prpLregistRiskCode.value == "" ){
                alert("险种不能为空！");
                return false;
            }
  			fm.pageNo.value = "1";
  			fm.submit();
  			
  		}
  </script>
          <script src="/claim/common/js/showpage.js"> </script>
  <html:base/> 
</head>

<script src="/claim/common/Common.js"></script>
  <script src="/claim/workflow/flow/js/WorkFlowFlowBeforeQuery.js"></script>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">


<body class="interface" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="initPage();">
<form name="fm" action="/claim/swfFlowQueryDxfl.do"  method="post" onsubmit="return validateForm(this);">
<%
WorkFlowQueryDto workFlowQueryDto = new WorkFlowQueryDto();
workFlowQueryDto = (WorkFlowQueryDto)request.getAttribute("workFlowQueryDto");
String strRegistNoSign = request.getParameter("RegistNoSign");
String strPolicyNoSign = request.getParameter("PolicyNoSign");
String strRiskCodeSign = request.getParameter("RiskCodeSign");
String strRiskCodeNameSign = request.getParameter("RiskCodeNameSign");
String strFlowinTimeNoSign = request.getParameter("FlowinTimeNoSign");
String strLicenseNoSign = request.getParameter("LicenseNoSign");
String strInsuredNameSign = request.getParameter("InsuredNameSign");

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

%>
<table width="100%" border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr> <td colspan=4 class="formtitle">工作流查询信息</td></tr>
      <tr>
        <td class='title' ><bean:message key="db.prpLregist.registNo" />：</td>
        <td class='input' >
          <select name="RegistNoSign" class=tag >
          <% if(!"*".equals(strRegistNoSign)){ %>
            <option value="=" selected>=</option>
            <option value="*">*</option>
            <%}else{ %>
            <option value="=">=</option>
            <option value="*" selected>*</option>
            <%} %>
          </select> <input type=text name="prpLregistRegistNo" class="query" value="<%=workFlowQueryDto.getRegistNo()%>"  onblur="changeRiskCode(this)" >
        </td>
        <td class='title' ><bean:message key="db.prpLregist.policyNo" />：</td>
        <td class='input' >
        <select name="PolicyNoSign" class=tag >
        <% if(!"*".equals(strPolicyNoSign)){ %>
            <option value="=" selected>=</option>
            <option value="*">*</option>
            <%}else{ %>
            <option value="=">=</option>
            <option value="*" selected>*</option>
            <%} %>
           
          </select> <input type=text name="prpLregistPolicyNo" class="query" value="<%=workFlowQueryDto.getPolicyNo()%>" onblur="changeRiskCode(this)">
        </td>

      </tr>

      <tr>
        <td class='title' ><bean:message key="db.prpLregist.licenseNo" />：</td>
        <td class='input' >
        <select name="LicenseNoSign" class=tag >
        <% if(!"*".equals(strLicenseNoSign)){ %>
            <option value="=" selected>=</option>
            <option value="*">*</option>
        <%}else{ %>
            <option value="=">=</option>
            <option value="*" selected>*</option>
        <%} %>     
          </select> <input type=text name="prpLregistLicenseNo" class="query"  value="<%=workFlowQueryDto.getLicenseNo()%>" onblur="changeRiskGategory(this)">
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
         <td class='title' style="width:10%">案件状态:</td>
         <td class='input' style="width:25%">
          <input type="radio" name="caseType" value="0" <%=workFlowQueryDto.getCaseType().equals("0")? "checked" : ""%>>未结案
          <input type="radio" name="caseType" value="1" <%=workFlowQueryDto.getCaseType().equals("1")? "checked" : ""%>>已结案 
          <input type="radio" name="caseType" value="" <%=workFlowQueryDto.getCaseType().equals("")? "checked" : ""%> >所有案件
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
        <select name="FlowinTimeNoSign" class=tag >
        <% if(!"<=".equals(strFlowinTimeNoSign)){ %>
            <option value=">=" selected>>=</option>
            <option value="<="><=</option>
        <%}else{ %>
            <option value=">=">>=</option>
            <option value="<=" selected><=</option>
        <%} %>     
          </select> <input type=text name="prpLregistFlowinTime" class="query"  value="<%=workFlowQueryDto.getRegistFlowinTime()%>">
        </td>
      </tr>
      <tr>
      
      </tr>
      
      <tr>
        <td class='title' >被保险人名称:</td>
        <td class='input'  >
          <select class=tag name="InsuredNameSign" >
          <% if(!"*".equals(strInsuredNameSign)){ %>
            <option value="=" selected>=</option>
            <option value="*">*</option>
           <%}else{ %> 
            <option value="=">=</option>
            <option value="*" selected>*</option>
           <%} %>  
          </select> <input type=text name="prpLregistInsuredName" class="query" value="<%=workFlowQueryDto.getInsuredName()%>" >
        </td>
      </tr>
      <tr>
      <td colspan="4" class='input'><font color="red">为了提高您的查询速度，请尽量录入精确的查询条件。同时系统不允许险种条件为空的查询</font></td>
      </tr>
      <tr> <td class='button' colspan="4">
          <input type=button class='button' value="<bean:message key='button.query.value' />" onClick="mysubmit();">
        </td>
        </tr>
    </table>
    <input type="hidden" name="editType" value="WorkFlow">
    <input type="hidden" name="taskCodeC" value="lplc">
 
<input type="hidden" name="pageFlag">
  <table bgcolor="#2D8EE1" class="common" cellpadding="4" cellspacing="1" >
     <tr>
        <td class="centertitle" >报案号</td>
        <td class="centertitle" style="width:5%">保单号</td>
        <td class="centertitle" >被保人名称</td>
        <td class="centertitle" >标的</td>
        <td class="centertitle" >处理人员</td>
        <td class="centertitle" >报案日期</td>
        <td class="centertitle"  style="display:none" >流程编号</td> 
        <td class="centertitle"  >险种名称</td> 
        <td class="centertitle" >案件状态</td>
     </tr>
     <%int index=0;%>
     <logic:notEmpty  name="swfLogDto"  property="swfLogList"> 
     <logic:iterate id="swfLogDtoList1"  name="swfLogDto"  property="swfLogList">  
<%
          if(index %2== 0)
               out.print("<tr class=listodd>");
          else
               out.print("<tr class=listeven>");
%>

        <td align="center"><a href="javascript:void(0)" onclick = "openLink(this)" title="<bean:write name='swfLogDtoList1' property='flowID'/>"><bean:write name="swfLogDtoList1" property="businessNo"/></a></td>    
        <td align="center">
        <logic:iterate id="relatePolicyList1"  name="swfLogDtoList1"  property="relatePolicyList">  
        <bean:write name="relatePolicyList1" property="policyNo"/>
        </logic:iterate>
         </td>  
        <td align="left"><bean:write name="swfLogDtoList1" property="insuredName"/></td>
        <td align="left"><bean:write name="swfLogDtoList1" property="lossItemName"/></td>
        <td align="center"><bean:write name="swfLogDtoList1" property="handlerName"/></td>    
        <td align="center"><bean:write name="swfLogDtoList1" property="submitTime"/></td>  
        <td align="center" style="display:none" ><bean:write name="swfLogDtoList1" property="flowID"/></td>  
        <td align="center" ><bean:write name="swfLogDtoList1" property="riskCodeName"/></td>                                                    
        <td align="center"><bean:write name="swfLogDtoList1" property="otherFlag"/></td>
      	<input type="hidden" name="flowId" value="<bean:write name='swfLogDtoList1' property='flowID'/>" />
      </tr>
<%        index++;%>
      </logic:iterate>
      </logic:notEmpty>      
      <tr class="listtail">
        <td colspan="7">
          <table width="100%" class="common" align="center" cellpadding="0" cellspacing="0">
              <tr>  
                  <bean:define id="pageview" name="swfLogDto" property="turnPageDto"/>  
<%
  SwfLogDto swfLogDto = (SwfLogDto)request.getAttribute("swfLogDto"); 
  int curPage = swfLogDto.getTurnPageDto().getPageNo(); 
  String taskcode =(String)request.getParameter("taskCodeC"); 
%>                  
                  <%@include file="/common/pub/TurnOverPage.jsp" %>   
              </tr> 
          </table>
        </td> 
      </tr>      
  </table>
    </table>
    </tr>
  </table> 
  
    <input type="hidden" name="editType" value="EDIT">
    <input type="hidden" name="taskCodeC" value="<%=taskcode%>">
<script language="javascript">
    var riskCodeCount = <%=riskCodeCollection.size()%>;
    var riskCodes = new Array();
    <%for(int i=0; i<riskCodeCollection.size(); i++){%>
        riskCodes[<%=i%>] = new Array("<%=riskCategory[i]%>", "<%=riskCode[i]%>", "<%=riskName[i]%>");
    <%}%>
    var riskCategory = fm.riskCategory;
    for(var i=0; i<riskCategory.length; i++){
        if(riskCategory.item(i).value=="<%=workFlowQueryDto.getRiskCategory()%>"){
            riskCategory.item(i).selected = true;
        }
    }
    fm.riskCategory.onchange();
    var riskCodeField = fm.prpLregistRiskCode;
    for(var i=0; i<riskCodeField.length; i++){
        if(riskCodeField.item(i).value=="<%=workFlowQueryDto.getRiskCode()%>"){
            riskCodeField.item(i).selected = true;
        }
    }
    
 function buildRiskCodeSelect(riskCategoryField, riskCodeField)
{
    var categoryValue = riskCategoryField.value;
    riskCodeField.length = 0;
    riskCodeField.options[0] = new Option("", "");
    for(var i=0; i<riskCodeCount; i++)
    {
        if(riskCodes[i][0] == categoryValue)
        {
            riskCodeField.options[riskCodeField.length] = new Option(riskCodes[i][2], riskCodes[i][1]);
        }
    }
    riskCodeField.remove(0);
}

 function openLink(Field){
 		var flowId = Field.title;
	    //var flowId = document.getElementsByName("flowId")[0].value;
		var url = "/claim/swfFlowBeforeQueryDxfl.do?swfLogFlowID="+flowId;
	  	if(hasSVG()){
	  	
	  		url += "&svgFlag=1";
	  	}else{
	  		url += "&svgFlag=0";
	  	}
	  	//alert(url);
	  	location.href = url;
  	}
  	function hasSVG(){
  		SVG_NS = 'http://www.w3.org/2000/svg';
		return !!document.createElementNS && !!document.createElementNS(SVG_NS,'svg').createSVGRect;
  	}
</script>

    
<script src="/claim/common/StaticJavascript.jsp"> </script>
</form>
</body>
</html:html>
