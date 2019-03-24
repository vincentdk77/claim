<%--
****************************************************************************
* DESC       �������������ղƲ���ʧȷ�����ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%-- ����bean�ಿ�� --%>
<%@page import="java.text.*"%>
<%@page import="com.sinosoft.claim.ui.control.action.*"%>
<%@page import="com.sinosoft.claim.dto.custom.*"%>
<%@page import="com.sinosoft.claim.dto.domain.*"%> 
<%@page import="com.sinosoft.claim.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.util.*"%> 
<%@page import="com.sinosoft.sysframework.common.datatype.DateTime"%> 
<%@page import="com.sinosoft.sysframework.exceptionlog.*"%> 

<%
  //������������
  String strClaimNo      = request.getParameter("ClaimNo"); //������
  String strPolicyNo      = "";
  String strInsureCarFlag = "";   //�Ƿ��Ǳ���������
  String strKindCode      = "";   //�ձ�
  double dblAmount        = 0;    //�����޶�
  double dblSumLoss       = 0;    //�۸�
  double dblSumDefLoss    = 0;    //��ʧ���
  String strApproverName  = "";   //������
  String strHandlerName   = "";  //������
  String strMessage       = "";

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
   
  //�����岿��  
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLpropDto        prpLpropDto        = null;   //propDto����
  PrpCitemKindDto    prpItemKindDto     = null;   //������ItemKindDto����
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intPropCount       = 0;   //PropDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  int intItemKindCount   = 0;   //ItemKindDto����ļ�¼��
  
  int index = 0;

  
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�������
  strPolicyNo = registDto.getPrpLregistDto().getPolicyNo();

  //�õ�blPrpCitemCar����
  if(policyDto.getPrpCitemKindDtoList()!=null){
    intItemKindCount     = policyDto.getPrpCitemKindDtoList().size();
  }  
  
  //�õ�prpLclaimDto����
  PrpLregistDto prplRegistDto   = registDto.getPrpLregistDto();
  PrpLclaimDto prplClaimDto = claimDto.getPrpLclaimDto();
  
  
  //�õ�blPrpLthirdParty����ļ�¼�� 
  if(registDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = registDto.getPrpLthirdPartyDtoList().size();
  }
  
  //�õ�blPrpLprop����ļ�¼��  
  if(certainLossDto.getPrpLpropDtoList()!=null){
    intPropCount     = certainLossDto.getPrpLpropDtoList().size();
  }
%> 

<script language="javascript">
  function loadForm()
  {
    //*****���⳵����ϢPrpLthirdParty*****
    tdPolicyNo.innerHTML  = '���յ��ţ�' + '<%=strPolicyNo%>';
   // tdCertainLoss.innerHTML = '';
    tdRegistNo.innerHTML  = '������ţ�' + '<%=StringConvert.encode(prplRegistDto.getRegistNo())%>';
    tdDamageKind.innerHTML= '����ԭ��' + '<%=StringConvert.encode(prplClaimDto.getDamageName())%>';
<%  
  if(registDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
      if( strInsureCarFlag.equals("1") ) 
      { 
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
        tdBrandName.innerHTML = '�����ͺţ�' + '<%=StringConvert.encode(prpLthirdPartyDto.getBrandName())%>';
        tdLicenseNo.innerHTML = '���ƺ��룺' + '<%=StringConvert.encode(prpLthirdPartyDto.getLicenseNo())%>';
<%        
        //�б���˾
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getInsureComCode());
        
        strName = uiCodeAction.translateComCode(strCode,isChinese);
        
%>        
        tdComName.innerHTML   = '�б���˾��<br>���չ�Ԫũҵ���չ�˾' ;
        tdAmount.innerHTML = '�����޶';
<%  
      }
    }
  }  

    //���������ϢPrpTitemKind
    dblAmount = 0; 
    
  if(policyDto.getPrpCitemKindDtoList()!=null){
    for(index=0;index<intItemKindCount;index++)
    {
      prpItemKindDto = (PrpCitemKindDto)policyDto.getPrpCitemKindDtoList().get(index); 
      strKindCode = prpItemKindDto.getKindCode();
      
      if( strKindCode.equals("B") || strKindCode.equals("D2") ) 
      {
        dblAmount += prpItemKindDto.getAmount();
      }
    }
  }  
%>
    tdAmount.innerHTML = '�����޶'+'<%=new DecimalFormat("#,##0.00").format(dblAmount)%>';
  }
</script>       
  
