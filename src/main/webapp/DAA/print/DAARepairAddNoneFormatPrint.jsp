<%--
****************************************************************************
* DESC       ��������������������Ŀ��ҳ
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
System.out.println("===================������====");
  //������������
  String printType         = request.getParameter("printType"); 
  String licenseNo         = request.getParameter("strLicenseNo");
  String  strInsuredName ="";
  String  strRegistNo="";
  
  String  engineNo ="";
  String    frameNo ="";
  String    brandName ="";

  //������������
  String strClaimNo = request.getParameter("ClaimNo"); //������
  String strInsureCarFlag = "";   //�Ƿ��Ǳ���������
  double dblManHour       = 0;    //��ʱ
  double dblManHourFee    = 0;    //��ʱ��
  double manHourFee    = 0;    //��ʱ��
  double dblMaterialFee   = 0;    //���Ϸ� 
  String strSanctioner    = "";   //��׼��
  String strApproverName  = "";   //������
  String strOperatorName  = "";   //������
  String strMessage       = "";

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  //�����岿��  
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����
  PrpLthirdPartyDto  prpLthirdPartyDto  = null;   //ThirdPartyDto����
  PrpLrepairFeeDto   prpLrepairFeeDto   = null;   //RepairFeeDto����
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intRepairFeeCount  = 0;   //RepairFeeDto����ļ�¼��
  int intThirdPartyCount = 0;   //ThirdPartyDto����ļ�¼��
  
  int index = 0;
  
System.out.println("===================������=2===");
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
 /*  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");  */
  
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto");
  RegistDto registDto = (RegistDto)request.getAttribute("registDto");
  CheckDto checkDto = (CheckDto)request.getAttribute("checkDto"); 
  CertainLossDto certainLossDto = (CertainLossDto)request.getAttribute("certainLossDto");
 System.out.println("===================������=21===");   
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�������
  String strPolicyNo =policyDto.getPrpCmainDto().getPolicyNo();
 /* prpLclaimDto = claimDto.getPrpLclaimDto();*/
  strInsuredName =policyDto.getPrpCmainDto().getInsuredName();
  strRegistNo = certainLossDto.getPrpLthirdPartyDto().getRegistNo();
   System.out.println("===================������=22===");
  //�õ�blPrpLthirdParty����ļ�¼�� 
  if(certainLossDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = certainLossDto.getPrpLthirdPartyDtoList().size();
     System.out.println("===================������=23===");
  }
   System.out.println("===================������=233===" +certainLossDto.getPrpLrepairFeeDtoList().size());
  //�õ�blPrpLrepairFee����ļ�¼��
  if(certainLossDto.getPrpLrepairFeeDtoList()!=null){
    intRepairFeeCount     = certainLossDto.getPrpLrepairFeeDtoList().size();
    System.out.println("===================������=24===");
  }   
 System.out.println("===================������=25===" +certainLossDto.getPrpLthirdPartyDtoList().size());
  if( intRepairFeeCount<24 )
  {
    strMessage = "��Ǹ!������Ŀδ����24��,�����ӡ�嵥��ҳ,������ӡ�嵥��";
System.out.println(strMessage );      
%>
    <jsp:include page="/common/pub/UIErrorPage.jsp">
      <jsp:param name="Picture" value="F" />
      <jsp:param name="Content" value="<%=strMessage%>" />
    </jsp:include>
<%  
    return;
  }
System.out.println("lijiyuan12");    
%>  

