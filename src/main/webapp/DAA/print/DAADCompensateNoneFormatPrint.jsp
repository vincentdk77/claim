<%--
****************************************************************************
* DESC       ����������ǿ�Ʊ������������ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��22004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>

  <%-- ��ʼ�� --%>
  <%@include file="DAADCompensateNoneFormatPrintIni.jsp"%>

<html>
  <head>
    <title>���������������������ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  <meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  <style type="text/css">
<!--
.style2 {font-size: 10pt}
.STYLE3 {font-size: 10px}
.STYLE6 {font-size: 14px}
-->
  </style>
  </head>

  <body bgcolor="#FFFFFF" onLoad="loadForm();">
    <form name="fm">
      <!-- ���ⲿ�� -->
     <table width="92%" align="center"��cellpadding="2" cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td colspan="2" height="40" align=center style="font-family:����; font-size:14pt;">
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>
        <tr>
          <td colspan="2" height="40"  align=center style="font-family:����; font-size:16pt;">
            <p align=center><B>��������������������<B></p>
          </td>
       </tr>
     </table>
     <!-- ���岿�� -->
     <table width="92%" align="center" cellspacing="0" cellpadding="2"  style="font-size: 10pt;border-collapse:collapse; bordercolor:#111111;">
       <tr>
         <td align=left colspan="2" id="tdPolicyNo" style="font-family:����; font-size:9pt;">���յ��ţ�
         </td>
       </tr>
       <tr>
         <td align=left id="tdRegistNo" style="font-family:����; font-size:9pt;">������ţ�</td>
         <td align=right id="tdCompensateNo" style="font-family:����; font-size:9pt;">��������ţ�</td>
       </tr>
     </table>
     <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2"  style="font-size: 10pt;border-collapse:collapse; bordercolor:#111111;">
        <tr>
          <td height="23" align="left" width="10%"><span class="style2">��������</span></td>
          <td id="tdInsuredName"  colspan="7"></td>
          <td width="10%" align="center" class="style2">�������</td>
          <td id="tdCarClause"colspan="3" ></td>
        </tr>

        <tr height="23">
          <td width="10%" align="left" class="style2">�����ͺ�</td>
          <td id="tdBrandName" colspan="3"></td>
          <td align="center" width="10%">�������ü�</td>
          <td id="tdPurchasePrice" colspan="3"></td>

          <td align="center" width="10%">�¹����</td>
          <td id="tdIndemnityType" colspan="3"></td>
        </tr>
        <tr height="23">
          <td align="left" width="10%">���ƺ���</td>
          <td id="tdLicenseNo" colspan="3">&nbsp;</td>
          <td align="center" width="10%">�����ձ���</td>
          <td id="tdSumAmount1" colspan="3">&nbsp;</td>
          <td align="center" width="10%">���α���</td>
          <td id="tdIndemnityDutyRate" colspan="3"></td>
        </tr>





        <tr height="23">
          <td align="left" width="10%">��������</td>
          <td id="tdDamageStartDate" colspan="3"></td> 
          <td align="center" width="10%">���������޶�</td>
          <td id="tdAmount" colspan="3"></td>
          <td align="center" width="10%">�������</td>
          <td id="tdLossRate" colspan="3"></td>
        </tr>
    
        <tr height="23">
          <td align="left" width="10%">���յص�</td>
          <td id="tdDamageAddress" colspan="3"></td>

          <td align="center" width="10%">��������</td>
          <td id="tdInsuredDate" colspan="7"></td>
        </tr>
    
   <!--     
         <tr height="23">
          <td align="left" width="15%">&nbsp;����ԭ��</td>
          <td id="tdDamageName" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;�¹�����</td>
          <td id="tdIndemnityDuty" colspan="3">&nbsp;</td>
          <td align="center" width="10%">&nbsp;�����޶�</td>
          <td id="tdSumAmount2" colspan="3">&nbsp;</td>
        </tr>
        -->
		<!-- weiqun temp edit -->
	<!--	
	<tr height="23">
          <td align="left" width="15%">&nbsp;ָ����ʻԱ</td>
          <td id="tdDriverName1" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;����������</td>
          <td id="" colspan="3">&nbsp;</td>
          
          <td align="center" width="10%">&nbsp;�ⰸ���</td>
          <td id="tdClaimType" colspan="3">&nbsp;</td>
        </tr>
        -->
        <!--
	       <tr height="23">
	       ��<td align="left" width="15%">&nbsp;���ռ�ʻԱ</td>
          <td id="tdDriverName" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;���������</td>
          <td id="" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;�����������</td>
          <td id="tdDamageAddressType" colspan="3">&nbsp;</td>          
        </tr>
        -->
        <!--
        
        <tr>
          <td align="left" width="15%">&nbsp;��ʧ�̶�</td>
          <td id="tdSumClaim" colspan="3">&nbsp;</td>
          <td align="left" width="15%">&nbsp;��ʻ����</td>
          <td id="tdRunAreaName" colspan="3">&nbsp;</td>

        </tr>
        
        -->
        <!--
	<tr height="23">
          <td align="left" width="15%">&nbsp�¹ʴ�����</td>
          <td id="tdHandleUnit" colspan="3">&nbsp;</td>
          <td align="center" width="15%">&nbsp;��Ա�������</td>
          <td id="tdPersonInjure" colspan="9">&nbsp;</td>
        </tr>
        
        -->
		<!-- weiqun temp edit -->
        <!--modified by zhangli 20070511-->
         <%
	        String bank = "";
	        if(!"0.0".equals(prpLcompensateDto.getBank())&&!"0.0".equals(prpLcompensateDto.getBank())
	           &&!"0.00".equals(prpLcompensateDto.getBank())){
	           bank = prpLcompensateDto.getBank();
            }         
        %>
         <tr height="23">
          <td align="left" width="10%">�������˿�������</td>
          <td id="bank" colspan="3">&nbsp;<%=bank%></td>

          <td align="center" width="10%">֧���ʺ�</td>
          <td id="account" colspan="7">&nbsp;<%=prpLcompensateDto.getAccount()%></td>
        </tr>  
         <tr height="23">
          <td align="left" width="10%">�տ���ȫ��</td>
          <td id="bank" colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>

          <td align="center" width="10%"></td>
          <td id="account" colspan="7">&nbsp;</td>
        </tr>  
        <tr>
          <td align="center" colspan="12" height="19"> ��&nbsp;&nbsp;&nbsp;
          ��&nbsp;&nbsp;&nbsp;
          ��&nbsp;&nbsp;&nbsp;
          ��&nbsp;&nbsp;&nbsp;
          ��&nbsp;&nbsp;&nbsp;
          ʽ </td>
        </tr>
         
         
        
        <tr>
          <td id="tdContext" colspan="12" height="230" valign="top">
            <input type=text rows=18 cols=90 class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt">          </td>
        </tr>

                <tr>
          <td colspan="4">
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdJudgeFee"><span class="STYLE3">&nbsp;</span>������<span class="STYLE3">��</span></td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdCheckFee1"><span class="STYLE3">&nbsp;</span>���鿱��<span class="STYLE3">��</span></td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
          

          
          
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdLawFee">&nbsp;���ϡ��ٲ÷�<span class="STYLE3">��</span></td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        
       <tr>
        <!--  <td colspan="4">
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td id="tdSerialNo" height="23">&nbsp;��Ԥ��������</td>
                <td align=right>��&nbsp;</td>
              </tr>
            </table>

          </td>  -->
          
          <td colspan="4">
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdJianYan">&nbsp;����ѣ�</td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
       
       
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdCheckFee">&nbsp;�鿱��<span class="STYLE3">��</span></td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdAssessFee">&nbsp;�����ѣ�</td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        
        
        <tr>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdElseFee">&nbsp;��������<span class="STYLE3">��</span></td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdSumPrePaid">&nbsp;��Ԥ�����<span class="STYLE3">��</span></td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
          <td colspan="4">

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr>
                <td height="23" id="tdSumRest">&nbsp;��������/��ֵ��</td>
                <td align=right>Ԫ&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>

