<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="com.sinosoft.claim.dto.domain.PrplpayDto"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>֧����Ϣ��ѯ���</title>
  <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <jsp:include page="/common/pub/StaticJavascript.jsp" />
  </head>
  <body>
  <form action="/claim/prplpaysearch.do" name="fm" method="post">
   		<table class="common" cellpadding="0"  cellspacing="0" >
   			<tr>
   				<td class="centertitle">������</td>
   				<td class="centertitle">ҵ���</td>
   				<td class="centertitle">��������</td>
   				<td class="centertitle">��ϵ�绰</td>
   				<td class="centertitle">����</td>
   				<td class="centertitle">����״̬</td>
   			</tr>
   			<%
   			ArrayList list=(ArrayList)request.getAttribute("payList");
   			PrplpayDto pay=null;
   			for(int i=0;i<list.size();i++){
   			 pay=(PrplpayDto)list.get(i);
   			    %>
	   				<tr class="listodd">
	   				<%
	   					    String state="";
	   					    String editType="";
	   						if(pay.getVFlag()==null||"".equals(pay.getVFlag())){
	   						    state="�ѱ���";editType="SHOW";
	   						}else if(pay.getVFlag().equals("3")){
	   						 state="����";
	   						}else if(pay.getVFlag().equals("1")){
	   						 state="�ݴ�";editType="SHOW";
	   						}else if(pay.getVFlag().equals("2")){
	   						 state="�������";
	   						 editType="SHOW";
	   						}else if(pay.getVFlag().equals("4")){
	   						 state="���ͨ��";
	   						 editType="SHOW";
	   						}
	   						String type=request.getParameter("type");
	   						if("4".equals(type)){
	   							editType="SHOW";
	   						}
	   					%>
	   					<td align="center"><a href="/claim/prplpayadd.do?busino=<%=pay.getCompensateno() %>&node=<%=pay.getNode() %>&registno=<%=pay.getRegistno() %>&payflag=<%=pay.getPayflag()%>&editType=<%=editType %>"><%=pay.getRegistno() %></a></td>
	   					<td align="center"><%=pay.getCompensateno() %></td>
	   					<td align="center"><%=pay.getBank() %></td>
	   					<td align="center"><%=pay.getFamilyphone() %></td>
	   					<td align="center">
	   					<%
	   						if(pay.getNode().equals("certify")){
	   						    out.print("��֤");
	   						}else if(pay.getNode().equals("prepay")){
	   						 out.print("Ԥ��");
	   						}else if(pay.getNode().equals("comp")){
	   						 out.print("����");
	   						}
	   					%>
	   					</td>
	   					<td align="center"><%=state%></td>
	   				</tr>
   			    <%
   			}
   			%>
   		</table>
   		<%
   		PrplpayDto payDto=(PrplpayDto)request.getAttribute("payDto");
   		int curPage =payDto.getTurnPageDto().getPageNo(); 
   		%>
   		 <%@include file="/common/pub/TurnOverPage.jsp" %>
   		</form>
  </body>
</html>
