<%--
****************************************************************************
* DESC       �����պ󳭵���ӡͷ��Ϣҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-17
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@ page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<%@include file="CopyNoneFormatPrintHead08Ini.jsp"%>

<html>
  <head></head>
  <body font-size:11pt>
    <table align="center" width="90%" style="font-family:����; font-size:11pt;">
      <tr><td colspan="5" align="center" style="font-size:14pt"><b> ��Ԫũҵ���չ�˾&nbsp;&nbsp;<%=strRiskName%>��������</b></td></tr>
      <tr><td colspan="5"><hr align="center" width="100%" size="4"/></td></tr>
      <tr><td colspan="5">�����ţ�<%= strRegistNo %></td></tr>
      <tr><td colspan="5">���յ��ţ�<%= strPolicyNo %></td></tr>
      <tr> <td>�����������ƣ�<%= strPolicyName %></td> </tr>
      <tr>
        <td></td><td>���������ˣ�</td>
        <td colspan="3">
<%
  for(i=0;i<arrInsuredName.length;i++){
    if(arrInsuredNature[i].equals("0") && arrInsuredFlag[i].equals("1")){
%>
          <%=arrInsuredName[i]%>
<%
    }
  }
%>
        </td>
      </tr>
      <tr>
        <td></td><td>���̳а��ˣ�</td>
        <td colspan="3">
<%
  for(i=0;i<arrInsuredName.length;i++){
    if(arrInsuredNature[i].equals("1") && arrInsuredFlag[i].equals("1")){
%>
          <%=arrInsuredName[i]%>
<%
    }
  }
%>
        </td>
      </tr>
      <tr>
        <td></td><td>���̷ְ��ˣ�</td>
        <td colspan="3">
<%
  for(i=0;i<arrInsuredName.length;i++){
    if(arrInsuredNature[i].equals("2") && arrInsuredFlag[i].equals("1")){
%>
         <%=arrInsuredName[i]%>
<%
    }
  }
%>
        </td>
      </tr>
      <tr>
        <td></td><td>������ϵ����</td>
        <td colspan="3">
<%
  for(i=0;i<arrInsuredName.length;i++){
    if(arrInsuredNature[i].equals("9") && arrInsuredFlag[i].equals("1")){
%>
          <%=arrInsuredName[i]%>
<%
    }
  }
%>
        </td>
      </tr>
      <tr><td colspan="5">���չ������ƣ�<%=strConstructionName%></td></tr>
      <tr><td colspan="5">���չ��̵�ַ��</td></tr>
<%
  for(i=0;i<arrItemAddress.length;i++){
%>
      <tr><td align="center"><%=i+1%>��</td><td colspan="4"><%=arrItemAddress[i]%></td></tr>
<%}%>
      
      <tr><td colspan="5"><hr align="center" width="100%" size="2"/></td></tr>
      <!-- ������ʧ���� -->
      <tr><td colspan="5">������ʧ���֣�</td></tr>
      <tr>
        <td > </td>
        <td >���ձ������</td>
        <td >����</td>
        <td colspan="2">���ս��/�⳥�޶�</td>
      </tr>
<%
  int j = 0;
  double dbSumTemp=0.0;
  for(i=0;i<strKindName.length;i++){
    if(strKindCode[i].equals("001")){
      j = j + 1;
      //zhulei leave 20051010��ֻ�Ǽ򵥵Ľ���ۼӣ�����û�п��Ǳ��ֶһ��ʵ����⡣
      dbSumTemp = dbSumTemp + dbAmount[i];
%>
      <tr>
        <td align="center"><%=j %> </td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=strKindCurrency[i]%></td>
        <td colspan="2"><%= new DecimalFormat("#,##0.00").format(dbAmount[i])%></td>
      </tr>
<%
    }
  }
