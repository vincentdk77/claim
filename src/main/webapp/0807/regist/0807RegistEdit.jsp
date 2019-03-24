<%--
****************************************************************************
* DESC       ：报案信息录入页面
* AUTHOR     ： 
* CREATEDATE ： 2007-05-21
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.custom.*" %>
<%@ page import="com.sinosoft.claim.dto.domain.*" %>
<%@ page import="com.sinosoft.sysframework.common.datatype.*" %>

<%
PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto"); 
PrpChospitalPersonDto prpChospitalPersonDto = (PrpChospitalPersonDto)request.getAttribute("prpChospitalPersonDto");
String strRiskCode = policyDto.getPrpCmainDto().getRiskCode();
String strPolicyNo = policyDto.getPrpCmainDto().getPolicyNo();
String strComCode = policyDto.getPrpCmainDto().getComCode();
String strClassCode = policyDto.getPrpCmainDto().getClassCode();
String strInsuredCode = prpChospitalPersonDto.getInsuredCode();
String strIdentifyNumber = prpChospitalPersonDto.getIdentifyNumber();
String strButtonSaveType = "4";

String sex="";
if(prpChospitalPersonDto.getSex().equals("1"))
{
  sex="男";
}
else
{
  sex="女";
}
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<script src="/claim/commonAcci/regist/js/AcciRegistEdit.js"></script>
		<script language="javascript">
			function calDays()
			{
				if(fm.damageStartDate.value!=""&&fm.damageEndDate.value!="")
				{
					var damageDay = fm.damageStartDate.value;
					var damage = new Date(damageDay.substring(0,4),damageDay.substring(5,7)-1,damageDay.substring(8,10));
          var endDay = fm.damageEndDate.value;
          var regist = new Date(endDay.substring(0,4),endDay.substring(5,7)-1,endDay.substring(8,10));
          var days = (regist.getTime()- damage.getTime())/(24*60*60*1000);
          fm.damageDays.value = days;
				}
			}
			function submitForm()
			{
				if(fm.damageStartDate.value=="")
				{
					alert("请输入入院日期!");
					return false;
				}
				if(fm.damageEndDate.value=="")
				{
					alert("请输入出院日期!");
					return false;
				}
				fm.nextStep.disabled = true;
				fm.submit();
			}
			function isNumeric(strValue)
      {
        var result = regExpTest(strValue,/\d*[.]?\d*/g);
        return result;
      }
   
      function checknumber(field)
      {
      	field.value = trim(field.value);
        var strValue = field.value;
        if(!isNumeric(strValue)&&field.value!="")
        {
        	alert("电话号码必须输入数字！");
        }
      }
		</script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
	</head>
	<body>
		<form name=fm action="/claim/0807registSave.do" method="post">
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td align="center" width="20%">医疗证号：</td>
					<td align="left" width="30%">
						<input align="left" type=text name=hospitalNumber class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='hospitalNumber'/>">
					</td>
					<td align="center" width="20%">身份证号：</td>
					<td align="left" width="30%">
						<input align="left" type=text name=identifyNumber class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='identifyNumber'/>">
					</td>
				</tr>
			</table>
			<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td  style="width:30px">姓名</td>
					<td >
						<input type=text name=insuredName class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='insuredName'/>">
					</td>
					<td  style="width:30px"> 性别</td>
					<td >
						<input type=text name=sex class="readonly" readonly="true" value="<%=sex%>">
						<input type=hidden name=sexCode value="<%=prpChospitalPersonDto.getSex()%>">
					</td>
					<td  style="width:30px">年龄</td>
					<td >
						<input type=text name=age class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='age'/>">
					</td>
					<td  style="width:50px">家庭住址</td>
					<td >
						<input type=text name=townName class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='townName'/>">
					</td>
					<td  style="width:10px">镇</td>
					<td >
						<input type=text name=insuredAddress class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='insuredAddress'/>">
					</td>
					<td  style="width:50px">联系电话</td>
					<td >
						<input type=text name=phoneNumber onblur="checknumber(this);">
					</td>
				</tr>
				<tr>
					<td  style="width:50px">所住医院</td>
					<td colspan="5">
						<input type=text name=hospitalName >
					</td>
					<td  style="width:50px">科别</td>
					<td colspan="3">
						<input type=text name=hospitalItem >
					</td>
					<td  style="width:50px">住院号</td>
					<td colspan="3">
						<input type=text name=hospitalCode >
					</td>
				</tr>
				<tr>
					<td  style="width:50px">入院时间</td>
					<td colspan="4">
						<input type=text name=damageStartDate onblur="checkFullDate(this);calDays();">日
						<img src="/claim/images/bgMarkMustInput.jpg">
					</td>
					<td>YYYY-MM-DD<BR>或YYYYMMDD</td>
					<td  style="width:50px">出院时间</td>
					<td colspan="3">
						<input type=text name=damageEndDate onblur="checkFullDate(this);calDays();">日
						<img src="/claim/images/bgMarkMustInput.jpg">
					</td>
					<td colspan="2">YYYY-MM-DD<BR>或YYYYMMDD</td>
				</tr>
				<tr>
					<td  style="width:50px">住院天数</td>
					<td colspan="11">
						<input type=text name=damageDays style="width:60px">日
					</td>
				</tr>
				<tr>
					<td  style="width:50px">诊断</td>
					<td colspan="11">
						<input type=text name=content style="width:650px">
					</td>
				</tr>
				<tr>
					<td colspan="12" align="center">
						<input type=button value="下一步" name=nextStep onclick="submitForm();">
					</td>
				</tr>
			</table>
			<input type="hidden" name="prpLregistRiskCode" value="<%=strRiskCode%>">
			<input type="hidden" name="prpLregistPolicyNo" value="<%=strPolicyNo%>">
			<input type="hidden" name="prpLregistComCode" value="<%=strComCode%>">
			<input type="hidden" name="prpLregistClassCode" value="<%=strClassCode%>">
			<input type="hidden" name="prpLregistInsuredCode" value="<%=strInsuredCode%>">
			<input type="hidden" name="prpLacciPersonIdentifyNumber" value="<%=strIdentifyNumber%>">
			<input type="hidden" name="buttonSaveType" value="<%=strButtonSaveType%>">
			<input type="hidden" name="prpLregistRegistNo">
		</form>
	</body>
</html>