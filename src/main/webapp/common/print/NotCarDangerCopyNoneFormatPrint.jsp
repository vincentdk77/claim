<%--
****************************************************************************
* DESC       �����պ󳭵���ӡҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE �� 2005-09-14
* MODIFYLIST ��   Name       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************
--%>
<%@page contentType="text/html; charset=GBK" %>

<%--��ʼ��--%>
<%@include file="NotCarDangerCopyNoneFormatPrintIni.jsp"%>

<html>
    <head>
	    <title> �Ʋ����չ�˾��������</title>
    </head>
	<!--��������ò�ͬģ��-->
	<body>
<%
  if(strClassCode.equals("10")||strClassCode.equals("09"))
  {
%>
  <%--include����ͷ��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead10.jsp" />
  <%--include����������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub.jsp" />
  <%--include�������ѵ�����Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount.jsp" />
  <%--include�����ֱ���Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintReins.jsp" />
  <%--include������ʷ�⸶��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory.jsp" />
<%
  }
  //ũ����ʱ�߲Ʋ��յĸ�ʽ  modify by kangzhen
  else if(strClassCode.equals("01") || strClassCode.equals("02") || strClassCode.equals("03")|| strClassCode.equals("11")|| strClassCode.equals("31")|| strClassCode.equals("32")|| strClassCode.equals("04")){
%>
  <%--include����ͷ��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead01.jsp" />
  <%--include������������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include����������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include�������ѵ�����Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include������ʷ�⸶��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("08")){
%>
  <%--include����ͷ��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead08.jsp" />
  <%--include������������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub08.jsp" />
  <%--include����������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include�������ѵ�����Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include������ʷ�⸶��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%  
  }else if(strClassCode.equals("15")){
%>
  <%--include����ͷ��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead15.jsp" />
  <%--include������������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include����������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include�������ѵ�����Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include������ʷ�⸶��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("16")){
%>
  <%--include����ͷ��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead16.jsp" />
  <%--include������������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include����������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include�������ѵ�����Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include������ʷ�⸶��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("17")){
%>
  <%--include����ͷ��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead17.jsp" />
  <%--include������������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub01.jsp" />
  <%--include����������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include�������ѵ�����Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include������ʷ�⸶��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else if(strClassCode.equals("08")){
%>
  <%--include����ͷ��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHead08.jsp" />
  <%--include������������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintSub08.jsp" />
  <%--include����������Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintEndorse.jsp" />
  <%--include�������ѵ�����Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintAccount01.jsp" />
  <%--include������ʷ�⸶��Ϣ--%>
  <jsp:include page="/common/print/copyprint/CopyNoneFormatPrintHistory01.jsp" />
<%
  }else{
%>
    <p align="center"><%=strRiskName%>��������-��������</p>
    <hr align="center" width="90%" size="4"/>
    <table align="center" width="90%">
      <tr><td colspan="2">�����ţ�<%= strRegistNo %></td></tr>
      <tr></tr><td colspan="2">���յ��ţ�<%= strPolicyNo %></td></tr>
      <tr></tr><td colspan="2">�����������ƣ�<%= strPolicyName %></td></tr>
      <tr></tr><td colspan="2">�������˵�ַ��<%= strPolicyAddress %></td></tr>
      <tr></tr><td colspan="2">���ս�<%=strCurrency%><%=new DecimalFormat("#,##0.00").format(dbSumAmount)%></td></tr>
      <tr></tr><td colspan="2">���ձ�ģ�</td></tr>
      <tr></tr><td colspan="2">���ձ�ĵ�ַ��</td></tr>
      <tr></tr><td colspan="2">����˵����</td></tr>
      <tr></tr><td>Ͷ�����ڣ�<%=OperateDate %></td><td>¼�����ڣ�<%=UnderWriteEndDate %></td></tr>
      <tr></tr><td>ǩ�����ڣ�<%=SignDate %></td><td>�������ڣ�<%=InputDate %></td></tr>
      <tr></tr><td colspan="2">�����ڼ䣺<%=StartDate %> �� <%=EndDate %></td></tr>
      <tr></tr><td colspan="2">�Ƿ��漰�ٱ���������������<%= strCoinsFlag %></td></tr>
      <tr></tr><td colspan="2">�ر�Լ����</td></tr>
      <tr><td colspan="2"><hr align="center" width="90%" size="2"/></td></tr>
     <% //��������ʾ����\��������Ϣ
      if(strClassCode.equals("04")){ //�ͻ�Ҫ����������ʾ���ա������յ��޶�
      System.out.println("000000000000000000000000000000������");
   %>  <tr>
       <td colspan="2">
       <table align="center" width="100%"> 
      
        <tr><td colspan="7">�����⳥�޶</td></tr>
       	<tr>
      	  <td align="center" width="20%" >Ӫҵ��������</td>
      	  <!--<td align="left" width="10%" >��ַ���</td>-->
      	  <td align="left" width="10%" >�ұ�</td>
      	  <td align="left" width="20%" >���</td>
      	  <!--<td align="left" width="15%" >�ۻ��⳥�޶�</td>
      	  <td align="left" width="10%" >ÿ���⳥�޶�</td>
          <td align="left" width="15%" >ÿ���¹ʲƲ���ʧ�⳥�޶�</td>
          <td align="left" width="15%" >ÿ���¹����������⳥�޶�</td>
          <td align="left" width="10%" >���У�ÿ���⳥�޶�</td>-->
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


  <tr><td colspan="7">�������⳥�޶</td></tr>
        <tr>
          <td align="center" width="20%" >Ӫҵ��������</td>
      	 <!-- <td align="left" width="10%" >��ַ���</td>-->
      	  <td align="left" width="5%" >�ұ�</td>
      	  <td align="left" width="15%" >���</td>
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
      <tr><td colspan="2">�����գ�</td></tr>
      <tr>
        <td colspan="2">
      	  <table width="90%" align="center">
      	<tr>
      	  <td align="left" width="50%" > ����</td>
          <td align="left" width="30%" > ����/�޶�  </td>
          <td align="left" width="20%" >ÿ���⳥�޶�</td>
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
  <tr><td colspan="2">���������</td></tr>
  <tr>
    <td colspan="2">
      <table width="90%" align="center">
        <tr>
          <td align="left" width="30%">������   </td>
          <td align="left" width="30%"> ����ԭ��  </td>
          <td align="left" width="20%">����ʱ��</td>
          <td align="left" width="20%">�˱���</td>
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
  <tr><td colspan="2">���ѵ��������</td></tr>                                                       
  <tr>
    <td colspan="2">
  	  <table width="90%" align="center">
  		  <tr>
  			  <td align="left">��������   </td>
  				<td align="left">������  </td>
  				<td align="left">Ӧ��</td>
  				<td align="left">ʵ��</td>
  				<td align="left">��������</td>
  			</tr>
  			<tr><td colspan="5"><hr align="center" width="90%" style="direction:inherit "/></td></tr>
  			<%for(i=0 ;i<strPlanEndorNo.length;i++){%>
  			<tr>
  				<td align="left"><%=iPlanNo[i]%></td>
  				<td align="left"><%=strPlanEndorNo[i]%></td>
  				<td align="left"><%=new DecimalFormat("#,##0.00").format(dbPlanFee[i])%></td>
  			  <td align="left"><%=new DecimalFormat("#,##0.00").format(dbRealFee[i])%></td>
  			  <!-- ����ʱ��Ϊ��ֵչʾ���� -->
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
                                             
  <tr><td colspan="2">��ʷ�⸶��¼��</td></tr> 
  
  <tr>
      <td colspan="2">
  	    <table width="90%" align="center">
  		    <tr>
  			    <td align="left">�鵵��   </td>
  				<td align="left"> ����ʱ��  </td>
  				<td align="left">δ�����</td>
  				<td align="left">�⸶���</td>
  			    <td align="left">�᰸����</td>
  				<td align="left">������</td>
  				<td align="left">�⸶����</td>
  			</tr>
  			<tr><td colspan="7"><hr width="90%" align="center" style="direction:inherit "/></td></tr>
  		</table>
  	</td>
  </tr>
  <tr><td colspan="2"><hr align="center" width="90%" size="4"/></td></tr>
  <tr><td>�����ˣ�</td><td>�������ڣ�</td></tr>
		</table>
<%
  }
%>		
		 <!--include��ӡ��ť-->
  <jsp:include page="/common/print/PrintButton.jsp" />
	</body>
</html>
