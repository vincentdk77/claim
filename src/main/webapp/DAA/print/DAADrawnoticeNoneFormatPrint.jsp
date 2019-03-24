<%--
****************************************************************************
* DESC       ����������������ȡ���֪ͨ���ӡҳ��
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
//  String strCaseNo         = request.getParameter("CaseNo"); //�鵵��
  String strCompensateNo    = request.getParameter("CompensateNo"); //�鵵��
  String strCaseNo          = "";   //�鵵��
  String strClaimNo         = "";   //������
  String strPolicyNo        = "";   //������
  String strInsuredName     = "";   //��������
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ���������� 
  String strLicenseNo       = "";   //���պ���
  String strDamageStartDate = "";   //����ʱ��
  String strDamageAddress   = "";   //���յص�
  String strDamageName      = "";   //����ԭ��
  String strInputDate       = "";   //����
  String strPhoneNumber     = "";   //��ϵ�绰
  String strHandlerName     = "";   //��ϵ��
  String strAddressCName    = "";   //����ַ
  String strContext         = "";
  String strMessage         = "";

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־

  
  int intCompensateCount = 0;
  int intThirdPartyCount = 0;
  int index = 0;
  //�õ�ClaimDto,RegistDto,CertainLossDto,PolicyDto����
  CompensateDto compensateDto = (CompensateDto)request.getAttribute("compensateDto");  
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");  
  PolicyDto policyDto = (PolicyDto)request.getAttribute("policyDto"); 
  PrpLcompensateDto  prpLcompensateDto = compensateDto.getPrpLcompensateDto();
  strCaseNo = prpLcompensateDto.getCaseNo(); 
  strClaimNo = prpLcompensateDto.getClaimNo();
  strPolicyNo = prpLcompensateDto.getPolicyNo();
  
  UICodeAction uiCodeAction = new UICodeAction();
  //�õ�PrpLclaimDto���� 
  PrpLclaimDto prpLclaimDto = claimDto.getPrpLclaimDto();
  
  strInsuredName = prpLclaimDto.getInsuredName();
  DateTime damageStartDateTemp = prpLclaimDto.getDamageStartDate();
  strDamageStartDate = damageStartDateTemp.getYear()
                      + " �� " + damageStartDateTemp.getMonth()
                      + " �� " + damageStartDateTemp.getDate()
                      + " �� ";  
  strDamageAddress   = prpLclaimDto.getDamageAddress();
  strDamageName      = prpLclaimDto.getDamageName();
   
  strCode = "";
  strName = "";
  strCode = prpLclaimDto.getMakeCom();
  //dbPrpDcompany.getInfo(strCode);
  UICompanyAction uiCompanyAction = new UICompanyAction();
  PrpDcompanyDto prpDcompanyDto = uiCompanyAction.findByPrimaryKey(strCode);      
  strPhoneNumber = prpDcompanyDto.getPhoneNumber();
  strAddressCName = prpDcompanyDto.getAddressCName(); 
  
  //�õ�PrpLthirdParty����ļ�¼��
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = claimDto.getPrpLthirdPartyDtoList().size();
  }
  if(claimDto.getPrpLthirdPartyDtoList()!=null){
    for(index=0;index<intThirdPartyCount;index++)
    {
      strInsureCarFlag = ((PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index)).getInsureCarFlag();
      
      if( strInsureCarFlag.equals("1") ) 
      {
        strLicenseNo = ((PrpLthirdPartyDto)claimDto.getPrpLthirdPartyDtoList().get(index)).getLicenseNo();
      }
    }
  }
  
  strContext = "<br>&nbsp;&nbsp;&nbsp;&nbsp;��Ͷ���ĳ��������պ��룺" + strLicenseNo + "&nbsp;&nbsp;������<ins> " + strDamageStartDate + "</ins>��<ins> "
               + strDamageAddress + "&nbsp;&nbsp;" + "</ins>�ضΣ�<br><br>�� <ins>&nbsp;" 
               + strDamageName + "&nbsp;</ins>���գ����ݱ���������йع涨�������ⰸ�ҹ�˾�Ѵ���᰸����" + ""
               + "ǰ��������ȡ���������";
  
  //*****Ͷ����������Ϣ��PrpCmain*****
  PrpCmainDto prpCmainDto = policyDto.getPrpCmainDto();
   
  strCode = "";
  strCode = prpCmainDto.getHandlerCode();
  strHandlerName = uiCodeAction.translateUserCode(strCode,isChinese);
   
  //����
  strInputDate = DateTime.current().getYear() + " �� "
               + DateTime.current().getMonth() + " �� "
               + DateTime.current().getDate() + " ��";  
