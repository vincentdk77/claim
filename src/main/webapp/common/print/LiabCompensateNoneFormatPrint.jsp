<%--
****************************************************************************
* DESC       �����������������������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��22004-11-16
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
  <%@include file="LiabCompensateNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title><%=strRiskName%>���������ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312"></head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;">
                <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>      
        <tr>
          <td colspan="3" height="40" align=center style="font-family:����; font-size:14pt;">
            <B><%=strRiskName%>���������<B><br>
          </td>
        </tr>

        <tr>
         
          <td width="50%" align=left id="tdCompensateNo" style="font-family:����; font-size:10pt;">
            ��������ţ�
1         </td>
 <td width="50%" align=left style="font-family:����; font-size:10pt;">
            
          </td>
        </tr>
      </table>

      <!-- ���岿�� -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
  <tr align="center">
    <td width="12%">�ⰸ���</td>
    <td colspan="2" id="tdClaimNo">&nbsp;</td>
    <td width="12%" height="30">��������</td>
    <td colspan="3" id="tdInsuredName">&nbsp;</td>

  </tr>
  <tr align="center">
    <td width="12%" height="30" >��������</td>
    <td colspan="2" id="tdPolicyNo" >&nbsp;</td>
    <td width="12%">����ʱ��</td>
    <td colspan="3" id="tdDamageStartDate">&nbsp;</td>   
       
    <td width="12%" style="display:none;">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>
    <td colspan="3" id="tdRiskName" style="display:none;">&nbsp;</td>
  </tr>
  <tr align="center">
    <td width="12%" height="30" style="display:none;">��&nbsp;��&nbsp;��</td>
    <td colspan="2" id="tdEndorseNo" style="display:none;">&nbsp;</td>
    
    <td width="12%" height="30">���ս��</td>
    <td colspan="2" id="tdOldSumAmount">&nbsp;</td>
    <td width="12%" height="30">���յص�</td>
    <td colspan="3" id="tdDamageAddress">&nbsp;</td>

  </tr>
  <tr align="center">    
    <td width="12%" height="30">��Ч����</td>
    <td colspan="2" id="tdSumAmount">&nbsp;</td>
    <td width="12%">����ԭ��</td>
    <td colspan="3" id="tdDamageName">&nbsp;</td>
  </tr>
  <tr align="center">
    <td width="12%" height="30" style="display:none;">�⳥�޶�</td>
    <td colspan="3" id="tdSumAmount2" style="display:none;">&nbsp;</td>
    
    <td width="12%" height="30" >��������</td>
    <td colspan="2" id="tdInsuredDate" >&nbsp;</td>    
    <td width="12%">���ձ��</td>
    <td colspan="3" id="tdLossName">&nbsp;</td>
  </tr>
  <tr align="center" >
    <td width="12%" height="30">�������˿�������</td>
    <td colspan="3" id="bank">&nbsp;<%=prpLcompensateDto.getBank()%></td>
    <td width="12%">֧���ʺ�</td>
    <td colspan="2" id="account">&nbsp;<%=prpLcompensateDto.getAccount()%></td>
  </tr>
  <tr align="center" >
          <td width="15%" height="30" >�տ���ȫ��</td>
          <td id="bank"  colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>    
          <td width="15%" align="left" ></td>     
          <td id="account" align=left  colspan="2"></td>          
        </tr> 
  <tr align="center">
    <td height="140" colspan="7" id="tdContext" valign="top" align="left">���㹫ʽ�������</td>
  </tr>
  <tr align="center" style="display:none;">
    <td width="12%" height="30">��������</td>
    <td colspan="2" id="tdPersonSumLossPay">&nbsp;</td>
    <td width="12%">�Ʋ���ʧ</td>
    <td colspan="3" id="tdPropSumLossPay">&nbsp;</td>
  </tr>
  <tr align="center" style="display:none;">
    <td width="12%" height="30">���Ϸ���</td>

    <td colspan="2">&nbsp;</td>
    
    <td width="12%">��������</td>

    <td colspan="3">&nbsp;</td>
    
  </tr>
  <tr align="center" style="display:none;">
    <td colspan="7" height="30" id="tdCSumLossPay" align="left">�������</td>
  </tr>
  <tr align="center" style="display:none;">
    <td colspan="2" rowspan="5" valign="top" align="left" id=" " ></td>
    <td colspan="3" rowspan="5" valign="top" align="left" id="   " ></td>
    <td colspan="2" height="30">���֧��</td>
  </tr>
  <tr style="display:none;">
    <td width="12%" align="center" height="30">�������</td>
    <td width="17%" align="center" id=" ">&nbsp;</td>
  </tr>
  
  <tr align="center" >
    <td rowspan="4">��������</td>
    <td width="12%" align="center" height="30">���ձ����ʧ</td>
    <td width="17%" align="center" id="tdSSumLossPay" colspan="2">&nbsp;</td> 
    <td width="12%" height="30">�ϼƽ��</td>
    <td width="17%" id="tdSSumPaid" colspan="2">&nbsp;</td>   
  </tr>

  <tr align="center">
    <td width="12%" align="center" height="30">ʩ�ȷ���</td>
    <td width="17%" align="center" id="tdRescueFee" colspan="2">&nbsp;</td>
    <td width="12%" align="center" height="30">&nbsp;</td>
    <td width="17%" align="center" id=" " colspan="2">&nbsp;</td>    
  </tr>
  <tr align="center">
    <td width="12%" align="center" height="30">�鿱����</td>
    <td width="17%" align="center" id="tdCheckFee" colspan="2">&nbsp;</td>
    <td width="12%" align="center" height="30">ʵ����</td>
    <td width="17%" align="center" id="tdtSumThisPaid" colspan="2">&nbsp;</td>    
  </tr>
  <tr align="center">
    <td width="12%" align="center" height="30">������</td>
    <td width="17%" align="center" id="tdJudgeFee" colspan="2">&nbsp;</td>
    <td width="12%" align="center" height="30">��������</td>
    <td width="17%" align="center" id="tdPayDate" colspan="2">&nbsp;</td>
  </tr>
