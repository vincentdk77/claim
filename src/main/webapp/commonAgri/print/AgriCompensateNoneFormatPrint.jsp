<%--
****************************************************************************
* DESC       ：农险赔款计算书打印页面
* AUTHOR     ：hanliang
* CREATEDATE ：2005-12-12
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
  <%@include file="AgriCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title><%=strRiskName%>赔款计算书</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:宋体; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="40"  align=center style="font-family:宋体; font-size:14pt;">
            <B><%=strRiskName%>赔款计算书<B>
          </td>
        </tr>
      </table>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;赔款计算书号:<%=prpLcompensateDto.getCompensateNo()%>
      
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">

		  <tr align="center">
			<td colspan="2" height="30" width="15%">保险单号码</td>
			<td colspan="3" id="tdPolicyNo"  width="30%">&nbsp;</td>
			<td  width="15%">赔案编号 </td>
			<td colspan="2" id="tdClaimNo">&nbsp;<%=strClaimNo%></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">被保险人</td>
			<td colspan="3" id="tdInsuredName">&nbsp;</td>
			<td  width="15%">批单号码</td>
			<td colspan="2" id="tdEndorseNo">&nbsp;<%=strEndorseNo%></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">保险金额</td>
			<td colspan="3" id="tdSumAmount1">&nbsp;<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%></td>
			<td  width="15%">保险标的</td>
			<td colspan="2" id="tdLossName">&nbsp;<%=prpLclaimDto.getLossName()%></td>
		  </tr>
		  <!--
		  deleted by zhangli 20070521
		  <tr align="center">
			<td colspan="2">被保险人地址：</td>
			<td colspan="7" height="30">&nbsp;<%=strInsuredAddress%></td>
		  </tr>
		  -->
		  <tr align="center">
			<td colspan="2" >保险期限</td>
			<td colspan="7" id="tdInsuredDate" height="30">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">出险地点</td> 
			<td colspan="3" id="tdDamageAddress">&nbsp;</td>
			<td  width="15%">出险日期</td>
			<td colspan="2" id="tdDamageStartDate">&nbsp;</td>
		  </tr>
		  <!--modified by zhangli 20070511-->
		 
		  <tr align="center">
			<td colspan="2" height="30">被保险人开户银行</td>
			<td colspan="3" id="bank">&nbsp;<%=prpLcompensateDto.getBank()%></td>
			<td  width="15%">支付帐号</td>
			<td colspan="2" id="account">&nbsp;<%=prpLcompensateDto.getAccount()%></td>
		  </tr>	 
		  <!--add by zhangli 20070521-->  
		  <tr align="center">
			<td colspan="2">收款人全称：</td>
			<td colspan="7" height="30">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>
		  </tr>
		  <tr align="center">
			<td  width="3%" height="250">赔款计算方式</td>
			<td colspan="7" id="tdContext" align="left" valign="top">&nbsp;<%=strContext%></td>
		  </tr>
		  <tr align="left">
			<td colspan="8" height="30">&nbsp;&nbsp;赔款金额合计（大写）人民币：&nbsp;<%=strPkhjSumPaid%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(小写)￥：&nbsp;<%=dbpkhjfee%>元</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">赔款核定</td>
			<td >金额</td>
			<td >币种</td>
			<td colspan="3" rowspan="5" align="left" valign="top" id="tdHandlerName"></td>
			<td width="33%" rowspan="5" align="left" valign="top" id="tdUnderWriteName"></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">标的赔款</td>
			<td id="tdSumLoss">&nbsp;</td>
			<td id="tdCurrency2">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">第三者赔付</td>
			<td id="">&nbsp;</td>
			<td id="">&nbsp;</td>
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
			<td colspan="4" rowspan="6" align="left" valign="top">&nbsp;总经理室意见：<br><br><br><br><br><br><br><br><br><br><br><p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;</p></td>
			
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">共损救助费</td>
			<td id="tdGsjzFee">&nbsp;</td>
			<td id="tdMGsjzFee">&nbsp;</td>
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
      
      
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
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