%>

<html>                                                                                       
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">                                                                                     

  <body bgcolor="#FFFFFF">                                        
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td colspan="2" height="40" align=top align=center style="font-family:����; font-size:14pt;">            
          <center><B>��������������ȡ���֪ͨ��<B></center>
        </td>
      </tr>
      <tr>
        <td align=left width="50%" style="font-family:����; font-size:10pt;">
          <br>�������ˣ�<%=strInsuredName%>
        </td>
<!--        <td align=right width="50%" style="font-family:����; font-size:10pt;">
          <br>��������ţ�<%=strCompensateNo%>
        </td>        
-->        
        <td align=right id="tdCaseNo" width="30%" style="font-family:����; font-size:10pt;">
          <br>�鵵�ţ�<%=strCaseNo%>
        </td>
        
      </tr>
    </table>
      
    <!-- ���岿�� -->
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td colspan="3" align="center"><hr noshade></td>
      </tr>
      <tr>
        <td colspan="3" align="left" valign="top" height="80"><%=strContext%></td>
      </tr>
      <tr>
        <td colspan="3" align="left" height="28">&nbsp;&nbsp;&nbsp;&nbsp;лл���ĺ�������ӭ�������ҹ�˾Ͷ����</td>
      </tr>
      <tr>
        <td colspan="2" align="left" width="50%" height="28">&nbsp;</td>
        <td align="left" width="50%" height="28">���չ�˾��ǩ�£���</td>
      </tr>
      <tr>
        <td colspan="2" align="left" height="30">&nbsp;</td>
        <td align="left" height="28">���ڣ�<%=strInputDate%><br></td>
      </tr>
      <tr>
        <td width="15%" height="28">&nbsp;</td>
        <td align="left" height="28" >��ϵ�绰��<%=strPhoneNumber%></td>
        <td width="50%" height="28">&nbsp;</td>
      </tr>
      <tr>
        <td width="15%" height="28">&nbsp;</td>
        <td align="left" height="28">�� ϵ �ˣ�<%=strHandlerName%></td>
        <td width="50%" height="28">&nbsp;</td>
      </tr>
      <tr>
        <td width="15%" height="28">&nbsp;</td>
        <td align="left" height="28">����ַ��<%=strAddressCName%></td>
        <td width="50%" height="28">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="3" align="center" height="28"><hr noshade></td>
      </tr>
    </table>
     
    <!-- ��β���� -->      
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td height="20"><br>
        ע�������ȡ���ʱ����Я��һ�µ�֤�����ϣ�<br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;1����������Ϊ���˻�������֯�ģ�Ӧ�ṩ��λ����ר���»��¡�<br><br> 
        &nbsp;&nbsp;&nbsp;&nbsp;2����������Ϊ��Ȼ�˵ģ�Ӧ�ṩ�����������֤����ԭ������<br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;3����������ȡ���ģ����ṩ��������ǩ��ġ���ȡ�����Ȩ�顷����ȡ��������֤����ԭ������ 
        </td>
      </tr>
    </table>
    <br>
    <br>
<script language='javascript'>
      function printPage()
      {
        tbButton.style.display = "none";
        window.print();
      }
    </script>    
      <%-- include��ӡ��ť --%>
      <!--<jsp:include page="/common/print/PrintButton.jsp" />     -->
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