<script language="javascript">
  function loadForm()
  {
<%    
    //*****������Ϣ��PrpLclaim*****
    //�б���˾
    strCode = "";
    strName = "";
    strCode = StringConvert.encode(policyDto.getPrpCmainDto().getComCode());
    strName = uiCodeAction.translateComCode(strCode,isChinese); 
    
%>
<%  
  if(certainLossDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      prpLthirdPartyDto = (PrpLthirdPartyDto)certainLossDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag     = prpLthirdPartyDto.getInsureCarFlag();
        System.out.println("===================������=4==3="+prpLthirdPartyDto.getLicenseNo()); 
       if (prpLthirdPartyDto.getLicenseNo().equals(licenseNo)){
          engineNo =prpLthirdPartyDto.getEngineNo();
          frameNo =prpLthirdPartyDto.getFrameNo();
          brandName =prpLthirdPartyDto.getBrandName();
        }

      
      if( strInsureCarFlag.equals("1") ) 
      {  
        //�������
        strCode = "";
        strName = "";
        strCode = StringConvert.encode(prpLthirdPartyDto.getClauseType());
        strName = uiCodeAction.translateCodeCode("ClauseType",strCode,isChinese);
%>        
      
<%   System.out.println("===================������=4===");
      }
    }
  }  
%>    
  } 
</script>       
  
<html>
  <head>
    <title>�����������ճ�����ʧ���ȷ����������Ŀ�嵥��ӡ</title>
    <link rel="stylesheet" type="text/css" href="/claim/css/Standard.css">
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">
  </head>

  <body bgcolor="#FFFFFF" onload="loadForm();">
    <!-- ���ⲿ�� -->
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
    <tr>
      <td colspan="2" height="40" align="center" style="text-align:center; font-family:����; font-size:14pt;"> <span><img src="/claim/images/LOGO.jpg"/></span> </td>
    </tr>
    <tr>
      <td colspan="2" height="40" align=center style="text-align:center; font-family:����; font-size:14pt;"> <strong><B>�����������ն��𱨸���ϸ������-��ҳ��<B> </b></b></strong></td>
    </tr>
  </table>

   <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">
     <tr height=30>
        <td width="30%" align=left id="insuredName" style="font-family:����; font-size:10pt;">
          �������ˣ�<%=strInsuredName%>
        </td>
        <td width="40%" align=left id="registNo" style="font-family:����; font-size:10pt;">
          �����ţ�<%=strRegistNo%>
        </td>
        <td width="30%" align=right id="pageCount" style="font-family:����; font-size:10pt;">
          ��&nbsp;&nbsp;&nbsp;&nbsp;ҳ&nbsp;��&nbsp&nbsp;&nbsp;&nbspҳ
        </td>
      </tr>   
    </table>

   <table  border=1 width="92%" align="center" cellspacing="0" cellpadding="0" border="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">  
      
      <tr height="25" border=1> 
        <td width="15%" align=center id="tdLicenseNo" style="font-family:����; font-size:10pt;">
          ���ƺ���:
        </td>
        <td width="35%" align=center ><%=licenseNo%></td>
        <td width="15%" align=center id="tdPolicyNo" style="font-family:����; font-size:10pt;">
          ���յ���: 
        </td>
        <td width="35%" align=center ><%=strPolicyNo%></td>
      </tr>
      <tr height="25"> 
        <td width="15%" align=center id="" style="font-family:����; font-size:10pt;">
          ��������: 
        </td>
         <td width="35%" align=center ><%=engineNo%></td>
        <td width="15%" align=center id="" style="font-family:����; font-size:10pt;">
          ���ܺ�:
        </td>
         <td width="35%" align=center ><%=frameNo%> </td>
      </tr>
    </table>
      
    <!-- ���岿�� -->  
    <table border=1 width="92%" align="center" cellspacing="0" cellpadding="2" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr height="25" align="center"> 
        <td width="5%">���</td>
        <td width="20%">������Ŀ����</td>
        <td width="13%">��ʱ</td>
        <td width="16%">��ʱ��</td>
        <td width="18%">���Ϸ�</td>
        <!--<td width="18%">������</td>-->
        <td width="20%">��  ע</td>

      </tr>
