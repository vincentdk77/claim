<%--
****************************************************************************
* DESC       �����ڻ������䱣������������ӡҳ��
* AUTHOR     ��zhuly
* CREATEDATE ��2005-11-15
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
<%@include file="FreightNationalCompensateNoneFormatPrintIni.jsp"%>
<html>
  <head>
    <title>���ڻ������䱣������������ӡ</title>
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
            <B>���ڻ������䱣�����������<B>
          </td>
        </tr>
        <!--<tr>
          <td width="50%" align=left style="font-family:����; font-size:10pt;">
            �б���˾��ǩ�£���
          </td>
          <td width="50%" align=left id="tdCompensateNo" style="font-family:����; font-size:10pt;">
            ��������ţ�
          </td>
        </tr>-->
      </table>

      <!-- ���岿�� -->
      <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
        <tr height="23">
          <td width="12%" align="left" >&nbsp;&nbsp;���յ���</td>
          <td id="tdPolicyNo" width="39%" colspan="3" >&nbsp;</td>    
          <td width="12%" align="left" >&nbsp;&nbsp;�ⰸ���</td>     
          <td align=left id="tdCaseNo" width="29%" colspan="3" ></td>          
        </tr>
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;��������</td>
          <td id="tdInsuredName" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;��������</td>     
          <td align=left id="tdInsuredDate" colspan="3" ></td>          
        </tr>             
        <tr height="23">
          <td width="15%" align="left" ></td>
          <td  colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;��������</td>     
          <td align=left id="tdDamageStartDate" colspan="3" ></td>          
        </tr>    
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;���յص�</td>
          <td colspan="7" id="tdDamageAddress">&nbsp;</td>            
        </tr> 
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;���乤���ƺ�</td>
          <td id="tdBLNo" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;����ԭ��</td>     
          <td align=left id="tdDamageName" colspan="3" ></td>          
        </tr> 
        <tr height="23">
          <td width="15%" align="left" >&nbsp;&nbsp;�˵�����</td>
          <td id="tdCarryBillNo" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left" >&nbsp;&nbsp;��������</td>     
          <td align=left id="" colspan="3" ><%=strLossName%></td>          
        </tr> 
        <tr height="23">
          <td width="15%" align="left">&nbsp;&nbsp;�����ձ�</td>
          <td  colspan="3" id="tdRiskName" >&nbsp;</td>    
          <td width="15%" align="left">&nbsp;&nbsp;��������</td>     
          <td align=left id="" colspan="3" ><%=intLossQuantity%></td>          
        </tr> 
        <tr height="23">
          <td width="15%" align="left">&nbsp;&nbsp;����·��</td>
          <td id="tdSiteName" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left">&nbsp;&nbsp;���ս��</td>     
          <td align=left id="tdSumAmount" colspan="3" ></td>          
        </tr>
        <tr height="25">
          <td width="15%" align="left" >�������˿�������</td>
          <td id="bank" align="left" colspan="3">&nbsp;<%=prpLcompensateDto.getBank()%></td>    
          <td width="15%" align="left" >&nbsp;&nbsp;֧���ʺ�</td>     
          <td id="account" align=left  colspan="3"><%=prpLcompensateDto.getAccount()%></td>          
        </tr>
         <tr height="25">
          <td width="15%" align="left" >�տ���ȫ��</td>
          <td id="bank" align="left" colspan="3">&nbsp;<%=prpLcompensateDto.getReceiverName()%></td>    
          <td width="15%" align="left" ></td>     
          <td id="account" align=left  colspan="3"></td>          
        </tr>    
        <tr>
          <td id="tdContext" colspan="8" height="200" valign="top">
            ������㣺<br>
            <!--<input type=text rows=18 cols=95 class=readonlyWhite readonly style="overflow:hidden;FONT-SIZE: 10pt">-->
          </td>
        </tr>
        <tr height="23">
          <td width="15%" align="center" >&nbsp;�����Ŀ</td>
          <td width="31%"align="center"  colspan="3" >��&nbsp;&nbsp;��</td>    
          <td width="15%" align="center"  colspan="1" >&nbsp;������Ŀ</td>     
          <td  width="31%" align="center"  colspan="3" >��&nbsp;&nbsp;��</td>          
        </tr>        
        <tr height="23">
          <td width="15%" align="left" >&nbsp;������</td>
          <td id="tdSumLossPay" colspan="3" >&nbsp;</td>    
          <td width="15%" align="left"  colspan="1" >&nbsp;����������׷��</td>     
          <td align=left  colspan="3" ></td>          
        </tr>        
        <tr height="23">
          <td width="15%" align="left" >&nbsp;ʩ�ȷ�</td>
          <td align=left colspan="3" >&nbsp;</td>    
          <td width="15%" align="left"  colspan="1" >&nbsp;�����ջ�</td>     
          <td align=left  colspan="3" ></td>          
        </tr>     
        <tr height="23">
          <td colspan="8" align="left" id="tdCSumLossPay">���ϼƣ���д�� ��Сд��</td>         
        </tr>   
        <tr>
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;���������ˣ�<br><br>
                	&nbsp;&nbsp;&nbsp;<%=strHandlerName%></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=strInputDate%>
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="5" colspan="4">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="50">
                <td width="33%" align="left" valign="top">&nbsp;�����ˣ�<br><br>
                	&nbsp;&nbsp;&nbsp;<%=strUnderWriteName%></td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=strUnderWriteEndDate%>
                </td>
              </tr>
            </table>
          </td>   
          <td align="center" colspan="2" width="25%">&nbsp;���֧��</td>               
        </tr>
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;������</td>  
          <td align="center" id="tdSSumLossPay" width="15%">&nbsp;</td>            
        </tr>   
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;ʩ�ȷ�</td>  
          <td align="center" id="tdRescueFee">&nbsp;</td>            
        </tr> 
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;�鿱��</td>  
          <td align="center" id="tdCheckFee">&nbsp;</td>            
        </tr> 
        <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;���������</td>  
          <td align="center" id="tdJudgeFee">&nbsp;</td>            
        </tr>                 
        <tr>
          <td rowspan="5" colspan="2">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="80">
                <td width="33%" align="left" valign="top">&nbsp;�ֹ�˾��ϯ�����ˣ�</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td>
          <td rowspan="5" colspan="4">          
            <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">
              <tr height="80">
                <td width="33%" align="left" valign="top">&nbsp;�ܹ�˾�����ˣ�</td>
              </tr>
              <tr height="23">
                <td width="33%" align="right">
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
              </tr>
            </table>
          </td> 
          <td align="left" colspan="1">&nbsp;&nbsp;���������</td>  
          <td align="center" id="tdGsjzFee">&nbsp;</td>                               
         </tr>
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;������</td>  
          <td align="center" id="tdAssessFee">&nbsp;</td>           
         </tr>
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;���ɷ�</td>  
          <td align="center" id="tdFlFee">&nbsp;</td>           
         </tr>         
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;����</td>  
          <td align="center" id="tdElseFee">&nbsp;</td>           
         </tr>
         <tr>
          <td align="left" colspan="1">&nbsp;&nbsp;�ܼ�</td>  
          <td align="center" id="tdSSumPaid">&nbsp;</td>           
         </tr>    
         
         <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      	<tr>
      		<td align="left"><%=strPayRefName%></td>
      		<td align="right"><%=strPayRefDate%></td>
      	</tr>
      </table>
    <table border="0"><tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ע�����֧����Ŀ�����ϼ������н��Ϊ֧�������յ�������</td></tr></table>

    <%--//modify by wangli update  start 20050422 --%>
     <jsp:include page="/common/print/PrintButton.jsp" />
      
      <%-- <jsp:include page="/DAA/compensate/DAASpecialPrintButton.jsp" />--%>
    <%--//modify by wangli update end 20050422 --%>
  </body>

</html>
