<%--
****************************************************************************
* DESC       ����Ԫ��Ŀ��ũ�����������ӡ���ݳ�ʼ��ҳ��
* AUTHOR     ������
* CREATEDATE ��2007-12-12
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
  <%@include file="AgriCompensateNoneFormatPrintGyNbIni.jsp"%>
<html>
  <head>
    <title><%=strRiskName%>��������</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
      <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="30" align="center" style="font-family:����; font-size:14pt;">            
          <img src="/claim/images/LOGO.jpg"/>
        </td>
      </tr>      
        <tr>
          <td colspan="3" height="35"  align=center style="font-family:����; font-size:14pt;">
            <B><%=strRiskName%>��������<B>
          </td>
        </tr>
      </table>
      <table border="0" align="center" width="100%">
      <tr>
      	<td width="50%" align="left">
      	�������ƣ�<%=strRiskName%>
      	</td>
      	<td width="50%" align="right">
      	  ���������:<%=prpLcompensateDto.getCompensateNo()%>
      	</td>
          </tr>
       </table>
      <table border="1" width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
		  <tr align="center">
			<td height="30" width="12.5%">���յ�����</td>
			<td colspan="3" id="tdPolicyNo"  width="37.5%">&nbsp;</td>
			<td width="12.5%">��������</td>
			<td colspan="3" width="37.5%" id="tdEndorseNo">&nbsp;<%=strEndorseNo%></td>
		  </tr>
		  <tr align="center">
			<td  height="30">��������</td>
			<td colspan="3" >&nbsp;<%=RegistNo%></td>
			<td >��������</td>
			<td colspan="3" id="tdClaimNo">&nbsp;<%=strClaimNo %></td>
		  </tr>
		   <tr align="center">
			<td colspan="1">��������</td>
			<td colspan="7" height="30" id="tdInsuredName">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td  height="30">���ս��</td>
			<td colspan="3" id="tdSumAmount1">&nbsp;<%=new DecimalFormat("#,##0.00").format(dblSumAmount1)%></td>
			<td >���ձ��</td>
			<td colspan="3" id="tdLossName">&nbsp;<%=prpLclaimDto.getLossName()%></td>
		  </tr>
		  <tr align="center">
			<td colspan="1">��ĵ�ַ</td>
			<td colspan="7" height="30">&nbsp;<%=strInsuredAddress%></td>
		  </tr>
		  <tr align="center">
			<td colspan="1" >��������</td>
			<td colspan="7" id="tdInsuredDate" height="30">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td height="30">���յص�</td> 
			<td colspan="3" id="tdDamageAddress">&nbsp;</td>
			<td >��������</td>
			<td colspan="3" id="tdDamageStartDate">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="1">����ԭ��</td>
			<td colspan="7" height="30">&nbsp;<%=strDamageName %></td>
		  </tr>
		  <tr align="center">
			<td  width="15%" height="200">�����㷽ʽ</td>
			<td colspan="7" id="tdContext" align="left" valign="top">&nbsp;<%=strContext%></td>
		  </tr>
		  <tr align="left">
			<td colspan="8" height="30">&nbsp;&nbsp;�����ϼƣ���д������ң�&nbsp;<%=strPkhjSumPaid%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Сд)����&nbsp;<%=dbpkhjfee%>Ԫ</td>
		  </tr>
        <tr align="center">
			<td height="30">���˶�</td>
			<td colspan="2">��Ԫ��</td>
			<td colspan="1">�ұ�</td>
			<td colspan="4"  align="left" colspan="4" rowspan="5" valign="top">&nbsp;��˾�쵼�����<br><br><br><br><br><br><br><br><br><br><br><p align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;</p></td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">������</td>
			<td id="tdSumLoss">&nbsp;</td>
			<td id="tdCurrency2">&nbsp;</td>
		  </tr>
		  <tr align="center">
			<td colspan="2" height="30">�������⸶</td>
			<td id="">&nbsp;---</td>
			<td id="">&nbsp;�����</td>
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
			<td  width="25%" align="left"  colspan="2" rowspan="6" valign="top" id="tdHandlerName"></td>
			<td  width="25%" align="left"  colspan="2" rowspan="6" valign="top" id="tdUnderWriteName"></td>
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
			<td colspan="2" height="30">���鿱��</td>
			<td id="tdDCheckFee">&nbsp;</td>
			<td id=tdMDCheckFee>&nbsp;</td>
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
      
      
      <table width="100%" align="center" cellspacing="0" cellpadding="0" border="0">
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
	        <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />     
  </body>

</html>
