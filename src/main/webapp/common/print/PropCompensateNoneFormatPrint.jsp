<%--
****************************************************************************
* DESC       ���Ʋ����������ӡҳ��
* AUTHOR     ��hanliang
* CREATEDATE ��2005-12-12
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/claim-app.tld" prefix="app" %>
<%-- ��ʼ�� --%>
  <%@include file="PropCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title><%=strRiskName%>��������</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="40"  align=center style="font-family:����; font-size:14pt;">
            <B><%=strRiskName%>��������<B>
          </td>
        </tr>
      </table>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���������:<%=prpLcompensateDto.getCompensateNo()%>
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">

		  <tr align="center">
			<td colspan="2" height="30" width="15%">���յ�����</td>
			<td colspan="3" id="tdPolicyNo"  width="30%">&nbsp;</td>
			<td  width="15%">�ⰸ��� </td>
			<td colspan="2" id="tdClaimNo">&nbsp;<%=strClaimNo%></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">��������</td>
			<td colspan="3" id="tdInsuredName">&nbsp;</td>
			<td>��������</td>
			<td colspan="2" id="tdEndorseNo">&nbsp;<%=strEndorseNo%></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">���ս��</td>
			<td colspan="3" id="tdSumAmount1">&nbsp;<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%></td>
			<td>���ձ��</td>
			<td colspan="2" id="tdLossName">&nbsp;<%=stritemKind%></td>
		  </tr>
		  <tr align="center">
			<td colspan="2">��ĵ�ַ��</td>
			<td colspan="7" height="30">&nbsp;<%= prpLclaimDto.getDamageAddress()%></td>
		  </tr>
			<tr align="center">
			<td colspan="2" height="30">��������</td>
			<td colspan="7" id="tdInsuredDate">&nbsp;<%=strInsuredDate%></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">���յص�</td>
			<td colspan="3" id="tdDamageAddress">&nbsp;</td>
			<td>��������</td>
			<td colspan="2" id="tdDamageStartDate">&nbsp;</td>
		  </tr>	
		   <tr align="center">
			<td colspan="2" height="30">�������˿�������</td>
			<td colspan="3" id="bank">&nbsp;<%=prpLcompensateDto.getBank()%></td>
			<td>֧���ʺ�</td>
			<td colspan="2" id="account">&nbsp;<%=prpLcompensateDto.getAccount()%></td>
		  </tr>
		   <tr align="center">
		     <td colspan="2">�տ���ȫ�ƣ�</td>
			 <td colspan="7" height="30">&nbsp;<%= prpLcompensateDto.getReceiverName()%></td>       
          </tr>  	  	   
		  <tr align="center">
			<td  width="3%" height="160">�����㷽ʽ</td>
			<td colspan="7" id="tdContext" align="left" valign="top">&nbsp;<%=strContext%></td>
		  </tr>
		  <tr align="left">
			<td colspan="8" height="30">&nbsp;&nbsp;�����ϼƣ���д������ң�&nbsp;<%=strCSumLossPay%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)����&nbsp;<%=strSumLossPay%>Ԫ</td>
		  </tr>
		  </table>
		  
		  
		  <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
		  <tr align="center">
			<td width="14%" colspan="2" height="30">���˶�</td>
			<td width="13%">���</td>
			<td width="13%">����</td>
			<td width="30%" colspan="3" rowspan="5" align="left" valign="top" id="tdHandlerName"></td>
			<td width="30%" rowspan="5" align="left" valign="top" id="tdUnderWriteName"></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">������</td>
			<td id="tdSumLoss">&nbsp;</td>
			<td id="tdCurrency2">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">�������⸶</td>
			<td id="">&nbsp;</td>
			<td id="">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">ʩ�ȷ�</td>
			<td id="tdRescueFee">&nbsp;</td>
			<td id="tdMRescueFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">�鿱��</td>
			<td id="tdCheckFee">&nbsp;</td>
			<td id="tdMCheckFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">���������</td>
			<td id="tdJudgeFee">&nbsp;</td>
			<td id="tdMJudgeFee">&nbsp;</td>
			<td colspan="4" rowspan="6" align="left" valign="top">&nbsp;�ܾ����������<br><br><br><br><br><br><br><br><br><br><br><p align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;</p></td>
			
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">���������</td>
			<td id="tdGsjzFee">&nbsp;</td>
			<td id="tdMGsjzFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">������</td>
			<td id="tdAssessFee">&nbsp;</td>
			<td id="tdMAssessFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">���ɷ�</td>
			<td id="tdFlFee">&nbsp;</td>
			<td id="tdMFlFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">����</td>
			<td id="tdElseFee">&nbsp;</td>
			<td id="tdMElseFee">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">�ϼ�</td>
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
    if(intCtextCountTmp>6){
    	%>
    
        <table width="92%"  align="center" cellspacing="0" cellpadding="0" border="1" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
        <tr>
          <td align=center style="font-family:����; font-size:14pt;">�����㷽ʽ�嵥</td>
        </tr>
        <tr>
          <td  align="left" valign="top"><%=strContext1%></td>
        </tr>
        </table>
        <% }%>
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
     
	        <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
  </body>

</html>