<tr align="center" style="display:none;"><td rowspan="5" colspan="7" >123&nbsp;</td></tr>
  <tr align="center">
    <td colspan="7"  valign="top" align="left">&nbsp;���������:<br><br><br><br><br><br><br><br><p align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;</p></td>
    
    <td width="12%" height="30" style="display:none;">���������</td>
    <td width="17%" id="tdGsjzFee" style="display:none;">&nbsp;</td>
  </tr>
  <tr align="center">
    <td colspan="7"  valign="top" align="left">&nbsp;����˾�쵼�˶���<br><br><br><br><br><br><br><br><p align="right">��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;</p></td>
  </tr>
  
  <tr align="center" style="display:none;">
    <td width="12%" height="30">������</td>
    <td width="17%" id='tdAssessFee'>&nbsp;</td>
  </tr>
  
  <tr align="center" style="display:none;">
    <td width="12%" height="30">���ɷ�</td>
    <td width="17%" id='tdFlFee'>&nbsp;</td>
  </tr>  
  
  <tr align="center" style="display:none;">
    <td width="12%" height="30">����</td>
    <td width="17%" id="tdElseFee">&nbsp;</td>
  </tr>

<table border=0 width="100%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">

  <tr align="center">
    <td width="12%">&nbsp;</td>
    <td colspan="2" >&nbsp;</td>
    <td width="12%" >&nbsp;</td>
    <td colspan="3" >&nbsp;</td>
  </tr>
  <tr>
    <td align="right">���ƣ�</td>
    <td align="left" colspan="2" id="tdHandlerName" ></td>
    <td align="right">��ˣ�</td>
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
    
        <table width="92%"  align="center" cellspacing="0" cellpadding="0" border="1" style="border-collapse: collapse;display:<%=strDisplay %>" bordercolor="#111111" style="font-family:����; font-size:10pt;">
        <tr>
          <td align=center style="font-family:����; font-size:14pt;">�����㷽ʽ�嵥</td>
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