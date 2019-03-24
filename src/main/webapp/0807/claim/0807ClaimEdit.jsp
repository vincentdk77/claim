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
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %><head>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.util.*"%>
<%@ page import="com.sinosoft.function.power.ui.action.UIPowerAction"%>


<%
RegistDto registDto = (RegistDto)request.getAttribute("registDto"); 
PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
PrpLacciPersonDto prpLacciPersonDto = registDto.getPrpLacciPersonDto();
String swfLogFlowID = (String)request.getAttribute("swfLogFlowID");
String swfLogLogNo = "2";
String strButtonSaveType = "4";
String sex="";
if(prpLacciPersonDto.getSex().equals("1"))
{
  sex="��";
}
else
{
  sex="Ů";
}

session.setAttribute("oldClaimLastAccessedTime","");
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
		<script src="/claim/commonAcci/claim/js/AcciClaimEdit.js"></script>
		<jsp:include page="/common/pub/StaticJavascript.jsp" />
		<script language="javascript">
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
        	alert("���ý������������֣�");
        }
      }
			function calFee()
			{
				var chuangweiFee     = 0;
				var chuangweiFee     = 0;
				var zhenliaoFee      = 0;
				var zhiliaoFee       = 0;
				var huliFee          = 0;
				var cailiaoFee       = 0;
				var jianchaFee       = 0;
				var huayanFee        = 0;
				var shepianFee       = 0;
				var qiangjiuFee      = 0;
				var shuxieFee        = 0;
				var yangqiFee        = 0;
				var xiyaoFee         = 0;
				var zhongchengyaoFee = 0;
				var zhongcaoyaoFee   = 0;
				var zifuFee          = 0;
				var qitaFee          = 0;
				var fee              = 0;
				var tichuFee         = 0;
				var buchangFee       = 0;
     
        chuangweiFee     = parseFloat(fm.chuangweiFee.value);
				zhenliaoFee      = parseFloat(fm.zhenliaoFee.value);
				zhiliaoFee       = parseFloat(fm.zhiliaoFee.value);
				huliFee          = parseFloat(fm.huliFee.value);
				cailiaoFee       = parseFloat(fm.cailiaoFee.value);
				jianchaFee       = parseFloat(fm.jianchaFee.value);
				huayanFee        = parseFloat(fm.huayanFee.value);
				shepianFee       = parseFloat(fm.shepianFee.value);
				qiangjiuFee      = parseFloat(fm.qiangjiuFee.value);
				shuxieFee        = parseFloat(fm.shuxieFee.value);
				yangqiFee        = parseFloat(fm.yangqiFee.value);
				xiyaoFee         = parseFloat(fm.xiyaoFee.value);
				zhongchengyaoFee = parseFloat(fm.zhongchengyaoFee.value);
				zhongcaoyaoFee   = parseFloat(fm.zhongcaoyaoFee.value);
				zifuFee          = parseFloat(fm.zifuFee.value);
				qitaFee          = parseFloat(fm.qitaFee.value);
				tichuFee         = parseFloat(fm.tichuFee.value);
				
				if(isNaN(chuangweiFee)) chuangweiFee = 0;        
				if(isNaN(zhenliaoFee)) zhenliaoFee = 0;          
				if(isNaN(zhiliaoFee)) zhiliaoFee = 0;            
				if(isNaN(huliFee)) huliFee = 0;                  
				if(isNaN(cailiaoFee)) cailiaoFee = 0;            
				if(isNaN(jianchaFee)) jianchaFee = 0;            
				if(isNaN(huayanFee)) huayanFee = 0;              
				if(isNaN(shepianFee)) shepianFee = 0;            
				if(isNaN(qiangjiuFee)) qiangjiuFee = 0;          
				if(isNaN(shuxieFee)) shuxieFee = 0;              
				if(isNaN(yangqiFee)) yangqiFee = 0;              
				if(isNaN(xiyaoFee)) xiyaoFee = 0;                
				if(isNaN(zhongchengyaoFee)) zhongchengyaoFee = 0;
				if(isNaN(zhongcaoyaoFee)) zhongcaoyaoFee = 0;    
				if(isNaN(zifuFee)) zifuFee = 0;                  
				if(isNaN(qitaFee)) qitaFee = 0;  
				if(isNaN(tichuFee)) tichuFee = 0;                
				
				fee = chuangweiFee + zhenliaoFee + zhiliaoFee + huliFee + cailiaoFee + jianchaFee + huayanFee + shepianFee + qiangjiuFee
				      + shuxieFee + yangqiFee + xiyaoFee + zhongchengyaoFee + zhongcaoyaoFee + zifuFee + qitaFee;
				      
				buchangFee = fee - tichuFee;
				
				fm.fee.value = point(round(fee,2),2);	
				fm.buchangFee.value = point(round(buchangFee,2),2);
			}
			
			function cal()
			{
				var fee = 0;
				var tichuFee = 0;
				var buchangFee = 0;
				
				fee = parseFloat(fm.fee.value);
				tichuFee = parseFloat(fm.tichuFee.value);
				if(isNaN(tichuFee)) tichuFee = 0;
				if(isNaN(fee))      fee = 0;
				
				buchangFee = fee - tichuFee;
				fm.buchangFee.value = point(round(buchangFee,2),2);
			}
			
			function submitForm()
			{
				if(fm.fee.value == "" || fm.fee.value == "0")
				{
					alert("��������ý�");
					return false;
				}
				if(parseFloat((fm.fee.value).replace(",",""))<=5000)
				{
					alert("סԺ��֧������5000Ԫ�����չ�˾���ò�����");
					return false;
				}
				fm.saveButton.disabled = true;
				fm.submit();
			}
		</script>
	</head>
	<body>
		<form name=fm action="/claim/0807claimSave.do" method="post">
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td align="center" width="20%">ҽ��֤�ţ�</td>
					<td align="left" width="30%">
						<input type=text name=hospitalNumber class="readonly" readonly="true" value="<%=prpLregistDto.getDamageTypeName()%>">
					</td>
					<td align="center" width="20%">���֤�ţ�</td>
					<td align="left" width="30%">
						<input type=text name=identifyNumber class="readonly" readonly="true" value="<%=prpLregistDto.getDamageName()%>">
					</td>
				</tr>
			</table>
			
			<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td  style="width:30px">����</td>
					<td >
						<input type=text name=insuredName class="readonly" readonly="true" value="<%=prpLacciPersonDto.getAcciName()%>">
					</td>
					<td  style="width:30px"> �Ա�</td>
					<td >
						<input type=text name=sex class="readonly" readonly="true" value="<%=sex%>">
						<input type=hidden name=sexCode value="<%=prpLacciPersonDto.getSex()%>">
					</td>
					<td  style="width:30px">����</td>
					<td >
						<input type=text name=age class="readonly" readonly="true" value="<%=prpLacciPersonDto.getAge()%>">
					</td>
					<td  style="width:50px">��ͥסַ</td>
					<td >
						<input type=text name=townName class="readonly" readonly="true" value="<%=prpLregistDto.getLicenseNo()%>">
					</td>
					<td  style="width:10px">��</td>
					<td >
						<input type=text name=insuredAddress class="readonly" readonly="true" value="<%=prpLregistDto.getInsuredAddress()%>">
					</td>
					<td  style="width:50px">��ϵ�绰</td>
					<td >
						<input type=text name=phoneNumber class="readonly" readonly="true" value="<%=prpLregistDto.getPhoneNumber()%>">
					</td>
				</tr>
				<tr>
					<td  style="width:50px">��סҽԺ</td>
					<td colspan="5">
						<input type=text name=hospitalName class="readonly" readonly="true" value="<%=prpLregistDto.getModelCode()%>">
					</td>
					<td  style="width:50px">�Ʊ�</td>
					<td colspan="3">
						<input type=text name=hospitalItem class="readonly" readonly="true" value="<%=prpLregistDto.getEngineNo()%>">
					</td>
					<td  style="width:50px">סԺ��</td>
					<td colspan="3">
						<input type=text name=hospitalCode class="readonly" readonly="true" value="<%=prpLregistDto.getFrameNo()%>">
					</td>
				</tr>
				<tr>
					<td  style="width:50px">��Ժʱ��</td>
					<td colspan="4">
						<input type=text name=damageStartDate class="readonly" readonly="true" value="<%=prpLregistDto.getDamageStartDate()%>">��
					</td>
					<td>YYYY-MM-DD<BR>��YYYYMMDD</td>
					<td  style="width:50px">��Ժʱ��</td>
					<td colspan="3">
						<input type=text name=damageEndDate class="readonly" readonly="true" value="<%=prpLregistDto.getDamageEndDate()%>">��
					</td>
					<td colspan="2">YYYY-MM-DD<BR>��YYYYMMDD</td>
				</tr>
				<tr>
					<td  style="width:50px">סԺ����</td>
					<td colspan="11">
						<input type=text name=damageDays style="width:60px" class="readonly" readonly="true" value="<%=prpLregistDto.getUseYears()%>">��
					</td>
				</tr>
				<tr>
					<td  style="width:50px">���</td>
					<td colspan="11">
						<input type=text name=content style="width:650px" class="readonly" readonly="true" value="<%=prpLregistDto.getBrandName()%>">
					</td>
				</tr>
			</table>
			<hr>
			<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td colspan="5">Ʊ�ݷ���Ǽ�</td>
					<td colspan="2">סԺ��֧��</td>
					<td>
						<input type=text name=fee onblur="checknumber(this);cal();">Ԫ
					</td>
				</tr>
				<tr>
					<td  style="width:50px">��λ��</td>
					<td colspan="1">
						<input type=text name=chuangweiFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">���Ʒ�</td>
					<td colspan="1">
						<input type=text name=zhenliaoFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">���Ʒ�</td>
					<td colspan="1">
						<input type=text name=zhiliaoFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">�����</td>
					<td colspan="1">
						<input type=text name=huliFee onblur="checknumber(this);calFee();">Ԫ
					</td>
				</tr>
				<tr>
					<td  style="width:50px">�������Ϸ�</td>
					<td colspan="1">
						<input type=text name=cailiaoFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">����</td>
					<td colspan="1">
						<input type=text name=jianchaFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">�����</td>
					<td colspan="1">
						<input type=text name=huayanFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">��Ƭ��</td>
					<td colspan="1">
						<input type=text name=shepianFee onblur="checknumber(this);calFee();">Ԫ
					</td>
				</tr>
				<tr>
					<td  style="width:50px">���ȷ�</td>
					<td colspan="1">
						<input type=text name=qiangjiuFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">��Ѫ��</td>
					<td colspan="1">
						<input type=text name=shuxieFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">������</td>
					<td colspan="1">
						<input type=text name=yangqiFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">��ҩ��</td>
					<td colspan="1">
						<input type=text name=xiyaoFee onblur="checknumber(this);calFee();">Ԫ
					</td>
				</tr>
				<tr>
					<td  style="width:50px">�г�ҩ��</td>
					<td colspan="1">
						<input type=text name=zhongchengyaoFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">�в�ҩ��</td>
					<td colspan="1">
						<input type=text name=zhongcaoyaoFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">�Ը���</td>
					<td colspan="1">
						<input type=text name=zifuFee onblur="checknumber(this);calFee();">Ԫ
					</td>
					<td  style="width:50px">������</td>
					<td colspan="1">
						<input type=text name=qitaFee onblur="checknumber(this);calFee();">Ԫ
					</td>
				</tr>
				<tr>
					<td style="width:100px" colspan="2">���޳����</td>
					<td colspan="2">
						<input type=text name=tichuFee onblur="checknumber(this);calFee();cal();">Ԫ
					</td>
					<td style="width:100px" colspan="2">�ɲ������</td>
					<td colspan="2">
						<input type=text name=buchangFee readonly="true">Ԫ
					</td>
				</tr>
				<tr>
					<td colspan="12" align="center">
						<input type=button value="����" name=saveButton onclick="submitForm();">
					</td>
				</tr>
			</table>
			<input type="hidden" name="buttonSaveType" value="<%=strButtonSaveType%>">
			<input type="hidden" name="swfLogFlowID" value="<%=swfLogFlowID%>">
			<input type="hidden" name="swfLogLogNo" value="<%=swfLogLogNo%>">
			<input type="hidden" name="prpLclaimRegistNo" value="<%=prpLregistDto.getRegistNo()%>">
			<input type="hidden" name="prpLclaimPolicyNo" value="<%=prpLregistDto.getPolicyNo()%>">
			<input type="hidden" name="prpLclaimClaimNo">
		</form>
	</body>
</html>