<%--
****************************************************************************
* DESC       ����������������ʧ���ȷ�����㲿��������Ŀ�嵥(��ѯ�۵�����)��ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@include file="DAACetainLossReportNoneFormatPrintIni.jsp"%>


<html>
 
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">

  <body bgcolor="#FFFFFF">
 <!-- ���ⲿ�� -->
 <table width="680" align="center" cellspacing="0" cellpadding="0" border="0">
       <tr>
         <td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;">
           <img src="/claim/images/LOGO.jpg"/>
         </td>
       </tr> 
      <tr height=40>
        <td colspan="3" align=center  style="font-family:����; font-size:16pt;">
          <B><center>�����������ն��𱨸�</span><center><B>
        </td>
      </tr>
</table>
<table border=1 align="center" width="676" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
    <tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		�� �� �� ��</td>
		<td colspan="4"><%=strInsuredName %></td>
		<td   align='center' colspan="2">
		�� �� �� ��</td>
		<td colspan="2"><%=strRegistNo %></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		�� �� �� ��</td>
		<td><%=strLicenseNo %></td>
		<td  align='center'>
		����Ʒ��</td>
		<td colspan="2" ><%=strBrandName %></td>
		<td   align='center' colspan="2">
		�� �� �� ��</td>
		<td colspan="2"><span><%=registRPolicyNoBu %></span>
		 <span><%=registRPolicyNoBz %></span></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		����������</td>
		<td><%=strEngineNo %></td>
		<td  align='center'>
		�����ͺ�</td>
		<td colspan="2" ><%=strModelNo %></td>
		<td  align='center' colspan="2">
		�� �� �� ��</td>
		<td colspan="2"><%=strFrameNo %></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" height="26" align='center'>
		�� �� ʱ ��</td>
		<td colspan="4" align='center'>
		<%=strDamageStartDate %></td>
		<td  align='center' colspan="2">
		�� �� �� ��</td>
		<td  align='center' colspan="2">
		<%if(involveKindA){ %>
		��������&nbsp;<%}else{%>
		��������&nbsp;<%} %>
		<%if(involveKindB){ %>
		 �������� <%}else{%>
		�������� <%} %>
	    <%if(involveKindSub){ %>
		 �������� <%}else{%>
		�������� <%} %></td>
	</tr>
	<tr height="26" style="height: 20.1pt">
		<td colspan="2" align='center'>
		�������</td>
		<td colspan="8"  height="26">&nbsp;��Լά��վ&nbsp; 
		<%if("01".equals(repairFactoryCode)){ %>
		��4S��&nbsp;<%}else{%>
		��4S��&nbsp;<%} %>
		<%if("02".equals(repairFactoryCode)){ %>
		 ��һ�� <%}else{%>
		��һ�� <%} %>
	    <%if("03".equals(repairFactoryCode)){ %>
		 ������ <%}else{%>
		������ <%} %></td>
	</tr>
	<tr height="24" style="height: 18.0pt">
		<td align="center">
		���</td>
		<td colspan="2" align="center"  height="26">
		�����������</td>
		<td  height="25" align="center">
		����</td>
		<td  height="25" align="center">
		����</td>
		<td  height="25" align="center">
		���</td>
		<td colspan="2"  height="26" align="center">
		������Ŀ����</td>
		<td  height="25" colspan="2" align="center">
		��ʱ��</td>
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
		<td colspan="2" ><%=strRepairName[i] %>��</td>
		<td align="right" colspan="2"><%=dbRepairSumFee[i] %>��</td>
	</tr>
	<%}} %>
	<tr height="24" style="height: 18.0pt">
		<td colspan="4" height="24" >
		���Ϸ�С�ƣ�</td>
		<td align="right" colspan="2"><%=sumSumDefLoss %></td>
		<td colspan="2" >
		��ʱ��С�ƣ�</td>
		<td align="right" colspan="2"><%=sumRepairDefLoss %>��</td>
	</tr>
	<tr height="24" style="height: 18.0pt">
		<td colspan="4" height="24" >
		�ܿ۲�ֵ��</td>
		<td  colspan="2" align="right"><%=sumRestFee %></td>
		<td colspan="2" ></td>
		<td align="right" colspan="2"></td>
	</tr>
	<tr height="24" style="height: 18.0pt">
		<td colspan="3" height="24" >
		�ܼƹ��Ϸ�����ң���д����</td>
		<td colspan="5" align="right"><%=strSumLossChina %>&nbsp;</td>
		<td align="center">
		Сд��</td>
		<td align="right"><%=sumLoss %></td>
	</tr>
	<tr height="83" style="height: 62.25pt">
		<td colspan="10" height="83">
		&nbsp;1�������ұ�����Э�̣���ȫͬ�ⰴ���Ϻ˶��ļ۸�����<font class="font5"><br>
		&nbsp;2���ҷ������Ϻ˶���Ŀ���ʱ����������������Ϻ˶�������������Ŀ������Υ�����׷���Ȩ���ҷ�׷�ؼ۸��<br>
		&nbsp;3���ҷ���֤��</font><font class="font6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font><font class="font5">
		���ڱ��ʱ�����ʱ���������ΥԼ��Ը���⳥������ʱ�����ɵı�����������ʧ��<br>
		&nbsp;4�����������Ϻ˶���������Ŀ�ͼ۸����κ����顣�����������������۸񳬱꣬Ը���ҷ�ȫ������<br>
		&nbsp;5������˵����</font></td>
	</tr>
	<tr>
		<td colspan="3" >�ҷ�(����)ǩ�£�<br>
		<br>
		<br>
		<br> <font class="font5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp; ��&nbsp;&nbsp; ��</font>
		<br><br>
		</td>
		<td colspan="4" >&nbsp;����(�������˻���ί����)ǩ�£�<br>
		<br>
		<br> <br>
		<font class="font5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp; ��&nbsp;&nbsp; ��</font>
		<br><br></td>
		<td colspan="3">&nbsp;�׷�(���չ�˾)ǩ�£�<br>
		&nbsp;�鿱����Ա��<br>
		&nbsp;�˼������<br>
		&nbsp;�˼��ˣ�<br>
		 <font class="font5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp; ��&nbsp;&nbsp; ��</font>
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

<%-- include��ӡ��ť --%>
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
