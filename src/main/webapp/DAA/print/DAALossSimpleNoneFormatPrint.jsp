<%--
****************************************************************************
* DESC       ���������������پ��ⰸ������ʧ���ȷ�����ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>

  <%-- ��ʼ�� --%>
  <%@include file="DAALossSimpleNoneFormatPrintIni.jsp"%>
  
<html>     
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
  
  <body bgcolor="#FFFFFF" onload="loadForm()">
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td colspan="2" height="40" align=top align=center style="font-family:����; font-size:14pt;">            
          <center><B>�������������پ��ⰸ������ʧ���ȷ����<B></center>
        </td>
      </tr>
      <tr>
        <td align=left id="tdClaimNo" width="50%" style="font-family:����; font-size:10pt;">
          ������ţ�
        </td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td align=left id="tdClauseType" width="50%" style="font-family:����; font-size:10pt;">
          ���𵥱�ţ�
        </td>
        <td align=right id="tdComName" width="50%" style="font-family:����; font-size:10pt;">
          �б���˾��
        </td>
      </tr>
    </table>
      
    <!-- ���岿�� -->  
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr> 
        <td height="20" colspan="5" id="tdInsuredName">�������ˣ�</td>
        <td height="20" colspan="5" id="tdDamageStartDate">����ʱ�䣺</td>
      </tr>            
      <tr>             
        <td height="20" colspan="5" id="tdPolicyNo">���յ��ţ�</td>
        <td height="20" colspan="5" id="tdDamageAddress">���յص㣺</td>
      </tr>            
      <tr>             
        <td height="20" colspan="5" id="tdSumAmount">���ս�</td>
        <td height="20" colspan="5" id="tdIndemnityDuty">�¹����Σ�</td>
      </tr>            
      <tr>             
        <td height="20" colspan="4" id="tdBrandName">�����ͺţ�</td>
        <td height="20" colspan="3" id="tdLicenseNo">���ƺ��룺</td>
        <td height="20" colspan="3" id="tdGearboxType">��������ʽ��</td>
      </tr>            
      <tr>             
        <td height="20" colspan="4">������ݣ�</td>
        <td height="20" colspan="3" id="tdEngineNo">�������ţ�</td>
        <td height="20" colspan="3" id="">�������ͺţ�</td>
      </tr>            
      <tr>             
        <td height="20" colspan="4" id="tdCheckDate">����ʱ�䣺</td>
        <td height="20" colspan="6" id="tdCheckSite">����ص㣺</td>
      </tr>            
      <tr>             
        <td height="20" colspan="7" id="tdFrameNo">���ܺ��룺</td>
        <td height="20" colspan="3" id="tdRepairStartDate">����ʱ�䣺</td>
      </tr>            
      <tr>             
        <td height="20" colspan="7" id="tdQuoteCompanyGrade">���۹�˾��</td>
        <td height="20" colspan="3" id="tdRepairEndDate">�޸�����ʱ�䣺</td>
      </tr>
      <tr valign="top"> 
        <td colspan="10" height="50">��ʧ��λ���̶ȸ�����</td>
      </tr>
      <tr height="20" align="center"> 
        <td rowspan=11 width="5%">��<br>��<br>��<br>��<br>��<br>��<br>Ŀ<br>��<br>��</td>
        <td rowspan=2 width="5%">���</td>
        <td colspan=2>�㲿��</td>
        <td rowspan=2 width="12%">���<br><br>���</td>
        <td rowspan=2 width="8%">����</td>
        <td rowspan=2 width="10%">��ʱ��
        <td rowspan=2 width="10%">���Ƽ۸�</td>
        <td rowspan=2 width="10%">����</td>
        <td rowspan=2 width="12%">С��</td>
      </tr>
      <tr height="20"> 
        <td width="14%" align="center">��λ</td>
        <td width="14%" align="center">����</td>
      </tr>
