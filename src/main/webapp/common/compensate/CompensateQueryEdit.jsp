<%--
****************************************************************************
* DESC       ：理算查询条件输入页面
* AUTHOR     ： liubvo
* CREATEDATE ： 2004-06-07
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>
<%@page import="com.sinosoft.prpall.pubfun.PubTools"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLPrpDriskFacade" %>
<%@ page import="com.sinosoft.claim.dto.domain.PrpDriskDto" %>
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%>
<%@page import="java.util.List"%>
<% 
String statStartDate = "";
String statEndDate ="";
DateTime dateTime = new DateTime(DateTime.current(), DateTime.YEAR_TO_DAY);
statStartDate = dateTime.toString();
statEndDate = dateTime.addDay(-7).toString();


PubTools pubTools = new PubTools();
String nowDate = new DateTime(DateTime.current().toString(),DateTime.YEAR_TO_DAY).toString();;
System.err.println("nowDate==="+nowDate);
String OperateDate = "";
String OperateDateEnd = "";
//取查询条件的时间段
if(nowDate!=null){
	OperateDate = pubTools.getMonthStart(pubTools.getNextMonthFullDate(nowDate,-1),"1",0);
	OperateDateEnd = pubTools.getMonthEnd(pubTools.getNextMonthFullDate(nowDate,1),"1",0);
}

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

  String riskType= request.getParameter("type");
  System.out.println("----------------------riskType-----"+ riskType );
  if ((riskType == null)||riskType.equals("")){
   riskType = "notacci";
  }
%>
<html>
<head>
  <title><bean:message key="title.claimBeforeEdit.titleName" /></title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <script src="/claim/common/js/SimpleCalendar.js"></script>
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  <script src="/claim/common/js/UILoad.js"></script>
  <script src="/claim/js/WdatePicker.js"></script>
  <script language="javascript">
  <%--案件状态标志处理--%>
  <!--
  function submitForm()
  {
    var ref1="";
    var ref2="";
    if(fm.riskCategory !=null &&trim(fm.riskCategory.value).length==0)
       {
           alert("险种大类不能为空，请选择！");
           return false;
       }
    if(fm.queryRiskCode !=null && trim(fm.queryRiskCode.value).length==0)
       {
            alert("险种不能为空，请选择！");
            return false;
       }
    for(i=0;i<fm.status.length;i++){
      if(fm.status[i].checked==true){
        ref1 = ref1+fm.status[i].value+",";
      }
    }

    for(i=0;i<fm.UnderWriteFlag.length;i++){
      if(fm.UnderWriteFlag[i].checked==true){
        ref2 = ref2+fm.UnderWriteFlag[i].value+",";
      }
    }
    fm.caseFlag.value = ref1;
    fm.compensateFlag.value = ref2;
    //x_load.show("系统正在查询,请勿点击页面...");
    fm.backButton.disabled=true;
    fm.submit();//提交
    setTimeout('fm.backButton.disabled=false',5000);
  }
  //-->
  
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
   
    var riskCodeCount = <%=riskCodeCollection.size()%>;
    var riskCodes = new Array();
    <%for(int i=0; i<riskCodeCollection.size(); i++){%>
        riskCodes[<%=i%>] = new Array("<%=riskCategory[i]%>", "<%=riskCode[i]%>", "<%=riskName[i]%>");
    <%}%>
  </script>
</head>



<body  onload="initPage();">
<form name="fm" action="/claim/compensateQuery.do"  method="post" onsubmit="return validateForm(this);">

    <table  border="0" align="center" cellpadding="5" cellspacing="1"  class="common">
    <tr>
