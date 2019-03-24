<%--
****************************************************************************
* DESC       ：理算页面
* AUTHOR     ： 
* CREATEDATE ： 2007-05-22
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>

<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="com.sinosoft.utility.*"%>
<%@ page import="com.sinosoft.utility.string.*"%>
<%@ page import="com.sinosoft.utility.string.Str"%>
<%@ page import="com.sinosoft.utility.string.Date"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="com.sinosoft.claim.ui.control.action.*"%>
<%@ page import="com.sinosoft.claim.dto.custom.*"%>
<%@ page import="com.sinosoft.claim.dto.domain.*"%>
<%@ page import="com.sinosoft.sysframework.reference.*"%>
<%@ page import="com.sinosoft.claim.util.*"%>
<%@ page import="com.sinosoft.function.power.ui.action.UIPowerAction"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLRegistFacade"%>
<%@ page import="com.sinosoft.claim.bl.facade.BLClaimFacade"%>

<%
String strClaimNo = (String)request.getAttribute("claimNo");
String strRegistNo = (String)request.getAttribute("registNo");
BLRegistFacade blRegistFacade = new BLRegistFacade();
RegistDto registDto = blRegistFacade.findByPrimaryKey(strRegistNo);
BLClaimFacade blClaimFacade = new BLClaimFacade();
ClaimDto claimDto = blClaimFacade.findByPrimaryKey(strClaimNo);
PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
PrpLpersonDto prpLpersonDtotemp = (PrpLpersonDto)claimDto.getPrpLpersonDtoList().get(0);
String sex="";
if(prpLpersonDtotemp.getPersonSex().equals("1"))
{
  sex="男";
}
else
{
  sex="女";
}

String compensateNo = (String)request.getAttribute("compensateNo");
if(compensateNo==null)
{
  compensateNo = "";
}
String swfLogFlowID = (String)request.getAttribute("swfLogFlowID");
String swfLogLogNo = (String)request.getAttribute("swfLogLogNo");
if(swfLogLogNo==null)
{
  swfLogLogNo = "3";
}
String strButtonSaveType = "4";
String strPolicyNo = prpLregistDto.getPolicyNo();

String strchuangweiFee    ="";
String strzhenliaoFee     ="";
String strzhiliaoFee      ="";
String strhuliFee         ="";
String strcailiaoFee      ="";
String strjianchaFee      ="";
String strhuayanFee       ="";
String strshepianFee      ="";
String strqiangjiuFee     ="";
String strshuxieFee       ="";
String stryangqiFee       ="";
String strxiyaoFee        ="";
String strzhongchengyaoFee="";
String strzhongcaoyaoFee  ="";
String strzifuFee         ="";
String strqitaFee         ="";
String strfee             ="";
String strtichuFee        ="";
String strbuchangFee      ="";


PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
strfee = "" + new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumClaim());
strbuchangFee = "" + new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumDefLoss());
strtichuFee = "" + new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumClaim()-prpLclaimDto.getSumDefLoss());
int i = 0;
for(i=0;i<claimDto.getPrpLpersonDtoList().size();i++)
{
  PrpLpersonDto prpLpersonDto = new PrpLpersonDto();
  prpLpersonDto = (PrpLpersonDto)claimDto.getPrpLpersonDtoList().get(i);
  if(prpLpersonDto.getFeeTypeCode().equals("01"))   strchuangweiFee    = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("02"))   strzhenliaoFee     = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("03"))   strzhiliaoFee      = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("04"))   strhuliFee         = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("05"))   strcailiaoFee      = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("06"))   strjianchaFee      = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("07"))   strhuayanFee       = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("08"))   strshepianFee      = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("09"))   strqiangjiuFee     = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("10"))   strshuxieFee       = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("11"))   stryangqiFee       = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("12"))   strxiyaoFee        = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("13"))   strzhongchengyaoFee= "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("14"))   strzhongcaoyaoFee  = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("15"))   strzifuFee         = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
  if(prpLpersonDto.getFeeTypeCode().equals("16"))   strqitaFee         = "" + new DecimalFormat("#,##0.00").format(prpLpersonDto.getSumLoss());
}

