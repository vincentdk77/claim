<%--
****************************************************************************
* DESC       ：机动车辆保险赔款计算书打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：22004-11-16
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
  <%@include file="LiabCompensateNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title><%=strRiskName%>赔款计算书打印</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- 标题部分 -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="3" height="40" align=center style="font-family:宋体; font-size:14pt;">
                <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>      
        <tr>
          <td colspan="3" height="40" align=center style="font-family:宋体; font-size:14pt;">
            <B><%=strRiskName%>赔款理算书<B><br>
          </td>
        </tr>

        <tr>
         
          <td width="50%" align=left id="tdCompensateNo" style="font-family:宋体; font-size:10pt;">
            赔款计算书号：
1         </td>
 <td width="50%" align=left style="font-family:宋体; font-size:10pt;">
            
          </td>
        </tr>
      </table>

      <!-- 主体部分 -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
  <tr align="center">
    <td width="12%">赔案编号</td>
    <td colspan="2" id="tdClaimNo">&nbsp;</td>
    <td width="12%" height="30">被保险人</td>
    <td colspan="3" id="tdInsuredName">&nbsp;</td>

  </tr>
  <tr align="center">
    <td width="12%" height="30" >保单号码</td>
    <td colspan="2" id="tdPolicyNo" >&nbsp;</td>
    <td width="12%">出险时间</td>
    <td colspan="3" id="tdDamageStartDate">&nbsp;</td>   
       
    <td width="12%" style="display:none;">险&nbsp;&nbsp;&nbsp;&nbsp;别</td>
    <td colspan="3" id="tdRiskName" style="display:none;">&nbsp;</td>
  </tr>
  <tr align="center">
    <td width="12%" height="30" style="display:none;">批&nbsp;单&nbsp;号</td>
    <td colspan="2" id="tdEndorseNo" style="display:none;">&nbsp;</td>
    
    <td width="12%" height="30">保险金额</td>
    <td colspan="2" id="tdOldSumAmount">&nbsp;</td>
    <td width="12%" height="30">出险地点</td>
    <td colspan="3" id="tdDamageAddress">&nbsp;</td>

  </tr>
  <tr align="center">    
    <td width="12%" height="30">有效保额</td>
    <td colspan="2" id="tdSumAmount">&nbsp;</td>
    <td width="12%">出险原因</td>
    <td colspan="3" id="tdDamageName">&nbsp;</td>
  </tr>
  <tr align="center">
    <td width="12%" height="30" style="display:none;">赔偿限额</td>
    <td colspan="3" id="tdSumAmount2" style="display:none;">&nbsp;</td>
    
    <td width="12%" height="30" >保险期限</td>
    <td colspan="2" id="tdInsuredDate" >&nbsp;</td>    
    <td width="12%">保险标的</td>
    <td colspan="3" id="tdLossName">&nbsp;</td>
  </tr>
  <tr align="center" >
    <td width="12%" height="30">被保险人开户银行</td>
    <td colspan="3" id="bank">&nbsp;<%=prpLcompensateDto.getBank()%></td>
    <td width="12%">支付帐号</td>
    <td colspan="2" id="account">&nbsp;<%=prpLcompensateDto.getAccount()%></td>
  </tr>
  <tr align="center" >
          <td width="15%" height="30" >收款人全称</td>
          <td id="bank"  colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>    
          <td width="15%" align="left" ></td>     
          <td id="account" align=left  colspan="2"></td>          
        </tr> 
  <tr align="center">
    <td height="140" colspan="7" id="tdContext" valign="top" align="left">计算公式及结果：</td>
  </tr>
  <tr align="center" style="display:none;">
    <td width="12%" height="30">人身伤亡</td>
    <td colspan="2" id="tdPersonSumLossPay">&nbsp;</td>
    <td width="12%">财产损失</td>
    <td colspan="3" id="tdPropSumLossPay">&nbsp;</td>
  </tr>
  <tr align="center" style="display:none;">
    <td width="12%" height="30">诉讼费用</td>

    <td colspan="2">&nbsp;</td>
    
    <td width="12%">其它费用</td>

    <td colspan="3">&nbsp;</td>
    
  </tr>
  <tr align="center" style="display:none;">
    <td colspan="7" height="30" id="tdCSumLossPay" align="left">责任赔款</td>
  </tr>
  <tr align="center" style="display:none;">
    <td colspan="2" rowspan="5" valign="top" align="left" id=" " ></td>
    <td colspan="3" rowspan="5" valign="top" align="left" id="   " ></td>
    <td colspan="2" height="30">赔款支出</td>
  </tr>
  <tr style="display:none;">
    <td width="12%" align="center" height="30">责任赔款</td>
    <td width="17%" align="center" id=" ">&nbsp;</td>
  </tr>
  
  <tr align="center" >
    <td rowspan="4">本案责任</td>
    <td width="12%" align="center" height="30">保险标的损失</td>
    <td width="17%" align="center" id="tdSSumLossPay" colspan="2">&nbsp;</td> 
    <td width="12%" height="30">合计金额</td>
    <td width="17%" id="tdSSumPaid" colspan="2">&nbsp;</td>   
  </tr>

  <tr align="center">
    <td width="12%" align="center" height="30">施救费用</td>
    <td width="17%" align="center" id="tdRescueFee" colspan="2">&nbsp;</td>
    <td width="12%" align="center" height="30">&nbsp;</td>
    <td width="17%" align="center" id=" " colspan="2">&nbsp;</td>    
  </tr>
  <tr align="center">
    <td width="12%" align="center" height="30">查勘费用</td>
    <td width="17%" align="center" id="tdCheckFee" colspan="2">&nbsp;</td>
    <td width="12%" align="center" height="30">实赔金额</td>
    <td width="17%" align="center" id="tdtSumThisPaid" colspan="2">&nbsp;</td>    
  </tr>
  <tr align="center">
    <td width="12%" align="center" height="30">鉴定费</td>
    <td width="17%" align="center" id="tdJudgeFee" colspan="2">&nbsp;</td>
    <td width="12%" align="center" height="30">赔讫日期</td>
    <td width="17%" align="center" id="tdPayDate" colspan="2">&nbsp;</td>
  </tr>