<%    
 
  if(certainLossDto.getPrpLrepairFeeDtoList()!=null){
      for(index=24;index<intRepairFeeCount;index++)
      {
        prpLrepairFeeDto = (PrpLrepairFeeDto)certainLossDto.getPrpLrepairFeeDtoList().get(index);
         System.out.println("1111111111111=="+prpLrepairFeeDto.getManHour());
          System.out.println("3333333333==="+prpLrepairFeeDto.getManHourUnitPrice());
         
         manHourFee = prpLrepairFeeDto.getManHour()*prpLrepairFeeDto.getManHourUnitPrice();
        dblManHour     += prpLrepairFeeDto.getManHour();
        //dblManHour     += Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeDto.getManHour()));
        dblManHourFee  += prpLrepairFeeDto.getManHour()*prpLrepairFeeDto.getManHourUnitPrice();
        //dblManHourFee  += Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeDto.getManHourFee()));
        dblMaterialFee += prpLrepairFeeDto.getMaterialFee();
        //dblMaterialFee += Double.parseDouble(DataUtils.nullToZero(prpLrepairFeeDto.getMaterialFee()));
        //��׼��
        strCode = "";
        strCode = StringConvert.encode(prpLrepairFeeDto.getSanctioner());
        strSanctioner = uiCodeAction.translateUserCode(strCode,isChinese);
        //������
        strCode = "";
        strCode = StringConvert.encode(prpLrepairFeeDto.getApproverCode());
        strApproverName = uiCodeAction.translateUserCode(strCode,isChinese); 
        //����Ա
        strCode = "";
        strCode = StringConvert.encode(prpLrepairFeeDto.getOperatorCode());
        strOperatorName = uiCodeAction.translateUserCode(strCode,isChinese);
%>      
      <tr height="25"> 
        <td align="center">
          <%=index+1%>
        </td>
        <td>
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
        <td align="center">
          <%=new DecimalFormat("#,##0.00").format(prpLrepairFeeDto.getManHour())%>
        </td>
<%
      }
      
 System.out.println("manHourFee==="+manHourFee);
 
     if(manHourFee==0 )
      { System.out.println("manHourFee==="+manHourFee);
%>        
        <td>&nbsp;</td>   
<%
      }
      else
      {        
%>      
        <td align="center">
          <%=new DecimalFormat("#,##0.00").format(manHourFee)%>
        </td>
<%
      }
     
  
      if(prpLrepairFeeDto.getMaterialFee()==0 )
      {
%>        
        <td>&nbsp;</td>   
<%
      }
      else
      {        
%>      <td align="center">
       
       <%=new DecimalFormat("#,##0.00").format(prpLrepairFeeDto.getMaterialFee())%>
        </td>
        
<%
      }
  %>

  




        <td>&nbsp;</td>
      </tr>
<%    
     }
   }  
%>     
      <tr height="25"> 
        <td colspan="2" align="center">С  ��</td>
        <td align="center"><%=new DecimalFormat("#,##0.00").format(dblManHour)%></td>
        <td>
        <table width="100%" style="font-family:����; font-size:10pt;">
        <tr><td width="60%" align="right"><%=new DecimalFormat("#,##0.00").format(dblManHourFee)%></td><td width="40%">&nbsp;</td></tr></table>
        </td>
        <%if(dblMaterialFee==0){%><td>&nbsp;</td><%}else{%>
        <td>
        <table width="100%" style="font-family:����; font-size:10pt;">
        <tr><td width="60%" align="right"><%=new DecimalFormat("#,##0.00").format(dblMaterialFee)%></td><td width="40%">&nbsp;</td></tr></table>
        </td><%}%>
        <td>&nbsp;</td>
      </tr> 
      </table>                 
    <!-- ��β���� -->
    <table  width="92%" align="center" cellspacing="0" cellpadding="2" border="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;" >
      <tr  height=25> 
        <td width="50%" id="tdSanctioner">�鿱�����ˣ�<%=strSanctioner%></td>
        <td width="50%" id="tdApproverName">�˼��ˣ�<%=strApproverName%></td> 
       <!-- <td width="37%" id="tdOperatorName">�����Ʊ��ˣ�<%=strOperatorName%></td>-->
      </tr>
   </table>
  
    
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
