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
<%@include file="DAACetainLossReportDetailNoneFormatPrintIni.jsp"%>


<html>
 
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">

  <body bgcolor="#FFFFFF">
  
    <script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>
  
    <!-- 标题部分 -->
<table width="666" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height=30>
        <td colspan="4" align="center">
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>
      <tr height=30>
        <td colspan="4" align=center style=" font-family:宋体; font-size:14pt;">
          <B><center>机动车辆保险定损报告清单</span><center><B>
        </td>
      </tr>
      <tr height=24 style="font-family:宋体; font-size:10pt;">
        <td colspan="4"   align="left" >
        &nbsp;&nbsp;&nbsp;报案号：<%=registerNo %>
        </td>
      </tr>
      <tr height=24 style="font-family:宋体; font-size:10pt;">
        <td   align="left">
        &nbsp;&nbsp;&nbsp;车牌号：<%=strLicenseNo %>
        </td>
       <td   align="left" style="font-family:宋体; font-size:10pt;">
        发动机号：<%=strEngineNo %>
        </td>
      <td   align="left" style="font-family:宋体; font-size:10pt;">
        车架号：<%=strtFrameNo %>
      </td>
      </tr>
</table>
<table border=1 align="center" width="666" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:宋体; font-size:10pt;">
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
	<%for(i=0;i< maxSize ;i++){ %>
	<tr height="24" style="height: 18.0pt">
		<td height="24"  align="center">
		<%=i+1 %></td>
		<td colspan="2" ><%=strCompName[i] %></td>
		<td ><%=dbComQuantity[i] %></td>
		<td><%=dbComUnitPrice[i] %> </td>
		<td><%=dbComSumPrice[i] %></td>
		<td colspan="2" ><%=strRepairName[i] %>　</td>
		<td align="right" colspan="2"><%=dbRepairSumFee[i] %>　</td>
	</tr>
	<%} %>
	<tr height="0">
        <td width="50" style="border: none"></td>
		<td width="39" style="border: none"></td>
	    <td width="80" style="border: none"></td>
	    <td width="66" style="border: none"></td>
		<td width="67" style="border: none"></td>
		<td width="70" style="border: none"></td>
		<td width="20" style="border: none"></td>
		<td width="95" style="border: none"></td>
		<td width="49" style="border: none"></td>
		<td width="130" style="border: none"></td>
	</tr>
</table>
  <br>    
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