<!--
        <tr>
          <td colspan=12>

            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="23">
                <td id="tdCSumThisPaid" width="70%">&nbsp;����ʵ��������Ҵ�д����</td>
                <td id="tdSumThisPaid" width="30%">&nbsp;</td>
                <td align=right>Ԫ��&nbsp;</td>
              </tr>
            </table>

          </td>
        </tr>
        -->
        <tr>
          <td colspan=12>

            <table width="100%" height="80%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="23">
                <td width="70%" id="tdCSumPaid">&nbsp;��ҵ�������ϼƣ�����Ҵ�д����</td>
                <td id="tdSumPaid" width="30%">&nbsp;</td>
                <td align=right>Ԫ��&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        
        <tr>
          <td colspan=12>

            <table width="100%" height="80%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="23">
                <td width="70%" id="tdCAllSumPaid">&nbsp;���ϼƣ�����Ҵ�д����</td>
                <td id="tdAllSumPaid" width="30%">&nbsp;</td>
                <td align=right>Ԫ��&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>

         <tr>
          <td colspan="4" width="50%">

            <table width="50%" height="50%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top" id="tdHandlerName"></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right" id="tdInputDate"></td>
              </tr>
            </table>          </td>
          <td colspan="8" width="50%">

            <table width="50%" height="50%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top" id="tdUnderWriteName"></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right" id="tdUnderWriteEndDate"></td>
              </tr>
            </table>          </td>
          
        </tr>


         <tr>
          <td colspan="12" height="60" align="left" valign="top">

            <table width="100%" height="50%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="40">
                <td width="33%" align="left" valign="top">&nbsp;�ϼ��������<span class="STYLE3">��</span></td>
              </tr>
              <tr height="20">
                <td width="33%" align="left">                </td>
              </tr>
            </table>          </td>
        </tr>
      </table>
 <!--     <br>
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
      <tr>
           <td  align="left" width="50%">&nbsp;���㣺<%=strOperatorName%></td>
           <td  align="left" width="50%">&nbsp;��ӡ���ڣ�<%=new DateTime(dateTime.current(),dateTime.YEAR_TO_DAY)%></td>
        </td>
      </table>   -->
      
      <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="left"><%=strPayRefName%></td>
      		<td align="right"><%=strPayRefDate%></td>
      	</tr>
      </table>
    </form>
    <br/><br/>
    <% if(intCtextCountTmp>20){ %>
        <table width="92%"  align="center" cellspacing="0" cellpadding="0" border="1" 
        		style="font-family:����; padding:5 5 5 5;font-size:10pt;border-collapse: collapse;display:<%=strDisplay %>" 
        		bordercolor="#111111" >
        <tr>
          <td align=center style="font-family:����; font-size:14pt;">�����㷽ʽ�嵥</td>
        </tr>
        <tr>
          <td  align="left" valign="top"><%=strContexTtemp%></td>
        </tr>
        </table>
    <% }%>
    <%--//modify by wangli update  start 20050422 --%>
    <%
     String PrintFlag="0";
     PrintFlag =request.getParameter("PrintFlag");
     if(PrintFlag == null){
   	%>
       <jsp:include page="/common/print/PrintButton.jsp" />
    <%
     }
    %>
      <%-- <jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
    <%--//modify by wangli update end 20050422 --%>
  </body>

</html>