double hospitalFee = 0d;
double fee0102 = 0d;
double fee0101 = 0d;
double fee01   = 0d;
double fee0202 = 0d;
double fee0201 = 0d;
double fee02   = 0d;
double fee0302 = 0d;
double fee0301 = 0d;
double fee03   = 0d;
double fee0402 = 0d;
double fee04   = 0d;
double quFee   = 0d;
double anxinFee= 0d;
double payFee  = 0d;
hospitalFee = prpLclaimDto.getSumDefLoss();
if(hospitalFee>45000)
{
  fee0402 = (hospitalFee - 45000)*0.9;
  fee0402 = Str.round(fee0402,1);
  fee04   = fee0402;
  fee0302 = 2750;
  fee0301 = 1750;
  fee03   = 4500;
  fee0202 = 3500;
  fee0201 = 3500;
  fee02   = 7000;
  fee0102 = 6250;
  fee0101 = 8750;
  fee01   = 15000;
} 
if(hospitalFee>40000 && hospitalFee<=45000)
{
  fee0302 = (hospitalFee - 40000)*0.55;
  fee0301 = (hospitalFee - 40000)*0.35;
  fee0302 = Str.round(fee0302,1);
  fee0301 = Str.round(fee0301,1);
  fee03   = fee0302 + fee0301;
  fee0202 = 3500;
  fee0201 = 3500;
  fee02   = 7000;
  fee0102 = 6250;
  fee0101 = 8750;
  fee01   = 15000;
}
if(hospitalFee>30000 && hospitalFee<=40000)
{
  fee0202 = (hospitalFee - 30000)*0.35;
  fee0201 = (hospitalFee - 30000)*0.35;
  fee0202 = Str.round(fee0202,1);
  fee0201 = Str.round(fee0201,1);
  fee02   = fee0202 + fee0201;
  fee0102 = 6250;
  fee0101 = 8750;
  fee01   = 15000;
}
if(hospitalFee>5000 && hospitalFee<=30000)
{
  fee0102 = (hospitalFee - 5000)*0.25;
  fee0101 = (hospitalFee - 5000)*0.35;
  fee0102 = Str.round(fee0102,1);
  fee0101 = Str.round(fee0101,1);
  fee01   = fee0102 + fee0101;
}
quFee    = fee0102 + fee0202 + fee0302 + fee0402;
anxinFee = fee0101 + fee0201 + fee0301;
payFee   = quFee + anxinFee;

quFee = Str.round(quFee,1);
anxinFee = Str.round(anxinFee,1);
payFee = Str.round(payFee,1);

String strfee0102  = "";
String strfee0101  = "";
String strfee01    = "";
String strfee0202  = "";
String strfee0201  = "";
String strfee02    = "";
String strfee0302  = "";
String strfee0301  = "";
String strfee03    = "";
String strfee0402  = "";
String strfee04    = "";
String strquFee    = "";
String stranxinFee = "";
String strpayFee   = "";

strquFee    = "" + new DecimalFormat("#,##0.00").format(quFee);
stranxinFee = "" + new DecimalFormat("#,##0.00").format(anxinFee);
strpayFee   = "" + new DecimalFormat("#,##0.00").format(payFee);

if(fee0102 != 0) strfee0102 = "" + new DecimalFormat("#,##0.00").format(fee0102);
if(fee0101 != 0) strfee0101 = "" + new DecimalFormat("#,##0.00").format(fee0101);
if(fee01   != 0) strfee01   = "" + new DecimalFormat("#,##0.00").format(fee01  );
if(fee0202 != 0) strfee0202 = "" + new DecimalFormat("#,##0.00").format(fee0202);
if(fee0201 != 0) strfee0201 = "" + new DecimalFormat("#,##0.00").format(fee0201);
if(fee02   != 0) strfee02   = "" + new DecimalFormat("#,##0.00").format(fee02  );
if(fee0302 != 0) strfee0302 = "" + new DecimalFormat("#,##0.00").format(fee0302);
if(fee0301 != 0) strfee0301 = "" + new DecimalFormat("#,##0.00").format(fee0301);
if(fee03   != 0) strfee03   = "" + new DecimalFormat("#,##0.00").format(fee03  );
if(fee0402 != 0) strfee0402 = "" + new DecimalFormat("#,##0.00").format(fee0402);
if(fee04   != 0) strfee04   = "" + new DecimalFormat("#,##0.00").format(fee04  );