<html>
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
      <tr height="40">
        <td colspan="2" height="40" align=top align=center style="font-family:����; font-size:14pt;">            
          <center><B>�����������ղƲ���ʧȷ����</B></center>
        </td>
      </tr>
      <tr height="25">
        <td width="60%" align=left id="tdRegistNo" style="font-family:����; font-size:10pt;">
          ������ţ�
        </td>
        <td width="40%" align=left id="tdCertainLoss" style="font-family:����; font-size:10pt;">

        </td>
      </tr>
    </table>
      
    <!-- ���岿�� -->  
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr height="25"> 
        <td colspan=2 width="40%" id="tdPolicyNo">���յ��ţ� </td>
        <td colspan=3 width="30%" id="tdBrandName">�����ͺţ� </td>
        <td colspan=3 width="30%" id="tdComName">�б���˾�� </td>
      </tr>
      <tr height="25"> 
        <td colspan=2 width="40%" id="tdLicenseNo">���ƺ��룺</td>
        <td colspan=3 width="30%" id="tdAmount">�����޶</td>
        <td colspan=3 width="30%" id="tdDamageKind">�����ձ�</td>
      </tr>
      <tr height="25" align="center"> 
        <td width="5%">���</td>
        <td width="30%">��ʧ��Ŀ����</td>
        <td colspan=2 width="20%">�����</td>
        <td colspan=2 width="20%">��  ��</td>
        <td colspan=2 width="20%">���չ�˾<br>�˶���ʧ���</td>
      </tr>
<%    
      int intPropCountTmp = 0;   //��ӡ�ĲƲ���ʧ��Ϣ��¼��
      
      //�Ʋ���ʧ��Ϣ
      if( intPropCount>28 )    //��������ָ����ӡ��Χ
      {
        intPropCountTmp = 28;
      }
      else
      {
        intPropCountTmp = intPropCount;  
      }   
      
  if(certainLossDto.getPrpLpropDtoList()!=null){
      for(index=0;index<intPropCountTmp;index++)
      {
        prpLpropDto = (PrpLpropDto)certainLossDto.getPrpLpropDtoList().get(index);
         
        dblSumLoss     += prpLpropDto.getSumLoss();
        dblSumDefLoss  += prpLpropDto.getSumDefLoss();

%>      
      <tr height="25"> 
        <td align="center">
          <%=index+1%>
        </td>
        <td>
          <%=StringConvert.encode(prpLpropDto.getFeeTypeName())%>
        </td>
        <td colspan=2>
          <%=StringConvert.encode(prpLpropDto.getRemark())%>
        </td>
<%
      if(prpLpropDto.getSumLoss()==0 )
      {
%>        
        <td colspan=2>&nbsp;</td>   
<%
      }
      else
      {        
%>        
        <td colspan=2>
          <%=new DecimalFormat("#,##0.00").format(prpLpropDto.getSumLoss())%>
        </td>
<%
      }
      if( prpLpropDto.getSumDefLoss()==0 )
      {
%>        
        <td colspan=2>&nbsp;</td>   
<%
      }
      else
      {        
%>      
        <td colspan=2>
          <%=new DecimalFormat("#,##0.00").format(prpLpropDto.getSumDefLoss())%>
        </td>
<%
      }
%>
      </tr>
<%    
     }
   }  
     
     for(index=0;index<28-intPropCountTmp;index++)
     {    
%>    
      <tr height="25"> 
        <td align="center"><%=intPropCount+index+1%></td>
        <td>&nbsp;</td>
        <td colspan=2>&nbsp;</td>
        <td colspan=2>&nbsp;</td>
        <td colspan=2>&nbsp;</td>
      </tr>     
<%    
      }  
%>
      <tr height="25"> 
        <td colspan="4" align="center">��&nbsp;&nbsp;&nbsp;&nbsp;��</td>
        <td colspan=2><%=DataUtils.zeroToEmpty(dblSumLoss)%></td>
        <td colspan=2><%=DataUtils.zeroToEmpty(dblSumDefLoss)%></td>
      </tr>
      <tr>
        <td colspan=2>
        
          <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">                 
            <tr height="50"> 
              <td width="33%" align="left" valign="top">&nbsp;���չ�˾��ǩ�£���</td>
            </tr>
            <tr height="25"> 
              <td width="33%" align="right">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;
              </td>
            </tr>
          </table>
          
        </td>
        <td colspan=3>
        
          <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">                 
            <tr height="50"> 
              <td width="33%" align="left" valign="top">&nbsp;�������ˣ�ǩ�£���</td>
            </tr>
            <tr height="25"> 
              <td width="33%" align="right">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;
              </td>
            </tr>
          </table>
          
        </td>
        <td colspan=3>
        
          <table width="100%" height="100%" align="center" cellspacing="0" cellpadding="0" border="0" style="font-family:����; font-size:10pt;">                 
            <tr height="50"> 
              <td width="33%">&nbsp;</td>
            </tr>
            <tr height="25"> 
              <td width="33%" align="right">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;
              </td>
            </tr>
          </table>
          
        </td>
      </tr>  
    </table>
    
    <!-- ��β���� -->
    <table width="92%" align="center" cellspacing="0" cellpadding="2" border="0" style="font-family:����; font-size:10pt;">
      <tr align="left" height="25"> 
        <td width="50%" id="tdSanctioner">�����ˣ�</td>
        <td width="570%" id="tdHandlerName">�����ˣ�</td>
      </tr>
    <table>
    
    <script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>
    
    <!-- ��ť���� -->
    <table id="tbButton" cellpadding="0" cellspacing="0" width="80%" style="display:">
      <tr>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonPrint value=" �� ӡ " class="button" onclick="return printPage()">
        </td>
        <td class=button style="width:50%" align="center">
          <input type=button name=buttonClose value=" �� �� " class="button" onclick="javascript:window.close()">
        </td>
      </tr>
    </table>
    
  </body>
</html>
 