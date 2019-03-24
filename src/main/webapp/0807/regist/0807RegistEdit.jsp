<%--
****************************************************************************
* DESC       ��������Ϣ¼��ҳ��
* AUTHOR     �� 
* CREATEDATE �� 2007-05-21
* MODIFYLIST ��   Name       Date            Reason/Contents
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
  sex="��";
}
else
{
  sex="Ů";
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
					alert("��������Ժ����!");
					return false;
				}
				if(fm.damageEndDate.value=="")
				{
					alert("�������Ժ����!");
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
        	alert("�绰��������������֣�");
        }
      }
		</script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
	</head>
	<body>
		<form name=fm action="/claim/0807registSave.do" method="post">
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td align="center" width="20%">ҽ��֤�ţ�</td>
					<td align="left" width="30%">
						<input align="left" type=text name=hospitalNumber class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='hospitalNumber'/>">
					</td>
					<td align="center" width="20%">���֤�ţ�</td>
					<td align="left" width="30%">
						<input align="left" type=text name=identifyNumber class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='identifyNumber'/>">
					</td>
				</tr>
			</table>
			<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td  style="width:30px">����</td>
					<td >
						<input type=text name=insuredName class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='insuredName'/>">
					</td>
					<td  style="width:30px"> �Ա�</td>
					<td >
						<input type=text name=sex class="readonly" readonly="true" value="<%=sex%>">
						<input type=hidden name=sexCode value="<%=prpChospitalPersonDto.getSex()%>">
					</td>
					<td  style="width:30px">����</td>
					<td >
						<input type=text name=age class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='age'/>">
					</td>
					<td  style="width:50px">��ͥסַ</td>
					<td >
						<input type=text name=townName class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='townName'/>">
					</td>
					<td  style="width:10px">��</td>
					<td >
						<input type=text name=insuredAddress class="readonly" readonly="true" value="<bean:write name='prpChospitalPersonDto' property='insuredAddress'/>">
					</td>
					<td  style="width:50px">��ϵ�绰</td>
					<td >
						<input type=text name=phoneNumber onblur="checknumber(this);">
					</td>
				</tr>
				<tr>
					<td  style="width:50px">��סҽԺ</td>
					<td colspan="5">
						<input type=text name=hospitalName >
					</td>
					<td  style="width:50px">�Ʊ�</td>
					<td colspan="3">
						<input type=text name=hospitalItem >
					</td>
					<td  style="width:50px">סԺ��</td>
					<td colspan="3">
						<input type=text name=hospitalCode >
					</td>
				</tr>
				<tr>
					<td  style="width:50px">��Ժʱ��</td>
					<td colspan="4">
						<input type=text name=damageStartDate onblur="checkFullDate(this);calDays();">��
						<img src="/claim/images/bgMarkMustInput.jpg">
					</td>
					<td>YYYY-MM-DD<BR>��YYYYMMDD</td>
					<td  style="width:50px">��Ժʱ��</td>
					<td colspan="3">
						<input type=text name=damageEndDate onblur="checkFullDate(this);calDays();">��
						<img src="/claim/images/bgMarkMustInput.jpg">
					</td>
					<td colspan="2">YYYY-MM-DD<BR>��YYYYMMDD</td>
				</tr>
				<tr>
					<td  style="width:50px">סԺ����</td>
					<td colspan="11">
						<input type=text name=damageDays style="width:60px">��
					</td>
				</tr>
				<tr>
					<td  style="width:50px">���</td>
					<td colspan="11">
						<input type=text name=content style="width:650px">
					</td>
				</tr>
				<tr>
					<td colspan="12" align="center">
						<input type=button value="��һ��" name=nextStep onclick="submitForm();">
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