session.setAttribute("oldCompensateLastAccessedTime","");
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <script src="/claim/commonAcci/compensate/js/AcciCompensateEdit.js"></script>
    <script src="/claim/commonAcci/compensate/js/AcciPersonLossEdit.js"></script>
    <jsp:include page="/common/pub/StaticJavascript.jsp" />
    <script language="javascript">
    	function calFee()
    	{
    		var fee0102 = 0;
    		var fee0101 = 0;
    		var fee0202 = 0;
    		var fee0201 = 0;
    		var fee0302 = 0;
    		var fee0301 = 0;
    		var fee0402 = 0;
    		
    		var fee01 = 0;
    		var fee02 = 0;
    		var fee03 = 0;
    		var fee04 = 0;
    		
    		var quFee = 0;
    		var anxinFee = 0;
    		var payFee = 0;
    		
    		fee0102 = parseFloat((fm.fee0102.value).replace(",","")); 		    		
    		fee0101 = parseFloat((fm.fee0101.value).replace(",",""));
    		fee0202 = parseFloat((fm.fee0202.value).replace(",",""));
    		fee0201 = parseFloat((fm.fee0201.value).replace(",",""));
    		fee0302 = parseFloat((fm.fee0302.value).replace(",",""));
    		fee0301 = parseFloat((fm.fee0301.value).replace(",",""));
    		fee0402 = parseFloat((fm.fee0402.value).replace(",",""));
    		
    		if(isNaN(fee0102)) fee0102 = 0;
    		if(isNaN(fee0101)) fee0101 = 0;
    		if(isNaN(fee0202)) fee0202 = 0;
    		if(isNaN(fee0201)) fee0201 = 0;
    		if(isNaN(fee0302)) fee0302 = 0;
    		if(isNaN(fee0301)) fee0301 = 0;
    		if(isNaN(fee0402)) fee0402 = 0;
    		
    		fee01 = fee0102 + fee0101;
    		fee02 = fee0202 + fee0201;
    		fee03 = fee0302 + fee0301;
    		fee04 = fee0402;
    		
    		quFee = fee0102 + fee0202 + fee0302 + fee0402;
    		anxinFee = fee0101 + fee0201 + fee0301;
    		payFee = quFee + anxinFee;
    		
    		fm.fee01.value = point(round(fee01,1),2);	
    		fm.fee02.value = point(round(fee02,1),2);
    		fm.fee03.value = point(round(fee03,1),2);
    		fm.fee04.value = point(round(fee04,1),2);
    		fm.quFee.value = point(round(quFee,1),2);
    		fm.anxinFee.value = point(round(anxinFee,1),2);
    		fm.payFee.value = point(round(payFee,1),2);
    	} 
    	function cal()
    	{
    		var fee0102 = 0;
    		var fee0101 = 0;
    		var fee0202 = 0;
    		var fee0201 = 0;
    		var fee0302 = 0;
    		var fee0301 = 0;
    		var fee0402 = 0;
    		
    		var fee01 = 0;
    		var fee02 = 0;
    		var fee03 = 0;
    		var fee04 = 0;
    		
    		var quFee = 0;
    		var anxinFee = 0;
    		var payFee = 0;
    		var fee = 0;
    		var zongFee = 0;
    		var tichuFee = 0;
    		
    		zongFee = parseFloat((fm.fee.value).replace(",",""));
    		tichuFee = parseFloat((fm.tichuFee.value).replace(",",""));
    		if(isNaN(zongFee)) zongFee = 0;
    		if(isNaN(tichuFee)) tichuFee = 0;
    		fee = zongFee - tichuFee;

    		fm.buchangFee.value = point(round(fee,1),2);
    		
    		if(fee>45000)
        {
           fee0402 = (fee - 45000)*0.9;
           fee04   = fee0402;
           fee0302 = 2750;
           fee0301 = 1750;
           fee03   = 4500;
           fee0202 = 3500;
           fee0201 = 3500;
           fee02   = 7000;
           fee0102 = 6250;
           fee0101 = 8750;
           fee01   = 15000;
        }
        if(fee>40000 && fee<=45000)
        {
           fee0302 = (fee - 40000)*0.55;
           fee0301 = (fee - 40000)*0.35;
           fee03   = (fee - 40000)*0.90;
           fee0202 = 3500;
           fee0201 = 3500;
           fee02   = 7000;
           fee0102 = 6250;
           fee0101 = 8750;
           fee01   = 15000;
        }
        if(fee>30000 && fee<=40000)
        {
           fee0202 = (fee - 30000)*0.35;
           fee0201 = (fee - 30000)*0.35;
           fee02   = (fee - 30000)*0.70;
           fee0102 = 6250;
           fee0101 = 8750;
           fee01   = 15000;
        }
        if(fee>5000 && fee<=30000)
        {
           fee0102 = (fee - 5000)*0.25;
           fee0101 = (fee - 5000)*0.35;
           fee01   = (fee - 5000)*0.60;
        }
        fee01 = fee0102 + fee0101;
    		fee02 = fee0202 + fee0201;
    		fee03 = fee0302 + fee0301;
    		fee04 = fee0402;
        
    		quFee    = fee0102 + fee0202 + fee0302 + fee0402;
        anxinFee = fee0101 + fee0201 + fee0301;
        payFee   = quFee + anxinFee;
        
        
        fm.fee0102.value = point(round(fee0102,1),2);	
        fm.fee0101.value = point(round(fee0101,1),2);	
        fm.fee0202.value = point(round(fee0202,1),2);	
        fm.fee0201.value = point(round(fee0201,1),2);	
        fm.fee0302.value = point(round(fee0302,1),2);	
        fm.fee0301.value = point(round(fee0301,1),2);	
        fm.fee0402.value = point(round(fee0402,1),2);	
        
        fm.fee01.value = point(round(fee01,1),2);	
    		fm.fee02.value = point(round(fee02,1),2);
    		fm.fee03.value = point(round(fee03,1),2);
    		fm.fee04.value = point(round(fee04,1),2);
    		
    		fm.quFee.value = point(round(quFee,1),2);
    		fm.anxinFee.value = point(round(anxinFee,1),2);
    		fm.payFee.value = point(round(payFee,1),2);
    	}
    	function submitForm()
    	{ 
    		fm.saveButton.disabled = true;
				fm.submit();
    	} 
    </script>	
	</head>
	<body>
		<form name=fm action="/claim/0807compensateSave.do" method="post">
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td align="center" width="20%">医疗证号：</td>
					<td align="left" width="30%">
						<input type=text name=hospitalNumber class="readonly" readonly="true" value="<%=prpLregistDto.getDamageTypeName()%>">
					</td>
					<td align="center" width="20%">身份证号：</td>
					<td align="left" width="30%">
						<input type=text name=identifyNumber class="readonly" readonly="true" value="<%=prpLregistDto.getDamageName()%>">
					</td>
				</tr>
			</table>
			<table border="0" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td align="left">报案号为：</td>
					<td align="left"><%=strRegistNo%></td>
					<td align="right">立案号为：</td>
					<td align="center"><%=strClaimNo%></td>
				</tr>
			</table>
			<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td  style="width:30px">姓名</td>
					<td >
						<input type=text name=insuredName class="readonly" readonly="true" value="<%=prpLpersonDtotemp.getPersonName()%>">
					</td>
					<td  style="width:30px"> 性别</td>
					<td >
						<input type=text name=sex class="readonly" readonly="true" value="<%=sex%>">
						<input type=hidden name=sexCode value="<%=prpLpersonDtotemp.getPersonSex()%>">
					</td>
					<td  style="width:30px">年龄</td>
					<td >
						<input type=text name=age class="readonly" readonly="true" value="<%=prpLpersonDtotemp.getPersonAge()%>">
					</td>
					<td  style="width:50px">家庭住址</td>
					<td >
						<input type=text name=townName class="readonly" readonly="true" value="<%=prpLregistDto.getLicenseNo()%>">
					</td>
					<td  style="width:10px">镇</td>
					<td >
						<input type=text name=insuredAddress class="readonly" readonly="true" value="<%=prpLregistDto.getInsuredAddress()%>">
					</td>
					<td  style="width:50px">联系电话</td>
					<td >
						<input type=text name=phoneNumber class="readonly" readonly="true" value="<%=prpLregistDto.getPhoneNumber()%>">
					</td>
				</tr>
				<tr>
					<td  style="width:50px">所住医院</td>
					<td colspan="5">
						<input type=text name=hospitalName class="readonly" readonly="true" value="<%=prpLregistDto.getModelCode()%>">
					</td>
					<td  style="width:50px">科别</td>
					<td colspan="3">
						<input type=text name=hospitalItem class="readonly" readonly="true" value="<%=prpLregistDto.getEngineNo()%>">
					</td>
					<td  style="width:50px">住院号</td>
					<td colspan="3">
						<input type=text name=hospitalCode class="readonly" readonly="true" value="<%=prpLregistDto.getFrameNo()%>">
					</td>
				</tr>
				<tr>
					<td  style="width:50px">入院时间</td>
					<td colspan="4">
						<input type=text name=damageStartDate class="readonly" readonly="true" value="<%=prpLregistDto.getDamageStartDate()%>">日
					</td>
					<td>YYYY-MM-DD<BR>或YYYYMMDD</td>
					<td  style="width:50px">出院时间</td>
					<td colspan="3">
						<input type=text name=damageEndDate class="readonly" readonly="true" value="<%=prpLregistDto.getDamageEndDate()%>">日
					</td>
					<td colspan="2">YYYY-MM-DD<BR>或YYYYMMDD</td>
				</tr>
				<tr>
					<td  style="width:50px">住院天数</td>
					<td colspan="11">
						<input type=text name=damageDays style="width:60px" class="readonly" readonly="true" value="<%=prpLregistDto.getUseYears()%>">日
					</td>
				</tr>
				<tr>
					<td  style="width:50px">诊断</td>
					<td colspan="11">
						<input type=text name=content style="width:650px" class="readonly" readonly="true" value="<%=prpLregistDto.getBrandName()%>">
					</td>
				</tr>
			</table>
			
			<hr>
			
			<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td colspan="5">票据分类登记</td>
					<td colspan="2">住院总支出</td>
					<td>
						<input type=text name=fee  value="<%=strfee%>" onblur="cal();">元
					</td>
				</tr>
				<tr>
					<td  style="width:50px">床位费</td>
					<td colspan="1">
						<input type=text name=chuangweiFee class="readonly" readonly="true" value="<%=strchuangweiFee%>">元
					</td>
					<td  style="width:50px">诊疗费</td>
					<td colspan="1">
						<input type=text name=zhenliaoFee class="readonly" readonly="true" value="<%=strzhenliaoFee%>">元
					</td>
					<td  style="width:50px">治疗费</td>
					<td colspan="1">
						<input type=text name=zhiliaoFee class="readonly" readonly="true" value="<%=strzhiliaoFee%>">元
					</td>
					<td  style="width:50px">护理费</td>
					<td colspan="1">
						<input type=text name=huliFee class="readonly" readonly="true" value="<%=strhuliFee%>">元
					</td>
				</tr>
				<tr>
					<td  style="width:50px">手术材料费</td>
					<td colspan="1">
						<input type=text name=cailiaoFee class="readonly" readonly="true" value="<%=strcailiaoFee%>">元
					</td>
					<td  style="width:50px">检查费</td>
					<td colspan="1">
						<input type=text name=jianchaFee class="readonly" readonly="true" value="<%=strjianchaFee%>">元
					</td>
					<td  style="width:50px">化验费</td>
					<td colspan="1">
						<input type=text name=huayanFee class="readonly" readonly="true" value="<%=strhuayanFee%>">元
					</td>
					<td  style="width:50px">摄片费</td>
					<td colspan="1">
						<input type=text name=shepianFee class="readonly" readonly="true" value="<%=strshepianFee%>">元
					</td>
				</tr>
				<tr>
					<td  style="width:50px">抢救费</td>
					<td colspan="1">
						<input type=text name=qiangjiuFee class="readonly" readonly="true" value="<%=strqiangjiuFee%>">元
					</td>
					<td  style="width:50px">输血费</td>
					<td colspan="1">
						<input type=text name=shuxieFee class="readonly" readonly="true" value="<%=strshuxieFee%>">元
					</td>
					<td  style="width:50px">氧气费</td>
					<td colspan="1">
						<input type=text name=yangqiFee class="readonly" readonly="true" value="<%=stryangqiFee%>">元
					</td>
					<td  style="width:50px">西药费</td>
					<td colspan="1">
						<input type=text name=xiyaoFee class="readonly" readonly="true" value="<%=strxiyaoFee%>">元
					</td>
				</tr>
				<tr>
					<td  style="width:50px">中成药费</td>
					<td colspan="1">
						<input type=text name=zhongchengyaoFee class="readonly" readonly="true" value="<%=strzhongchengyaoFee%>">元
					</td>
					<td  style="width:50px">中草药费</td>
					<td colspan="1">
						<input type=text name=zhongcaoyaoFee class="readonly" readonly="true" value="<%=strzhongcaoyaoFee%>">元
					</td>
					<td  style="width:50px">自负费</td>
					<td colspan="1">
						<input type=text name=zifuFee class="readonly" readonly="true" value="<%=strzifuFee%>">元
					</td>
					<td  style="width:50px">其他费</td>
					<td colspan="1">
						<input type=text name=qitaFee class="readonly" readonly="true" value="<%=strqitaFee%>">元
					</td>
				</tr>
				<tr>
					<td style="width:100px" colspan="2">需剔除金额</td>
					<td colspan="2">
						<input type=text name=tichuFee value="<%=strtichuFee%>" onblur="cal();">元
					</td>
					<td style="width:100px" colspan="2">可补偿金额</td>
					<td colspan="2">
						<input type=text name=buchangFee class="readonly" readonly="true" value="<%=strbuchangFee%>">元
					</td>
				</tr>
			</table>
			
			<hr>
			
			<table border="1" align="center" cellpadding="4" cellspacing="1" class="common">
				<tr>
					<td align="left" colspan="4">属区级可补偿分段计算<td>
				</tr>
				<tr>
					<td align="center">医疗费可补偿<br>费用段</td>
					<td align="center">区合作医疗</td>
					<td align="center">国元保险公司</td>
					<td align="center">总补偿比例</td>
				</tr>
				<tr>
					<td align="center">5001-30000元</td>
					<td align="center">
						<input type=text name="fee0102"  readonly="true" value="<%=strfee0102%>" onblur="calFee();">元(按25%补偿)
					</td>
					<td align="center">
						<input type=text name="fee0101"   readonly="true" value="<%=strfee0101%>" onblur="calFee();">元(按35%补偿)
					</td>
					<td align="center">
						<input type=text name="fee01"   readonly="true" value="<%=strfee01%>">元(按60%补偿)
					</td>
			  </tr>
			  <tr>
					<td align="center">30001-40000元</td>
					<td align="center">
						<input type=text name="fee0202"  readonly="true" value="<%=strfee0202%>" onblur="calFee();">元(按35%补偿)
					</td>
					<td align="center">
						<input type=text name="fee0201"  readonly="true" value="<%=strfee0201%>" onblur="calFee();">元(按35%补偿)
					</td>
					<td align="center">
						<input type=text name="fee02"  readonly="true" value="<%=strfee02%>">元(按70%补偿)
					</td>
			  </tr>
			  <tr>
					<td align="center">40001-45000元</td>
					<td align="center">
						<input type=text name="fee0302"  readonly="true" value="<%=strfee0302%>" onblur="calFee();">元(按55%补偿)
					</td>
					<td align="center">
						<input type=text name="fee0301"  readonly="true" value="<%=strfee0301%>" onblur="calFee();">元(按35%补偿)
					</td>
					<td align="center">
						<input type=text name="fee03"   readonly="true" value="<%=strfee03%>">元(按90%补偿)
					</td>
			  </tr>
			  <tr>
					<td align="center">45000元以上</td>
					<td align="center">
						<input type=text name="fee0402"   readonly="true" value="<%=strfee0402%>" onblur="calFee();">元(按90%补偿)
					</td>
					<td align="center"></td>
					<td align="center">
						<input type=text name="fee04"   readonly="true" value="<%=strfee04%>">元(按90%补偿)
					</td>
			  </tr>
			  <tr>
			  	<td align="center">合  计</td>
			  	<td align="center">
			  		<input type=text name="quFee"  readonly="true" value="<%=strquFee%>">
			  	</td>
			  	<td align="center">
			  		<input type=text name="anxinFee"   readonly="true" value="<%=stranxinFee%>">
			  	</td>
			  	<td align="center">
			  		<input type=text name="payFee" readonly="true"  value="<%=strpayFee%>">
			  	</td>
			  </tr>
			  <tr>
					<td colspan="4" align="center">
						<input type=button value="确定" name=saveButton onclick="submitForm();">
					</td>
				</tr>
			</table>
			<input type="hidden" name="buttonSaveType" value="<%=strButtonSaveType%>">
			<input type="hidden" name="swfLogFlowID" value="<%=swfLogFlowID%>">
			<input type="hidden" name="swfLogLogNo" value="<%=swfLogLogNo%>">
			<input type="hidden" name="prpLcompensateCompensateNo" value="<%=compensateNo%>">
			<input type="hidden" name="prpLcompensateClaimNo" value="<%=strClaimNo%>">
			<input type="hidden" name="prpLcompensatePolicyNo" value="<%=strPolicyNo%>">
		</form>
	</body>
</html>