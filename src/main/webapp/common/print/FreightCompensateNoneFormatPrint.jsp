<%--
****************************************************************************
* DESC       �����������ӡҳ��
* AUTHOR     �� ��Ŀ��
* CREATEDATE ��2005-9-21
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<%-- ��ʼ�� --%>
<%@include file="FreightCompensateNoneFormatPrintIni.jsp"%>


<html>
  <head>
    <title>���������嵥��ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
  </head>

  <body bgcolor="#FFFFFF"  onload="loadForm();" >
<%
  //�����ռ�����
  if(strClassCode.equals("09") || strClassCode.equals("10")){
%>
    <!-- ���ⲿ�� -->
    <form name="fm">
    <table width="90%" align="center" cellspacing="0" cellpadding="0" border="0" >
        <tr height="40">
          <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>        
      <tr>
        <td colspan="2" align=center  style="font-size:14pt" >
          <B><%=strRiskName%>�������� <B>
        </td>
      </tr>
      <tr></tr>
      <tr><td id="tdCompensateNo" align="right" style="font-size:10pt" > <font size="2" >��������� ��</font></td></tr>
    </table>

    <table class="size11" border=1 width="90%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" >
      <tr>
        <td style="font-size:10pt"  width="15%" height="25">��������</td>
        <td style="font-size:10pt"  width="30%" id="tdInsuredName" colspan="2">&nbsp;</td>
        <td style="font-size:10pt"  width="15%">�� �� ��</td>
        <td style="font-size:10pt"  width="30%" id="tdClaimNo" colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td style="font-size:10pt"   height="25">���յ�����</td>
        <td style="font-size:10pt"  id="tdPolicyNo" colspan="2">&nbsp;</td>
        <td style="font-size:10pt" >��������</td>
        <td style="font-size:10pt" colspan="2" ><%=strInsuredDateTime%></td>
      </tr>
      <tr >      
        <td style="font-size:10pt"  height="25">���ս��</td>
        <td style="font-size:10pt"  id="tdSumAmount" colspan="2"><%=prpLclaimDto.getCurrency()%><%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%></td>
        <td style="font-size:10pt" >��������</td>
        <td style="font-size:10pt" colspan="2" ><%=StartDate%></td>
        <td style="font-size:10pt"  style="display:none">�� ��</td>
        <td style="font-size:10pt"  id="tdKindName" style="display:none">&nbsp;</td>
      </tr>
      <tr>
        <td style="font-size:10pt"  height="25">��������</td>
        <td style="font-size:10pt"  colspan="2">&nbsp;</td>
        <td style="font-size:10pt"  >���յص�</td>
        <td style="font-size:10pt"  colspan="2" id="tdDamageAddress"><%=prpLclaimDto.getDamageAddress()%></td>
      </tr>
      <tr style="display:" height="25">
        <td style="font-size:10pt"  >����·��</td>
        <td style="font-size:10pt"  colspan="2" id="tdLindline">&nbsp;</td>
        <td style="font-size:10pt"  width="20%">���ձ��</td>
        <td style="font-size:10pt"  width="30%" id="tdCount"  colspan="2"><%=strCount%></td>
      </tr>
      <tr style="display:" height="25">
        <td style="font-size:10pt"  >��������</td>
        <td style="font-size:10pt"  colspan="2"><%=strDamageStartDate%>&nbsp;</td>
        <td style="font-size:10pt"  width="20%">��������</td>
        <td style="font-size:10pt"  width="30%" colspan="2">  </tr>
      <tr style="display:" height="25">
        <td style="font-size:10pt"  >����ԭ��</td>
        <td style="font-size:10pt"  colspan="2" id="tdDamageTypeName" >&nbsp;</td>
        <td style="font-size:10pt"  width="20%">��������</td>
        <td style="font-size:10pt"  width="30%"  colspan="2">  </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >����ԭ��</td>
        <td style="font-size:10pt"  colspan="2" id="tdDamageTypeName">&nbsp;</td>
        <td style="font-size:10pt"  rowspan="2">���������</td>
        <td style="font-size:10pt"  rowspan="2" id="tdCheckAgentName">&nbsp;</td>
        <td style="font-size:10pt"  id="tdSumPrePaid"></td>
        <td style="font-size:10pt"  id="tdSumThisPaid"></td>
        <td style="font-size:10pt"  id="tdConveyance"></td>
      </tr>
      <tr >
        <td style="font-size:10pt" height="450px" align="center"><p>��<br>��<br>��<br>��<br>��<br>ʽ</p></td>
        <td style="font-size:10pt" colspan="5" id="tdContext" valign="top">
        <pre>
        <%=strContext%>
        </pre>
        </td>
      </tr>
      <tr>
        <td style="font-size:10pt" colspan="2" height="25">���ϼƣ���д�������</td>
        <td style="font-size:10pt"  id="tdCSumPaid" colspan="4"></td>
        <td style="font-size:10pt"  id="tdSumPaidCNY" style="display:none" >&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >���˶�</td>
        <td style="font-size:10pt"  width="93">���</td>
        <td style="font-size:10pt"  width="94">����</td>
        <td style="font-size:10pt"  colspan="3" align="center">�� �� ˵ ��</td>
      </tr>
      <tr  style="display:none">
        <td style="font-size:10pt"  >��Ʒ��ʧ</td>
        <td style="font-size:10pt"  id="tdSumRealpay"><%=strSumRealPayShow%></td>
        <td style="font-size:10pt"  id="tdCurrency4"><%=strCurrency4Show%></td>
        <td style="font-size:10pt"  colspan="3" rowspan="8" >
          <textarea rows="10" cols="150" class=readonly readonly White style="overflow:hidden;width:100%" style="font-size:10pt" >
            <%=strContext2%>
          </textarea>
        </td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�������⸶</td>
        <td style="font-size:10pt"  id="tdChargeAmount1">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY1">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >ʩ���������</td>
        <td style="font-size:10pt"  id="tdChargeAmount2">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY2">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� �� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount3">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY3">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� �� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount4">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY4">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� �� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount5">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY5">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount6">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY6">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td  style="font-size:10pt"  >�� ��</td>
        <td style="font-size:10pt" ></td>
        <td style="font-size:10pt"  ><%=strCurrency1%></td>
      </tr>
        <tr>
          <td rowspan="3" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="3" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;�ֹ�˾�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>   
          <td align="center" colspan="4" height="23">&nbsp;���֧��</td>               
        </tr>
        <tr height="23">
          <td align="left" width="11%">&nbsp;��Ʒ��ʧ</td>  
          <td align="left" id="tdSumRealpay" ><%=strSumRealPayShow%>&nbsp;<%//=strCurrency4Show%></td>            
        </tr>   
        <tr height="23">
          <td align="left" >&nbsp;�鿱����</td>  
          <td align="left" id="tdChargeAmount5" >&nbsp;</td>            
        </tr> 
        <tr >
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;�ֹ�˾��ϯ�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;�ܹ�˾�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td> 
          <td align="left"  height="23">&nbsp;�������</td>  
          <td align="left" id="tdChargeAmount3">&nbsp;</td>                               
         </tr>
         <tr height="23">
          <td align="left" >&nbsp;��������</td>  
          <td align="left" id="tdChargeAmount4" >&nbsp;</td>           
         </tr>
         <tr height="23">
          <td align="left" >ʩ���������</td>  
          <td align="left" id="tdChargeAmount2">&nbsp;</td>           
         </tr>
         <tr height="23">
          <td align="left">��������</td>  
          <td align="left" id="tdChargeAmount6" >&nbsp;</td>           
         </tr>
         <tr height="23">
          <td align="left">��&nbsp;&nbsp;&nbsp;��</td>  
          <td align="left"  id="tdSumPaid" ><%=strCurrency1%></td>           
         </tr>    
    </table>
    <table border=0 width="90%" align="center" cellspacing="0" cellpadding="2"
       style="border-collapse: collapse" bordercolor="#111111"
       style="font-family:����; font-size:10pt;"  style="display:none">
      <tr>
          <td style="font-size:10pt" > ���㣺_______</td>
          <td style="font-size:10pt" > ���죺_______</td>
          <td style="font-size:10pt" > ���⣺_______</td>
          <td style="font-size:10pt" > ���⣺_______</td>
      </tr>
     <tr>
  ������   <td style="font-size:10pt" >____��____��____��</td>
           <td style="font-size:10pt" >____��____��____��</td>
           <td style="font-size:10pt" >____��____��____��</td>
           <td style="font-size:10pt" >____��____��____�� </td>
     </tr>
    </table>
  </form>
<%
  } else {
  //�ǻ����ռ�����
%>
    <!--����Ϊ�ǻ����ռ�����-->
    <!-- ���ⲿ�� -->
    <form name="fm">
    <table width="90%" align="center" cellspacing="0" cellpadding="0" border="0" >
        <tr height="40">
          <td colspan="2" height="40" align="center" style="font-family:����; font-size:14pt;">            
            <img src="/claim/images/LOGO.jpg"/>
          </td>
        </tr>        
      <tr>
        <td colspan="2" align=center  style="font-size:14pt" >
          <B><%=strRiskName%>�������� <B>
        </td>
      </tr>
      <tr></tr>
      <tr><td id="tdCompensateNo" align="right" style="font-size:10pt" > <font size="2" >��������� ��</font></td></tr>
    </table>

    <table class="size11" border=1 width="90%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" >
      <tr>
        <td style="font-size:10pt"  width="15%" height="25">��������</td>
        <td style="font-size:10pt"  width="30%" id="tdInsuredName" colspan="2">&nbsp;</td>
        <td style="font-size:10pt"  width="15%">�� �� ��</td>
        <td style="font-size:10pt"  width="30%" id="tdClaimNo" colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td style="font-size:10pt"   height="25">���յ�����</td>
        <td style="font-size:10pt"  id="tdPolicyNo" colspan="2">&nbsp;</td>
        <td style="font-size:10pt" >��������</td>
        <td style="font-size:10pt" colspan="2" ><%=strInsuredDateTime%></td>
      </tr>
      <tr >      
        <td style="font-size:10pt"  height="25">���ս��</td>
        <td style="font-size:10pt"  id="tdSumAmount" colspan="2"><%=prpLclaimDto.getCurrency()%><%= new DecimalFormat("#,##0.00").format(prpLclaimDto.getSumAmount())%></td>
        <td style="font-size:10pt" >��������</td>
        <td style="font-size:10pt" colspan="2" ><%=StartDate%></td>
        <td style="font-size:10pt"  style="display:none">�� ��</td>
        <td style="font-size:10pt"  id="tdKindName" style="display:none">&nbsp;</td>
      </tr>
      <tr>
        <td style="font-size:10pt"  height="25">��������</td>
        <td style="font-size:10pt"  colspan="2">&nbsp;</td>
        <td style="font-size:10pt"  >���յص�</td>
        <td style="font-size:10pt"  colspan="2" id="tdDamageAddress"><%=prpLclaimDto.getDamageAddress()%></td>
      </tr>
      <tr style="display:" height="25">
        <td style="font-size:10pt"  >����·��</td>
        <td style="font-size:10pt"  colspan="2" id="tdLindline">&nbsp;</td>
        <td style="font-size:10pt"  width="20%">���ձ��</td>
        <td style="font-size:10pt"  width="30%" id="tdCount"  colspan="2"><%=strCount%></td>
      </tr>
      <tr style="display:" height="25">
        <td style="font-size:10pt"  >��������</td>
        <td style="font-size:10pt"  colspan="2"><%=strDamageStartDate%>&nbsp;</td>
        <td style="font-size:10pt"  width="20%">��������</td>
        <td style="font-size:10pt"  width="30%" colspan="2">  </tr>
      <tr style="display:" height="25">
        <td style="font-size:10pt"  >����ԭ��</td>
        <td style="font-size:10pt"  colspan="2" id="tdDamageTypeName" >&nbsp;</td>
        <td style="font-size:10pt"  width="20%">��������</td>
        <td style="font-size:10pt"  width="30%"  colspan="2">  </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >����ԭ��</td>
        <td style="font-size:10pt"  colspan="2" id="tdDamageTypeName">&nbsp;</td>
        <td style="font-size:10pt"  rowspan="2">���������</td>
        <td style="font-size:10pt"  rowspan="2" id="tdCheckAgentName">&nbsp;</td>
        <td style="font-size:10pt"  id="tdSumPrePaid"></td>
        <td style="font-size:10pt"  id="tdSumThisPaid"></td>
        <td style="font-size:10pt"  id="tdConveyance"></td>
      </tr>
      <tr >
        <td style="font-size:10pt" height="450px" align="center"><p>��<br>��<br>��<br>��<br>��<br>ʽ</p></td>
        <td style="font-size:10pt" colspan="5" id="tdContext" valign="top">
        <pre>
        <%=strContext%>
        </pre>
        </td>
      </tr>
      <tr>
        <td style="font-size:10pt" colspan="2" height="25">���ϼƣ���д�������</td>
        <td style="font-size:10pt"  id="tdCSumPaid" colspan="4"></td>
        <td style="font-size:10pt"  id="tdSumPaidCNY" style="display:none" >&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >���˶�</td>
        <td style="font-size:10pt"  width="93">���</td>
        <td style="font-size:10pt"  width="94">����</td>
        <td style="font-size:10pt"  colspan="3" align="center">�� �� ˵ ��</td>
      </tr>
      <tr  style="display:none">
        <td style="font-size:10pt"  >��Ʒ��ʧ</td>
        <td style="font-size:10pt"  id="tdSumRealpay"><%=strSumRealPayShow%></td>
        <td style="font-size:10pt"  id="tdCurrency4"><%=strCurrency4Show%></td>
        <td style="font-size:10pt"  colspan="3" rowspan="8" >
          <textarea rows="10" cols="150" class=readonly readonly White style="overflow:hidden;width:100%" style="font-size:10pt" >
            <%=strContext2%>
          </textarea>
        </td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�������⸶</td>
        <td style="font-size:10pt"  id="tdChargeAmount1">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY1">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >ʩ���������</td>
        <td style="font-size:10pt"  id="tdChargeAmount2">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY2">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� �� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount3">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY3">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� �� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount4">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY4">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� �� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount5">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY5">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td style="font-size:10pt"  >�� ��</td>
        <td style="font-size:10pt"  id="tdChargeAmount6">&nbsp;</td>
        <td style="font-size:10pt"  id="tdChargeAmountCNY6">&nbsp;</td>
      </tr>
      <tr style="display:none">
        <td  style="font-size:10pt"  >�� ��</td>
        <td style="font-size:10pt" ></td>
        <td style="font-size:10pt"  ><%=strCurrency1%></td>
      </tr>
        <tr>
          <td rowspan="3" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="55">
                <td width="33%" align="left" valign="top">&nbsp;�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="3" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="55">
                <td width="33%" align="left" valign="top">&nbsp;�ֹ�˾�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>   
          <td align="center" colspan="4" height="23">&nbsp;���֧��</td>               
        </tr>
        <tr height="23">
          <td align="left" width="11%">&nbsp;��Ʒ��ʧ</td>  
          <td align="left" id="tdSumRealpay" ><%=strSumRealPayShow%>&nbsp;<%//=strCurrency4Show%></td>            
        </tr>   
        <tr height="23">
          <td align="left" >&nbsp;�鿱����</td>  
          <td align="left" id="tdChargeAmount5" >&nbsp;</td>            
        </tr> 
        <tr >
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="90">
                <td width="33%" align="left" valign="top">&nbsp;�ֹ�˾��ϯ�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="90">
                <td width="33%" align="left" valign="top">&nbsp;�ܹ�˾�����������</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td> 
          <td align="left"  height="23">&nbsp;�������</td>  
          <td align="left" id="tdChargeAmount3">&nbsp;</td>                               
         </tr>
         <tr height="23">
          <td align="left" >&nbsp;��������</td>  
          <td align="left" id="tdChargeAmount4" >&nbsp;</td>           
         </tr>
         <tr height="23">
          <td align="left" >ʩ���������</td>  
          <td align="left" id="tdChargeAmount2">&nbsp;</td>           
         </tr>
         <tr height="23">
          <td align="left">��������</td>  
          <td align="left" id="tdChargeAmount6" >&nbsp;</td>           
         </tr>
         <tr height="23">
          <td align="left">��&nbsp;&nbsp;&nbsp;��</td>  
          <td align="left"  id="tdSumPaid" ><%=strCurrency1%></td>           
         </tr>    
    </table>
    <table border=0 width="90%" align="center" cellspacing="0" cellpadding="2"
       style="border-collapse: collapse" bordercolor="#111111"
       style="font-family:����; font-size:10pt;"  style="display:none">
      <tr>
          <td style="font-size:10pt" > ���㣺_______</td>
          <td style="font-size:10pt" > ���죺_______</td>
          <td style="font-size:10pt" > ���⣺_______</td>
          <td style="font-size:10pt" > ���⣺_______</td>
      </tr>
     <tr>
  ������   <td style="font-size:10pt" >____��____��____��</td>
           <td style="font-size:10pt" >____��____��____��</td>
           <td style="font-size:10pt" >____��____��____��</td>
           <td style="font-size:10pt" >____��____��____�� </td>
     </tr>
    </table>
  </form>
<%}%>
  <!--include��ӡ��ť-->
  <jsp:include page="/common/print/PrintButton.jsp" />
  </body>
</html>