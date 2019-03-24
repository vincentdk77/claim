<%--
****************************************************************************
* DESC       ：出险后抄单打印页面
* AUTHOR     ： 项目组
* CREATEDATE ： 2005-09-14
* MODIFYLIST ：   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html; charset=GBK" %>

<%--初始化--%>
<%@include file="NotCarDangerCopyNoneFormatPrintIni.jsp"%>

<html>
    <head>
	    <title> 财产保险公司保单抄件</title>
    </head>
	<!--按险类调用不同模块-->
	<body>
<%
  if(strClassCode.equals("10")||strClassCode.equals("09"))
  {
%>
  <%--include抄单头信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead10.jsp" />
  <%--include抄单附加信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub.jsp" />
  <%--include抄单保费到账信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount.jsp" />
  <%--include抄单分保信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintReins.jsp" />
  <%--include抄单历史赔付信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory.jsp" />
<%
  }
  //农险暂时走财产险的格式  modify by kangzhen
  else if(strClassCode.equals("01") || strClassCode.equals("02") || strClassCode.equals("03")|| strClassCode.equals("11")|| strClassCode.equals("31")|| strClassCode.equals("32")|| strClassCode.equals("04")){
%>
  <%--include抄单头信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead01.jsp" />
  <%--include抄单附加险信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include抄单批改信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include抄单保费到账信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include抄单历史赔付信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("08")){
%>
  <%--include抄单头信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead08.jsp" />
  <%--include抄单附加险信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub08.jsp" />
  <%--include抄单批改信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include抄单保费到账信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include抄单历史赔付信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%  
  }else if(strClassCode.equals("15")){
%>
  <%--include抄单头信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead15.jsp" />
  <%--include抄单附加险信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include抄单批改信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include抄单保费到账信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include抄单历史赔付信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("16")){
%>
  <%--include抄单头信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead16.jsp" />
  <%--include抄单附加险信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include抄单批改信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include抄单保费到账信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include抄单历史赔付信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("17")){
%>
  <%--include抄单头信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead17.jsp" />
  <%--include抄单附加险信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include抄单批改信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include抄单保费到账信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include抄单历史赔付信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("08")){
%>
  <%--include抄单头信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead08.jsp" />
  <%--include抄单附加险信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub08.jsp" />
  <%--include抄单批改信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include抄单保费到账信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include抄单历史赔付信息--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else{
%>
    <p align="center"><%=strRiskName%>保单抄件-公共抄单</p>
    <hr align="center" width="90%" size="4"/>
    <table align="center" width="90%">
      <tr><td colspan="2">报案号：<%= strRegistNo %></td></tr>
      <tr></tr><td colspan="2">保险单号：<%= strPolicyNo %></td></tr>
      <tr></tr><td colspan="2">被保险人名称：<%= strPolicyName %></td></tr>
      <tr></tr><td colspan="2">被保险人地址：<%= strPolicyAddress %></td></tr>
      <tr></tr><td colspan="2">保险金额：<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbSumAmount)%></td></tr>
      <tr></tr><td colspan="2">保险标的：</td></tr>
      <tr></tr><td colspan="2">保险标的地址：</td></tr>
      <tr></tr><td colspan="2">免赔说明：</td></tr>
      <tr></tr><td>投保日期：<%=OperateDate %></td><td>录入日期：<%=UnderWriteEndDate %></td></tr>
      <tr></tr><td>签单日期：<%=SignDate %></td><td>出单日期：<%=InputDate %></td></tr>
      <tr></tr><td colspan="2">保险期间：<%=StartDate %> 到 <%=EndDate %></td></tr>
      <tr></tr><td colspan="2">是否涉及再保、联保、共保：<%= strCoinsFlag %></td></tr>
      <tr></tr><td colspan="2">特别约定：</td></tr>
      <tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>
     <% //责任险显示主险\附加险信息
      if(strClassCode.equals("04")){ //客户要求责任险显示主险、附加险的限额
      System.out.println("000000000000000000000000000000责任险");
   %>  <tr>
       <td colspan="2">
       <table align="center" width="100%"> 
      
        <tr><td colspan="7">主险赔偿限额：</td></tr>
       	<tr>
      	  <td align="center" width="20%" >营业场所名称</td>
      	  <!--<td align="left" width="10%" >地址序号</td>-->
      	  <td align="left" width="10%" >币别</td>
      	  <td align="left" width="20%" >金额</td>
      	  <!--<td align="left" width="15%" >累积赔偿限额</td>
      	  <td align="left" width="10%" >每次赔偿限额</td>
          <td align="left" width="15%" >每次事故财产损失赔偿限额</td>
          <td align="left" width="15%" >每次事故人身伤亡赔偿限额</td>
          <td align="left" width="10%" >其中，每人赔偿限额</td>-->
        </tr>
        <tr><td colspan="7"><hr align="center" width="90%" style="direction:inherit "/></td></tr>
<%System.out.println("000000000000000000000000000000"+flag.length); 
for(i=0 ;i<flag.length;i++){
if(flag[i]!=null&&flag.length >= 2)
{
 if (flag[i].substring(1,2).equals("1")){
 %>
       	 <tr>
      	  <td align="center"><%=itemDetailName[i]%></td>
      	  <!--<td align="left"></td>-->
      	  <td align="left"><%=currency[i]%></td>
      	  <td align="left"><%=new DecimalFormat("#,##0.00").format(limitAmount[i])%></td>
      	 </tr>
<%
}}}
%>


  <tr><td colspan="7">附加险赔偿限额：</td></tr>
        <tr>
          <td align="center" width="20%" >营业场所名称</td>
      	 <!-- <td align="left" width="10%" >地址序号</td>-->
      	  <td align="left" width="5%" >币别</td>
      	  <td align="left" width="15%" >金额</td>
        </tr>
        <tr><td colspan="7"><hr align="center" width="90%" style="direction:inherit "/></td></tr>
<%for(i=0 ;i<flag.length;i++){%>
<% if(flag[i]!=null&&flag.length >= 2)
   {
   if (flag[i].substring(1,2).equals("2")){%>
      	 <tr>
      	   <td align="center"><%=itemDetailName[i]%></td>
      	 <!-- <td align="left"></td>-->
      	  <td align="left"><%=currency[i]%></td>
      	  <td align="left"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
       </tr>
<%}} }%>
 
    </table>
    </td>
     </tr>
    <% 
     
       
      }
     else{
      %>
      <tr><td colspan="2">附加险：</td></tr>
      <tr>
        <td colspan="2">
      	  <table width="90%" align="center">
      	<tr>
      	  <td align="left" width="50%" > 名称</td>
          <td align="left" width="30%" > 保额/限额  </td>
          <td align="left" width="20%" >每次赔偿限额</td>
        </tr>
        <tr><td colspan="3"><hr align="center" width="90%" style="direction:inherit "/></td></tr>
<%for(i=0 ;i<strKindName.length;i++){%>
      	<tr>
      	  <td align="left"><%=strKindName[i]%></td>
      	  <td align="left"><%=new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
          <td align="left"></td>
      	</tr>
<%}

%>
      </table>
    </td>
  </tr>
<%}

%>			                                           
  <tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>
  <tr><td colspan="2">批改情况：</td></tr>
  <tr>
    <td colspan="2">
      <table width="90%" align="center">
        <tr>
          <td align="left" width="30%">批单号   </td>
          <td align="left" width="30%"> 批改原因  </td>
          <td align="left" width="20%">批改时间</td>
          <td align="left" width="20%">核保人</td>
        </tr>
        <tr><td colspan="4"><hr width="90%" align="center" style="direction:inherit "/></td></tr>
<%for(i=0 ;i<strEndorseNo.length;i++){%>
        <tr>
          <td align="left"><%=strEndorseNo[i]%></td>
          <td align="left"><%=strEndorType[i]%></td>
          <td align="left"><%=strEndorDate[i]%></td>
          <td align="left"><%=strUnderWriteName[i]%></td>
        </tr>
<%}%>
      </table>
    </td>
  </tr>
  <tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>
  <tr><td colspan="2">保费到账情况：</td></tr>                                                       
  <tr>
    <td colspan="2">
  	  <table width="90%" align="center">
  		  <tr>
  			  <td align="left">付款期数   </td>
  				<td align="left">批单号  </td>
  				<td align="left">应收</td>
  				<td align="left">实收</td>
  				<td align="left">到账日期</td>
  			</tr>
  			<tr><td colspan="5"><hr align="center" width="90%" style="direction:inherit "/></td></tr>
  			<%for(i=0 ;i<strPlanEndorNo.length;i++){%>
  			<tr>
  				<td align="left"><%=iPlanNo[i]%></td>
  				<td align="left"><%=strPlanEndorNo[i]%></td>
  				<td align="left"><%=new DecimalFormat("#,##0.00").format(dbPlanFee[i])%></td>
  			  <td align="left"><%=new DecimalFormat("#,##0.00").format(dbRealFee[i])%></td>
  			  <!-- 到账时间为空值展示处理 -->
  			  <%if(strPayDate[i]==null){ %>
  			    <td align="left"></td>
  			  <%}else{ %>
  				<td align="left"><%=strPayDate[i]%></td>
  			  <%} %>
  			</tr>
  		  <%}%>
  		</table>
  	</td>
  </tr>
                                             
  <tr><td colspan="2">历史赔付纪录：</td></tr> 
  
  <tr>
      <td colspan="2">
  	    <table width="90%" align="center">
  		    <tr>
  			    <td align="left">归档号   </td>
  				<td align="left"> 出险时间  </td>
  				<td align="left">未决金额</td>
  				<td align="left">赔付金额</td>
  			    <td align="left">结案日期</td>
  				<td align="left">核赔人</td>
  				<td align="left">赔付次数</td>
  			</tr>
  			<tr><td colspan="7"><hr width="90%" align="center" style="direction:inherit "/></td></tr>
  		</table>
  	</td>
  </tr>
  <tr><td colspan="2"><hr align="center" width="90%" size="4"/></td></tr>
  <tr><td>抄单人：</td><td>抄单日期：</td></tr>
		</table>
<%
  }
%>		
		 <!--include打印按钮-->
  <jsp:include page="/common/print/PrintButton.jsp" />
	</body>
</html>