<%    
      int intComponentCountTmp = 0;   //��ӡ�Ļ�����Ŀ��Ϣ��¼��
      
      //������Ŀ��Ϣ
      if( intComponentCount>8 )    //��������ָ����ӡ��Χ
      {
        intComponentCountTmp = 7;
      }
      else
      {
        intComponentCountTmp = intComponentCount;  
      }   
      
      for(index=0;index<intComponentCountTmp;index++)
      {
        prpLcomponentDto = (PrpLcomponentDto)certainLossDto.getPrpLcomponentDtoList().get(index);
         
        //dblQuantity    += prpLcomponentDto.getQuantity();
        dblQuantity    += prpLcomponentDto.getQuantity();
        //dblManHourFee1 += prpLcomponentDto.getManHourFee();
        dblManHourFee1 += prpLcomponentDto.getManHourFee();
        dblQueryPrice  += prpLcomponentDto.getQueryPrice();
        dblQuotedPrice += prpLcomponentDto.getQuotedPrice(); 
        dbSum1 += prpLcomponentDto.getQuantity()*prpLcomponentDto.getQuotedPrice();
%>      
      <tr height="20"> 
        <td align="center">
          <%=index+1%>
        </td>
        <td>
          <%=StringConvert.encode(prpLcomponentDto.getPartDesc())%>
        </td>
        <td>
          <%=StringConvert.encode(prpLcomponentDto.getCompName())%>
        </td>
        <td>
          <%=StringConvert.encode(prpLcomponentDto.getCompCode())%>
        </td>
<%    
      //if( prpLcomponentDto.getQuantity()==0 )
      if( prpLcomponentDto.getQuantity()==0 )
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else
      {        
%>        
        <td>
          <%=prpLcomponentDto.getQuantity()%>
        </td>
<%    
      }
      //if( prpLcomponentDto.getManHourFee()==0 )
      if( prpLcomponentDto.getManHourFee()==0 )
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else
      {        
%>      
        <td>
          <%=new DecimalFormat("#,##0.00").format(prpLcomponentDto.getManHourFee())%>
        </td>
<%    
      }
      if( prpLcomponentDto.getQueryPrice()==0 )
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else 
      {        
%>      
        <td>
          <%=new DecimalFormat("#,##0.00").format(prpLcomponentDto.getQueryPrice())%>
        </td>
<%    
      }
      if( prpLcomponentDto.getQuotedPrice()==0 )
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else
      {        
%>      
        <td>
          <%=new DecimalFormat("#,##0.00").format(prpLcomponentDto.getQuotedPrice())%>
        </td>
<%    
      }
      //modify by caopeng start at 2005-12-20
      if((prpLcomponentDto.getQuantity()*prpLcomponentDto.getQuotedPrice())==0 )
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else
      {        
%>      
        <td>
          <%=new DecimalFormat("#,##0.00").format((prpLcomponentDto.getQuantity()*prpLcomponentDto.getQuotedPrice()))%>
        </td>
<%    
      }
      //modify by caopeng end at 2005-12-20
%>
      </tr>
<%    
      
      
      if( intComponentCount>8 )    //��������ָ����ӡ��Χ
      
%>    
      <tr height="20"> 
        <td align="center">8</td>
        <td colspan="10">��������嵥</td>
      </tr>     
<%    
     }
     
     for(index=0;index<8-intComponentCountTmp;index++)
     {    
%>    
      <tr height="20"> 
        <td align="center"><%=intComponentCount+index+1%></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>     
<%    
      }  
%>    
      <tr height="20"> 
        <td colspan="4" align="center">С  ��</td>
        <td><%=DataUtils.zeroToEmpty(dblQuantity)%></td>
        <td><%=DataUtils.zeroToEmpty(dblManHourFee1)%></td>
        <td><%=DataUtils.zeroToEmpty(dblQueryPrice)%></td>
        <td><%=DataUtils.zeroToEmpty(dblQuotedPrice)%></td>
        <td><%=DataUtils.zeroToEmpty(dbSum1)%></td>
      </tr>                 
      <tr height="20" align="center"> 
        <td rowspan=10>��<br>��<br>��<br>Ŀ<br>��<br>��</td>
        <td>���</td>
        <td colspan=4>������Ŀ����</td>
        <td>��ʱ</td>
        <td>��ʱ��</td>
        <td>���Ϸ�</td>
        <td>С��</td>
      </tr>