<% if (riskType.equals("acci")){  %>
       <td colspan=4 class="formtitle">查询审核信息</td>
<% } 
   else {  %> 
       <td colspan=4 class="formtitle">查询理算信息</td>
<% }  %>
   </tr>
      <tr>
        <td class='title'>赔款计算书号：</td>
        <td class='input'>
          <select class=tag name="CompensateNoSign">
            <!--<option value="*">*</option>  -->
            <option value="=">=</option>
          </select> <input type=text name="CompensateNo" class="query">
        </td>
        <td class='title'>立案号：</td>
        <td class='input'>
          <select class=tag name="ClaimNoSign">
            <!--  <option value="*">*</option>-->
            <option value="=">=</option>
          </select> <input type=text name="ClaimNo" class="query">
        </td>

      </tr>
      <tr>
        <td class='title'>保单号：</td>
        <td class='input'>
          <select class=tag name="PolicyNoSign">
          <!--  <option value="*">*</option>  -->
            <option value="=">=</option>
          </select> <input type=text name="PolicyNo" class="query">
        </td>
         <td class='title'>案件状态：</td>
        <td class='input' colspan=1>
        <input type="hidden" name="caseFlag" value="">
        <input type="checkbox" name="status" value="1">未处理
        <input type="checkbox" name="status" value="2">正处理
        <%--没有此种案件状态 2005-07-28<input type="checkbox" name="status" value="3">已处理--%>
        <input type="checkbox" name="status" value="4">已提交
        <input type="checkbox" name="status" value="5">已撤消
        </td>
      </tr>
      <tr>
        <td class='title'><bean:message key="db.prpLregist.licenseNo" />：</td>
        <td class='input'>
        <select class=tag name="LicenseNoSign">
            <option value="*">*</option>
            <option value="=">=</option>
          </select> <input type=text name="LicenseNo" class="query">
        </td>
         <%--报案查询增加被保险人查询条件--%>
       <td class='title' >被保险人名称:</td>
        <td class='input' >
          <select class=tag name="InsuredNameSign" >
            <!--<option value="*">*</option>  -->
            <option value="=">=</option>
          </select> <input type=text name="InsuredName" class="query" >
        </td>
      </tr>
     <tr>
        <td class='title'>核赔标志：</td>
        <td class='input' colspan=3>
          <input type="hidden" name="compensateFlag">
          <input type="checkbox" name="UnderWriteFlag" value="0">初始值
          <input type="checkbox" name="UnderWriteFlag" value="1">通过
          <input type="checkbox" name="UnderWriteFlag" value="2">不通过
          <input type="checkbox" name="UnderWriteFlag" value="3">无需核赔
          <input type="checkbox" name="UnderWriteFlag" value="9">待核赔
        </td>
      </tr>
      <tr>
        <td class='title'>操作时间起始：</td>
        <td class='input'>
          <select class=tag name="OperateDateSign">
	         <option value=">=">&gt;=</option>
          </select> <input type=text name="OperateDate" value="<%=statEndDate %>" class="Wdate" style="width:60%" onfocus="WdatePicker();"> <!-- <img align="absmiddle" style='cursor: hand' src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDate', '2007', '2017')"> -->
        </td>
         <td class='title' >操作时间截止：</td>
        <td class='input' >
        <select class=tag name="OperateDateSignEnd" >
          <option value="<=">&lt;=</option>
        </select> <input type="text" name="OperateDateEnd" value="<%=statStartDate %>" class="Wdate" style="width:60%" onfocus="WdatePicker();"> <!-- <img style='cursor: hand' align="absmiddle" src="/claim/images/bgcalendar.gif" onclick="TogglePopupCalendarWindow('document.fm.OperateDateEnd', '2007', '2017')" onblur="return checkFullDate(this);"> -->
        </td>
     </tr>
      <tr>	
		<td class='title'>险种大类：</td>
        <td class='title'>
        <select class="common" name="riskCategory" 
                                onchange="buildRiskCodeSelect(fm.riskCategory, fm.queryRiskCode);">
                            <option value="">请选择</option>
                            <option value="D">车险</option>
                            <option value="Y">水险</option>
                            <option value="Q">非水</option>
                            <option value="E">意健</option>
                            <option value="H">种植</option>
                            <option value="I">养殖</option>
                        </select>
        </td>
		<td class='title' >险种：</td>
        <td class="input" >
            <select class=tag name="RiskCodeSign" style="display:none">
                <option value="=">=</option>
            </select> 
            <input type="hidden" name="riskCodeTag" value="=">
            <select class="common" name="queryRiskCode" size="7" >
            </select>
        </td>
	  </tr>
	  <tr>
	    <td colspan="4" class='input'><font color="red">为了提高您的查询速度，请尽量录入精确的查询条件。同时系统不允许险种条件为空的查询</font></td>
	  </tr>
       <td class='button'  colspan="4">
          <input type=button class='button' id="backButton" value="<bean:message key='button.query.value' />" onClick="submitForm();">
        </td>
    </table>
    <input type="hidden" name="riskType" value="<%=riskType %>">
    <input type="hidden" name="editType" value="SHOW">
    <input type="hidden" name="nodeType" value="<%= request.getParameter("nodeType") %>">
  </form>
</body>
</html>