%>
      <tr><td></td><td>����С�ƣ�</td><td colspan="3"><%=  new DecimalFormat("#,##0.00").format(dbSumTemp)%> </td></tr>

 <%//��0803����start
 if(!strRiskCode.equals("0803")){ %>
      <!-- ���ַ����⳥�޶�� -->
      <tr><td colspan="5">���ַ����⳥�޶</td></tr>
      <tr>
        <td > </td>
        <td >���ַ�������</td>
        <td >����</td>
        <td colspan="2">�⳥�޶�</td>
      </tr>
<%
  j = 0;
  dbSumTemp = 0.0;
  for(i=0;i< strLimitType.length;i++){
    //leave by zhulei:��������������ж������ַ���
    System.out.println(">>>>=====strLimitType=="+strLimitType[i]);
    //if(arrLimitGrade[i].equals("2") && (strLimitType[i].equals("01")||strLimitType[i].equals("02")||strLimitType[i].equals("03")||strLimitType[i].equals("04")||strLimitType[i].equals("12")||strLimitType[i].equals("13")||strLimitType[i].equals("14")||strLimitType[i].equals("15")) ){ 
    if(strLimitType[i].equals("01")||strLimitType[i].equals("02")||strLimitType[i].equals("03")||strLimitType[i].equals("04")||strLimitType[i].equals("12")||strLimitType[i].equals("13")||strLimitType[i].equals("14")||strLimitType[i].equals("15")){ 
      j = j + 1;
      dbSumTemp = dbSumTemp + dbLimitFee[i];
%>
      <tr>
        <td align="center"><%=j %> </td>
        <td ><%=arrLimitTypeName[i]%></td>
        <td ><%=strLimitCurrency[i]%></td>
        <td colspan="2"><%=new DecimalFormat("0.00").format(dbLimitFee[i])%></td>
      </tr>
<%
    }
  }
%>
      <tr><td></td><td>����С�ƣ�</td><td colspan="3"><%=dbSumTemp%> </td></tr>
      <!-- ���������β��� -->
      <tr><td colspan="5">���������β��֣�</td></tr>
	<tr></tr><td align="right"> �⳥�޶<td colspan="4">ÿ���¹��⳥�޶<%=strCurrency10%> <%=new DecimalFormat("0.00").format(dbLimit10)%></td></tr>
	<tr></tr><td align="right">���У�</td><td colspan="4">�Ʋ���ʧ�⳥�޶<%=strCurrency07%> <%=new DecimalFormat("0.00").format(dbLimit07)%> </td></tr>
        <tr></tr><td > </td><td colspan="4">���������⳥�޶<%=strCurrency06%> <%=new DecimalFormat("0.00").format(dbLimit06)%> </td></tr>
			<tr></tr><td > </td><td colspan="4">ÿ���⳥�޶<%=strCurrency05%> <%=new DecimalFormat("0.00").format(dbLimit05)%> </td></tr>
			
			<tr></tr><td colspan="5">&nbsp;&nbsp;&nbsp;&nbsp;���������ۼ��⳥�޶<%=strCurrency11%><%=new DecimalFormat("#,##0.00").format(dbLimit11)%></td></tr>
<%
 //��0803����end   
  }
  else if(strRiskCode.equals("0803")){
   
%>
 <tr><td colspan="5">������ʧ���֣�</td></tr>
      <tr>
        <td > </td>
        <td >���ձ������</td>
        <td >����</td>
        <td colspan="2">���ս��/�⳥�޶�</td>
      </tr>
<% }%>

<%
  int m = 0;
  double sumTemp=0.0;
  for(i=0;i<strKindName.length;i++){
    if(strKindCode[i].equals("100")){
      j = j + 1;
      //zhulei leave 20051010��ֻ�Ǽ򵥵Ľ���ۼӣ�����û�п��Ǳ��ֶһ��ʵ����⡣
      sumTemp = sumTemp + dbAmount[i];
%>
      <tr>
        <td align="center"><%=j %> </td>
        <td ><%=strItemDetailName[i]%></td>
        <td ><%=strKindCurrency[i]%></td>
        <td colspan="2"><%=dbAmount[i]%></td>
      </tr>
<%
    }
  }
%>



			<tr></tr><td>ÿ���¹ʾ������⣺</td><td>������ʧ���֣�</td><td colspan="4"><%=strCurrency09%> <%=new DecimalFormat("0.00").format(dbLimit09)%> </td></tr>
<% if(!strRiskCode.equals("0803")){
   
%>			
			<tr><td></td><td>���������β��֣�</td><td colspan="4"></td></tr>
<% }else {%>      
 		<tr><td></td><td>������ʧ���֣�</td><td colspan="4"> <%=new DecimalFormat("0.00").format(dbDeductible)%></td></tr>
<% }%> 		
			<tr><td colspan="2">Ͷ�����ڣ�<%=OperateDate %></td><td colspan="3">¼�����ڣ�<%=UnderWriteEndDate %></td></tr>
			<tr><td colspan="2">ǩ�����ڣ�<%=SignDate %></td><td colspan="3">�������ڣ�<%=InputDate %></td></tr>
			<tr><td colspan="5">�������ޣ���<%=StartDate %> �� <%=EndDate %></td></tr>
			
			<tr><td colspan="5">��װ�ڣ�</td></tr>
			<tr><td></td><td colspan="4">��<%=strStartFixDate %> �� <%=strEndFixDate %></td></tr>
			<tr><td colspan="5">�Գ��ڣ�</td></tr>
			<tr><td></td><td colspan="4"><%=strTestPeriod%>��</td></tr>
			<tr><td></td><td colspan="4">��<%=strTestStartDate %> �� <%=strTestEndDate %></td></tr>
			<tr><td colspan="5">��֤�ڣ�</td></tr>
			<tr><td></td><td colspan="4">��<%=strStartAddDate %> �� <%=strEndAddDate %></td></tr>
			
			<tr><td colspan="5">�Ƿ��漰�ٱ��ٷ֡�������������<%= strCoinsFlag %></td></tr>
			
			<tr><td valign="top">�ر�Լ����</td><td colspan="4"><%=strEngage%></td></tr>
			
	  </table>
  </body>
</html>