<%    
      int intRepairFeeCountTmp = 0;   //��ӡ��������Ŀ��Ϣ��¼��
      
      //������Ŀ��Ϣ
      if( intRepairFeeCount>8 )    //��������ָ����ӡ��Χ
      {
        intRepairFeeCountTmp = 5;
      }
      else
      {
        intRepairFeeCountTmp = intRepairFeeCount;  
      }   
      
      for(index=0;index<intRepairFeeCountTmp;index++)
      {
        prpLrepairFeeDto =(PrpLrepairFeeDto)certainLossDto.getPrpLrepairFeeDtoList().get(index);
        
        //dblManHour     += prpLrepairFeeDto.getManHour();
        dblManHour     += prpLrepairFeeDto.getManHour();
       // dblManHourFee2 += prpLrepairFeeDto.getManHourFee();
        dblManHourFee2 +=prpLrepairFeeDto.getManHourFee();
        //dblMaterialFee += prpLrepairFeeDto.getMaterialFee();
        dblMaterialFee += prpLrepairFeeDto.getMaterialFee(); 
        dbSum2 = prpLrepairFeeDto.getManHour() * prpLrepairFeeDto.getManHourFee() + prpLrepairFeeDto.getMaterialFee();
        //modify by caopeng start at 2005-12-20
        dbSumSum2 += dbSum2;        
        //modify by caopeng end at 2005-12-20
%>      
      <tr height="20"> 
        <td align="center">
          <%=index+1%>
        </td>
        <td colspan=4>
          <%=StringConvert.encode(prpLrepairFeeDto.getCompName())%>
        </td>
<%    
      //if( prpLrepairFeeDto.getManHour()==0 )
      if( prpLrepairFeeDto.getManHour()==0 )
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else
      {        
%>        
        <td>
          <%=new DecimalFormat("#,##0.00").format(prpLrepairFeeDto.getManHour())%>
        </td>
<%    
      }
      //if( prpLrepairFeeDto.getManHourFee()==0 )
      if( prpLrepairFeeDto.getManHourFee()==0 )
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else
      {        
%>      
        <td>
          <%=new DecimalFormat("#,##0.00").format(prpLrepairFeeDto.getManHourFee())%>
        </td>
<%    
      }
      //if( prpLrepairFeeDto.getMaterialFee()==0 )
      if(prpLrepairFeeDto.getMaterialFee()==0 ) 
      {
%>        
        <td>&nbsp;</td>   
<%    
      }
      else
      {        
%>      
        <td>
          <%=new DecimalFormat("#,##0.00").format(prpLrepairFeeDto.getMaterialFee())%>
        </td>
<%    
      }
%>    
        <td>
          <%=new DecimalFormat("#,##0.00").format(dbSum2) %>
        </td>
      </tr>
<%    
      }
      
      if( intRepairFeeCount>8 )    //��������ָ����ӡ��Χ
      {
%>     
       <tr height="20"> 
         <td align="center">8</td>
         <td colspan="10">��������嵥</td>
       </tr>     
<%     
      }
      
      for(index=0;index<8-intRepairFeeCountTmp;index++)
      {    
%>    
      <tr height="20"> 
        <td align="center"><%=intRepairFeeCount+index+1%></td>
        <td colspan=4>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>     
<%    
      }  
%>    
      <tr height="20"> 
        <td colspan="5" align="center">С  ��</td>
        <td><%=DataUtils.zeroToEmpty(dblManHour)%></td>
        <td><%=DataUtils.zeroToEmpty(dblManHourFee2)%></td>
        <td><%=DataUtils.zeroToEmpty(dblMaterialFee)%></td>
        <td><%//add by caopeng start at 2005-12-20%><%=DataUtils.zeroToEmpty(dbSumSum2)%><%//add by caopeng end at 2005-12-20%></td>
      </tr>                 
      <tr align="center" valign="middle"> 
        <td  colspan="10">
          <table width="100%" border="0" height="100%" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
            <tr>
              <td align="left" width="75%" height="33%" id="tdComContext">&nbsp;</td>
              <td align="left" width="20%" height="33%" id="tdComSumDefLoss">&nbsp;</td>
              <td align="right" width="5%" height="33%">Ԫ��</td>
            </tr>
            <tr>
              <td align="left" width="75%" height="33%" id="tdRepContext"></td>
              <td align="left" width="20%" height="33%" id="tdRepSumDefLoss">&nbsp;</td>
              <td align="right" width="5%" height="33%">Ԫ��</td>
            </tr>
            <tr>
              <td align="left" width="75%" height="33%" id="tdProContext">&nbsp;</td>
              <td align="left" width="20%" height="33%" id="tdProSumReject">&nbsp;</td>
              <td align="right" width="5%" height="33%">Ԫ��</td>
            </tr>
          </table>
        </td>
      </tr>
      <tr valign="middle"> 
        <td colspan="10" height="60">&nbsp;&nbsp;&nbsp;&nbsp;  ���պ�ͬ�����˸�����Э�̣�ͬ�ⰴ��ȷ��������������������ĿΪȷ�������¹���ʧ��Χ�����ݣ����������Э�飺<br>													
          &nbsp;&nbsp;&nbsp;&nbsp;  ��ȷ��������������ܼƽ����Ѱ�������˰�ѣ���Ϊ���չ�˾�϶�����ʧ����⸶�������˽��֣����չ�˾�����⸶��<br>									
        </td>
      </tr>
      <tr> 
        <td colspan="4" height="70" align="center" valign="middle">
          <table width="100%" border="0" height="100%" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
            <tr>
              <td valign="top">
                ���չ�˾<br><br>
                ǩ�£�<br>
              </td>
            </tr>
            <tr>
              <td align="right" valign="bottom">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;
              </td>
            </tr>
          </table>
        </td>
        <td colspan="3" colspan="2" height="70" valign="middle" align="center">
          <table width="100%" border="0" height="100%" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
            <tr> 
              <td valign="top">
                ��������<br><br>
                ǩ�£�<br>
              </td>
            </tr>
            <tr> 
              <td align="right" valign="bottom">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;
              </td>
            </tr>
          </table>
        </td>
        <td colspan="3" height="70" align="center" valign="middle">
          <table width="100%" border="0" height="100%" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
            <tr> 
              <td>&nbsp;</td>
            </tr>
            <tr> 
              <td align="right" valign="bottom">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />
          
  </body>
</html>