<tr align="center" style="display:none;"><td rowspan="5" colspan="7" >123&nbsp;</td></tr>
  <tr align="center">
    <td colspan="7"  valign="top" align="left">&nbsp;经办人意见:<br><br><br><br><br><br><br><br><p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;</p></td>
    
    <td width="12%" height="30" style="display:none;">共损救助费</td>
    <td width="17%" id="tdGsjzFee" style="display:none;">&nbsp;</td>
  </tr>
  <tr align="center">
    <td colspan="7"  valign="top" align="left">&nbsp;本公司领导核定：<br><br><br><br><br><br><br><br><p align="right">年&nbsp;&nbsp;&nbsp;&nbsp;月&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;</p></td>
  </tr>
  
  <tr align="center" style="display:none;">
    <td width="12%" height="30">公估费</td>
    <td width="17%" id='tdAssessFee'>&nbsp;</td>
  </tr>
  
  <tr align="center" style="display:none;">
    <td width="12%" height="30">法律费</td>
    <td width="17%" id='tdFlFee'>&nbsp;</td>
  </tr>  
  
  <tr align="center" style="display:none;">
    <td width="12%" height="30">其它</td>
    <td width="17%" id="tdElseFee">&nbsp;</td>
  </tr>

<table border=0 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">

  <tr align="center">
    <td width="12%">&nbsp;</td>
    <td colspan="2" >&nbsp;</td>
    <td width="12%" >&nbsp;</td>
    <td colspan="3" >&nbsp;</td>
  </tr>
  <tr>
    <td align="right">缮制：</td>
    <td align="left" colspan="2" id="tdHandlerName" ></td>
    <td align="right">审核：</td>
    <td align="left" colspan="2" id="tdUnderWriteName"></td>
  </tr>
</table>
<br>
<br>
<br>
<br>
<br>
</table>

      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="display:<%=strDisplay %>">
      	<tr>
      		<td align="left"><%=strPayRefName%></td>
      		<td align="right"><%=strPayRefDate%></td>
      	</tr>
      </table>
            <%
    if(intCtextCountTmp>6){
      %>
    
        <table width="92%"  align="center" cellspacing="0" cellpadding="0" border="1" style="border-collapse: collapse;display:<%=strDisplay %>" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
        <tr>
          <td align=center style="font-family:宋体; font-size:14pt;">赔款计算方式清单</td>
        </tr>
        <tr>
          <td  align="left" valign="top"><%=strContexTtemp%></td>
        </tr>
        </table>
        <% }%>
 <!--     
 <%
  //EndorseDto endorseDto = uiEndorseAction.findByConditions(strPolicyNo);
  ArrayList prpPheadDtoList = endorseDto.getPrpPheadDtoList();
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
   -->   
    <%--//modify by wangli update  start 20050422 --%>
     <jsp:include page="/common/print/PrintButton.jsp" />
      
      <%-- <jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
    <%--//modify by wangli update end 20050422 --%>
  </body>

</html>