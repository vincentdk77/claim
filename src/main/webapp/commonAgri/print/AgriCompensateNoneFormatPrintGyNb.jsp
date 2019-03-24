<%--
****************************************************************************
* DESC       ：国元项目组农险赔款计算书打印数据初始化页面
* AUTHOR     ：冯雷
* CREATEDATE ：2007-12-12
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- 初始化 --%>
  <%@include file="AgriCompensateNoneFormatPrintGyNbIni.jsp"%>
<html>
  <head>
    <title><%=strRiskName%>赔款计算书</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
      <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="30" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="35"  align=center style="font-family:宋体; font-size:14pt;">
            <B><%=strRiskName%>赔款计算书<B>
          </td>
        </tr>
      </table>
      <table border="0" align="center" width="100%">
      <tr>
      	<td width="50%" align="left">
      	险种名称：<%=strRiskName%>
      	</td>
      	<td width="50%" align="right">
      	  赔款计算书号:<%=prpLcompensateDto.getCompensateNo()%>
      	</td>
          </tr>
       </table>
      <table border="1" width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
		  <tr align="center">
			<td height="30" width="12.5%">保险单号码</td>
			<td colspan="3" id="tdPolicyNo"  width="37.5%">&nbsp;</td>
			<td width="12.5%">批单号码</td>
			<td colspan="3" width="37.5%" id="tdEndorseNo">&nbsp;<%=strEndorseNo%></td>
		  </tr>
		  <tr align="center">
			<td  height="30">报案号码</td>
			<td colspan="3" >&nbsp;<%=RegistNo%></td>
			<td >立案号码</td>
			<td colspan="3" id="tdClaimNo">&nbsp;<%=strClaimNo %></td>
		  </tr>
		   <tr align="center">
			<td colspan="1">被保险人</td>
			<td colspan="7" height="30" id="tdInsuredName">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td  height="30">保险金额</td>
			<td colspan="3" id="tdSumAmount1">&nbsp;<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%></td>
			<td >保险标的</td>
			<td colspan="3" id="tdLossName">&nbsp;<%=prpLclaimDto.getLossName()%></td>
		  </tr>
		  <tr align="center">
			<td colspan="1">标的地址</td>
			<td colspan="7" height="30">&nbsp;<%=strInsuredAddress%></td>
		  </tr>
		  <tr align="center">
			<td colspan="1" >保险期限</td>
			<td colspan="7" id="tdInsuredDate" height="30">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td height="30">出险地点</td> 
			<td colspan="3" id="tdDamageAddress">&nbsp;</td>
			<td >出险日期</td>
			<td colspan="3" id="tdDamageStartDate">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="1">出险原因</td>
			<td colspan="7" height="30">&nbsp;<%=strDamageName %></td>
		  </tr>
		  <tr align="center">
			<td  width="15%" height="200">赔款计算方式</td>
			<td colspan="7" id="tdContext" align="left" valign="top">&nbsp;<%=strContext%></td>
		  </tr>
		  <tr align="left">
			<td colspan="8" height="30">&nbsp;&nbsp;赔款金额合计（大写）人民币：&nbsp;<%=strPkhjSumPaid%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥：&nbsp;<%=dbpkhjfee%>元</td>
		  </tr>
        <tr align="center">
			<td height="30">赔款核定</td>
			<td colspan="2">金额（元）</td>
			<td colspan="1">币别</td>
			<td colspan="4"  align="left" colspan="4" rowspan="5" valign="top">&nbsp;公司领导意见：<br><br><br><br><br><br><br><br><br><br><br><p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;</p></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">标的赔款</td>
			<td id="tdSumLoss">&nbsp;</td>
			<td id="tdCurrency2">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">第三者赔付</td>
			<td id="">&nbsp;---</td>
			<td id="">&nbsp;人民币</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">施救费</td>
			<td id="tdRescueFee">&nbsp;</td>
			<td id="tdMRescueFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">查勘费</td>
			<td id="tdCheckFee">&nbsp;</td>
			<td id="tdMCheckFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">检验鉴定费</td>
			<td id="tdJudgeFee">&nbsp;</td>
			<td id="tdMJudgeFee">&nbsp;</td>
			<td  width="25%" align="left"  colspan="2" rowspan="6" valign="top" id="tdHandlerName"></td>
			<td  width="25%" align="left"  colspan="2" rowspan="6" valign="top" id="tdUnderWriteName"></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">公估费</td>
			<td id="tdAssessFee">&nbsp;</td>
			<td id="tdMAssessFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">法律费</td>
			<td id="tdFlFee">&nbsp;</td>
			<td id="tdMFlFee">&nbsp;</td>
		  </tr>
		   <tr align="center">
			<td colspan="2" height="30">代查勘费</td>
			<td id="tdDCheckFee">&nbsp;</td>
			<td id=tdMDCheckFee>&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">其它</td>
			<td id="tdElseFee">&nbsp;</td>
			<td id="tdMElseFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">合计</td>
			<td id="tdSumPaid">&nbsp;</td>
			<td id="tdCurrency22">&nbsp;</td>
		  </tr>
    
      </table>
      
      
      <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="left"><%=strPayRefName%></td>
      		<td align="right"><%=strPayRefDate%></td>
      	</tr>
      </table>
 <%
    if(prpPheadDtoList!=null && prpPheadDtoList.size()>0){
     for(int i =0 ;i<prpPheadDtoList.size();i++)
     {
       PrpPheadDto prpPheadDto = (PrpPheadDto)endorseDto.getPrpPheadDtoList().get(i); 
       
       String EndorseNo = prpPheadDto.getEndorseNo();
       String strCompensateno = prpPheadDto.getCompensateNo();
       if(!(strCompensateno == null || strCompensateno.equals("")))
       {
       %>
	       <jsp:include page="/common/print/UIPtextShow.jsp">
	         <jsp:param name="EndorseNo" value="<%=EndorseNo%>"/>
	       </jsp:include>
       <%
       }
     }
     }  
     %>
	        <%-- include打印按钮 --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
  </body>

</html>
