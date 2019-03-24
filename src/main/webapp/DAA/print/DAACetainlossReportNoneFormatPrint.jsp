<%--
****************************************************************************
* DESC       ：机动车辆保险损失情况确认书零部件更换项目清单(代询价单附件)打印页面
* AUTHOR     ：liubvo
* CREATEDATE ：2004-11-16
* MODIFYLIST ：   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@include file="DAACetainLossReportNoneFormatPrintIni.jsp"%>


<html>
 
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">

  <body bgcolor="#FFFFFF">
 <!-- 标题部分 -->
 <table width="680" align="center" cellspacing="0" cellpadding="0" border="0">
       <tr>
         <td colspan="3" height="40" align=center style="font-family:宋体; font-size:14pt;">
           <img src="/claim/images/LOGO.jpg"/>
         </td>
       </tr> 
      <tr height=40>
        <td colspan="3" align=center  style="font-family:宋体; font-size:16pt;">
          <B><center>机动车辆保险定损报告</span><center><B>
        </td>
      </tr>
</table>
<table border=1 align="center" width="676" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
    <tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		被 保 险 人</td>
		<td colspan="4"><%=strInsuredName %></td>
		<td   align='center' colspan="2">
		报 案 号 码</td>
		<td colspan="2"><%=strRegistNo %></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		车 牌 号 码</td>
		<td><%=strLicenseNo %></td>
		<td  align='center'>
		车辆品牌</td>
		<td colspan="2" ><%=strBrandName %></td>
		<td   align='center' colspan="2">
		保 单 号 码</td>
		<td colspan="2"><span><%=registRPolicyNoBu %></span>
		 <span><%=registRPolicyNoBz %></span></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		发动机号码</td>
		<td><%=strEngineNo %></td>
		<td  align='center'>
		车辆型号</td>
		<td colspan="2" ><%=strModelNo %></td>
		<td  align='center' colspan="2">
		车 架 号 码</td>
		<td colspan="2"><%=strFrameNo %></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		出 险 时 间</td>
		<td colspan="4" align='center'>
		<%=strDamageStartDate %></td>
		<td  align='center' colspan="2">
		涉 及 险 别</td>
		<td  align='center' colspan="2">
		<%if(involveKindA){ %>
		■车损险&nbsp;<%}else{%>
		□车损险&nbsp;<%} %>
		<%if(involveKindB){ %>
		 ■三者险 <%}else{%>
		□三者险 <%} %>
	    <%if(involveKindSub){ %>
		 ■附加险 <%}else{%>
		□附加险 <%} %></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" align='center'>
		修理厂类别</td>
		<td colspan="8"  height="26">&nbsp;特约维修站&nbsp; 
		<%if("01".equals(repairFactoryCode)){ %>
		■4S店&nbsp;<%}else{%>
		□4S店&nbsp;<%} %>
		<%if("02".equals(repairFactoryCode)){ %>
		 ■一类 <%}else{%>
		□一类 <%} %>
	    <%if("03".equals(repairFactoryCode)){ %>
		 ■二类 <%}else{%>
		□二类 <%} %></td>
	</tr>
	<tr height="24" style="height: 18.0pt">
		<td align="center">
		序号</td>
		<td colspan="2" align="center"  height="26">
		更换配件名称</td>
		<td  height="25" align="center">
		数量</td>
		<td  height="25" align="center">
		单价</td>
		<td  height="25" align="center">
		金额</td>
		<td colspan="2"  height="26" align="center">
		修理项目名称</td>
		<td  height="25" colspan="2" align="center">
		工时费</td>
	</tr>
	<%if(maxSize>13){ %>
    <tr height="312">
		<td  colspan="10" align="center" ><%=printMessage %></td>
	</tr>
	<%}else{ 
	for(int i=0;i<13;i++){%>
	<tr height="24" style="height: 18.0pt">
		<td height="24"  align="center">
		<%=i+1 %></td>
		<td colspan="2" ><%=strCompName[i] %></td>
		<td align="right"><%=dbComQuantity[i] %></td>
		<td align="right"><%=dbComUnitPrice[i] %> </td>
		<td align="right"><%=dbComSumPrice[i] %></td>
		<td colspan="2" ><%=strRepairName[i] %>　</td>
		<td align="right" colspan="2"><%=dbRepairSumFee[i] %>　</td>
	</tr>
	<%}} %>
	<tr height="24" style="height: 18.0pt">
		<td colspan="4" height="24" >
		材料费小计：</td>
		<td align="right" colspan="2"><%=sumSumDefLoss %></td>
		<td colspan="2" >
		工时费小计：</td>
		<td align="right" colspan="2"><%=sumRepairDefLoss %>　</td>
	</tr>
	<tr height="24" style="height: 18.0pt">
		<td colspan="4" height="24" >
		总扣残值：</td>
		<td  colspan="2" align="right"><%=sumRestFee %></td>
		<td colspan="2" ></td>
		<td align="right" colspan="2"></td>
	</tr>
	<tr height="24" style="height: 18.0pt">
		<td colspan="3" height="24" >
		总计工料费人民币（大写）：</td>
		<td colspan="5" align="right"><%=strSumLossChina %>&nbsp;</td>
		<td align="center">
		小写：</td>
		<td align="right"><%=sumLoss %></td>
	</tr>
	<tr height="83" style="height: 62.25pt">
		<td colspan="10" height="83">
		&nbsp;1、经甲乙丙三方协商，完全同意按以上核定的价格修理。<font class="font5"><br>
		&nbsp;2、乙方按以上核定项目保质保量修理，且履行以上核定的修理及换件项目。如有违背，甲方有权向乙方追回价格差额。<br>
		&nbsp;3、乙方保证在</font><font class="font6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font class="font5">
		日内保质保量按时完成修理；若违约，愿意赔偿因拖延时间而造成的丙方的利润损失。<br>
		&nbsp;4、丙方对以上核定的修理项目和价格无任何异议。如在修理质量问题或价格超标，愿由乙方全部负责。<br>
		&nbsp;5、其它说明：</font></td>
	</tr>
	<tr>
		<td colspan="3" >乙方(修理厂)签章：<br>
		<br>
		<br>
		<br> <font class="font5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp; 月&nbsp;&nbsp; 日</font>
		<br><br>
		</td>
		<td colspan="4" >&nbsp;丙方(被保险人或其委托人)签章：<br>
		<br>
		<br> <br>
		<font class="font5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp; 月&nbsp;&nbsp; 日</font>
		<br><br></td>
		<td colspan="3">&nbsp;甲方(保险公司)签章：<br>
		&nbsp;查勘定损员：<br>
		&nbsp;核价意见：<br>
		&nbsp;核价人：<br>
		 <font class="font5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;年&nbsp;&nbsp; 月&nbsp;&nbsp; 日</font>
		 <br><br>
	    </td>
	</tr>
	<tr height="0">
        <td width="50" style="border: none"></td>
		<td width="39" style="border: none"></td>
	    <td width="80" style="border: none"></td>
	    <td width="66" style="border: none"></td>
		<td width="67" style="border: none"></td>
		<td width="65" style="border: none"></td>
		<td width="20" style="border: none"></td>
		<td width="95" style="border: none"></td>
		<td width="49" style="border: none"></td>
		<td width="135" style="border: none"></td>
	</tr>
</table>
   <br>     

<%-- include打印按钮 --%>
    <%
     String PrintFlag="0";
     PrintFlag =request.getParameter("PrintFlag");
     if(PrintFlag == null){
   	%>
       <jsp:include page="/common/print/PrintButton.jsp" />
    <%
     }
    %>
    
  </body>
</html>
