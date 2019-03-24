<%--
****************************************************************************
* DESC       �������������վ���֪ͨ���ӡҳ��
* AUTHOR     ��liubvo
* CREATEDATE ��2004-11-16
* MODIFYLIST ��   id       Date            Reason/Contents
*          ------------------------------------------------------
****************************************************************************/
--%>
<%@ page contentType="text/html; charset=GBK" %>
<%@page errorPage="UIErrorPage"%>

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
  String strClaimNo         = request.getParameter("ClaimNo"); //������
  String strPolicyNo        = "";   //������
  String strInsuredName     = "";   //��������
  String strInsureCarFlag   = "";   //�Ƿ�Ϊ����������
  String strLicenseNo       = "";   //���պ���
  DateTime strDamageStartDate = new DateTime();   //����ʱ��
  String strDamageAddress   = "";   //���յص�
  String strDealerCode      = "";    
  String strContext         = ""; 
  String strMessage         = "";
  PrpLclaimDto       prpLclaimDto       = null;   //ClaimDto����

  //���뷭�����
  String strCode    = "";
  String strName    = "";
  boolean isChinese = true; //���ı�־
  
  int intClaimCount      = 0;   //ClaimDto����ļ�¼��
  int intThirdPartyCount = 0;
  int index = 0;
  

  //�õ�ClaimDto����
  ClaimDto claimDto = (ClaimDto)request.getAttribute("claimDto");
  UICodeAction uiCodeAction = new UICodeAction();
  
  //�õ�prpLclaimDto����

  prpLclaimDto     = claimDto.getPrpLclaimDto();
  
  UIRegistAction uiRegistAction = new UIRegistAction();
  RegistDto registDto = uiRegistAction.findByPrimaryKey(prpLclaimDto.getRegistNo());
  PrpLregistDto prpLregistDto = registDto.getPrpLregistDto();
  
  if (prpLclaimDto!=null){
  strClaimNo = prpLclaimDto.getClaimNo();
  strDealerCode = prpLclaimDto.getDealerCode();
  if(strDealerCode==null || strDealerCode.trim().equals(""))
  {
//    throw new UserException(-98,-2013,"UILDAACancelnoticeNoneFormatPrint.jsp");
    //���Ǿ���İ���
%>

    <jsp:include page="/common/pub/UIErrorPage.jsp">
      <jsp:param name="Picture" value="F" />
      <jsp:param name="Content" value="���Ǿ��ⰸ��!" />
    </jsp:include>


<%  
return;
}  
  strPolicyNo = prpLclaimDto.getPolicyNo();
  
  strInsuredName = prpLclaimDto.getInsuredName();
  strDamageStartDate = prpLclaimDto.getDamageStartDate();
  String strDamageStartDateView = strDamageStartDate.getYear()
                      + " �� " + strDamageStartDate.getMonth()
                      + " �� " + strDamageStartDate.getDate()
                      + " �� ";  
  strDamageAddress   = prpLclaimDto.getDamageAddress();
  
  strCode = "";
  strName = "";
  strCode = prpLclaimDto.getMakeCom();
  //dbPrpDcompany.getInfo(strCode); 
  
  //�õ�blPrpLthirdParty����ļ�¼��
  if(registDto.getPrpLthirdPartyDtoList()!=null){
    intThirdPartyCount     = registDto.getPrpLthirdPartyDtoList().size();    
    for(index=0;index<intThirdPartyCount;index++)
    {
      PrpLthirdPartyDto prpLthirdPartyDto = (PrpLthirdPartyDto)registDto.getPrpLthirdPartyDtoList().get(index);
      strInsureCarFlag = prpLthirdPartyDto.getInsureCarFlag();
      if( strInsureCarFlag.equals("1") ) 
      {
        strLicenseNo = prpLthirdPartyDto.getLicenseNo();
      }
    } 
  }
  
  strContext = "<br><br>&nbsp;&nbsp;&nbsp;&nbsp;�ǳ��ź���֪ͨ���������йط����뱣�պ�ͬ�Ĺ涨���ҹ�˾���յ�<ins> " 
               + strPolicyNo + "</ins> <br><br>���³б���<ins> " + strLicenseNo + "</ins>����������<ins> " + strDamageStartDateView + "</ins>��<ins> "
               + strDamageAddress + "&nbsp;&nbsp;</ins><br><br>�������¹���ʧ�����ڱ��������⳥��Χ���Դ��ҹ�˾���ܸ����⸶��������⡣";
  	}  
%>

<html>                                                                                 
  <head>                                                                               
    <title>�����������վ���֪ͨ���ӡ</title>      
    <link rel="stylesheet" type="text/css" href="/claim/DAA/print/StandardPrint.css">        
  </head>                                                                              

  <body bgcolor="#FFFFFF">                                        
    <!-- ���ⲿ�� -->                                                                  
    <table width="92%" align="center" cellspacing="0" cellpadding="0" border="0">      
      <tr>
        <td align="center" height="40" align=top align=center style="font-family:����; font-size:14pt;">            
          <B>�����������վ���֪ͨ��<B>
        </td>
      </tr>
      <tr>
        <td align=left style="font-family:����; font-size:10pt;">
          <br>�������ˣ�<%=strInsuredName%>
        </td>
      </tr>
    </table>
      
    <!-- ���岿�� -->
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td colspan="2" align="left" valign="top" height="120"><%=strContext%></td>
      </tr>
      <tr>
        <td colspan="2" align="left" height="28"><br><br>&nbsp;&nbsp;&nbsp;&nbsp;��ӭ�����ҹ�˾�Ĺ�����������Ե������</td>
      </tr>
      <tr>
        <td colspan="2" align="left" height="28"><br><br>&nbsp;&nbsp;&nbsp;&nbsp;����</td>
      </tr>
      <tr>
        <td align="left" width="50%" height="28"><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;��������ǩ�գ�</td>
        <td align="left" width="50%" height="28"><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;�����ˣ�ǩ�£���<%=uiCodeAction.translateComCode(prpLclaimDto.getMakeCom(),isChinese)%></td>
      </tr>
      <tr>
        <td align="left" height="28">
          <br><br>&nbsp;&nbsp;&nbsp;&nbsp;���ڣ�
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��&nbsp;&nbsp;&nbsp;��
        </td>
        <td align="left" height="28">
          <br><br>&nbsp;&nbsp;&nbsp;&nbsp;���ڣ�
          &nbsp;&nbsp;<%=DateTime.current().getYear()%>��&nbsp;&nbsp;<%=DateTime.current().getMonth()%>��&nbsp;&nbsp;<%=DateTime.current().getDay()%>��
        </td>
      </tr>
      <tr>
        <td colspan="3" align="center"><hr noshade></td>
      </tr>
    </table>
     
    <!-- ��β���� -->      
    <table border="0" width="92%" align="center" cellspacing="0" cellpadding="0" style="border-collapse: collapse" bordercolor="#111111" style="font-family:����; font-size:10pt;">
      <tr>
        <td height="20"><br>&nbsp;&nbsp;&nbsp;&nbsp;���ⰸ�������ע��</td>
      </tr>
    </table>
       
      <%-- include��ӡ��ť --%>
      <jsp:include page="/common/print/PrintButton.jsp" />   
    
  </body>
</html>
